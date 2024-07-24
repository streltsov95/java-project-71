package hexlet.code.formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PlainFormatter {

    private static final String UPDATED_TEMPLATE = "Property '%s' was updated. From %s to %s\n";
    private static final String REMOVED_TEMPLATE = "Property '%s' was removed\n";
    private static final String ADDED_TEMPLATE = "Property '%s' was added with value: %s\n";

    private static String getValue(Object data) {
        if (data == null) {
            return "null";
        } else if (data instanceof Collection || data instanceof Map) {
            return "[complex value]";
        } else if (data instanceof String) {
            return "'" + data + "'";
        } else {
            return String.valueOf(data);
        }
    }

    public static String format(List<Map<String, Object>> compareResult) {

        StringBuilder sb = new StringBuilder();

        for (Map<String, Object> map : compareResult) {

            String status = String.valueOf(map.get("STATUS"));
            switch (status) {
                case "UPDATED" -> {
                    String updated = String.format(UPDATED_TEMPLATE,
                            map.get("FIELD"), getValue(map.get("OLD_VALUE")), getValue(map.get("NEW_VALUE")));
                    sb.append(updated);
                }
                case "REMOVED" -> {
                    String removed = String.format(REMOVED_TEMPLATE, map.get("FIELD"));
                    sb.append(removed);
                }
                case "ADDED" -> {
                    String added = String.format(ADDED_TEMPLATE, map.get("FIELD"), getValue(map.get("NEW_VALUE")));
                    sb.append(added);
                }
                default -> sb.append("");
            }
        }
        return sb.toString().trim();
    }
}

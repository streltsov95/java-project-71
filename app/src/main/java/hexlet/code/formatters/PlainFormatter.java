package hexlet.code.formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PlainFormatter {

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

            String templateUpdated = String.format("Property '%s' was updated. From %s to %s\n",
                    map.get("FIELD"), getValue(map.get("OLD_VALUE")), getValue(map.get("NEW_VALUE")));
            String templateRemoved = String.format("Property '%s' was removed\n", map.get("FIELD"));
            String templateAdded = String.format("Property '%s' was added with value: %s\n",
                    map.get("FIELD"), getValue(map.get("NEW_VALUE")));

            if (map.get("STATUS").equals("UPDATED")) {
                sb.append(templateUpdated);
            }
            if (map.get("STATUS").equals("REMOVED")) {
                sb.append(templateRemoved);
            }
            if (map.get("STATUS").equals("ADDED")) {
                sb.append(templateAdded);
            }
        }
        return sb.toString().trim();
    }
}

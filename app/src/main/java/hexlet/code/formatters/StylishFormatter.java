package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {

    private static final String SAME_TEMPLATE = "    %s: %s\n";
    private static final String REMOVED_TEMPLATE = "  - %s: %s\n";
    private static final String ADDED_TEMPLATE = "  + %s: %s\n";
    private static final String UPDATED_TEMPLATE = "  - %s: %s\n  + %s: %s\n";

    public static String format(List<Map<String, Object>> compareResult) {

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        for (Map<String, Object> map : compareResult) {

            String status = String.valueOf(map.get("STATUS"));
            switch (status) {
                case "SAME" -> {
                    String same = String.format(SAME_TEMPLATE, map.get("FIELD"), map.get("VALUE"));
                    sb.append(same);
                }
                case "REMOVED" -> {
                    String removed = String.format(REMOVED_TEMPLATE, map.get("FIELD"), map.get("OLD_VALUE"));
                    sb.append(removed);
                }
                case "ADDED" -> {
                    String added = String.format(ADDED_TEMPLATE, map.get("FIELD"), map.get("NEW_VALUE"));
                    sb.append(added);
                }
                case "UPDATED" -> {
                    String updated = String.format(UPDATED_TEMPLATE,
                            map.get("FIELD"), map.get("OLD_VALUE"), map.get("FIELD"), map.get("NEW_VALUE"));
                    sb.append(updated);
                }
                default -> sb.append("");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}

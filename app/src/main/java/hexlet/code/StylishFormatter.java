package hexlet.code;

import java.util.List;
import java.util.Map;

public class StylishFormatter {

    public static String format(List<Map<String, Object>> compareResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (Map<String, Object> map : compareResult) {
            if (map.get("STATUS").equals("SAME")) {
                sb.append("  ");
                sb.append(map.get("FIELD"));
                sb.append(": ");
                sb.append(map.get("VALUE"));
                sb.append("\n");
            } if (map.get("STATUS").equals("REMOVED")) {
                sb.append("  - ");
                sb.append(map.get("FIELD"));
                sb.append(": ");
                sb.append(map.get("OLD_VALUE"));
                sb.append("\n");
            } if (map.get("STATUS").equals("ADDED")) {
                sb.append("  + ");
                sb.append(map.get("FIELD"));
                sb.append(": ");
                sb.append(map.get("NEW_VALUE"));
                sb.append("\n");
            } if (map.get("STATUS").equals("UPDATED")) {
                sb.append("  - ");
                sb.append(map.get("FIELD"));
                sb.append(": ");
                sb.append(map.get("OLD_VALUE"));
                sb.append("\n");
                sb.append("  + ");
                sb.append(map.get("FIELD"));
                sb.append(": ");
                sb.append(map.get("NEW_VALUE"));
                sb.append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}

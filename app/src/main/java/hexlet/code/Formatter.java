package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> compareResult, String outFormat) throws Exception {
        return switch (outFormat) {
            case "stylish" -> StylishFormatter.format(compareResult);
            case "plain" -> PlainFormatter.format(compareResult);
            case "json" -> JsonFormatter.format(compareResult);
            default -> throw new RuntimeException("format is not supported");
        };
    }
}

package hexlet.code;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> compareResult, String outFormat) {
        return switch (outFormat) {
            case "stylish" -> StylishFormatter.format(compareResult);
            case "plain" -> PlainFormatter.format(compareResult);
//            case "json" -> JSONFormatter.format(compareResult);
            default -> throw new RuntimeException("format is not supported");
        };
    }
}

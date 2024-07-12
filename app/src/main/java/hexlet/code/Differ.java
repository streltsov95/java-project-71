package hexlet.code;

import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filePath1, String filePath2, String outFormat) throws Exception {

        String content1 = Reader.readFile(filePath1);
        String fileType1 = Reader.getFileType(filePath1);

        String content2 = Reader.readFile(filePath2);
        String fileType2 = Reader.getFileType(filePath2);

        Map<String, Object> file1 = Parser.parse(content1, fileType1);
        Map<String, Object> file2 = Parser.parse(content2, fileType2);

        List<Map<String, Object>> compareResult = Comparator.compare(file1, file2);

        return format(compareResult, outFormat);

    }

    private static String format(List<Map<String, Object>> compareResult, String outFormat) {
        return switch (outFormat) {
            case "stylish" -> StylishFormatter.format(compareResult);
//            case "plain" -> PlainFormatter.format(compareResult);
//            case "json" -> JSONFormatter.format(compareResult);
            default -> throw new RuntimeException("format is not supported");
        };
    }

}
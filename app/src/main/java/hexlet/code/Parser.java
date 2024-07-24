package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String format) throws Exception {
        switch (format) {
            case "json" -> {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(content, new TypeReference<>() { });
            }
            case "yaml", "yml" -> {
                ObjectMapper objectMapper = new YAMLMapper();
                return objectMapper.readValue(content, new TypeReference<>() { });
            }
            default -> throw new RuntimeException("input format is not supported");
        }
    }
}

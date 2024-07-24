package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static String readFile(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    public static String getFileType(String filePath) {
        String[] s = filePath.split("\\.");
        String fileType = s[s.length - 1];
        return fileType;
    }

}

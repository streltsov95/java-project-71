package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DifferTest {

    private static String expectedStylish;
    private static String expectedJson;
    private static String expectedPlain;

    private static Path getAbsolutePath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFile(String fileName) throws Exception {
        Path filePath = getAbsolutePath(fileName);
        return Files.readString(filePath);
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        expectedJson = readFile("expected_results/json.json");
        expectedPlain = readFile("expected_results/plain.txt");
        expectedStylish = readFile("expected_results/stylish.txt");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void testGenerateWithDefaultOutput(String inputFormat) throws Exception {
        String filePath1 = getAbsolutePath("input_files/file1." + inputFormat).toString();
        String filePath2 = getAbsolutePath("input_files/file2." + inputFormat).toString();

        String actualResult = Differ.generate(filePath1, filePath2);
        assertEquals(expectedStylish, actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void testGenerateWithStylishOutput(String inputFormat) throws Exception {
        String filePath1 = getAbsolutePath("input_files/file1." + inputFormat).toString();
        String filePath2 = getAbsolutePath("input_files/file2." + inputFormat).toString();

        String actualResult = Differ.generate(filePath1, filePath2, "stylish");
        assertEquals(expectedStylish, actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void testGenerateWithPlainOutput(String inputFormat) throws Exception {
        String filePath1 = getAbsolutePath("input_files/file1." + inputFormat).toString();
        String filePath2 = getAbsolutePath("input_files/file2." + inputFormat).toString();

        String actualResult = Differ.generate(filePath1, filePath2, "plain");
        assertEquals(expectedPlain, actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void testGenerateWithJsonOutput(String inputFormat) throws Exception {
        String filePath1 = getAbsolutePath("input_files/file1." + inputFormat).toString();
        String filePath2 = getAbsolutePath("input_files/file2." + inputFormat).toString();

        String actualResult = Differ.generate(filePath1, filePath2, "json");
        assertEquals(expectedJson, actualResult);
    }
}

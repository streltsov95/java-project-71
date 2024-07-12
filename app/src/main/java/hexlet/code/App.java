package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    @Parameters(index = "0", paramLabel = "filePath1", description = "Path to first file")
    private String filePath1;

    @Parameters(index = "1", paramLabel = "filePath2", description = "Path to second file")
    private String filePath2;

    @Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            defaultValue = "stylish",
            description = "Output format [default: stylish]"
    )
    private String format;

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filePath1, filePath2, format));
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}

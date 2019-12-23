package io.github.epam.html.tests.elements.common;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class JustTest {

    @Test
    public void justTest() throws InterruptedException {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", "java -version");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            List<String> results = readOutput(process.getInputStream());
            logger.info("!!! " + results);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readOutput(InputStream inputStream) throws IOException {
        try (BufferedReader output = new BufferedReader(new InputStreamReader(inputStream))) {
            return output.lines()
                    .collect(Collectors.toList());
        }
    }
}

package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static com.epam.jdi.light.settings.JDISettings.COMMON;
import static com.jdiai.tools.PathUtils.mergePath;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.fileInputsPage;
import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.pages.FileInputsPage.acceptFileInput;
import static io.github.com.pages.FileInputsPage.chipsFileInput;
import static io.github.com.pages.FileInputsPage.complexFileInput;
import static io.github.com.pages.FileInputsPage.counterFileInput;
import static io.github.com.pages.FileInputsPage.denseFileInput;
import static io.github.com.pages.FileInputsPage.multiplyFileInput;
import static io.github.com.pages.FileInputsPage.prependIconFileInput;
import static io.github.com.pages.FileInputsPage.selectionFileInput;
import static io.github.com.pages.FileInputsPage.showSizeFileInput;
import static io.github.com.pages.FileInputsPage.smallChipsFileInput;
import static io.github.com.pages.FileInputsPage.validationFileInput;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;

public class FileInputsTests extends TestsInit {

    private Path pathTXT;
    private Path pathPNG;

    @BeforeClass
    public void before() {
        fileInputsPage.open();
        waitCondition(() -> fileInputsPage.isOpened());
        fileInputsPage.checkOpened();
    }

    @BeforeClass
    public void createFiles() throws IOException {
        pathTXT = Paths.get(mergePath(COMMON.projectPath, "/src/test/resources/TextTestFile.txt"));
        pathPNG = Paths.get(mergePath(COMMON.projectPath, "/src/test/resources/ImageTestFile.png"));
        Files.deleteIfExists(pathTXT);
        Files.deleteIfExists(pathPNG);
        Files.write(pathTXT, "LOREM IPSUM".getBytes(), StandardOpenOption.CREATE);
        Files.write(pathPNG, "Lorem ipsum dolor sit amet, no nam oblique veritus.".getBytes(), StandardOpenOption.CREATE);
    }

    @Test
    public void acceptFileInput() {
        acceptFileInput.uploadFile(pathTXT.toString());
        acceptFileInput.has().file(pathTXT.getFileName().toString());
    }

    @Test
    public void chipsFileInputTest() {
        chipsFileInput.is().multiply();
        chipsFileInput.uploadFiles(asList(pathTXT.toString(), pathPNG.toString()));
        chipsFileInput.has().files(asList(pathTXT.getFileName().toString(), pathPNG.getFileName().toString()));
    }

    @Test
    public void smallChipsFileInputTest() {
        smallChipsFileInput.is().multiply();
        smallChipsFileInput.uploadFile(pathTXT.toString());
        smallChipsFileInput.has().file(pathTXT.getFileName().toString());
        smallChipsFileInput.uploadFile(pathPNG.toString());
        smallChipsFileInput.has().files(asList(pathTXT.getFileName().toString(), pathPNG.getFileName().toString()));
    }

    @Test(enabled = false)
    public void counterFileInputTest() {
        counterFileInput.is().multiply();
        counterFileInput.counter().has().text("0 files (0 B in total)");

        counterFileInput.uploadFile(pathTXT.toString());
        counterFileInput.has().file("TextTestFile.txt (11 B)");
        counterFileInput.counter().has().text("1 files (11 B in total)");

        counterFileInput.clear();

        counterFileInput.uploadFile(pathPNG.toString());
        counterFileInput.has().file("ImageTestFile.png (51 B)");
        counterFileInput.counter().has().text("1 files (51 B in total)");

        counterFileInput.clear();

        counterFileInput.uploadFiles(asList(pathTXT.toString(), pathPNG.toString()));
        counterFileInput.has().file("2 files");
        counterFileInput.counter().has().text("2 files (62 B in total)");
    }

    @Test
    public void denseFileInputTest() {
        denseFileInput.uploadFile(pathTXT.toString());
        denseFileInput.has().file(pathTXT.getFileName().toString());
    }

    @Test
    public void multiplyFileInputTest() {
        multiplyFileInput.uploadFile(pathTXT.toString());
        multiplyFileInput.has().file(pathTXT.getFileName().toString());
        for (int i = 2; i <= 10; i++) {
            multiplyFileInput.uploadFile(pathTXT.toString());
            multiplyFileInput.has().file(i + " files");
        }
    }

    @Test(enabled = false)
    public void prependIconFileInputTest() {
        prependIconFileInput.getPrependOuterIcon().has().type("mdi-camera");
        prependIconFileInput.has().hasLabel();
        prependIconFileInput.label().has().text("File input");
    }

    @Test
    public void showSizeFileInputTest() {
        showSizeFileInput.uploadFile(pathTXT.toString());
        showSizeFileInput.has().file("TextTestFile.txt (11 B)");
    }

    @Test
    public void validationFileInputTest() {
        validationFileInput.is().accept(containsString("image/png, image/jpeg, image/bmp"));
    }

    @Test
    public void selectionFileInputTest() {
        selectionFileInput.uploadFile(pathTXT.toString());
        selectionFileInput.uploadFile(pathPNG.toString());
        selectionFileInput.uploadFile(pathTXT.toString());
        selectionFileInput.has().files(asList(
                pathTXT.getFileName().toString(),
                pathPNG.getFileName().toString(),
                pathTXT.getFileName().toString())
        );
        selectionFileInput.files().foreach(chip ->
                chip.has().css("background-color", BLUE_DARKEN_2.toString())
        );
    }

    @Test
    public void complexFileInputTest() {
        complexFileInput.uploadFile(pathTXT.toString());
        complexFileInput.uploadFile(pathPNG.toString());
        complexFileInput.uploadFile(pathTXT.toString());
        complexFileInput.has().files(asList(
                "TextTestFile.txt (11 B)",
                "ImageTestFile.png (51 B)",
                "+1 FILE(S)")
        );
        complexFileInput.counter().has().text("3 files (73 B in total)");
    }

    @AfterClass
    public void deleteFiles() throws IOException {
        Files.deleteIfExists(pathTXT);
        Files.deleteIfExists(pathPNG);
    }
}

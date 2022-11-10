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
import java.util.Collections;

import static com.epam.jdi.light.settings.JDISettings.COMMON;
import static com.jdiai.tools.PathUtils.mergePath;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.fileInputsPage;
import static io.github.com.enums.Colors.BLACK;
import static io.github.com.enums.Colors.BLUE;
import static io.github.com.pages.FileInputsPage.appendIconWithSuffixFileInput;
import static io.github.com.pages.FileInputsPage.appendOuterIconWithPrefixFileInput;
import static io.github.com.pages.FileInputsPage.backgroundColorFileInput;
import static io.github.com.pages.FileInputsPage.chipsFileInput;
import static io.github.com.pages.FileInputsPage.counterFileInput;
import static io.github.com.pages.FileInputsPage.denseFileInput;
import static io.github.com.pages.FileInputsPage.disabledFileInput;
import static io.github.com.pages.FileInputsPage.errorFileInput;
import static io.github.com.pages.FileInputsPage.fullWidthFileInput;
import static io.github.com.pages.FileInputsPage.loadingFileInput;
import static io.github.com.pages.FileInputsPage.multipleFileInput;
import static io.github.com.pages.FileInputsPage.prependIconFileInput;
import static io.github.com.pages.FileInputsPage.prependInnerIconFileInput;
import static io.github.com.pages.FileInputsPage.selectionFileInput;
import static io.github.com.pages.FileInputsPage.showSizeFileInput;
import static io.github.com.pages.FileInputsPage.smallChipsFileInput;
import static io.github.com.pages.FileInputsPage.soloFileInput;
import static io.github.com.pages.FileInputsPage.successFileInput;
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

    @AfterClass
    public void deleteFiles() throws IOException {
        Files.deleteIfExists(pathTXT);
        Files.deleteIfExists(pathPNG);
    }

    @Test
    public void uploadMultipleFilesFileInputTest() {
        chipsFileInput.show();
        chipsFileInput.is().multiple();
        chipsFileInput.uploadFiles(asList(pathTXT.toString(), pathPNG.toString()));
        chipsFileInput.has().files(asList(pathTXT.getFileName().toString(), pathPNG.getFileName().toString()));
        smallChipsFileInput.show();
        smallChipsFileInput.is().multiple();
        smallChipsFileInput.uploadFile(pathTXT.toString());
        smallChipsFileInput.has().file(pathTXT.getFileName().toString());
        smallChipsFileInput.uploadFile(pathPNG.toString());
        smallChipsFileInput.has().files(asList(pathTXT.getFileName().toString(), pathPNG.getFileName().toString()));
    }

    @Test(enabled = false)
    public void counterFileInputTest() {
        counterFileInput.show();
        counterFileInput.counter().has().text("0 files (0 B in total)");
        counterFileInput.uploadFile(pathTXT.toString());
        counterFileInput.has().file("TextTestFile.txt (11 B)");
        counterFileInput.counter().has().text("1 files (11 B in total)");
        counterFileInput.clear();
        counterFileInput.uploadFiles(asList(pathTXT.toString(), pathPNG.toString()));
        counterFileInput.has().file("2 files");
        counterFileInput.counter().has().text("2 files (62 B in total)");
    }

    @Test
    public void denseFileInputTest() {
        denseFileInput.show();
        denseFileInput.is().dense();
    }

    @Test
    public void iconFileInputTest() {
        prependIconFileInput.show();
        prependIconFileInput.getPrependOuterIcon().has().type("mdi-camera");
    }

    @Test
    public void labelFileInputTest() {
        prependIconFileInput.show();
        prependIconFileInput.has().hasLabel();
        prependIconFileInput.label().has().text("Prepend-icon rounded file input");
    }

    @Test
    public void suffixPrefixFileInputTest() {
        appendIconWithSuffixFileInput.show();
        appendIconWithSuffixFileInput.has().suffixText("Suffix");
        appendOuterIconWithPrefixFileInput.has().prefixText("Prefix");
    }

    @Test
    public void showSizeFileInputTest() {
        showSizeFileInput.show();
        showSizeFileInput.uploadFile(pathTXT.toString());
        showSizeFileInput.has().file("TextTestFile.txt (11 B)");
    }

    @Test
    public void validationFileInputTest() {
        validationFileInput.show();
        validationFileInput.is().accept(containsString("image/png, image/jpeg, image/bmp"));
    }

    @Test
    public void selectionFileInputTest() {
        selectionFileInput.show();
        selectionFileInput.uploadFile(pathTXT.toString());
        selectionFileInput.uploadFile(pathPNG.toString());
        selectionFileInput.uploadFile(pathTXT.toString());
        selectionFileInput.has().files(asList(
                pathTXT.getFileName().toString(),
                pathPNG.getFileName().toString(),
                pathTXT.getFileName().toString())
        );
    }

    @Test
    public void colorFileInputTest() {
        backgroundColorFileInput.show();
        backgroundColorFileInput.has().backgroundColor(BLUE.value());
        backgroundColorFileInput.has().color(BLACK.value());
        backgroundColorFileInput.has().labelColor(BLACK.value());
    }

    @Test
    public void autofocusFileInputTest() {
        backgroundColorFileInput.show();
        backgroundColorFileInput.has().autofocus();
    }

    @Test
    public void themeFileInputTest() {
        counterFileInput.show();
        counterFileInput.has().darkTheme();
        denseFileInput.show();
        denseFileInput.has().lightTheme();
    }

    @Test
    public void clearIconFileInputTest() {
        backgroundColorFileInput.show();
        backgroundColorFileInput.uploadFile(pathTXT.toString());
        backgroundColorFileInput.is().clearable();
        backgroundColorFileInput.clearButton().click();
    }

    @Test
    public void messagesFileInputTest() {
        backgroundColorFileInput.show();
        backgroundColorFileInput.has().messagesCount(1);
        backgroundColorFileInput.has().messageText("Message");
        backgroundColorFileInput.has().noErrorMessages();
        backgroundColorFileInput.has().noSuccessMessages();
        errorFileInput.show();
        errorFileInput.has().errorMessages();
        errorFileInput.has().errorMessagesCount(1);
        errorFileInput.has().errorMessages(Collections.singletonList("Error Message"));
        errorFileInput.has().errorMessage("Error Message");
        successFileInput.has().successMessages();
        successFileInput.has().successMessagesCount(1);
        successFileInput.has().successMessages(Collections.singletonList("Success Message"));
        successFileInput.has().successMessage("Success Message");
    }

    @Test
    public void filledFileInputTest() {
        prependIconFileInput.show();
        prependIconFileInput.is().filled();
        showSizeFileInput.show();
        showSizeFileInput.is().notFilled();
    }

    @Test
    public void flatFileInputTest() {
        counterFileInput.show();
        counterFileInput.is().flat();
        denseFileInput.show();
        denseFileInput.is().notFlat();
    }

    @Test
    public void fullWidthFileInputTest() {
        fullWidthFileInput.show();
        fullWidthFileInput.is().fullWidth();
        soloFileInput.show();
        soloFileInput.is().notFullWidth();
    }

    @Test
    public void hideDetailsFileInputTest() {
        fullWidthFileInput.show();
        fullWidthFileInput.has().detailsHidden();
        soloFileInput.show();
        soloFileInput.has().notDetailsHidden();
    }

    @Test
    public void heightFileInputTest() {
        fullWidthFileInput.show();
        fullWidthFileInput.has().height(57);
        fullWidthFileInput.has().heightGreaterThan(50);
        fullWidthFileInput.has().heightLessThan(60);
    }

    @Test
    public void reversedFileInputTest() {
        loadingFileInput.show();
        loadingFileInput.is().reversed();
        denseFileInput.show();
        denseFileInput.is().notReversed();
    }

    @Test
    public void loadingFileInputTest() {
        loadingFileInput.show();
        loadingFileInput.is().loading();
        loadingFileInput.has().loaderHeightPx(3);
    }

    @Test
    public void outlinedFileInputTest() {
        denseFileInput.show();
        denseFileInput.is().outlined();
        multipleFileInput.is().notOutlined();
    }

    @Test
    public void placeholderFileInputTest() {
        selectionFileInput.show();
        selectionFileInput.has().placeholder("Upload your documents");
    }

    @Test
    public void roundedFileInputTest() {
        prependIconFileInput.show();
        prependIconFileInput.is().rounded();
        prependInnerIconFileInput.is().notRounded();
    }

    @Test
    public void shapedFileInputTest() {
        backgroundColorFileInput.show();
        backgroundColorFileInput.is().shaped();
        loadingFileInput.show();
        loadingFileInput.is().notShaped();
    }

    @Test
    public void soloFileInputTest() {
        soloFileInput.show();
        soloFileInput.is().solo();
        soloFileInput.is().soloInverted();
        fullWidthFileInput.show();
        fullWidthFileInput.is().notSolo();
        fullWidthFileInput.is().notSoloInverted();
    }

    @Test
    public void truncatedNameFileInputTest() {
        soloFileInput.show();
        soloFileInput.uploadFile(pathPNG.toString());
        soloFileInput.has().truncatedFileName();
    }

    @Test
    public void disabledFileInputTest() {
        disabledFileInput.show();
        disabledFileInput.is().disabled();
        soloFileInput.show();
        soloFileInput.is().enabled();
    }

    @Test
    public void singleLineFileInputTest() {
        prependInnerIconFileInput.show();
        prependInnerIconFileInput.is().singleLine();
    }
}


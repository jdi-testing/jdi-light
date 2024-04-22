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
        // @todo #5363 fix paths to do not use src, they are available in resources
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

    @Test(description = "Test checks that multiple files can be uploaded one by one and at once")
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

    @Test(description = "Test checks that counter shows correct number of uploaded files")
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

    @Test(description = "Test checks that file input is dense or not")
    public void denseFileInputTest() {
        denseFileInput.show();
        denseFileInput.is().dense();
        multipleFileInput.is().notDense();
    }

    @Test(description = "Test checks that file input has icon")
    public void iconFileInputTest() {
        prependIconFileInput.show();
        prependIconFileInput.getPrependOuterIcon().has().type("mdi-camera");
    }

    @Test(description = "Test checks that file input has label with expected text")
    public void labelFileInputTest() {
        prependIconFileInput.show();
        prependIconFileInput.has().hasLabel();
        prependIconFileInput.label().has().text("Prepend-icon rounded file input");
    }

    @Test(description = "Test checks that file input has suffix and prefix with expected text")
    public void suffixPrefixFileInputTest() {
        appendIconWithSuffixFileInput.show();
        appendIconWithSuffixFileInput.has().suffixText("Suffix");
        appendOuterIconWithPrefixFileInput.has().prefixText("Prefix");
    }

    @Test(description = "Test checks that file size is shown in file input")
    public void showSizeFileInputTest() {
        showSizeFileInput.show();
        showSizeFileInput.uploadFile(pathTXT.toString());
        showSizeFileInput.has().file("TextTestFile.txt (11 B)");
    }

    @Test(description = "Test checks that file input accept only specific file formats")
    public void validationFileInputTest() {
        validationFileInput.show();
        validationFileInput.is().accept(containsString("image/png, image/jpeg, image/bmp"));
    }

    @Test(description = "Test checks that multiple files can be uploaded into selection file input")
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

    @Test(description = "Test checks various colors in color file input")
    public void colorFileInputTest() {
        backgroundColorFileInput.show();
        backgroundColorFileInput.has().backgroundColor(BLUE.value());
        backgroundColorFileInput.has().color(BLACK.value());
        backgroundColorFileInput.has().labelColor(BLACK.value());
    }

    @Test(description = "Test checks that file input has autofocus enabled")
    public void autofocusFileInputTest() {
        backgroundColorFileInput.show();
        backgroundColorFileInput.has().autofocus();
    }

    @Test(description = "Test checks light and dark themes of file inputs")
    public void themeFileInputTest() {
        counterFileInput.show();
        counterFileInput.has().darkTheme();
        denseFileInput.show();
        denseFileInput.has().lightTheme();
    }

    @Test(description = "Test checks that file input can be cleared by clear button")
    public void clearIconFileInputTest() {
        backgroundColorFileInput.show();
        backgroundColorFileInput.uploadFile(pathTXT.toString());
        backgroundColorFileInput.is().clearable();
        backgroundColorFileInput.clearButton().click();
    }

    @Test(description = "Test checks different simple/error/success messages of file inputs")
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

    @Test(description = "Test checks that file input field is 'filled' or not")
    public void filledFileInputTest() {
        prependIconFileInput.show();
        prependIconFileInput.is().filled();
        showSizeFileInput.show();
        showSizeFileInput.is().notFilled();
    }

    @Test(description = "Test checks that file input field is 'flat' or not")
    public void flatFileInputTest() {
        counterFileInput.show();
        counterFileInput.is().flat();
        denseFileInput.show();
        denseFileInput.is().notFlat();
    }

    @Test(description = "Test checks that file input field has full width or not")
    public void fullWidthFileInputTest() {
        fullWidthFileInput.show();
        fullWidthFileInput.is().fullWidth();
        soloFileInput.show();
        soloFileInput.is().notFullWidth();
    }

    @Test(description = "Test checks that file input details are hidden or not")
    public void hideDetailsFileInputTest() {
        fullWidthFileInput.show();
        fullWidthFileInput.has().detailsHidden();
        soloFileInput.show();
        soloFileInput.has().notDetailsHidden();
    }

    @Test(description = "Test checks that file input field has specific height")
    public void heightFileInputTest() {
        fullWidthFileInput.show();
        fullWidthFileInput.has().height(57);
        fullWidthFileInput.has().heightGreaterThan(50);
        fullWidthFileInput.has().heightLessThan(60);
    }

    @Test(description = "Test checks that file input field is reversed")
    public void reversedFileInputTest() {
        loadingFileInput.show();
        loadingFileInput.is().reversed();
        denseFileInput.show();
        denseFileInput.is().notReversed();
    }

    @Test(description = "Test checks loading state of file input and its height")
    public void loadingFileInputTest() {
        loadingFileInput.show();
        loadingFileInput.is().loading();
        loadingFileInput.has().loaderHeightPx(3);
    }

    @Test(description = "Test checks that file input is outlined")
    public void outlinedFileInputTest() {
        denseFileInput.show();
        denseFileInput.is().outlined();
        multipleFileInput.is().notOutlined();
    }

    @Test(description = "Test checks that file input has expected placeholder")
    public void placeholderFileInputTest() {
        selectionFileInput.show();
        selectionFileInput.has().placeholder("Upload your documents");
    }

    @Test(description = "Test checks that file input is rounded or not")
    public void roundedFileInputTest() {
        prependIconFileInput.show();
        prependIconFileInput.is().rounded();
        prependInnerIconFileInput.is().notRounded();
    }

    @Test(description = "Test checks that file input is shaped or not")
    public void shapedFileInputTest() {
        backgroundColorFileInput.show();
        backgroundColorFileInput.is().shaped();
        loadingFileInput.show();
        loadingFileInput.is().notShaped();
    }

    @Test(description = "Test checks that file input is of solo type")
    public void soloFileInputTest() {
        soloFileInput.show();
        soloFileInput.is().solo();
        soloFileInput.is().soloInverted();
        fullWidthFileInput.show();
        fullWidthFileInput.is().notSolo();
        fullWidthFileInput.is().notSoloInverted();
    }

    @Test(description = "Test checks that file input truncates uploaded file name correctly")
    public void truncatedNameFileInputTest() {
        soloFileInput.show();
        soloFileInput.uploadFile(pathPNG.toString());
        soloFileInput.has().truncatedFileName();
    }

    @Test(description = "Test checks that file input is disabled or not")
    public void disabledFileInputTest() {
        disabledFileInput.show();
        disabledFileInput.is().disabled();
        soloFileInput.show();
        soloFileInput.is().enabled();
    }

    @Test(description = "Test checks that file input is single lined or not")
    public void singleLineFileInputTest() {
        prependInnerIconFileInput.show();
        prependInnerIconFileInput.is().singleLine();
        prependIconFileInput.is().notSingleLine();
    }
}


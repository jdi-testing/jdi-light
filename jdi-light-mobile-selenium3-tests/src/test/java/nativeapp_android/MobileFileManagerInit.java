package nativeapp_android;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.mobile.elements.common.AppManager;
import nativeapp.android.AndroidFileManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static nativeapp.android.AndroidFileManager.*;

public class MobileFileManagerInit {

    protected byte[] createdFileByte;
    protected File createdFile;
    protected File pulledFile;
    public static final String FILE_NAME_TEST = "TEST.txt";
    protected static final String PATH_TO_ANDROID_FOLDER = "/sdcard/download";
    protected static final String PATH_TO_FILE_ANDROID = PATH_TO_ANDROID_FOLDER + FILE_NAME_TEST;
    protected static final String FILE_PULL_PATH_LOCAL = "src/main/resources/";
    protected static final String PATH_TO_FILE_LOCAL = FILE_PULL_PATH_LOCAL + FILE_NAME_TEST;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        initMobile(AndroidFileManager.class);
        logger.toLog("Run MobileFileManager Tests");
    }

    @BeforeMethod(alwaysRun = true)
    public void createFile() {
        AppManager.launchApp();
        createdFile = new File(PATH_TO_FILE_LOCAL);
        try {
            createdFile.createNewFile();
            PrintStream writer = new PrintStream(createdFile);
            writer.print(RandomStringUtils.random(50, true, true));
            createdFileByte = Files.readAllBytes(createdFile.toPath());
            writer.close();
        } catch (IOException e) {
            logger.toLog("New file for testing File Manager not created" + e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void resetApp() {
        AppManager.resetApp();
        deleteFileOnAndroid();
        deleteFileIfExist(createdFile);
        deleteFileIfExist(pulledFile);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quit();
    }

    private void deleteFileOnAndroid() {
        roots.click();
        downloads.click();
        fileOnAndroid.rightClick();
        deleteButton.click();
        okButton.click();
    }

    private void deleteFileIfExist(File file) {
        if (file != null && !file.delete()) {
            logger.error("Can't delete file %s", file.getAbsolutePath());
        }
    }
}

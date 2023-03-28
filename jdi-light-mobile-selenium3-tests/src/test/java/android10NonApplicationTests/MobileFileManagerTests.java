package android10NonApplicationTests;

import nativeapp_android.MobileFileManagerInit;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Enumeration;

import static com.epam.jdi.light.mobile.elements.common.MobileFileManager.*;
import static nativeapp.android.AndroidFileManager.*;

@Ignore("Should be checked")
public class MobileFileManagerTests extends MobileFileManagerInit {

    @Test
    public void pushFileTest() throws IOException {
        pushFile(PATH_TO_FILE_ANDROID, createdFile);
        roots.click();
        downloads.click();
        Assert.assertTrue(fileOnAndroid.isDisplayed());
    }

    @Test
    public void pushByteFileTest() {
        pushFile(PATH_TO_FILE_ANDROID, createdFileByte);
        roots.click();
        downloads.click();
        Assert.assertTrue(fileOnAndroid.isDisplayed());
    }

    @Test
    public void pullFileTest() throws IOException {
        pushFile(PATH_TO_FILE_ANDROID, createdFile);
        byte[] contentFileAndroid = pullFile(PATH_TO_FILE_ANDROID);
        pulledFile = new File(FILE_PULL_PATH_LOCAL + "PULLED_FILE.txt");
        Files.write(pulledFile.toPath(), contentFileAndroid);
        Assert.assertTrue(Arrays.equals(createdFileByte, Files.readAllBytes(pulledFile.toPath())));
    }

    @Test
    public void pullFolderTest() throws IOException {
        pushFile(PATH_TO_FILE_ANDROID, createdFile);
        byte[] folder = pullFolder(PATH_TO_ANDROID_FOLDER);
        pulledFile = new File(FILE_PULL_PATH_LOCAL + "DOWNLOAD.zip");
        FileUtils.writeByteArrayToFile(pulledFile, folder);

        ZipFile zipFile = new ZipFile(pulledFile);
        Enumeration<ZipArchiveEntry> entries = zipFile.getEntries();
        boolean findFile = false;
        while (entries.hasMoreElements()) {
            ZipArchiveEntry entry = entries.nextElement();
            String fileName = entry.getName();
            if (createdFile.getName().equals(fileName)) {
                findFile = true;
                break;
            }
        }
        zipFile.close();
        Assert.assertTrue(findFile);
    }

}

package com.epam.jdi.light.asserts;

import org.hamcrest.Matcher;

import java.io.File;
import java.io.IOException;

import static com.epam.jdi.light.asserts.BaseSelectorAssert.waitAssert;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.get.DriverData.DOWNLOADS_DIR;
import static com.epam.jdi.light.elements.base.JDIBase.timer;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.io.FileUtils.readFileToString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FileAssert {
    public static FileAssert assertThatFile(String fileName) {
        return new FileAssert(fileName);
    }
    private File file;

    public FileAssert(String fileName) {
        file = new File(mergePath(DOWNLOADS_DIR, fileName));
    }
    public FileAssert isDownloaded() {
        waitAssert(() -> assertThat(timer().wait(() -> file.exists()), is(true)), file.getName());
        return this;
    }
    public FileAssert text(Matcher<String> text) {
        boolean result = timer().wait(() -> {
            assertThat(readFileToString(file, "UTF-8"), text); return true; }
        );
        if (result) return this;
        String fileText;
        try {
            fileText = readFileToString(file, "UTF-8");
        } catch (IOException ex) {
            throw exception("Can't read File: " + ex.getMessage());
        }
        waitAssert(() -> assertThat(fileText, text), file.getName());
        return this;
    }

    public FileAssert hasSize(Matcher<Long> size) {
        timer().wait(() -> {
            assertThat(file.length(), size);
            return true;
        });
        return this;
    }

    public static void cleanupDownloads() {
        File dir = new File(DOWNLOADS_DIR);
        for(File file : requireNonNull(dir.listFiles()))
            file.delete();
        logger.info("Remove all downloads successfully");
    }
}

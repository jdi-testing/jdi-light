package com.epam.jdi.mobile.asserts.core;

import com.epam.jdi.mobile.asserts.generic.BaseAssert;
import com.epam.jdi.mobile.common.JDIAction;
import org.hamcrest.Matcher;

import java.io.File;

import static com.epam.jdi.mobile.driver.get.DriverData.DOWNLOADS_DIR;
import static com.epam.jdi.mobile.settings.WebSettings.logger;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.io.FileUtils.readFileToString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class FileAssert extends BaseAssert {
    public static FileAssert assertThatFile(String fileName) {
        return new FileAssert(fileName);
    }
    private File file;

    public FileAssert(String fileName) {
        super(fileName);
        file = new File(mergePath(DOWNLOADS_DIR, fileName));
    }
    /**
     * Check that file is downloaded
     * @return FileAssert
     */
    @JDIAction("Assert that file '{name}' is downloaded")
    public FileAssert isDownloaded() {
        assertThat(file.exists(), is(true));
        return this;
    }

    /**
     * Match passed value with file text
     * @param text to compare
     * @return FileAssert
     */
    @JDIAction("Assert that file '{name}' text {0}")
    public FileAssert text(Matcher<String> text) {
        try {
            assertThat(readFileToString(file, "UTF-8"), text);
            return this;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public FileAssert text(String text) { return text(is(text)); }

    /**
     * Match passed value with file size
     * @param size to compare
     * @return FileAssert
     */
    @JDIAction("Assert file '{name}' size")
    public FileAssert hasSize(Matcher<Long> size) {
        assertThat(file.length(), size);
        return this;
    }
    public FileAssert hasSize(Long size) {
        return hasSize(is(size));
    }
    public static void cleanupDownloads() {
        File dir = new File(DOWNLOADS_DIR);
        for(File file : requireNonNull(dir.listFiles()))
            file.delete();
        logger.info("Remove all downloads successfully");
    }
}

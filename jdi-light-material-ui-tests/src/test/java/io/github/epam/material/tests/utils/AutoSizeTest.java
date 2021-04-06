package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static org.hamcrest.Matchers.*;

public class AutoSizeTest extends TestsInit {

    private int initialHeight;
    private static final String FOUR_LINES = "1\n2\n3\n4";

    @Test
    public void defaultAreaHeightIncreasesTest() {
        textAreaAutoSizeDefaultPage.open();
        initialHeight = textAreaAutoSizeFrame.textAreaAutoSize.getSize().height;
        textAreaAutoSizeFrame.textAreaAutoSize.setValue(FOUR_LINES);
        textAreaAutoSizeFrame.textAreaAutoSize.has().height(greaterThan(initialHeight));
    }

    @Test
    public void defaultAreaHeightDecreasesTest() {
        textAreaAutoSizeDefaultPage.open();
        textAreaAutoSizeFrame.textAreaAutoSize.setValue(FOUR_LINES);
        initialHeight = textAreaAutoSizeFrame.textAreaAutoSize.getSize().height;
        textAreaAutoSizeFrame.textAreaAutoSize.clear();
        textAreaAutoSizeFrame.textAreaAutoSize.setValue("1\n");
        textAreaAutoSizeFrame.textAreaAutoSize.has().height(lessThan(initialHeight));
    }

    @DataProvider(name = "zeroToThree")
    public Object[][] zeroToThree() {
        return new Object[][]{
                {""},
                {"1\n"},
                {"1\n2\n3"}
        };
    }

    @Test(dataProvider = "zeroToThree")
    public void minAreaDoesNotIncreaseBefore4thLineTest(String line) {
        textAreaAutoSizeMinHeightPage.open();
        initialHeight = textAreaAutoSizeFrame.textAreaAutoSize.getSize().height;
        textAreaAutoSizeFrame.textAreaAutoSize.setValue(line);
        textAreaAutoSizeFrame.textAreaAutoSize.has().height(anyOf(equalTo(initialHeight), equalTo(initialHeight + 1)));
    }

    @Test
    public void minAreaIncreasesAfter3dLineTest() {
        textAreaAutoSizeMinHeightPage.open();
        initialHeight = textAreaAutoSizeFrame.textAreaAutoSize.getSize().height;
        textAreaAutoSizeFrame.textAreaAutoSize.setValue(FOUR_LINES);
        textAreaAutoSizeFrame.textAreaAutoSize.has().height(greaterThan(initialHeight));
    }

    @Test
    public void maxAreaDoesNotIncreaseAfter4LinesTest() {
        textAreaAutoSizeMaxHeightPage.open();
        initialHeight = textAreaAutoSizeFrame.textAreaAutoSize.getSize().height;
        textAreaAutoSizeFrame.textAreaAutoSize.setValue(FOUR_LINES);
        textAreaAutoSizeFrame.textAreaAutoSize.has().height(equalTo(initialHeight));
    }

    @Test
    public void maxAreaHeightDecreasesWhenClearLinesTest() {
        textAreaAutoSizeMaxHeightPage.open();
        initialHeight = textAreaAutoSizeFrame.textAreaAutoSize.getSize().height;
        textAreaAutoSizeFrame.textAreaAutoSize.setValue("");
        textAreaAutoSizeFrame.textAreaAutoSize.has().height(lessThan(initialHeight));
    }

    @Test
    public void maxAreaIncreasesTill4LinesTest() {
        textAreaAutoSizeMaxHeightPage.open();
        textAreaAutoSizeFrame.textAreaAutoSize.setValue("");
        initialHeight = textAreaAutoSizeFrame.textAreaAutoSize.getSize().height;
        textAreaAutoSizeFrame.textAreaAutoSize.setValue("1\n2\n3");
        textAreaAutoSizeFrame.textAreaAutoSize.has().height(greaterThan(initialHeight));
    }

    @Test
    public void maxAreaDoesNotChangeAfter4LinesTest() {
        textAreaAutoSizeMaxHeightPage.open();
        textAreaAutoSizeFrame.textAreaAutoSize.setValue("1\n2\n3\n4");
        initialHeight = textAreaAutoSizeFrame.textAreaAutoSize.getSize().height;
        textAreaAutoSizeFrame.textAreaAutoSize.setValue("1\n2\n3\n4\n5");
        textAreaAutoSizeFrame.textAreaAutoSize.has().height(equalTo(initialHeight));
    }
}

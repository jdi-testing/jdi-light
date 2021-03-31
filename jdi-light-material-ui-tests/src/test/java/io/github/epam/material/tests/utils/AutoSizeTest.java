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
        initialHeight = textFieldFrame.textAreaAutoSize.getSize().height;
        textFieldFrame.textAreaAutoSize.setValue(FOUR_LINES);
        textFieldFrame.textAreaAutoSize.has().height(greaterThan(initialHeight));
    }

    @Test
    public void defaultAreaHeightDecreasesTest() {
        textAreaAutoSizeDefaultPage.open();
        textFieldFrame.textAreaAutoSize.addNewLine(FOUR_LINES);
        initialHeight = textFieldFrame.textAreaAutoSize.getSize().height;
        textFieldFrame.textAreaAutoSize.clear();
        textFieldFrame.textAreaAutoSize.addNewLine("1\n");
        textFieldFrame.textAreaAutoSize.has().height(lessThan(initialHeight));
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
        initialHeight = textFieldFrame.textAreaAutoSize.getSize().height;
        textFieldFrame.textAreaAutoSize.setValue(line);
        textFieldFrame.textAreaAutoSize.has().height(anyOf(equalTo(initialHeight), equalTo(initialHeight + 1)));
    }

    @Test
    public void minAreaIncreasesAfter3dLineTest() {
        textAreaAutoSizeMinHeightPage.open();
        initialHeight = textFieldFrame.textAreaAutoSize.getSize().height;
        textFieldFrame.textAreaAutoSize.setValue(FOUR_LINES);
        textFieldFrame.textAreaAutoSize.has().height(greaterThan(initialHeight));
    }

    @Test
    public void maxAreaDoesNotIncreaseAfter4LinesTest() {
        textAreaAutoSizeMaxHeightPage.open();
        initialHeight = textFieldFrame.textAreaAutoSize.getSize().height;
        textFieldFrame.textAreaAutoSize.setValue(FOUR_LINES);
        textFieldFrame.textAreaAutoSize.has().height(equalTo(initialHeight));
    }

    @Test
    public void maxAreaHeightDecreasesWhenClearLinesTest() {
        textAreaAutoSizeMaxHeightPage.open();
        initialHeight = textFieldFrame.textAreaAutoSize.getSize().height;
        textFieldFrame.textAreaAutoSize.setValue("");
        textFieldFrame.textAreaAutoSize.has().height(lessThan(initialHeight));
    }

    @Test
    public void maxAreaIncreasesTill4LinesTest() {
        textAreaAutoSizeMaxHeightPage.open();
        textFieldFrame.textAreaAutoSize.setValue("");
        initialHeight = textFieldFrame.textAreaAutoSize.getSize().height;
        textFieldFrame.textAreaAutoSize.addNewLine("1\n2\n3");
        textFieldFrame.textAreaAutoSize.has().height(greaterThan(initialHeight));
    }
}

package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.textAreaAutoSizePage;
import static io.github.com.pages.utils.TextAreaAutoSizePage.emptyTextArea;
import static io.github.com.pages.utils.TextAreaAutoSizePage.maxArea;
import static io.github.com.pages.utils.TextAreaAutoSizePage.minArea;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;

public class TextAreaAutoSizeTests extends TestsInit {

    private int initialHeight;

    private static final String ONE_LINE = "1";
    private static final String THREE_LINES = "1\n2\n3";
    private static final String FOUR_LINES = "1\n2\n3\n4";

    @BeforeMethod
    public void beforeTest() {
        textAreaAutoSizePage.open();
        textAreaAutoSizePage.isOpened();
    }

    @Test
    public void emptyAreaHeightIncreasesTest() {
        initialHeight = emptyTextArea.getSize().height;
        emptyTextArea.setLines(FOUR_LINES);
        assertThat(emptyTextArea.getSize().height, greaterThanOrEqualTo(initialHeight));
    }

    @Test
    public void emptyAreaHeightDecreasesTest() {
        emptyTextArea.setLines(FOUR_LINES);
        initialHeight = emptyTextArea.getSize().height;
        emptyTextArea.clear();
        emptyTextArea.setLines(ONE_LINE);
        assertThat(emptyTextArea.getSize().height, lessThan(initialHeight));
    }

    @DataProvider(name = "zeroToThree")
    public Object[][] zeroToThree() {
        return new Object[][]{
                {""},
                {ONE_LINE},
                {THREE_LINES}
        };
    }

    @Test(dataProvider = "zeroToThree")
    public void minAreaDoesNotIncreaseBefore4thLineTest(String lines) {
        initialHeight = minArea.getSize().height;
        minArea.setLines(lines);
        assertThat(minArea.getSize().height, anyOf(equalTo(initialHeight), lessThan(initialHeight + 2)));
    }

    @Test
    public void minAreaIncreasesAfter3dLineTest() {
        initialHeight = minArea.getSize().height;
        minArea.setLines(FOUR_LINES);
        assertThat(minArea.getSize().height, greaterThan(initialHeight));
    }

    @Test
    public void maxAreaDoesNotIncreaseAfter4LinesTest() {
        initialHeight = maxArea.getSize().height;
        maxArea.setLines(FOUR_LINES);
        assertThat(maxArea.getSize().height, equalTo(initialHeight));
    }

    @Test
    public void maxAreaHeightDecreasesWhenClearLinesTest() {
        initialHeight = maxArea.getSize().height;
        maxArea.clear();
        maxArea.setLines(ONE_LINE);
        assertThat(maxArea.getSize().height, lessThan(initialHeight));
    }

    @Test
    public void maxAreaIncreasesTill4LinesTest() {
        maxArea.clear();
        maxArea.setLines(ONE_LINE);
        initialHeight = maxArea.getSize().height;
        maxArea.setLines(THREE_LINES);
        assertThat(maxArea.getSize().height, greaterThan(initialHeight));
    }

    @Test
    public void maxAreaDoesNotChangeAfter4LinesTest() {
        maxArea.setLines(FOUR_LINES);
        initialHeight = maxArea.getSize().height;
        maxArea.setLines(FOUR_LINES + ONE_LINE);
        assertThat(maxArea.getSize().height, equalTo(initialHeight));
    }
}

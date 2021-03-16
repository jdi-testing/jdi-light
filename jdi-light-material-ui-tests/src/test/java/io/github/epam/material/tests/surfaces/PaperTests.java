package io.github.epam.material.tests.surfaces;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.surfacePaperDefaultPage;
import static io.github.com.StaticSite.paperFrame;

public class PaperTests extends TestsInit {

    private final String EXPECTED_TEXT = "Paper";
    private final String EXPECTED_TEXT_CAMEL_CASE = "pApEr";
    private final String EXPECTED_TEXT_PART = "per";

    @Test
    public void defaultPaperTest() {
        surfacePaperDefaultPage.open();

        paperFrame.paper.is().textEquals(EXPECTED_TEXT);
        paperFrame.paper.is().textEqualsIgnoreCase(EXPECTED_TEXT_CAMEL_CASE);
        paperFrame.paper.is().textContains(EXPECTED_TEXT_PART);
    }
}

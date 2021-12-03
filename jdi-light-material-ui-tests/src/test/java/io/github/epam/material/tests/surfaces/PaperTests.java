package io.github.epam.material.tests.surfaces;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.paperPage;
import static io.github.com.pages.surfaces.PaperPage.defaultElevationPaper;
import static io.github.com.pages.surfaces.PaperPage.elevationThreePaper;
import static io.github.com.pages.surfaces.PaperPage.infoPaper;
import static io.github.com.pages.surfaces.PaperPage.outlinedRoundedPaper;
import static io.github.com.pages.surfaces.PaperPage.outlinedSquarePaper;
import static io.github.com.pages.surfaces.PaperPage.zeroElevationPaper;

/**
 * To see an example of Paper web element please visit
 * https://mui.com/components/paper/
 */

public class PaperTests extends TestsInit {

    private final String ZERO_ELEVATION = "Paper with elevation = 0";
    private final String DEFAULT_ELEVATION = "Paper with default elavation";
    private final String ELEVATION_EQUALS_THREE = "Paper with elevation = 3";
    private final String OUTLINED_ROUNDED = "Outlined paper";
    private final String OUTLINED_SQUARE = "Outlined square paper";
    private final String YOU_CLICKED = "You clicked: ";

    @BeforeMethod
    public void beforeTest() {
        paperPage.open();
        paperPage.checkOpened();
    }

    @Test
    public void zeroElevationPaperTest() {
        zeroElevationPaper.is().displayed();
        zeroElevationPaper.click();
        infoPaper.has().text(YOU_CLICKED + ZERO_ELEVATION);
    }

    @Test
    public void defaultElevationPaperTest() {
        defaultElevationPaper.is().displayed();
        defaultElevationPaper.click();
        infoPaper.has().text(YOU_CLICKED + DEFAULT_ELEVATION);
    }

    @Test
    public void elevationThreePaperTest() {
        elevationThreePaper.is().displayed();
        elevationThreePaper.click();
        infoPaper.has().text(YOU_CLICKED + ELEVATION_EQUALS_THREE);
    }

    @Test
    public void outlinedRoundedPaperPaperTest() {
        outlinedRoundedPaper.is().displayed();
        outlinedRoundedPaper.click();
        infoPaper.has().text(YOU_CLICKED + OUTLINED_ROUNDED);
    }

    @Test
    public void outlinedSquarePaperTest() {
        outlinedSquarePaper.is().displayed();
        outlinedSquarePaper.click();
        infoPaper.has().text(YOU_CLICKED + OUTLINED_SQUARE);
    }
}

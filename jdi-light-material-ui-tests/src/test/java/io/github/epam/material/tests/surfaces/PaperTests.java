package io.github.epam.material.tests.surfaces;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.paperPage;
import static io.github.com.pages.surfaces.PaperPage.defaultElevationPaper;
import static io.github.com.pages.surfaces.PaperPage.elevationThreePaper;
import static io.github.com.pages.surfaces.PaperPage.outlinedRoundedPaper;
import static io.github.com.pages.surfaces.PaperPage.outlinedSquarePaper;
import static io.github.com.pages.surfaces.PaperPage.zeroElevationPaper;

public class PaperTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        paperPage.open();
        paperPage.checkOpened();
    }

    @Test
    public void zeroElevationPaperTest() {
        zeroElevationPaper.is().displayed();
        zeroElevationPaper.has().elevation(0);
    }

    @Test
    public void defaultElevationPaperTest() {
        defaultElevationPaper.is().displayed();
        defaultElevationPaper.has().elevation(1);
        defaultElevationPaper.is().rounded();
    }

    @Test
    public void elevationThreePaperTest() {
        elevationThreePaper.is().displayed();
        elevationThreePaper.has().elevation(3);
        elevationThreePaper.is().rounded();
    }

    @Test
    public void outlinedRoundedPaperPaperTest() {
        outlinedRoundedPaper.is().displayed();
        outlinedRoundedPaper.is().rounded();
        outlinedRoundedPaper.is().outlined();
    }

    @Test
    public void outlinedSquarePaperTest() {
        outlinedSquarePaper.is().displayed();
        outlinedSquarePaper.is().outlined();
        outlinedSquarePaper.is().notRounded();
    }
}

package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.elements.common.WindowsManager.resizeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.fullscreen;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.gridSystemPage;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.GREY_LIGHTEN_6;
import static io.github.com.pages.GridSystemPage.alignGrid;
import static io.github.com.pages.GridSystemPage.breakpointSizingGrid;
import static io.github.com.pages.GridSystemPage.equalWidthColumnsGrid;
import static io.github.com.pages.GridSystemPage.fluidGrid;
import static io.github.com.pages.GridSystemPage.growAndShrinkGrid;
import static io.github.com.pages.GridSystemPage.justifyGrid;
import static io.github.com.pages.GridSystemPage.marginHelpersGrid;
import static io.github.com.pages.GridSystemPage.nestedGridGrid;
import static io.github.com.pages.GridSystemPage.noGuttersGrid;
import static io.github.com.pages.GridSystemPage.offsetBreakpointGrid;
import static io.github.com.pages.GridSystemPage.offsetGrid;
import static io.github.com.pages.GridSystemPage.orderFirstAndLastGrid;
import static io.github.com.pages.GridSystemPage.orderGrid;
import static io.github.com.pages.GridSystemPage.spacersGrid;
import static io.github.com.pages.GridSystemPage.uniqueLayoutsGrid;
import static io.github.com.pages.GridSystemPage.variableContentWidthGrid;

public class GridsTests extends TestsInit {

    @BeforeClass
    public void before() {
        gridSystemPage.open();
        waitCondition(() -> gridSystemPage.isOpened());
        gridSystemPage.checkOpened();
        resizeWindow(1280, 1057);
    }
    // @todo #5298 Delete window resize and restore window, check the tests
    @AfterClass
	public static void after() {
		fullscreen();
	}

    @Test(description = "Test checks grid's vertical alignment")
    public void alignGridSystemTests() {
        alignGrid.show();
        List<String> alignments = Arrays.asList("start", "center", "end");
        alignGrid.is().displayed();
        for (int i = 1; i <= 3; i++) {
            alignGrid.has().rowVerticalAlignment(i, alignments.get(i - 1));
            alignGrid.has().cellVerticalAlignment(4, i, alignments.get(i - 1));
        }
        alignGrid.has().cellText("One of three columns", 1, 2);
    }

    @Test(description = "Test checks grid's horizontal alignment")
    public void justifyGridSystemTests() {
        List<String> alignments = Arrays.asList("start", "center", "end", "space-around", "space-between");
        justifyGrid.is().displayed();
        for (int i = 1; i <= 5; i++) {
            justifyGrid.has().rowHorizontalAlignment(i, alignments.get(i - 1));
        }
        justifyGrid.has().cellText("One of two columns", 1, 2);
        justifyGrid.has().cellText("One of two columns", 4, 1);
    }

    @Test(description = "Test checks cell texts")
    public void breakpointSizingGridSystemTests() {
        breakpointSizingGrid.show();
        breakpointSizingGrid.has().cellText("1 of 2", 1, 1);
        breakpointSizingGrid.has().cellText("2 of 2", 1, 2);
        breakpointSizingGrid.has().cellText("1 of 3", 2, 1);
        breakpointSizingGrid.has().cellText("2 of 3", 2, 2);
        breakpointSizingGrid.has().cellText("3 of 3", 2, 3);
        noGuttersGrid.show();
        noGuttersGrid.has().cellText(".col-12 .col-sm-6 .col-md-8", 1, 1);
        noGuttersGrid.has().cellText(".col-6 .col-md-4", 1, 2);
    }

    @Test(description = "Test checks is grid has offset or not")
    public void offsetGridSystemTests() {
        offsetGrid.show();
        offsetGrid.has().cellOffset(1, 2);
        offsetGrid.has().cellOffset(2, 1);
        offsetGrid.has().cellOffset(3, 1);
        offsetBreakpointGrid.show();
        offsetBreakpointGrid.has().cellOffset(1, 2);
        offsetBreakpointGrid.has().cellOffset(2, 2);
        noGuttersGrid.show();
        noGuttersGrid.has().noCellOffset(1, 1);
    }

    @Test(description = "Test checks grid cell's order")
    public void orderGridSystemTests() {
        orderGrid.show();
        orderGrid.has().cellOrder(1, 2, 12);
        orderGrid.has().cellOrder(1, 3, 1);
        orderFirstAndLastGrid.show();
        orderFirstAndLastGrid.has().cellOrder(1, 1, "last");
        orderFirstAndLastGrid.has().cellOrder(1, 3, "first");
    }

    @Test(description = "Test checks if grid cells at row has equal width or not")
    public void equalWidthColumnsGridSystemTests() {
        equalWidthColumnsGrid.show();
        equalWidthColumnsGrid.has().cellWithEqualWidthsInRow(1);
        growAndShrinkGrid.show();
        growAndShrinkGrid.has().cellWithDifferentWidthsInRow(2);
    }

    @Test(description = "Test checks grid cell's custom width")
    public void growAndShrinkGridSystemTests() {
        growAndShrinkGrid.show();
        growAndShrinkGrid.has().cellWithCustomWidth(2, 1, 8);
        growAndShrinkGrid.has().cellWithCustomWidth(2, 2, 4);
    }

    @Test(description = "Test checks if cell has margin or not")
    public void marginHelpersGridSystemTests() {
        marginHelpersGrid.show();
        marginHelpersGrid.has().cellWithMargin(1, 1);
        marginHelpersGrid.has().cellWithMargin(1, 2);
        marginHelpersGrid.has().cellWithMargin(2, 1);
        marginHelpersGrid.has().cellWithMargin(2, 2);
        marginHelpersGrid.has().cellWithMargin(3, 1);
        nestedGridGrid.show();
        nestedGridGrid.has().cellWithoutMargin(1, 1);
    }

    @Test(description = "Test checks grid cell's background and font color")
    public void colorGridSystemTests() {
        nestedGridGrid.show();
        nestedGridGrid.has().cellBackgroundColor(2, 1, GREY_LIGHTEN_6.value());
        nestedGridGrid.has().cellFontColor(2, 1, BLACK_TRANSPARENT_087.value());
    }

    @Test(description = "Test checks if grid row has spacers or not")
    public void spacersGridSystemTests() {
        spacersGrid.show();
        spacersGrid.has().rowWithSpacers(1);
        spacersGrid.has().rowWithSpacers(2);
        uniqueLayoutsGrid.show();
        uniqueLayoutsGrid.has().rowWithoutSpacers(1);
    }

    @Test(description = "Test checks that grid cells has auto-width")
    public void autoWidthGridSystemTests() {
        variableContentWidthGrid.show();
        variableContentWidthGrid.has().cellWithAutoWidth(1,2);
        variableContentWidthGrid.has().cellWithAutoWidth(2,2);
    }

    @Test(description = "Test checks if grid is fluid or not")
    public void fluidGridSystemTests() {
        fluidGrid.show();
        fluidGrid.is().fluid();
        variableContentWidthGrid.show();
        variableContentWidthGrid.is().notFluid();
    }

    @Test(description = "Test checks that grid row has no-gutters")
    public void noGuttersGridSystemTests() {
        noGuttersGrid.show();
        noGuttersGrid.has().noGuttersRow(1);
    }

    @Test(description = "Test checks if grid row is dense or not")
    public void denseGridSystemTests() {
        fluidGrid.show();
        fluidGrid.is().dense(1);
        variableContentWidthGrid.show();
        variableContentWidthGrid.is().notDense(1);
    }
}

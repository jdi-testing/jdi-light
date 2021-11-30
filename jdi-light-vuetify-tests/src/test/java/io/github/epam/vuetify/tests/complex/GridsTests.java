package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.elements.common.WindowsManager.resizeWindow;
import static io.github.com.StaticSite.gridSystemPage;
import static io.github.com.enums.Colors.GREY_LIGHTEN_6;
import static io.github.com.pages.GridSystemPage.alignGrid;
import static io.github.com.pages.GridSystemPage.breakpointSizingGrid;
import static io.github.com.pages.GridSystemPage.columnWrappingGrid;
import static io.github.com.pages.GridSystemPage.equalWidthColumnsGrid;
import static io.github.com.pages.GridSystemPage.growAndShrinkGrid;
import static io.github.com.pages.GridSystemPage.justifyGrid;
import static io.github.com.pages.GridSystemPage.marginHelpersGrid;
import static io.github.com.pages.GridSystemPage.nestedGridGrid;
import static io.github.com.pages.GridSystemPage.noGuttersGrid;
import static io.github.com.pages.GridSystemPage.offsetBreakpointGrid;
import static io.github.com.pages.GridSystemPage.offsetGrid;
import static io.github.com.pages.GridSystemPage.oneColumnWidthGrid;
import static io.github.com.pages.GridSystemPage.orderFirstAndLastGrid;
import static io.github.com.pages.GridSystemPage.orderGrid;
import static io.github.com.pages.GridSystemPage.rowAndColumnBreakpointsGrid;
import static io.github.com.pages.GridSystemPage.spacersGrid;
import static io.github.com.pages.GridSystemPage.uniqueLayoutsGrid;
import static io.github.com.pages.GridSystemPage.variableContentWidthGrid;

public class GridsTests extends TestsInit {

    @BeforeClass
    public void before() {
        gridSystemPage.open();
        resizeWindow(1280, 1057);
    }

    @Test
    public void alignGridSystemTests() {
        List<String> alignments = Arrays.asList("start", "center", "end");
        alignGrid.is().displayed();
        for(int i = 1; i <= 3; i++) {
            alignGrid.has().rowVerticalAlignment(i, alignments.get(i - 1));
            alignGrid.has().columnVerticalAlignment(4, i, alignments.get(i - 1));
        }
        alignGrid.has().columnText("One of three columns", 1, 2);
    }

    @Test
    public void breakpointSizingGridSystemTests() {
        breakpointSizingGrid.is().displayed();
        breakpointSizingGrid.has().columnText("1 of 2", 1, 1);
        breakpointSizingGrid.has().columnText("2 of 2", 1, 2);
        breakpointSizingGrid.has().columnText("1 of 3", 2, 1);
        breakpointSizingGrid.has().columnText("2 of 3", 2, 2);
        breakpointSizingGrid.has().columnText("3 of 3", 2, 3);
    }

    @Test
    public void justifyGridSystemTests() {
        List<String> alignments = Arrays.asList("start", "center", "end", "space-around", "space-between");
        justifyGrid.is().displayed();
        for(int i = 1; i <= 5; i++) {
            justifyGrid.has().rowHorizontalAlignment(i, alignments.get(i - 1));
        }
        justifyGrid.has().columnText("One of two columns", 1, 2);
        justifyGrid.has().columnText("One of two columns", 4, 1);
    }

    @Test
    public void noGuttersGridSystemTests() {
        noGuttersGrid.is().displayed();
        noGuttersGrid.has().columnText(".col-12 .col-sm-6 .col-md-8", 1, 1);
        noGuttersGrid.has().columnText(".col-6 .col-md-4", 1, 2);
    }

    @Test
    public void offsetGridSystemTests() {
        offsetGrid.is().displayed();
        offsetGrid.has().columnText(".col-md-4", 1, 1);
        offsetGrid.has().columnText(".col-md-3 .offset-md-3", 2, 2);
        offsetGrid.has().columnText(".col-md-6 .offset-md-3", 3, 1);
        offsetGrid.has().columnOffset(1, 2);
        offsetGrid.has().columnOffset(2, 1);
        offsetGrid.has().columnOffset(3, 1);
    }

    @Test
    public void offsetBreakpointGridSystemTests() {
        offsetBreakpointGrid.is().displayed();
        offsetBreakpointGrid.has().columnText(".col-sm-5 .col-md-6", 1, 1);
        offsetBreakpointGrid.has().columnText(".col-sm-5 .offset-sm-2 .col-md-6 .offset-md-0", 1, 2);
        offsetBreakpointGrid.has().columnText(".col-sm-6 .col-md-5 .offset-md-2 .col-lg-6 .offset-lg-0", 2, 2);
        offsetBreakpointGrid.has().columnOffset(1, 2);
        offsetBreakpointGrid.has().columnOffset(2, 2);
    }

    @Test
    public void orderGridSystemTests() {
        orderGrid.is().displayed();
        orderGrid.has().columnText("First, but unordered", 1, 1);
        orderGrid.has().columnText("Second, but last", 1, 2);
        orderGrid.has().columnText("Third, but first", 1, 3);
        orderGrid.has().columnOrder(1, 2, 12);
        orderGrid.has().columnOrder(1, 3, 1);
    }

    @Test
    public void orderFirstAndLastGridSystemTests() {
        orderFirstAndLastGrid.is().displayed();
        orderFirstAndLastGrid.has().columnText("First, but last", 1, 1);
        orderFirstAndLastGrid.has().columnText("Second, but unordered", 1, 2);
        orderFirstAndLastGrid.has().columnText("Third, but first", 1, 3);
        orderFirstAndLastGrid.has().columnOrder(1, 1, "last");
        orderFirstAndLastGrid.has().columnOrder(1, 3, "first");

    }

    @Test
    public void columnWrappingGridSystemTests() {
        columnWrappingGrid.is().displayed();
        columnWrappingGrid.has().columnText(".col-9", 1, 1);
        columnWrappingGrid.has().columnText(
                ".col-4\nSince 9 + 4 = 13 > 12, this 4-column-wide div gets wrapped " +
                        "onto a new line as one contiguous unit.",
                1, 2);
        columnWrappingGrid.has().columnText(".col-6\nSubsequent columns continue along the new line.",
                1, 3);

    }

    @Test
    public void equalWidthColumnsGridSystemTests() {
        equalWidthColumnsGrid.is().displayed();
        for(int i = 1; i <=4; i++) {
            equalWidthColumnsGrid.has().columnText("Column", 1, i);
        }
        equalWidthColumnsGrid.has().columnsWithEqualWidthsInRow(1);
    }

    @Test
    public void growAndShrinkGridSystemTests() {
        growAndShrinkGrid.is().displayed();
        growAndShrinkGrid.has().columnsWithEqualWidthsInRow(1);
        growAndShrinkGrid.has().columnsWithCustomWidth(2, 1, 8);
        growAndShrinkGrid.has().columnsWithCustomWidth(2, 2, 4);
    }

    @Test
    public void marginHelpersGridSystemTests() {
        marginHelpersGrid.is().displayed();
        marginHelpersGrid.has().columnText(".col-md-4", 1, 1);
        marginHelpersGrid.has().columnText(".col-md-3 .ml-md-auto", 2, 2);
        marginHelpersGrid.has().columnText(".col-auto .mr-auto", 3, 1);
        marginHelpersGrid.has().columnWithMargin(1, 1);
        marginHelpersGrid.has().columnWithMargin(1, 2);
        marginHelpersGrid.has().columnWithMargin(2, 1);
        marginHelpersGrid.has().columnWithMargin(2, 2);
        marginHelpersGrid.has().columnWithMargin(3, 1);
    }

    @Test
    public void nestedGridGridSystemTests() {
        nestedGridGrid.is().displayed();
        nestedGridGrid.has().columnText("Level 2: .col-8 .col-sm-6", 2, 1);
        nestedGridGrid.has().columnText("Level 3: .col-4 .col-sm-6", 2, 2);
        nestedGridGrid.has().columnBackgroundColor(2, 1, GREY_LIGHTEN_6.value());
    }

    @Test
    public void oneColumnWidthGridSystemTests() {
        oneColumnWidthGrid.is().displayed();
        oneColumnWidthGrid.has().columnText("1 of 3", 1, 1);
        oneColumnWidthGrid.has().columnText("2 of 3 (wider)", 1, 2);
        oneColumnWidthGrid.has().columnText("2 of 3 (wider)", 2, 2);
        oneColumnWidthGrid.has().columnsWithCustomWidth(1, 2, 6);
        oneColumnWidthGrid.has().columnsWithCustomWidth(2, 2, 5);
    }

    @Test
    public void rowAndColumnBreakpointsGridSystemTests() {
        rowAndColumnBreakpointsGrid.is().displayed();
        rowAndColumnBreakpointsGrid.show();
        rowAndColumnBreakpointsGrid.has().columnText("col-3", 1, 1);
        rowAndColumnBreakpointsGrid.has().columnText("col-9", 1, 2);
        rowAndColumnBreakpointsGrid.has().columnText("col", 2, 2);
    }

    @Test
    public void spacersGridSystemTests() {
        spacersGrid.is().displayed();
        spacersGrid.has().rowWithSpacers(1);
        spacersGrid.has().rowWithSpacers(2);
    }

    @Test
    public void uniqueLayoutsGridSystemTests() {
        uniqueLayoutsGrid.is().displayed();
        uniqueLayoutsGrid.has().columnText(".col-12 .col-md-8", 1, 1);
        uniqueLayoutsGrid.has().columnText(".col-6 .col-md-4", 2, 2);
        uniqueLayoutsGrid.has().columnText(".col-6", 3, 2);
        uniqueLayoutsGrid.has().columnsWithCustomWidth(1, 1, 12);
        uniqueLayoutsGrid.has().columnsWithCustomWidth(2, 2, 6);
        uniqueLayoutsGrid.has().columnsWithCustomWidth(3, 1, 6);
    }

    @Test
    public void variableContentWidthGridSystemTests() {
        variableContentWidthGrid.is().displayed();
        variableContentWidthGrid.has().columnWithVariableWidth(1,2);
        variableContentWidthGrid.has().columnWithVariableWidth(2,2);
    }
}

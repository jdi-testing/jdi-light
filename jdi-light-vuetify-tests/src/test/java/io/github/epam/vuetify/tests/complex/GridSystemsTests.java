package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.GREY_LIGHTEN_6;
import static io.github.com.StaticSite.gridSystemPage;
import static io.github.com.pages.GridSystemPage.alignGridSystem;
import static io.github.com.pages.GridSystemPage.breakpointSizingGridSystem;
import static io.github.com.pages.GridSystemPage.columnWrappingGridSystem;
import static io.github.com.pages.GridSystemPage.equalWidthColumnsGridSystem;
import static io.github.com.pages.GridSystemPage.growAndShrinkGridSystem;
import static io.github.com.pages.GridSystemPage.justifyGridSystem;
import static io.github.com.pages.GridSystemPage.marginHelpersGridSystem;
import static io.github.com.pages.GridSystemPage.nestedGridGridSystem;
import static io.github.com.pages.GridSystemPage.noGuttersGridSystem;
import static io.github.com.pages.GridSystemPage.offsetBreakpointGridSystem;
import static io.github.com.pages.GridSystemPage.offsetGridSystem;
import static io.github.com.pages.GridSystemPage.oneColumnWidthGridSystem;
import static io.github.com.pages.GridSystemPage.orderFirstAndLastGridSystem;
import static io.github.com.pages.GridSystemPage.orderGridSystem;
import static io.github.com.pages.GridSystemPage.rowAndColumnBreakpointsGridSystem;
import static io.github.com.pages.GridSystemPage.spacersGridSystem;
import static io.github.com.pages.GridSystemPage.uniqueLayoutsGridSystem;
import static io.github.com.pages.GridSystemPage.variableContentWidthGridSystem;

public class GridSystemsTests extends TestsInit {

    @BeforeClass
    public void before() {
        gridSystemPage.open();
    }

    @Test
    public void alignGridSystemTests() {
        List<String> alignments = Arrays.asList("start", "center", "end");
        alignGridSystem.is().displayed();
        for(int i = 1; i <= 3; i++) {
            alignGridSystem.has().rowVerticalAlignment(i, alignments.get(i - 1));
            alignGridSystem.has().columnVerticalAlignment(4, i, alignments.get(i - 1));
        }
        alignGridSystem.has().columnText("One of three columns", 1, 2);
    }

    @Test
    public void breakpointSizingGridSystemTests() {
        breakpointSizingGridSystem.is().displayed();
        breakpointSizingGridSystem.has().columnText("1 of 2", 1, 1);
        breakpointSizingGridSystem.has().columnText("2 of 2", 1, 2);
        breakpointSizingGridSystem.has().columnText("1 of 3", 2, 1);
        breakpointSizingGridSystem.has().columnText("2 of 3", 2, 2);
        breakpointSizingGridSystem.has().columnText("3 of 3", 2, 3);
    }

    @Test
    public void justifyGridSystemTests() {
        List<String> alignments = Arrays.asList("start", "center", "end", "space-around", "space-between");
        justifyGridSystem.is().displayed();
        for(int i = 1; i <= 5; i++) {
            justifyGridSystem.has().rowHorizontalAlignment(i, alignments.get(i - 1));
        }
        justifyGridSystem.has().columnText("One of two columns", 1, 2);
        justifyGridSystem.has().columnText("One of two columns", 4, 1);
    }

    @Test
    public void noGuttersGridSystemTests() {
        noGuttersGridSystem.is().displayed();
        noGuttersGridSystem.has().columnText(".col-12 .col-sm-6 .col-md-8", 1, 1);
        noGuttersGridSystem.has().columnText(".col-6 .col-md-4", 1, 2);
    }

    @Test
    public void offsetGridSystemTests() {
        offsetGridSystem.is().displayed();
        offsetGridSystem.has().columnText(".col-md-4", 1, 1);
        offsetGridSystem.has().columnText(".col-md-3 .offset-md-3", 2, 2);
        offsetGridSystem.has().columnText(".col-md-6 .offset-md-3", 3, 1);
        offsetGridSystem.has().columnOffset(1, 2);
        offsetGridSystem.has().columnOffset(2, 1);
        offsetGridSystem.has().columnOffset(3, 1);

    }

    @Test
    public void offsetBreakpointGridSystemTests() {
        offsetBreakpointGridSystem.is().displayed();
        offsetBreakpointGridSystem.has().columnText(".col-sm-5 .col-md-6", 1, 1);
        offsetBreakpointGridSystem.has().columnText(".col-sm-5 .offset-sm-2 .col-md-6 .offset-md-0", 1, 2);
        offsetBreakpointGridSystem.has().columnText(".col-sm-6 .col-md-5 .offset-md-2 .col-lg-6 .offset-lg-0", 2, 2);
        offsetBreakpointGridSystem.has().columnOffset(1, 2);
        offsetBreakpointGridSystem.has().columnOffset(2, 2);
    }

    @Test
    public void orderGridSystemTests() {
        orderGridSystem.is().displayed();
        orderGridSystem.has().columnText("First, but unordered", 1, 1);
        orderGridSystem.has().columnText("Second, but last", 1, 2);
        orderGridSystem.has().columnText("Third, but first", 1, 3);
        orderGridSystem.has().columnOrder(1, 2, 12);
        orderGridSystem.has().columnOrder(1, 3, 1);
    }

    @Test
    public void orderFirstAndLastGridSystemTests() {
        orderFirstAndLastGridSystem.is().displayed();
        orderFirstAndLastGridSystem.has().columnText("First, but last", 1, 1);
        orderFirstAndLastGridSystem.has().columnText("Second, but unordered", 1, 2);
        orderFirstAndLastGridSystem.has().columnText("Third, but first", 1, 3);
        orderFirstAndLastGridSystem.has().columnOrder(1, 1, "last");
        orderFirstAndLastGridSystem.has().columnOrder(1, 3, "first");

    }

    @Test
    public void columnWrappingGridSystemTests() {
        columnWrappingGridSystem.is().displayed();
        columnWrappingGridSystem.has().columnText(".col-9", 1, 1);
        columnWrappingGridSystem.has().columnText(
                ".col-4\nSince 9 + 4 = 13 > 12, this 4-column-wide div gets wrapped " +
                        "onto a new line as one contiguous unit.",
                1, 2);
        columnWrappingGridSystem.has().columnText(".col-6\nSubsequent columns continue along the new line.",
                1, 3);

    }

    @Test
    public void equalWidthColumnsGridSystemTests() {
        equalWidthColumnsGridSystem.is().displayed();
        for(int i = 1; i <=4; i++) {
            equalWidthColumnsGridSystem.has().columnText("Column", 1, i);
        }
        equalWidthColumnsGridSystem.has().columnsWithEqualWidthsInRow(1);
    }

    @Test
    public void growAndShrinkGridSystemTests() {
        growAndShrinkGridSystem.is().displayed();
        growAndShrinkGridSystem.has().columnsWithEqualWidthsInRow(1);
        growAndShrinkGridSystem.has().columnsWithCustomWidth(2, 1, 8);
        growAndShrinkGridSystem.has().columnsWithCustomWidth(2, 2, 4);
    }

    @Test
    public void marginHelpersGridSystemTests() {
        marginHelpersGridSystem.is().displayed();
        marginHelpersGridSystem.has().columnText(".col-md-4", 1, 1);
        marginHelpersGridSystem.has().columnText(".col-md-3 .ml-md-auto", 2, 2);
        marginHelpersGridSystem.has().columnText(".col-auto .mr-auto", 3, 1);
        marginHelpersGridSystem.has().columnWithMargin(1, 1);
        marginHelpersGridSystem.has().columnWithMargin(1, 2);
        marginHelpersGridSystem.has().columnWithMargin(2, 1);
        marginHelpersGridSystem.has().columnWithMargin(2, 2);
        marginHelpersGridSystem.has().columnWithMargin(3, 1);
    }

    @Test
    public void nestedGridGridSystemTests() {
        nestedGridGridSystem.is().displayed();
        nestedGridGridSystem.has().columnText("Level 2: .col-8 .col-sm-6", 2, 1);
        nestedGridGridSystem.has().columnText("Level 3: .col-4 .col-sm-6", 2, 2);
        nestedGridGridSystem.has().backgroundColor(2, 1, GREY_LIGHTEN_6.value());
    }

    @Test
    public void oneColumnWidthGridSystemTests() {
        oneColumnWidthGridSystem.is().displayed();
        oneColumnWidthGridSystem.has().columnText("1 of 3", 1, 1);
        oneColumnWidthGridSystem.has().columnText("2 of 3 (wider)", 1, 2);
        oneColumnWidthGridSystem.has().columnText("2 of 3 (wider)", 2, 2);
        oneColumnWidthGridSystem.has().columnsWithCustomWidth(1, 2, 6);
        oneColumnWidthGridSystem.has().columnsWithCustomWidth(2, 2, 5);
    }

    @Test
    public void rowAndColumnBreakpointsGridSystemTests() {
        rowAndColumnBreakpointsGridSystem.is().displayed();
        rowAndColumnBreakpointsGridSystem.show();
        rowAndColumnBreakpointsGridSystem.has().columnText("col-6", 1, 1);
        rowAndColumnBreakpointsGridSystem.has().columnText("col-6", 1, 2);
        rowAndColumnBreakpointsGridSystem.has().columnText("col", 2, 2);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void spacersGridSystemTests() {
        spacersGridSystem.is().displayed();
        spacersGridSystem.has().rowWithSpacers(1);
        spacersGridSystem.has().rowWithSpacers(2);
    }

    @Test
    public void uniqueLayoutsGridSystemTests() {
        uniqueLayoutsGridSystem.is().displayed();
    }

    @Test
    public void variableContentWidthGridSystemTests() {
        variableContentWidthGridSystem.is().displayed();
    }
}

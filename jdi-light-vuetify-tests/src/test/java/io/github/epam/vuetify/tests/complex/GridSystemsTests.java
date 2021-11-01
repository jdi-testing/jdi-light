package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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
        for(int i = 1; i < alignGridSystem.getRows().size(); i++) {
            alignGridSystem.has().rowVerticalAlignment(i, alignments.get(i-1));
            for(int j = 1; j <= alignGridSystem.getColumnsByRowIndex(i).size(); j++) {
                alignGridSystem.has().columnText("One of three columns", i ,j);
            }
        }
        for(int i = 1; i <= alignGridSystem.getColumnsByRowIndex(4).size(); i++) {
            alignGridSystem.has().columnText("One of three columns", 4, i);
            alignGridSystem.has().columnVerticalAlignment(4, i, alignments.get(i-1));
        }
    }

    @Test
    public void breakpointSizingGridSystemTests() {
        breakpointSizingGridSystem.is().displayed();
    }

    @Test
    public void justifyGridSystemTests() {
        justifyGridSystem.is().displayed();
    }

    @Test
    public void noGuttersGridSystemTests() {
        noGuttersGridSystem.is().displayed();
    }

    @Test
    public void offsetGridSystemTests() {
        offsetGridSystem.is().displayed();
    }

    @Test
    public void orderGridSystemTests() {
        orderGridSystem.is().displayed();
    }

    @Test
    public void orderFirstAndLastGridSystemTests() {
        orderFirstAndLastGridSystem.is().displayed();
    }

    @Test
    public void columnWrappingGridSystemTests() {
        columnWrappingGridSystem.is().displayed();
    }

    @Test
    public void equalWidthColumnsGridSystemTests() {
        equalWidthColumnsGridSystem.is().displayed();
    }

    @Test
    public void growAndShrinkGridSystemTests() {
        growAndShrinkGridSystem.is().displayed();
    }

    @Test
    public void marginHelpersGridSystemTests() {
        marginHelpersGridSystem.is().displayed();
    }

    @Test
    public void nestedGridGridSystemTests() {
        nestedGridGridSystem.is().displayed();
    }

    @Test
    public void oneColumnWidthGridSystemTests() {
        oneColumnWidthGridSystem.is().displayed();
    }

    @Test
    public void rowAndColumnBreakpointsGridSystemTests() {
        rowAndColumnBreakpointsGridSystem.is().displayed();
    }

    @Test
    public void spacersGridSystemTests() {
        spacersGridSystem.is().displayed();
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

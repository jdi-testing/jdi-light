package io.github.epam.vuetify.tests.complex;


import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.simpleTablesPage;
import static io.github.com.enums.TableTestData.ECLAIR;
import static io.github.com.enums.TableTestData.FROZEN_YOGURT_CALORIES;
import static io.github.com.pages.SimpleTablesPage.darkTable;
import static io.github.com.pages.SimpleTablesPage.denseTable;
import static io.github.com.pages.SimpleTablesPage.fixedHeaderTable;
import static io.github.com.pages.SimpleTablesPage.heightTable;

public class SimpleTablesTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        simpleTablesPage.open();
        waitCondition(() -> simpleTablesPage.isOpened());
        simpleTablesPage.checkOpened();
    }

    @Test(description = "Test checks columns' titles and values")
    public static void contentSimpleTableTest() {
        darkTable.is().columnTitle(1, "Name").and().columnTitle(2, "Calories");
        darkTable.is().columnHasValue(1, ECLAIR.value()).and().cellValue(1, 3, ECLAIR.value());
        darkTable.is().columnHasValue(2, FROZEN_YOGURT_CALORIES.value());
        darkTable.is().cellValue(2, 1, FROZEN_YOGURT_CALORIES.value());
    }

    @Test(description = "Test checks that table has dark or light theme")
    public static void themeSimpleTableTests() {
        darkTable.is().dark();
        denseTable.is().light();
    }

    @Test(description = "Test checks that table is dense")
    public static void denseSimpleTableTests() {
        denseTable.show();
        denseTable.is().dense();
    }

    @Test(description = "Test checks that table has fixed header")
    public static void fixedHeaderSimpleTableTests() {
        fixedHeaderTable.show();
        fixedHeaderTable.is().fixedHeader();
    }

    @Test(description = "Test checks that table has fixed height with expected value")
    public static void heightSimpleTableTests() {
        heightTable.show();
        heightTable.is().fixedHeight();
        heightTable.has().height(300);
    }
}

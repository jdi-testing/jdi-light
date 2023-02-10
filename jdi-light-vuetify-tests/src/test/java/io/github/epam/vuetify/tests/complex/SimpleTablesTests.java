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

    @Test
    public static void contentSimpleTableTest() {
        darkTable.is().columnTitle(0, "Name")
                .and().columnTitle(1, "Calories")
                .and().columnHasValue(1, ECLAIR.value())
                .and().cellValue(1, 3, ECLAIR.value())
                .and().columnHasValue(2, FROZEN_YOGURT_CALORIES.value())
                .and().cellValue(2, 1, FROZEN_YOGURT_CALORIES.value());
    }

    @Test
    public static void themeSimpleTableTests() {
        darkTable.is().dark();
        denseTable.is().light();
    }

    @Test
    public static void denseSimpleTableTests() {
        denseTable.show();
        denseTable.is().dense();
    }

    @Test
    public static void fixedHeaderSimpleTableTests() {
        fixedHeaderTable.show();
        fixedHeaderTable.is().fixedHeader();
    }

    @Test
    public static void heightSimpleTableTests() {
        heightTable.show();
        heightTable.is().fixedHeight();
        heightTable.has().height(300);
    }
}

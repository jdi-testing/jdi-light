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
        darkTable.is().columnTitle(0, "Name")
                .and().columnTitle(1, "Calories")
                .and().cellValue(1, 3, ECLAIR.value())
                .and().cellValue(2, 1, FROZEN_YOGURT_CALORIES.value());
    }

    @Test(description = "Test checks that table has dark or light theme")
    public static void themeSimpleTableTests() {
        darkTable.is().darkTheme();
        denseTable.show();
        denseTable.is().dense();
        denseTable.is().lightTheme();
    }

    @Test(description = "Test checks that table has fixed header")
    public static void fixedHeaderSimpleTableTests() {
        fixedHeaderTable.show();
        fixedHeaderTable.has().fixedHeader();
        
        heightTable.show();
        heightTable.has().fixedHeight().and().height(300);
    }
}

package io.github.epam.vuetify.tests.complex;


import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.simpleTablesPage;
import static io.github.com.enums.TableTestData.ECLAIR;
import static io.github.com.enums.TableTestData.FROZEN_YOGURT_CALORIES;
import static io.github.com.pages.SimpleTablesPage.*;

public class SimpleTablesTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        simpleTablesPage.open();
        waitCondition(() -> simpleTablesPage.isOpened());
        simpleTablesPage.checkOpened();
    }

    @Test
    public static void contentSimpleTableTest() {
        darkTable.is().columnTitle(1, "Name").and().columnTitle(2, "Calories");
        darkTable.is().columnHasValue(1, ECLAIR.value()).and().cellHasValue(1, 3, ECLAIR.value());
        darkTable.is().columnHasValue(2, FROZEN_YOGURT_CALORIES.value());
        darkTable.is().cellHasValue(2, 1, FROZEN_YOGURT_CALORIES.value());
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

package io.github.epam.vuetify.tests.complex;


import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.enums.TableTestData.DONUT;
import static io.github.com.enums.TableTestData.DONUT_CALORIES;
import static io.github.com.enums.TableTestData.ECLAIR;
import static io.github.com.enums.TableTestData.FROZEN_YOGURT_CALORIES;
import static io.github.com.enums.TableTestData.GINGERBREAD;
import static io.github.com.enums.TableTestData.HONEYCOMB;
import static io.github.com.enums.TableTestData.HONEYCOMB_CALORIES;
import static io.github.com.enums.TableTestData.ICE_CREAM_SANDWICH;
import static io.github.com.enums.TableTestData.ICE_CREAM_SANDWICH_CALORIES;
import static io.github.com.enums.TableTestData.JELLY_BEAN;
import static io.github.com.enums.TableTestData.JELLY_BEAN_CALORIES;
import static io.github.com.enums.TableTestData.KITKAT;
import static io.github.com.enums.TableTestData.KITKAT_CALORIES;
import static io.github.com.enums.TableTestData.LOLLIPOP;
import static io.github.com.enums.TableTestData.LOLLIPOP_CALORIES;
import static io.github.com.StaticSite.simpleTablesPage;
import static io.github.com.pages.SimpleTablesPage.darkTable;
import static io.github.com.pages.SimpleTablesPage.denseTable;
import static io.github.com.pages.SimpleTablesPage.fixedHeaderTable;
import static io.github.com.pages.SimpleTablesPage.heightTable;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTablesTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        simpleTablesPage.open();
        waitCondition(() -> simpleTablesPage.isOpened());
        simpleTablesPage.checkOpened();
    }

    @Test
    public static void darkTableTests() {
        darkTable.is().columnHasValue(1, ECLAIR.value());
        darkTable.is().columnHasValue(2, FROZEN_YOGURT_CALORIES.value());
        darkTable.is().dark();
        darkTable.is().columnTitle(1, "Name");
    }

    @Test
    public static void denseTableTests() {
        denseTable.show();
        denseTable.is().light();
        denseTable.is().columnTitle(1, "Name");
        denseTable.is().columnTitle(2, "Calories");
        denseTable.is().columnHasValue(1, LOLLIPOP.value()).and().columnHasValue(2, LOLLIPOP_CALORIES.value());
        denseTable.is().columnHasValue(1, DONUT.value()).and().columnHasValue(2, DONUT_CALORIES.value());
    }

    @Test
    public static void fixedHeaderTableTests() {
        fixedHeaderTable.is().fixedHeader();
        fixedHeaderTable.is().columnTitle(1, "Name").and().columnHasValue(1, HONEYCOMB.value());
        fixedHeaderTable.is().columnHasValue(1, ICE_CREAM_SANDWICH.value())
                .and().columnHasValue(2, ICE_CREAM_SANDWICH_CALORIES.value());
        fixedHeaderTable.is().columnHasValue(1, KITKAT.value()).and().columnHasValue(2, KITKAT_CALORIES.value());
    }

    @Test
    public static void heightTableTests() {
        heightTable.is().fixedHeight();
        heightTable.is().columnTitle(2, "Calories").and().columnHasValue(1, GINGERBREAD.value());
        heightTable.is().columnHasValue(1, HONEYCOMB.value()).and().columnHasValue(2, HONEYCOMB_CALORIES.value());
        heightTable.is().columnHasValue(1, JELLY_BEAN.value()).and().columnHasValue(2, JELLY_BEAN_CALORIES.value());
    }
}

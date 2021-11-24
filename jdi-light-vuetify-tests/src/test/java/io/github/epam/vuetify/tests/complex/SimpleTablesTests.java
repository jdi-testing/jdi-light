package io.github.epam.vuetify.tests.complex;


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
    }

    @Test
    public static void darkTableTests() {
        darkTable.is().firstColumnHasElement(ECLAIR.value());
        darkTable.is().secondColumnHasElement(1, FROZEN_YOGURT_CALORIES.value());
        darkTable.is().dark();
        darkTable.is().columnTitle(1, "Name");
    }

    @Test
    public static void denseTableTests() {
        denseTable.is().light();
        denseTable.is().columnTitle(1, "Name");
        denseTable.is().columnTitle(2, "Calories");
        denseTable.is().firstColumnHasElement(LOLLIPOP.value()).and().secondColumnHasElement(LOLLIPOP_CALORIES.value());
        denseTable.is().firstColumnHasElement(DONUT.value()).and().secondColumnHasElement(DONUT_CALORIES.value());
    }

    @Test
    public static void fixedHeaderTableTests() {
        fixedHeaderTable.is().fixedHeader();
        fixedHeaderTable.is().columnTitle(1, "Name").and().firstColumnHasElement(HONEYCOMB.value());
        fixedHeaderTable.is().firstColumnHasElement(ICE_CREAM_SANDWICH.value())
                .and().secondColumnHasElement(ICE_CREAM_SANDWICH_CALORIES.value());
        fixedHeaderTable.is().firstColumnHasElement(KITKAT.value()).and().secondColumnHasElement(KITKAT_CALORIES.value());
    }

    @Test
    public static void heightTableTests() {
        heightTable.is().fixedHeight();
        heightTable.is().columnTitle(2, "Calories").and().firstColumnHasElement(GINGERBREAD.value());
        heightTable.is().firstColumnHasElement(HONEYCOMB.value()).and().secondColumnHasElement(HONEYCOMB_CALORIES.value());
        heightTable.is().firstColumnHasElement(JELLY_BEAN.value()).and().secondColumnHasElement(JELLY_BEAN_CALORIES.value());
    }
}

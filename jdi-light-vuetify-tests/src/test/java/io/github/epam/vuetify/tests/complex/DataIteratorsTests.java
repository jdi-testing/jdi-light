package io.github.epam.vuetify.tests.complex;

import static io.github.com.StaticSite.dataIteratorsPage;
import static io.github.com.pages.DataIteratorsPage.defaultDataIterator;
import static io.github.com.pages.DataIteratorsPage.defaultDataIteratorExpandSingleItemButton;
import static io.github.com.pages.DataIteratorsPage.filterDataIterator;
import static io.github.com.pages.DataIteratorsPage.headerFooterDataIterator;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DataIteratorsTests extends TestsInit {
    private final static String YOGURT = "Frozen Yogurt";
    private final static String CUPCAKE = "Cupcake";
    private final static String DONUT = "Donut";
    private final static String LOLLIPOP = "Lollipop";
    private final static String JELLYBEAN = "Jelly bean";
    private final static String SANDWICH = "Ice cream sandwich";
    private final static String ECLAIR = "Eclair";

    @BeforeSuite
    public static void setup() {
        dataIteratorsPage.open();
    }

    @Test
    public static void defaultDataIteratorTest() {

        defaultDataIterator.getAllColumns();
        defaultDataIterator.has().columnExpanded(1).and().columnNotEmpty(1);
        defaultDataIterator.has().columnExpanded(2).and().columnNotEmpty(2);
        defaultDataIterator.has().columnExpanded(3).and().columnNotEmpty(3);
        defaultDataIterator.has().columnExpanded(4).and().columnNotEmpty(4);

        defaultDataIteratorExpandSingleItemButton.click();
        defaultDataIterator.closeColumn(1);

        defaultDataIterator.has().columnClosed(1).and().columnEmpty(1);
        defaultDataIterator.has().columnClosed(2).and().columnEmpty(2);
        defaultDataIterator.has().columnClosed(3).and().columnEmpty(3);
        defaultDataIterator.has().columnClosed(4).and().columnEmpty(4);
    }

    @Test
    public static void headerFooterDataIteratorTest() {
        headerFooterDataIterator.has().columnTitle(1, YOGURT).and().columnNotEmpty(1);
        headerFooterDataIterator.has().columnTitle(2, SANDWICH).and().columnNotEmpty(2);
        headerFooterDataIterator.has().columnTitle(3, ECLAIR).and().columnNotEmpty(3);
        headerFooterDataIterator.has().columnTitle(4, CUPCAKE).and().columnNotEmpty(4);

        headerFooterDataIterator.has().header("This is a header");
        headerFooterDataIterator.has().footer("This is a footer");
    }

    @Test
    public static void filterDataIteratorTest() {
        filterDataIterator.search(YOGURT);
        filterDataIterator.has().columnTitle(1, YOGURT);
        filterDataIterator.search(DONUT);
        filterDataIterator.has().columnTitle(1, DONUT);
        filterDataIterator.clear();

        filterDataIterator.sortAscend("Name");
        filterDataIterator.has().columnTitle(1, CUPCAKE);
        filterDataIterator.has().columnTitle(2, DONUT);

        filterDataIterator.sortDescend("Carbs");
        filterDataIterator.has().columnTitle(1, LOLLIPOP);
        filterDataIterator.has().columnTitle(2, JELLYBEAN);

        filterDataIterator.numberColumnsOnPage("8");
        filterDataIterator.has().number(8);

        filterDataIterator.nextPage();
        filterDataIterator.has().number(2);
    }
}

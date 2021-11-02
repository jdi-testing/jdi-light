package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.enums.TableTestData;
import static io.github.com.StaticSite.dataIteratorsPage;
import static io.github.com.pages.DataIteratorsPage.defaultDataIterator;
import static io.github.com.pages.DataIteratorsPage.filterDataIterator;
import static io.github.com.pages.DataIteratorsPage.headerFooterDataIterator;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataIteratorsTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        dataIteratorsPage.open();
    }

    @Test
    public static void defaultDataIteratorTest() {

        defaultDataIterator.expandColumn(1);
        defaultDataIterator.expandColumn(3);
        defaultDataIterator.assertThat().columnExpanded(1).and().columnNotEmpty(1);
        defaultDataIterator.assertThat().columnExpanded(3).and().columnNotEmpty(3);
        defaultDataIterator.singleSelectOn();
        defaultDataIterator.collapseCollumn(1);

        defaultDataIterator.assertThat().columnClosed(1).and().columnClosed(3);
    }

    @Test
    public static void headerFooterDataIteratorTest() {
        headerFooterDataIterator.assertThat().columnTitle(1, TableTestData.FROZEN_YOGURT)
                .and().columnNotEmpty(1);
        headerFooterDataIterator.assertThat().columnTitle(2, TableTestData.ICE_CREAM_SANDWICH)
                .and().columnNotEmpty(2);
        headerFooterDataIterator.assertThat().columnTitle(3, TableTestData.ECLAIR)
                .and().columnNotEmpty(3);
        headerFooterDataIterator.assertThat().columnTitle(4, TableTestData.CUPCAKE)
                .and().columnNotEmpty(4);

        headerFooterDataIterator.assertThat().header("This is a header");
        headerFooterDataIterator.assertThat().footer("This is a footer");
    }

    @Test
    public static void filterDataIteratorTest() {
        filterDataIterator.search(TableTestData.FROZEN_YOGURT);
        filterDataIterator.has().columnTitle(1, TableTestData.FROZEN_YOGURT);
        filterDataIterator.search(TableTestData.DONUT);
        filterDataIterator.has().columnTitle(1, TableTestData.DONUT);
        filterDataIterator.clear();

        filterDataIterator.assertThat().columnTitle(1, TableTestData.CUPCAKE)
                .and().columnTitle(2, TableTestData.DONUT);

        filterDataIterator.sortAscend("Name");
        filterDataIterator.assertThat().columnTitle(1, TableTestData.CUPCAKE)
                .and().columnTitle(2, TableTestData.DONUT);

        filterDataIterator.sortDescend("Carbs");
        filterDataIterator.assertThat().columnTitle(1, TableTestData.LOLLIPOP)
                .and().columnTitle(2, TableTestData.JELLY_BEAN);

        filterDataIterator.numberColumnsOnPage("8");
        filterDataIterator.has().number(8);

        filterDataIterator.nextPage();
        filterDataIterator.has().number(2);
    }
}

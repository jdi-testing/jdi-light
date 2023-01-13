package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.dataIteratorsPage;
import static io.github.com.enums.TableTestData.CUPCAKE;
import static io.github.com.enums.TableTestData.DONUT;
import static io.github.com.enums.TableTestData.ECLAIR;
import static io.github.com.enums.TableTestData.FROZEN_YOGURT;
import static io.github.com.enums.TableTestData.ICE_CREAM_SANDWICH;
import static io.github.com.enums.TableTestData.JELLY_BEAN;
import static io.github.com.enums.TableTestData.LOLLIPOP;
import static io.github.com.pages.DataIteratorsPage.defaultDataIterator;
import static io.github.com.pages.DataIteratorsPage.defaultDataIteratorSingleSelect;
import static io.github.com.pages.DataIteratorsPage.filterDataIterator;
import static io.github.com.pages.DataIteratorsPage.headerFooterDataIterator;
import static io.github.com.pages.DataIteratorsPage.singleSelectTableIterator;

public class DataIteratorsTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        dataIteratorsPage.open();
        waitCondition(() -> dataIteratorsPage.isOpened());
        dataIteratorsPage.checkOpened();
    }

    @Test(description = "Test checks if column is expanded or collapsed")
    public static void expandCollapseDataIteratorTest() {
        defaultDataIterator.expandColumn(1);
        defaultDataIterator.expandColumn(3);
        defaultDataIterator.assertThat().columnExpanded(1).and().columnNotEmpty(1);
        defaultDataIterator.assertThat().columnExpanded(3).and().columnNotEmpty(3);
        defaultDataIteratorSingleSelect.check();
        defaultDataIterator.collapseCollumn(1);
        defaultDataIterator.assertThat().columnCollapsed(1).and().columnCollapsed(3);
    }

    @Test(description = "Test checks data iterator column title")
    public static void columnTitleDataIteratorTest() {
        headerFooterDataIterator.show();
        headerFooterDataIterator.assertThat().columnTitle(1, FROZEN_YOGURT.value())
                .and().columnNotEmpty(1);
        headerFooterDataIterator.assertThat().columnTitle(2, ICE_CREAM_SANDWICH.value())
                .and().columnNotEmpty(2);
        headerFooterDataIterator.assertThat().columnTitle(3, ECLAIR.value())
                .and().columnNotEmpty(3);
        headerFooterDataIterator.assertThat().columnTitle(4, CUPCAKE.value())
                .and().columnNotEmpty(4);
    }

    @Test(description = "Test checks data iterator header and footer")
    public static void headerFooterDataIteratorTest() {
        headerFooterDataIterator.show();
        headerFooterDataIterator.assertThat().header("This is a header");
        headerFooterDataIterator.assertThat().footer("This is a footer");
    }

    @Test(description = "Test checks data iterator sort")
    public static void filterDataIteratorTest() {
        filterDataIterator.filterDataSearchField.clearAndTypeText(FROZEN_YOGURT.value());
        filterDataIterator.has().columnTitle(1, FROZEN_YOGURT.value());
        filterDataIterator.filterDataSearchField.clearAndTypeText(DONUT.value());
        filterDataIterator.has().columnTitle(1, DONUT.value());
        filterDataIterator.filterDataSearchField.clearTextField();
        filterDataIterator.assertThat().columnTitle(1, CUPCAKE.value())
                .and().columnTitle(2, DONUT.value());
        filterDataIterator.filterSortSelect.select("Name");
        filterDataIterator.sortAsc();
        filterDataIterator.assertThat().columnTitle(1, CUPCAKE.value())
                .and().columnTitle(2, DONUT.value());
        filterDataIterator.filterSortSelect.select("Carbs");
        filterDataIterator.sortDesc();
        filterDataIterator.assertThat().columnTitle(1, LOLLIPOP.value())
                .and().columnTitle(2, JELLY_BEAN.value());
        filterDataIterator.itemsPerPage.select("8");
        filterDataIterator.has().numberOfColumns(8);
        filterDataIterator.nextPage.click();
        filterDataIterator.has().numberOfColumns(2);
    }

    @Test(description = "Test checks data iterator theme : theme (dark/light)")
    public void themeDataIteratorTest() {
        headerFooterDataIterator.show();
        headerFooterDataIterator.has().headerWithDarkTheme();
        headerFooterDataIterator.has().footerWithDarkTheme();
        headerFooterDataIterator.has().lightTheme();
    }

    @Test(description = "Test checks that data iterator is single select")
    public void singleSelectDataIteratorTest() {
        singleSelectTableIterator.show();
        singleSelectTableIterator.checkboxes().get(0).check();
        singleSelectTableIterator.is().checked(0);
        singleSelectTableIterator.checkboxes().get(1).check();
        singleSelectTableIterator.is().unchecked(0);
        singleSelectTableIterator.is().checked(1);
    }
}

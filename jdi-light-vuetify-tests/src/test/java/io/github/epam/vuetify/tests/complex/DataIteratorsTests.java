package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.complex.WebList;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.DataIteratorDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.UIFactory.$$;
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
import static io.github.com.pages.DataIteratorsPage.groupedDataIteratorLocator;
import static io.github.com.pages.DataIteratorsPage.headerFooterDataIterator;
import static io.github.com.pages.DataIteratorsPage.loadingTextDataIterator;
import static io.github.com.pages.DataIteratorsPage.noDataTextDataIterator;
import static io.github.com.pages.DataIteratorsPage.noResultsTextDataIterator;
import static io.github.com.pages.DataIteratorsPage.noResultsTextSearchField;
import static io.github.com.pages.DataIteratorsPage.singleSelectTableIterator;
import static org.hamcrest.Matchers.containsString;

public class DataIteratorsTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        dataIteratorsPage.open();
        waitCondition(() -> dataIteratorsPage.isOpened());
        dataIteratorsPage.checkOpened();
    }

    @Test(description = "Test checks data iterator column title")
    public static void columnTitleDataIteratorTest() {
        headerFooterDataIterator.show();
        headerFooterDataIterator.dataiteratorCardByNumber(1).assertThat().columnTitle(FROZEN_YOGURT.value())
                .and().columnNotEmpty();
        headerFooterDataIterator.dataiteratorCardByNumber(2).assertThat().columnTitle(ICE_CREAM_SANDWICH.value())
                .and().columnNotEmpty();
        headerFooterDataIterator.dataiteratorCardByNumber(3).assertThat().columnTitle(ECLAIR.value())
                .and().columnNotEmpty();
        headerFooterDataIterator.dataiteratorCardByNumber(4).assertThat().columnTitle(CUPCAKE.value())
                .and().columnNotEmpty();
    }

    @Test(description = "Test checks if column is expanded or collapsed")
    public static void expandCollapseDataIteratorTest() {
        defaultDataIterator.dataiteratorCardByNumber(1).expandColumn();
        defaultDataIterator.dataiteratorCardByNumber(3).expandColumn();

        defaultDataIterator.dataiteratorCardByNumber(1).assertThat().columnExpanded().and().columnNotEmpty();
        defaultDataIterator.dataiteratorCardByNumber(3).assertThat().columnExpanded().and().columnNotEmpty();
        defaultDataIteratorSingleSelect.check();
        defaultDataIterator.dataiteratorCardByNumber(1).collapseCollumn();
        defaultDataIterator.dataiteratorCardByNumber(1).assertThat().columnCollapsed();
        defaultDataIterator.dataiteratorCardByNumber(3).assertThat().columnCollapsed();
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
        filterDataIterator.dataiteratorCardByNumber(1).has().columnTitle(FROZEN_YOGURT.value());
        filterDataIterator.filterDataSearchField.clearAndTypeText(DONUT.value());
        filterDataIterator.dataiteratorCardByNumber(1).has().columnTitle(DONUT.value());
        filterDataIterator.filterDataSearchField.clearTextField();
        filterDataIterator.dataiteratorCardByNumber(1).assertThat().columnTitle(CUPCAKE.value());
        filterDataIterator.dataiteratorCardByNumber(2).assertThat().columnTitle(DONUT.value());
        filterDataIterator.filterSortSelect.select("Name");
        filterDataIterator.sortAsc();
        filterDataIterator.dataiteratorCardByNumber(1).assertThat().columnTitle(CUPCAKE.value());
        filterDataIterator.dataiteratorCardByNumber(2).assertThat().columnTitle(DONUT.value());
        filterDataIterator.filterSortSelect.select("Carbs");
        filterDataIterator.sortDesc();
        filterDataIterator.dataiteratorCardByNumber(1).assertThat().columnTitle(LOLLIPOP.value());
        filterDataIterator.dataiteratorCardByNumber(2).assertThat().columnTitle(JELLY_BEAN.value());
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

    @Test(description = "Test checks data iterator parameter : No data text")
    public void noDataTextDataIteratiorTest() {
        noDataTextDataIterator.show();
        noDataTextDataIterator.has().text(containsString("Sorry, there's no any items data..."));
        //The default text is "No data available".
        //Test checks the parameter no-data-text="..." that allows to set custom text value.
    }

    @Test(description = "Test checks data iterator parameter : No results text")
    public void noResultsTextDataIteratiorTest() {
        noResultsTextSearchField.show();
        noResultsTextSearchField.clearTextField();
        noResultsTextDataIterator.dataIteratorElements().is().notEmpty();
        noResultsTextSearchField.clearAndTypeText("abcd");
        noResultsTextDataIterator.has().text(containsString("Sorry, nothing found :("));
        //The default text is "No matching records found".
        //Test checks the parameter no-results-text="..." that allows to set custom text value.
    }

    @Test(description = "Test checks data iterator parameter : Loading text")
    public void loadingTextDataIteratiorTest() {
        loadingTextDataIterator.show();
        loadingTextDataIterator.has().text(containsString("Items are loading, please, wait a little bit..."));
        //The default text is "Loading items...".
        //Test checks the parameter loading-text="..." that allows to set custom text value.
    }

    @Test(description = "Test checks data iterator parameter : Group by",
    dataProvider = "groupByDataIteratorTestData", dataProviderClass = DataIteratorDataProvider.class)
    public void groupByDataIteratorTest(String groupingParameter, String parameterValue, int expectedElementsQuantity) {
        WebList groupedByDataIterator = $$(groupedDataIteratorLocator
                .replace("PARAMETER", groupingParameter)
                .replace("VALUE", parameterValue));
        groupedByDataIterator.show();
        groupedByDataIterator.has().size(expectedElementsQuantity);
    }

}

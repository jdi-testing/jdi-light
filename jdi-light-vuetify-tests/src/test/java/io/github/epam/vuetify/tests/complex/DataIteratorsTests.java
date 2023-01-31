package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import io.github.com.custom.cards.ButtonCard;
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
        headerFooterDataIterator.assertThat().columnTitle(1, FROZEN_YOGURT.value())
                .and().columnNotEmpty(1);
        headerFooterDataIterator.assertThat().columnTitle(2, ICE_CREAM_SANDWICH.value())
                .and().columnNotEmpty(2);
        headerFooterDataIterator.assertThat().columnTitle(3, ECLAIR.value())
                .and().columnNotEmpty(3);
        headerFooterDataIterator.assertThat().columnTitle(4, CUPCAKE.value())
                .and().columnNotEmpty(4);
    }

    @Test(description = "Test checks if column is expanded or collapsed")
    public static void expandCollapseDataIteratorTest() {
        defaultDataIterator.dataIteratorElements().get(1).with(ButtonCard.class).expandColumn();
        defaultDataIterator.dataIteratorElements().get(3).with(ButtonCard.class).expandColumn();

        defaultDataIterator.dataIteratorElements().get(1).with(ButtonCard.class).assertThat().columnExpanded().and().columnNotEmpty();
        defaultDataIterator.assertThat().columnExpanded(3).and().columnNotEmpty(3);
        defaultDataIteratorSingleSelect.check();
        defaultDataIterator.dataIteratorElements().get(1).with(ButtonCard.class).collapseCollumn();
        defaultDataIterator.assertThat().columnCollapsed(1).and().columnCollapsed(3);
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

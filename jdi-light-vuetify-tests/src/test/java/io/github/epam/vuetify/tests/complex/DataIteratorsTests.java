package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.DataIteratorDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.vuetify.elements.complex.tables.DataIterator.groupedElements;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.dataIteratorsPage;
import static io.github.com.enums.TableTestData.CUPCAKE;
import static io.github.com.enums.TableTestData.DONUT;
import static io.github.com.enums.TableTestData.FROZEN_YOGURT;
import static io.github.com.enums.TableTestData.JELLY_BEAN;
import static io.github.com.enums.TableTestData.LOLLIPOP;
import static io.github.com.pages.DataIteratorsPage.defaultDataIterator;
import static io.github.com.pages.DataIteratorsPage.defaultDataIteratorSingleSelect;
import static io.github.com.pages.DataIteratorsPage.filterDataIterator;
import static io.github.com.pages.DataIteratorsPage.headerFooterDataIterator;
import static io.github.com.pages.DataIteratorsPage.loadingTextDataIterator;
import static io.github.com.pages.DataIteratorsPage.noDataTextDataIterator;
import static io.github.com.pages.DataIteratorsPage.noResultsTextDataIterator;
import static io.github.com.pages.DataIteratorsPage.noResultsTextSearchField;
import static io.github.com.pages.DataIteratorsPage.singleSelectTableIterator;
import static org.hamcrest.Matchers.containsString;

public class DataIteratorsTests extends TestsInit {

    @BeforeClass
    public void setup() {
        dataIteratorsPage.open();
        waitCondition(() -> dataIteratorsPage.isOpened());
        dataIteratorsPage.checkOpened();
    }

    @Test(description = "Test checks data iterator column title")
    public static void columnTitleDataIteratorTest() {
        headerFooterDataIterator.show();
        headerFooterDataIterator.item(1).has().title(FROZEN_YOGURT.value());
        headerFooterDataIterator.item(4).has().title(CUPCAKE.value());
    }

    @Test(description = "Test checks if column is expanded or collapsed")
    public static void expandCollapseDataIteratorTest() {
        defaultDataIterator.item(1).expand();
        defaultDataIterator.item(3).expand();

        defaultDataIterator.item(1).is().expanded().and().hasContent();
        defaultDataIterator.item(3).is().expanded().and().hasContent();

        defaultDataIteratorSingleSelect.check();
        defaultDataIterator.item(1).collapse();
        defaultDataIterator.item(1).is().collapsed();
        defaultDataIterator.item(3).is().collapsed();
    }

    @Test(description = "Test checks data iterator header and footer")
    public static void headerFooterTest() {
        headerFooterDataIterator.show();
        List<ToolBar> headers = headerFooterDataIterator.headers();
        headers.get(0)
                .has().text("This is a header")
                .and().darkTheme();
        headers.get(1)
                .has().text("This is a footer")
                .and().darkTheme();
    }

    @Test(description = "Test checks data iterator sort")
    public static void filterDataIteratorTest() {
        filterDataIterator.filterDataSearchField.text(FROZEN_YOGURT.value());
        filterDataIterator.item(1).has().title(FROZEN_YOGURT.value());
        filterDataIterator.filterDataSearchField.text(DONUT.value());
        filterDataIterator.item(1).has().title(DONUT.value());
        filterDataIterator.filterDataSearchField.clear();
        filterDataIterator.item(1).has().title(CUPCAKE.value());
        filterDataIterator.item(2).has().title(DONUT.value());
        filterDataIterator.filterSortSelect.select("Name");
        filterDataIterator.sortAsc();
        filterDataIterator.item(1).has().title(CUPCAKE.value());
        filterDataIterator.item(2).has().title(DONUT.value());
        filterDataIterator.filterSortSelect.select("Carbs");
        filterDataIterator.sortDesc();
        filterDataIterator.item(1).has().title(LOLLIPOP.value());
        filterDataIterator.item(2).has().title(JELLY_BEAN.value());
    }

    @Test(description = "Test checks that data iterator is single select")
    public void singleSelectDataIteratorTest() {
        singleSelectTableIterator.show();
        singleSelectTableIterator.item(1).check();
        singleSelectTableIterator.item(1).is().checked();
        singleSelectTableIterator.item(2).check();
        singleSelectTableIterator.item(1).is().unchecked();
        singleSelectTableIterator.item(2).is().checked();
    }

    @Test(description = "Test checks data iterator parameter : No data text")
    public void noDataTextDataIteratiorTest() {
        noDataTextDataIterator.show();
        noDataTextDataIterator.has().text(containsString("Sorry, there's no any items data..."));
    }

    @Test(description = "Test checks data iterator parameter : No results text")
    public void noResultsTextDataIteratiorTest() {
        noResultsTextSearchField.show();
        noResultsTextSearchField.clear();
        noResultsTextDataIterator.elements().is().notEmpty();
        noResultsTextSearchField.text("abcd");
        noResultsTextDataIterator.has().text(containsString("Sorry, nothing found :("));
    }

    @Test(description = "Test checks data iterator parameter : Loading text")
    public void loadingTextDataIteratiorTest() {
        loadingTextDataIterator.show();
        loadingTextDataIterator.has().text(containsString("Items are loading, please, wait a little bit..."));
    }

    @Test(description = "Test checks data iterator pagination")
    public void dataIteratorPaginationTest() {
        filterDataIterator.has().numberOfElements(4);
        filterDataIterator.nextPage.click();
        filterDataIterator.nextPage.click();
        filterDataIterator.has().numberOfElements(2);
        filterDataIterator.previousPage.click();
        filterDataIterator.itemsPerPage.select("8");
        filterDataIterator.has().numberOfElements(2);
    }
}

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
import static io.github.com.pages.DataIteratorsPage.filterCard;
public class DataIteratorsTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        dataIteratorsPage.open();
        waitCondition(() -> dataIteratorsPage.isOpened());
        dataIteratorsPage.checkOpened();
    }

    @Test
    public static void defaultDataIteratorTest() {
        defaultDataIteratorSingleSelect.is().unchecked();
        defaultDataIterator.expandColumn(1);
        defaultDataIterator.expandColumn(3);
        defaultDataIterator.assertThat().columnExpanded(1).and().columnNotEmpty(1);
        defaultDataIterator.assertThat().columnExpanded(3).and().columnNotEmpty(3);
        defaultDataIteratorSingleSelect.check();
        defaultDataIteratorSingleSelect.is().checked();
        defaultDataIterator.collapseColumn(1);
        defaultDataIterator.assertThat().columnCollapsed(1).and().columnCollapsed(3);
    }

    @Test
    public static void headerFooterDataIteratorTest() {
        headerFooterDataIterator.assertThat().columnTitle(1, FROZEN_YOGURT.value())
                .and().columnNotEmpty(1);
        headerFooterDataIterator.assertThat().columnTitle(2, ICE_CREAM_SANDWICH.value())
                .and().columnNotEmpty(2);
        headerFooterDataIterator.assertThat().columnTitle(3, ECLAIR.value())
                .and().columnNotEmpty(3);
        headerFooterDataIterator.assertThat().columnTitle(4, CUPCAKE.value())
                .and().columnNotEmpty(4);

        headerFooterDataIterator.assertThat().header("This is a header");
        headerFooterDataIterator.assertThat().footer("This is a footer");
    }

    @Test
    public static void filterDataIteratorTest() {
        String invalidKeySearch = "non-existing data";

        filterDataIterator.filterDataSearchField.clearAndTypeText(FROZEN_YOGURT.value());
        filterDataIterator.has().columnTitle(1, FROZEN_YOGURT.value());
        filterDataIterator.filterDataSearchField.clearAndTypeText(DONUT.value());
        filterDataIterator.has().columnTitle(1, DONUT.value());

        filterDataIterator.filterDataSearchField.clearAndTypeText(invalidKeySearch);
        filterDataIterator.assertThat().noResultsText();

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
        filterDataIterator.assertThat().groupByItem("Carbs");
        filterCard.is().isLightTheme();

        filterDataIterator.itemsPerPage.select("8");
        filterDataIterator.has().number(8);

        filterDataIterator.nextPage.click();
        filterDataIterator.has().number(2);
    }
}

package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.dataIteratorsPage;
import static io.github.com.pages.DataIteratorsPage.defaultDataIterator;
import static io.github.com.pages.DataIteratorsPage.defaultDataIteratorExpandSingleItemButton;
import static io.github.com.pages.DataIteratorsPage.filterDataIterator;
import static io.github.com.pages.DataIteratorsPage.headerFooterDataIterator;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DataIteratorsTests extends TestsInit {

    @BeforeSuite
    public static void setup() {
        dataIteratorsPage.open();
    }

    @Test
    public static void defaultDataIteratorTest() {

        defaultDataIterator.getAllColumns();
        defaultDataIterator.is().expanded(1).and().notEmpty(1);
        defaultDataIterator.is().expanded(2).and().notEmpty(2);
        defaultDataIterator.is().expanded(3).and().notEmpty(3);
        defaultDataIterator.is().expanded(4).and().notEmpty(4);

        defaultDataIteratorExpandSingleItemButton.click();
        defaultDataIterator.closeColumn(1);

        defaultDataIterator.is().closed(1).and().empty(1);
        defaultDataIterator.is().closed(2).and().empty(2);
        defaultDataIterator.is().closed(3).and().empty(3);
        defaultDataIterator.is().closed(4).and().empty(4);
    }

    @Test
    public static void headerFooterDataIteratorTest() {
        jdiAssert(headerFooterDataIterator.getColumnTitle(1), Matchers.is("Frozen Yogurt"));
        headerFooterDataIterator.is().notEmpty(1);
        jdiAssert(headerFooterDataIterator.getColumnTitle(2), Matchers.is("Ice cream sandwich"));
        headerFooterDataIterator.is().notEmpty(2);
        jdiAssert(headerFooterDataIterator.getColumnTitle(3), Matchers.is("Eclair"));
        headerFooterDataIterator.is().notEmpty(3);
        jdiAssert(headerFooterDataIterator.getColumnTitle(4), Matchers.is("Cupcake"));
        headerFooterDataIterator.is().notEmpty(4);

        jdiAssert(headerFooterDataIterator.getHeader(), Matchers.is("This is a header"));
        jdiAssert(headerFooterDataIterator.getFooter(), Matchers.is("This is a footer"));
    }

    @Test
    public static void filterDataIteratorTest() {
        filterDataIterator.search("Frozen Yogurt");
        jdiAssert(filterDataIterator.getColumnTitle(1), Matchers.is("Frozen Yogurt"));
        filterDataIterator.search("Donut");
        jdiAssert(filterDataIterator.getColumnTitle(1), Matchers.is("Donut"));
        filterDataIterator.clear();

        filterDataIterator.sortAscend("Name");
        jdiAssert(filterDataIterator.getColumnTitle(1), Matchers.is("Cupcake"));
        jdiAssert(filterDataIterator.getColumnTitle(2), Matchers.is("Donut"));

        filterDataIterator.sortDescend("Carbs");
        jdiAssert(filterDataIterator.getColumnTitle(1), Matchers.is("Lollipop"));
        jdiAssert(filterDataIterator.getColumnTitle(2), Matchers.is("Jelly bean"));

        filterDataIterator.quantityColumnsOnPage("8");
        jdiAssert(filterDataIterator.getAllColumns().size(), Matchers.is(8));

        filterDataIterator.nextPage();
        jdiAssert(filterDataIterator.getAllColumns().size(), Matchers.is(2));
    }
}

package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.selectsPage;
import static io.github.com.pages.SelectsPage.appendAndPrependItemSelect;
import static io.github.com.pages.SelectsPage.prependedIconSelect;
import static io.github.com.pages.SelectsPage.multipleSelect;
import static io.github.com.pages.SelectsPage.disabledSelect;
import static io.github.com.pages.SelectsPage.readonlySelect;
import static io.github.com.pages.SelectsPage.customSelect;
import static io.github.com.pages.SelectsPage.selectionSelect;

public class SelectsTests extends TestsInit {

    @BeforeClass
    public void before() {
        selectsPage.open();
        waitCondition(() -> selectsPage.isOpened());
        selectsPage.checkOpened();
    }

    @Test(description = "Test checks basic functionality of simple select")
    public void basicFunctionalityTest() {
        customSelect.show();
        customSelect.is().displayed();
        customSelect.expand();
        customSelect.is().expanded();

        customSelect.select("New York");
        customSelect.is().selected("New York");

        customSelect.is().collapsed();
    }

    @Test(description = "Test checks that select has prepended icon")
    public void pretendedIconSelectTest() {
        prependedIconSelect.show();
        prependedIconSelect.icon().is().displayed();
    }

    @Test(description = "Test checks that multiple selection select has expected hint and set of values")
    public void multipleSelectTest() {
        multipleSelect.show();
        multipleSelect.label().has().text("Select");
        multipleSelect.hint().has().text("Pick your favorite states");

        multipleSelect.select("Alaska");
        multipleSelect.select("American Samoa");
        multipleSelect.is().selected(Matchers.containsString("Alaska"));
        multipleSelect.is().selected("Alaska,American Samoa");
        multipleSelect.close();
    }

    @Test(description = "Test checks that select is disabled and has expected label")
    public void disableSelectTest() {
        disabledSelect.show();
        disabledSelect.is().disabled();
        disabledSelect.label().has().text("Disabled");
    }

    @Test(description = "Test checks that select is read-only it can not be expanded")
    public void readOnlySelectTest() {
        readonlySelect.show();
        readonlySelect.is().classValue(Matchers.containsString("readonly"));

        readonlySelect.expand();
        readonlySelect.is().collapsed();
    }

    @Test(description = "Test checks that only first selected value is shown and others are counted")
    public void selectionSelectTest() {
        selectionSelect.show();
        selectionSelect.select("buzz");
        selectionSelect.selection().is().text("(+3 others)");
    }

    @Test(enabled = false, description = "select close doe not work")
    public void appendAndPrependItemSelectTest() {
        appendAndPrependItemSelect.show();
        waitCondition(() -> appendAndPrependItemSelect.isDisplayed());
        appendAndPrependItemSelect.select(1);
        // close does not work
        appendAndPrependItemSelect.close();
        appendAndPrependItemSelect.is().selected("Apples,Apricots,Avocado,Bananas,"
                + "Blueberries,Blackberries,Boysenberries,Bread fruit,Cantaloupes (cantalope),"
                + "Cherries,Cranberries,Cucumbers,Currants,Dates,Eggplant,Figs,Grapes,Grapefruit,"
                + "Guava,Honeydew melons,Huckleberries,Kiwis,Kumquat,Lemons,Limes,Mangos,Mulberries,"
                + "Muskmelon,Nectarines,Olives,Oranges,Papaya,Peaches,Pears,Persimmon,Pineapple,Plums,"
                + "Pomegranate,Raspberries,Rose Apple,Starfruit,Strawberries,Tangerines,Tomatoes,Watermelons,"
                + "Zucchini");
    }

    //to check failing tests for CI run- 31 01 23
}

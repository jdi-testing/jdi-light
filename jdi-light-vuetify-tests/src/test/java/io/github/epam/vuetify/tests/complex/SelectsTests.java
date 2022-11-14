package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
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

    @BeforeMethod
    public void before() {
        selectsPage.open();
        waitCondition(() -> selectsPage.isOpened());
        selectsPage.checkOpened();
    }

    @Test
    public void basicFunctionalityTest() {
        customSelect.is().displayed();
        customSelect.expand();
        customSelect.is().expanded();

        customSelect.select("New York");
        customSelect.is().selected("New York");

        customSelect.is().collapsed();
    }

    @Test
    public void pretendedIconSelectTest() {
        prependedIconSelect.show();
        prependedIconSelect.icon().is().displayed();
    }

    @Test
    public void multipleSelectTest() {
        multipleSelect.has().hasLabel();
        multipleSelect.label().has().text("Select");
        multipleSelect.hint().has().text("Pick your favorite states");

        multipleSelect.select("Alaska");
        multipleSelect.select("American Samoa");
        multipleSelect.is().selected(Matchers.containsString("Alaska"));
        multipleSelect.is().selected("Alaska,American Samoa");
        multipleSelect.close();
    }

    @Test
    public void disableSelectTest() {
        disabledSelect.is().disabled();
        disabledSelect.has().hasLabel();
        disabledSelect.label().has().text("Disabled");
    }

    @Test
    public void readOnlySelectTest() {
        readonlySelect.is().classValue(Matchers.containsString("readonly"));

        readonlySelect.expand();
        readonlySelect.is().collapsed();
    }

    @Test
    public void customSelectTest() {
        customSelect.select("Georgia");
        customSelect.is().selected("Georgia");
    }

    @Test
    public void selectionSelectTest() {
        selectionSelect.select("buzz");
        selectionSelect.selection().is().text("(+3 others)");
    }

    @Test
    public void appendAndPrependItemSelectTest() {
        waitCondition(() -> appendAndPrependItemSelect.isDisplayed());
        appendAndPrependItemSelect.select(1);
        appendAndPrependItemSelect.is().selected("Apples,Apricots,Avocado,Bananas,"
                + "Blueberries,Blackberries,Boysenberries,Bread fruit,Cantaloupes (cantalope),"
                + "Cherries,Cranberries,Cucumbers,Currants,Dates,Eggplant,Figs,Grapes,Grapefruit,"
                + "Guava,Honeydew melons,Huckleberries,Kiwis,Kumquat,Lemons,Limes,Mangos,Mulberries,"
                + "Muskmelon,Nectarines,Olives,Oranges,Papaya,Peaches,Pears,Persimmon,Pineapple,Plums,"
                + "Pomegranate,Raspberries,Rose Apple,Starfruit,Strawberries,Tangerines,Tomatoes,Watermelons,"
                + "Zucchini");
    }
}

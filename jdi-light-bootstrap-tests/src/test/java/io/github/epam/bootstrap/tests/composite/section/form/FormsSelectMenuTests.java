package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formsSelectMenu;
import static io.github.com.pages.BootstrapPage.formsSelectMenuLarge;
import static io.github.com.pages.BootstrapPage.formsSelectMenuMultiple;
import static io.github.com.pages.BootstrapPage.formsSelectMenuSize;
import static io.github.com.pages.BootstrapPage.formsSelectMenuSmall;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.AssertJUnit.assertEquals;

public class FormsSelectMenuTests extends TestsInit {

    @DataProvider
    public Object[][] optionFormSelectMenuTest() {
        return new Object[][]{
                {1, "Open this select menu", "Open this select menu"},
                {2, "One", "1"},
                {3, "Two", "2"},
                {4, "Three", "3"},
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        bsPage.refresh();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(formsSelectMenuLarge);
        baseValidation(formsSelectMenu);
        baseValidation(formsSelectMenuSmall);
        baseValidation(formsSelectMenuMultiple);
        baseValidation(formsSelectMenuSize);
    }

    @Test
    public void isValidationTest() {
        formsSelectMenuLarge.is().displayed();
        formsSelectMenuLarge.is().enabled();
        formsSelectMenuLarge.assertThat().displayed()
                .core()
                .css("font-size", is("20px"))
                .hasClass("custom-select-lg")
                .tag(is("select"));

        formsSelectMenu.is().displayed();
        formsSelectMenu.is().enabled();
        formsSelectMenu.assertThat().displayed()
                .core()
                .css("font-size", is("16px"))
                .hasClass("custom-select")
                .tag(is("select"));

        formsSelectMenuSmall.is().displayed();
        formsSelectMenuSmall.is().enabled();
        formsSelectMenuSmall.assertThat().displayed()
                .core()
                .css("font-size", is("14px"))
                .hasClass("custom-select-sm")
                .tag(is("select"));

        formsSelectMenuMultiple.is().displayed();
        formsSelectMenuMultiple.is().enabled();
        formsSelectMenuMultiple.assertThat().displayed()
                .core()
                .css("font-size", is("16px"))
                .hasClass("custom-select")
                //.hasAttr("multiple")
                .tag(is("select"));

        formsSelectMenuSize.is().displayed();
        formsSelectMenuSize.is().enabled();
        formsSelectMenuSize.assertThat().displayed()
                .core()
                .css("font-size", is("16px"))
                .hasClass("custom-select")
                .attr("size", "3")
                .tag(is("select"));
    }

    @Test(dataProvider = "optionFormSelectMenuTest")
    public void getTextFormsSelectMenuTest(int i, String optionText, String value) {
        formsSelectMenuLarge.optionsSelectMenu.get(i).is().text(optionText);
        formsSelectMenuLarge.optionsSelectMenu.get(i).assertThat().attr("value", value);

        formsSelectMenu.optionsSelectMenu.get(i).is().text(optionText);
        formsSelectMenu.optionsSelectMenu.get(i).assertThat().attr("value", value);

        formsSelectMenuSmall.optionsSelectMenu.get(i).is().text(optionText);
        formsSelectMenuSmall.optionsSelectMenu.get(i).assertThat().attr("value", value);

        formsSelectMenuMultiple.optionsSelectMenu.get(i).is().text(optionText);
        formsSelectMenuMultiple.optionsSelectMenu.get(i).assertThat().attr("value", value);

        formsSelectMenuSize.optionsSelectMenu.get(i).is().text(optionText);
        formsSelectMenuSize.optionsSelectMenu.get(i).assertThat().attr("value", value);
    }

    @Test
    public void getSelectedOptionFormsSelectMenuTest() {
        formsSelectMenuLarge.selectedOptionsSelectMenu.is().text("Open this select menu");
        formsSelectMenu.selectedOptionsSelectMenu.is().text("Open this select menu");
        formsSelectMenuSmall.selectedOptionsSelectMenu.is().text("Open this select menu");
        formsSelectMenuMultiple.selectedOptionsSelectMenu.is().text("Open this select menu");
        formsSelectMenuSize.selectedOptionsSelectMenu.is().text("Open this select menu");
    }

    @Test
    public void selectOptionFormsSelectMenuTest() {
        formsSelectMenuLarge.optionsSelectMenu.get(3).click();
        assertEquals(formsSelectMenuLarge.getValue(), "Two");

        formsSelectMenu.optionsSelectMenu.get(2).click();
        assertEquals(formsSelectMenu.getValue(), "One");

        formsSelectMenuSmall.optionsSelectMenu.get(3).click();
        assertEquals(formsSelectMenuSmall.getValue(), "Two");

        formsSelectMenuSize.optionsSelectMenu.get(4).click();
        assertEquals(formsSelectMenuSize.getValue(), "Three");
    }
}

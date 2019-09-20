package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.customSelect;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class InputGroupCustomSelect extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String optionText = "Options";

    @Test
    public void isValidationOptionsSectionTests() {
        customSelect.optionText.is().text(optionText);
        customSelect.optionText.is()
                .core()
                .hasClass("input-group-prepend")
                .css("font-size", is("14px"))
                .tag("div");
    }

    @Test
    public void selectorByIndexTests() {
        customSelect.selector.is().selected("Choose...");
        customSelect.selector.select(2);
        customSelect.selector.is().selected("One");
        customSelect.selector.select(3);
        customSelect.selector.is().selected("Two");
        customSelect.selector.select(4);
        customSelect.selector.is().selected("Three");
        customSelect.selector.select(1);
        customSelect.selector.is().selected("Choose...");
    }

    @Test(priority = 1)
    public void selectorByValueTests() {
        customSelect.selector.is().selected("Choose...");
        customSelect.selector.select("One");
        customSelect.selector.is().selected("One");
        customSelect.selector.select("Two");
        customSelect.selector.is().selected("Two");
        customSelect.selector.select("Three");
        customSelect.selector.is().selected("Three");
    }

    @Test
    public void selectorIsValidationTests() {
        customSelect.selector.is().displayed()
                .enabled()
                .core()
                .hasClass("custom-select")
                .css("font-size", is("16px"));;
        customSelect.selector.is().size(4);
    }
}

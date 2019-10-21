package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formsSelectMenu;
import static io.github.com.pages.BootstrapPage.formsSelectMenuLarge;
import static io.github.com.pages.BootstrapPage.formsSelectMenuMultiple;
import static io.github.com.pages.BootstrapPage.formsSelectMenuSize;
import static io.github.com.pages.BootstrapPage.formsSelectMenuSmall;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class FormsSelectMenuTests extends TestsInit {

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
                .attr("multiple","true")
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
}

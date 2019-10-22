package io.github.epam.bootstrap.tests.complex.dropdown;

import com.epam.jdi.light.elements.common.Alerts;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Dropdown;
import io.github.com.sections.dropdown.StaticDropdownMenu;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.dropdownMenuItemsSection;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class DropdownMenuItemsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationTest() {
        //Dropdown
        Dropdown dropdown = dropdownMenuItemsSection.getDropdown();
        baseValidation(dropdown);
        dropdown.unhighlight();

        baseValidation(dropdown.dropdownToggle);
        dropdown.dropdownToggle.unhighlight();

        dropdown.dropdownToggle.click();

        baseValidation(dropdown.dropdownMenu);
        dropdown.dropdownMenu.unhighlight();

        for(UIElement item : dropdown.items) {
            baseValidation(item);
            item.unhighlight();
        }

        dropdown.dropdownToggle.click();

        //Static Dropdown Menu
        StaticDropdownMenu staticDropdownMenu = dropdownMenuItemsSection.getMenuWithText();
        baseValidation(staticDropdownMenu);
        staticDropdownMenu.unhighlight();
        for(UIElement item : staticDropdownMenu.getItems()) {
            baseValidation(item);
            item.unhighlight();
        }
    }

    @DataProvider(name = "buttonsTestData")
    public Object[][] buttonsTestData() {
        return new Object[][] {
                {"Action", "Action"},
                {"Another action", "Another action"},
                {"Something else here", "One more action"}
        };
    }

    @Test(dataProvider = "buttonsTestData")
    public void dropdownButtonsTest(String itemText, String alertText) {
        Dropdown dropdown = dropdownMenuItemsSection.getDropdown();
        dropdown.dropdownToggle.click();
        dropdown.dropdownMenu.waitFor().displayed();

        UIElement button = dropdown.items.get(itemText);
        button.click();
        Alerts.validateAlert(Matchers.is(alertText));
    }

    @Test
    public void plainTextElementTest() {
        StaticDropdownMenu staticDropdownMenu = dropdownMenuItemsSection.getMenuWithText();
        WebList items = staticDropdownMenu.getItems();
        UIElement textItem = items.get("Dropdown item text");
        textItem.assertThat()
                .enabled()
                .text("Dropdown item text")
                .tag("span");
    }

}

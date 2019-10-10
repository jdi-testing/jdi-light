package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.simpleDropdown;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Daniil Kopylov on 03.10.2019
 * Email: daniil_kopylov@epam.com
 */

public class DrowdownTests extends TestsInit {
    private static final String DROPDOWN = "Dropdown";

    private static final String FIRSTITEM = "Action";
    private static final String SECONDITEM = "Another\n                                        action";
    private static final String LASTITEM = "Separated link";
    private static final String ITEMS_VALUES = String.format("%s,%s,%s", FIRSTITEM, SECONDITEM, LASTITEM);

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTextTest() {
        assertEquals(simpleDropdown.getText(), DROPDOWN);
    }

    @Test
    public void getValueTest() {
        assertEquals(simpleDropdown.getValue(), DROPDOWN);
    }

    @Test
    public void itemsTest() {
        assertEquals(simpleDropdown.items.getValue(), ITEMS_VALUES);
    }

    @Test
    public void clickTest() {
        simpleDropdown.click();
        simpleDropdown.items.is().displayed();
        assertTrue(simpleDropdown.items.isDisplayed());
    }

    @Test
    public void toggleTest() {
        simpleDropdown.dropdownToggle.click();
        simpleDropdown.items.is().displayed();
        assertTrue(simpleDropdown.items.isDisplayed());
    }

    @Test
    public void simpleDropdownIsValidationTest() {
        simpleDropdown.is()
                .core()
                .cssClass("dropdown")
                .tag(is("div"));
        simpleDropdown.dropdownMenu.is()
                .core()
                .cssClass("dropdown-menu")
                .attr("x-placement", "bottom-start")
                .tag(is("div"));
        simpleDropdown.dropdownToggle.is()
                .core()
                .cssClass("btn btn-primary dropdown-toggle")
                .attr("data-toggle", "dropdown")
                .tag(is("button"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(simpleDropdown);
    }

}

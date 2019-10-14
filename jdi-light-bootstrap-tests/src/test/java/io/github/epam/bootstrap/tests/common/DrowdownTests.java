package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;
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
                .tag(is("div"));
        simpleDropdown.dropdownToggle.is()
                .core()
                .cssClass(containsString("btn"))
                .cssClass(containsString("btn-primary"))
                .cssClass(containsString("dropdown-toggle"))
                .attr("data-toggle", "dropdown")
                .tag(is("button"));
    }

    @Test
    public void linkDropdownIsValidationTest() {
        linkDropdown.dropdownToggle.is()
                .core()
                .tag(is("a"));
    }

    @Test
    public void primaryDropdownIsValidationTest() {
        primaryDropdown.dropdownToggle.is()
                .core()
                .cssClass(containsString("btn-primary"))
                .css("color", is("rgba(255, 255, 255, 1)")) //#fff Color Hex
                .css("background-color", is("rgba(0, 123, 255, 1)")) //#007bff Color Hex
                .css("border-color", is("rgb(0, 123, 255)")); //#007bff Color Hex
    }

    @Test
    public void successDropdownIsValidationTest() {
        successDropdown.dropdownToggle.is()
                .core()
                .cssClass(containsString("btn-success"))
                .css("color", is("rgba(255, 255, 255, 1)")) //#fff Color Hex
                .css("background-color", is("rgba(40, 167, 69, 1)")) //#28a745 Color Hex
                .css("border-color", is("rgb(40, 167, 69)")); //#28a745 Color Hex
    }

    @Test
    public void infoDropdownIsValidationTest() {
        infoDropdown.dropdownToggle.is()
                .core()
                .cssClass(containsString("btn-info"))
                .css("color", is("rgba(255, 255, 255, 1)")) //#fff Color Hex
                .css("background-color", is("rgba(23, 162, 184, 1)")) //#28a745 Color Hex
                .css("border-color", is("rgb(23, 162, 184)")); //#28a745 Color Hex
    }

    @Test
    public void splitDropdownIsValidationTest() {
        splitDropdown.dropdownToggle.is()
                .core()
                .cssClass(containsString("dropdown-toggle-split"));
    }

    @Test
    public void largeDropdownIsValidationTest() {
        largeDropdown.dropdownToggle.is()
                .core()
                .cssClass(containsString("btn-lg"))
                .css("padding", is("8px 16px"))
                .css("font-size", is("20px"))
                .css("line-height", is("30px"))
                .css("border-radius", is("4.8px"));
    }

    @Test
    public void largeSplitDropdownIsValidationTest() {
        largeSplitDropdown.dropdownToggle.is()
                .core()
                .cssClass(containsString("btn-lg"))
                .cssClass(containsString("dropdown-toggle-split"))
                .css("padding", is("8px 12px"))
                .css("font-size", is("20px"))
                .css("line-height", is("30px"))
                .css("border-radius", is("0px 4.8px 4.8px 0px"));
    }

    @Test
    public void smallDropdownIsValidationTest() {
        smallDropdown.dropdownToggle.is()
                .core()
                .cssClass(containsString("btn-sm"))
                .css("padding", is("4px 8px"))
                .css("font-size", is("14px"))
                .css("line-height", is("21px"))
                .css("border-radius", is("3.2px"));
    }

    @Test
    public void smallSplitDropdownIsValidationTest() {
        smallSplitDropdown.dropdownToggle.is()
                .core()
                .cssClass(containsString("btn-sm"))
                .cssClass(containsString("dropdown-toggle-split"))
                .css("padding", is("4px 6px"))
                .css("font-size", is("14px"))
                .css("line-height", is("21px"))
                .css("border-radius", is("0px 3.2px 3.2px 0px"));
    }

    @Test
    public void dropUpDropdownIsValidationTest() {
        dropUpDropdown.is()
                .core()
                .cssClass(containsString("dropup"));
        dropUpDropdown.dropdownMenu.is()
                .core()
                .css("top", is("auto"))
                .css("bottom", is("100%"));
    }

    @Test
    public void dropUpSplitDropdownIsValidationTest() {
        dropUpSplitDropdown.is()
                .core()
                .cssClass(containsString("dropup"));
        dropUpSplitDropdown.dropdownMenu.is()
                .core()
                .css("top", is("auto"))
                .css("bottom", is("100%"));
    }

    @Test
    public void dropRightDropdownIsValidationTest() {
        dropRightDropdown.is()
                .core()
                .cssClass(containsString("dropright"));
        dropRightDropdown.dropdownMenu.is()
                .core()
                .css("right", is("auto"))
                .css("left", is("100%"));
    }

    @Test
    public void dropRightSplitDropdownIsValidationTest() {
        dropRightSplitDropdown.is()
                .core()
                .cssClass(containsString("dropright"));
        dropRightSplitDropdown.dropdownMenu.is()
                .core()
                .css("right", is("auto"))
                .css("left", is("100%"));
    }

    @Test
    public void dropLeftDropdownIsValidationTest() {
        dropLeftDropdown.is()
                .core()
                .cssClass(containsString("dropleft"));
        dropLeftDropdown.dropdownMenu.is()
                .core()
                .css("left", is("auto"))
                .css("right", is("100%"));
    }

    @Test
    public void dropLeftSplitDropdownIsValidationTest() {
        dropLeftSplitDropdown.dropdownMenu.is()
                .core()
                .css("left", is("auto"))
                .css("right", is("100%"));
    }

    @Test
    public void rightAllignedDropdownIsValidationTest() {
        rightAllignedDropdown.dropdownMenu.is()
                .core()
                .cssClass(containsString("dropdown-menu-right"));
    }

    @Test
    public void leftAllignedDropdownIsValidationTest() {
        leftAllignedDropdown.dropdownMenu.is()
                .core()
                .cssClass(containsString("dropdown-menu-lg-left"))
                .css("right", is("auto"))
                .css("left", is("0px"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(simpleDropdown);
    }

}

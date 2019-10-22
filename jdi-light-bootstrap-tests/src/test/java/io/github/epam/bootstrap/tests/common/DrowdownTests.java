package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.simpleDropdown;
import static io.github.com.pages.BootstrapPage.linkDropdown;
import static io.github.com.pages.BootstrapPage.primaryDropdown;
import static io.github.com.pages.BootstrapPage.successDropdown;
import static io.github.com.pages.BootstrapPage.infoDropdown;
import static io.github.com.pages.BootstrapPage.splitDropdown;
import static io.github.com.pages.BootstrapPage.largeDropdown;
import static io.github.com.pages.BootstrapPage.largeSplitDropdown;
import static io.github.com.pages.BootstrapPage.smallDropdown;
import static io.github.com.pages.BootstrapPage.smallSplitDropdown;
import static io.github.com.pages.BootstrapPage.dropUpDropdown;
import static io.github.com.pages.BootstrapPage.dropUpSplitDropdown;
import static io.github.com.pages.BootstrapPage.dropRightDropdown;
import static io.github.com.pages.BootstrapPage.dropRightSplitDropdown;
import static io.github.com.pages.BootstrapPage.dropLeftDropdown;
import static io.github.com.pages.BootstrapPage.dropLeftSplitDropdown;
import static io.github.com.pages.BootstrapPage.rightAllignedDropdown;
import static io.github.com.pages.BootstrapPage.leftAllignedDropdown;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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

    private static final String COLOR = "color";
    private static final String BACKGROUNDCOLOR = "background-color";
    private static final String BORDERCOLOR = "border-color";
    private static final String PADDING = "padding";
    private static final String FONTSIZE = "font-size";
    private static final String LINEHEIGHT = "line-height";
    private static final String BORDERRADIUS = "border-radius";
    private static final String TOP = "top";
    private static final String BOTTOM = "bottom";
    private static final String LEFT = "left";
    private static final String RIGHT = "right";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTextTest() {
        assertThat(simpleDropdown.getText(), is(DROPDOWN));
    }

    @Test
    public void getValueTest() {
        assertThat(simpleDropdown.getValue(), is(DROPDOWN));
    }

    @Test
    public void itemsTest() {
        assertThat(simpleDropdown.items.getValue(), is(ITEMS_VALUES));
    }

    @Test
    public void clickTest() {
        simpleDropdown.click();
        simpleDropdown.items.is().displayed();
        assertThat(simpleDropdown.items.isDisplayed(), is(Boolean.TRUE));
    }

    @Test
    public void toggleTest() {
        simpleDropdown.dropdownToggle.click();
        simpleDropdown.items.is().displayed();
        assertThat(simpleDropdown.items.isDisplayed(), is(Boolean.TRUE));
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
                .hasClass("btn")
                .hasClass("btn-primary")
                .hasClass("dropdown-toggle")
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
                .hasClass("btn-primary")
                .css(COLOR, is("rgba(255, 255, 255, 1)")) //#fff Color Hex
                .css(BACKGROUNDCOLOR, is("rgba(0, 123, 255, 1)")) //#007bff Color Hex
                .css(BORDERCOLOR, is("rgb(0, 123, 255)")); //#007bff Color Hex
    }

    @Test
    public void successDropdownIsValidationTest() {
        successDropdown.dropdownToggle.is()
                .core()
                .hasClass("btn-success")
                .css(COLOR, is("rgba(255, 255, 255, 1)")) //#fff Color Hex
                .css(BACKGROUNDCOLOR, is("rgba(40, 167, 69, 1)")) //#28a745 Color Hex
                .css(BORDERCOLOR, is("rgb(40, 167, 69)")); //#28a745 Color Hex
    }

    @Test
    public void infoDropdownIsValidationTest() {
        infoDropdown.dropdownToggle.is()
                .core()
                .hasClass("btn-info")
                .css(COLOR, is("rgba(255, 255, 255, 1)")) //#fff Color Hex
                .css(BACKGROUNDCOLOR, is("rgba(23, 162, 184, 1)")) //#28a745 Color Hex
                .css(BORDERCOLOR, is("rgb(23, 162, 184)")); //#28a745 Color Hex
    }

    @Test
    public void splitDropdownIsValidationTest() {
        splitDropdown.dropdownToggle.is()
                .core()
                .hasClass("dropdown-toggle-split");
    }

    @Test
    public void largeDropdownIsValidationTest() {
        largeDropdown.dropdownToggle.is()
                .core()
                .hasClass("btn-lg")
                .css(PADDING, is("8px 16px"))
                .css(FONTSIZE, is("20px"))
                .css(LINEHEIGHT, is("30px"))
                .css(BORDERRADIUS, is("4.8px"));
    }

    @Test
    public void largeSplitDropdownIsValidationTest() {
        largeSplitDropdown.dropdownToggle.is()
                .core()
                .hasClass("btn-lg")
                .hasClass("dropdown-toggle-split")
                .css(PADDING, is("8px 12px"))
                .css(FONTSIZE, is("20px"))
                .css(LINEHEIGHT, is("30px"))
                .css(BORDERRADIUS, is("0px 4.8px 4.8px 0px"));
    }

    @Test
    public void smallDropdownIsValidationTest() {
        smallDropdown.dropdownToggle.is()
                .core()
                .hasClass("btn-sm")
                .css(PADDING, is("4px 8px"))
                .css(FONTSIZE, is("14px"))
                .css(LINEHEIGHT, is("21px"))
                .css(BORDERRADIUS, is("3.2px"));
    }

    @Test
    public void smallSplitDropdownIsValidationTest() {
        smallSplitDropdown.dropdownToggle.is()
                .core()
                .hasClass("btn-sm")
                .hasClass("dropdown-toggle-split")
                .css(PADDING, is("4px 6px"))
                .css(FONTSIZE, is("14px"))
                .css(LINEHEIGHT, is("21px"))
                .css(BORDERRADIUS, is("0px 3.2px 3.2px 0px"));
    }

    @Test
    public void dropUpDropdownIsValidationTest() {
        dropUpDropdown.is()
                .core()
                .hasClass("dropup");
        dropUpDropdown.dropdownMenu.is()
                .core()
                .css(TOP, is("auto"))
                .css(BOTTOM, is("100%"));
    }

    @Test
    public void dropUpSplitDropdownIsValidationTest() {
        dropUpSplitDropdown.is()
                .core()
                .hasClass("dropup");
        dropUpSplitDropdown.dropdownMenu.is()
                .core()
                .css(TOP, is("auto"))
                .css(BOTTOM, is("100%"));
    }

    @Test
    public void dropRightDropdownIsValidationTest() {
        dropRightDropdown.is()
                .core()
                .hasClass("dropright");
        dropRightDropdown.dropdownMenu.is()
                .core()
                .css(RIGHT, is("auto"))
                .css(LEFT, is("100%"));
    }

    @Test
    public void dropRightSplitDropdownIsValidationTest() {
        dropRightSplitDropdown.is()
                .core()
                .hasClass("dropright");
        dropRightSplitDropdown.dropdownMenu.is()
                .core()
                .css(RIGHT, is("auto"))
                .css(LEFT, is("100%"));
    }

    @Test
    public void dropLeftDropdownIsValidationTest() {
        dropLeftDropdown.is()
                .core()
                .hasClass("dropleft");
        dropLeftDropdown.dropdownMenu.is()
                .core()
                .css(LEFT, is("auto"))
                .css(RIGHT, is("100%"));
    }

    @Test
    public void dropLeftSplitDropdownIsValidationTest() {
        dropLeftSplitDropdown.dropdownMenu.is()
                .core()
                .css(LEFT, is("auto"))
                .css(RIGHT, is("100%"));
    }

    @Test
    public void rightAllignedDropdownIsValidationTest() {
        rightAllignedDropdown.dropdownMenu.is()
                .core()
                .hasClass("dropdown-menu-right");
    }

    @Test
    public void leftAllignedDropdownIsValidationTest() {
        leftAllignedDropdown.dropdownMenu.is()
                .core()
                .hasClass("dropdown-menu-lg-left")
                .css(RIGHT, is("auto"))
                .css(LEFT, is("0px"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(simpleDropdown);
    }

}

package io.github.epam.bootstrap.tests.complex;

import com.epam.jdi.light.elements.common.Alerts;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Dropdown;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.elements.common.Alerts.*;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.offsetDropdown;
import static io.github.com.pages.BootstrapPage.referenceDropdown;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DropdownOptionsTests extends TestsInit {

    private static final String ITEM_ONE = "Action";
    private static final String ITEM_TWO = "Another action";
    private static final String ITEM_THREE = "Something else here";
    private static final String ITEM_FOUR = "Separated link";
    private static final String[] OFFSET_DROPDOWN_CONTENTS =  new String[]{ITEM_ONE, ITEM_TWO, ITEM_THREE};
    private static final String[] REFERENCE_DROPDOWN_CONTENTS =  new String[]{ITEM_ONE, ITEM_TWO, ITEM_THREE, ITEM_FOUR};

    @DataProvider
    public Object[][] dropdownData() {
        return new Object[][]{
                {offsetDropdown},
                {referenceDropdown}
        };
    }

    @DataProvider
    public Object[][] dropdownLinkData() {
        return new Object[][]{
                {offsetDropdown, OFFSET_DROPDOWN_CONTENTS},
                {referenceDropdown, REFERENCE_DROPDOWN_CONTENTS}
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "dropdownData")
    public void expandCollapseTest(Dropdown dropdown) {
        dropdown.expand();
        dropdown.is().expanded();
        dropdown.collapse();
        dropdown.is().collapsed();
    }

    @Test
    public void dropdownContentTest() {
        offsetDropdown.expand();
        offsetDropdown.assertThat()
                .itemValues(is(Arrays.asList(OFFSET_DROPDOWN_CONTENTS)))
                .hasItems(ITEM_ONE)
                .hasItems(ITEM_TWO)
                .hasItems(ITEM_THREE);

        referenceDropdown.expand();
        referenceDropdown.assertThat()
                .itemValues(is(Arrays.asList(REFERENCE_DROPDOWN_CONTENTS)))
                .hasItems(ITEM_ONE)
                .hasItems(ITEM_TWO)
                .hasItems(ITEM_THREE)
                .hasItems(ITEM_FOUR);
    }

    @Test(dataProvider = "dropdownLinkData")
    public void dropdownLinkTest(Dropdown dropdown, String[] alertTextArray) {
        dropdown.expand();
        dropdown.assertThat().itemValues(is(hasItems(alertTextArray)));
    }

}

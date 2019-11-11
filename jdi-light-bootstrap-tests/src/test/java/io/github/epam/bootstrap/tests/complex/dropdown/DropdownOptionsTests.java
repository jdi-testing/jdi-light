package io.github.epam.bootstrap.tests.complex.dropdown;

import com.epam.jdi.light.ui.bootstrap.elements.complex.Dropdown;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.offsetDropdown;
import static io.github.com.pages.BootstrapPage.referenceDropdown;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

public class DropdownOptionsTests extends TestsInit {

    private static final String ITEM_ONE = "Action";
    private static final String ITEM_TWO = "Another action";
    private static final String ITEM_THREE = "Something else here";
    private static final String ITEM_FOUR = "Separated link";
    private static final String APPENDIX = " clicked!";
    private static final String DATA_OFFSET = "data-offset";
    private static final String DATA_OFFSET_VALUE = "10,20";
    private static final String DATA_REFERENCE = "data-reference";
    private static final String DATA_REFERENCE_VALUE = "parent";
    private static final String[] OFFSET_DROPDOWN_CONTENTS = new String[]{ITEM_ONE, ITEM_TWO, ITEM_THREE};
    private static final String[] REFERENCE_DROPDOWN_CONTENTS = new String[]{ITEM_ONE, ITEM_TWO, ITEM_THREE, ITEM_FOUR};

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

    @Test(dataProvider = "dropdownLinkData")
    public void dropdownLinkTest(Dropdown dropdown, String[] linkArray) {
        for (int i = 1; i <= dropdown.list().size(); i++) {
            dropdown.expand();
            dropdown.list().get(i).click();
            validateAlert(is(linkArray[i - 1] + APPENDIX));
            dropdown.collapse();
        }
    }

    @Test
    public void dropdownContentTest() {
        offsetDropdown.expand();
        offsetDropdown.assertThat()
                .itemValues(OFFSET_DROPDOWN_CONTENTS)
                .hasItems(ITEM_ONE)
                .hasItems(ITEM_TWO)
                .hasItems(ITEM_THREE);

        referenceDropdown.expand();
        referenceDropdown.assertThat()
                .itemValues(REFERENCE_DROPDOWN_CONTENTS)
                .hasItems(ITEM_ONE)
                .hasItems(ITEM_TWO)
                .hasItems(ITEM_THREE)
                .hasItems(ITEM_FOUR);
    }

    @Test
    public void optionsCssTest() {
        offsetDropdown.expand();
        offsetDropdown.childs().get(1).assertThat().core().attr(DATA_OFFSET, is(DATA_OFFSET_VALUE));
        offsetDropdown.collapse();

        referenceDropdown.expand();
        referenceDropdown.childs().get(2).assertThat().core().attr(DATA_REFERENCE, is(DATA_REFERENCE_VALUE));
        referenceDropdown.collapse();
    }

}

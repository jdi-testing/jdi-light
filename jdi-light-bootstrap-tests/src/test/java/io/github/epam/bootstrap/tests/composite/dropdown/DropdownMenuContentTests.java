package io.github.epam.bootstrap.tests.composite.dropdown;

import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.composite.DropdownMenu;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.dropdownMenuContentDivider;
import static io.github.com.pages.BootstrapPage.dropdownMenuContentHeader;
import static io.github.com.pages.BootstrapPage.dropdownMenuContentText;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.hasItems;

public class DropdownMenuContentTests extends TestsInit {

    private static final String HEADER_TEXT = "DROPDOWN HEADER";
    private static final int NUMBER_OF_CHILDREN_HEADER = 3;
    private static final int NUMBER_OF_CHILDREN_DIVIDER = 4;
    private static final int NUMBER_OF_CHILDREN_TEXT = 2;
    private static final String TEXT_1_OF_DROPDOWN_TEXT = "Some example text that's free-flowing within the dropdown menu.";
    private static final String TEXT_2_OF_DROPDOWN_TEXT = "And this is more example text.";

    @DataProvider
    public Object[][] dropdownData() {
        return new Object[][]{
                {dropdownMenuContentHeader},
                {dropdownMenuContentDivider},
                {dropdownMenuContentText}
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "dropdownData")
    public void baseTest(DropdownMenu dropdown) {
        baseValidation(dropdown);
        dropdown.unhighlight();

        dropdown.expand();
        baseValidation(dropdown.expander());
        dropdown.expander().unhighlight();
        if (dropdown.equals(dropdownMenuContentText)) {
            for(Text text : dropdownMenuContentText.text) {
                baseValidation(text);
                text.unhighlight();
            }
        } else {
            for (UIElement item : dropdown.list()) {
                baseValidation(item);
                item.unhighlight();
            }
        }
        dropdown.collapse();
    }

    @Test
    public void checkHeaderTest() {
        dropdownMenuContentHeader.show();
        dropdownMenuContentHeader.is().displayed();
        dropdownMenuContentHeader.expand();
        dropdownMenuContentHeader.menu().childs().is().size(NUMBER_OF_CHILDREN_HEADER);
        dropdownMenuContentHeader.header.is().core()
                .displayed()
                .tag("h6")
                .hasClass("dropdown-header")
                .text(HEADER_TEXT);
    }

    @Test
    public void checkDividerTest() {
        dropdownMenuContentDivider.show();
        dropdownMenuContentDivider.is().displayed();
        dropdownMenuContentDivider.expand();
        dropdownMenuContentDivider.menu().childs().is().size(NUMBER_OF_CHILDREN_DIVIDER);
        dropdownMenuContentDivider.divider.is().core()
                .displayed()
                .tag("div")
                .hasClass("dropdown-divider");
    }

   @Test
    public void checkTextTest() {
        dropdownMenuContentText.show();
        dropdownMenuContentText.is().displayed();
        dropdownMenuContentText.expand();
        dropdownMenuContentText.menu().childs().is().size(NUMBER_OF_CHILDREN_TEXT);
        dropdownMenuContentText.text.is().values(TextTypes.TEXT, hasItems(TEXT_1_OF_DROPDOWN_TEXT));
        dropdownMenuContentText.text.is().values(TextTypes.TEXT, hasItems(TEXT_2_OF_DROPDOWN_TEXT));
    }

}

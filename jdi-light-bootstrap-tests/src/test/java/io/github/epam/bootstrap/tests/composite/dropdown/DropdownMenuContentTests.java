package io.github.epam.bootstrap.tests.composite.dropdown;

import com.epam.jdi.light.common.TextTypes;
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
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.not;

public class DropdownMenuContentTests extends TestsInit {


    private String headerText = "DROPDOWN HEADER";
    private int numberOfItemsHeader = 2;
    private int numberOfChildrenHeader = 3;

    private int numberOfItemsDivider = 3;
    private int numberOfChildrenDivider = 4;

    private String text1 = "Some example text that's free-flowing within the dropdown menu.";
    private String text2 = "And this is more example text.";
    private int numberOfItemsText = 0;
    private int numberOfChildrenText = 2;

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

    @Test
    public void baseTest() {
        baseValidation(dropdownMenuContentHeader);
        dropdownMenuContentHeader.unhighlight();
        baseValidation(dropdownMenuContentDivider);
        dropdownMenuContentDivider.unhighlight();
        baseValidation(dropdownMenuContentText);
        dropdownMenuContentText.unhighlight();

    }

    @Test(dataProvider = "dropdownData")
    public void expandCollapseTest(DropdownMenu dropdown) {
        dropdown.expand();
        dropdown.is().expanded();
        dropdown.collapse();
        dropdown.is().collapsed();
    }

    @Test
    public void checkHeaderTest() {
        dropdownMenuContentHeader.show();
        dropdownMenuContentHeader.is().displayed();
        dropdownMenuContentHeader.expand();
        dropdownMenuContentHeader.menu().childs().is().size(numberOfChildrenHeader);
        dropdownMenuContentHeader.list().is()
                .size(numberOfItemsHeader)
                .values(TextTypes.TEXT, not(hasItem(headerText)));
        dropdownMenuContentHeader.header.is().core()
                .displayed()
                .tag("h6")
                .hasClass("dropdown-header")
                .text(headerText);
    }


    @Test
    public void checkDividerTest() {
        dropdownMenuContentHeader.show();
        dropdownMenuContentDivider.is().displayed();
        dropdownMenuContentHeader.expand();
        dropdownMenuContentDivider.menu().childs().is().size(numberOfChildrenDivider);
        dropdownMenuContentDivider.list().is()
                .size(numberOfItemsDivider);
        dropdownMenuContentDivider.list().is(not(hasItem(dropdownMenuContentDivider.divider)));
        dropdownMenuContentDivider.divider.is().core()
                .hidden()
                .tag("div")
                .hasClass("dropdown-divider");
    }

   @Test
    public void checkTextTest() {
        dropdownMenuContentHeader.show();
        dropdownMenuContentText.is().displayed();
        dropdownMenuContentHeader.expand();
        dropdownMenuContentText.menu().childs().is().size(numberOfChildrenText);
        dropdownMenuContentText.list().is()
                .size(numberOfItemsText);

        dropdownMenuContentText.text.is().values(TextTypes.TEXT, hasItems(text1));
       dropdownMenuContentText.text.is().values(TextTypes.TEXT, hasItems(text2));

    }

}

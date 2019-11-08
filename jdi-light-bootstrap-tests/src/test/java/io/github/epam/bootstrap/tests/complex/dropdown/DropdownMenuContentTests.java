package io.github.epam.bootstrap.tests.complex.dropdown;

import com.epam.jdi.light.ui.bootstrap.elements.complex.Dropdown;
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
    public void expandCollapseTest(Dropdown dropdown) {
        dropdown.expand();
        dropdown.is().expanded();
        dropdown.collapse();
        dropdown.is().collapsed();
    }

    @Test
    public void checkHeaderTest() {
        dropdownMenuContentHeader.show();
        dropdownMenuContentHeader.expand();
        dropdownMenuContentHeader.menu().childs().get(1).is().core()
                .displayed()
                .tag("h6")
                .hasClass("dropdown-header")
                .text(headerText);
    }

 /*   @Test
    public void checkHeaderTest() {
        dropdownMenuContentHeader.is().displayed();
        dropdownMenuContentHeader.childs().is().size(numberOfChildrenHeader);
        dropdownMenuContentHeader.list().is()
                .size(numberOfItemsHeader)
                .values(TextTypes.TEXT, not(hasItem(headerText)));
        dropdownMenuContentHeader.header.is()
                .displayed()
                .text(headerText)
                .core().tag("h6");
    }

/*
    @Test
    public void checkDividerTest() {
        dropdownWithContentDivider.is().displayed();
        dropdownWithContentDivider.childs().is().size(numberOfChildrenDivider);
        dropdownWithContentDivider.items.is()
                .size(numberOfItemsDivider);
        dropdownWithContentDivider.items.is(not(hasItem(dropdownWithContentDivider.divider)));
        dropdownWithContentDivider.divider.is()
                .displayed()
                .core().tag("div");
    }

    @Test
    public void checkTextTest() {
        dropdownWithContentText.is().displayed();
        dropdownWithContentText.childs().is().size(numberOfChildrenText);
        dropdownWithContentText.items.is()
                .size(numberOfItemsText);
        for (Text t : dropdownWithContentText.text) {
            dropdownWithContentText.items.is().values(TextTypes.TEXT, not(hasItem(t.getText())));
        }
        dropdownWithContentText.text.is().size(numberOfChildrenText - numberOfItemsText).values(TextTypes.TEXT, hasItems(text1, text2));

    }
*/

}

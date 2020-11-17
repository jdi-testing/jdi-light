package io.github.epam.mobile.tests;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.epam.pages.HtmlMobilePage.multiDropdown;
import static io.github.epam.sections.HtmlMobileElements.htmlMobileElements;
import static io.github.epam.sections.LeftMenu.leftMenu;
import static io.github.epam.steps.Preconditions.shouldBeLoggedIn;

public class MultiDropdownTests extends StaticTestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        leftMenu.click();
        htmlMobileElements.click();
    }

    @Test
    public void basicTest() {
        getButton().click();
        getOptions().get("Steam").click();
        multiDropdown.core().click();
        getValue().has().text("None selected");
    }

    @Test
    public void allOptionsCheckedTest() {
        getButton().click();
        getOptions().get("Electro").click();
        getOptions().get("Metalic").click();
        getOptions().get("Wood").click();
        multiDropdown.core().click();
        getValue().has().text("4 selected");
    }

    @Test
    public void disabledOptionTest() {
        getButton().click();
        getOptions().get("Disabled").find("input").is().disabled();
        multiDropdown.core().click();
    }

    private UIElement getValue(){
        return getButton().find("span");
    }

    private UIElement getButton(){
        return multiDropdown.find("button");
    }

    private WebList getOptions() {
        return multiDropdown.finds("a");
    }
}

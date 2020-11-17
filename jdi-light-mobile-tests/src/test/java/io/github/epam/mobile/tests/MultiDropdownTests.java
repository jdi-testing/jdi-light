package io.github.epam.mobile.tests;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.epam.pages.HtmlMobilePage.multiDropdown;
import static io.github.epam.sections.HtmlMobileElements.htmlMobileElements;
import static io.github.epam.sections.LeftMenu.leftMenu;
import static io.github.epam.steps.Preconditions.shouldBeLoggedIn;

public class MultiDropdownTests extends StaticTestsInit{

    // //select[@id='multi-dropdown']/..//button
    //  //select[@id='multi-dropdown']/..//button//span
    //  //select[@id='multi-dropdown']/..//ul//input

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        leftMenu.click();
        htmlMobileElements.click();
    }

    @Test
    public void basicTest() {
        getButton().click();
//        getOptions().get("Steam").click();
//        getButton().click();
//        System.out.println(getValue().getText());
//        getValue().getText().equals("Non selected");
    }

    private UIElement getValue(){
        return getButton().find("span");
    }

    private UIElement getButton(){
        return multiDropdown.find("button");
    }

    private WebList getOptions() {
        return multiDropdown.finds("input");
    }
}

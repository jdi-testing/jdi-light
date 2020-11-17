package io.github.epam.mobile.tests;

import com.epam.jdi.light.elements.complex.WebList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.epam.pages.HtmlMobilePage.radioButtons;
import static io.github.epam.sections.HtmlMobileElements.htmlMobileElements;
import static io.github.epam.sections.LeftMenu.leftMenu;
import static io.github.epam.steps.Preconditions.shouldBeLoggedIn;

public class RadioButtonsTests extends StaticTestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        leftMenu.click();
        htmlMobileElements.click();
    }

    @Test
    public void basicTest() {
        getRadioButtons().get("Blue").click();
        getRadioButtons().get("Green").click();
        getRadioButtons().get("Red").click();

        getRadioButtons().get("Blue").is().deselected();
        getRadioButtons().get("Green").is().deselected();
        getRadioButtons().get("Red").is().selected();

        getRadioButtons().get("Yellow").is().disabled();
    }

    private WebList getRadioButtons() {
        return radioButtons.finds("input");
    }
}

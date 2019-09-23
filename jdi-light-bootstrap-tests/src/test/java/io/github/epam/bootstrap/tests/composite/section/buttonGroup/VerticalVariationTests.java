package io.github.epam.bootstrap.tests.composite.section.buttonGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonGroupVerticalVariation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class VerticalVariationTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String buttonOneClickAlert = "Button One Clicked!";
    String buttonTwoClickAlert = "Button Two Clicked!";
    String dropdownMenuLinkOne = "JDI Light";
    String dropdownMenuLinkTwo = "JDI Docs";
    String linkOnePageTitle = "GitHub - jdi-testing/jdi-light: Powerful Framework for UI Automation Testing on Java";
    String linkTwoPageTitle = "JDI Light Framework – API Reference";

    @Test
    public void buttonOneTests() {
        buttonGroupVerticalVariation.buttonOne.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-secondary")
                .css("font-size", "16px");
        buttonGroupVerticalVariation.buttonOne.click();
        validateAlert(is(buttonOneClickAlert));
    }

    @Test
    public void buttonTwoTests() {
        buttonGroupVerticalVariation.buttonTwo.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-secondary")
                .css("font-size", "16px");
        buttonGroupVerticalVariation.buttonTwo.click();
        validateAlert(is(buttonTwoClickAlert));
    }

    @Test
    public void dropdownMenuTests() {
        buttonGroupVerticalVariation.dropdownMenu.expand();
        buttonGroupVerticalVariation.dropdownMenu.is().expanded();
        buttonGroupVerticalVariation.dropdownMenu.is().size(2);
        buttonGroupVerticalVariation.dropdownMenu.list().get(0).is().text(dropdownMenuLinkOne);
        buttonGroupVerticalVariation.dropdownMenu.list().get(1).is().text(dropdownMenuLinkTwo);
        buttonGroupVerticalVariation.dropdownMenu.highlight();
        buttonGroupVerticalVariation.dropdownMenu.select(dropdownMenuLinkOne);
        newWindowTitleCheck(linkOnePageTitle);
        buttonGroupVerticalVariation.dropdownMenu.select(dropdownMenuLinkTwo);
        newWindowTitleCheck(linkTwoPageTitle);
    }

    public void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}

package io.github.epam.bootstrap.tests.composite.section.buttonGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonGroupNesting;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class NestingTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String buttonOneClickAlert = "Button 1 Clicked!";
    String buttonTwoClickAlert = "Button 2 Clicked!";
    String dropdownMenuLinkOne = "JDI Github";
    String dropdownMenuLinkTwo = "JDI Docs";
    String linkOnePageTitle = "GitHub - jdi-testing/jdi-light: Powerful Framework for UI Automation Testing on Java";
    String linkTwoPageTitle = "JDI Light Framework – API Reference";

    @Test
    public void buttonOneTests() {
        buttonGroupNesting.one.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-secondary")
                .css("font-size", "16px");
        buttonGroupNesting.one.click();
        validateAlert(is(buttonOneClickAlert));
    }

    @Test
    public void buttonTwoTests() {
        buttonGroupNesting.two.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-secondary")
                .css("font-size", "16px");
        buttonGroupNesting.two.click();
        validateAlert(is(buttonTwoClickAlert));
    }

    @Test
    public void dropdownMenuTests() {
        buttonGroupNesting.dropdownMenu.expand();
        buttonGroupNesting.dropdownMenu.is().expanded();
        buttonGroupNesting.dropdownMenu.is().size(2);
        buttonGroupNesting.dropdownMenu.list().get(1).is().text(dropdownMenuLinkOne);
        buttonGroupNesting.dropdownMenu.list().get(2).is().text(dropdownMenuLinkTwo);
        buttonGroupNesting.dropdownMenu.highlight();
        buttonGroupNesting.dropdownMenu.select(dropdownMenuLinkOne);
        newWindowTitleCheck(linkOnePageTitle);
        buttonGroupNesting.dropdownMenu.select(dropdownMenuLinkTwo);
        newWindowTitleCheck(linkTwoPageTitle);
    }

    public void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}

package io.github.epam.bootstrap.tests.composite.section.buttonGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonGroupBasicExample;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

public class BasicExampleTests extends TestsInit {


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String leftButtonClickAlert = "Left button clicked!";
    String middleButtonClickAlert = "Middle button clicked!";
    String rightButtonClickAlert = "Right button clicked!";

    @Test
    public void leftButtonTests() {
        buttonGroupBasicExample.leftButton.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-secondary")
                .css("font-size", "12px");
        buttonGroupBasicExample.leftButton.click();
        validateAlert(is(leftButtonClickAlert));
    }

    @Test
    public void middleButtonTests() {
        buttonGroupBasicExample.middleButton.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-secondary")
                .css("font-size", "12px");
        buttonGroupBasicExample.middleButton.click();
        validateAlert(is(middleButtonClickAlert));
    }

    @Test
    public void rightButtonTests() {
        buttonGroupBasicExample.rightButton.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-secondary")
                .css("font-size", "12px");
        buttonGroupBasicExample.rightButton.click();
        validateAlert(is(rightButtonClickAlert));
    }
}

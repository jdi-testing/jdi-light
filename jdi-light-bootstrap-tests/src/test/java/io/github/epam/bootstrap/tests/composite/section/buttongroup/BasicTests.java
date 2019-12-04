package io.github.epam.bootstrap.tests.composite.section.buttongroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonGroupBasic;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
public class BasicTests extends TestsInit {

    private String leftButtonClickAlert = "Left Button Clicked!";
    private String middleButtonClickAlert = "Middle Button Clicked!";
    private String rightButtonClickAlert = "Right Button Clicked!";
    private String leftButtonText = "Left";
    private String middleButtonText = "Middle";
    private String rightButtonText = "Right";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void leftButtonTests() {
        buttonGroupBasic.leftButton.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-secondary")
                .css("font-size", "16px");
        buttonGroupBasic.leftButton.click();
        validateAlert(is(leftButtonClickAlert));
    }

    @Test
    public void middleButtonTests() {
        buttonGroupBasic.middleButton.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-secondary")
                .css("font-size", "16px");
        buttonGroupBasic.middleButton.click();
        validateAlert(is(middleButtonClickAlert));
    }

    @Test
    public void buttonGroupTextTest() {
        buttonGroupBasic.leftButton.is().text(leftButtonText);
        buttonGroupBasic.middleButton.is().text(middleButtonText);
        buttonGroupBasic.rightButton.is().text(rightButtonText);
    }

    @Test
    public void rightButtonTests() {
        buttonGroupBasic.rightButton.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-secondary")
                .css("font-size", "16px");
        buttonGroupBasic.rightButton.click();
        validateAlert(is(rightButtonClickAlert));
    }
}

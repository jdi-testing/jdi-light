package io.github.epam.bootstrap.tests.composite.section.buttongroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonGroupBasicExample;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 19.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class BasicExampleTests extends TestsInit {

    private String leftButtonClickAlert = "Left Button Clicked!";
    private String middleButtonClickAlert = "Middle Button Clicked!";
    private String rightButtonClickAlert = "Right Button Clicked!";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void leftButtonTests() {
        buttonGroupBasicExample.leftButton.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("btn btn-secondary")
                .css("font-size", "16px");
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
                .css("font-size", "16px");
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
                .css("font-size", "16px");
        buttonGroupBasicExample.rightButton.click();
        validateAlert(is(rightButtonClickAlert));
    }
}

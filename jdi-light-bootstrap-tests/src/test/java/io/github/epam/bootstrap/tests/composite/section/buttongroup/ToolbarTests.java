package io.github.epam.bootstrap.tests.composite.section.buttonGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonGroupToolbar;
import static io.github.com.pages.BootstrapPage.buttonGroupToolbarWithInputField;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

/**
 * Created by Dmitrii Pavlov on 19.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class ToolbarTests extends TestsInit {

    private String borderColorBeforeClicking = "rgb(108, 117, 125)";
    private String borderColorAfterClicking = "rgb(84, 91, 98)";
    private String backgroundColorBeforeHovering = "rgba(108, 117, 125, 1)";
    private String backgroundColorAfterHovering = "rgba(90, 98, 104, 1)";
    private String textForTestingInputField = "Test text";
    private String placeholderForInputField = "Input group example";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTextTest() {
        for (int i = 1; i < 9; i++) {
            assertEquals(buttonGroupToolbar.buttonsInToolbar.get(i).getText(), String.valueOf(i));
        }
    }

    @Test
    public void isValidationTest() {
        for (int i = 1; i < 9; i++) {
            buttonGroupToolbar.buttonsInToolbar.get(i).is().text(String.valueOf(i));
        }
    }

    @Test
    public void buttonsInButtonToolbarTest() {
        buttonGroupToolbar.buttonsInToolbar.forEach(button -> {
            button.is().displayed();
            button.is().enabled();
            button.assertThat().css("background-color", backgroundColorBeforeHovering);
            button.assertThat().css("border-color", borderColorBeforeClicking);
            button.core().hover();
            button.assertThat().css("background-color", backgroundColorAfterHovering);
            button.click();
            validateAlert(containsString("button is clicked"));
            button.assertThat().css("border-color", borderColorAfterClicking);
        });
    }

    @Test
    public void inputFieldInButtonToolbarTest() {
        buttonGroupToolbarWithInputField.inputAreaInToolbar.is().displayed();
        buttonGroupToolbarWithInputField.inputAreaInToolbar.is().enabled();
        buttonGroupToolbarWithInputField.inputAreaInToolbar.is().core().attr("placeholder", placeholderForInputField);
        buttonGroupToolbarWithInputField.inputAreaInToolbar.setValue(textForTestingInputField);
        assertEquals(buttonGroupToolbarWithInputField.inputAreaInToolbar.getValue(), textForTestingInputField);
    }
}

package io.github.epam.bootstrap.tests.composite.section.buttonGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonToolbar;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class ButtonToolbarTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private String borderColorBeforeClicking = "rgb(108, 117, 125)";
    private String borderColorAfterClicking = "rgb(84, 91, 98)";
    private String backgroundColorBeforeHovering = "rgba(108, 117, 125, 1)";
    private String backgroundColorAfterHovering = "rgba(90, 98, 104, 1)";
    private String textForTestingInputField = "Test text";
    private String placeholderForInputField = "Input";

    @Test
    public void getTextTest() {
        assertEquals(buttonToolbar.buttonsInToolbar.get(0).getText(), "1");
        assertEquals(buttonToolbar.buttonsInToolbar.get(1).getText(), "2");
    }

    @Test
    public void buttonsInButtonToolbarTest() {
        buttonToolbar.buttonsInToolbar.forEach(button -> {
            button.is().displayed();
            button.is().enabled();
            button.assertThat().css("background-color", backgroundColorBeforeHovering);
            button.core().hover();
            button.assertThat().css("background-color", backgroundColorAfterHovering);
            button.assertThat().css("border-color", borderColorBeforeClicking);
            button.click();
            button.assertThat().css("border-color", borderColorAfterClicking);
        });
    }

    @Test
    public void inputFieldInButtonToolbarTest() {
        buttonToolbar.inputAreaInToolbar.is().displayed();
        buttonToolbar.inputAreaInToolbar.is().enabled();
        buttonToolbar.inputAreaInToolbar.is().core().attr("placeholder", placeholderForInputField);
        buttonToolbar.inputAreaInToolbar.setValue(textForTestingInputField);
        assertEquals(buttonToolbar.inputAreaInToolbar.getValue(), textForTestingInputField);
    }
}
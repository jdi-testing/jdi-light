package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.buttonGroupFrame;
import static io.github.com.StaticSite.inputButtonGroupDefaultPage;
import static io.github.com.StaticSite.inputButtonGroupDisabledPage;
import static io.github.com.StaticSite.inputButtonGroupSplitPage;
import static io.github.com.StaticSite.splitButtonGroupFrame;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class ButtonGroupTests extends TestsInit {

    @Test
    public void defaultButtonGroupTest() {
        inputButtonGroupDefaultPage.open();

        buttonGroupFrame.buttonGroup.buttonWithIndex(1).click();
        buttonGroupFrame.buttonGroup.buttonWithIndex(2).click();
        buttonGroupFrame.buttonGroup.buttonWithIndex(3).click();

        buttonGroupFrame.buttonGroup.buttonWithText("Three").click();
        buttonGroupFrame.buttonGroup.buttonWithText("Two").click();
        buttonGroupFrame.buttonGroup.buttonWithText("One").click();

        buttonGroupFrame.buttonGroup.buttonWithIndex(1).is().enabled();
        buttonGroupFrame.buttonGroup.buttonWithIndex(1).has().text(containsStringIgnoringCase("One"));
    }

    @Test(expectedExceptions = {RuntimeException.class},
            expectedExceptionsMessageRegExp = ".*(Can't perform click. Element is disabled)")
    public void disabledButtonGroupTest() {
        inputButtonGroupDisabledPage.open();

        buttonGroupFrame.buttonGroup.buttonWithIndex(1).is().disabled();
        buttonGroupFrame.buttonGroup.buttonWithText("Two").is().disabled();
        buttonGroupFrame.buttonGroup.buttonWithText("Two").click();
    }

    @Test
    public void splitButtonGroupTest() {
        inputButtonGroupSplitPage.open();

        splitButtonGroupFrame.buttonGroup.mainButton().click();
        splitButtonGroupFrame.buttonGroup.mainButton()
                .has().text(containsStringIgnoringCase("Squash and merge"));
        splitButtonGroupFrame.buttonGroup.select("Update project");
        splitButtonGroupFrame.buttonGroup.mainButton()
                .has().text(containsStringIgnoringCase("Update project"));


    }
}

package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.LinqUtils.safeException;
import static io.github.com.StaticSite.buttonGroupFrame;
import static io.github.com.StaticSite.inputButtonGroupDefaultPage;
import static io.github.com.StaticSite.inputButtonGroupDisabledPage;
import static io.github.com.StaticSite.inputButtonGroupSplitPage;
import static io.github.com.StaticSite.splitButtonGroupFrame;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.testng.Assert.fail;

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

    @Test
    public void disabledButtonGroupTest() {
        inputButtonGroupDisabledPage.open();

        buttonGroupFrame.buttonGroup.buttonWithIndex(1).is().disabled();
        buttonGroupFrame.buttonGroup.buttonWithText("Two").is().disabled();
        try {
            buttonGroupFrame.buttonGroup.buttonWithText("Three").click();
            fail("Disabled button shouldn't work, but it does");
        } catch (Exception ex) {
            assertThat(safeException(ex),
                    containsString("Can't perform click. Element is disabled"));
        }
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

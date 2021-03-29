package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.buttonGroupFrame;
import static io.github.com.StaticSite.inputButtonGroupDefaultPage;
import static io.github.com.StaticSite.inputButtonGroupDisabledPage;
import static io.github.com.StaticSite.inputButtonGroupSplitPage;
import static io.github.com.StaticSite.splitButtonGroupFrame;

public class ButtonGroupTests extends TestsInit {

    @Test
    public void defaultButtonGroupTest() {
        inputButtonGroupDefaultPage.open();

        buttonGroupFrame.buttonGroup.getButtonByIndex(1).click();
        buttonGroupFrame.buttonGroup.getButtonByIndex(2).click();
        buttonGroupFrame.buttonGroup.getButtonByIndex(3).click();

        buttonGroupFrame.buttonGroup.getButtonByText("Three").click();
        buttonGroupFrame.buttonGroup.getButtonByText("Two").click();
        buttonGroupFrame.buttonGroup.getButtonByText("One").click();

        buttonGroupFrame.buttonGroup.getButtonByIndex(1).is().enabled();
        buttonGroupFrame.buttonGroup.getButtonByIndex(1).has().text("ONE");
    }

    @Test
    public void splitButtonGroupTest() {
        inputButtonGroupSplitPage.open();

        splitButtonGroupFrame.buttonGroup.getMainButton().click();
        splitButtonGroupFrame.buttonGroup.getMainButton()
                .has().text("SQUASH AND MERGE");
        splitButtonGroupFrame.buttonGroup.select("Update project");
        splitButtonGroupFrame.buttonGroup.getMainButton()
                .has().text("UPDATE PROJECT");


    }
}

package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.inputs.ButtonGroupPage.*;

public class ButtonGroupTests extends TestsInit {

    @BeforeMethod
    public void before(){

        buttonGroupPage.open();
        buttonGroupPage.isOpened();
    }

    @Test
    public void basicButtonGroupTest() {

        basicButtonGroup.getButtonByIndex(1).click();
        basicButtonGroup.getButtonByIndex(2).click();
        basicButtonGroup.getButtonByIndex(3).click();

        basicButtonGroup.getButtonByText("Three").click();
        basicButtonGroup.getButtonByText("Two").click();
        basicButtonGroup.getButtonByText("One").click();

        basicButtonGroup.getButtonByIndex(1).is().enabled();
        basicButtonGroup.getButtonByIndex(1).has().text("ONE");
    }

    @Test
    public void verticalButtonGroupTest() {

        verticalButtonGroup.getButtonByIndex(2).click();
        verticalButtonGroup.getButtonByIndex(3).click();

        verticalButtonGroup.getButtonByText("Two").click();
        verticalButtonGroup.getButtonByText("One").click();

        basicButtonGroup.getButtonByIndex(2).is().enabled();
        basicButtonGroup.getButtonByIndex(2).has().text("TWO");
    }

    @Test
    public void disabledButtonGroupTest() {
        basicButtonGroup.getButtonByIndex(1).is().disabled();
        basicButtonGroup.getButtonByText("Two").is().disabled();
    }

    @Test
    public void splitButtonGroupTest() {
        splitButtonGroup.expand();
        splitButtonGroup.has().text("SQUASH AND MERGE");
        splitButtonGroup.select("Create a merge commit");
        splitButtonGroup.has().text("CREATE A MERGE COMMIT");
    }
}

package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
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
    public void splitButtonGroupTest() {
        splitButtonGroup.getButtonByIndex(1).has().text("SQUASH AND MERGE");
        splitButtonGroup.getButtonByText("Squash and merge").click();

        splitButtonGroup.getButtonByIndex(2).click();
        splitButtonDropdown.get(1).click();
        splitButtonGroup.getButtonByIndex(1).has().text("CREATE A MERGE COMMIT");

        splitButtonGroup.getButtonByIndex(2).click();
        splitButtonDropdown.get(3).has().cssClass("Mui-disabled");
        splitButtonDropdown.get(2).click();
        splitButtonGroup.getButtonByIndex(1).has().text("SQUASH AND MERGE");
    }
}

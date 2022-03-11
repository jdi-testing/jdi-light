package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.buttonGroupPage;
import static io.github.com.pages.inputs.ButtonGroupPage.basicButtonGroup;
import static io.github.com.pages.inputs.ButtonGroupPage.basicLastClick;
import static io.github.com.pages.inputs.ButtonGroupPage.splitButtonGroup;
import static io.github.com.pages.inputs.ButtonGroupPage.splitButtonMenu;
import static io.github.com.pages.inputs.ButtonGroupPage.verticalButtonGroup;
import static io.github.com.pages.inputs.ButtonGroupPage.verticalLastClick;

public class ButtonGroupTests extends TestsInit {

    @BeforeMethod
    public void before() {
        buttonGroupPage.open();
        buttonGroupPage.isOpened();
    }

    @Test
    public void basicButtonGroupTest() {
        basicButtonGroup.getButtonByIndex(1).click();
        basicButtonGroup.getButtonByIndex(2).click();
        basicButtonGroup.getButtonByIndex(3).click();

        basicLastClick.has().text("Last click: Three");

        basicButtonGroup.getButtonByText("Three").click();
        basicButtonGroup.getButtonByText("Two").click();
        basicButtonGroup.getButtonByText("One").click();

        basicLastClick.has().text("Last click: One");

        basicButtonGroup.getButtonByIndex(1).is().enabled();
        basicButtonGroup.getButtonByIndex(1).has().text("ONE");

        basicButtonGroup.has().numberOfGroupedButtons(3);
        basicButtonGroup.has().buttonsTextsInAnyOrder(Arrays.asList("THREE", "ONE", "TWO"));
    }

    @Test
    public void verticalButtonGroupTest() {
        verticalButtonGroup.getButtonByIndex(2).click();
        verticalButtonGroup.getButtonByIndex(3).click();

        verticalLastClick.has().text("Last click: Three");

        verticalButtonGroup.getButtonByText("Two").click();
        verticalButtonGroup.getButtonByText("One").click();

        verticalLastClick.has().text("Last click: One");

        basicButtonGroup.getButtonByIndex(2).is().enabled();
        basicButtonGroup.getButtonByIndex(2).has().text("TWO");
    }

    @Test
    public void splitButtonGroupTest() {

        splitButtonGroup.getButtonByIndex(1).has().text("SQUASH AND MERGE");
        splitButtonGroup.getButtonByText("Squash and merge").click();

        splitButtonGroup.getButtonByIndex(2).click();
        waitCondition(() -> splitButtonMenu.item(1).isDisplayed());
        splitButtonMenu.item(1).click();
        splitButtonGroup.getButtonByIndex(1).has().text("CREATE A MERGE COMMIT");

        splitButtonGroup.getButtonByIndex(2).click();
        splitButtonMenu.item(3).is().disabled()
                .and().has().text("Rebase and merge");

        splitButtonMenu.item(2).click();
        splitButtonGroup.getButtonByIndex(1).has().text("SQUASH AND MERGE");
    }
}

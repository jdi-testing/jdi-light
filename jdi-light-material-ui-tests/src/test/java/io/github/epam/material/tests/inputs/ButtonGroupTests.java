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
        basicButtonGroup.button(1).click();
        basicButtonGroup.button(2).click();
        basicButtonGroup.button(3).click();

        basicLastClick.has().text("Last click: Three");

        basicButtonGroup.button("Three").click();
        basicButtonGroup.button("Two").click();
        basicButtonGroup.button("One").click();

        basicLastClick.has().text("Last click: One");

        basicButtonGroup.button(1).is().enabled();
        basicButtonGroup.button(1).has().text("ONE");

        basicButtonGroup.has().numberOfGroupedButtons(3);
        basicButtonGroup.has().buttonsTextsInAnyOrder(Arrays.asList("THREE", "ONE", "TWO"));
    }

    @Test
    public void verticalButtonGroupTest() {
        verticalButtonGroup.button(2).click();
        verticalButtonGroup.button(3).click();

        verticalLastClick.has().text("Last click: Three");

        verticalButtonGroup.button("Two").click();
        verticalButtonGroup.button("One").click();

        verticalLastClick.has().text("Last click: One");

        basicButtonGroup.button(2).is().enabled();
        basicButtonGroup.button(2).has().text("TWO");
    }

    @Test
    public void splitButtonGroupTest() {

        splitButtonGroup.button(1).has().text("SQUASH AND MERGE");
        splitButtonGroup.button("Squash and merge").click();

        splitButtonGroup.button(2).click();
        waitCondition(() -> splitButtonMenu.item(1).isDisplayed());
        splitButtonMenu.item(1).click();
        splitButtonGroup.button(1).has().text("CREATE A MERGE COMMIT");

        splitButtonGroup.button(2).click();
        splitButtonMenu.item("Rebase and merge").is().disabled();

        splitButtonMenu.item("Squash and merge").click();
        splitButtonGroup.button(1).has().text("SQUASH AND MERGE");
    }
}

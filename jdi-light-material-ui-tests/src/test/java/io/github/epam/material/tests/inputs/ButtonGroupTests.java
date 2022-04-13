package io.github.epam.material.tests.inputs;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        basicButtonGroup.has().buttons(3)
            .and().buttonsTexts(Matchers.containsInAnyOrder("THREE", "ONE", "TWO"));
        basicButtonGroup.button(1).is().enabled().and().has().text("ONE");

        basicButtonGroup.button(1).click();
        basicButtonGroup.button(2).click();
        basicButtonGroup.button(3).click();

        basicLastClick.has().text("Last click: Three");

        basicButtonGroup.button("Three").click();
        basicButtonGroup.button("Two").click();
        basicButtonGroup.button("One").click();

        basicLastClick.has().text("Last click: One");
    }

    @Test
    public void verticalButtonGroupTest() {
        verticalButtonGroup.has().buttonsTexts(Matchers.contains("ONE", "TWO", "THREE"));
        verticalButtonGroup.button(2).is().enabled().and().has().text("TWO");

        verticalButtonGroup.button(2).click();
        verticalButtonGroup.button(3).click();

        verticalLastClick.has().text("Last click: Three");

        verticalButtonGroup.button("Two").click();
        verticalButtonGroup.button("One").click();

        verticalLastClick.has().text("Last click: One");
    }

    @Test
    public void splitButtonGroupTest() {
        String firstMenuItem = "Create a merge commit";
        String secondMenuItem = "Squash and merge";
        String thirdMenuItem = "Rebase and merge";

        splitButtonGroup.button(1).is().enabled()
            .and().has().text(Matchers.equalToIgnoringCase(secondMenuItem));

        splitButtonGroup.button(2).click();
        Timer.waitCondition(() -> splitButtonMenu.item(1).isDisplayed());
        splitButtonMenu.item(firstMenuItem).click();
        splitButtonGroup.button(1).has().text(Matchers.equalToIgnoringCase(firstMenuItem));

        splitButtonGroup.button(2).click();
        splitButtonMenu.item(thirdMenuItem).is().disabled();

        splitButtonMenu.item(secondMenuItem).click();
        splitButtonGroup.button(1).has().text(Matchers.equalToIgnoringCase(secondMenuItem));
    }
}

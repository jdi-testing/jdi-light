package io.github.epam.vuetify.tests.input;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.StaticSite.buttonsPage;
import static io.github.com.pages.ButtonsPage.blockButton;
import static io.github.com.pages.ButtonsPage.blockButtonState;
import static io.github.com.pages.ButtonsPage.commonButton;
import static io.github.com.pages.ButtonsPage.commonButtonState;
import static io.github.com.pages.ButtonsPage.depressedButtonState;
import static io.github.com.pages.ButtonsPage.depressedDisabledButton;
import static io.github.com.pages.ButtonsPage.depressedErrorButton;
import static io.github.com.pages.ButtonsPage.depressedNormalButton;
import static io.github.com.pages.ButtonsPage.depressedPrimaryButton;
import static io.github.com.pages.ButtonsPage.iconButtonState;
import static io.github.com.pages.ButtonsPage.iconButtons;
import static io.github.com.pages.ButtonsPage.loaderButtons;
import static io.github.com.pages.ButtonsPage.outlinedButton;
import static io.github.com.pages.ButtonsPage.outlinedButtonState;
import static io.github.com.pages.ButtonsPage.plainButtonState;
import static io.github.com.pages.ButtonsPage.plainButtons;
import static io.github.com.pages.ButtonsPage.roundedButton;
import static io.github.com.pages.ButtonsPage.roundedButtonState;
import static io.github.com.pages.ButtonsPage.textButtonState;
import static io.github.com.pages.ButtonsPage.textButtons;
import static io.github.com.pages.ButtonsPage.tileButton;
import static io.github.com.pages.ButtonsPage.tileButtonState;

public class ButtonsTests extends TestsInit {

    @BeforeClass
    public void beforeClass() {
        buttonsPage.open();
        waitCondition(() -> buttonsPage.isOpened());
    }

    @Test
    public void commonButtonsTests() {
        commonButton.click();
        commonButtonState.is().text("Button clicked");
    }

    @Test
    public void blockButtonsTests() {
        blockButton.click();
        blockButtonState.is().text("Block button clicked");
    }

    @Test
    public void depressedButtonsTests() {
        depressedNormalButton.click();
        depressedButtonState.is().text("Depressed button clicked: Normal");
        depressedPrimaryButton.click();
        depressedButtonState.is().text("Depressed button clicked: Primary");
        depressedErrorButton.click();
        depressedButtonState.is().text("Depressed button clicked: Error");
        depressedDisabledButton.is().disabled();
    }

    @Test
    public void iconButtonsTests() {
        iconButtons.get(1).click();
        iconButtonState.is().text("Icon button clicked: heart");
        iconButtons.get(2).click();
        iconButtonState.is().text("Icon button clicked: star");
        iconButtons.get(3).click();
        iconButtonState.is().text("Icon button clicked: cached");
        iconButtons.get(4).click();
        iconButtonState.is().text("Icon button clicked: thumb up");

        iconButtons.get(5).is().disabled();
        iconButtons.get(6).is().disabled();
        iconButtons.get(7).is().disabled();
        iconButtons.get(8).is().disabled();
    }

    @Test
    public void loaderButtonsTests() {
        loaderButtons.forEach(button -> {
            button.click();
            waitCondition(() -> button.isLoading());
            button.is().loading();
        });
    }

    @Test
    public void textButtonsTests() {
        textButtons.get(1).click();
        textButtonState.is().text("Text button clicked: Normal");
        textButtons.get(2).click();
        textButtonState.is().text("Text button clicked: Primary");
        textButtons.get(3).click();
        textButtonState.is().text("Text button clicked: Error");
        textButtons.get(4).is().disabled();
    }

    @Test
    public void plainButtonsTests() {
        plainButtons.get(1).click();
        plainButtonState.is().text("Plain button clicked: cancel");
        plainButtons.get(2).click();
        plainButtons.get(2).is().loading();
        plainButtonState.is().text("Plain button clicked: delete");
    }

    @Test
    public void outlinedButtonsTests() {
        outlinedButton.click();
        outlinedButtonState.is().text("Outlined button clicked");
    }

    @Test
    public void roundedButtonsTests() {
        roundedButton.click();
        roundedButtonState.is().text("Rounded button clicked");
    }

    @Test
    public void tileButtonsTests() {
        tileButton.click();
        tileButtonState.is().text("Tile button clicked");
    }
}

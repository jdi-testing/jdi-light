package io.github.epam.vuetify.tests.common;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.StaticSite.floatingActionButtonsPage;
import static io.github.com.pages.FloatingActionButtonsPage.addSmallVariantButton;
import static io.github.com.pages.FloatingActionButtonsPage.animationButtonState;
import static io.github.com.pages.FloatingActionButtonsPage.chevronUpLateralScreenButton;
import static io.github.com.pages.FloatingActionButtonsPage.collapseSpeedDialButton;
import static io.github.com.pages.FloatingActionButtonsPage.expandSpeedDialButton;
import static io.github.com.pages.FloatingActionButtonsPage.fileNameTextField;
import static io.github.com.pages.FloatingActionButtonsPage.floatingButtonState;
import static io.github.com.pages.FloatingActionButtonsPage.heartFloatingButton;
import static io.github.com.pages.FloatingActionButtonsPage.hideAnimationButton;
import static io.github.com.pages.FloatingActionButtonsPage.lateralScreenButtonState;
import static io.github.com.pages.FloatingActionButtonsPage.lateralScreenTabs;
import static io.github.com.pages.FloatingActionButtonsPage.listSpeedDialButtons;
import static io.github.com.pages.FloatingActionButtonsPage.pencilFloatingButton;
import static io.github.com.pages.FloatingActionButtonsPage.pencilLateralScreenButton;
import static io.github.com.pages.FloatingActionButtonsPage.plusAnimationButton;
import static io.github.com.pages.FloatingActionButtonsPage.plusFloatingButton;
import static io.github.com.pages.FloatingActionButtonsPage.shareLateralScreenButton;
import static io.github.com.pages.FloatingActionButtonsPage.showAnimationButton;
import static io.github.com.pages.FloatingActionButtonsPage.smallPlusAnimationButton;
import static io.github.com.pages.FloatingActionButtonsPage.smallVariantDialog;
import static io.github.com.pages.FloatingActionButtonsPage.submitButton;

public class FloatingActionButtonsTests extends TestsInit {

    @BeforeClass
    public void beforeClass() {
        floatingActionButtonsPage.open();
        waitCondition(() -> floatingActionButtonsPage.isOpened());
    }

    @Test
    public void floatingButtonsTests() {
        heartFloatingButton.click();
        floatingButtonState.is().text("Floating button clicked: heart");
        plusFloatingButton.click();
        floatingButtonState.is().text("Floating button clicked: plus");
        pencilFloatingButton.click();
        floatingButtonState.is().text("Floating button clicked: pencil");
    }

    @Test
    public void displayAnimationTests() {
        smallPlusAnimationButton.click();
        animationButtonState.is().text("Last clicked: top plus");
        plusAnimationButton.click();
        animationButtonState.is().text("Last clicked: bottom plus");
        hideAnimationButton.click();
        Timer.waitCondition(smallPlusAnimationButton::isHidden);
        smallPlusAnimationButton.is().hidden();
        plusAnimationButton.is().hidden();
        showAnimationButton.click();
        Timer.waitCondition(smallPlusAnimationButton::isDisplayed);
        smallPlusAnimationButton.is().displayed();
        plusAnimationButton.is().displayed();
    }

    @Test
    public void lateralScreensTests() {
        lateralScreenTabs.get(1).click();
        Timer.waitCondition(shareLateralScreenButton::isDisplayed);
        shareLateralScreenButton.click();
        lateralScreenButtonState.is().text("Last clicked: Share");
        lateralScreenTabs.get(2).click();
        Timer.waitCondition(pencilLateralScreenButton::isDisplayed);
        pencilLateralScreenButton.click();
        lateralScreenButtonState.is().text("Last clicked: Pencil");
        lateralScreenTabs.get(3).click();
        Timer.waitCondition(chevronUpLateralScreenButton::isDisplayed);
        chevronUpLateralScreenButton.click();
        lateralScreenButtonState.is().text("Last clicked: Chevron up");
    }

    @Test
    public void smallVariantTests() {
        addSmallVariantButton.click();
        smallVariantDialog.is().displayed();
        fileNameTextField.setText("file name");
        submitButton.click();
        smallVariantDialog.is().hidden();
    }

    @Test
    public void specialDialTests() {
        expandSpeedDialButton.click();
        collapseSpeedDialButton.is().displayed();
        listSpeedDialButtons.forEach(button -> button.is().displayed());
        int listSize = listSpeedDialButtons.size();
        collapseSpeedDialButton.click();
        expandSpeedDialButton.is().displayed();

        do {
            expandSpeedDialButton.click();
            listSpeedDialButtons.get(listSize).click();
            expandSpeedDialButton.is().displayed();
            listSize--;
        } while (listSize > 0);
    }
}

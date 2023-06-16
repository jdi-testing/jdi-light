package io.github.epam.vuetify.tests.common;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
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
import static io.github.com.pages.FloatingActionButtonsPage.hoverSpeedDialCheckbox;
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
        floatingActionButtonsPage.checkOpened();
    }

    @Test(description = "Test checks floating button feature: 'fab'")
    public void floatingButtonsTests() {
        heartFloatingButton.click();
        heartFloatingButton.has().icon();
        floatingButtonState.is().text("Floating button clicked: heart");
        plusFloatingButton.click();
        plusFloatingButton.has().cssClass("v-btn--fab");
        plusFloatingButton.has().icon();
        floatingButtonState.is().text("Floating button clicked: plus");
        pencilFloatingButton.click();
        pencilFloatingButton.has().icon();
        floatingButtonState.is().text("Floating button clicked: pencil");
    }

    @Test(description = "Test checks floating button with animation: 'hidden' vs 'displayed'")
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

    @Test(description = "Test checks floating button with lateral screen: 'displayed' and their icon types")
    public void lateralScreensTests() {
        lateralScreenTabs.get(1).click();
        Timer.waitCondition(shareLateralScreenButton::isDisplayed);
        shareLateralScreenButton.click();
        shareLateralScreenButton.has().cssClass("mdi-share-variant");
        lateralScreenButtonState.is().text("Last clicked: Share");
        lateralScreenTabs.get(2).click();
        Timer.waitCondition(pencilLateralScreenButton::isDisplayed);
        pencilLateralScreenButton.click();
        pencilLateralScreenButton.has().cssClass("mdi-pencil");
        lateralScreenButtonState.is().text("Last clicked: Pencil");
        lateralScreenTabs.get(3).click();
        Timer.waitCondition(chevronUpLateralScreenButton::isDisplayed);
        chevronUpLateralScreenButton.click();
        chevronUpLateralScreenButton.has().cssClass("mdi-chevron-up");
        lateralScreenButtonState.is().text("Last clicked: Chevron up");
    }

    @Test(description = "Test checks floating button 'small variant: position=absolute, displayed, clickable'")
    public void smallVariantTests() {
        addSmallVariantButton.is().displayed();
        addSmallVariantButton.has().cssClass("v-btn--absolute");
        addSmallVariantButton.click();
        smallVariantDialog.is().displayed();
        fileNameTextField.setText("file name");
        submitButton.click();
        smallVariantDialog.is().hidden();
    }
    @Test(description = "Test checks floating button speed dial transition: all speed-dial buttons are clickable")
    public void clickDialTests() {
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

    @Test(description = "Test checks floating button speed dial feature: 'open-on-hover'")
    public void hoverDialTests() {
        hoverSpeedDialCheckbox.check();
        expandSpeedDialButton.is().displayed();
        expandSpeedDialButton.hover();
        expandSpeedDialButton.has().cssClass("v-speed-dial--is-active");
        listSpeedDialButtons.forEach(i -> i.is().visible());
        hoverSpeedDialCheckbox.uncheck();
    }
}

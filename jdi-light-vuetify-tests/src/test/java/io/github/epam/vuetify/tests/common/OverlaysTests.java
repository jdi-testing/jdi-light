package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.overlaysPage;
import static io.github.com.enums.Colors.CYAN_DARKEN_5;
import static io.github.com.pages.OverlaysPage.absoluteOverlay;
import static io.github.com.pages.OverlaysPage.absoluteOverlayButton;
import static io.github.com.pages.OverlaysPage.advancedOverlay;
import static io.github.com.pages.OverlaysPage.advancedOverlayCard;
import static io.github.com.pages.OverlaysPage.closeButton;
import static io.github.com.pages.OverlaysPage.loaderOverlay;
import static io.github.com.pages.OverlaysPage.loaderOverlayButton;
import static io.github.com.pages.OverlaysPage.opacityOverlay;
import static io.github.com.pages.OverlaysPage.opacityOverlayButton;
import static io.github.com.pages.OverlaysPage.progressCircular;
import static io.github.com.pages.OverlaysPage.zIndexOverlay;
import static io.github.com.pages.OverlaysPage.zIndexOverlayButton;

public class OverlaysTests extends TestsInit {

//    @BeforeClass
//    public void before() {
//        overlaysPage.open();
//        waitCondition(() -> overlaysPage.isOpened());
//        overlaysPage.checkOpened();
//    }
//
//    @AfterMethod()
//    public void afterTest() {
//        if (closeButton.isDisplayed()) {
//            closeButton.click();
//            waitCondition(closeButton::isHidden);
//        } else if (progressCircular.isVisible()) {
//            waitCondition(progressCircular::isHidden);
//        }
//    }
//
//    @Test(description = "Check that overlay position is absolute")
//    public void absolutePositionOverlaysTest() {
//        absoluteOverlayButton.show();
//        absoluteOverlayButton.click();
//        absoluteOverlay.has().absolutePosition();
//    }
//
//    @Test(description = "Check that overlay position is not absolute")
//    public void notAbsolutePositionOverlaysTest() {
//        loaderOverlayButton.show();
//        loaderOverlayButton.click();
//        loaderOverlay.has().notAbsolutePosition();
//    }
//
//    @Test(description = "Check overlay color")
//    public void colorOverlaysTest() {
//        advancedOverlayCard.show();
//        advancedOverlayCard.hover();
//        advancedOverlay.has().backgroundColor(CYAN_DARKEN_5.value());
//    }
//
//    @Test(description = "Check that overlay theme is dark")
//    public void darkThemeOverlaysTest() {
//        absoluteOverlayButton.show();
//        absoluteOverlayButton.click();
//        absoluteOverlay.has().darkTheme();
//    }
//
//    @Test(description = "Check overlay opacity value")
//    public void opacityOverlaysTest() {
//        opacityOverlayButton.show();
//        opacityOverlayButton.click();
//        opacityOverlay.has().opacity(1);
//    }
//
//    @Test(description = "Check that overlay is displayed or not")
//    public void displayedOverlaysTest() {
//        absoluteOverlay.is().hidden();
//        absoluteOverlayButton.click();
//        absoluteOverlay.is().displayed();
//    }
//
//    @Test(description = "Check overlay z-index value")
//    public void zIndexOverlaysTest() {
//        zIndexOverlayButton.show();
//        zIndexOverlayButton.click();
//        zIndexOverlay.has().zIndex(0);
//    }
}

package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Overlay;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.overlaysPage;
import static io.github.com.pages.OverlaysPage.absoluteOverlay;
import static io.github.com.pages.OverlaysPage.absoluteOverlayButton;
import static io.github.com.pages.OverlaysPage.advancedOverlayCard;
import static io.github.com.pages.OverlaysPage.loaderOverlay;
import static io.github.com.pages.OverlaysPage.loaderOverlayButton;
import static io.github.com.pages.OverlaysPage.opacityOverlay;
import static io.github.com.pages.OverlaysPage.opacityOverlayButton;
import static io.github.com.pages.OverlaysPage.zIndexOverlay;
import static io.github.com.pages.OverlaysPage.zIndexOverlayButton;

public class OverlaysTests extends TestsInit {

    @BeforeClass
    public void before() {
        overlaysPage.open();
        waitCondition(() -> overlaysPage.isOpened());
        overlaysPage.checkOpened();
    }

    @Test
    public void absoluteOverlayTest() {
        absoluteOverlay.is().absolute();
        absoluteOverlay.is().notActive();
        absoluteOverlay.is().opacity(0);

        absoluteOverlayButton.click();
        absoluteOverlay.is().absolute();
        absoluteOverlay.is().active();
        absoluteOverlay.is().opacity(0.46);

        absoluteOverlay.content().find("button").click();
        absoluteOverlay.is().notActive();
        absoluteOverlay.is().opacity(0);
    }

    @Test
    public void opacityOverlayTest() {
        opacityOverlay.is().opacity(0);
        opacityOverlayButton.click();
        opacityOverlay.is().opacity(1);
        opacityOverlay.content().find("button").click();
        opacityOverlay.is().opacity(0);
    }

    @Test
    public void zIndexOverlayTest() {
        zIndexOverlay.is().zIndex(0);
        zIndexOverlay.is().opacity(0);
        zIndexOverlay.is().notAbsolute();

        absoluteOverlay.is().zIndex(5);
        absoluteOverlayButton.click();
        absoluteOverlay.is().active();

        zIndexOverlayButton.click();
        zIndexOverlay.is().active();

        absoluteOverlay.content().find("button").click();
        absoluteOverlay.is().notActive();

        zIndexOverlay.content().find("button").click();
        zIndexOverlay.is().notActive();
    }

    @Test
    public void advancedOverlayTest() {
        advancedOverlayCard.finds(".v-overlay").is().empty();
        advancedOverlayCard.hover();
        advancedOverlayCard.finds(".v-overlay").is().notEmpty();
        Overlay advancedOverlay = new Overlay(advancedOverlayCard.find(".v-overlay"));
        advancedOverlay.is().active();
        advancedOverlay.is().absolute();
        advancedOverlay.is().contentExist();
        zIndexOverlayButton.hover();
        advancedOverlayCard.finds(".v-overlay").is().empty();
    }

    @Test
    public void loaderOverlayTest() {
        loaderOverlay.is().contentNotExist();
        loaderOverlayButton.click();
        loaderOverlay.is().active();
        loaderOverlay.is().contentExist();
        loaderOverlay.content().firstChild().is().cssClass("v-progress-circular");
        loaderOverlay.is().contentNotExist();
    }
}

package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.badgesPage;
import static io.github.com.pages.BadgesPage.clearNotificationsButton;
import static io.github.com.pages.BadgesPage.dotBadge;
import static io.github.com.pages.BadgesPage.dynamicBadge;
import static io.github.com.pages.BadgesPage.hoverBadge;
import static io.github.com.pages.BadgesPage.imageBadge;
import static io.github.com.pages.BadgesPage.sendMessageButton;
import static io.github.com.pages.BadgesPage.simpleBadges;
import static io.github.com.pages.BadgesPage.lockUnlockAccountBadge;

public class BadgesTests extends TestsInit {

    @BeforeClass
    public void before() {
        badgesPage.open();
        waitCondition(() -> badgesPage.isOpened());
        badgesPage.checkOpened();
    }

    @Test
    public void simpleBadgeTest() {
        simpleBadges.forEach(e -> {
            e.badge().is().displayed();
            e.is().type("Text");
            e.has().badgeNumber(1);
        });
    }

    @Test
    public void customBadgeTest() {
        lockUnlockAccountBadge.is().type("Icon");
        lockUnlockAccountBadge.click();
        lockUnlockAccountBadge.has().icon("mdi-lock-open-variant");
        lockUnlockAccountBadge.click();
        lockUnlockAccountBadge.has().icon("mdi-lock");

        dotBadge.is().type("Dot");
        dotBadge.has().dot();

        imageBadge.is().type("Image");
    }

    @Test
    public void dynamicBadgeTest() {
        dynamicBadge.is().type("Text");
        dynamicBadge.badge().is().hidden();

        for (int i = 1; i < 4; i++) {
            sendMessageButton.click();
            dynamicBadge.badge().is().displayed();
            dynamicBadge.has().badgeNumber(i);
        }

        clearNotificationsButton.click();
        dynamicBadge.badge().is().hidden();
    }

    @Test
    public void hoverBadgeTest() {
        hoverBadge.is().type("Text");
        hoverBadge.badge().is().hidden();
        hoverBadge.hover();
        hoverBadge.badge().is().displayed();
        hoverBadge.has().badgeText("9999+");
    }
}

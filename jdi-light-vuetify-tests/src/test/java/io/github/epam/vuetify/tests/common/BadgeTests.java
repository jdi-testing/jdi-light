package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Badge;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.badgesPage;
import static io.github.com.pages.BadgesPage.clearNotificationsButton;
import static io.github.com.pages.BadgesPage.customBadges;
import static io.github.com.pages.BadgesPage.dynamicBadge;
import static io.github.com.pages.BadgesPage.hoverBadge;
import static io.github.com.pages.BadgesPage.hoverIcon;
import static io.github.com.pages.BadgesPage.lockAccountButton;
import static io.github.com.pages.BadgesPage.sendMessageButton;
import static io.github.com.pages.BadgesPage.simpleBadges;
import static io.github.com.pages.BadgesPage.unlockAccountButton;

public class BadgeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        badgesPage.open();
    }

    @Test
    public void simpleBadgeTest() {
        simpleBadges.stream().map(Badge::is).forEach(e -> {
            e.is().displayed();
            e.has().newMessages();
            e.has().numberOfNewMessages(1);
        });
    }

    @Test
    public void customBadgeTest() {
        unlockAccountButton.click();
        lockAccountButton.click();
        customBadges.stream().map(Badge::is).forEach(e -> {
            e.is().displayed();
            e.has().numberOfNewMessages(-1);
        });
    }

    @Test
    public void dynamicBadgeTest() {
        dynamicBadge.is().notDisplayed();
        for(int i = 1; i < 4; i++) {
            sendMessageButton.click();
            dynamicBadge.is().displayed();
            dynamicBadge.has().newMessages();
            dynamicBadge.has().numberOfNewMessages(i);
        }
        clearNotificationsButton.click();
        dynamicBadge.is().notDisplayed();
    }

    @Test
    public void hoverBadgeTest() {
        hoverBadge.is().notDisplayed();
        hoverIcon.hover();
        hoverBadge.is().displayed();
        hoverBadge.has().newMessages();
        hoverBadge.has().numberOfNewMessages(9999);
        hoverBadge.has().text("9999+");
    }
}

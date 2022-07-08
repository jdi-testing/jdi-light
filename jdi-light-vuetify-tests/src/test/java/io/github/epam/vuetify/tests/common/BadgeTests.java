package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Badge;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.badgesPage;
import static io.github.com.pages.BadgesPage.clearNotificationsButton;
import static io.github.com.pages.BadgesPage.customBadges;
import static io.github.com.pages.BadgesPage.dynamicBadge;
import static io.github.com.pages.BadgesPage.hoverBadge;
import static io.github.com.pages.BadgesPage.hoverIcon;
import static io.github.com.pages.BadgesPage.sendMessageButton;
import static io.github.com.pages.BadgesPage.simpleBadges;
import static io.github.com.pages.BadgesPage.lockUnlockAccountButton;

public class BadgeTests extends TestsInit {

    @BeforeClass
    public void before() {
        badgesPage.open();
        waitCondition(() -> badgesPage.isOpened());
        badgesPage.checkOpened();
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
        lockUnlockAccountButton.click();
        customBadges.find(By.tagName("i")).is().classValue(Matchers.containsString("mdi-lock-open-variant"));
        lockUnlockAccountButton.click();
        customBadges.find(By.tagName("i")).is().classValue(Matchers.containsString("mdi-lock "));
    }

    @Test
    public void dynamicBadgeTest() {
        dynamicBadge.is().hidden();
        for(int i = 1; i < 4; i++) {
            sendMessageButton.click();
            waitCondition(() -> dynamicBadge.isDisplayed());
            dynamicBadge.is().displayed();
            dynamicBadge.has().newMessages();
            dynamicBadge.has().numberOfNewMessages(i);
        }
        clearNotificationsButton.click();
        dynamicBadge.is().hidden();
    }

    @Test
    public void hoverBadgeTest() {
        hoverBadge.is().hidden();
        hoverIcon.hover();
        hoverBadge.is().displayed();
        hoverBadge.has().newMessages();
        hoverBadge.has().numberOfNewMessages(9999);
        hoverBadge.has().text("9999+");
    }
}

package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Badge;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.vuetifyPage;
import static io.github.com.StaticSite.badgesPage;
import static io.github.com.pages.BadgesPage.simpleBadges;

public class BadgeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        vuetifyPage.open();
        vuetifyPage.badges.click();
    }

    @Test
    public void simpleBadgeTest() {
        simpleBadges.stream().map(Badge::is).forEach(e -> {
            e.is().displayed();
            e.has().newMessages();
            e.has().numberOfNewMessages(1);
        });
    }
}

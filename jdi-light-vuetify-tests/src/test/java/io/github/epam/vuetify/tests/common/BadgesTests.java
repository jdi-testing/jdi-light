package io.github.epam.vuetify.tests.common;

import io.github.com.enums.Colors;
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
import static io.github.com.pages.BadgesPage.lockUnlockAccountBadge;
import static io.github.com.pages.BadgesPage.sendMessageButton;
import static io.github.com.pages.BadgesPage.simpleBadges;

public class BadgesTests extends TestsInit {

    @BeforeClass
    public void before() {
        badgesPage.open();
        waitCondition(() -> badgesPage.isOpened());
        badgesPage.checkOpened();
    }

    @Test
    public void typeBadgesTest() {
        lockUnlockAccountBadge.is().icon();
        dotBadge.is().notIcon();
        imageBadge.is().avatar();
        dotBadge.is().notAvatar();
        dotBadge.is().dot();
        imageBadge.is().notDot();
    }

    @Test
    public void borderedBadgesTest() {
        imageBadge.show();
        imageBadge.has().bordered();
        simpleBadges.get(1).has().notBordered();
    }

    @Test
    public void bottomBadgesTest() {
        dotBadge.show();
        dotBadge.is().bottom();
        imageBadge.is().notBottom();
    }

    @Test
    public void colorBadgesTest() {
        dotBadge.show();
        dotBadge.has().backgroundColor(Colors.DEEP_PURPLE_ACCENT_4.value());
    }

    @Test
    public void textBadgesTest() {
        simpleBadges.get(1).show();
        simpleBadges.get(1).has().text("1");
    }

    @Test
    public void inlineBadgesTest() {
        simpleBadges.get(5).show();
        simpleBadges.get(5).is().inline();
        simpleBadges.get(4).is().notInline();
    }

    @Test
    public void alignmentBadgesTest() {
        simpleBadges.get(5).show();
        simpleBadges.get(5).has().rightAlignment();
        simpleBadges.get(6).has().leftAlignment();
    }

    @Test
    public void overlapBadgesTest() {
        dotBadge.show();
        lockUnlockAccountBadge.is().overlap();
        dotBadge.is().notOverlap();
    }

    @Test
    public void tileBadgesTest() {
        dynamicBadge.show();
        dynamicBadge.is().tile();
        lockUnlockAccountBadge.is().notTile();
    }

    @Test
    public void displayedBadgesTest() {
        dynamicBadge.show();
        dynamicBadge.is().hidden();
        sendMessageButton.click();
        dynamicBadge.is().displayed();
        clearNotificationsButton.click();
        dynamicBadge.is().hidden();
    }

    @Test
    public void hoverBadgeTest() {
        hoverBadge.badge().is().hidden();
        hoverBadge.hover();
        hoverBadge.badge().is().displayed();
    }

    @Test
    public void iconBadgesTest() {
        lockUnlockAccountBadge.show();
        lockUnlockAccountBadge.has().icon("mdi-lock");
        lockUnlockAccountBadge.click();
        lockUnlockAccountBadge.has().icon("mdi-lock-open-variant");
    }
}

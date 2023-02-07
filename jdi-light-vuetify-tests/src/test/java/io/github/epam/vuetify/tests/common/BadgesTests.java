package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Badge;
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

    @Test(description = "Test checks different types of badges")
    public void typeBadgesTest() {
        lockUnlockAccountBadge.is().icon();
        dotBadge.has().notIcon();
        imageBadge.has().avatar();
        dotBadge.has().notAvatar();
        dotBadge.is().dot();
        imageBadge.is().notDot();
    }

    @Test(description = "Test checks that badge is bordered or not")
    public void borderedBadgesTest() {
        imageBadge.show();
        imageBadge.has().bordered();
        simpleBadges.get(1).has().notBordered();
    }

    @Test(description = "Test checks that badges is on bottom")
    public void bottomBadgesTest() {
        dotBadge.show();
        dotBadge.is().onBottom();
        imageBadge.is().notBottom();
    }

    @Test(description = "Test checks the background color of a badge")
    public void colorBadgesTest() {
        dotBadge.show();
        dotBadge.has().backgroundColor(Colors.DEEP_PURPLE_ACCENT_4.value());
    }

    @Test(description = "Test checks that badge has text")
    public void textBadgesTest() {
        Badge simpleBadge = simpleBadges.get(1);
        simpleBadge.show();
        simpleBadge.has().text("1");
    }

    @Test(description = "Test checks that badge is inline to icon")
    public void inlineBadgesTest() {
        simpleBadges.get(5).show();
        simpleBadges.get(5).is().inline();
        simpleBadges.get(6).is().inline();
        simpleBadges.get(4).is().notInline();
    }

    @Test(description = "Test checks that badge is inline to icon")
    public void alignmentBadgesTest() {
        simpleBadges.get(5).show();
        simpleBadges.get(5).has().rightAlignment();
        simpleBadges.get(6).has().leftAlignment();
    }

    @Test(description = "Test checks overlapped badge for button")
    public void overlapBadgesTest() {
        dotBadge.show();
        lockUnlockAccountBadge.is().overlapped();
        dotBadge.is().notOverlapped();
    }

    @Test(description = "Test checks that badge is a tile")
    public void tileBadgesTest() {
        dynamicBadge.show();
        dynamicBadge.is().tile();
        lockUnlockAccountBadge.is().notTile();
    }

    @Test(description = "Test checks different badges are displayed")
    public void displayedBadgesTest() {
        dynamicBadge.show();
        dynamicBadge.is().hidden();
        sendMessageButton.click();
        dynamicBadge.is().displayed();
        clearNotificationsButton.click();
        dynamicBadge.is().hidden();
    }

    @Test(description = "Test checks that badge appears after hover upon it")
    public void hoverBadgeTest() {
        hoverBadge.badge().is().hidden();
        hoverBadge.hover();
        hoverBadge.badge().is().displayed();
    }

    @Test(description = "Test checks that icon badge changed after clicking on button")
    public void iconBadgesTest() {
        lockUnlockAccountBadge.show();
        lockUnlockAccountBadge.has().icon("mdi-lock");
        lockUnlockAccountBadge.click();
        lockUnlockAccountBadge.has().icon("mdi-lock-open-variant");
    }
}

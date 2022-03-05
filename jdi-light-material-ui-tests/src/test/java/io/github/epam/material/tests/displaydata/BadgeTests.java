package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Badge;
import io.github.epam.TestsInit;
import io.github.epam.test.data.BadgeDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.badgePage;
import static io.github.com.pages.displaydata.BadgePage.buttonIncrease;
import static io.github.com.pages.displaydata.BadgePage.buttonReduce;
import static io.github.com.pages.displaydata.BadgePage.dotBadgeContainer;
import static io.github.com.pages.displaydata.BadgePage.primaryColorBadgeContainer;
import static io.github.com.pages.displaydata.BadgePage.secondaryColorBadgeContainer;
import static io.github.com.pages.displaydata.BadgePage.switchShowBadge;
import static io.github.com.pages.displaydata.BadgePage.switchShowZero;

public class BadgeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        badgePage.open();
        badgePage.isOpened();
    }

    @Test
    public void simpleBadgeTest() {
        primaryColorBadgeContainer.is().displayed();
        primaryColorBadgeContainer.icon().is().displayed();
        primaryColorBadgeContainer.badge().is().displayed()
                .and().has().text("4")
                .and().primaryColor()
                .and().position("TopRightRectangle");
    }

    @Test
    public void variousBadgeTest() {
        secondaryColorBadgeContainer.badge().is().displayed();
        secondaryColorBadgeContainer.badge().has().text("1")
                .and().secondaryColor()
                .and().position("TopRightRectangle");

        buttonReduce.click();
        secondaryColorBadgeContainer.badge().has().text("0").and().is().notVisible();

        switchShowZero.uncheck();
        secondaryColorBadgeContainer.is().visible();
        switchShowZero.check();
        secondaryColorBadgeContainer.badge().is().notVisible();

        buttonIncrease.click();
        for (int i = 1; i <= 10; i++) {
            secondaryColorBadgeContainer.badge().has().text(String.valueOf(i));
            buttonIncrease.click();
        }
        secondaryColorBadgeContainer.badge().has().text("10+");
    }

    @Test
    public void dotBadgeTest() {
        dotBadgeContainer.badge().is().displayed().and().is().dot()
                .and().has().secondaryColor().and().position("TopRightRectangle");

        switchShowBadge.uncheck();
        dotBadgeContainer.badge().is().notVisible();
    }

    @Test(dataProviderClass = BadgeDataProvider.class, dataProvider = "alignmentBadges")
    public void alignmentBadgeTest(Badge badge, String text, String position) {
        badge.is().displayed()
                .and().has().text(text)
                .and().primaryColor()
                .and().position(position);
    }
}

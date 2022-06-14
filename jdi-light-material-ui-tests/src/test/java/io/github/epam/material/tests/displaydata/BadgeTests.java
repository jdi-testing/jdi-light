package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import io.github.epam.TestsInit;
import io.github.epam.test.data.BadgeDataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.badgePage;
import static io.github.com.pages.displaydata.BadgePage.badgeDifferentPosition;
import static io.github.com.pages.displaydata.BadgePage.buttonIncrease;
import static io.github.com.pages.displaydata.BadgePage.buttonReduce;
import static io.github.com.pages.displaydata.BadgePage.dotBadgeContainer;
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
    public void variousBadgeTest() {
        secondaryColorBadgeContainer.icon().is().displayed();
        secondaryColorBadgeContainer.badge().is().displayed()
                .and().has().text(Matchers.containsString("1"))
                .and().position(Position.TOP_RIGHT);

        buttonReduce.click();
        secondaryColorBadgeContainer.badge().has().text(Matchers.containsString("0")).and().is().notVisible();

        switchShowZero.uncheck();
        secondaryColorBadgeContainer.badge().is().notVisible();
        switchShowZero.check();
        secondaryColorBadgeContainer.badge().is().visible();
    }

    @Test
    public void maxValueTest() {
        for (int i = 1; i <= 10; i++) {
            secondaryColorBadgeContainer.badge().has().text(Matchers.containsString(String.valueOf(i)));
            buttonIncrease.click();
        }
        secondaryColorBadgeContainer.badge().has().text(Matchers.containsString("10+"));
    }

    @Test
    public void dotBadgeTest() {
        dotBadgeContainer.badge().is().displayed().and().is().dot()
                .and().position(Position.TOP_RIGHT);

        switchShowBadge.uncheck();
        dotBadgeContainer.badge().is().notVisible();
    }

    @Test(dataProviderClass = BadgeDataProvider.class, dataProvider = "alignmentBadges")
    public void alignmentBadgeTest(int badgeIndex, String text, Position position) {
        badgeDifferentPosition.get(badgeIndex).badge().is().displayed()
                .and().has().text(Matchers.containsString(text))
                .and().position(position);
    }
}

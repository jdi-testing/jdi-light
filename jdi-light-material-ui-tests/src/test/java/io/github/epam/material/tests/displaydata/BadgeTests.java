package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.badgeFrame;
import static io.github.com.StaticSite.dataDisplayBadgeAlignmentPage;
import static io.github.com.StaticSite.dataDisplayBadgePrimaryPage;
import static io.github.com.StaticSite.dataDisplayBadgeDotPage;
import static io.github.com.StaticSite.dataDisplayBadgeInvisiblePage;
import static org.hamcrest.Matchers.containsString;

public class BadgeTests extends TestsInit {

    @Test
    public void primaryBadgeTest() {
        dataDisplayBadgePrimaryPage.open();
        badgeFrame.badge.has().badgeContent(containsString("4"));
        badgeFrame.badge.has().alignment("Top Right");
    }

    @Test
    public void dotBadgeTest() {
        dataDisplayBadgeDotPage.open();
        badgeFrame.badge.is().dot();
    }

    @Test
    public void invisibleBadgeTest() {
        dataDisplayBadgeInvisiblePage.open();
        badgeFrame.badge.is().invisible();
    }

    @Test
    public void alignmentBadgeTest() {
        dataDisplayBadgeAlignmentPage.open();
        badgeFrame.badge.has().alignment("Bottom Left");
    }


}

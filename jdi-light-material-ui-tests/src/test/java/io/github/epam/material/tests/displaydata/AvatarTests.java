package io.github.epam.material.tests.displaydata;

import static io.github.com.StaticSite.avatarPage;
import static io.github.com.pages.displaydata.AvatarPage.avatarsWithIcon;
import static io.github.com.pages.displaydata.AvatarPage.avatarsWithPhoto;
import static io.github.com.pages.displaydata.AvatarPage.avatarsWithText;

import com.epam.jdi.light.material.elements.displaydata.Avatar;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AvatarTests extends TestsInit {

    @DataProvider
    public static Object[][] avatarsWithBadge() {
        return new Object[][]{
                {avatarsWithPhoto.get(1), true, ""},
                {avatarsWithPhoto.get(2), false, "R"}
        };
    }

    @BeforeMethod
    public void beforeTest() {
        avatarPage.open();
    }

    @Test
    public void avatarsWithTextTests() {
        for (Avatar avatar : avatarsWithText) {
            avatar.is().displayed();
        }
        avatarsWithText.get(1).is().text("L");
        avatarsWithText.get(2).is().text("A");
    }

    @Test
    public void avatarsWithPhotoTests() {
        for (Avatar avatar : avatarsWithPhoto) {
            avatar.is().displayed();
            avatar.image().is().displayed();
            avatar.badge().is().displayed();
        }
    }

    @Test(dataProvider = "avatarsWithBadge")
    public void avatarsWithBadgeTests(Avatar avatar, boolean isDot, String badgeText) {
        avatar.is().displayed();
        Badge badge = avatar.badge();
        badge.is().displayed();
        if (isDot) {
            badge.is().dot();
        }
        badge.has().text(badgeText).and().position("BottomRightCircle");
    }

    @Test
    public void avatarsWithIconTests() {
        for (Avatar avatar : avatarsWithIcon) {
            avatar.is().displayed();
            avatar.icon().is().displayed();
            avatar.image().is().hidden();
        }
    }
}

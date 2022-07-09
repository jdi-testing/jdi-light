package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Avatar;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import io.github.epam.TestsInit;
import io.github.epam.test.data.AvatarDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.material.elements.utils.enums.Position.BOTTOM_RIGHT;
import static io.github.com.StaticSite.avatarPage;
import static io.github.com.pages.displaydata.AvatarPage.avatarsWithIcon;
import static io.github.com.pages.displaydata.AvatarPage.avatarsWithPhoto;
import static io.github.com.pages.displaydata.AvatarPage.avatarsWithText;

public class AvatarTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        avatarPage.open();
        avatarPage.isOpened();
    }

    @Test
    public void avatarsWithTextTests() {
        for (Avatar avatar: avatarsWithText) {
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

    @Test(dataProviderClass = AvatarDataProvider.class, dataProvider = "avatarsWithBadge")
    public void avatarsWithBadgeTests(int index, boolean isDot, String badgeText) {
        Avatar avatar = avatarsWithPhoto.get(index);
        avatar.is().displayed();
        Badge badge = avatar.badge();
        badge.is().displayed();
        if (isDot) {
            badge.is().dot();
        }
        badge.has().text(badgeText).and().position(BOTTOM_RIGHT.toString());
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

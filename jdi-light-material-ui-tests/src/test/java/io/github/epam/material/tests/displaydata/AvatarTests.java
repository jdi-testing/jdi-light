package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Avatar;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import com.epam.jdi.light.material.elements.utils.enums.VariantType;
import io.github.epam.TestsInit;
import io.github.epam.test.data.AvatarDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.material.elements.utils.enums.Position.BOTTOM_RIGHT;
import static io.github.com.StaticSite.avatarPage;
import static io.github.com.pages.displaydata.AvatarPage.avatarsWithIcon;
import static io.github.com.pages.displaydata.AvatarPage.badgeWithAvatars;
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
        for (Badge badge : badgeWithAvatars) {
            badge.is().displayed();
            badge.avatar().is().displayed();
            badge.avatar().is().displayed();
        }
    }

    @Test(dataProviderClass = AvatarDataProvider.class, dataProvider = "avatarsWithBadge")
    public void avatarsWithBadgeTests(int index, String badgeText) {
        Badge badge = badgeWithAvatars.get(index);
        badge.is().displayed();
        Avatar avatar = badge.avatar();
        avatar.is().displayed();
        badge.has().dot();
        badge.has().text(badgeText);
    }

    @Test
    public void avatarsWithIconTests() {
        for (Avatar avatar : avatarsWithIcon) {
            avatar.is().displayed();
            avatar.icon().is().displayed();
            avatar.image().is().hidden();
        }
    }

    @Test
    public void avatarsVariantsTests() {
        Avatar avatarL = avatarsWithIcon.get(1);
        avatarL.has().variant(VariantType.CIRCULAR);

        Avatar avatarA = avatarsWithIcon.get(3);
        avatarA.has().variant(VariantType.SQUARE);

        Avatar avatarN = avatarsWithIcon.get(4);
        avatarA.has().variant(VariantType.ROUNDED);
    }
}

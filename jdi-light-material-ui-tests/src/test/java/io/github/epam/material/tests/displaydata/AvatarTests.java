package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Avatar;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import com.epam.jdi.light.material.elements.utils.enums.VariantType;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.material.elements.utils.enums.VariantType.CIRCULAR;
import static com.epam.jdi.light.material.elements.utils.enums.VariantType.SQUARE;
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
        Avatar avatarL = avatarsWithText.get(1);
        avatarL.is().displayed();
        avatarL.is().text("L");
        avatarL.has().variant(CIRCULAR);

        Avatar avatarA = avatarsWithText.get(2);
        avatarA.is().displayed();
        avatarA.is().text("A");
        avatarA.has().variant(SQUARE);
    }

    @Test
    public void avatarsWithPhotoTests() {
        for (Badge badge : badgeWithAvatars) {
            badge.is().displayed();
            badge.avatar().is().displayed();
        }
    }

    @Test()
    public void badgeWithAvatarsAndDotTests() {
        Badge badge = badgeWithAvatars.get(1);
        badge.is().displayed();
        Avatar avatar = badge.avatar();
        avatar.is().displayed();
        badge.has().dot();
        badge.has().text("");
    }
    @Test()
    public void badgeWithAvatarsTests() {
        Badge badge = badgeWithAvatars.get(2);
        badge.is().displayed();
        Avatar avatar = badge.avatar();
        avatar.is().displayed();
        badge.is().dot();
        badge.has().text("R");
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
        avatarL.has().variant(CIRCULAR);

        Avatar avatarN = avatarsWithIcon.get(2);
        avatarN.has().variant(VariantType.ROUNDED);
    }
}

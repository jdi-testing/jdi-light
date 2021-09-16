package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Avatar;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.base.Conditions.displayed;
import static io.github.com.StaticSite.avatarsPage;
import static io.github.com.pages.AvatarsPage.avatarsWithSize;
import static io.github.com.pages.AvatarsPage.profileCard;
import static io.github.com.pages.AvatarsPage.slotAvatars;
import static io.github.com.pages.AvatarsPage.tileAvatar;

public class AvatarTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        avatarsPage.open();
    }

    @Test
    public void avatarsWithSizeTests() {
        avatarsWithSize.get(1).waitFor(displayed);
        for(Avatar avatar : avatarsWithSize) {
            avatar.is().displayed();
        }
        avatarsWithSize.get(1).is().text("36");
        avatarsWithSize.get(2).is().text("48");
        avatarsWithSize.get(3).is().text("62");
        avatarsWithSize.get(1).has().size("36");
        avatarsWithSize.get(2).has().size("48");
        avatarsWithSize.get(3).has().size("62");
    }

    @Test
    public void tileAvatarTests() {
        tileAvatar.waitFor(displayed);
        tileAvatar.is().displayed();
        tileAvatar.has().icon();
        tileAvatar.has().size("48");
    }

    @Test
    public void slotAvatarsTests() {
        slotAvatars.get(1).waitFor(displayed);
        for(Avatar avatar : slotAvatars) {
            avatar.is().displayed();
        }
        slotAvatars.get(1).has().icon();
        slotAvatars.get(2).has().photo();
        slotAvatars.get(3).is().text("CJ");
    }

    @Test
    public void profileCardTests() {
        profileCard.waitUntilImagesAreDisplayed();
        profileCard.is().displayed();
        jdiAssert(profileCard.hasProperName("Marcus Obrien"), Matchers.is(true));
        jdiAssert(profileCard.hasProperJobFunction("Network Engineer"), Matchers.is(true));
        jdiAssert(profileCard.hasAvatarPhoto(), Matchers.is(true));
        jdiAssert(profileCard.hasBackgroundPhoto(), Matchers.is(true));
    }
}

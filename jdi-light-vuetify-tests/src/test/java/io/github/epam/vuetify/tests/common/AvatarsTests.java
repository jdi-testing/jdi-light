package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.StaticSite.avatarsPage;
import static io.github.com.pages.AvatarsPage.avatarsWithSize;
import static io.github.com.pages.AvatarsPage.profileCard;
import static io.github.com.pages.AvatarsPage.slotAvatars;
import static io.github.com.pages.AvatarsPage.tileAvatar;

public class AvatarsTests extends TestsInit {

    @BeforeClass
    public void before() {
        avatarsPage.open();
        waitCondition(() -> avatarsPage.isOpened());
        avatarsPage.checkOpened();
    }

    @Test
    public void avatarsWithSizeTests() {
        avatarsWithSize.forEach(avatar -> avatar.is().displayed());
        avatarsWithSize.get(1).has().text("36");
        avatarsWithSize.get(2).has().text("48");
        avatarsWithSize.get(3).has().text("62");
        avatarsWithSize.get(1).has().size(36);
        avatarsWithSize.get(2).has().size(48);
        avatarsWithSize.get(3).has().size(62);
    }

    @Test
    public void tileAvatarTests() {
        tileAvatar.is().displayed();
        tileAvatar.icon().is().displayed();
        tileAvatar.has().size(48);
    }

    @Test
    public void slotAvatarsTests() {
        slotAvatars.forEach(avatar -> avatar.is().displayed());
        slotAvatars.get(1).icon().is().displayed();
        slotAvatars.get(2).image().is().displayed();
        slotAvatars.get(3).has().text("CJ");
    }

    @Test
    public void profileCardTests() {
        profileCard.is().displayed();
        profileCard.has().userName("Marcus Obrien");
        profileCard.has().userJobFunction("Network Engineer");
        profileCard.avatarImage().is().displayed();
        profileCard.backgroundImage().is().displayed();
    }
}

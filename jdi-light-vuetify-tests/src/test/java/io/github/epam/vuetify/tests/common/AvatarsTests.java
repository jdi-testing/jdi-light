package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.AvatarsTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.avatarsPage;
import static io.github.com.pages.AvatarsPage.avatarsWithSize;
import static io.github.com.pages.AvatarsPage.leftAvatar;
import static io.github.com.pages.AvatarsPage.profileCard;
import static io.github.com.pages.AvatarsPage.rightAvatar;
import static io.github.com.pages.AvatarsPage.slotAvatars;

public class AvatarsTests extends TestsInit {

    @BeforeClass
    public void before() {
        avatarsPage.open();
        waitCondition(() -> avatarsPage.isOpened());
        avatarsPage.checkOpened();
    }

    @Test
    public void leftAvatarsTest() {
        leftAvatar.show();
        leftAvatar.is().leftAlignment();
    }

    @Test
    public void rightAvatarsTest() {
        rightAvatar.show();
        rightAvatar.is().rightAlignment();
    }

    @Test(dataProvider = "avatarsWithSizeTestData", dataProviderClass = AvatarsTestsDataProvider.class)
    public void avatarsWithSizeTests(int avatarNumber, int avatarSize) {
        avatarsWithSize.get(avatarNumber).show();
        avatarsWithSize.get(avatarNumber).is().displayed().and().has().size(avatarSize);
    }

    @Test
    public void slotAvatarsTests() {
        slotAvatars.get(1).show();
        slotAvatars.forEach(avatar -> avatar.is().displayed());
        slotAvatars.get(1).has().icon();
        slotAvatars.get(1).icon().is().displayed();
        slotAvatars.get(2).image().is().displayed();
        slotAvatars.get(3).has().text("CJ");
    }

    @Test
    public void profileCardTests() {
        profileCard.show();
        profileCard.is().displayed()
            .and().has().userName("Marcus Obrien")
            .and().userJobFunction("Network Engineer");
        profileCard.avatarImage().is().displayed();
        profileCard.backgroundImage().is().displayed();
    }
}

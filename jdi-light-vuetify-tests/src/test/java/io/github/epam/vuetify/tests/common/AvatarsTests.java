package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.AvatarsTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
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

    @Test(dataProvider = "avatarsWithSizeTestData", dataProviderClass = AvatarsTestsDataProvider.class)
    public void avatarsWithSizeTests(int avatarNumber, int avatarSize) {
        avatarsWithSize.forEach(avatar -> avatar.is().displayed());
        avatarsWithSize.get(avatarNumber).has().size(avatarSize);
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

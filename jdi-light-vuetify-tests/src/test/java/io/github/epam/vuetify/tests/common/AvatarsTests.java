package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Avatar;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.AvatarsTestsDataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.annotation.Nullable;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.avatarsPage;
import static io.github.com.pages.AvatarsPage.menuAvatarIndigo;
import static io.github.com.pages.AvatarsPage.avatarsWithSize;
import static io.github.com.pages.AvatarsPage.slotAvatars;
import static io.github.com.pages.AvatarsPage.profileCard;
import static io.github.com.pages.AvatarsPage.menuCard;
import static io.github.com.pages.AvatarsPage.avatarMix;


public class AvatarsTests extends TestsInit {

    @BeforeClass
    public void before() {
        avatarsPage.open();
        waitCondition(() -> avatarsPage.isOpened());
        avatarsPage.checkOpened();
    }

    @Test(dataProvider = "avatarsWithSizeTestData", dataProviderClass = AvatarsTestsDataProvider.class)
    public void avatarsWithSizeTests(int avatarNumber, int avatarSize) {
        avatarsWithSize.get(avatarNumber).show();
        avatarsWithSize.get(avatarNumber).is().displayed().and().has().size(avatarSize);
    }

    @Test(dataProvider =  "slotAvatarsTestData", dataProviderClass = AvatarsTestsDataProvider.class)
    public void slotAvatarsTests(int avatarNumber, Boolean checkImage, Boolean checkIcon, @Nullable String cssText) {
        Avatar avatar = slotAvatars.get(avatarNumber);
        avatar.show();
        avatar.is().displayed();
        if (checkImage) {
            avatar.hasImage();
            avatar.image().is().displayed();
        }
        if (checkIcon) {
            avatar.hasIcon();
            avatar.icon().is().displayed();
        }
        if (cssText != null) {
            avatar.has().text(cssText);
        }
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

    @Test
    public void combinationWithMenuTests() {
        menuAvatarIndigo.show();
        menuAvatarIndigo.click();
        waitCondition(()-> menuCard.isDisplayed());
        menuCard.is().displayed()
                .and().has().email("john.doe@doe.com")
                .and().has().text("John Doe");
        menuCard.getEditAccountButton().isClickable();
        menuCard.getEditAccountButton().is().displayed();
        menuCard.getDisconnectedButton().isClickable();
        menuCard.getDisconnectedButton().is().displayed();
        menuCard.avatar().is().displayed();
    }

    @Test(dataProvider = "combinationWithElementsTestData", dataProviderClass = AvatarsTestsDataProvider.class)
    public void combinationWithElementsTests(int avatarNumber) {
        avatarMix.get(avatarNumber);
    }
}

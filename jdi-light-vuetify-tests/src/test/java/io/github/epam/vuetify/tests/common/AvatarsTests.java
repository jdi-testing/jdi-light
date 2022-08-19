package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Avatar;
import io.github.com.enums.BorderRadius;
import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.AvatarsTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.annotation.Nullable;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.avatarsPage;
import static io.github.com.pages.AvatarsPage.avatarsWithSize;
import static io.github.com.pages.AvatarsPage.tileAvatar;
import static io.github.com.pages.AvatarsPage.slotAvatars;
import static io.github.com.pages.AvatarsPage.profileCard;
import static io.github.com.pages.AvatarsPage.menuAvatarIndigo;
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
    public void avatarsWithSizeTests(int avatarNumber, int avatarSize, String color) {
        avatarsWithSize.get(avatarNumber).show();
        avatarsWithSize.get(avatarNumber).is().displayed().and().has().size(avatarSize);
        avatarsWithSize.get(avatarNumber).has().css("border-radius", BorderRadius.CIRCLE.getRadius());
        avatarsWithSize.get(avatarNumber).has().css("background-color", color);
    }

    @Test
    public void tileAvatarTests() {
        tileAvatar.show();
        tileAvatar.has().css("border-radius", BorderRadius.TILE.getRadius());
        tileAvatar.has().css("background-color", Colors.BLUE.value());
    }

    @Test(dataProvider =  "slotAvatarsTestData", dataProviderClass = AvatarsTestsDataProvider.class)
    public void slotAvatarsTests(int avatarNumber, Boolean checkImage, Boolean checkIcon, @Nullable String cssText, String color) {
        Avatar avatar = slotAvatars.get(avatarNumber);
        avatar.show();
        avatar.is().displayed();
        avatar.has().css("border-radius", BorderRadius.CIRCLE.getRadius());
        avatar.has().css("background-color", color);
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
        profileCard.has().css("border-radius", BorderRadius.TILE.getRadius());
        profileCard.has().css("background-color", Colors.TRANSPARENT.value());
        profileCard.avatarImage().is().displayed();
        profileCard.backgroundImage().is().displayed();
    }

    @Test
    public void combinationWithMenuTests() {
        menuAvatarIndigo.show();
        menuAvatarIndigo.click();
        menuAvatarIndigo.has().css("border-radius", BorderRadius.ROUNDED.getRadius());
        waitCondition(()-> menuCard.isDisplayed());
        menuCard.is().displayed()
                .and().has().email("john.doe@doe.com")
                .and().has().text("John Doe");
        menuCard.getEditAccountButton().isClickable();
        menuCard.getEditAccountButton().is().displayed();
        menuCard.getDisconnectedButton().isClickable();
        menuCard.getDisconnectedButton().is().displayed();
        menuCard.avatar().is().displayed();
        menuCard.avatar().has().css("border-radius", BorderRadius.ROUNDED.getRadius());
    }

    @Test(dataProvider = "combinationWithElementsTestData", dataProviderClass = AvatarsTestsDataProvider.class)
    public void combinationWithElementsTests(int avatarNumber, String avatarText, String grayText,
                                             String textNotification, @Nullable String cntNotification) {
        avatarMix.get(avatarNumber).show();
        avatarMix.get(avatarNumber).panelBar().avatar().is().displayed();
        avatarMix.get(avatarNumber).panelBar().has().avatarText(avatarText);
        avatarMix.get(avatarNumber).panelBar().has().greyText(grayText);
        avatarMix.get(avatarNumber).panelBar().has().textNotification(textNotification);
        if(cntNotification != null) { avatarMix.get(avatarNumber).panelBar().has().cntNotification(cntNotification); }
        avatarMix.get(avatarNumber).panelBar().avatar().has().css("border-radius", BorderRadius.ROUNDED.getRadius());
    }
}

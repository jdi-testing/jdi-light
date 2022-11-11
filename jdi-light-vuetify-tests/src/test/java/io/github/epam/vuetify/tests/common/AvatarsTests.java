package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.AvatarsTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.avatarsPage;
import static io.github.com.pages.AvatarsPage.sizeAvatars;
import static io.github.com.pages.AvatarsPage.leftAvatar;
import static io.github.com.pages.AvatarsPage.menuAvatar;
import static io.github.com.pages.AvatarsPage.rightAvatar;
import static io.github.com.pages.AvatarsPage.slotAvatars;
import static io.github.com.pages.AvatarsPage.tileAvatar;

public class AvatarsTests extends TestsInit {

    @BeforeClass
    public void before() {
        avatarsPage.open();
        waitCondition(() -> avatarsPage.isOpened());
        avatarsPage.checkOpened();
    }

    @Test(dataProvider = "colorAvatarTestData", dataProviderClass = AvatarsTestsDataProvider.class)
    public void colorAvatarsTest(int index, String backgroundColor) {
        sizeAvatars.get(index).show();
        sizeAvatars.get(index).has().backgroundColor(backgroundColor);
    }

    @Test(dataProvider = "sizeAvatarsTestData", dataProviderClass = AvatarsTestsDataProvider.class)
    public void sizeAvatarTest(int index, int size) {
        sizeAvatars.get(index).show();
        sizeAvatars.get(index).has().size(size)
                .and().has().height(size)
                .and().has().heightGreaterThan(size - 10)
                .and().has().heightLessThan(size + 10)
                .and().has().width(size)
                .and().has().widthGreaterThan(size - 10)
                .and().has().widthLessThan(size + 10);
    }

    @Test
    public void alignmentAvatarsTest() {
        leftAvatar.show();
        leftAvatar.is().leftAlignment();
        rightAvatar.show();
        rightAvatar.is().rightAlignment();
    }

    @Test
    public void roundedAvatarsTest() {
        menuAvatar.show();
        menuAvatar.is().rounded();
    }

    @Test(dataProvider = "sizeAvatarsTestData", dataProviderClass = AvatarsTestsDataProvider.class)
    public void textAvatarsTest(int index, String text) {
        sizeAvatars.get(index).show();
        sizeAvatars.get(index).has().text(text);
    }

    @Test
    public void tileAvatarsTest() {
        tileAvatar.show();
        tileAvatar.is().tile();
    }

    @Test
    public void displayedAvatarsTests() {
        slotAvatars.get(1).show();
        slotAvatars.forEach(avatar -> avatar.is().displayed());
        slotAvatars.get(1).has().icon();
        slotAvatars.get(1).icon().is().displayed();
        slotAvatars.get(2).image().is().displayed();
    }
}

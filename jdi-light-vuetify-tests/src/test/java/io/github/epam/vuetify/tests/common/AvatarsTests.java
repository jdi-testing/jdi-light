package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Avatar;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.avatarsPage;
import static io.github.com.pages.AvatarsPage.*;

public class AvatarsTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        avatarsPage.open();
    }

    @Test
    public void avatarsWithSizeTests() {
        avatarsWithSize.get(1).waitFor().is().displayed();
        avatarsWithSize.stream().map(Avatar::is).forEach(e -> {
            e.is().displayed();
        });
        avatarsWithSize.get(1).is().text("36");
        avatarsWithSize.get(2).is().text("48");
        avatarsWithSize.get(3).is().text("62");
        avatarsWithSize.get(1).has().size("36");
        avatarsWithSize.get(2).has().size("48");
        avatarsWithSize.get(3).has().size("62");
    }

    @Test
    public void tileAvatarTests() {
        tileAvatar.waitFor().is().displayed();
        tileAvatar.is().displayed();
        tileAvatar.has().icon();
        tileAvatar.has().size("48");
    }

    @Test
    public void slotAvatarsTests() {
        slotAvatars.get(1).waitFor().is().displayed();
        slotAvatars.stream().map(Avatar::is).forEach(e -> {
            e.is().displayed();
        });
        slotAvatars.get(1).has().icon();
        slotAvatars.get(2).has().photo();
        slotAvatars.get(3).is().text("CJ");
    }

    @Test
    public void profileCardTests() {
        profileCard.waitFor().is().displayed();
        profileCard.is().displayed();
        jdiAssert(profileCard.hasProperName("Marcus Obrien"), Matchers.is(true));
        jdiAssert(profileCard.hasProperJobFunction("Network Engineer"), Matchers.is(true));
        jdiAssert(profileCard.hasAvatarPhoto(), Matchers.is(true));
        jdiAssert(profileCard.hasBackgroundPhoto(), Matchers.is(true));
    }
}

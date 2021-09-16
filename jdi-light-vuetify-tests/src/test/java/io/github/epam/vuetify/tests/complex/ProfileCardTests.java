package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.Conditions.displayed;
import static io.github.com.StaticSite.avatarsPage;
import static io.github.com.pages.AvatarsPage.profileCard;

public class ProfileCardTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        avatarsPage.open();
    }

    @Test
    public void profileCardTests() {
        profileCard.waitFor(displayed);
        profileCard.is().displayed();
        profileCard.has().properName("Marcus Obrien");
        profileCard.has().properJobFunction("Network Engineer");
        profileCard.waitUntilImagesAreDisplayed();
        profileCard.has().avatarPhoto();
        profileCard.has().backgroundPhoto();
    }
}

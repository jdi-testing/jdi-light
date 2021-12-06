package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Avatar;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.avatarPage;
import static io.github.com.pages.displaydata.AvatarPage.avatarsWithIcon;
import static io.github.com.pages.displaydata.AvatarPage.avatarsWithPhoto;
import static io.github.com.pages.displaydata.AvatarPage.avatarsWithText;

public class AvatarTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        avatarPage.open();
    }

    @Test
    public void avatarsWithTextTests() {
        Dimension dimension = avatarPage.driver().manage().window().getSize();
        jdiAssert(dimension.width, Matchers.equalTo(801));
        for(Avatar avatar : avatarsWithText) {
            avatar.is().displayed();
        }
        avatarsWithText.get(1).is().text("L");
        avatarsWithText.get(2).is().text("A");
    }

    @Test
    public void avatarsWithPhotoTests() {
        Dimension dimension = avatarPage.driver().manage().window().getSize();
        jdiAssert(dimension.height, Matchers.equalTo(601));
        for(Avatar avatar : avatarsWithPhoto) {
            avatar.is().displayed();
            avatar.has().image();
            avatar.has().badge();
        }
    }

    @Test
    public void avatarsWithIconTests() {
        for(Avatar avatar : avatarsWithIcon) {
            avatar.is().displayed();
            avatar.has().icon();
            avatar.has().noImage();
        }
    }

}

package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.com.StaticSite;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.pages.displaydata.AvatarPage.onlineStatus;
import static io.github.com.pages.displaydata.AvatarPage.avatarWithPhoto;
import static io.github.com.pages.displaydata.AvatarPage.avatarWithoutPhoto;



public class AvatarTests extends TestsInit {
    @BeforeTest
    public void beforeTest() {
        //openSection("Avatar");
        StaticSite.dataDisplayAvatarPage.open();
        StaticSite.dataDisplayAvatarPage.isOpened();
    }

    @Test
    public void avatarTests() {
        testLogic(avatarWithoutPhoto);
        testLogic(avatarWithPhoto);
        onlineStatus.get(1).has().classValue(Matchers.containsString("MuiBadge-dot"));
        onlineStatus.get(2).has().classValue(Matchers.containsString("MuiBadge-anchorOriginBottomRightCircle"));
    }

    private void testLogic(List<UIElement> elements) {
        for (int i = 1; i < elements.size(); i++) {
            elements.get(i).isDisplayed();
            elements.get(i).hasImage();
            if (i > 2)
                elements.get(i).has().classValue(Matchers.containsString("MuiAvatar-square"));
            else
                elements.get(i).has().classValue(Matchers.containsString("MuiAvatar-circle"));
        }
    }
}

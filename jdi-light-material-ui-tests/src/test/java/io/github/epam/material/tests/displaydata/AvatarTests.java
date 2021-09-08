package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.avatarPage;
import static io.github.com.pages.displaydata.AvatarPage.avatarWithPhoto;
import static io.github.com.pages.displaydata.AvatarPage.avatarWithoutPhoto;
import static io.github.com.pages.displaydata.AvatarPage.onlineStatus;

/**
 * To see an example of Avatar web element please visit https://material-ui.com/ru/components/avatars/
 */

public class AvatarTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        avatarPage.open();
    }

    @Test
    public void avatarTests() {
        basicAvatarChecks(avatarWithoutPhoto, true);
        basicAvatarChecks(avatarWithPhoto, false);
        onlineStatus.get(1).has().classValue(Matchers.containsString("MuiBadge-dot"));
        onlineStatus.get(2).has().text("R");
        onlineStatus.get(2).has().classValue(Matchers.containsString("MuiBadge-anchorOriginBottomRightCircle"));
    }

    private void basicAvatarChecks(List<UIElement> elements, boolean noPhoto) {
        for (int i = 1; i <= elements.size(); i++) {
            elements.get(i).isDisplayed();
            elements.get(i).hasImage();
            if (i < 3) {
                if (i == 1 && noPhoto)
                    elements.get(i).has().text("L");
                elements.get(i).has().classValue(Matchers.containsString("MuiAvatar-circle"));
            }
            if (i == 3) {
                elements.get(i).has().text("A");
                elements.get(i).has().classValue(Matchers.containsString("MuiAvatar-square"));
            }
            if (i == 4)
                elements.get(i).has().classValue(Matchers.containsString("MuiAvatar-rounded"));
        }
    }
}

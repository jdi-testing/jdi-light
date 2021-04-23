package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.displaydata.AvatarPage.onlineStatus;
import static io.github.com.pages.displaydata.AvatarPage.avatarWithPhoto;
import static io.github.com.pages.displaydata.AvatarPage.avatarWithoutPhoto;

/**
 * To see an example of Avatar web element please visit https://material-ui.com/ru/components/avatars/
 */
public class AvatarTests extends TestsInit {
    @BeforeTest
    public void beforeTest() {
        openSection("Avatar");
    }

    @Test
    public void avatarTests() {
        Timer timer = new Timer(1000L);
        timer.wait(() -> onlineStatus.get(1).is().displayed());
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

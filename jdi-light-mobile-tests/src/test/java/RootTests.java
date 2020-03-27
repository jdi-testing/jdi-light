import com.epam.jdi.light.mobile.elements.common.AppManager;
import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.Footer.aboutLink;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;
import static io.github.com.tests.recommended.steps.Preconditions.shouldBeLoggedOut;
import static io.github.epam.entities.Users.DEFAULT_USER;


public class RootTests extends StaticTestsInit {

    @Test
    public void rootTest() {
        shouldBeLoggedOut();
        userIcon.tap();
        loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
        System.out.println("Mobile screen size:");
        System.out.println("x: " + AndroidScreen.getScreenSize().width + "; y: " + AndroidScreen.getScreenSize().height);
//        MobileScreen.zoomIn(0.2);
        aboutLink.tap();
        supportPage.checkOpened();
        AppManager.activateApp("com.android.settings");
        MobileScreen.scrollDown(800);
    }
    @Test
    public void initDeepTest() {
        Assert.assertNotNull(homePage.testField);
        Assert.assertNotNull(searchPage.testField);
    }
}

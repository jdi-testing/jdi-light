package io.github.epam.mobile.tests;

import com.epam.jdi.light.mobile.elements.common.AppManager;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.homePage;
import static io.github.com.StaticSite.supportPage;
import static io.github.com.pages.Footer.aboutLink;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;
import static io.github.epam.steps.Preconditions.shouldBeLoggedOut;
import static io.github.epam.entities.Users.DEFAULT_USER;

public class MobileRootTests extends StaticTestsInit {

    private static final String nativeAppIos = "com.apple.Preferences";
    private static final String nativeAppAndroid = "com.android.settings";

    @Test
    public void rootTest() {
        shouldBeLoggedOut();
        userIcon.tap();
        loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
        System.out.println("Mobile screen size:");
        System.out.println("x: " + MobileScreen.getScreenSize().width + "; y: " + MobileScreen.getScreenSize().height);
        aboutLink.tap();
        supportPage.checkOpened();
        AppManager.activateApp(nativeAppAndroid);
        MobileScreen.scrollDown(800);
    }
}

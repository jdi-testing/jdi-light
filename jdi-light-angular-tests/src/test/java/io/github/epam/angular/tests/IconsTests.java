package io.github.epam.angular.tests;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.basicIcon;
import static io.github.com.pages.AngularPage.svgIcon;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class IconsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void checkBasicIconIsDisplayed() {
        basicIcon.show();
        basicIcon.isDisplayed();
    }

    @Test
    public void checkSVGIconIsDisplayed() {
        svgIcon.show();
        svgIcon.isDisplayed();
    }
}

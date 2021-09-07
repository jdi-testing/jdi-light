package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.linkPage;
import static io.github.com.pages.navigation.LinkPage.bodyLink;
import static io.github.com.pages.navigation.LinkPage.inheritColorLink;
import static io.github.com.pages.navigation.LinkPage.link;
import static io.github.com.pages.navigation.LinkPage.underLinedLink;
import static org.hamcrest.Matchers.hasToString;

public class LinkTests extends TestsInit {

    @BeforeMethod
    public void before() {
        linkPage.open();
        linkPage.isOpened();
    }

    @Test
    public void defaultLinkTest() {
        link.is().underlineHover();
        link.is().colorPrimary();
        link.click();
        link.is().text(hasToString("Link"));
    }

    @Test
    public void colorInheritLinkTest() {
        inheritColorLink.is().underlineHover();
        inheritColorLink.is().colorInherit();
        inheritColorLink.click();
        inheritColorLink.is().text(hasToString("color=\"inherit\""));
    }

    @Test
    public void bodyLinkTest() {
        bodyLink.is().underlineHover();
        bodyLink.is().typographyBody();
        bodyLink.click();
        bodyLink.is().text(hasToString("variant=\"body2\""));
    }

    @Test
    public void underlineAlwaysLinkTest() {
        underLinedLink.is().underlineAlways();
        underLinedLink.click();
        underLinedLink.is().text(hasToString("Underlined link4"));
    }
}

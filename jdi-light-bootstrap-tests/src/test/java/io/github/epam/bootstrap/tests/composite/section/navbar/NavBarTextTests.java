package io.github.epam.bootstrap.tests.composite.section.navbar;

import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarText;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class NavBarTextTests extends TestsInit {

    private static final String inlineElement = "Navbar text with an inline element";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void verifySimpleNambarTextTest() {
        String text = navbarText.simpleNavbar.getText();
        Assert.assertEquals(text,inlineElement);
    }
}

package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardNavigation;
import static io.github.epam.states.States.shouldBeLoggedIn;

/**
 * Created by Zaur Bibilov on 24.09.2019
 * Email: zaur_bibilov@epam.com;
 * Skype: dasilveria
 */

public class CardNavigationTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void navLinkClickTest() {
        cardNavigation.menu.select("Active");
        cardNavigation.menu.select("JDI");
    }

}

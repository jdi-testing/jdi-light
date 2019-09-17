package io.github.epam.bootstrap.tests.common;


import io.github.epam.TestsInit;
import static io.github.com.pages.BootstrapPage.breadcrumb;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static io.github.com.StaticSite.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class BreadcrumbTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private static final String HOME_PAGE_TITLE = "Home Page";
    private static final String HTML5_PAGE_TITLE = "HTML 5";
    private static final String BOOTSTRAP_PAGE_TITLE = "Bootstrap";

    private static final String HOME = "Home";
    private static final String HTML5 = "HTML5";
    private static final String BOOTSTRAP = "Bootstrap";

    @Test
    public void getTextTest() {
        assertEquals(breadcrumb.currentItem.getText(), BOOTSTRAP);
//        assertEquals(breadcrumb.itemsList.get(HTML5).getText(), HTML5);
//        assertEquals(breadcrumb.itemsList.get(HOME).getText(), HOME);
    }

    @Test
    public void getValueTest() {
        assertEquals(breadcrumb.currentItem.getValue(), BOOTSTRAP);
//        assertEquals(breadcrumb.itemsList.get(1).getText(), HTML5);
//        assertEquals(breadcrumb.itemsList.get(2).getText(), HOME);
    }

/*        String bsPageT = bsPage.getTitle();

        homePage.shouldBeOpened();
        String homePageT = homePage.getTitle();

        html5Page.shouldBeOpened();
        String html5PageT = html5Page.getTitle();*/
}
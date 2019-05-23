package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.github.com.StaticSite.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;


public class ActionsWebPageTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        leftMenu.select("Contact form");
    }

    @Test
    public void getUrlTest() {

        Assert.assertEquals(WebPage.getUrl(), "");
    }

    @Test
    public void getTitleTest() {

        Assert.assertEquals(WebPage.getTitle(), "");
    }

    @Test
    public void openTest() {

        new WebPage().open("");
    }

    @Test
    public void checkOpenedTest() {

        new WebPage().checkOpened();
    }


    @Test
    public void isOpenedTest() {

        Assert.assertTrue(new WebPage().isOpened());
    }

    @Test
    public void scrollToTopTest() {

        WebPage.scrollToTop();
    }

    @Test
    public void scrollToBottomTest() {

        WebPage.scrollToBottom();
    }

    @Test
    public void scrollDownTest() {

        WebPage.scrollDown(3);
    }

    @Test
    public void scrollUpTest() {

        WebPage.scrollUp(1);
    }

    @Test
    public void scrollRightTest() {

        WebPage.scrollRight(1);
    }

    @Test
    public void scrollLeftTest() {

        WebPage.scrollLeft(1);
    }

    @Test
    public void toStringTest() {

        Assert.assertEquals(new WebPage().toString(), "");
    }
}
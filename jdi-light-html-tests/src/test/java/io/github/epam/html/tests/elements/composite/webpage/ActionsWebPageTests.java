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

        Assert.assertEquals(WebPage.getUrl(), "https://epam.github.io/JDI/");
    }

    @Test
    public void getTitleTest() {

        Assert.assertEquals(WebPage.getTitle(), "!here must be title!");
    }

    @Test
    public void checkOpenedTest() {

        contactFormPage.checkOpened();
    }


    @Test
    public void isOpenedTest() {

        Assert.assertTrue(contactFormPage.isOpened());
    }

    @Test
    public void scrollToBottomTest() {

        WebPage.scrollToBottom();
    }

    @Test
    public void scrollToTopTest() {

        WebPage.scrollToTop();
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

        Assert.assertEquals(new WebPage().toString(), "!here must be WebPage toString() value!");
    }
}
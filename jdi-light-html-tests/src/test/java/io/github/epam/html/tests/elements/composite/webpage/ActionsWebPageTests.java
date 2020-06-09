package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.leftMenu;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;


public class ActionsWebPageTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        leftMenu.select("Contact form");
    }

    @Test
    public void getUrlTest() {
        Assert.assertEquals(WebPage.getUrl(), "https://jdi-testing.github.io/jdi-light/contacts.html");
    }

    @Test
    public void getTitleTest() {
        Assert.assertEquals(WebPage.getTitle(), "Contact Form");
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
        WebPage.scrollDown(30);
    }

    @Test
    public void scrollUpTest() {
        WebPage.scrollUp(20);
    }

    @Test
    public void scrollRightTest() {
        WebPage.scrollRight(10);
    }

    @Test
    public void scrollLeftTest() {
        WebPage.scrollLeft(5);
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals(contactFormPage.toString(), "StaticSite.contactFormPage (url=https://jdi-testing.github.io/jdi-light/contacts.html; title=Contact Form)");
    }
}
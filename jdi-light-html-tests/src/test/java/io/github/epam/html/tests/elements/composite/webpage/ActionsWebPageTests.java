package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;
import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.leftMenu;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;


public class ActionsWebPageTests extends TestsInit {

    @BeforeMethod
    public void before() {
        // We have to set browser size first. Otherwise the scroll and zoom tests won't work
        Dimension dimension = new Dimension(700, 500);
        WebDriverFactory.getDriver().manage().window().setSize(dimension);
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
        String text = "Powered by EPAM";
        boolean execResult = jsExecute("return (document.documentElement.textContent " +
                " || document.documentElement.innerText).indexOf(" +
                "'" + text + "') > -1;");
        Assert.assertEquals(execResult, true);
    }

    @Test
    public void scrollToTopTest() {
        WebPage.scrollToTop();
        boolean execResult = jsExecute("return (window.scrollX == 0 && window.scrollY == 0);");
        Assert.assertEquals(execResult, true);
    }

    @Test
    public void scrollDownTest() throws InterruptedException {
        WebPage.scrollDown(30);
        long execResult = jsExecute("return window.scrollY;");
        Assert.assertEquals(execResult, 30);
    }

    @Test
    public void scrollUpTest() throws InterruptedException {
        WebPage.scrollUp(20);
        long execResult = jsExecute("return window.scrollY;");
        Assert.assertEquals(execResult, 0);
    }

    @Test
    public void scrollRightTest() throws InterruptedException {
        WebPage.scrollRight(10);
        long execResult = jsExecute("return Math.ceil(window.scrollX);");
        Assert.assertEquals(execResult, 10);
    }

    @Test
    public void scrollLeftTest() throws InterruptedException {
        WebPage.scrollLeft(5);
        long execResult = jsExecute("return Math.ceil(window.scrollX);");
        Assert.assertEquals(execResult, 0);
    }

    @Test
    public void zoomTest() throws InterruptedException {
        WebPage.zoom(2);
        jsExecute("var genderDropdownWidth = document.getElementById('gender').offsetWidth; " +
                "console.log(genderDropdownWidth);");
        boolean execResult = jsExecute("return document.getElementById('gender').offsetWidth == 546;");
        Assert.assertEquals(execResult, true);
    }

    @Test
    public void goBackTest() {
        WebPage.back();
        Assert.assertEquals(WebPage.getTitle(), "Home Page");
    }

    @Test
    public void goForwardTest() {
        WebPage.forward();
        Assert.assertEquals(WebPage.getTitle(), "Contact Form");
    }

    @Test
    public void pageRefreshTest() {
        WebPage.refresh();
        Assert.assertEquals(WebPage.getTitle(), "Contact Form");
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals(new WebPage().toString(), " (url=; title=)");
    }
}
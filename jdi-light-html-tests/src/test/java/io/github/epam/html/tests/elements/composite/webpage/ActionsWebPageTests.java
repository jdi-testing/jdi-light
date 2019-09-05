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

    private final int ZOOM_FACTOR = 2;

    @BeforeMethod
    public void before() {
        // We have to set browser size first. Otherwise the scroll and zoom tests won't work
//        Dimension dimension = new Dimension(700, 500);
//        WebDriverFactory.getDriver().manage().window().setSize(dimension);
//        shouldBeLoggedIn();
//        contactFormPage.shouldBeOpened();
//        leftMenu.select("Contact form");
        WebPage.openUrl("https://jdi-testing.github.io/jdi-light/superpage.html");
    }

    @Test
    public void getUrlTest() {
//        Assert.assertEquals(WebPage.getUrl(), "https://jdi-testing.github.io/jdi-light/contacts.html");
        Assert.assertEquals(WebPage.getUrl(), "https://jdi-testing.github.io/jdi-light/superpage.html");
    }

    @Test
    public void getTitleTest() {
//        Assert.assertEquals(WebPage.getTitle(), "Contact Form");
        Assert.assertEquals(WebPage.getTitle(), "Superpage");
    }

//    @Test
//    public void checkOpenedTest() {
//        contactFormPage.checkOpened();
//    }


//    @Test
//    public void isOpenedTest() {
//        Assert.assertTrue(contactFormPage.isOpened());
//    }

    @Test
    public void scrollToBottomTest() {
        WebPage.scrollToBottom();
        boolean execResult = jsExecute("return (" +
                "(window.innerHeight + window.scrollY) >= document.body.scrollHeight);");
        Assert.assertEquals(execResult, true);
    }

    @Test
    public void scrollToTopTest() {
        WebPage.scrollToTop();
        boolean execResult = jsExecute("return (window.scrollX == 0 && window.scrollY == 0);");
        Assert.assertEquals(execResult, true);
    }

    @Test
    public void scrollDownTest() {
        WebPage.scrollDown(30);
        long execResult = jsExecute("return window.scrollY;");
        Assert.assertEquals(execResult, 30);
    }

    @Test
    public void scrollUpTest() {
        WebPage.scrollUp(20);
        long execResult = jsExecute("return window.scrollY;");
        Assert.assertEquals(execResult, 0);
    }

    @Test
    public void scrollRightTest() {
        WebPage.scrollRight(10);
        long execResult = jsExecute("return Math.ceil(window.scrollX);");
        Assert.assertEquals(execResult, 10);
    }

    @Test
    public void scrollLeftTest() {
        WebPage.scrollLeft(5);
        long execResult = jsExecute("return Math.ceil(window.scrollX);");
        Assert.assertEquals(execResult, 0);
    }

    @Test
    public void zoomTest() {
        long initZoom = jsExecute("return Math.round(window.devicePixelRatio * 100);");
        WebPage.zoom(ZOOM_FACTOR);
        long finalZoom = jsExecute("return Math.round(window.devicePixelRatio * 100);");
        long zoomToCheck = finalZoom / ZOOM_FACTOR;
        Assert.assertEquals(zoomToCheck, initZoom);
    }

    @Test
    public void goBackTest() {
        WebPage.back();
        Assert.assertEquals(WebPage.getTitle(), "Home Page");
    }

    @Test
    public void goForwardTest() {
        WebPage.forward();
        Assert.assertEquals(WebPage.getTitle(), "Superpage");
    }

    @Test
    public void pageRefreshTest() {
        WebPage.refresh();
        Assert.assertEquals(WebPage.getTitle(), "Superpage");
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals(new WebPage().toString(), " (url=; title=)");
    }
}
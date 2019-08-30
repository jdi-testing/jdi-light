package io.github.epam.html.tests.elements.composite.webpage;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
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
        boolean execResult = jsExecute("if (" +
                "(document.documentElement.textContent || document.documentElement.innerText).indexOf(" +
                "'Powered by EPAM') > -1" +
                ") { return true; }");
        Assert.assertEquals(execResult, true);
    }

    @Test
    public void scrollToTopTest() {
        WebPage.scrollToTop();
        boolean execResult = jsExecute("if (window.scrollY == 0 && window.scrollX == 0){\n" +
                "return true;\n" +
                "}");
        Assert.assertEquals(execResult, true);
    }

    @Test
    public void scrollDownTest() {
        WebPage.scrollDown(30);
        boolean execResult = jsExecute("if (window.scrollY == 30) {return true;}");
        Assert.assertEquals(execResult, true);
    }

    @Test
    public void scrollUpTest() {
        WebPage.scrollUp(20);
        boolean execResult = jsExecute("if (window.scrollY == 0) {return true;}");
        Assert.assertEquals(execResult, true);
    }

    @Test
    public void scrollRightTest() {
        WebPage.scrollRight(10);
        boolean execResult = jsExecute("console.log(window.scrollX);" +
                "if (window.scrollX == 10) {return true;}");
        Assert.assertEquals(execResult, true);
    }

    @Test
    public void scrollLeftTest() {
        WebPage.scrollLeft(5);
        boolean execResult = jsExecute("if (window.scrollX == 0) {return true;}");
        Assert.assertEquals(execResult, true);
    }

    @Test
    public void zoomInTest() {
        WebPage.zoom(2);
        boolean execResult = jsExecute(
                "console.log('zoomed 2x');" +
                        "const genderDropdownWidth = document.getElementById('gender').offsetWidth;" +
                        "if (genderDropdownWidth == 546) {return true;}"
        );
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
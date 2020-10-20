package io.github.epam.html.tests.elements.composite.page.init;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.jdi.HomePageWeb;
import page.objects.jdi.HomePageWebEx;
import page.objects.selenium.HomePage;
import page.objects.selenium.HomePageEx;

import static com.epam.jdi.light.elements.common.Cookies.clearAllCookies;
import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static page.objects.selenium.PageBase.JDI_DOMAIN;

public class PageInitTests {
    static String expectedUrl(String url) {
        return JDI_DOMAIN + url;
    }
    @BeforeMethod
    public void before() {
        try {
            clearAllCookies();
            logger.trace("before: openUrl");
            openUrl(JDI_DOMAIN);
            logger.trace("before: user-icon");
            $("#user-icon").click();
            logger.trace("before: end");
        } catch (Exception ex) {
            String msg = ex.getMessage() == null ? ex.getCause().getMessage() : ex.getMessage();
            throw new RuntimeException("before: " + msg);
        }
    }
    @Test
    public void loginPageExTest() {
        try {
        HomePageEx page = new HomePageEx();
        Assert.assertEquals(page.url, expectedUrl("/index.html"));
        Assert.assertEquals(page.title, "Home");
        page.userName.sendKeys("Rom");
        page.userNameUI.sendKeys("an");
        page.password.sendKeys("Jdi");
        page.enter.click();
        page.passwordUI.sendKeys("1234");
        page.enterUI.click();
        $("#user-name").is().displayed();
    } catch (Exception ex) {
        String msg = ex.getMessage() == null ? ex.getCause().getMessage() : ex.getMessage();
        throw new RuntimeException("loginPageExTest: " + msg);
    }
    }
    @Test
    public void loginPageTest() {
        try {
            HomePage page = new HomePage();
            page.userName.sendKeys("Rom");
            page.userNameUI.sendKeys("an");
            page.password.sendKeys("Jdi");
            page.enter.click();
            page.passwordUI.sendKeys("1234");
            page.enterUI.click();
            $("#user-name").is().displayed();
        } catch (Exception ex) {
            String msg = ex.getMessage() == null ? ex.getCause().getMessage() : ex.getMessage();
            throw new RuntimeException("loginPageTest: " + msg);
        }
    }
    @Test
    public void loginPageUITest() {
        try {
            HomePageWeb page = new HomePageWeb();
            page.userName.sendKeys("Rom");
            page.userNameUI.sendKeys("an");
            page.password.sendKeys("Jdi");
            page.enter.click();
            page.passwordUI.sendKeys("1234");
            page.loginButton.click();
            $("#user-name").is().displayed();
        } catch (Exception ex) {
            String msg = ex.getMessage() == null ? ex.getCause().getMessage() : ex.getMessage();
            throw new RuntimeException("loginPageUITest: " + msg);
        }
    }

    @Test
    public void loginPageUIExTest() {
        try {
            HomePageWebEx page = new HomePageWebEx();
            page.userName.sendKeys("Rom");
            page.userNameUI.sendKeys("an");
            page.password.sendKeys("Jdi");
            page.enter.click();
            page.passwordUI.sendKeys("1234");
            page.loginButton.click();
            $("#user-name").is().displayed();
        } catch (Exception ex) {
            String msg = ex.getMessage() == null ? ex.getCause().getMessage() : ex.getMessage();
            throw new RuntimeException("loginPageUIExTest: " + msg);
        }
    }
}

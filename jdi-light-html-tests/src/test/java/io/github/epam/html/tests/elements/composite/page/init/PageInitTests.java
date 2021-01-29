package io.github.epam.html.tests.elements.composite.page.init;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.jdi.HomePageWeb;
import page.objects.jdi.HomePageWebEx;
import page.objects.selenium.HomePage;
import page.objects.selenium.HomePageEx;

import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.elements.common.Cookies.clearAllCookies;
import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static java.lang.Thread.currentThread;
import static page.objects.selenium.PageBase.JDI_DOMAIN;

public class PageInitTests {
    static String expectedUrl(String url) {
        return JDI_DOMAIN + url;
    }
    @BeforeMethod
    public void before() {
        clearAllCookies();
        takeScreen("clearAllCookies" + currentThread().getId());
        openUrl(JDI_DOMAIN);
        takeScreen("openUrl" + currentThread().getId());
        $("#user-icon").click();
        takeScreen("userIconClick" + currentThread().getId());
    }
    @Test
    public void loginPageExTest() {
        try {
            HomePageEx page = new HomePageEx();
            takeScreen("loginPageExTest" + currentThread().getId());
            Assert.assertEquals(page.url, expectedUrl("/index.html"));
            Assert.assertEquals(page.title, "Home");
            takeScreen("CheckUrlTitle" + currentThread().getId());
            page.userName.sendKeys("Rom");
            takeScreen("sendKeys_Rom" + currentThread().getId());
            page.userNameUI.sendKeys("an");
            takeScreen("sendKeys_an" + currentThread().getId());
            page.password.sendKeys("Jdi");
            takeScreen("sendKeys_Jdi" + currentThread().getId());
            page.enter.click();
            takeScreen("enterClick" + currentThread().getId());
            page.passwordUI.sendKeys("1234");
            takeScreen("sendKeys1234" + currentThread().getId());
            page.enterUI.click();
            takeScreen("enterUIclick" + currentThread().getId());
            $("#user-name").is().displayed();
            takeScreen("userNameDisplayed" + currentThread().getId());
        } catch (Exception ex) {
            String msg = ex.getMessage() == null ? ex.getCause().getMessage() : ex.getMessage();
            throw new RuntimeException("loginPageExTest: " + msg);
        }
    }
    @Test
    public void loginPageTest() {
        try {
            HomePage page = new HomePage();
            takeScreen("loginPageTest" + currentThread().getId());
            page.userName.sendKeys("Rom");
            takeScreen("sendKeys_Rom" + currentThread().getId());
            page.userNameUI.sendKeys("an");
            takeScreen("sendKeys_an" + currentThread().getId());
            page.password.sendKeys("Jdi");
            takeScreen("sendKeys_Jdi" + currentThread().getId());
            page.enter.click();
            takeScreen("enterClick" + currentThread().getId());
            page.passwordUI.sendKeys("1234");
            takeScreen("sendKeys1234" + currentThread().getId());
            page.enterUI.click();
            takeScreen("enterUIclick" + currentThread().getId());
            $("#user-name").is().displayed();
            takeScreen("userNameDisplayed" + currentThread().getId());
        } catch (Exception ex) {
            String msg = ex.getMessage() == null ? ex.getCause().getMessage() : ex.getMessage();
            throw new RuntimeException("loginPageTest: " + msg);
        }
    }
    @Test
    public void loginPageUITest() {
        try {
            HomePageWeb page = new HomePageWeb();
            takeScreen("loginPageUITest" + currentThread().getId());
            page.userName.sendKeys("Rom");
            takeScreen("sendKeys_Rom" + currentThread().getId());
            page.userNameUI.sendKeys("an");
            takeScreen("sendKeys_an" + currentThread().getId());
            page.password.sendKeys("Jdi");
            takeScreen("sendKeys_Jdi" + currentThread().getId());
            page.enter.click();
            takeScreen("enterClick" + currentThread().getId());
            page.passwordUI.sendKeys("1234");
            takeScreen("sendKeys1234" + currentThread().getId());
            page.loginButton.click();
            takeScreen("loginButtonClick" + currentThread().getId());
            $("#user-name").is().displayed();
            takeScreen("userNameDisplayed" + currentThread().getId());
        } catch (Exception ex) {
            String msg = ex.getMessage() == null ? ex.getCause().getMessage() : ex.getMessage();
            throw new RuntimeException("loginPageUITest: " + msg);
        }
    }

    @Test
    public void loginPageUIExTest() {
        try {
            HomePageWebEx page = new HomePageWebEx();
            takeScreen("loginPageUIExTest" + currentThread().getId());
            page.userName.sendKeys("Rom");
            takeScreen("sendKeys_Rom" + currentThread().getId());
            page.userNameUI.sendKeys("an");
            takeScreen("sendKeys_an" + currentThread().getId());
            page.password.sendKeys("Jdi");
            takeScreen("sendKeys_Jdi" + currentThread().getId());
            page.enter.click();
            takeScreen("enterClick" + currentThread().getId());
            page.passwordUI.sendKeys("1234");
            takeScreen("sendKeys1234" + currentThread().getId());
            page.loginButton.click();
            takeScreen("loginButtonClick" + currentThread().getId());
            $("#user-name").is().displayed();
            takeScreen("userNameDisplayed" + currentThread().getId());
        } catch (Exception ex) {
            String msg = ex.getMessage() == null ? ex.getCause().getMessage() : ex.getMessage();
            throw new RuntimeException("loginPageUIExTest: " + msg);
        }
    }
}

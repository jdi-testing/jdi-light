package io.github.epam.html.tests.elements.composite.page.init;

import org.testng.Assert;
import org.testng.annotations.*;
import page.objects.jdi.*;
import page.objects.selenium.*;

import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.elements.init.UIFactory.*;
import static page.objects.selenium.PageBase.*;

public class PageInitTests {
    static String expecterdUrl(String url) {
        return JDI_DOMAIN + url;
    }
    boolean first = true;
    @BeforeMethod
    public void before() {
        if (first) {
            openUrl(JDI_DOMAIN);
            first = false;
        }
        if ($("#user-name").isDisplayed()) {
            if (!$(".fa-sign-out").isDisplayed()) {
                $("#user-icon").click();
            }
            $(".fa-sign-out").click();
        }
        if (!$("form #name").isDisplayed()) {
            $("#user-icon").click();
        }
    }
    @Test
    public void loginPageExTest() {
        HomePageEx page = new HomePageEx();
        Assert.assertEquals(page.url, expecterdUrl("/index.html"));
        Assert.assertEquals(page.title, "Home");
        page.userName.sendKeys("Rom");
        page.userNameUI.sendKeys("an");
        page.password.sendKeys("Jdi");
        page.enter.click();
        page.passwordUI.sendKeys("1234");
        page.enterUI.click();
        $("#user-name").is().displayed();
    }
    @Test
    public void loginPageTest() {
        HomePage page = new HomePage();
        page.userName.sendKeys("Rom");
        page.userNameUI.sendKeys("an");
        page.password.sendKeys("Jdi");
        page.enter.click();
        page.passwordUI.sendKeys("1234");
        page.enterUI.click();
        $("#user-name").is().displayed();
    }
    @Test
    public void loginPageUITest() {
        HomePageWeb page = new HomePageWeb();
        page.userName.sendKeys("Rom");
        page.userNameUI.sendKeys("an");
        page.password.sendKeys("Jdi");
        page.enter.click();
        page.passwordUI.sendKeys("1234");
        page.loginButton.click();
        $("#user-name").is().displayed();
    }

    @Test
    public void loginPageUIExTest() {
        HomePageWebEx page = new HomePageWebEx();
        page.userName.sendKeys("Rom");
        page.userNameUI.sendKeys("an");
        page.password.sendKeys("Jdi");
        page.enter.click();
        page.passwordUI.sendKeys("1234");
        page.loginButton.click();
        $("#user-name").is().displayed();
    }
}

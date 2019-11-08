package io.github.epam.html.tests.elements.composite.page.init;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.jdi.HomePageWeb;
import page.objects.jdi.HomePageWebEx;
import page.objects.selenium.HomePage;
import page.objects.selenium.HomePageEx;

import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static page.objects.selenium.PageBase.JDI_DOMAIN;

public class PageInitTests {
    private static String expecterdUrl(String url) {
        return JDI_DOMAIN + url;
    }
    private boolean first = true;
    @BeforeMethod
    public void before() {
        if (first) {
            openUrl(JDI_DOMAIN);
            $("#user-icon").click();
            first = false;
        } else {
            $(".fa-sign-out").click();
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

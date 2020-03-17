package io.github.epam.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.StaticTestsInit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.homePage;
import static io.github.com.StaticSite.searchPage;
import static io.github.com.pages.Header.iconSearch;
import static io.github.com.pages.Header.linkText;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;
import static io.github.epam.entities.Users.DEFAULT_USER;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedOut;


public class RootTests extends StaticTestsInit {

    @Test
    public void rootTest() {
        shouldBeLoggedOut();
        //((AppiumDriver) WebDriverFactory.getDriver()).findElementsById("user-icon");
        //homePage.driver().findElement(By.("user-icon")).click(); //Selenium
        //((AppiumDriver) homePage.driver()).findElementById("user-icon").click();;
        //mainTitleName.getText();  //name doesn't work with css and xpath both
        //System.out.println(titleTag);     //tagName doesn't work with css/xpath both
        iconSearch.click();
        //WebDriverFactory.getDriver().findElement(By.linkText("About")).click();
        linkText.click();
        userIcon.click();
        loginForm.submit(DEFAULT_USER, "enter");
        //homePage.checkOpened();
    }
    @Test
    public void initDeepTest() {
        Assert.assertNotNull(homePage.testField);
        Assert.assertNotNull(searchPage.testField);
    }
}

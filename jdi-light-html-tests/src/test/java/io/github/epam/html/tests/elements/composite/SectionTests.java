package io.github.epam.html.tests.elements.composite;

import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static io.github.com.StaticSite.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;

public class SectionTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
    }

    @Test
    public void displayedTest() {
        homePage.shouldBeOpened();
        mainTitle.is().displayed();
    }

    @Test
    public void basePageTest() {
        //place some elements on Base Page and validate that these elements are not null
        //validate that Base action also work for section (like isDisplayed and all is() validations)
        Assert.assertTrue(basePage.passportNumber.isDisplayed());
        basePage.passportNumber.sendKeys("1234");
        Assert.assertEquals(basePage.passportNumber.getText(), "1234");
    }

    @Test
    public void packageVisibleTest() {
        Assert.assertNotNull(mainSection.accessPackageElementName());
        Assert.assertTrue(mainSection.displayedPackageElementReligion());
    }

    @Test
    public void publicVisibleTest() {
        //Validate that they are not null
        //And validate that elements in IFrame are intractable
        mainSection.lastName.setText("lastName");
        Assert.assertNotNull(mainSection.lastName);
        Assert.assertTrue(mainSection.lastName.isDisplayed());
        Assert.assertTrue(mainSection.wather.isDisplayed());
    }

    @Test
    public void staticElementTest() {
        Assert.assertTrue(mainSection.position.isDisplayed());
        Assert.assertTrue(mainSection.passport.isDisplayed());
    }

    @Test
    public void parentLocatorTest() {
        //Use Section (parent) locator as context
        mainSection.wather.findElement(new By.ByCssSelector(".checkbox"));
    }

    @Test
    public void notExtendSectionTest() {
        //Add tests for PageObjects that not extend Section and placed on some WebPage
        Assert.assertTrue($(new By.ByCssSelector(".info-panel-body-log")).isDisplayed());
    }
}

package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.ui.html.common.TextArea;
import io.github.com.pages.BasePage;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        homePage.shouldBeOpened();
    }

    @Test
    public void displayedTest() {
        mainTitle.is().displayed();
    }

    @Test
    public void selectTest() {
        contactFormPage.shouldBeOpened();

        //place some elements on Base Page and validate that these elements are not null
        //validate that Base action also work for section (like isDisplayed and all is() validations)
        BasePage.passportNumber.isDisplayed();
        BasePage.passportNumber.sendKeys("1234");
        Assert.assertEquals(BasePage.passportNumber.getText(), "1234");

        //mainSection.religion.isDisplayed();
        //mainSection.name.setText("name");
        //Assert.assertNotNull(mainSection.name);

        //validate that they are not null
        //and validate that elements in IFrame are intractable
        mainSection.lastName.setText("lastName");
        Assert.assertNotNull(mainSection.lastName);
        mainSection.position.isDisabled();
        mainSection.passport.isDisplayed();
        mainSection.wather.isDisplayed();

        //and use Section (parent) locator as context
        mainSection.wather.findElement(new By.ByCssSelector(".checkbox"));

        //Add tests for PageObjects that not extend Section and placed on some WebPage
        $(new By.ByCssSelector(".info-panel-body-log")).isDisabled();
    }
   }

package io.github.epam.angular.tests;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.basicRadioButtons;
import static io.github.com.pages.AngularPage.firstBasicRadioButton;
import static io.github.com.pages.AngularPage.secondBasicRadioButton;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void basicTest() {
        basicRadioButtons.is().displayed();
        firstBasicRadioButton.is().displayed();
        secondBasicRadioButton.is().displayed();
    }

    @Test
    public void getTextTest() {
        assertEquals(firstBasicRadioButton.getText(), "Option 1");
        assertEquals(secondBasicRadioButton.getText(), "Option 2");
    }
}

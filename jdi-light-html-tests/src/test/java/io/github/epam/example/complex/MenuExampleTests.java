package io.github.epam.example.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.contactFormPage;
import static io.github.com.StaticSite.datesPage;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.StaticSite.leftMenu;
import static io.github.com.enums.Navigation.HTML5;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;

public class MenuExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void selectTest() {
        leftMenu.select("Contact form");
        contactFormPage.checkOpened();
    }

    @Test
    public void selectListTest() {
        leftMenu.select("Service", "Dates");
        datesPage.checkOpened();
    }

    @Test
    public void isValidationTest() {
        leftMenu.is().selected(HTML5);
    }
}

package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.enums.Navigation.*;
import static io.github.epam.html.tests.site.steps.States.*;

public class Menu2DTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }
    @Test
    public void selectTest() {
        leftMenu2D.select("Contact form");
        contactFormPage.checkOpened();
    }
    @Test
    public void selectEnumTest() {
        leftMenu2D.select(MetalsColors);
        metalAndColorsPage.checkOpened();
    }
    @Test
    public void selectListTest() {
        leftMenu2D.select("Service", "Dates");
        datesPage.checkOpened();
    }
    @Test
    public void selectEnumListTest() {
        leftMenu2D.select(Service, Dates);
        datesPage.checkOpened();
    }
    @Test
    public void selectIndexTest() {
        menu2D.select(4);
        metalAndColorsPage.checkOpened();
    }
    @Test
    public void selectIndexListTest() {
        menu2D.select(3, 2);
        datesPage.checkOpened();
    }
}

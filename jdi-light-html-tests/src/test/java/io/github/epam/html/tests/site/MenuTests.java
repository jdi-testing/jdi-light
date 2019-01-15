package io.github.epam.html.tests.site;

import io.github.epam.TestsInit;
import io.github.epam.html.tests.site.steps.Preconditions;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.enums.Navigation.*;
import static org.testng.Assert.assertEquals;

public class MenuTests extends TestsInit {

    @Test
    public void menuTest() {
        Preconditions.shouldBeLoggedIn();
        homePage.shouldBeOpened();
        leftMenu.select(Service, Dates);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }

    @Test
    public void customMenuTest() {
        Preconditions.shouldBeLoggedIn();
        homePage.shouldBeOpened();
        menu.select(ContactForm);
        assertEquals(menu.isSelected(), ContactForm.value);
        menu.select(Service, Dates);
        assertEquals(menu.isSelected(), Service.value);
        datesPage.checkOpened();

    }
}

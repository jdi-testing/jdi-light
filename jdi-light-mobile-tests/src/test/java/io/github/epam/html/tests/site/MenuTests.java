package io.github.epam.html.tests.site;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.enums.Navigation.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class MenuTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        homePage.open();
    }
    @Test
    public void menuTest() {
        leftMenu.select(Service, Dates);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }

    @Test
    public void customMenuTest() {
        menu.select(ContactForm.value);
        assertEquals(menu.selected(), ContactForm.value);
        menu.select(Service, Dates);
        assertEquals(menu.selected(), Service.value);
        datesPage.checkOpened();
    }

    @Test
    public void refreshAssertMenuTest() {
        menu.assertThat().size(is(5));
        menu.select(Service);
        menu.assertThat().size(is(14));
    }

    @Test
    public void refreshSelectTest() {
        menu.select(Service);
        menu.select(Dates);
    }

    @Test
    public void refreshTemplateSelectTest() {
        leftMenu.select(Service);
        leftMenu.select(Dates);
    }
    @Test
    public void refreshIndexSelectTest() {
        menu.select(3);
        menu.select(9);
        usersPage.checkOpened();
    }

}

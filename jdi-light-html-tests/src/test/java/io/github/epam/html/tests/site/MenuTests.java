package io.github.epam.html.tests.site;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.datesPage;
import static io.github.com.StaticSite.homePage;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.StaticSite.leftMenu;
import static io.github.com.StaticSite.menu;
import static io.github.com.StaticSite.usersPage;
import static io.github.com.enums.Navigation.ContactForm;
import static io.github.com.enums.Navigation.Dates;
import static io.github.com.enums.Navigation.ElementsPacks;
import static io.github.com.enums.Navigation.HTML5;
import static io.github.com.enums.Navigation.Service;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class MenuTests extends TestsInit {

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
        menu.select(2);
        menu.select(8);
        usersPage.checkOpened();
    }

}

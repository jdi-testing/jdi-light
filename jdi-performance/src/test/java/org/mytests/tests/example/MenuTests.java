package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.mytests.tests.states.States;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.entities.LeftMenuData.ContactForm;
import static org.mytests.uiobjects.example.entities.LeftMenuData.Dates;
import static org.mytests.uiobjects.example.entities.LeftMenuData.ElementsPacks;
import static org.mytests.uiobjects.example.entities.LeftMenuData.HTML5;
import static org.mytests.uiobjects.example.entities.LeftMenuData.Service;
import static org.mytests.uiobjects.example.site.SiteJdi.datesPage;
import static org.mytests.uiobjects.example.site.SiteJdi.homePage;
import static org.mytests.uiobjects.example.site.SiteJdi.html5Page;
import static org.mytests.uiobjects.example.site.SiteJdi.leftMenu;
import static org.mytests.uiobjects.example.site.SiteJdi.menu;
import static org.testng.Assert.assertEquals;

public class MenuTests extends SimpleTestsInit {

    @Test
    public void menuTest() {
        States.shouldBeLoggedIn();
        homePage.shouldBeOpened();
        leftMenu.select(Service, Dates);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }
    @Test
    public void customMenuTest() {
        States.shouldBeLoggedIn();
        homePage.shouldBeOpened();
        menu.select(ContactForm);
        assertEquals(menu.selected(), ContactForm.value);
        menu.select(Service, Dates);
        menu.is().selected(Dates.value);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }
}

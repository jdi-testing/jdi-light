package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.mytests.tests.preconditions.Preconditions;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.entities.LeftMenuData.*;
import static org.mytests.uiobjects.example.site.SiteJdi.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MenuTests extends SimpleTestsInit {

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
        menu.is().selected(Dates.value);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }
}

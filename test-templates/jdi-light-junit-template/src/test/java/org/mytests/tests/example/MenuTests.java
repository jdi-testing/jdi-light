package org.mytests.tests.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mytests.tests.TestsInit;
import org.mytests.tests.states.States;

import static org.junit.jupiter.api.Assertions.*;
import static org.mytests.uiobjects.example.entities.LeftMenuData.*;
import static org.mytests.uiobjects.example.site.SiteJdi.*;

public class MenuTests extends TestsInit {
    @BeforeEach
    public void openPerformancePage() {
        States.shouldBeLoggedIn();
        homePage.shouldBeOpened();
    }
    @Test
    void menuTest() {
        leftMenu.select(Service, Dates);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }
    @Test
    void customMenuTest() {
        menu.select(ContactForm);
        assertEquals(menu.selected(), ContactForm.value);
        menu.select(Service, Dates);
        menu.is().selected(Dates.value);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }
}

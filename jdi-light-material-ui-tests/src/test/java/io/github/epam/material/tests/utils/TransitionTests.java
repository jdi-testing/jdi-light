package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.utils.TransitionPage.checkboxes;
import static io.github.com.pages.utils.TransitionPage.displayedCollapseFadeTransitions;
import static io.github.com.pages.utils.TransitionPage.transitions;

/**
 * To see an example of Button web element please visit https://material-ui.com/components/transitions/
 */

public class TransitionTests extends TestsInit {

    @BeforeMethod
    public void before() {
        openSection("Transitions");
    }

    @Test
    public void collapseDisplayTest() {
        checkboxes.get(1).click();
        displayedCollapseFadeTransitions.get(1).is().displayed();
        displayedCollapseFadeTransitions.get(2).is().displayed();
    }

    @Test
    public void fadeDisplayTest() {
        checkboxes.get(2).click();
        displayedCollapseFadeTransitions.get(3).is().hidden();
        displayedCollapseFadeTransitions.get(4).is().hidden();
    }

    @Test
    public void growDisplayTest() {
        checkboxes.get(3).click();
        transitions.get(6).is().displayed();
        transitions.get(5).is().displayed();
    }

    @Test
    public void slideDisplayTest() {
        checkboxes.get(4).click();
        transitions.get(7).is().displayed();
    }

    //I think that this test should be changed. it uses 7th and 8th
    // transitions indexes only because slide transition becomes visible in html
    //only after click on slide checkbox. so it confused when the same
    // transitions index are in slideDisplayTest() and in zoomDisplayTest()
    @Test
    public void zoomDisplayTest() {
        checkboxes.get(5).click();
        transitions.get(7).is().displayed();
        transitions.get(8).is().displayed();
    }
}

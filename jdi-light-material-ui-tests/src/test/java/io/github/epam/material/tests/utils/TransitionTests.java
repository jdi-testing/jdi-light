package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.utils.TransitionPage.checkboxes;
import static io.github.com.pages.utils.TransitionPage.transitions;

/**
 * To see an example of Button web element please visit https://material-ui.com/components/transitions/
 */

public class TransitionTests extends TestsInit {

    @BeforeMethod
    public void before() {
        openSection("Transitions");
    }

/*
//both of this test were previously used
  @Test
    public void fadeTransitionTest() {

        transition.is().hidden();
        transition.clickSwitch();
        transition.is().visible();
        transition.has().content("Content");
    }

    @Test
    public void collapseTransitionTest() {

        transition.is().hidden();
        transition.clickSwitch();
        transition.is().visible();
        transition.has().content("Content");
    }*/

    //tried to check functionality of elements but checkboxes does not work
    @Test
    public void transitionsTest() {
        transitions.get(1).isEnabled();
        transitions.get(2).isEnabled();
        checkboxes.get(3).check();
        transitions.get(1).is().enabled();
        transitions.get(2).is().enabled();
    }
}

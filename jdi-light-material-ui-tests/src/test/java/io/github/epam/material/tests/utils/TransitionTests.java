package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.transitionFrame;
import static io.github.com.StaticSite.utilsTransitionCollapsePage;
import static io.github.com.StaticSite.utilsTransitionFadePage;

public class TransitionTests extends TestsInit {

    @Test
    public void fadeTransitionTest() {
        utilsTransitionFadePage.open();

        transitionFrame.transition.is().hidden();
        transitionFrame.transition.clickSwitch();
        transitionFrame.transition.is().visible();
        transitionFrame.transition.has().content("Content");
    }

    @Test
    public void collapseTransitionTest() {
        utilsTransitionCollapsePage.open();

        transitionFrame.transition.is().hidden();
        transitionFrame.transition.clickSwitch();
        transitionFrame.transition.is().visible();
        transitionFrame.transition.has().content("Content");
    }

}

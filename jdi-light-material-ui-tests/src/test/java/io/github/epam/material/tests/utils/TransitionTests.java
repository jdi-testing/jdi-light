package io.github.epam.material.tests.utils;

import static com.epam.jdi.light.material.elements.utils.enums.TransitionType.COLLAPSE;
import static com.epam.jdi.light.material.elements.utils.enums.TransitionType.FADE;
import static com.epam.jdi.light.material.elements.utils.enums.TransitionType.GROW;
import static com.epam.jdi.light.material.elements.utils.enums.TransitionType.SLIDE;
import static com.epam.jdi.light.material.elements.utils.enums.TransitionType.ZOOM;
import static io.github.com.StaticSite.transitionPage;
import static io.github.com.pages.utils.TransitionPage.checkboxes;
import static io.github.com.pages.utils.TransitionPage.collapseFadeTransitions;
import static io.github.com.pages.utils.TransitionPage.growSlideTransitions;
import static io.github.com.pages.utils.TransitionPage.zoomTransitions;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * To see an example of Transitions web element please visit
 * https://material-ui.com/components/transitions/
 */

public class TransitionTests extends TestsInit {

    @BeforeMethod
    public void before() {
        transitionPage.open();
        transitionPage.shouldBeOpened();
    }

    @Test
    public void collapseDisplayTest() {

        collapseFadeTransitions.get(1).is().transitionExited(COLLAPSE);
        collapseFadeTransitions.get(2).is().transitionExited(COLLAPSE);

        checkboxes.get(1).check();

        collapseFadeTransitions.get(1).is().transitionEntered(COLLAPSE);
        collapseFadeTransitions.get(2).is().transitionEntered(COLLAPSE);

        checkboxes.get(1).uncheck();

        collapseFadeTransitions.get(1).is().collapseTransitionHidden(COLLAPSE);
        collapseFadeTransitions.get(1).is().transitionExited(COLLAPSE);
        collapseFadeTransitions.get(2).is().transitionExited(COLLAPSE);
    }

    @Test
    public void fadeDisplayTest() {
        collapseFadeTransitions.get(3).is().transitionExited(FADE);
        collapseFadeTransitions.get(4).is().transitionExited(FADE);

        checkboxes.get(2).check();

        collapseFadeTransitions.get(3).is().transitionEntered(FADE);
        collapseFadeTransitions.get(4).is().transitionEntered(FADE);

        checkboxes.get(2).uncheck();

        collapseFadeTransitions.get(3).is().collapseTransitionHidden(FADE);
        collapseFadeTransitions.get(3).is().transitionExited(FADE);
        collapseFadeTransitions.get(4).is().transitionExited(FADE);
    }

    @Test
    public void growDisplayTest() {
        growSlideTransitions.get(1).is().transitionExited(GROW);
        growSlideTransitions.get(2).is().transitionExited(GROW);

        checkboxes.get(3).check();

        growSlideTransitions.get(1).is().transitionEntered(GROW);
        growSlideTransitions.get(2).is().transitionEntered(GROW);

        checkboxes.get(3).uncheck();

        growSlideTransitions.get(1).is().transitionExited(GROW);
        growSlideTransitions.get(2).is().transitionExited(GROW);
    }

    @Test
    public void slideDisplayTest() {
        growSlideTransitions.get(3).is().transitionExited(SLIDE);

        checkboxes.get(4).check();

        growSlideTransitions.get(3).is().transitionEntered(SLIDE);

        checkboxes.get(4).uncheck();

        growSlideTransitions.get(3).is().transitionExited(SLIDE);
    }

    @Test
    public void zoomDisplayTest() {
        zoomTransitions.get(1).is().transitionExited(ZOOM);
        zoomTransitions.get(2).is().transitionExited(ZOOM);

        checkboxes.get(5).check();

        zoomTransitions.get(1).is().transitionEntered(ZOOM);
        zoomTransitions.get(2).is().transitionEntered(ZOOM);

        checkboxes.get(5).uncheck();

        zoomTransitions.get(1).is().transitionExited(ZOOM);
        zoomTransitions.get(2).is().transitionExited(ZOOM);
    }
}
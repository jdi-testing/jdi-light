package io.github.epam.material.tests.utils;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.material.elements.utils.enums.TransitionType.*;
import static io.github.com.StaticSite.transitionPage;
import static io.github.com.pages.utils.TransitionPage.*;

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
        Timer timer = new Timer(2000L);

        collapseFadeTransitions.get(1).is().transitionExited(COLLAPSE);
        collapseFadeTransitions.get(2).is().transitionExited(COLLAPSE);

        checkboxes.get(1).check();

        timer.wait(() -> collapseFadeTransitions.get(1).is().transitionEntered(COLLAPSE));
        collapseFadeTransitions.get(2).is().transitionEntered(COLLAPSE);

        checkboxes.get(1).uncheck();

        timer.wait(() -> collapseFadeTransitions.get(1).is().collapseTransitionHidden(COLLAPSE));
        collapseFadeTransitions.get(1).is().transitionExited(COLLAPSE);
        collapseFadeTransitions.get(2).is().transitionExited(COLLAPSE);
    }

    @Test
    public void fadeDisplayTest() {
        Timer timer = new Timer(2000L);
        collapseFadeTransitions.get(3).is().transitionExited(FADE);
        collapseFadeTransitions.get(4).is().transitionExited(FADE);;

        checkboxes.get(2).check();

        timer.wait(() -> collapseFadeTransitions.get(3).is().transitionEntered(FADE));
        collapseFadeTransitions.get(4).is().transitionEntered(FADE);

        checkboxes.get(2).uncheck();

        timer.wait(() -> collapseFadeTransitions.get(3).is().collapseTransitionHidden(FADE));
        collapseFadeTransitions.get(3).is().transitionExited(FADE);
        collapseFadeTransitions.get(4).is().transitionExited(FADE);
    }

    @Test
    public void growDisplayTest() {
        Timer timer = new Timer(2000L);
        growSlideTransitions.get(1).is().transitionExited(GROW);
        growSlideTransitions.get(2).is().transitionExited(GROW);

        checkboxes.get(3).check();

        timer.wait(() -> growSlideTransitions.get(1).is().transitionEntered(GROW));
        timer.wait(() -> growSlideTransitions.get(2).is().transitionEntered(GROW));

        checkboxes.get(3).uncheck();

        timer.wait(() -> growSlideTransitions.get(1).is().transitionExited(GROW));
        timer.wait(() -> growSlideTransitions.get(2).is().transitionExited(GROW));
    }

    @Test
    public void slideDisplayTest() {
        Timer timer = new Timer(2000L);
        growSlideTransitions.get(3).is().transitionExited(SLIDE);

        checkboxes.get(4).check();

        timer.wait(() -> growSlideTransitions.get(3).is().transitionEntered(SLIDE));

        checkboxes.get(4).uncheck();

        timer.wait(() -> growSlideTransitions.get(3).is().transitionExited(SLIDE));
    }

    @Test
    public void zoomDisplayTest() {
        Timer timer = new Timer(2000L);
        zoomTransitions.get(1).is().transitionExited(ZOOM);
        zoomTransitions.get(2).is().transitionExited(ZOOM);

        checkboxes.get(5).check();

        timer.wait(() -> zoomTransitions.get(1).is().transitionEntered(ZOOM));
        timer.wait(() -> zoomTransitions.get(2).is().transitionEntered(ZOOM));

        checkboxes.get(5).uncheck();

        timer.wait(() -> zoomTransitions.get(1).is().transitionExited(ZOOM));
        timer.wait(() -> zoomTransitions.get(2).is().transitionExited(ZOOM));
    }
}

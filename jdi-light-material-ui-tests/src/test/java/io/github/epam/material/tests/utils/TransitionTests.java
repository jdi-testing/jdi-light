package io.github.epam.material.tests.utils;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.transitionPage;
import static io.github.com.pages.utils.TransitionPage.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

/**
 * To see an example of Transitions web element please visit https://material-ui.com/components/transitions/
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

        collapseFadeTransitions.get(1).has().classValue(not(containsString("MuiCollapse-entered")));
        collapseFadeTransitions.get(2).has().classValue(not(containsString("MuiCollapse-entered")));

        checkboxes.get(1).check();

        timer.wait(() -> collapseFadeTransitions.get(1).hasClass(containsString("MuiCollapse-entered").toString()));
        collapseFadeTransitions.get(1).has().classValue(containsString("MuiCollapse-entered"));
        collapseFadeTransitions.get(2).has().classValue(containsString("MuiCollapse-entered"));
    }

    @Test
    public void fadeDisplayTest() {
        Timer timer = new Timer(2000L);
        collapseFadeTransitions.get(3).has().classValue(not(containsString("MuiCollapse-entered")));
        collapseFadeTransitions.get(4).has().classValue(not(containsString("MuiCollapse-entered")));

        checkboxes.get(2).check();
        timer.wait(() -> collapseFadeTransitions.get(3).hasClass(containsString("MuiCollapse-entered").toString()));
        collapseFadeTransitions.get(3).has().classValue(containsString("MuiCollapse-entered"));
        collapseFadeTransitions.get(4).has().classValue(containsString("MuiCollapse-entered"));
    }

    @Test
    public void growDisplayTest() {
        growSlideTransitions.get(1).is().hidden();
        growSlideTransitions.get(2).is().hidden();

        checkboxes.get(3).check();

        growSlideTransitions.get(1).is().displayed();
        growSlideTransitions.get(2).is().displayed();
    }

    @Test
    public void slideDisplayTest() {
        growSlideTransitions.get(3).is().hidden();

        checkboxes.get(4).check();

        growSlideTransitions.get(3).is().displayed();
    }

    @Test
    public void zoomDisplayTest() {
        Timer timer = new Timer(2000L);
        zoomTransitions.get(1).is().hidden();
        zoomTransitions.get(2).is().hidden();

        checkboxes.get(5).check();

        zoomTransitions.get(1).is().displayed();
        timer.wait(() -> zoomTransitions.get(2).isDisplayed());
        zoomTransitions.get(2).is().displayed();
    }
}

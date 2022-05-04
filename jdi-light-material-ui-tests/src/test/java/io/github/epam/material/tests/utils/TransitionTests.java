package io.github.epam.material.tests.utils;

import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.material.elements.utils.Transition;
import com.epam.jdi.light.material.elements.utils.enums.TransitionType;
import io.github.epam.TestsInit;
import io.github.epam.test.data.TransitionDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.transitionPage;
import static io.github.com.pages.utils.TransitionPage.collapseTransitions;
import static io.github.com.pages.utils.TransitionPage.fadeTransitions;
import static io.github.com.pages.utils.TransitionPage.growTransitions;
import static io.github.com.pages.utils.TransitionPage.slideTransitions;
import static io.github.com.pages.utils.TransitionPage.switches;
import static io.github.com.pages.utils.TransitionPage.zoomTransitions;

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

    @Test(dataProvider = "transitionTestData", dataProviderClass = TransitionDataProvider.class)
    public void basicFunctionalityTest(TransitionType transitionType, int switchIndex, int transitionIndex) {
        Transition transition = specialTransitionOnThePage(transitionType).get(transitionIndex);
        Switch transitionSwitch = switches.get(switchIndex);
        transition.show();

        transitionSwitch.is().unchecked();
        transition.is().exited();
        transitionSwitch.check();
        transition.is().entered();
        waitCondition(transitionSwitch::isChecked);
        transitionSwitch.uncheck();
        transition.is().exited();
    }

    @Test
    public void collapseHiddenTest() {
        switches.get(1).check();
        collapseTransitions.get(1).is().displayed();
        collapseTransitions.get(2).is().displayed();
        switches.get(1).uncheck();
        collapseTransitions.get(1).is().hidden();
        collapseTransitions.get(2).is().displayed();
    }

    private List<Transition> specialTransitionOnThePage(TransitionType type) {
        List<Transition> transitions;
        switch (type) {
        case COLLAPSE:
            transitions = collapseTransitions;
            break;
        case FADE:
            transitions = fadeTransitions;
            break;
        case GROW:
            transitions = growTransitions;
            break;
        case SLIDE:
            transitions = slideTransitions;
            break;
        case ZOOM:
            transitions = zoomTransitions;
            break;
        default:
            transitions = Collections.emptyList();
            break;
        }
        return transitions;
    }
}

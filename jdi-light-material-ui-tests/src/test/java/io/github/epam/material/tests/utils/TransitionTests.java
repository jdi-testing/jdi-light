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

        transition.is().transitionExited(transitionType);
        transitionSwitch.check();
        transition.is().transitionEntered(transitionType);
        waitCondition(transitionSwitch::isChecked);
        transitionSwitch.uncheck();
        transition.is().transitionExited(transitionType);
    }

    @Test
    public void collapseHiddenTest() {
        switches.get(1).uncheck();
        collapseTransitions.get(1).is().collapseTransitionHidden();
    }

    private List<Transition> specialTransitionOnThePage(TransitionType type) {
        switch (type) {
        case COLLAPSE:
            return collapseTransitions;
        case FADE:
            return fadeTransitions;
        case GROW:
            return growTransitions;
        case SLIDE:
            return slideTransitions;
        case ZOOM:
            return zoomTransitions;
        default:
            return Collections.emptyList();
        }
    }
}

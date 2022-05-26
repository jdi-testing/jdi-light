package io.github.epam.material.tests.utils;

import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.material.elements.utils.Transition;
import io.github.epam.TestsInit;
import io.github.epam.test.data.TransitionDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.transitionPage;
import static io.github.com.pages.utils.TransitionPage.collapseTransitions;
import static io.github.com.pages.utils.TransitionPage.switches;

public class TransitionTests extends TestsInit {

    @BeforeMethod
    public void before() {
        transitionPage.open();
        transitionPage.shouldBeOpened();
    }

    @Test(dataProvider = "transitionTestData", dataProviderClass = TransitionDataProvider.class)
    public void basicFunctionalityTest(Transition transition, int switchIndex) {
        Switch transitionSwitch = switches.get(switchIndex);
        transition.show();

        transitionSwitch.is().unchecked();
        transition.is().exited();
        transitionSwitch.check();
        waitCondition(transitionSwitch::isChecked);
        transition.is().entered();
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
}

package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.material.elements.utils.enums.TransitionType.COLLAPSE;
import static com.epam.jdi.light.material.elements.utils.enums.TransitionType.FADE;
import static com.epam.jdi.light.material.elements.utils.enums.TransitionType.GROW;
import static com.epam.jdi.light.material.elements.utils.enums.TransitionType.SLIDE;
import static com.epam.jdi.light.material.elements.utils.enums.TransitionType.ZOOM;

public class TransitionDataProvider {

    @DataProvider
    public Object[][] transitionTestData() {
        return new Object[][] {
            {COLLAPSE, 1, 1},
            {COLLAPSE, 1, 2},
            {FADE, 2, 1},
            {FADE, 2, 2},
            {GROW, 3, 1},
            {GROW, 3, 2},
            {SLIDE, 4, 1},
            {ZOOM, 5, 1},
            {ZOOM, 5, 2},
        };
    }
}

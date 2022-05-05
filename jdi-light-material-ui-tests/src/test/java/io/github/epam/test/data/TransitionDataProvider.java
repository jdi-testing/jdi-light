package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

import static io.github.com.pages.utils.TransitionPage.collapseTransitions;
import static io.github.com.pages.utils.TransitionPage.fadeTransitions;
import static io.github.com.pages.utils.TransitionPage.growTransitions;
import static io.github.com.pages.utils.TransitionPage.slideTransitions;
import static io.github.com.pages.utils.TransitionPage.zoomTransitions;

public class TransitionDataProvider {

    @DataProvider
    public Object[][] transitionTestData() {
        return new Object[][] {
            {collapseTransitions.get(1), 1},
            {collapseTransitions.get(2), 1},
            {fadeTransitions.get(1), 2},
            {fadeTransitions.get(2), 2},
            {growTransitions.get(1), 3},
            {growTransitions.get(2), 3},
            {slideTransitions.get(1), 4},
            {zoomTransitions.get(1), 5},
            {zoomTransitions.get(2), 5},
        };
    }
}

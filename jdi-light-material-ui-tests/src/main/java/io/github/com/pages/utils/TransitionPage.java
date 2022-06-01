package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.material.elements.utils.Transition;

import java.util.List;

public class TransitionPage extends WebPage {

    @UI("//h2[text()='Collapse']/following::div[contains(@class,'MuiCollapse-root')]")
    public static List<Transition> collapseTransitions;

    @UI("//h2[text()='Fade']/following::div[contains(@class,'MuiPaper-root')]")
    public static List<Transition> fadeTransitions;

    @UI("//h2[text() = 'Grow']//following::div[contains(@class,'MuiPaper-root')]")
    public static List<Transition> growTransitions;

    @UI("//h2[text() = 'Slide']//following::div[contains(@class,'MuiPaper-root')]")
    public static List<Transition> slideTransitions;

    @UI("//h2[text()='Zoom']/following::div[contains(@class,'MuiPaper-root')]")
    public static List<Transition> zoomTransitions;

    @UI("span.MuiSwitch-root")
    public static List<Switch> switches;
}

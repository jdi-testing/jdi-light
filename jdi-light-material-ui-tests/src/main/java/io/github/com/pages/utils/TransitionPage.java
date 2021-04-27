package io.github.com.pages.utils;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;

import java.util.List;

public class TransitionPage extends WebPage {

    @UI("//*[contains(@class,'MuiPaper-root')]")
    public static List<UIElement> transitions;

    @UI("//*[contains(@class,'MuiCollapse-entered')]")
    public static List<UIElement> displayedCollapseFadeTransitions;


    @UI("//*[contains(@class,'MuiSwitch-switchBase MuiSwitch-colorSecondary')]")
    public static List<Checkbox> checkboxes;
}

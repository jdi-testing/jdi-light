package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.material.elements.navigation.Menu;
import com.epam.jdi.light.ui.html.elements.common.Text;


public class ButtonGroupPage extends WebPage {

    @UI("div[aria-label = 'outlined primary button group'].MuiButtonGroup-root")
    public static ButtonGroup basicButtonGroup;

    @UI("div[aria-label = 'vertical contained primary button group'].MuiButtonGroup-root")
    public static ButtonGroup verticalButtonGroup;

    @UI("div[aria-label = 'split button'].MuiButtonGroup-root")
    public static ButtonGroup splitButtonGroup;

    @UI("#split-button-menu")
    public static Menu splitButtonMenu;

    @UI("#basicLastClick")
    public static Text basicLastClick;

    @UI("#verticalLastClick")
    public static Text verticalLastClick;
}


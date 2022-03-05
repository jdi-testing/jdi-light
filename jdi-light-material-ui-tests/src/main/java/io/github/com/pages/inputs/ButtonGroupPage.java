package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIButtonGroup;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.ui.html.elements.common.Text;


public class ButtonGroupPage extends WebPage {

    @UI("//div[@aria-label = 'outlined primary button group']")
    @JDIButtonGroup(list = ".MuiButtonGroup-groupedHorizontal")
    public static ButtonGroup basicButtonGroup;

    @UI("//div[@aria-label = 'vertical contained primary button group']")
    @JDIButtonGroup(list = ".MuiButton-root")
    public static ButtonGroup verticalButtonGroup;

    @UI("//div[@aria-label = 'split button']")
    @JDIButtonGroup(list = ".MuiButtonBase-root")
    public static ButtonGroup splitButtonGroup;

    @UI("#split-button-menu")
    public static Menu splitButtonDropdown;

    @UI("#basicLastClick")
    public static Text basicLastClick;

    @UI("#verticalLastClick")
    public static Text verticalLastClick;
}


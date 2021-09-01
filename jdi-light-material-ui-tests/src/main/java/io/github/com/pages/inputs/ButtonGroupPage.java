package io.github.com.pages.inputs;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIButtonGroup;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;

import java.util.List;


public class ButtonGroupPage extends WebPage {

    @UI("//*[@id='__next']/div/div/div[2]/div/div/div/div[1]/div")
    @JDIButtonGroup(list = ".MuiButtonGroup-groupedHorizontal")
    public static ButtonGroup basicButtonGroup;

    @UI("//*[@id='__next']/div/div/div[2]/div/div/div/div[2]/div")
    @JDIButtonGroup(list = ".MuiButton-root")
    public static ButtonGroup verticalButtonGroup;

    @UI("//*[@id='__next']/div/div/div[2]/div/div/div/div[3]/div")
    @JDIButtonGroup(list = ".MuiButtonBase-root")
    public static ButtonGroup splitButtonGroup;

    @UI("//*[@id='split-button-menu']/li")
    public static List<UIElement> splitButtonDropdown;

}
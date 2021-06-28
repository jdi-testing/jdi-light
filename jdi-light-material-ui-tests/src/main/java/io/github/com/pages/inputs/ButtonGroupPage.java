package io.github.com.pages.inputs;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIButtonGroup;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;


public class ButtonGroupPage extends WebPage {

    @UI("//*[@id=\"__next\"]/div/div/div[2]/div/div/div/div[1]/div")
    public ButtonGroup basicButtonGroup;

    @UI("//*[@id=\"__next\"]/div/div/div[2]/div/div/div/div[2]/div")
    public ButtonGroup verticalButtonGroup;


    @JDIButtonGroup(
            root = "#root",
            mainButton = ".MuiButton-root[1]",
            expand = ".MuiButton-root[2]",
            list = ".MuiPaper-root #split-button-menu")
    public ButtonGroup splitButtonGroup;

}

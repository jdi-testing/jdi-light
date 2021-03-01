package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIPopper;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.material.elements.utils.Popper;

public class PopperFrame extends Section {

    @UI("//button[text()='Toggle Popper']")
    public Button togglePopperButton;

    @UI("//span[text()='top']")
    public Button topButton;

    @UI("//span[text()='left']")
    public Button leftButton;

    @UI("//span[text()='right']")
    public Button rightButton;

    @UI("//span[text()='bottom']")
    public Button bottomButton;

    @JDIPopper(root = "#root",
        tooltip = "//div[./div[text()='The content of the Popper.']]",
        popper = ".makeStyles-paper-1")
    public Popper simplePopper;

    @JDIPopper(root = "#root",
        tooltip = "//div[./div[text()='The content of the Popper.']]",
        popper = ".makeStyles-paper-1")
    public Popper transitionsPopper;

    @JDIPopper(root = "#root",
        tooltip = "//div[./div/p[text()='The content of the Popper.']]",
        popper = ".MuiTypography-body1")
    public Popper topPopper;

    @JDIPopper(root = "#root",
        tooltip = "//div[./div/p[text()='The content of the Popper.']]",
        popper = ".MuiTypography-body1")
    public Popper leftPopper;

    @JDIPopper(root = "#root",
        tooltip = "//div[./div/p[text()='The content of the Popper.']]",
        popper = ".MuiTypography-body1")
    public Popper rightPopper;

    @JDIPopper(root = "#root",
        tooltip = "//div[./div/p[text()='The content of the Popper.']]",
        popper = ".MuiTypography-body1")
    public Popper bottomPopper;
}

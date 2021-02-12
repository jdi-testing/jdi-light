package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDIPopper;
import com.epam.jdi.light.material.elements.utils.Popper;

public class PopperFrame extends Section {

    @JDIPopper(root = "#root", button = "//button[text()='Toggle Popper']",
        tooltip = "//div[./div[text()='The content of the Popper.']]",
        popper = ".makeStyles-paper-1")
    public Popper simplePopper;

    @JDIPopper(root = "#root", button = "//button[text()='Toggle Popper']",
        tooltip = "//div[./div[text()='The content of the Popper.']]",
        popper = ".makeStyles-paper-1")
    public Popper transitionsPopper;

    @JDIPopper(root = "#root", button = "//span[text()='top']",
        tooltip = "//div[./div/p[text()='The content of the Popper.']]",
        popper = ".MuiTypography-body1")
    public Popper topPopper;

    @JDIPopper(root = "#root", button = "//span[text()='left']",
        tooltip = "//div[./div/p[text()='The content of the Popper.']]",
        popper = ".MuiTypography-body1")
    public Popper leftPopper;

    @JDIPopper(root = "#root", button = "//span[text()='right']",
        tooltip = "//div[./div/p[text()='The content of the Popper.']]",
        popper = ".MuiTypography-body1")
    public Popper rightPopper;

    @JDIPopper(root = "#root", button = "//span[text()='bottom']",
        tooltip = "//div[./div/p[text()='The content of the Popper.']]",
        popper = ".MuiTypography-body1")
    public Popper bottomPopper;
}

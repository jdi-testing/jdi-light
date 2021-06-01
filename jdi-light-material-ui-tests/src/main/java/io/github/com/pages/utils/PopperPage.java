package io.github.com.pages.utils;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.material.elements.utils.Popper;

import java.util.List;

public class PopperPage extends WebPage {
    @UI("button")
    public static List<com.epam.jdi.light.ui.html.elements.common.Button> buttons;

    @UI("[role='tooltip']")
    public static UIElement tooltip;


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

    @UI("#simple-popper")
    public Popper simplePopper;

    @UI("#transitions-popper")
    public Popper transitionsPopper;

    @UI("//div[@role = 'tooltip']")
    public Popper topPopper;

    @UI("//div[@role = 'tooltip']")
    public Popper leftPopper;

    @UI("//div[@role = 'tooltip']")
    public Popper rightPopper;

    @UI("//div[@role = 'tooltip']")
    public Popper bottomPopper;
}

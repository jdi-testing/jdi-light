package io.github.com.pages.utils;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.utils.Popper;
import io.github.com.custom.TooltipButton;

import java.util.List;

public class PopperPage extends WebPage {

    @UI("[type=button]")
    public static List<TooltipButton> popperButton;

    @UI("div p.MuiTypography-body1")
    public static UIElement fakeReferenceObject;

    @UI("[role='tooltip']")
    public static Popper popper;
}

package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.ComplexMUIButton;
import com.epam.jdi.light.material.elements.inputs.MUIButton;

import com.epam.jdi.light.ui.html.elements.common.Text;

public class ButtonPage extends WebPage {

    @UI("#contained-button-default")
    public static MUIButton defaultContainedButton;

    @UI("#contained-button-disabled")
    public static MUIButton disabledContainedButton;

    @UI("#contained-button-last-click")
    public static Text containedButtonLastClick;

    @UI("#text-button-default")
    public static MUIButton defaultTextButton;

    @UI("#text-button-disabled")
    public static MUIButton disabledTextButton;

    @UI("#text-button-last-click")
    public static Text textButtonLastClick;

    @UI("#icon-label-button-delete")
    public static MUIButton deleteIconLabelButton;

    @UI("#icon-label-button-talk")
    public static MUIButton talkIconLabelButton;

    @UI("#icon-label-button-last-click")
    public static Text iconLabelButtonLastClick;

    @UI("#icon-button-delete")
    public static MUIButton deleteIconButton;

    @UI("#icon-button-disabled")
    public static MUIButton disabledIconButton;

    @UI("#icon-button-last-click")
    public static Text iconButtonLastClick;

    @UI("#customized-button-custom-css")
    public static MUIButton customCssCustomizedButton;

    @UI("#customized-button-last-click")
    public static Text customizedButtonLastClick;

    @UI("#complex-button-Breakfast")
    public static ComplexMUIButton breakfastComplexButton;

    @UI("#complex-button-last-click")
    public static Text complexButtonLastClick;
}

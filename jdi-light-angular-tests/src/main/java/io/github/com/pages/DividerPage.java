package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Divider;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class DividerPage extends NewAngularPage {

    @UI("/descendant::h3[1]")
    public static UIElement textWithDefaultDividers;

    @UI("#divider-list:first-of-type > mat-divider[role=\"separator\"]")
    public static JList<Divider> defaultDividersSeparators;

    @UI("#divider-list:nth-of-type(2) > mat-divider[role=\"separator\"]")
    public static JList<Divider> insetDividerSeparators;

    @UI(".vertical-dividers > mat-divider[role=\"separator\"]")
    public static JList<Divider> verticalDividerSeparators;

}

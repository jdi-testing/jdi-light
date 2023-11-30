package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Divider;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class DividerPage extends NewAngularPage {

    @UI("/descendant::h3[1]")
    public static UIElement textWithDefaultDividers;

    @UI("#divider-list:first-of-type > mat-list-item")
    public static JList<Divider> defaultDividersList;

    @UI("#divider-list:first-of-type > mat-divider[role=\"separator\"]")
    public static JList<UIElement> defaultDividersSeparators;

    @UI("#divider-list:first-of-type  > mat-list-item:nth-of-type(1)")
    public static UIElement elementDefaultItemOneDivider;

    @UI("#divider-list:first-of-type  > mat-list-item:nth-of-type(2)")
    public static UIElement elementDefaultItemTwoDivider;

    @UI("#divider-list:first-of-type  > mat-list-item:nth-of-type(3)")
    public static UIElement elementDefaultItemThreeDivider;

    @UI("/descendant::h3[2]")
    public static UIElement textInsetDividers;

    @UI("#divider-list:nth-of-type(2) > mat-list-item")
    public static JList<Divider> insetDividersList;

    @UI("#divider-list:nth-of-type(2) > mat-divider[role=\"separator\"]")
    public static JList<UIElement> insetDividerSeparators;

    @UI("#divider-list:nth-of-type(2)  > mat-list-item:nth-of-type(1)")
    public static UIElement elementInsetItemOneDivider;

    @UI("#divider-list:nth-of-type(2)  > mat-list-item:nth-of-type(2)")
    public static UIElement elementInsetItemTwoDivider;

    @UI("#divider-list:nth-of-type(2)  > mat-list-item:nth-of-type(3)")
    public static UIElement elementInsetItemThreeDivider;

    @UI("/descendant::h3[3]")
    public static UIElement textVerticalDividers;

    @UI(".vertical-dividers > mat-list-item")
    public static JList<Divider> verticalDividersList;

    @UI(".vertical-dividers > mat-divider[role=\"separator\"]")
    public static JList<UIElement> verticalDividerSeparators;

    @UI(".vertical-dividers > mat-list-item:nth-of-type(1)")
    public static UIElement elementVerticalItemOneDivider;

    @UI(".vertical-dividers > mat-list-item:nth-of-type(2)")
    public static UIElement elementVerticalItemTwoDivider;

    @UI(".vertical-dividers > mat-list-item:nth-of-type(3)")
    public static UIElement elementVerticalItemThreeDivider;

}

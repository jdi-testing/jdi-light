package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Divider;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class DividerPage extends NewAngularPage {

    @UI("h2.example-h2")
    public static Label textWithBasicDivider;

    @UI("#divider-list:first-of-type > mat-divider[role=\"separator\"]")
    public static JList<Divider> defaultDividers;

    @UI("#divider-list:nth-of-type(2) > mat-divider[role=\"separator\"]")
    public static JList<Divider> insetDivider;

    @UI(".vertical-dividers > mat-divider[role=\"separator\"]")
    public static JList<Divider> verticalDivider;

}

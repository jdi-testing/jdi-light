package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.Sidenav;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class SidenavSection {

    @UI("basic-sidenav")
    public static Sidenav basicSidenav;

    @UI("implicit-main-content")
    public static Sidenav implicitMainContent;

    @UI("open-close-behavior")
    public static Sidenav openCloseBehavior;

    @UI("configurable-mode")
    public static Sidenav configurableMode;

    @UI("custom-escape-backdrop")
    public static Sidenav customEscapeBackdrop;

    @UI("fixed-position")
    public static Sidenav fixedPosition;

    @UI("responsive-content")
    public static Sidenav responsiveContent;
}

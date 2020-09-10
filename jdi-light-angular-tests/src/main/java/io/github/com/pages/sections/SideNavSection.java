package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.complex.RadioButtons;
import com.epam.jdi.light.angular.elements.complex.SideNav;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class SideNavSection {

    public static SideNav basicSideNav;

    public static SideNav implicitMainContent;

    public static SideNav openCloseBehavior;
    @UI("#open-close-behavior mat-checkbox")
    public static Checkbox sideNavOpened;
    @UI("#open-close-behavior button")
    public static Button sideNavToggle;

    public static SideNav configurableMode;
    @UI("#configurable-mode .mat-sidenav button")
    public static Button sideToggle;
    @UI("#configurable-mode .mat-sidenav-content button")
    public static Button contentToggle;
    @UI("#configurable-mode .mat-sidenav .mat-radio-group")
    public static RadioButtons sideNavRadioButtons;
    @UI("#configurable-mode .mat-sidenav-content .mat-radio-group")
    public static RadioButtons contentRadioButtons;

    public static SideNav customEscapeBackdrop;
    @UI("#custom-escape-backdrop .mat-sidenav button")
    public static Button toggleSideNav;
    @UI("#custom-escape-backdrop .mat-sidenav-content button")
    public static Button openSideNav;

    public static SideNav fixedPosition;
    @UI("#fixed-position mat-checkbox")
    public static Checkbox fixSideNav;
    @UI("#fixed-position .mat-sidenav-content button")
    public static Button toggleFixedSideNav;
    @UI("#fixed-position .mat-sidenav-content mat-form-field input[formcontrolname='top']")
    public static UIElement topGap;
    @UI("#fixed-position .mat-sidenav-content mat-form-field input[formcontrolname='bottom']")
    public static UIElement bottomGap;

    public static SideNav responsiveContent;
    @UI("//*[@id='responsive-content']/preceding-sibling::mat-toolbar/button")
    public static Button toolbarToggle;
}

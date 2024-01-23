package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.complex.SideNav;
import com.epam.jdi.light.angular.elements.complex.radiobuttons.RadioGroup;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.com.pages.sections.SideNavSection;

public class SideNavPage extends NewAngularPage {

    public static SideNav basicSideNav;
    public static SideNav basicDrawer;
    public static SideNav sidenavBackdropContainer;
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

    @UI("#configurable-mode .mat-sidenav .mat-mdc-radio-group")
    public static RadioGroup sideNavRadioGroup;
    @UI("#mat-select-position")
    public static UIElement sideNavPosition;

    @UI("#mat-select-focus-on-the-first-item")
    public static UIElement sideNavFocusSelection;

    @UI("#configurable-mode .mat-sidenav-content .mat-mdc-radio-group")
    public static RadioGroup contentRadioGroup;

    public static SideNav customEscapeBackdrop;

    @UI("#custom-escape-backdrop .mat-sidenav button")
    public static Button toggleSideNav;

    @UI("#custom-escape-backdrop .mat-sidenav-content button")
    public static Button openSideNav;

    public static SideNav autoSizeSideNav;

    @UI("#auto-size-side-nav .mat-drawer-content button")
    public static Button toggleAutoNav;

    @UI("#auto-size-side-nav .mat-drawer button")
    public static Button toggleExtraText;

    public static SideNav fixedPosition;

    @UI("#fixed-position mat-checkbox")
    public static Checkbox fixSideNav;

    @UI("#fixed-position .mat-sidenav-content button")
    public static Button toggleFixedSideNav;

    @UI("#fixed-position .mat-sidenav-content mat-form-field input[formcontrolname='top']")
    public static UIElement topGap;

    @UI("#fixed-position .mat-sidenav-content mat-form-field input[formcontrolname='bottom']")
    public static UIElement bottomGap;

    public static SideNavSection sidenavBackdropDrawer;

    public static SideNav responsiveContent;

    @UI("//*[@id='responsive-content']/preceding-sibling::mat-toolbar/button")
    public static Button toolbarToggle;

    @UI("#mat-drawer-open-button")
    public static Button backDropToggle;

    @UI("//button[.//span[contains(@class, 'mdc-button__label') and text()='First Element']]")
    public static Button firstElement;

    @UI("//button[.//span[contains(@class, 'mdc-button__label') and text()='First Element'] and contains(@class, 'cdk-focused')]")
    public static Button firstElementFocused;

    @UI("//button[.//span[contains(@class, 'mdc-button__label') and text()='Second Element']]")
    public static Button secondElement;
}

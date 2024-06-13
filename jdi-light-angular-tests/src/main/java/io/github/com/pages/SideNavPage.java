package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.complex.radiobuttons.RadioGroup;
import com.epam.jdi.light.angular.elements.composite.MaterialSelectorContainer;
import com.epam.jdi.light.angular.elements.composite.SideNavContainer;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.pages.sections.SideNavSection;

public class SideNavPage extends NewAngularPage {

    public static SideNavContainer basicSideNav;
    public static SideNavContainer basicDrawer;
    public static SideNavContainer sidenavBackdropContainer;
    public static SideNavContainer implicitMainContent;
    public static SideNavContainer openCloseBehavior;

    @UI("#open-close-behavior mat-checkbox")
    public static Checkbox sideNavOpened;

    @UI("#open-close-behavior button")
    public static Button sideNavToggle;

    public static SideNavContainer configurableMode;

    @UI("#configurable-mode .mat-sidenav button")
    public static Button sideToggle;

    @UI("#configurable-mode .mat-sidenav-content button")
    public static Button contentToggle;

    @UI("#configurable-mode .mat-sidenav .mat-mdc-radio-group")
    public static RadioGroup sideNavRadioGroup;
    @UI("#mat-select-position")
    public static MaterialSelectorContainer sideNavPosition;

    @UI("#mat-select-focus-on-the-first-item")
    public static MaterialSelectorContainer sideNavFocusSelection;

    @UI("#configurable-mode .mat-sidenav-content .mat-mdc-radio-group")
    public static RadioGroup contentRadioGroup;

    public static SideNavContainer customEscapeBackdrop;

    @UI("#custom-escape-backdrop .mat-sidenav button")
    public static Button toggleSideNav;

    @UI("#custom-escape-backdrop .mat-sidenav-content button")
    public static Button openSideNav;

    public static SideNavContainer autoSizeSideNav;

    @UI("#auto-size-side-nav .mat-drawer-content button")
    public static Button toggleAutoNav;

    @UI("#auto-size-side-nav .mat-drawer button")
    public static Button toggleExtraText;

    public static SideNavContainer fixedPosition;

    @UI("#fixed-position mat-checkbox")
    public static Checkbox fixSideNav;

    @UI("#fixed-position .mat-sidenav-content button")
    public static Button toggleFixedSideNav;

    @UI("#fixed-position .mat-sidenav-content mat-form-field input[formcontrolname='top']")
    public static TextField topGap;

    @UI("#fixed-position .mat-sidenav-content mat-form-field input[formcontrolname='bottom']")
    public static TextField bottomGap;

    public static SideNavSection sidenavBackdropDrawer;

    public static SideNavContainer responsiveContent;

    @UI("//*[@id='responsive-content']/preceding-sibling::mat-toolbar/button")
    public static Button toolbarToggle;

    @UI("#mat-drawer-open-button")
    public static Button backDropToggle;

    @UI("//button[.//span[contains(@class, 'mdc-button__label') and text()='First Element']]")
    public static Button firstElement;

   // @UI("//button[.//span[contains(@class, 'mdc-button__label') and text()='First Element'] and contains(@class, 'cdk-focused')]")
    @UI("//button[contains(@class, 'cdk-focused') and contains(@class, 'cdk-program-focused') and //span[contains(@class, 'mdc-button__label') and text()='First Element']]")
    public static Button firstElementFocused;

    @UI("//button[.//span[contains(@class, 'mdc-button__label') and text()='Second Element']]")
    public static Button secondElement;
}

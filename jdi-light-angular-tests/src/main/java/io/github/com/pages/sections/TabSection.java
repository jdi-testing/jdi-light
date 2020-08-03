package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.ButtonToggle;
import com.epam.jdi.light.angular.elements.complex.Tab;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;

public class TabSection {

    /* BASIC TABS */
    @UI("#basic-tab")
    public Tab basicTabsSection;

    /* USING TABS WITH A CUSTOM LABEL TEMPLATE*/
    @UI("#tab-with-custom-label")
    public Tab tabsWithCustomLabel;

    /*TAB GROUP WITH DYNAMIC HEIGHT BASED ON TAB CONTENTS*/
    @UI("#tab-dynamic-height-based-on-content")
    public Tab tabsWithDynamicHeightBasedOnContent;

    /*TAB GROUP WITH DYNAMICALLY CHANGING TABS*/
    @UI("#dynamically-changing-tabs")
    public Tab tabsWithDynamicChangingCount;
    @UI("#add-new-tab-button")
    public Button addNewTabButton;
    @UI("#delete-tab-button")
    public Button deleteButton;
    @UI("#select-after-adding-checkbox")
    public Checkbox selectTabAfterAddingCheckbox;
    @UI("#select-by-index-input")
    public TextArea selectTabIndexArea;

    /*TAB GROUP WITH THE HEADERS ON THE BOTTOM*/
    @UI("#tab-with-headers-on-the-bottom")
    public Tab tabsWithHeadersOnTheBottom;

    /* TAB GROUP WHERE THE TAB CONTENT IS LOADED LAZILY (WHEN ACTIVATED)*/
    @UI("#tabs-with-lazy-loaded-content")
    public Tab tabsWithLazyLoadedContent;

    /*CUSTOMIZING THE THEME OPTIONS ON THE TAB GROUP*/
    @UI("#tab-group-theme-example")
    public Tab tabGroupThemeExample;
    @UI("#mat-button-toggle-group-color")
    public ButtonToggle  colorButtonToggle;
    @UI("#mat-button-toggle-group-background-color")
    public ButtonToggle backgroundButtonToggle;

    /* TAB GROUP WITH ASYNCHRONOUSLY LOADING TAB CONTENTS*/
    @UI("#tabs-async-loading-content")
    public Tab tabsAsyncLoadingContent;

    /*BASIC USE OF THE TAB NAV BAR*/
    @UI("#tabs-nav-bar")
    public Tab tabsNavBar;
    @UI("#add-link-button")
    public Button  addLinkButton;
    @UI("#toggle-background-button")
    public Button  toggleBackgroundButton;

}

package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.ButtonToggle;
import com.epam.jdi.light.angular.elements.complex.Tabs;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;

public class TabSection {

    /* BASIC TABS */
    @UI("#basic-tab")
    public Tabs basicTabsSection;

    /* USING TABS WITH A CUSTOM LABEL TEMPLATE*/
    @UI("#tab-with-custom-label")
    public Tabs tabsWithCustomLabel;

    /*TAB GROUP WITH DYNAMIC HEIGHT BASED ON TAB CONTENTS*/
    @UI("#tab-dynamic-height-based-on-content")
    public Tabs tabsWithDynamicHeightBasedOnContent;

    /*TAB GROUP WITH DYNAMICALLY CHANGING TABS*/
    @UI("#dynamically-changing-tabs")
    public Tabs tabsWithDynamicChangingCount;
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
    public Tabs tabsWithHeadersOnTheBottom;

    /* TAB GROUP WHERE THE TAB CONTENT IS LOADED LAZILY (WHEN ACTIVATED)*/
    @UI("#tabs-with-lazy-loaded-content")
    public Tabs tabsWithLazyLoadedContent;

    /*CUSTOMIZING THE THEME OPTIONS ON THE TAB GROUP*/
    @UI("#tab-group-theme-example")
    public Tabs tabGroupThemeExample;
    @UI("#mat-button-toggle-group-color")
    public ButtonToggle  colorButtonToggle;
    @UI("#mat-button-toggle-group-background-color")
    public ButtonToggle backgroundButtonToggle;

    /* TAB GROUP WITH ASYNCHRONOUSLY LOADING TAB CONTENTS*/
    @UI("#tabs-async-loading-content")
    public Tabs tabsAsyncLoadingContent;

    /*BASIC USE OF THE TAB NAV BAR*/
    @UI("#tabs-nav-bar")
    public Tabs tabsNavBar;
    @UI("#add-link-button")
    public Button  addLinkButton;
    @UI("#toggle-background-button")
    public Button  toggleBackgroundButton;

}

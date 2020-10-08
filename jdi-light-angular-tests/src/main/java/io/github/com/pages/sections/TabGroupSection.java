package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.ButtonToggle;
import com.epam.jdi.light.angular.elements.complex.TabGroup;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextArea;

public class TabGroupSection {
    @UI("#basic-tab")
    public TabGroup basicTab;

    @UI("#tab-with-custom-label")
    public TabGroup tabWithCustomLabel;

    @UI("#tab-dynamic-height-based-on-content")
    public TabGroup tabDynamicHeightBasedOnContent;

    @UI("#tab-with-headers-on-the-bottom")
    public TabGroup tabWithHeadersOnTheBottom;

    @UI("#tabs-with-lazy-loaded-content")
    public TabGroup tabsWithLazyLoadedContent;

    @UI("#tabs-async-loading-content")
    public TabGroup tabsAsyncLoadingContent;

    @UI("#tab-group-theme-example")
    public TabGroup tabGroupThemeExample;

    @UI("#mat-button-toggle-group-color")
    public ButtonToggle matButtonToggleGroupColor;

    @UI("#mat-button-toggle-background-color")
    public ButtonToggle matButtonToggleGroupBackgroundColor;

    @UI("#tabs-nav-bar")
    public TabGroup tabsNavBar;

    @UI("#add-link-button")
    public Button addLinkButton;

    @UI("toggle-background-button")
    public Button toggleBackgroundButton;

    @UI("#dynamically-changing-tabs")
    public TabGroup dynamicallyChangingTabs;

    @UI("#add-new-tab-button")
    public Button addNewTabButton;

    @UI("#delete-tab-button")
    public Button deleteTabButton;

    @UI("#select-after-adding-checkbox")
    public Checkbox selectAfterAddingCheckbox;

    @UI("#select-by-index-input")
    public TextArea selectByIndexInput;
}

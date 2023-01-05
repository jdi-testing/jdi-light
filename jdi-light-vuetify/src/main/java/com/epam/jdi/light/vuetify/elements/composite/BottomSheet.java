package com.epam.jdi.light.vuetify.elements.composite;


import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.BottomSheetAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

/**
 * To see an example of Bottom Sheet web element please visit <a href="https://vuetifyjs.com/en/components/bottom-sheets/">...</a>
 * <p>
 * Created by Nikita Nechepurenko on 21.09.2021
 * <p>
 * From vuetify docs: "The bottom sheet is a modified v-dialog that slides from the bottom of the screen,
 * similar to a v-bottom-navigation.
 * Whereas a bottom navigation component is for buttons and specific application level actions,
 * a bottom sheet can contain anything."
 * <p>
 * It is a type alias for a section
 */
public class BottomSheet extends UIBaseElement<BottomSheetAssert> implements HasTheme {

    // Element could be presented on a page and isDisplayed would return true but all sheet content is hidden
    // with z-index tricks if the element does not have this css class
    protected static final String ACTIVE_SHEET_CLASSNAME = "v-dialog__content--active";
    protected static final String PERSISTENT_SHEET_CLASSNAME = "v-dialog--persistent";
    protected static final String SCROLLABLE_CLASS = "v-dialog--scrollable";
    protected static final String FULLSCREEN_CLASS = "v-dialog--fullscreen";
    protected static final String INSET_CLASS = "v-bottom-sheet--inset";
    protected static final String DIALOG = ".v-dialog";
    protected static final String SHEET = ".v-sheet";
    protected static final String OPTION_TITLE = "//*[text()='%s']";

    @Override
    public BottomSheetAssert is() {
        return new BottomSheetAssert().set(this);
    }

    protected UIElement dialog() {
        return find(DIALOG);
    }

    protected UIElement sheet() {
        return dialog().find(SHEET);
    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed() && this.core().hasClass(ACTIVE_SHEET_CLASSNAME);
    }

    @JDIAction("Check that {optionName} is presented")
    public boolean isOptionTitlesPresented(String optionName) {
        return find(String.format(OPTION_TITLE, optionName)).isExist();
    }

    @JDIAction("Clicking outside the sheet '{0}'")
    public void clickOutsideOfSheet() {
        core().click(0, 0);
    }

    @JDIAction("Check that '{name}' is persistent")
    public boolean isPersistent() {
        return dialog().hasClass(PERSISTENT_SHEET_CLASSNAME);
    }

    @Override
    @JDIAction("Get '{name}' theme")
    public String theme() {
        return sheet().classLike("theme--");
    }

    @JDIAction("Check that '{name}' is fullscreen")
    public boolean isFullscreen() {
        return dialog().hasClass(FULLSCREEN_CLASS);
    }

    @JDIAction("Check that '{name}' is scrollable")
    public boolean isScrollable() {
        return dialog().hasClass(SCROLLABLE_CLASS);
    }

    @JDIAction("Check that '{name}' is inset")
    public boolean isInset() {
        return dialog().hasClass(INSET_CLASS);
    }

    @JDIAction("Get '{name}' max-width")
    public int getMaxWidthPx() {
        return Integer.parseInt(dialog().css("max-width").replace("px", ""));
    }

    @JDIAction("Get '{name}' max-width")
    public int getWidthPx() {
        return Integer.parseInt(dialog().css("width").replace("px", ""));
    }
}

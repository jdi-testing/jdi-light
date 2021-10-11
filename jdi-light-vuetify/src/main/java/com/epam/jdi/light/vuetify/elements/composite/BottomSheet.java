package com.epam.jdi.light.vuetify.elements.composite;

/**
 * To see an example of Bottom Sheet web element please visit https://vuetifyjs.com/en/components/bottom-sheets/
 *
 * Created by Nikita Nechepurenko on 21.09.2021
 *
 * From vuetify docs: "The bottom sheet is a modified v-dialog that slides from the bottom of the screen,
 * similar to a v-bottom-navigation.
 * Whereas a bottom navigation component is for buttons and specific application level actions,
 * a bottom sheet can contain anything."
 *
 * It is a type alias for a section
 */
public class BottomSheet extends Sheet {

    // Element could be presented on a page and isDisplayed would return true but all sheet content is hidden
    // with z-index tricks if the element does not have this css class
    protected final String ACTIVE_SHEET_CLASSNAME = "v-dialog__content--active";

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed() && this.core().hasClass(ACTIVE_SHEET_CLASSNAME);
    }
}

package io.github.com.custom.bottomsheets;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyList;

public class ListBottomSheet extends Dialog {
    @UI(".v-list")
    public static VuetifyList list;

    public VuetifyList bottomSheetList() {
        return list;
    }

}

package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Divider;

import java.util.List;

public class DividersPage extends VuetifyPage {

    @UI(".v-divider--inset")
    public static List<Divider> horizontalDividers;

    @UI(".v-divider--vertical")
    public static List<Divider> verticalDividers;
}

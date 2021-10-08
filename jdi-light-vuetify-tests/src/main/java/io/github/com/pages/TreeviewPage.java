package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.annotations.JDITreeView;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;

public class TreeviewPage extends VuetifyPage {

    @JDITreeView(core = "#ActivatableTreeview")
    public static TreeView<UIElement> activatableTreeView;

}

package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.annotations.JDITreeView;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import io.github.com.custom.treeview.CheckedNode;

public class TreeviewPage extends VuetifyPage {

    @JDITreeView(core = "#ActivatableTreeview")
    public static TreeView activatableTreeView;

    @JDITreeView(core = "#SelectableTreeview")
    public static TreeView selectableTreeView;

}

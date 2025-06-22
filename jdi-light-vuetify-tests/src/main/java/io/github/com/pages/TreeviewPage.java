package io.github.com.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.annotations.JDITreeView;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;

public class TreeviewPage extends VuetifyPage {
    @UI("#ActivatableTreeview.v-treeview")
    public static TreeView activatableTreeView;

    @UI("#ColorTreeview.v-treeview")
    public static TreeView colorTreeView;

    @UI("#DenseModeTreeview.v-treeview")
    public static TreeView denseTreeView;

    @UI("#HoverableTreeview.v-treeview")
    public static TreeView hoverableTreeView;

    @UI("#ItemDisabledTreeview.v-treeview")
    public static TreeView itemDisabledTreeView;

    @UI("#LoadChildrenTreeview .v-treeview")
    public static TreeView loadChildrenTreeView;

    @UI("#OpenAllTreeview.v-treeview")
    public static TreeView openAllTreeView;

    @UI("#RoundedTreeview.v-treeview")
    public static TreeView roundedTreeView;

    @UI("#SelectableTreeview.v-treeview")
    public static TreeView selectableTreeView;

    @UI("#SelectionTypeTreeview .v-treeview")
    public static TreeView selectionTypeTreeView;

    @UI("#SelectionTypeTreeview .pa-6 > *")
    public static WebList selectionTypeResult;

    @UI("#ShapedTreeview.v-treeview")
    public static TreeView shapedTreeView;

    @UI("#AppendLableTreeview.v-treeview")
    public static TreeView appendLabelTreeView;

    @UI("#SearchFilterTreeview .v-treeview")
    public static TreeView searchFilterTreeView;

    @UI("#SearchFilterTreeview .v-text-field")
    public static Input searchLine;

    @UI("#SearchFilterTreeview .v-input--checkbox")
    public static VueCheckbox caseSensitiveSearchCheckbox;

    @JDITreeView(
        core = "#SelectableIconsTreeview",
        full = "mdi-bookmark",
        not = "mdi-bookmark-outline"
    )
    public static TreeView selectableIconsTreeView;

    @UI("#SelectableIconsTreeview .v-chip__content")
    public static WebList chips;

    @UI("#SelectableIconsTreeview [*'Reset']")
    public static Button reset;
}

package io.github.com.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.vuetify.annotations.JDITreeView;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import com.epam.jdi.light.vuetify.elements.complex.TreeViewDropDown;

public class TreeviewPage extends VuetifyPage {

    @JDropdown(
            root = "#ActivatableTreeview.v-treeview",
            list = "./*[contains(@class, 'v-treeview-node')]",
            expand = ".v-treeview-node__toggle"
    )
    public static TreeViewDropDown activatableTreeView;


//    @JDITreeView(core = "#ActivatableTreeview.v-treeview")
//    public static TreeView activatableTreeView;
//
//    @JDITreeView(core = "#ColorTreeview.v-treeview")
//    public static TreeView colorTreeView;
//
//    @JDITreeView(core = "#DenseModeTreeview.v-treeview")
//    public static TreeView denseTreeView;
//
//    @JDITreeView(core = "#HoverableTreeview.v-treeview")
//    public static TreeView hoverableTreeView;
//
//    @JDITreeView(core = "#ItemDisabledTreeview.v-treeview")
//    public static TreeView itemDisabledTreeView;
//
//    @JDITreeView(core = "#LoadChildrenTreeview .v-treeview")
//    public static TreeView loadChildrenTreeView;
//
//    @UI("#LoadChildrenTreeview .v-card")
//    public static Card card;
//
//    @JDITreeView(core = "#OpenAllTreeview.v-treeview")
//    public static TreeView openAllTreeView;
//
//    @JDITreeView(core = "#RoundedTreeview.v-treeview")
//    public static TreeView roundedTreeView;
//
//    @JDITreeView(core = "#SelectableTreeview.v-treeview")
//    public static TreeView selectableTreeView;
//
//    @JDITreeView(core = "#SelectedColorTreeview.v-treeview")
//    public static TreeView selectedColorTreeView;
//
//    @JDITreeView(core = "#SelectionTypeTreeview .v-treeview")
//    public static TreeView selectionTypeTreeView;
//
//    @UI("#SelectionTypeTreeview .pa-6 > *")
//    public static WebList selectionTypeList;
//
//    @JDITreeView(core = "#ShapedTreeview.v-treeview")
//    public static TreeView shapedTreeView;
//
//    @JDITreeView(core = "#AppendLableTreeview.v-treeview")
//    public static TreeView appendLableTreeView;
//
//    @JDITreeView(core = "#SearchFilterTreeview .v-treeview")
//    public static TreeView searchFilterTreeView;
//
//    @UI("#SearchFilterTreeview .v-input[1]")
//    public static TextField searchLine;
//
//    @UI("#SearchFilterTreeview .v-input[2]")
//    public static Checkbox caseSensitiveSearch;
//
//    @JDITreeView(core = "#SelectableIconsTreeview .v-treeview")
//    public static TreeView selectableIconsTreeView;
//
//    @UI("#SelectableIconsTreeview .v-chip__content")
//    public static WebList chips;
}

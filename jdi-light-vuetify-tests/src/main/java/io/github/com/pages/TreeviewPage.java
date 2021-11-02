package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.annotations.JDITreeView;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;

public class TreeviewPage extends VuetifyPage {

    @JDITreeView(core = "#ActivatableTreeview.v-treeview")
    public static TreeView activatableTreeView;

    @JDITreeView(core = "#ColorTreeview.v-treeview")
    public static TreeView colorTreeView;

    @JDITreeView(core = "#DenseModeTreeview.v-treeview")
    public static TreeView denseTreeView;

    @JDITreeView(core = "#HoverableTreeview.v-treeview")
    public static TreeView hoverableTreeView;

    @JDITreeView(core = "#ItemDisabledTreeview.v-treeview")
    public static TreeView itemDisabledTreeView;

    @JDITreeView(core = "#LoadChildrenTreeview .v-treeview")
    public static TreeView loadChildrenTreeView;

    @UI("#LoadChildrenTreeview .v-card")
    public static Card userCard;

    @JDITreeView(core = "#OpenAllTreeview.v-treeview")
    public static TreeView openAllTreeView;

    @JDITreeView(core = "#RoundedTreeview.v-treeview")
    public static TreeView roundedTreeView;

    @JDITreeView(core = "#SelectableTreeview.v-treeview")
    public static TreeView selectableTreeView;

    @JDITreeView(core = "#SelectedColorTreeview.v-treeview")
    public static TreeView selectedColorTreeView;

    @JDITreeView(core = "#SelectionTypeTreeview .v-treeview")
    public static TreeView selectionTypeTreeView;

    @UI("#SelectionTypeTreeview .v-input__control input[id^='input']")
    public static UIElement selectionTypeId;

    @UI("#SelectionTypeTreeview .v-input__control .v-icon")
    public static UIElement selectionTypeExpander;

    @UI("#SelectionTypeTreeview .pa-6 > *")
    public static WebList selectionTypeResult;

    @JDITreeView(core = "#ShapedTreeview.v-treeview")
    public static TreeView shapedTreeView;

    @JDITreeView(core = "#AppendLableTreeview.v-treeview")
    public static TreeView appendLabelTreeView;

    @JDITreeView(core = "#SearchFilterTreeview .v-treeview")
    public static TreeView searchFilterTreeView;

    @UI("#SearchFilterTreeview .v-input .v-text-field__slot input")
    public static UIElement searchLine;

    @UI("#SearchFilterTreeview .v-input .v-input__append-inner button")
    public static UIElement clearSearchButton;

    @UI("#SearchFilterTreeview .v-input .v-input--selection-controls__input")
    public static Checkbox caseSensitiveSearchCheckbox;

    @JDITreeView(
            core = "#SelectableIconsTreeview .v-treeview",
            full = "mdi-bookmark",
            part = "mdi-bookmark-minus",
            not = "mdi-bookmark-outline"
    )
    public static TreeView selectableIconsTreeView;

    @UI("#SelectableIconsTreeview .v-chip__content")
    public static WebList chips;

    @UI("#SelectableIconsTreeview [*'Reset']")
    public static Button reset;
}

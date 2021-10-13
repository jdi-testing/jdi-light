package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.*;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.vuetify.asserts.TreeViewDropDownAssert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.PrintUtils.print;

public class TreeView extends Dropdown
        implements ISetup, HasCheck, IMultiSelector, CanBeSelected, IClickable, IListSelector<TreeView> {

    protected String CORE_LOCATOR = ".v-treeview | .v-treeview-node";
    protected String NODES_IN_CORE_LOCATOR = "./*[contains(@class, 'v-treeview-node')]";
    protected String NODES_IN_NODE_LOCATOR = "./*[contains(@class, 'v-treeview-node__children')]/*[contains(@class, 'v-treeview-node')]";
    protected String ROOT_IN_NODE_LOCATOR = "./*[contains(@class, 'v-treeview-node__root')]";
    protected String TOGGLE_IN_ROOT_LOCATOR = ".v-treeview-node__toggle";
    protected String CHECKBOX_IN_ROOT_LOCATOR = ".v-treeview-node__checkbox";
    protected String CONTENT_IN_ROOT_LOCATOR = ".v-treeview-node__content";

    protected String CORE_CLASS = "v-treeview";
    protected String LEAF_CLASS = "v-treeview-node--leaf";
    protected String SELECTED_NODE_CLASS = "v-treeview-node--selected";
    protected String ACTIVE_NODE_CLASS = "v-treeview-node--active";
    protected String DISABLED_NODE_CLASS = "v-treeview-node--disabled";

    @JDIAction("Check if '{name}' is a pseudo core node")
    public boolean isPseudoCore() {
        Dropdown dropdown = new Dropdown();
        return core().hasClass(CORE_CLASS);
    }

    @Override
    public int size() {
        return elements(0).size();
    }

    @JDIAction("Check if '{name}' is a leaf")
    public boolean isLeaf() {
        return core().hasClass(LEAF_CLASS);
    }

    @Override
    @JDIAction("Check if '{name}' is enabled")
    public boolean isEnabled() {
        return !core().hasClass(DISABLED_NODE_CLASS);
    }

    @JDIAction("Check if '{name}' is expanded")
    public boolean isExpanded() {
        return core().attr("aria-expanded").equalsIgnoreCase("true");
    }

    @JDIAction("Check if '{name}' is active")
    public boolean isActive() {
        return root().hasClass(ACTIVE_NODE_CLASS);
    }

    @Override
    @JDIAction("Check if '{name}' is selected")
    public boolean isSelected() {
        return core().hasClass(SELECTED_NODE_CLASS);
    }

    @JDIAction("Get root from '{name}'")
    public UIElement root() {
        if (isPseudoCore()) {
            throw new UnsupportedOperationException("Can't find root for pseudo core node '" + CORE_LOCATOR + "'");
        }
        return core().find(ROOT_IN_NODE_LOCATOR);
    }

    @JDIAction("Get root expander from '{name}'")
    public UIElement expander() {
        return root().find(TOGGLE_IN_ROOT_LOCATOR);
    }

    @JDIAction("Get root checkbox from '{name}'")
    public UIElement checkbox() {
        return root().find(CHECKBOX_IN_ROOT_LOCATOR);
    }

    @JDIAction("Get root content from '{name}'")
    public UIElement content() {
        return root().find(CONTENT_IN_ROOT_LOCATOR);
    }

    @JDIAction("Expand '{name}'")
    public void expand() {
        if (!isExpanded()) {
            expander().click();
        }
    }

    @JDIAction("Close '{name}'")
    public void close() {
        if (isExpanded()) {
            expander().click();
        }
    }

    @Override
    @JDIAction("Click on root in '{name}'")
    public void click() {
        root().click();
    }

    @JDIAction("Activate '{name}'")
    public void activate() {
        if (!isActive()) {
            click();
        }
    }

    @JDIAction("Deactivate '{name}'")
    public void deactivate() {
        if (isActive()) {
            click();
        }
    }

    @JDIAction("Select checkbox in '{name}'")
    public void select() {
        checkbox().click();
    }

    @Override
    @JDIAction("Check checkbox in '{name}'")
    public void check() {
        if (!isSelected()) {
            select();
        }
    }

    @Override
    @JDIAction("Uncheck checkbox in '{name}'")
    public void uncheck() {
        if (isSelected()) {
            select();
        }
    }

    @JDIAction("Get list of nodes from '{name}'")
    public List<TreeView> nodes() {
        if (isLeaf()) {
            return Collections.emptyList();
        }
        WebList nodes;
        if (isPseudoCore()) {
            nodes = core().finds(NODES_IN_CORE_LOCATOR);
        } else {
            expand();
            nodes = core().finds(NODES_IN_NODE_LOCATOR);
        }
        return nodes.map(elem -> new TreeView().setCore(TreeView.class, elem));
    }

    @JDIAction("Get node from '{name}' by index '{0}'")
    public TreeView getNode(int index) {
        return nodes().get(index - 1);
    }

    @JDIAction("Get node from '{name}' by string '{0}'")
    public TreeView getNode(String value) {
        return nodes().stream()
                .filter(node -> node.content().getText().equals(value))
                .findFirst()
                .orElse(null);
    }

    @Override
    @JDIAction("Get content list of nodes from '{name}'")
    public WebList list() {
        return WebList.newList(nodes().stream()
                .map(TreeView::content)
                .collect(Collectors.toList())
        );
    }

    @Override
    public void clear() {

    }

//    @Override
//    @JDIAction("Get content from '{name}' by index '{0}'")
//    public UIElement get(int index) {
//        return list().get(index);
//    }

    @Override
    public List<TreeView> elements(int minAmount) {
        return nodes();
    }

    @Override
    public TreeView get(String value) {
        return getNode(value);
    }
//
//    @Override
//    @JDIAction("Get content from '{name}' by string '{0}'")
//    public UIElement get(String value) {
//        return list().stream()
//                .filter(content -> content.getText().equals(value))
//                .findFirst()
//                .orElse(null);
//    }

    @Override
    @JDIAction("Select node from '{name}' by string '{0}'")
    public void select(String value) {
        getNode(value).select();
    }

    @Override
    @JDIAction("Select node from '{name}' by index '{0}'")
    public void select(int index) {
        getNode(index).select();
    }

    @Override
    @JDIAction("Select node from '{name}' by enum '{0}'")
    public <TEnum extends Enum<?>> void select(TEnum value) {
        select(getEnumValue(value));
    }

    @Override
    @JDIAction("Select node from '{name}' by array of strings '{0}'")
    public void select(String... values) {
        for (String value : values) {
            select(value);
        }
    }

    @Override
    @JDIAction("Select node from '{name}' by array of enums '{0}'")
    public <TEnum extends Enum<?>> void select(TEnum... values) {
        for (TEnum value : values) {
            select(value);
        }
    }

    @Override
    @JDIAction("Select node from '{name}' by array of ints '{0}'")
    public void select(int... values) {
        for (int value : values) {
            select(value);
        }
    }

    @Override
    @JDIAction("Get selected nodes from '{name}' in one string")
    public String selected() {
        return print(checked());
    }

    @Override
    @JDIAction("Check if node from '{name}' by string '{0}' is selected")
    public boolean selected(String option) {
        return getNode(option).isSelected();
    }

    @Override
    @JDIAction("Check if node from '{name}' by index '{0}' is selected")
    public boolean selected(int index) {
        return getNode(index).isSelected();
    }

    @Override
    @JDIAction("Get string list of selected nodes from '{name}'")
    public List<String> checked() {
        return nodes().stream()
                .filter(TreeView::isSelected)
                .map(treeView -> treeView.content().getText())
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get string list of selected nodes from '{name}'")
    public List<String> listEnabled() {
        return nodes().stream()
                .filter(TreeView::isEnabled)
                .map(treeView -> treeView.content().getText())
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get string list of selected nodes from '{name}'")
    public List<String> listDisabled() {
        return nodes().stream()
                .filter(TreeView::isDisabled)
                .map(treeView -> treeView.content().getText())
                .collect(Collectors.toList());
    }

    @Override
    public TreeViewDropDownAssert is() {
        return new TreeViewDropDownAssert();
    }

//    @Override
//    public void setup(Field field) {
//        if (fieldHasAnnotation(field, JDITreeView.class, TreeView.class)) {
//            JDITreeView annotation = field.getAnnotation(JDITreeView.class);
//            initializeLocators(annotation);
//        }
//        this.setCore(TreeView.class, $(CORE_LOCATOR));
//        this.setName(String.format("TreeView %s", field.getName()));
//    }
//
//    private void initializeLocators(JDITreeView annotation) {
//        if (!annotation.core().isEmpty()) {
//            CORE_LOCATOR = annotation.core();
//        }
//        super.setup(CORE_LOCATOR, null, null, null);
//        if (!annotation.coreNodes().isEmpty()) {
//            NODES_IN_CORE_LOCATOR = annotation.coreNodes();
//        }
//        if (!annotation.nodeNodes().isEmpty()) {
//            NODES_IN_NODE_LOCATOR = annotation.nodeNodes();
//        }
//        if (!annotation.root().isEmpty()) {
//            ROOT_IN_NODE_LOCATOR = annotation.root();
//        }
//        if (!annotation.toggle().isEmpty()) {
//            TOGGLE_IN_ROOT_LOCATOR = annotation.toggle();
//        }
//        if (!annotation.checkbox().isEmpty()) {
//            CHECKBOX_IN_ROOT_LOCATOR = annotation.checkbox();
//        }
//        if (!annotation.content().isEmpty()) {
//            CONTENT_IN_ROOT_LOCATOR = annotation.content();
//        }
//    }

    @Override
    public int getStartIndex() {
        return 1;
    }

    @Override
    public void setStartIndex(int i) {

    }
}

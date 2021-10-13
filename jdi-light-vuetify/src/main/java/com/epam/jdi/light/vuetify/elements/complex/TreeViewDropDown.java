package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.*;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.light.vuetify.annotations.JDITreeViewDropDown;
import com.epam.jdi.light.vuetify.asserts.TreeViewDropDownAssert;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class TreeViewDropDown extends Dropdown
        implements IMultiSelector, CanBeSelected, HasCheck {
//        implements HasCheck

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
        return core().hasClass(CORE_CLASS);
    }

    @JDIAction("Check if '{name}' is a leaf")
    public boolean isLeaf() {
        return core().hasClass(LEAF_CLASS);
    }

    @JDIAction("Check if '{name}' is active")
    public boolean isActive() {
        return root().hasClass(ACTIVE_NODE_CLASS);
    }

    @Override
    @JDIAction("Check if '{name}' is enabled")
    public boolean isEnabled() {
        return !core().hasClass(DISABLED_NODE_CLASS);
    }

    @Override
    @JDIAction("Check if '{name}' is selected")
    public boolean isSelected() {
        return core().hasClass(SELECTED_NODE_CLASS);
    }

    @Override
    @JDIAction("Check if '{name}' is expanded")
    public boolean isExpanded() {
        return core().attr("aria-expanded").equalsIgnoreCase("true");
    }

    @JDIAction("Get root from '{name}'")
    public UIElement root() {
        if (isPseudoCore()) {
            return null;
        }
        return core().find(ROOT_IN_NODE_LOCATOR).setName("root");
    }

    @JDIAction("Get root expander from '{name}'")
    public UIElement expander() {
        return root().find(TOGGLE_IN_ROOT_LOCATOR).setName("expander");
    }

    @JDIAction("Get root checkbox from '{name}'")
    public UIElement checkbox() {
        return root().find(CHECKBOX_IN_ROOT_LOCATOR).setName("checkbox");
    }

    @Override
    @JDIAction("Get root content from '{name}'")
    public UIElement value() {
        return root().find(CONTENT_IN_ROOT_LOCATOR).setName("value");
    }

    @Override
    public WebList list() {
        return core().finds(NODES_IN_CORE_LOCATOR);
    }

    @Override
    public List<String> checked() {
        return null;
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDITreeViewDropDown.class, TreeViewDropDown.class)) {
            JDITreeViewDropDown annotation = field.getAnnotation(JDITreeViewDropDown.class);
            initializeLocators(annotation);
        }
        setName(String.format("TreeView %s", field.getName()));
        autoClose = false;
        setupDone = true;
        thisParent = true;
    }

    private void initializeLocators(JDITreeViewDropDown annotation) {
        if (!annotation.core().isEmpty()) {
            setCore(TreeView.class, $(annotation.core()));
        }
        if (!annotation.coreNodes().isEmpty()) {
            NODES_IN_CORE_LOCATOR = annotation.coreNodes();
        }
        if (!annotation.nodeNodes().isEmpty()) {
            NODES_IN_NODE_LOCATOR = annotation.nodeNodes();
        }
        if (!annotation.root().isEmpty()) {
            ROOT_IN_NODE_LOCATOR = annotation.root();
        }
        if (!annotation.toggle().isEmpty()) {
            TOGGLE_IN_ROOT_LOCATOR = annotation.toggle();
        }
        if (!annotation.checkbox().isEmpty()) {
            CHECKBOX_IN_ROOT_LOCATOR = annotation.checkbox();
        }
        if (!annotation.content().isEmpty()) {
            CONTENT_IN_ROOT_LOCATOR = annotation.content();
        }
    }

    @Override
    public TreeViewDropDownAssert is() {
        TreeViewDropDownAssert treeViewDropDownAssert = new TreeViewDropDownAssert();
        treeViewDropDownAssert.set(this);
        return treeViewDropDownAssert;
    }

    @Override
    public TreeViewDropDownAssert assertThat() {
        return is();
    }

    @Override
    public TreeViewDropDownAssert has() {
        return is();
    }

    @Override
    public TreeViewDropDownAssert waitFor() {
        return is();
    }

    @Override
    public TreeViewDropDownAssert waitFor(int sec) {
        this.waitSec(sec);
        return is();
    }

    @Override
    public TreeViewDropDownAssert shouldBe() {
        return is();
    }

    @Override
    public TreeViewDropDownAssert verify() {
        assertSoft();
        return is();
    }

    @JDIAction("Get list of nodes from '{name}'")
    public List<TreeViewDropDown> nodes() {
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
        return nodes.map(elem -> new TreeViewDropDown().setCore(TreeViewDropDown.class, elem));
    }

    public TreeViewDropDown get(String value) {
        return nodes().stream()
                .filter(node -> node.value().getText().equals(value))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void click() {

    }
}

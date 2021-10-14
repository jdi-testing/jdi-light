package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.complex.IListSelector;
import com.epam.jdi.light.elements.complex.IMultiSelector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.vuetify.annotations.JDITreeViewDropDown;
import com.epam.jdi.light.vuetify.asserts.TreeViewDropDownAssert;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.tools.PrintUtils.print;

public class TreeViewDropDown extends Dropdown
        implements IMultiSelector, CanBeSelected, HasCheck, IListSelector<TreeViewDropDown> {

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

    @Override
    public void select(String value) {
        get(value).select();
    }

    @Override
    public void select(int index) {
        get(index).select();
    }

    @Override
    public String selected() {
        return print(checked());
    }

    @Override
    public boolean selected(String option) {
        return selected().equals(option);
    }

    @Override
    public void select(String... values) {
        Arrays.stream(values).forEach(this::select);
    }

    @Override
    public <TEnum extends Enum<?>> void select(TEnum... values) {
        Arrays.stream(values).forEach(this::select);
    }

    @Override
    public void select(int... values) {
        Arrays.stream(values).forEach(this::select);
    }

    @Override
    public boolean selected(int index) {
        return get(index).isSelected();
    }

    @Override
    public <TEnum extends Enum<?>> void select(TEnum value) {
        super.select(value);
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
        return nodes.map(this::create);
    }

    protected TreeViewDropDown create(JDIBase base) {
        TreeViewDropDown created = new TreeViewDropDown().setCore(TreeViewDropDown.class, base);
        created.NODES_IN_CORE_LOCATOR = NODES_IN_CORE_LOCATOR;
        created.NODES_IN_NODE_LOCATOR = NODES_IN_NODE_LOCATOR;
        created.ROOT_IN_NODE_LOCATOR = ROOT_IN_NODE_LOCATOR;
        created.TOGGLE_IN_ROOT_LOCATOR = TOGGLE_IN_ROOT_LOCATOR;
        created.CHECKBOX_IN_ROOT_LOCATOR = CHECKBOX_IN_ROOT_LOCATOR;
        created.CONTENT_IN_ROOT_LOCATOR = CONTENT_IN_ROOT_LOCATOR;
        created.CORE_CLASS = CORE_CLASS;
        created.LEAF_CLASS = LEAF_CLASS;
        created.SELECTED_NODE_CLASS = SELECTED_NODE_CLASS;
        created.ACTIVE_NODE_CLASS = ACTIVE_NODE_CLASS;
        created.DISABLED_NODE_CLASS = DISABLED_NODE_CLASS;
        return created;
    }

    @Override
    public WebList list() {
        return WebList.newList(nodes().stream()
                .map(TreeViewDropDown::value)
                .collect(Collectors.toList())
        );
    }

    @Override
    public List<TreeViewDropDown> elements(int minAmount) {
        if (minAmount > size())
            throw exception("Expected at least %s elements but failed (%s)", minAmount, toString());
        return nodes();
    }

    @Override
    public TreeViewDropDown get(String value) {
        return nodes().stream()
                .filter(node -> node.getText().equals(value))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<String> checked() {
        return nodes().stream()
                .filter(TreeViewDropDown::isSelected)
                .map(DropdownExpand::getText)
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
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
}

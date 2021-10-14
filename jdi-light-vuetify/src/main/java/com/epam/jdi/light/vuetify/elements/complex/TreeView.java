package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.complex.IListSelector;
import com.epam.jdi.light.elements.complex.IMultiSelector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.vuetify.annotations.JDITreeView;
import com.epam.jdi.light.vuetify.asserts.TreeViewAssert;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.tools.PrintUtils.print;

public class TreeView extends Dropdown
        implements IMultiSelector, CanBeSelected, HasCheck, IListSelector<TreeView> {

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
    @JDIAction("Get text from '{name}'")
    public String getText() {
        return value().getText();
    }

    @Override
    @JDIAction("Get size of '{name}'")
    public int size() {
        return list().size();
    }

    @Override
    public WebList list() {
        if (isPseudoCore()) {
            return core().finds(NODES_IN_CORE_LOCATOR);
        }
        if (!isLeaf()) {
            expand();
        }
        return core().finds(NODES_IN_NODE_LOCATOR);
    }

    @JDIAction("Get list of nodes from '{name}'")
    public List<TreeView> nodes() {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        return list().map(this::create);
    }

    @Override
    @JDIAction("Get list of string values of child nodes from '{name}'")
    public List<String> values() {
        return nodes().stream()
                .map(TreeView::getText)
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Click on root from '{name}'")
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
    @JDIAction("Select node from '{name}' by index '{0}'")
    public void select(int index) {
        get(index).select();
    }

    @Override
    @JDIAction("Select node from '{name}' by string '{0}'")
    public void select(String value) {
        get(value).select();
    }

    @Override
    @JDIAction("Select node from '{name}' by enum '{0}'")
    public <TEnum extends Enum<?>> void select(TEnum value) {
        super.select(value);
    }

    @Override
    @JDIAction("Select node from '{name}' by array of indexes '{0}'")
    public void select(int... values) {
        Arrays.stream(values).forEach(this::select);
    }

    @Override
    @JDIAction("Select node from '{name}' by array of strings '{0}'")
    public void select(String... values) {
        Arrays.stream(values).forEach(this::select);
    }

    @Override
    @JDIAction("Select node from '{name}' by array of enums '{0}'")
    public <TEnum extends Enum<?>> void select(TEnum... values) {
        Arrays.stream(values).forEach(this::select);
    }

    @Override
    @JDIAction("Check if node from '{name}' by index '{0}' is selected")
    public boolean selected(int index) {
        return get(index).isSelected();
    }

    @Override
    @JDIAction("Check if node from '{name}' by string '{0}' is selected")
    public boolean selected(String option) {
        return selected().equals(option);
    }

    @Override
    @JDIAction("Get selected nodes from '{name}' in one string")
    public String selected() {
        return print(checked());
    }

    @Override
    @JDIAction("Get string list of selected nodes from '{name}'")
    public List<String> checked() {
        return nodes().stream()
                .filter(TreeView::isSelected)
                .map(TreeView::getText)
                .collect(Collectors.toList());
    }

    @Override
    public List<TreeView> elements(int minAmount) {
        if (minAmount > size())
            throw exception("Expected at least %s elements but failed (%s)", minAmount, toString());
        return nodes();
    }

    @Override
    public TreeView get(String value) {
        return nodes().stream()
                .filter(node -> node.getText().equals(value))
                .findFirst()
                .orElse(null);
    }

    @Override
    @JDIAction("Get string list of selected nodes from '{name}'")
    public List<String> listEnabled() {
        return nodes().stream()
                .filter(TreeView::isEnabled)
                .map(TreeView::getText)
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get string list of selected nodes from '{name}'")
    public List<String> listDisabled() {
        return nodes().stream()
                .filter(TreeView::isDisabled)
                .map(TreeView::getText)
                .collect(Collectors.toList());
    }

    public void walk(Consumer<TreeView> consumer) {
        consumer.accept(this);
        nodes().forEach(treeView -> treeView.walk(consumer));
    }

    protected String delimiter = "/";

    @JDIAction("Get structure from '{name}'")
    public Map<String, List<String>> structure() {
        return getStructRecursive(this, delimiter);
    }

    protected Map<String, List<String>> getStructRecursive(TreeView treeView, String currentPath) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        List<String> values = treeView.values();
        if (!values.isEmpty()) {
            map.put(currentPath, values);
            for (TreeView children : treeView.nodes()) {
                String childPath = currentPath;
                if (!childPath.equals(delimiter)) {
                    childPath += delimiter;
                }
                childPath += children.getText();
                map.putAll(getStructRecursive(children, childPath));
            }
        }
        return map;
    }

    @Override
    public void refresh() {}

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    protected TreeView create(UIElement base) {
        TreeView created = new TreeView().setCore(TreeView.class, base);
        created.NODES_IN_CORE_LOCATOR = NODES_IN_CORE_LOCATOR;
        created.NODES_IN_NODE_LOCATOR = NODES_IN_NODE_LOCATOR;
        created.ROOT_IN_NODE_LOCATOR = ROOT_IN_NODE_LOCATOR;
        created.TOGGLE_IN_ROOT_LOCATOR = TOGGLE_IN_ROOT_LOCATOR;
        created.CHECKBOX_IN_ROOT_LOCATOR = CHECKBOX_IN_ROOT_LOCATOR;
        created.CONTENT_IN_ROOT_LOCATOR = CONTENT_IN_ROOT_LOCATOR;
        return created;
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDITreeView.class, TreeView.class)) {
            JDITreeView annotation = field.getAnnotation(JDITreeView.class);
            initializeLocators(annotation);
        }
        setName(String.format("TreeView %s", field.getName()));
        autoClose = false;
        setupDone = true;
        thisParent = true;
    }

    private void initializeLocators(JDITreeView annotation) {
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
    public TreeViewAssert is() {
        TreeViewAssert treeViewAssert = new TreeViewAssert();
        treeViewAssert.set(this);
        return treeViewAssert;
    }

    @Override
    public TreeViewAssert assertThat() {
        return is();
    }

    @Override
    public TreeViewAssert has() {
        return is();
    }

    @Override
    public TreeViewAssert waitFor() {
        return is();
    }

    @Override
    public TreeViewAssert waitFor(int sec) {
        this.waitSec(sec);
        return is();
    }

    @Override
    public TreeViewAssert shouldBe() {
        return is();
    }

    @Override
    public TreeViewAssert verify() {
        assertSoft();
        return is();
    }
}

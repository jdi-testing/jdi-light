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
import com.epam.jdi.tools.Timer;

import java.lang.reflect.Field;
import java.util.Arrays;
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

/**
 * To see an example of TreeView web element please visit
 * https://vuetifyjs.com/en/components/treeview/
 */
public class TreeView extends Dropdown
        implements IMultiSelector, CanBeSelected, HasCheck, IListSelector<TreeView> {

    private static final String CORE_CLASS = "v-treeview";
    private static final String HOVERABLE_CORE_CLASS = "v-treeview--hoverable";
    private static final String LEAF_NODE_CLASS = "v-treeview-node--leaf";
    private static final String SELECTED_NODE_CLASS = "v-treeview-node--selected";
    private static final String DISABLED_NODE_CLASS = "v-treeview-node--disabled";
    private static final String SHAPED_NODE_CLASS = "v-treeview-node--shaped";
    private static final String ROUNDED_NODE_CLASS = "v-treeview-node--rounded";
    private static final String ACTIVE_ROOT_CLASS = "v-treeview-node--active";

    private String checkboxFullyMarkedClass = "mdi-checkbox-marked";
    private String checkboxPartlyMarkedClass = "mdi-minus-box";
    private String checkboxNotMarkedClass = "mdi-checkbox-blank-outline";

    private String nodesInCoreLocator = "./*[contains(@class, 'v-treeview-node')]";
    private String nodesInNodeLocator = "./*[contains(@class, 'v-treeview-node__children')]/*[contains(@class, 'v-treeview-node')]";
    private String rootInNodeLocator = "./*[contains(@class, 'v-treeview-node__root')]";
    private String toggleInRootLocator = ".v-treeview-node__toggle";
    private String checkboxInRootLocator = ".v-treeview-node__checkbox";
    private String contentInRootLocator = ".v-treeview-node__content";
    private String coreFromNodeLocator = "//ancestor::*[" +
            "@class='v-treeview' or " +
            "starts-with(@class, 'v-treeview ') or " +
            "contains(@class, ' v-treeview ') or " +
            "substring(@class, string-length(@class) - string-length('v-treeview') + 1) = 'v-treeview']";

    private String delimiter = "/";

    @JDIAction("Check if '{name}' is a pseudo core node")
    public boolean isPseudoCore() {
        return core().hasClass(CORE_CLASS);
    }

    @JDIAction("Check if '{name}' is a leaf")
    public boolean isLeaf() {
        return core().hasClass(LEAF_NODE_CLASS);
    }

    @JDIAction("Check if '{name}' is active")
    public boolean isActive() {
        return root().hasClass(ACTIVE_ROOT_CLASS);
    }

    @JDIAction("Check if '{name}' is hoverable")
    public boolean isHoverable() {
        if (isPseudoCore()) {
            return core().hasClass(HOVERABLE_CORE_CLASS);
        }
        return pseudoCore().isHoverable();
    }

    @JDIAction("Check if '{name}' is shaped")
    public boolean isShaped() {
        return core().hasClass(SHAPED_NODE_CLASS);
    }

    @JDIAction("Check if '{name}' is rounded")
    public boolean isRounded() {
        return core().hasClass(ROUNDED_NODE_CLASS);
    }

    @JDIAction("Check if '{name}' is fully marked")
    public boolean isFullyMarked() {
        return checkbox().hasClass(checkboxFullyMarkedClass);
    }

    @JDIAction("Check if '{name}' is partly marked")
    public boolean isPartlyMarked() {
        return checkbox().hasClass(checkboxPartlyMarkedClass);
    }

    @JDIAction("Check if '{name}' is not marked")
    public boolean isNotMarked() {
        return checkbox().hasClass(checkboxNotMarkedClass);
    }

    @Override
    @JDIAction("Check if '{name}' is enabled")
    public boolean isEnabled() {
        return !core().hasClass(DISABLED_NODE_CLASS) && super.isEnabled();
    }

    @Override
    @JDIAction("Check if '{name}' is selected")
    public boolean isSelected() {
        return core().hasClass(SELECTED_NODE_CLASS);
    }

    @Override
    @JDIAction("Check if '{name}' is expanded")
    public boolean isExpanded() {
        if (isPseudoCore()) {
            return true;
        }
        return core().attr("aria-expanded").equalsIgnoreCase("true");
    }

    @JDIAction("Get main pseudo core TreeView from '{name}'")
    public TreeView pseudoCore() {
        return create(core().find(coreFromNodeLocator));
    }

    @JDIAction("Get root from '{name}'")
    public UIElement root() {
        if (isPseudoCore()) {
            return null;
        }
        return core().find(rootInNodeLocator).setName("root " + getName());
    }

    @JDIAction("Get root expander from '{name}'")
    public UIElement expander() {
        return root().find(toggleInRootLocator).setName("expander " + getName());
    }

    @JDIAction("Get root checkbox from '{name}'")
    public UIElement checkbox() {
        return root().find(checkboxInRootLocator).setName("checkbox " + getName());
    }

    @Override
    @JDIAction("Get root value from '{name}'")
    public UIElement value() {
        return iCore().setName("value " + getName());
    }

    @Override
    @JDIAction("Get root value from '{name}'")
    public UIElement iCore() {
        return core().find(rootInNodeLocator).find(contentInRootLocator);
    }

    @Override
    @JDIAction("Get text value from '{name}'")
    public String getValue() {
        if (isPseudoCore()) {
            return null;
        }
        return iCore().getText();
    }

    @Override
    @JDIAction("Get text value from '{name}'")
    public String getText() {
        return getValue();
    }

    @Override
    @JDIAction("Get size of '{name}'")
    public int size() {
        return list().size();
    }

    @Override
    @JDIAction("Get list from '{name}'")
    public WebList list() {
        if (isPseudoCore()) {
            return core().finds(nodesInCoreLocator);
        }
        if (isLeaf()) {
            return new WebList();
        }
        expand();
        return core().finds(nodesInNodeLocator);
    }

    @JDIAction("Get list of nodes from '{name}'")
    public List<TreeView> nodes() {
        return list().stream()
                .map(this::create)
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get list of string values of child nodes from '{name}'")
    public List<String> values() {
        return nodes().stream()
                .map(TreeView::getText)
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Expand '{name}'")
    public void expand() {
        if (!isExpanded()) {
            toggle();
            Timer.waitCondition(this::isExpanded);
        }
    }

    @Override
    @JDIAction("Close '{name}'")
    public void close() {
        if (isExpanded()) {
            toggle();
            Timer.waitCondition(() -> !isExpanded());
        }
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
    @JDIAction("Get node from '{name}' by string '{0}'")
    public TreeView get(String value) {
        return nodes().stream()
                .filter(node -> node.getText().equals(value))
                .findFirst()
                .orElse(null);
    }

    @Override
    @JDIAction("Get first node from '{name}'")
    public TreeView first() {
        return get(getStartIndex());
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

    public void walk(Consumer<? super TreeView> visitor) {
        visitor.accept(this);
        nodes().forEach(treeView -> treeView.walk(visitor));
    }

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
        created.nodesInCoreLocator = nodesInCoreLocator;
        created.nodesInNodeLocator = nodesInNodeLocator;
        created.rootInNodeLocator = rootInNodeLocator;
        created.toggleInRootLocator = toggleInRootLocator;
        created.checkboxInRootLocator = checkboxInRootLocator;
        created.contentInRootLocator = contentInRootLocator;
        created.checkboxFullyMarkedClass = checkboxFullyMarkedClass;
        created.checkboxPartlyMarkedClass = checkboxPartlyMarkedClass;
        created.checkboxNotMarkedClass = checkboxNotMarkedClass;
        created.setName(String.format("TreeView %s", created.getValue()));
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
            nodesInCoreLocator = annotation.coreNodes();
        }
        if (!annotation.nodeNodes().isEmpty()) {
            nodesInNodeLocator = annotation.nodeNodes();
        }
        if (!annotation.root().isEmpty()) {
            rootInNodeLocator = annotation.root();
        }
        if (!annotation.toggle().isEmpty()) {
            toggleInRootLocator = annotation.toggle();
        }
        if (!annotation.checkbox().isEmpty()) {
            checkboxInRootLocator = annotation.checkbox();
        }
        if (!annotation.content().isEmpty()) {
            contentInRootLocator = annotation.content();
        }
        if (!annotation.full().isEmpty()) {
            checkboxFullyMarkedClass = annotation.full();
        }
        if (!annotation.part().isEmpty()) {
            checkboxPartlyMarkedClass = annotation.part();
        }
        if (!annotation.not().isEmpty()) {
            checkboxNotMarkedClass = annotation.not();
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

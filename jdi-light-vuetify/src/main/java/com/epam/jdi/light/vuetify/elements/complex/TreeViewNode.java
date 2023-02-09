package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.complex.IListSelector;
import com.epam.jdi.light.elements.complex.IMultiSelector;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.vuetify.asserts.TreeViewNodeAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.jdiai.tools.Timer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.jdiai.tools.PrintUtils.print;

/**
 * To see an example of TreeView web element please visit
 * <a href="https://vuetifyjs.com/en/components/treeview/">Vuetify Tree View</a>
 */
public class TreeViewNode extends UIBaseElement<TreeViewNodeAssert> implements
        IMultiSelector,
        CanBeSelected,
        HasCheck,
        IListSelector<TreeViewNode>,
        ISelector,
        HasRounded,
        IsShaped,
        IsLoading {

    protected static final String LEAF_NODE_CLASS = "v-treeview-node--leaf";
    protected static final String SELECTED_NODE_CLASS = "v-treeview-node--selected";
    protected static final String DISABLED_NODE_CLASS = "v-treeview-node--disabled";
    protected static final String ACTIVE_ROOT_CLASS = "v-treeview-node--active";
    protected final String delimiter = "/";
    protected  String checkboxFullyMarkedClass = "mdi-checkbox-marked";
    protected String checkboxPartlyMarkedClass = "mdi-minus-box";
    protected  String checkboxNotMarkedClass = "mdi-checkbox-blank-outline";
    protected  String nodesInCoreLocator = "./*[contains(@class, 'v-treeview-node')]";
    protected  String nodesInNodeLocator =
            "./*[contains(@class, 'v-treeview-node__children')]/*[contains(@class, 'v-treeview-node')]";
    protected String rootInNodeLocator = "./*[contains(@class, 'v-treeview-node__root')]";
    protected String toggleLocator = ".v-treeview-node__toggle";
    protected String checkboxLocator = ".v-treeview-node__checkbox";
    protected String contentLocator = ".v-treeview-node__content";
    protected int startIndex = ELEMENT.startIndex;


    @JDIAction("Get if '{name}' is a leaf")
    public boolean isLeaf() {
        return core().hasClass(LEAF_NODE_CLASS);
    }

    @JDIAction("Get if '{name}' is active")
    public boolean isActive() {
        return root().hasClass(ACTIVE_ROOT_CLASS);
    }

    @JDIAction("Get if '{name}' is fully marked")
    public boolean isFullyMarked() {
        return checkbox().hasClass(TreeView.checkboxFullyMarkedClass);
    }

    @JDIAction("Get if '{name}' is partly marked")
    public boolean isPartlyMarked() {
        return checkbox().hasClass(TreeView.checkboxPartlyMarkedClass);
    }

    @JDIAction("Get if '{name}' is not marked")
    public boolean isNotMarked() {
        return checkbox().hasClass(TreeView.checkboxNotMarkedClass);
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return !core().hasClass(DISABLED_NODE_CLASS) && super.isEnabled();
    }

    @Override
    @JDIAction("Get if '{name}' is selected")
    public boolean isSelected() {
        return core().hasClass(SELECTED_NODE_CLASS);
    }

    @JDIAction("Get if '{name}' is expanded")
    public boolean isExpanded() {
        return core().attr("aria-expanded").equalsIgnoreCase("true");
    }

    @JDIAction("Get '{name}' root")
    public UIElement root() {

        return core().find(rootInNodeLocator).setName("root " + getName());
    }

    @JDIAction("Get '{name}' expanders")
    public List<VuetifyButton> expanders() {
        return core().finds(TreeView.toggleLocator)
                .stream()
                .map((e) -> new VuetifyButton().setCore(VuetifyButton.class, e))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' root checkbox")
    public UIElement checkbox() {
        return root().find(TreeView.checkboxLocator);
    }

    @JDIAction("Get root value from '{name}'")
    public UIElement value() {
        return iCore().setName("value " + getName());
    }

    @Override
    @JDIAction("Get '{name}' root value")
    public UIElement iCore() {
        return core().find(TreeView.contentLocator);
    }

    @Override
    @JDIAction("Get '{name}' text value")
    public String getValue() {

        return iCore().getText();
    }

    @Override
    @JDIAction("Get '{name}' text value")
    public String getText() {
        return getValue();
    }

    @Override
    @JDIAction("Get '{name}' size")
    public int size() {
        return list().size();
    }

    @JDIAction("Get '{name}' check list")
    public WebList checkList() {

        return new WebList();
    }

    @Override
    @JDIAction("Get '{name}' list")
    public WebList list() {
        if (isLeaf()) {
            return checkList();
        }
        expand();
        return core().finds(TreeView.nodesInNodeLocator);
    }

    @JDIAction("Get '{name}' list of nodes")
    public List<TreeViewNode> nodes() {
        return list().stream()
                .map(this::create)
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get '{name}' list of string values of child nodes")
    public List<String> values() {
        return nodes().stream()
                .map(TreeViewNode::getText)
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' icon")
    public Icon icon() {
        return new Icon().setCore(Icon.class, core().find(".v-icon"));
    }

    @JDIAction("Expand '{name}'")
    public void expand() {
        for (int i = 0; i <= expanders().size() - 1; i++) {
            if (!expanders().get(i).hasClass("v-treeview-node__toggle--open")) {
                expanders().get(i).click(ElementArea.CENTER);
            }
        }
    }

    @JDIAction("Close '{name}'")
    public void close() {
        if (isExpanded()) {
            expanders().get(0).click();
            Timer.waitCondition(() -> !isExpanded());
        }
    }

    @Override
    @JDIAction("Click on '{name}' root")
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

    @JDIAction("Select '{name}' checkbox")
    public void selectCheckbox() {
        checkbox().click(ElementArea.CENTER);
    }

    @JDIAction("Select '{name}' value")
    public void select() {
        value().click();
    }

    @Override
    @JDIAction("Check '{name}' checkbox")
    public void check() {
        if (!isSelected()) {
            selectCheckbox();
        }
    }

    @Override
    @JDIAction("Uncheck  '{name}' checkbox")
    public void uncheck() {
        if (isSelected()) {
            selectCheckbox();
        }
    }

    @Override
    @JDIAction("Select '{name}' node with index '{0}'")
    public void select(int index) {
        get(index).selectCheckbox();
    }

    @Override
    @JDIAction("Select '{name}' node with value '{0}'")
    public void select(String value) {
        get(value).selectCheckbox();
    }

    @Override
    @JDIAction("Select '{name}' node by enum '{0}'")
    public <TEnum extends Enum<?>> void select(TEnum value) {
        expand();
        list().select(value);
    }

    @Override
    @JDIAction("Select '{name}' node by array of indexes '{0}'")
    public void select(int... values) {
        Arrays.stream(values).forEach(this::select);
    }

    @Override
    @JDIAction("Select '{name}' node by array of strings '{0}'")
    public void select(String... values) {
        Arrays.stream(values).forEach(this::select);
    }

    @Override
    @JDIAction("Select '{name}' node by array of enums '{0}'")
    public <TEnum extends Enum<?>> void select(TEnum... values) {
        Arrays.stream(values).forEach(this::select);
    }

    @Override
    @JDIAction("Get if '{name}' node with index '{0}' is selected")
    public boolean selected(int index) {
        return get(index).isSelected();
    }

    @Override
    @JDIAction("Get if '{name}' node '{0}' is selected")
    public boolean selected(String option) {
        return selected().equals(option);
    }

    @Override
    @JDIAction("Get '{name}' selected nodes in one string")
    public String selected() {
        return print(checked());
    }

    @Override
    @JDIAction("Get '{name}' selected nodes")
    public List<String> checked() {
        return nodes().stream()
                .filter(TreeViewNode::isSelected)
                .map(TreeViewNode::getText)
                .collect(Collectors.toList());
    }

    @Override
    public List<TreeViewNode> elements(int minAmount) {
        if (minAmount > size()) {
            throw runtimeException("Expected at least %s elements but failed (%s)", minAmount, toString());
        }
        return nodes();
    }

    @Override
    @JDIAction("Get '{name}' node string value '{0}'")
    public TreeViewNode get(String value) {
        return nodes().stream()
                .filter(node -> node.getText().equals(value))
                .findFirst()
                .orElse(null);
    }

    @Override
    @JDIAction("Get '{name}' first node")
    public TreeViewNode first() {
        return get(getStartIndex());
    }


    public void walk(Consumer<? super TreeViewNode> visitor) {
        visitor.accept(this);
        nodes().forEach(treeViewNode -> treeViewNode.walk(visitor));
    }

    @JDIAction("Get '{name}' structure")
    public Map<String, List<String>> structure() {
        return getStructRecursive(this, delimiter + this.getText());
    }

    protected Map<String, List<String>> getStructRecursive(TreeViewNode treeViewNode, String currentPath) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        List<String> values = treeViewNode.values();
        if (!values.isEmpty()) {
            map.put(currentPath, values);
            for (TreeViewNode children : treeViewNode.nodes()) {
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

    @JDIAction("Get '{name}' color")
    public String color() {
        return value().css("color");
    }

    @JDIAction("Get '{name}' checkbox color")
    public String checkboxColor() {
        return checkbox().css("color");
    }

    @JDIAction("Get if '{name}' is loading")
    public boolean isLoading() {
        return expanders().get(0).attr("class").contains("-loading");
    }

    @Override
    public void refresh() {
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    protected TreeViewNode create(UIElement base) {
        TreeViewNode created = new TreeViewNode().setCore(TreeViewNode.class, base);
        created.nodesInCoreLocator = TreeView.nodesInCoreLocator;
        created.nodesInNodeLocator = TreeView.nodesInNodeLocator;
        created.rootInNodeLocator = TreeView.rootInNodeLocator;
        created.toggleLocator = TreeView.toggleLocator;
        created.checkboxLocator = TreeView.checkboxLocator;
        created.contentLocator = TreeView.contentLocator;
        created.checkboxFullyMarkedClass = TreeView.checkboxFullyMarkedClass;
        created.checkboxPartlyMarkedClass = TreeView.checkboxPartlyMarkedClass;
        created.checkboxNotMarkedClass = TreeView.checkboxNotMarkedClass;
        created.setName(String.format("TreeView %s", created.getValue()));
        return created;
    }


    @Override
    public TreeViewNodeAssert is() {
        return new TreeViewNodeAssert().set(this);
    }


    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public void setStartIndex(int i) {
        startIndex = i;
    }
}

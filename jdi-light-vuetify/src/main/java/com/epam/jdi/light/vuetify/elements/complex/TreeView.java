package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.complex.IListSelector;
import com.epam.jdi.light.elements.complex.IMultiSelector;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.vuetify.annotations.JDITreeView;
import com.epam.jdi.light.vuetify.asserts.TreeViewAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.jdiai.tools.Timer;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.jdiai.tools.PrintUtils.print;

/**
 * To see an example of TreeView web element please visit
 * https://vuetifyjs.com/en/components/treeview/
 */
public class TreeView extends UIBaseElement<TreeViewAssert> implements IMultiSelector, CanBeSelected, HasCheck,
        IListSelector<TreeView>, ISetup, ISelector, HasRounded, IsShaped, IsDense, IsLoading {
    protected static final String CORE_CLASS = "v-treeview";
    protected static final String HOVERABLE_CORE_CLASS = "v-treeview--hoverable";
    protected static final String LEAF_NODE_CLASS = "v-treeview-node--leaf";
    protected static final String SELECTED_NODE_CLASS = "v-treeview-node--selected";
    protected static final String DISABLED_NODE_CLASS = "v-treeview-node--disabled";
    protected static final String ACTIVE_ROOT_CLASS = "v-treeview-node--active";

    protected String checkboxFullyMarkedClass = "mdi-checkbox-marked";
    protected String checkboxPartlyMarkedClass = "mdi-minus-box";
    protected String checkboxNotMarkedClass = "mdi-checkbox-blank-outline";
    protected String nodesInCoreLocator = "./*[contains(@class, 'v-treeview-node')]";
    protected String nodesInNodeLocator =
            "./*[contains(@class, 'v-treeview-node__children')]/*[contains(@class, 'v-treeview-node')]";
    protected String rootInNodeLocator = "./*[contains(@class, 'v-treeview-node__root')]";
    protected String toggleLocator = ".v-treeview-node__toggle";
    protected String checkboxLocator = ".v-treeview-node__checkbox";
    protected String contentLocator = ".v-treeview-node__content";
    protected String coreFromNodeLocator = "//ancestor::*[" +
            "@class='v-treeview' or " +
            "starts-with(@class, 'v-treeview ') or " +
            "contains(@class, ' v-treeview ') or " +
            "substring(@class, string-length(@class) - string-length('v-treeview') + 1) = 'v-treeview']";
    protected final String delimiter = "/";
    protected int startIndex = ELEMENT.startIndex;
    protected boolean autoClose;
    protected boolean setupDone;

    @JDIAction("Get if '{name}' is a pseudo core node")
    public boolean isPseudoCore() {
        return core().hasClass(CORE_CLASS);
    }

    @JDIAction("Get if '{name}' is a leaf")
    public boolean isLeaf() {
        return core().hasClass(LEAF_NODE_CLASS);
    }

    @JDIAction("Get if '{name}' is active")
    public boolean isActive() {
        return root().hasClass(ACTIVE_ROOT_CLASS);
    }

    @JDIAction("Get if '{name}' is hoverable")
    public boolean isHoverable() {
        if (isPseudoCore()) {
            return core().hasClass(HOVERABLE_CORE_CLASS);
        }
        return pseudoCore().isHoverable();
    }

    @JDIAction("Get if '{name}' is fully marked")
    public boolean isFullyMarked() {
        return checkbox().hasClass(checkboxFullyMarkedClass);
    }

    @JDIAction("Get if '{name}' is partly marked")
    public boolean isPartlyMarked() {
        return checkbox().hasClass(checkboxPartlyMarkedClass);
    }

    @JDIAction("Get if '{name}' is not marked")
    public boolean isNotMarked() {
        return checkbox().hasClass(checkboxNotMarkedClass);
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
        if (isPseudoCore()) {
            return true;
        }
        return core().attr("aria-expanded").equalsIgnoreCase("true");
    }

    @JDIAction("Get '{name}' main pseudo core TreeView")
    public TreeView pseudoCore() {
        return create(core().find(coreFromNodeLocator));
    }

    @JDIAction("Get '{name}' root")
    public UIElement root() {
        if (isPseudoCore()) {
            return null;
        }
        return core().find(rootInNodeLocator).setName("root " + getName());
    }

    @JDIAction("Get '{name}' expanders")
    public List<VuetifyButton> expanders() {
        return core().finds(toggleLocator)
                .stream()
                .map((e) -> new VuetifyButton().setCore(VuetifyButton.class, e))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' root checkbox")
    public UIElement checkbox() {
        return root().find(checkboxLocator);
    }

    @JDIAction("Get root value from '{name}'")
    public UIElement value() {
        return iCore().setName("value " + getName());
    }

    @Override
    @JDIAction("Get '{name}' root value")
    public UIElement iCore() {
        return core().find(contentLocator);
    }

    @Override
    @JDIAction("Get '{name}' text value")
    public String getValue() {
        if (isPseudoCore()) {
            return null;
        }
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
        if (isPseudoCore()) {
            return core().finds(nodesInCoreLocator);
        } else {
            return new WebList();
        }
    }

    @Override
    @JDIAction("Get '{name}' list")
    public WebList list() {
        if (isPseudoCore() | isLeaf()) {
            return checkList();
        }
        expand();
        return core().finds(nodesInNodeLocator);
    }

    @JDIAction("Get '{name}' list of nodes")
    public List<TreeView> nodes() {
        return list().stream()
                .map(this::create)
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get '{name}' list of string values of child nodes")
    public List<String> values() {
        return nodes().stream()
                .map(TreeView::getText)
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' icon")
    public Icon icon() {
        return new Icon().setCore(Icon.class, core().find(".v-icon"));
    }

    @JDIAction("Expand '{name}' item")
    public void expand(int index) {
        if (!isExpanded()) {
            expanders().get(index);
            Timer.waitCondition(this::isExpanded);
        }
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
                .filter(TreeView::isSelected)
                .map(TreeView::getText)
                .collect(Collectors.toList());
    }

    @Override
    public List<TreeView> elements(int minAmount) {
        if (minAmount > size()) {
            throw runtimeException("Expected at least %s elements but failed (%s)", minAmount, toString());
        }
        return nodes();
    }

    @Override
    @JDIAction("Get '{name}' node string value '{0}'")
    public TreeView get(String value) {
        return nodes().stream()
                .filter(node -> node.getText().equals(value))
                .findFirst()
                .orElse(null);
    }

    @Override
    @JDIAction("Get '{name}' first node")
    public TreeView first() {
        return get(getStartIndex());
    }

    @Override
    @JDIAction("Get '{name}' list of enabled selected node values")
    public List<String> listEnabled() {
        return nodes().stream()
                .filter(TreeView::isEnabled)
                .map(TreeView::getText)
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get '{name}' list of disabled selected node values")
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

    @JDIAction("Get '{name}' structure")
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

    protected TreeView create(UIElement base) {
        TreeView created = new TreeView().setCore(TreeView.class, base);
        created.nodesInCoreLocator = nodesInCoreLocator;
        created.nodesInNodeLocator = nodesInNodeLocator;
        created.rootInNodeLocator = rootInNodeLocator;
        created.toggleLocator = toggleLocator;
        created.checkboxLocator = checkboxLocator;
        created.contentLocator = contentLocator;
        created.checkboxFullyMarkedClass = checkboxFullyMarkedClass;
        created.checkboxPartlyMarkedClass = checkboxPartlyMarkedClass;
        created.checkboxNotMarkedClass = checkboxNotMarkedClass;
        created.setName(String.format("TreeView %s", created.getValue()));
        return created;
    }

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
            toggleLocator = annotation.toggle();
        }
        if (!annotation.checkbox().isEmpty()) {
            checkboxLocator = annotation.checkbox();
        }
        if (!annotation.content().isEmpty()) {
            contentLocator = annotation.content();
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
        return new TreeViewAssert().set(this);
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

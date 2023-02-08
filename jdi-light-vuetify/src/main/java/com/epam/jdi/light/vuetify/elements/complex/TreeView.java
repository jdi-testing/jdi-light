package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDITreeView;
import com.epam.jdi.light.vuetify.asserts.TreeViewAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;

/**
 * To see an example of TreeView web element please visit
 * https://vuetifyjs.com/en/components/treeview/
 */
public class TreeView extends UIBaseElement<TreeViewAssert> implements
        ISetup,
        IsLoading,
        ISelector,
        IsDense {

    protected static final String HOVERABLE_CORE_CLASS = "v-treeview--hoverable";
    protected String nodesInCoreLocator = "./*[contains(@class, 'v-treeview-node')]";
    protected String checkboxFullyMarkedClass = "mdi-checkbox-marked";
    protected String checkboxPartlyMarkedClass = "mdi-minus-box";
    protected String checkboxNotMarkedClass = "mdi-checkbox-blank-outline";

    protected String nodesInNodeLocator =
            "./*[contains(@class, 'v-treeview-node__children')]/*[contains(@class, 'v-treeview-node')]";
    protected String rootInNodeLocator = "./*[contains(@class, 'v-treeview-node__root')]";
    protected String toggleLocator = ".v-treeview-node__toggle";
    protected String checkboxLocator = ".v-treeview-node__checkbox";
    protected String contentLocator = ".v-treeview-node__content";
    protected int startIndex = ELEMENT.startIndex;
    protected boolean autoClose;
    protected boolean setupDone;


    @JDIAction("Get '{name}' check list")
    public WebList treeViewNodesWebList() {
            return core().finds(nodesInCoreLocator);

    }


    @JDIAction("Get '{name}' node string value '{0}'")
    public TreeViewNode node(String value) {
        return treeViewNodes().stream()
                .filter(node -> node.getText().equals(value))
                .findFirst()
                .orElse(null);
    }

    @JDIAction("Get '{name}' item with index '{0}'")
    public TreeViewNode node(int index) {
        return treeViewNodes().get(index);
    }

    @JDIAction("Get '{name}' list of nodes")
    public List<TreeViewNode> treeViewNodes() {
        return treeViewNodesWebList().stream()
                .map(webElement -> new TreeViewNode().setCore(TreeViewNode.class, webElement))
                .collect(Collectors.toList());
    }

    @JDIAction("Get if '{name}' is hoverable")
    public boolean isHoverable() {
        return core().hasClass(HOVERABLE_CORE_CLASS);
    }

    @JDIAction("Get '{name}' structure")
    public Map<String, List<String>> structure() {
        Map<String, List<String>> map = new LinkedHashMap<>();

        map.put("/", treeViewNodes().stream()
                .map(TreeViewNode::getText)
                .collect(Collectors.toList()));

        for(TreeViewNode node: treeViewNodes()){
            map.putAll(node.structure());
        }
        return map;
    }

    @JDIAction("Get '{name}' size")
    public int size() {
        int size = 0;
        for(TreeViewNode node: treeViewNodes()){
            size += node.size();
        }
        return size;
    }

    @JDIAction("Get '{name}' icon")
    public Icon icon() {
        return new Icon().setCore(Icon.class, core().find(".v-icon"));
    }

    @JDIAction("Expand '{name}'")
    public void expand() {
        treeViewNodes().forEach(TreeViewNode::expand);
    }

    @JDIAction("Close '{name}'")
    public void close() {
        treeViewNodes().forEach(TreeViewNode::close);
    }

    @JDIAction("Get if '{name}' is loading")
    public boolean isLoading() {
        for(TreeViewNode node:treeViewNodes()){
            if (node.isLoading()){
                return true;
            }
        }
        return false;
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

    @JDIAction("Get '{name}' text value")
    public String getValue() {

        return iCore().getText();
    }


    @Override
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    public void setStartIndex(int i) {
        startIndex = i;
    }

    @Override
    public WebList list() {
        return null;
    }
}

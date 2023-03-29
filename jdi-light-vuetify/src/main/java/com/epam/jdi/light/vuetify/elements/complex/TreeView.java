package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISelector;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDITreeView;
import com.epam.jdi.light.vuetify.asserts.TreeViewAssert;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;

/**
 * To see an example of TreeView web element please visit
 * <a href="https://vuetifyjs.com/en/components/treeview/">Vuetify Tree View</a>
 */
public class TreeView extends UIBaseElement<TreeViewAssert> implements
        ISetup, IsLoading, ISelector, IsDense {

    protected static final String HOVERABLE_CORE_CLASS = "v-treeview--hoverable";
    protected static String nodesInCoreLocator = "./*[contains(@class, 'v-treeview-node')]";
    protected static String nodesAllLocator = ".v-treeview-node";
    protected static String checkboxFullyMarkedClass = "mdi-checkbox-marked";
    protected static String checkboxPartlyMarkedClass = "mdi-minus-box";
    protected static String checkboxNotMarkedClass = "mdi-checkbox-blank-outline";

    protected static String nodesInNodeLocator =
            "./*[contains(@class, 'v-treeview-node__children')]/*[contains(@class, 'v-treeview-node')]";
    protected static String rootInNodeLocator = "./*[contains(@class, 'v-treeview-node__root')]";
    protected int startIndex = ELEMENT.startIndex;
    protected boolean autoClose;
    protected boolean setupDone;

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

    @JDIAction("Get '{name}' check list")
    public WebList childNodes() {
            return core().finds(nodesInCoreLocator);
    }

    @JDIAction("Get '{name}' check list")
    public WebList allNodes() {
            return core().finds(nodesAllLocator);
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
        return childNodes().stream()
                .map(webElement -> new TreeViewNode().setCore(TreeViewNode.class, webElement))
                .collect(Collectors.toList());
    }

    @JDIAction("Get if '{name}' is hoverable")
    public boolean isHoverable() {
        return core().hasClass(HOVERABLE_CORE_CLASS);
    }

    @JDIAction("Get '{name}' size")
    public int size() {
        return childNodes().size();
    }

    @JDIAction("Get '{name}' size")
    public int fullSize() {
        return allNodes().size();
    }

    @JDIAction("Expand all nodes in '{name}'")
    public void expandAllNodes() {
        treeViewNodes().forEach(TreeViewNode::expand);
    }

    @JDIAction("Close all nodes in '{name}'")
    public void closeAllNodes() {
        treeViewNodes().forEach(TreeViewNode::close);
    }

    @JDIAction("Get if '{name}' has at least one loading node")
    public boolean isLoading() {
        for (TreeViewNode node:treeViewNodes()) {
            if (node.isLoading()) {
                return true;
            }
        }
        return false;
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
        return childNodes();
    }
}

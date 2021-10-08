package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.annotations.JDITreeView;
import com.sun.istack.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import static com.epam.jdi.light.common.UIUtils.initT;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.tools.ReflectionUtils.getGenericTypes;

public class TreeView<T extends ICoreElement> extends UIBaseElement<UIAssert<?, ?>> implements ISetup {

    protected String CORE_LOCATOR = ".v-treeview OR .v-treeview-node";

    protected String ROOT_LOCATOR = "./*[contains(@class, 'v-treeview-node__root')]";

    protected String ROOT_NODES_LOCATOR = "./*[contains(@class, 'v-treeview-node')]";
    protected String NODE_NODES_LOCATOR = "./*[contains(@class, 'v-treeview-node__children')]/*[contains(@class, 'v-treeview-node')]";

    protected String TOGGLE_LOCATOR = ".v-treeview-node__toggle";

    protected String ROOT_NODE_CLASS = "v-treeview";
    protected String LEAF_NODE_CLASS = "v-treeview-node--leaf";
    protected String TOGGLE_OPEN_CLASS = "v-treeview-node__toggle--open";

    protected @NotNull Class<T> clazz;

    public TreeView() {}

    protected TreeView(Class<T> clazz, JDIBase core) {
        if (clazz == null) {
            throw new RuntimeException();
        }
        this.setCore(clazz, core);
        this.clazz = clazz;
    }

    public boolean isPseudoRoot() {
        return core().hasClass(ROOT_NODE_CLASS);
    }

    public boolean isLeaf() {
        return core().hasClass(LEAF_NODE_CLASS);
    }

    public UIElement rootElement() {
        if (isPseudoRoot()) {
            throw new UnsupportedOperationException();
        }
        return core().find(ROOT_LOCATOR);
    }

    public T root() {
        return initT(rootElement(), this, clazz);
    }

    @Override
    public WebList children() {
        if (isLeaf()) {
            return WebList.newList(Collections.emptyList());
        }
        if (isPseudoRoot()) {
            return core().finds(ROOT_NODES_LOCATOR);
        }
        expand();
        return core().finds(NODE_NODES_LOCATOR);
    }

    public List<TreeView<T>> nodes() {
        return children().map(elem -> new TreeView<>(clazz, elem));
    }

    public UIElement expander() {
        return rootElement().find(TOGGLE_LOCATOR);
    }

    public boolean isExpanded() {
        return expander().hasClass(TOGGLE_OPEN_CLASS);
    }

    public void expand() {
        if (!isExpanded()) {
            expander().click();
        }
    }

    public void close() {
        if (isExpanded()) {
            expander().click();
        }
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDITreeView.class, TreeView.class)) {
            JDITreeView annotation = field.getAnnotation(JDITreeView.class);
            initializeLocators(annotation);
        }
        this.setCore(TreeView.class, $(CORE_LOCATOR));
        this.setName(String.format("TreeView %s", field.getName()));
        Type type = getGenericTypes(field)[0];
        this.clazz = type.toString().equals("?") ? null : (Class<T>) type;
        if (clazz == null) {
            throw new RuntimeException();
        }
    }

    private void initializeLocators(JDITreeView annotation) {
        if (annotation.core().isEmpty()) {
            throw new RuntimeException();
        }
        CORE_LOCATOR = annotation.core();
        if (!annotation.root().isEmpty()) {
            ROOT_LOCATOR = annotation.root();
        }
        if (!annotation.nodes().isEmpty()) {
            NODE_NODES_LOCATOR = annotation.nodes();
        }
    }

}

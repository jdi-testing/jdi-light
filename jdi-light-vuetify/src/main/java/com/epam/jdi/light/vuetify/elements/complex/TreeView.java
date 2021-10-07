package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.annotations.JDITreeView;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import static com.epam.jdi.light.common.UIUtils.initT;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.tools.ReflectionUtils.getGenericTypes;

public class TreeView<T extends ICoreElement> extends UIBaseElement<UIAssert<?,?>> implements ISetup {

    protected String CORE_LOCATOR = ".v-treeview";
    protected String NODE_LOCATOR = ".v-treeview-node";
    protected String ROOT_LOCATOR = ":self > .v-treeview-node__root";
    protected String CHILDREN_LOCATOR = ":self > v-treeview-node__children > .v-treeview-node";
    protected String LEAF_LOCATOR = ".v-treeview-node--leaf";
    protected Class<T> clazz;

    public UIElement self() {
        return core().find(ROOT_LOCATOR);
    }

    public T getSelf() {
        return initT(self(), this, clazz);
    }

    // "./*[contains(@class, 'v-treeview-node__children')]/*[contains(@class,'v-treeview-node')]"
    public WebList getChildren() {
        return core().finds(CHILDREN_LOCATOR);
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDITreeView.class, TreeView.class)) {
            JDITreeView annotation = field.getAnnotation(JDITreeView.class);
            initializeLocators(annotation);
        }
        this.setCore(Pagination.class, $(CORE_LOCATOR));
        this.setName(String.format("TreeView %s", field.getName()));
        Type type = getGenericTypes(field)[0];
        this.clazz = type.toString().equals("?") ? null : (Class<T>) type;
        if (clazz == null) {
            throw new RuntimeException();
        }
    }

    private void initializeLocators(JDITreeView annotation) {
        if (!annotation.core().isEmpty()) {
            CORE_LOCATOR = annotation.core();
        }
        if (!annotation.node().isEmpty()) {
            NODE_LOCATOR = annotation.node();
        }
        if (!annotation.root().isEmpty()) {
            ROOT_LOCATOR = annotation.root();
        }
        if (!annotation.children().isEmpty()) {
            CHILDREN_LOCATOR = annotation.children();
        }
        if (!annotation.leaf().isEmpty()) {
            LEAF_LOCATOR = annotation.leaf();
        }
    }
}

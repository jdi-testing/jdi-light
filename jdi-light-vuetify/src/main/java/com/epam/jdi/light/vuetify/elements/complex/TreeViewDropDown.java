package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.complex.IListSelector;
import com.epam.jdi.light.elements.complex.IMultiSelector;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.vuetify.annotations.JDITreeViewDropDown;
import com.epam.jdi.light.vuetify.asserts.TreeViewDropDownAssert;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class TreeViewDropDown extends Dropdown
//        implements HasCheck, IMultiSelector, CanBeSelected, IListSelector<TreeViewDropDown>
{

    @Override
    public TreeViewDropDownAssert is() {
        TreeViewDropDownAssert treeViewDropDownAssert = new TreeViewDropDownAssert();
        treeViewDropDownAssert.set(this);
        return treeViewDropDownAssert;
    }

//    public String coreLocator;
//    public String checkboxLocator;
//    public String contentLocator;
//
//    TreeViewDropDown() {
//        this.valueLocator = ".v-treeview-node__content";
//        this.expandLocator = ".v-treeview-node__toggle";
//        this.listLocator = "";
//        this.startIndex;
//        this.thisParent;
//        this.autoClose;
//        this.setupDone;
//    }
//
////    protected String CORE_LOCATOR = ".v-treeview | .v-treeview-node";
//
////    protected String NODES_IN_CORE_LOCATOR = "./*[contains(@class, 'v-treeview-node')]";
////    protected String NODES_IN_NODE_LOCATOR = "./*[contains(@class, 'v-treeview-node__children')]/*[contains(@class, 'v-treeview-node')]";
//
////    protected String ROOT_IN_NODE_LOCATOR = "./*[contains(@class, 'v-treeview-node__root')]";
////
////    protected String CHECKBOX_IN_ROOT_LOCATOR = ".v-treeview-node__checkbox";
////    protected String CONTENT_IN_ROOT_LOCATOR = ".v-treeview-node__content";
//
//    protected String CORE_CLASS = "v-treeview";
//    protected String LEAF_CLASS = "v-treeview-node--leaf";
//    protected String SELECTED_NODE_CLASS = "v-treeview-node--selected";
//    protected String ACTIVE_NODE_CLASS = "v-treeview-node--active";
//    protected String DISABLED_NODE_CLASS = "v-treeview-node--disabled";
//


    //
//    @Override
//    public void setup(Field field) {
//        if (fieldHasAnnotation(field, JDITreeViewDropDown.class, TreeViewDropDown.class)) {
//            JDITreeViewDropDown annotation = field.getAnnotation(JDITreeViewDropDown.class);
//            initializeLocators(annotation);
//        }
//        this.setCore(TreeView.class, $(CORE_LOCATOR));
//        this.setName(String.format("TreeView %s", field.getName()));
//    }
//
//    private void initializeLocators(JDITreeViewDropDown annotation) {
//        if (!annotation.core().isEmpty()) {
//            CORE_LOCATOR = annotation.core();
//        }
//        if (!annotation.coreNodes().isEmpty()) {
//            NODES_IN_CORE_LOCATOR = annotation.coreNodes();
//        }
//        if (!annotation.nodeNodes().isEmpty()) {
//            NODES_IN_NODE_LOCATOR = annotation.nodeNodes();
//        }
//        if (!annotation.root().isEmpty()) {
//            ROOT_IN_NODE_LOCATOR = annotation.root();
//        }
//        if (!annotation.toggle().isEmpty()) {
//            TOGGLE_IN_ROOT_LOCATOR = annotation.toggle();
//        }
//        if (!annotation.checkbox().isEmpty()) {
//            CHECKBOX_IN_ROOT_LOCATOR = annotation.checkbox();
//        }
//        if (!annotation.content().isEmpty()) {
//            CONTENT_IN_ROOT_LOCATOR = annotation.content();
//        }
//    }
//
//    @Override
//    public List<TreeViewDropDown> elements(int minAmount) {
//        return null;
//    }
//
//    @Override
//    public TreeViewDropDown get(String value) {
//        return null;
//    }
//
//    @Override
//    public void clear() {
//
//    }
//
//    @Override
//    public List<String> checked() {
//        return null;
//    }
}

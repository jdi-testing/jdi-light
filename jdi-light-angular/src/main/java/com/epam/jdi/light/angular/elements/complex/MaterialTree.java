package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.TreeAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;

import java.util.List;

public class MaterialTree extends UIBaseElement<TreeAssert> {

    public String cssTreeNodeLocator = "mat-tree-node";
    public String cssButtonLocator = "button > span > mat-icon";
    public String cssCheckBox = "mat-checkbox";
    public String cssChevronLocator = cssTreeNodeLocator + " > "+ cssButtonLocator;

    public final String attributeExpanded = "aria-expanded";
    public final String attributeRole = "role";
    public final String item = "treeitem";
    public final String itemgroup = "group";
    public final String attributeLevel = "aria-level";

    @JDIAction("Expand '{name}' node by name '{node}'")
    public void expand(final String nodeName) {
        UIElement expansionIndicator = getNodeByName(nodeName);
        if (expansionIndicator!=null) {
            expansionIndicator.finds(By.cssSelector(cssButtonLocator)).get(1).click();
        }
    }

    @JDIAction("Collapse '{name}' panel by name '{node}'")
    public void collapse(final String nodeName) {
        UIElement expansionIndicator = getNodeByName(nodeName);
        if (!expansionIndicator.isEmpty() && isExpanded(nodeName)) {
            expansionIndicator.click();
        }
    }

    @JDIAction("Is '{name}' '{node}' panel expanded")
    public boolean isExpanded(final String nodeName) {
        return !isCollapsed(nodeName);
    }

    @JDIAction("Is '{name}' '{node}' panel collapsed")
    public boolean isCollapsed(final String nodeName) {
        UIElement expansionNode = getNodeByName(nodeName);
        expansionNode.waitFor();
        boolean isNodeExpanded = expansionNode.getAttribute(attributeExpanded).contains("false");
        boolean isGroup = expansionNode.getAttribute(attributeRole).contains(itemgroup);
        return isNodeExpanded && isGroup;
    }

    @JDIAction("Is '{name}' '{0}' panel collapsed")
    public boolean isCollapsed(final int indexNumber) {
        UIElement expansionNode = getNodeLocator().get(indexNumber);
        expansionNode.waitFor();
        boolean isNodeExpanded = expansionNode.getAttribute(attributeExpanded).contains("false");
        boolean isGroup = expansionNode.getAttribute(attributeRole).contains(itemgroup);
        return isNodeExpanded && isGroup;
    }

    @Override
    public TreeAssert is() {
        return new TreeAssert().set(this);
    }

    protected UIElement getNodeByName(String name) {
        List<UIElement> nodes = getNodeLocator();
        for(UIElement node: nodes) {
            if(node.getText().split("\n")[1].equalsIgnoreCase(name)) return node;
        }
        return null;
    }

    protected List<UIElement> getNodeLocator() {
        return this.uiElement.finds(By.cssSelector(cssTreeNodeLocator));
    }

    protected List<UIElement> getExpansionButton() {
        return this.uiElement.finds(By.cssSelector(cssChevronLocator));
    }

    @JDIAction("Get '{name}' '{0}' value")
    public String value(final String field) {
        return "";
    }
//
//    @JDIAction("Get '{name}' '{0}' field")
//    public TreeAssert attribute(final String attrib, final String field) {
//        return new TreeAssert().set(this);
//    }

}

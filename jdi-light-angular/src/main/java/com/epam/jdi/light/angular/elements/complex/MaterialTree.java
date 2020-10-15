package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.TreeAssert;
import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.common.ProgressBar;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class MaterialTree extends UIBaseElement<TreeAssert> {

    public String cssTreeNodeLocator = "mat-tree-node";
    public String cssProgressBarLocator = "mat-progress-bar";
    public String cssButtonLocator = "button > span > mat-icon";
    public String cssCheckBox = "mat-checkbox";
    public String cssChevronLocator = cssTreeNodeLocator + " > "+ cssButtonLocator;

    public final String ATTRIBUTEEXPANDED = "aria-expanded";
    public final String ATTRIBUTEROLE = "role";
    public final String TREEITEM = "treeitem";
    public final String ITEMGROUP = "group";
    public final String ATTRIBUTELEVEL = "aria-level";
    public final String FALSE = "false";
    public static ProgressBar matProgressBarNode = new ProgressBar();

    @JDIAction("Expand '{name}' node by name '{node}'")
    public UIElement expand(final String nodeName) {
        UIElement expansionNode = getNodeByName(nodeName);
        if (!expansionNode.isEmpty() && isCollapsed(nodeName)) {
            expansionNode.finds(By.cssSelector(cssButtonLocator)).get(1).click();
        }
        return expansionNode;
    }

    @JDIAction("Collapse '{name}' panel by name '{node}'")
    public UIElement collapse(final String nodeName) {
        UIElement expansionNode = getNodeByName(nodeName);
        if (!expansionNode.isEmpty() && isExpanded(nodeName)) {
            expansionNode.finds(By.cssSelector(cssButtonLocator)).get(1).click();
        }
        return expansionNode;
    }

    @JDIAction("Is '{name}' '{node}' panel expanded")
    public boolean isExpanded(final String nodeName) {
        return !isCollapsed(nodeName);
    }

    @JDIAction("Is '{name}' '{node}' panel collapsed")
    public boolean isCollapsed(final String nodeName) {
        UIElement expansionNode = getNodeByName(nodeName);
        boolean isNodeExpanded = expansionNode.getAttribute(ATTRIBUTEEXPANDED).contains(FALSE);
        boolean isGroup = expansionNode.getAttribute(ATTRIBUTEROLE).contains(ITEMGROUP);
        return isNodeExpanded && isGroup;
    }

    @JDIAction("Is '{name}' '{0}' panel collapsed")
    public boolean isCollapsed(final int indexNumber) {
        UIElement expansionNode = getNodes().get(indexNumber);
        boolean isNodeExpanded = expansionNode.getAttribute(ATTRIBUTEEXPANDED).contains(FALSE);
        boolean isGroup = expansionNode.getAttribute(ATTRIBUTEROLE).contains(ITEMGROUP);
        return isNodeExpanded && isGroup;
    }

    @Override
    public TreeAssert is() {
        return new TreeAssert().set(this);
    }

    public void waitExpandTree(UIElement node) {
        matProgressBarNode.setCore(matProgressBarNode.getClass(), node.find(By.cssSelector(cssProgressBarLocator)));
        if(matProgressBarNode.isExist()) {
            matProgressBarNode.waitFor().disappear(1);
        }
    }

    protected UIElement getNodeByName(String name) {
        List<UIElement> nodes = getNodes();
        for(UIElement node: nodes) {
            if(node.getText().contains(name)) return node;
        }
        return null;
    }

    protected List<UIElement> getNodes() {
        return this.uiElement.finds(By.cssSelector(cssTreeNodeLocator));
    }

    protected List<UIElement> getExpansionButton() {
        return this.uiElement.finds(By.cssSelector(cssChevronLocator));
    }

    @JDIAction("Get '{name}' '{0}' value")
    public String value(final String field) {
        return "";
    }

    public List<UIElement> getNodeItems(int level) {
        List<UIElement> opened = this.uiElement.finds(By.cssSelector(cssTreeNodeLocator));
        List<UIElement> branch = new ArrayList<>();
        String shift = level*40+"px";
        for(UIElement item : opened) {
            if(item.getAttribute("style").contains(shift)) {
                branch.add(item);
            }
        }
        return branch;
    }

    public Checkbox getCheckbox(int level, String name) {
        Checkbox checkbox = new Checkbox();
        List<UIElement> branch = getNodeItems(level);
        for(UIElement item: branch) {
            if(item.getText().contains(name)) {
                checkbox.setCore(checkbox.getClass(), item.find(By.cssSelector(cssCheckBox)));
                break;
            }
        }
        return checkbox;
    }
}

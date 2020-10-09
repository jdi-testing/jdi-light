package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MaterialTree extends UIBaseElement<UIAssert<?, MaterialTree>> {

    public String cssTreeNodeLocator = "mat-tree-node";
    public String cssButtonLocator = "button > span > mat-icon";
    public String cssChevronLocator = cssTreeNodeLocator + " > "+ cssButtonLocator;

    public final String role = "role";
    public final String item = "treeitem";
    public final String itemgroup = "group";

    @JDIAction("Expand '{name}' panel by index '{0}'")
    public void expand(final int indexNumber) {
        List<WebElement> expansionIndicator = getNodeLocator();
        if (!expansionIndicator.isEmpty() && isCollapsed(indexNumber)) {
            expansionIndicator.get(indexNumber-1).click();
        }
    }

    @JDIAction("Expand '{name}' node by name '{node}'")
    public void expandByName(final String nodeName) {
        WebElement expansionIndicator = getNodeByName(nodeName);
        if (expansionIndicator!=null) {
            expansionIndicator.findElement(By.cssSelector(cssButtonLocator)).click();
        }
    }

    @JDIAction("Collapse '{name}' panel by index '{0}'")
    public void collapse(final int indexNumber) {
        List<WebElement> expansionIndicator = getExpansionButton();
        if (!expansionIndicator.isEmpty() && isExpanded(indexNumber)) {
            expansionIndicator.get(indexNumber-1).click();
        }
    }

    @JDIAction("Is '{name}' '{0}' panel expanded")
    public boolean isExpanded(final int indexNumber) {
        return !isCollapsed(indexNumber);
    }

    @JDIAction("Is '{name}' '{0}' panel collapsed")
    public boolean isCollapsed(final int indexNumber) {
        WebElement expansionHeader = getNodeLocator().get(indexNumber-1);
        boolean isHeaderExpanded = expansionHeader.getAttribute("aria-expanded").contains("false");
        boolean isContentHidden = expansionHeader.getAttribute(role).contains(itemgroup);
        return isHeaderExpanded && isContentHidden;
    }

    protected WebElement getNodeByName(String name) {
        List<WebElement> nodes = getNodeLocator();
        for(WebElement node: nodes) {
            if(node.getText().split("\n")[1].equalsIgnoreCase(name)) return node;
        }
        return null;
    }

    protected List<WebElement> getNodeLocator() {
        return this.uiElement.findElements(By.cssSelector(cssTreeNodeLocator));
    }

    protected List<WebElement> getExpansionButton() {
        return this.uiElement.findElements(By.cssSelector(cssChevronLocator));
    }
}

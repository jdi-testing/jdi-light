package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import org.openqa.selenium.By;

import java.util.List;

public class MaterialTree extends UIBaseElement<UIAssert<?, MaterialTree>> {
    public String treeLocator = "//*[@id='%s']";
    public String nodeLocator = treeLocator.concat("//mat-tree-node");
    public String contentsLocator = treeLocator.concat("//*[contains(@class,'mat-expansion-panel-content')]");
    public String iconsLocator = nodeLocator.concat("//mat-icon");
    public String titlesLocator = nodeLocator.concat("//mat-panel-title");

    public String navigationButton
            = "[text()=' %s ']//ancestor::mat-expansion-panel-header//following-sibling::*//button";
    public String nextButtonLocator = titlesLocator.concat(navigationButton.concat("//span[text()='Next']"));
    public String previousButtonLocator = titlesLocator.concat(navigationButton.concat("//span[text()='Previous']"));
    public String endButtonLocator = titlesLocator.concat(navigationButton.concat("//span[text()='End']"));

    public String expansionIndicatorLocator = nodeLocator.concat("/button/span/mat-icon");
    public String smartSharp = "smart: #";
    public String cssSharp = "css='#";

    @JDIAction("Expand '{name}' panel by index '{0}'")
    public void expand(final int indexNumber) {
        List<UIElement> expansionIndicator = getExpansionIndicatorLocator();
        List<UIElement> icons = getIconsLocator();
        if (!expansionIndicator.isEmpty() && isCollapsed(indexNumber)) {
            expansionIndicator.get(indexNumber).click();
        } else if (!icons.isEmpty() && isCollapsed(indexNumber)) {
            icons.get(indexNumber).click();
        }
    }

    @JDIAction("Collapse '{name}' panel by index '{0}'")
    public void collapse(final int indexNumber) {
        List<UIElement> expansionIndicator = getExpansionIndicatorLocator();
        List<UIElement> icons = getIconsLocator();
        if (!expansionIndicator.isEmpty() && isExpanded(indexNumber)) {
            expansionIndicator.get(indexNumber).click();
        } else if (!icons.isEmpty() && isExpanded(indexNumber)) {
            icons.get(indexNumber).click();
        }
    }

    @JDIAction("Is '{name}' '{0}' panel expanded")
    public boolean isExpanded(final int indexNumber) {
        return !isCollapsed(indexNumber);
    }

    @JDIAction("Is '{name}' '{0}' panel collapsed")
    public boolean isCollapsed(final int indexNumber) {
        UIElement expansionHeader = getNodeLocator().get(indexNumber);
        expansionHeader.waitFor();
        boolean isHeaderExpanded = expansionHeader.attr("aria-expanded").contains("false");
        UIElement expansionContent = getContentsLocator().get(indexNumber);
        expansionContent.waitFor();
        boolean isContentHidden = expansionContent.attr("style").contains("visibility: hidden");
        return isHeaderExpanded && isContentHidden;
    }

    @JDIAction("Select '{name}' '{0}' next panel")
    public void next(final String title) {
        getNextButtonLocator(title).click();
    }

    @JDIAction("Select '{name}' '{0}' previous panel")
    public void previous(final String title) {
        getPreviousButtonLocator(title).click();
    }

    @JDIAction("Select '{name}' '{0}' end selection")
    public void end(final String title) {
        getEndButtonLocator(title).click();
    }

    protected List<UIElement> getNodeLocator() {
        return new WebList(By.xpath(String.format(nodeLocator,
                this.uiElement.locator.printLocator().replace(smartSharp, "")
                        .replace(cssSharp, "").replace("'", ""))));
    }

    protected List<UIElement> getContentsLocator() {
        return new WebList(By.xpath(String.format(contentsLocator,
                this.uiElement.locator.printLocator().replace(smartSharp, "")
                        .replace(cssSharp, "").replace("'", ""))));
    }

    protected UIElement getNextButtonLocator(final String tittle) {
        return new UIElement(By.xpath(String.format(nextButtonLocator,
                this.uiElement.locator.printLocator().replace(smartSharp, "")
                        .replace(cssSharp, "").replace("'", ""), tittle)));
    }

    protected UIElement getPreviousButtonLocator(final String tittle) {
        return new UIElement(By.xpath(String.format(previousButtonLocator,
                this.uiElement.locator.printLocator().replace(smartSharp, "")
                        .replace(cssSharp, "").replace("'", ""), tittle)));
    }

    protected UIElement getEndButtonLocator(final String tittle) {
        return new UIElement(By.xpath(String.format(endButtonLocator,
                this.uiElement.locator.printLocator().replace(smartSharp, "")
                        .replace(cssSharp, "").replace("'", ""), tittle)));
    }

    protected List<UIElement> getIconsLocator() {
        return new WebList(By.xpath(String.format(iconsLocator,
                this.uiElement.locator.printLocator().replace(smartSharp, "")
                        .replace(cssSharp, "").replace("'", ""))));
    }

    protected List<UIElement> getExpansionIndicatorLocator() {
        String idName = this.uiElement.locator.printLocator().replace(smartSharp, "")
                .replace(cssSharp, "").replace("'", "");
        String sl = String.format(expansionIndicatorLocator, idName);
        List<UIElement> nodes = new WebList(By.xpath(sl));
        return nodes;
//        return new WebList(By.xpath(String.format(expansionIndicatorLocator,
//                this.uiElement.locator.printLocator().replace(smartSharp, "")
//                        .replace(cssSharp, "").replace("'", ""))));
    }
}

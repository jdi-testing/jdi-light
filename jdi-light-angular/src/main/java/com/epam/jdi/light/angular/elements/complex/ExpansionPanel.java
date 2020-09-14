package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.ExpansionPanelAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * To see an example of ExpansionPanel web element please visit https://material.angular.io/components/expansion/overview.
 */

public class ExpansionPanel extends UIBaseElement<ExpansionPanelAssert> {
    public String panelLocator = "//*[@id='%s']";
    public String headersLocator = panelLocator.concat("//mat-expansion-panel-header");
    public String contentsLocator = panelLocator.concat("//*[contains(@class,'mat-expansion-panel-content')]");
    public String contentBodiesLocator = panelLocator.concat("//*[contains(@class,'mat-expansion-panel-body')]");
    public String inputLocator = panelLocator.concat("//mat-label[text()='%s']//ancestor::div/input");
    public String iconsLocator = headersLocator.concat("//mat-icon");
    public String descriptionsLocator = headersLocator.concat("//mat-panel-description");
    public String titlesLocator = headersLocator.concat("//mat-panel-title");
    public String navigationButton
            = "[text()=' %s ']//ancestor::mat-expansion-panel-header//following-sibling::*//button";
    public String nextButtonLocator = titlesLocator.concat(navigationButton.concat("//span[text()='Next']"));
    public String previousButtonLocator = titlesLocator.concat(navigationButton.concat("//span[text()='Previous']"));
    public String endButtonLocator = titlesLocator.concat(navigationButton.concat("//span[text()='End']"));
    public String expansionIndicatorLocator = headersLocator
            .concat("//span[contains(@class, 'mat-expansion-indicator')]");
    public String smartSharp = "smart: #";
    public String cssSharp = "css='#";
    protected Datepicker accordionDateInput;

    public ExpansionPanel() {
        accordionDateInput = new Datepicker();
    }

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
        UIElement expansionHeader = getHeadersLocator().get(indexNumber);
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

    @JDIAction("Input '{name}' panel by index '{0}'")
    public void input(final String placeholder, final String inputText) {
        if ("Date".equalsIgnoreCase(placeholder)) {
            accordionDateInput.select(inputText);
        } else {
            getInputLocator(placeholder).sendKeys(inputText);
        }
    }

    @JDIAction("Clear '{name}' '{0}' field")
    public void clear(final String field) {
        getInputLocator(field).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    @JDIAction("Get '{name}' '{0}' value")
    public String value(final String field) {
        if ("Date".equalsIgnoreCase(field)) {
            return accordionDateInput.selectedDate().format(DateTimeFormatter.ofPattern("M/d/yyyy", Locale.ENGLISH));
        } else {
            return getInputLocator(field).text(TextTypes.VALUE);
        }
    }

    @JDIAction("Get '{name}' '{0}' title")
    public String title(final int indexNumber) {
        return getTitlesLocator().get(indexNumber).text().trim();
    }

    @JDIAction("Get '{name}' '{0}' description")
    public String description(final int indexNumber) {
        return getDescriptionsLocator().get(indexNumber).text().trim();
    }

    @JDIAction("Get '{name}' '{0}' content")
    public String content(final int indexNumber) {
        return getContentBodiesLocator().get(indexNumber).text().trim();
    }

    @Override
    public ExpansionPanelAssert is() {
        return new ExpansionPanelAssert().set(this);
    }

    protected List<UIElement> getHeadersLocator() {
        return new WebList(By.xpath(String.format(headersLocator,
                                                  this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                          .replace(cssSharp, "").replace("'", ""))));
    }

    protected List<UIElement> getContentsLocator() {
        return new WebList(By.xpath(String.format(contentsLocator,
                                                  this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                          .replace(cssSharp, "").replace("'", ""))));
    }

    protected List<UIElement> getContentBodiesLocator() {
        return new WebList(By.xpath(String.format(contentBodiesLocator,
                                                  this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                          .replace(cssSharp, "").replace("'", ""))));
    }

    protected UIElement getInputLocator(final String placeholder) {
        return new UIElement(By.xpath(String.format(inputLocator,
                                                    this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                            .replace(cssSharp, "").replace("'", ""), placeholder)));
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

    protected List<UIElement> getTitlesLocator() {
        return new WebList(By.xpath(String.format(titlesLocator,
                                                  this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                          .replace(cssSharp, "").replace("'", ""))));
    }

    protected List<UIElement> getIconsLocator() {
        return new WebList(By.xpath(String.format(iconsLocator,
                                                  this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                          .replace(cssSharp, "").replace("'", ""))));
    }

    protected List<UIElement> getDescriptionsLocator() {
        return new WebList(By.xpath(String.format(descriptionsLocator,
                                                  this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                          .replace(cssSharp, "").replace("'", ""))));
    }

    protected List<UIElement> getExpansionIndicatorLocator() {
        return new WebList(By.xpath(String.format(expansionIndicatorLocator,
                                                  this.uiElement.locator.printLocator().replace(smartSharp, "")
                                                          .replace(cssSharp, "").replace("'", ""))));
    }
}

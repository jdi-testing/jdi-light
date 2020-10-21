package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.FormFieldsAssert;
import com.epam.jdi.light.angular.elements.composite.MaterialSelectorContainer;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.logger.JDILogger;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.TextTypes.VALUE;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

/**
 To see an example of FormField web element please visit https://material.angular.io/components/form-field/overview#form-field-appearance-variants
 **/

public class FormField extends UIBaseElement<FormFieldsAssert> {
    private final String matFormFieldPrefix = "//mat-form-field[@";
    private final String autocompleteAttrPrefix = "_ngcontent-";
    private String containerAttribute;

    private String getContainerAttribute() {
        final String[] curAttr = {""};
        MapArray<String, String> attributesAndValues = this.core().getAllAttributes();
        List<String> attributes = attributesAndValues.keys();
        attributes.forEach(attr -> {
            boolean doesContain = attr.contains(autocompleteAttrPrefix);
            if (doesContain) {
                curAttr[0] = attr;
            }
        });
        return curAttr[0];
    }

    private UIElement getContainer() {
        containerAttribute = getContainerAttribute();
        WebElement element = null;
        try {
            element = getDriver().findElement(By.xpath("//form[@" +  containerAttribute + "]"));
        } catch (Exception e) {
            try {
                element = getDriver().findElement(By.xpath("//div[@" + containerAttribute + "]"));
            } catch (Exception exception) {
                JDILogger logger = new JDILogger();
                logger.error(exception.toString());
            }
        }
        return new UIElement(element);
    }

    public WebList getInputs() {
        return getContainer().finds(By.xpath(matFormFieldPrefix + containerAttribute + "]//input"));
    }

    public WebList getDropdowns() {
        return getContainer().finds(By.xpath(matFormFieldPrefix + containerAttribute + "]//mat-select"));
    }

    public WebList getTextAreas() {
        return getContainer().finds(By.xpath(matFormFieldPrefix + containerAttribute + "]//textarea"));
    }

    @JDIAction("Input value {1} for input in '{name}' with index {0}")
    public void input(int index, String value) {
        getInputs().get(index).input(value);
    }

    @JDIAction("Select value {1} for dropdown '{name}' with index {0}")
    public void select(int index, String value) {
        getDropdowns().get(index).click();
        MaterialSelectorContainer cdkOverlayContainer = new MaterialSelectorContainer();
        cdkOverlayContainer.select(value);
    }

    @JDIAction("Input value {1} for text area in '{name}' with index {0}")
    public void setTextArea(int index, String value) {
        getTextAreas().get(index).input(value);
    }

    @JDIAction("Get value for input with index {0} in '{name}'")
    public String inputText(int index) {
        return getInputs().get(index).text(VALUE);
    }

    @JDIAction("Get value for input with index {0} in '{name}'")
    public String getInputValue(int index) {
        return inputText(index);
    }

    @JDIAction("Get value for text area with index {0} in '{name}'")
    public String textAreaText(int index) {
        return getTextAreas().get(index).text(VALUE);
    }

    @JDIAction("Get value for text area with index {0} in '{name}'")
    public String getTextAreaValue(int index) {
        return textAreaText(index);
    }

    @JDIAction("Get value for dropdown with index {0} in '{name}'")
    public String getDropdownValue(int index) {
        return getDropdowns().get(index).getText();
    }

    @JDIAction("Get placeholder for input in '{name}' with index {0}")
    public String inputPlaceholder(int index) {
        String placeholder = "placeholder";
        return (getInputs().get(index).hasAttribute(placeholder)) ? getInputs().get(index).getAttribute(placeholder) : "";
    }

    @JDIAction("Get label for input in '{name}' with index {0}")
    public String inputLabel(int index) {
        UIElement label = getInputs().get(index).
            find(By.xpath("//ancestor::mat-form-field[@" + containerAttribute + "]//mat-label"));
        return label.getText();
    }

    @JDIAction("Get label for text area in '{name}' with index {0}")
    public String textAreaLabel(int index) {
        UIElement label = getTextAreas().get(index).
            find(By.xpath("//ancestor::mat-form-field[@" + containerAttribute + "]//mat-label"));
        return label.getText();
    }

    @JDIAction("Get label for dropdown in '{name}' with index {0}")
    public String dropdownLabel(int index) {
        UIElement label = getDropdowns().get(index).
            find(By.xpath("//ancestor::mat-form-field[@" + containerAttribute + "]//mat-label"));
        return label.getText();
    }

    @JDIAction("Get hint for input in '{name}' with index {0}")
    public String inputHint(int index) {
        UIElement hint = getInputs().get(index).
            find(By.xpath("//ancestor::mat-form-field[@" + containerAttribute + "]//mat-hint"));
        return hint.getText();
    }

    @JDIAction("Get hint for '{name}' with index {0}")
    public String hint(int index) {
        UIElement hint = getFormFields().get(index).find(By.cssSelector("mat-hint"));
        return hint.getText();
    }

    @JDIAction("Get placeholder for '{name}' with index {0}")
    public String placeholder(int index) {
        String placeholder = "placeholder";
        String type = getType(index);
        WebElement element = getFormFields().get(index).find(By.xpath("//" + type));
        UIElement actualElement = new UIElement(element);
        return (actualElement.hasAttribute(placeholder)) ? actualElement.getAttribute(placeholder) : "";
    }

    @JDIAction("Get label for '{name}' with index {0}")
    public String label(int index) {
        UIElement label = getFormFields().get(index).find(By.xpath("//mat-label"));
        return label.getText();
    }

    @JDIAction("Get error for input in '{name}' with index {0}")
    public String inputError(int index) {
        UIElement error = getInputs().get(index).
            find(By.xpath("//ancestor::mat-form-field[@" + containerAttribute + "]//mat-error"));
        return error.getText();
    }

    @JDIAction("Get error for '{name}' with index {0}")
    public String error(int index) {
        UIElement error = getFormFields().get(index).find(By.xpath("//mat-error"));
        return error.getText();
    }

    @JDIAction("Get focus out from '{name}'")
    public void focusOut() {
        getContainer().click();
    }

    @JDIAction("Clear value from input in '{name}' with index {0}")
    public void clearInput(int index) {
        getInputs().get(index).sendKeys(Keys.CONTROL + "a");
        getInputs().get(index).sendKeys(Keys.DELETE);
        focusOut();
    }

    @JDIAction("Clear value from text area in '{name}' with index {0}")
    public void clearTextArea(int index) {
        getTextAreas().get(index).sendKeys(Keys.CONTROL + "a");
        getTextAreas().get(index).sendKeys(Keys.DELETE);
        focusOut();
    }

    private String getType(int index) {
        String type = "";
        getContainer();
        String currentXpath = "(" + matFormFieldPrefix + containerAttribute + "])[" + index + "]";
        try {
            getDriver().findElement(By.xpath(currentXpath + "//input"));
            type = "input";
        } catch (Exception e1) {
            try {
                getDriver().findElement(By.xpath(currentXpath + "//mat-select"));
                type = "mat-select";
            } catch (Exception e2) {
                try{
                    getDriver().findElement(By.xpath(currentXpath + "//textarea"));
                    type = "textarea";
                } catch (Exception e3) {
                    JDILogger logger = new JDILogger();
                    logger.error(e3.toString());
                }
            }
        }
        return type;
    }

    private WebList getFormFields() {
        return getContainer().finds(By.xpath(matFormFieldPrefix + containerAttribute + "]"));
    }

    @JDIAction("Set value {1} for '{name}' with index {0}")
    public void set(int index, String value) {
        String type = getType(index);
        WebElement element = getFormFields().get(index).find(By.xpath("//" + type));
        UIElement actualElement = new UIElement(element);
        switch (type) {
            case "input":
                actualElement.input(value);
                break;
            case "textarea":
                actualElement.input(value);
                break;
            case "mat-select":
                actualElement.click();
                MaterialSelectorContainer cdkOverlayContainer = new MaterialSelectorContainer();
                cdkOverlayContainer.select(value);
                break;
            default:
                break;
        }
    }

    @JDIAction("Get value for '{name}' with index {0}")
    public String value(int index) {
        String value = "";
        String type = getType(index);
        WebElement element = getFormFields().get(index).find(By.xpath("//" + type));
        UIElement actualElement = new UIElement(element);
        switch (type) {
            case "input":
                value = actualElement.text(VALUE);
                break;
            case "textarea":
                value = actualElement.text(VALUE);
                break;
            case "mat-select":
                value = actualElement.getText();
                break;
            default:
                break;
        }
        return value;
    }

    @JDIAction("Clear value from '{name}' with index {0}")
    public void clear(int index) {
        String type = getType(index);
        WebElement element = getFormFields().get(index).find(By.xpath("//" + type));
        UIElement actualElement = new UIElement(element);
        actualElement.sendKeys(Keys.CONTROL + "a");
        actualElement.sendKeys(Keys.DELETE);
        focusOut();
    }

    @JDIAction("Click icon in '{name}' with index {0}")
    public void clickIcon(int index) {
        WebElement element = getFormFields().get(index).find(By.xpath("//mat-icon"));
        UIElement actualElement = new UIElement(element);
        actualElement.click();
    }

    @JDIAction("Get icon text in '{name}' with index {0}")
    public String icon(int index) {
        WebElement element = getFormFields().get(index).find(By.xpath("//mat-icon"));
        UIElement actualElement = new UIElement(element);
        return actualElement.getText();
    }

    @JDIAction("Get font attributes in '{name}' with index {0}")
    public String font(int index) {
        String type = getType(index);
        WebElement element = getFormFields().get(index).find(By.xpath("//" + type));
        UIElement actualElement = new UIElement(element);
        return actualElement.getCssValue("font");
    }

    @JDIAction("Get color attribute in '{name}' with index {0}")
    public String color(int index) {
        String type = getType(index);
        WebElement element = getFormFields().get(index).find(By.xpath("//" + type));
        UIElement actualElement = new UIElement(element);
        return actualElement.getCssValue("color");
    }

    @Override
    public FormFieldsAssert is() {
        return new FormFieldsAssert().set(this);
    }
}

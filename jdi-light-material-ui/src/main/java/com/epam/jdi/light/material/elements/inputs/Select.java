package com.epam.jdi.light.material.elements.inputs;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDISelect;
import com.epam.jdi.light.material.asserts.inputs.SelectAssert;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.Field;
import java.util.List;
import java.util.NoSuchElementException;

public class Select extends UIBaseElement<SelectAssert> implements ISetup {

    private String root;
    private String items;
    private String itemByText;

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return this.find(root).hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name} enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Is '{name}' is expanded")
    public Boolean isExpanded() {
        return this.find(root).hasAttribute("aria-expanded");
    }

    @JDIAction("Is '{name}' is collapsed")
    public Boolean isCollapsed() {
        return !isExpanded();
    }

    @JDIAction("Is text in '{name}' is displayed")
    public Boolean isItemDisplayed(String itemText) {
        return itemText.equals(getText());
    }
    @JDIAction("Is text in '{name}' is contained")
    public Boolean isItemContains(String itemText) {
        return getText().contains(itemText);
    }

    public void open() {
        if (isCollapsed()){
            this.find(root).click();
        }
    }

    public void close(){
        Actions actions = new Actions(core().driver());
        actions.sendKeys(Keys.ESCAPE).perform();
        this.is().collapsed();
    }

    @JDIAction("Select item for '{name}' by text")
    public void selectItemByText(String item) {
        if (StringUtils.isBlank(itemByText)){
            core().finds(items).stream().filter(i -> item.equals(i.getText())).findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .get().click();
        }
        else {
            try {
                core().find(String.format(itemByText, item)).click();
            } catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }
    }

    @JDIAction("Select item for '{name}' by index")
    public void selectItemByIndex(int index) {
        core().finds(items).get(index).click();
    }

    @JDIAction("Select items for '{name}'")
    public void multipleSelect(List<String> items) {
        items.forEach(this::selectItemByText);
    }

    private String getText(){
        return this.find(root).getText();
    }

    @Override
    public SelectAssert is() {
        return new SelectAssert().set(this);
    }


    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDISelect.class, Select.class))
            return;
        JDISelect j = field.getAnnotation(JDISelect.class);

        root = j.root();
        items = j.items();
        itemByText = j.itemByText();
    }
}

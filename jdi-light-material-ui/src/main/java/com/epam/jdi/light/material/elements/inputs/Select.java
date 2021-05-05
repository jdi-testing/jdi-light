package com.epam.jdi.light.material.elements.inputs;

import static com.epam.jdi.light.common.Exceptions.exception;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.SelectAssert;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.NoSuchElementException;

public class Select extends UIBaseElement<SelectAssert> {

    private String items = "li.MuiListItem-button";
    private String itemByText = "//li[text() = '%s']";

    @JDIAction("Select item for '{name}' by text")
    public void selectItemByText(String item) {
        if (StringUtils.isBlank(itemByText)) {
            core().finds(items).stream().filter(i -> item.equals(i.getText())).findFirst()
                    .orElseThrow(IllegalArgumentException::new)
                    .get().click();
        } else {
            try {
                core().find(String.format(itemByText, item)).click();
            } catch (NoSuchElementException e) {
                throw exception("There is no item " + item);
            }
        }
    }

    @JDIAction("Select items for '{name}'")
    public void multipleSelect(List<String> items) {
        items.forEach(this::selectItemByText);
    }

    @Override
    public SelectAssert is() {
        return new SelectAssert().set(this);
    }
}

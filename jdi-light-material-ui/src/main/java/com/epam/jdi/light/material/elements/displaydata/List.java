package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.ListAssert;
import com.epam.jdi.light.material.asserts.displaydata.ListItemAssert;

import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;

public class List<L extends UIBaseElement<ListItemAssert>> extends UIBaseElement<ListAssert> {
    protected final String LIST_ITEM_CONTAINER_LOCATOR = ".MuiListItem-container";
    protected final String LIST_ITEM_LOCATOR = ".MuiListItem-root";
    protected final String SUBHEADER_LOCATOR =".MuiListSubheader-root";

    @JDIAction("Return a list of '{name}' items")
    public java.util.List<ListItem> items() {
        if (finds(LIST_ITEM_CONTAINER_LOCATOR).size() > 0) {
            return finds(LIST_ITEM_CONTAINER_LOCATOR).stream().map(listItem -> new ListItem().setCore(ListItem.class, listItem)).collect(Collectors.toList());
        } else return finds(LIST_ITEM_LOCATOR).stream().map(listItem -> new ListItem().setCore(ListItem.class, listItem)).collect(Collectors.toList());
    }

    @JDIAction("Return size of '{name}'")
    public int size() {
        return items().size();
    }

    @JDIAction("Check if '{name}' does not contain any elements")
    public boolean isEmpty() {
        return items().size() == 0;
    }

    @JDIAction("Check if '{name}' is dense")
    public boolean isDense() {
        return hasClass("MuiList-dense");
    }

    @JDIAction("Check if '{name}' has a subheader")
    public boolean hasSubheader() {
        return finds(SUBHEADER_LOCATOR).isDisplayed();
    }

    @JDIAction("Get '{name}' subheader text")
    public String subheaderText() {
        if (hasSubheader()) {
            return find(SUBHEADER_LOCATOR).text();
        } else {
            throw exception("The list has no subheader");
        }
    }

    @JDIAction("Click on the first item in '{name}' with text '{0}'")
    public void selectItemByText(String itemText) {
        for (ListItem item : items()) {
            if (item.getText().equals(itemText)) {
                item.click();
                break;
            }
        }
    }

    @Override
    public ListAssert is() { return new ListAssert().set(this); }
}

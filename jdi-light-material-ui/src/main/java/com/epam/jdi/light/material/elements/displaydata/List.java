package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIList;
import com.epam.jdi.light.material.asserts.displaydata.ListAssert;

import java.lang.reflect.Field;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Material UI Lists are continuous, vertical indexes of text or images.
 *
 * Lists are customizable and can be placed inside other lists.
 *
 * To see an example of Lists web element please visit
 * https://mui.com/components/lists/
 */

public class List extends UIBaseElement<ListAssert> implements ISetup {

    protected String rootLocator = ".MuiList-root";
    protected final String LIST_ITEM_CONTAINER_LOCATOR = ".MuiListItem-container";
    protected final String LIST_ITEM_LOCATOR = ".MuiListItem-root";
    protected final String SUBHEADER_LOCATOR =".MuiListSubheader-root";

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIList.class, List.class)) return;
        JDIList j = field.getAnnotation(JDIList.class);
        setup(j.root());
        this.setCore(List.class, $(rootLocator));
    }

    public List setup(String rootLocator) {
        if (isNotBlank(rootLocator))
            this.rootLocator = rootLocator;
        return this;
    }

    @JDIAction("Return Java list of '{name}' items")
    public java.util.List<ListItem> items() {
        if (finds(LIST_ITEM_CONTAINER_LOCATOR).size() > 0) {
            return finds(LIST_ITEM_CONTAINER_LOCATOR).stream().map(listItem -> new ListItem().setCore(ListItem.class, listItem)).collect(Collectors.toList());
        } else return finds(LIST_ITEM_LOCATOR).stream().map(listItem -> new ListItem().setCore(ListItem.class, listItem)).collect(Collectors.toList());
    }

    @JDIAction("Return Java list containing MUI lists nested within '{name}'")
    public java.util.List<List> nestedLists() {
        return finds("ul").stream().map(nestedList -> new List().setCore(List.class, nestedList)).collect(Collectors.toList());
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

    @JDIAction("Get '{name}' subheader")
    public UIElement getSubheader() {
        if (hasSubheader()) {
            return find(SUBHEADER_LOCATOR);
        } else {
            throw exception("The list has no subheader");
        }
    }

    @JDIAction("Get the first item in '{name}' with text '{0}'")
    public ListItem getItemByText(String itemText) {
        for (ListItem item : items()) {
            if (item.getText().equals(itemText)) {
                return item;
            }
        }
        throw exception(format("The list has no item with text '%s'", itemText));
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

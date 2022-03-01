package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIList;
import com.epam.jdi.light.material.asserts.displaydata.ListAssert;
import com.jdiai.tools.Timer;

import java.lang.reflect.Field;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Material UI Lists are continuous, vertical indexes of text or images.
 * <p>
 * Lists are customizable and can be placed inside other lists.
 * <p>
 * To see an example of Lists web element please visit
 * https://mui.com/components/lists/
 */

public class List extends UIBaseElement<ListAssert> implements ISetup {

    protected String rootLocator = ".MuiList-root";
    protected static final String LIST_ITEM_CONTAINER_LOCATOR = ".MuiListItem-container";
    protected static final String LIST_ITEM_LOCATOR = ".MuiListItem-root";
    protected static final String SUBHEADER_LOCATOR = ".MuiListSubheader-root";

    private List() {
    }

    public List(UIElement element) {
        core().setCore(element);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIList.class, List.class)) {
            return;
        }
        JDIList j = field.getAnnotation(JDIList.class);
        setup(j.root());
        this.setCore(List.class, $(rootLocator));
    }

    public List setup(String rootLocator) {
        if (isNotBlank(rootLocator)) {
            this.rootLocator = rootLocator;
        }
        return this;
    }

    @JDIAction("Return Java list of '{name}' items")
    public java.util.List<ListItem> items() {
        if (finds(LIST_ITEM_CONTAINER_LOCATOR).size() > 0) {
            return finds(LIST_ITEM_CONTAINER_LOCATOR).stream()
                    .map(listItem -> new ListItem().setCore(ListItem.class, listItem))
                    .collect(Collectors.toList());
        } else {
            return finds(LIST_ITEM_LOCATOR).stream()
                    .map(listItem -> new ListItem().setCore(ListItem.class, listItem))
                    .collect(Collectors.toList());
        }
    }

    @JDIAction("Get the first item in '{name}' with text '{0}'")
    public ListItem getItemByText(String itemText) {
        for (ListItem item : items()) {
            if (item.getText().equals(itemText)) {
                return item;
            }
        }
        throw runtimeException(format("The list has no item with text '%s'", itemText));
    }

    @JDIAction("Click on the first item in '{name}' with text '{0}'")
    public void selectItemByText(String itemText) {
        for (ListItem item : items()) {
            if (item.getText().equals(itemText)) {
                item.click();
                Timer.waitCondition(item::isNotVisible);
                break;
            }
        }
    }

    @JDIAction("Return Java list containing Material UI lists nested directly within '{name}'")
    public java.util.List<List> nestedLists() {
        return finds(".//ul[not(parent::ul)]").stream() // targets only the first layer of nested lists
                .map(nestedList -> new List().setCore(List.class, nestedList))
                .collect(Collectors.toList());
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
        return core().hasClass("MuiList-dense");
    }

    @JDIAction("Get a list '{name}' subheaders as UIElements")
    public java.util.List<UIElement> subheaders() {
        return finds(SUBHEADER_LOCATOR).stream()
                .map(subheader -> new UIElement().setCore(UIElement.class, subheader)).collect(Collectors.toList());
    }

    @JDIAction("Get icon of '{name}' item {0}")
    public Icon itemIcon(String menuItem) {
        return new Icon().setCore(Icon.class, getItemByText(menuItem).core().find(".MuiListItemIcon-root"));
    }

    @JDIAction("Scroll to '{name}' item {0}")
    public void scrollToItem(String menuItem) {
        getItemByText(menuItem).core().jsExecute("scrollIntoView()");
    }

    @Override
    public ListAssert is() {
        return new ListAssert().set(this);
    }

}

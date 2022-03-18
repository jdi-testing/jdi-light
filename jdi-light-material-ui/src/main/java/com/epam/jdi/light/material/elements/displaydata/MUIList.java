package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.displaydata.MUIListAssert;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static java.lang.String.format;

/**
 * To see an example of Lists web element please visit
 * https://mui.com/components/lists/
 */

public class MUIList extends UIBaseElement<MUIListAssert> {

    protected static final String LIST_ITEM_CONTAINER_LOCATOR = ".MuiListItem-container";
    protected static final String LIST_ITEM_LOCATOR = ".MuiListItem-root";
    protected static final String SUBHEADER_LOCATOR = ".MuiListSubheader-root";

    private MUIList() {
    }

    public MUIList(UIElement element) {
        core().setCore(element);
    }

    @JDIAction("Get list of '{name}' items")
    public List<MUIListItem> items() {
        Function<String, List<MUIListItem>> function = locator -> finds(locator).stream()
                .map(listItem -> new MUIListItem().setCore(MUIListItem.class, listItem))
                .collect(Collectors.toList());
        if (!finds(LIST_ITEM_CONTAINER_LOCATOR).isEmpty()) {
            return function.apply(LIST_ITEM_CONTAINER_LOCATOR);
        } else {
            return function.apply(LIST_ITEM_LOCATOR);
        }
    }

    @JDIAction("Get the first item in '{name}' with text '{0}'")
    public MUIListItem getItemByText(String itemText) {
        for (MUIListItem item : items()) {
            if (item.getText().equals(itemText)) {
                return item;
            }
        }
        throw runtimeException(format("The list has no item with text '%s'", itemText));
    }

    @JDIAction("Click on the first item in '{name}' with text '{0}'")
    public void selectItemByText(String itemText) {
        getItemByText(itemText).click();
    }

    @JDIAction("Get list of Material UI lists nested directly within '{name}'")
    public List<MUIList> nestedLists() {
        return finds(".//ul[not(parent::ul)]").stream() // targets only the first layer of nested lists
                .map(nestedList -> new MUIList().setCore(MUIList.class, nestedList))
                .collect(Collectors.toList());
    }

    @JDIAction("Get size of '{name}'")
    public int size() {
        return items().size();
    }

    @JDIAction("Check that '{name}' is empty")
    public boolean isEmpty() {
        return items().isEmpty();
    }

    @JDIAction("Get list of '{name}' subheaders")
    public java.util.List<UIElement> subheaders() {
        return finds(SUBHEADER_LOCATOR).stream()
                .map(subheader -> new UIElement().setCore(UIElement.class, subheader)).collect(Collectors.toList());
    }

    @Override
    public MUIListAssert is() {
        return new MUIListAssert().set(this);
    }

}

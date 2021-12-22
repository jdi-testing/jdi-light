package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.displaydata.ListItem;

import java.util.stream.Collectors;

public class TransferInnerList extends List {

    // Filters out the textless intransferable <li> element which seems to be a transfer list-specific hack
    protected final String LIST_ITEM_LOCATOR = "div.MuiListItem-root";

    @Override
    @JDIAction("Return Java list of '{name}' items")
    public java.util.List<ListItem> items() {
            return finds(LIST_ITEM_LOCATOR).stream()
                    .map(listItem -> new ListItem().setCore(ListItem.class, listItem))
                    .collect(Collectors.toList());
    }
}

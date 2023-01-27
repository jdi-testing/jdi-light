package com.epam.jdi.light.vuetify.elements.complex.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.tables.DataIteratorAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * To see an example of Data Iterator web element please visit https://vuetifyjs.com/en/components/data-iterators/
 */

public class DataIterator extends UIBaseElement<DataIteratorAssert> implements HasTheme, IsText {
    private static final String TITLE = "[class*='title']";
    private static final String LIST_ITEM = "[role = 'listitem']";
    private static final String TABLE = ".v-card";

    public WebList dataIteratorElements() {
        return finds("[class^='col']");
    }

    private UIElement expander(int colNum) {
        return dataIteratorElements().get(colNum).find("[class*='selection']");
    }

    public Integer getColumnsValue() {
        return dataIteratorElements().size();
    }

    @JDIAction("Is '{name}' expanded")
    public boolean columnIsExpanded(int colNum) {
        if (expander(colNum).isExist()) {
            return dataIteratorElements().get(colNum).find("input[role=switch]")
                    .attr("aria-checked").equalsIgnoreCase("true");
        } else {
            return false;
        }
    }

    @JDIAction("Get single '{name}' column")
    public Map<String, WebList> getSingleColumn(int colNum) {
        Map<String, WebList> singleColumn = new HashMap<>();
        UIElement singleElement = dataIteratorElements().get(colNum);
        if (!columnIsExpanded(colNum) && expander(colNum).isExist()) {
            expander(colNum).click();
        }
        String columnTitle = singleElement.find(TITLE).getText();
        singleColumn.put(columnTitle, singleElement.finds(LIST_ITEM));
        return singleColumn;
    }

    @JDIAction("Get '{name}' column")
    public WebList getColumn(int colNum) {
        return dataIteratorElements().get(colNum).finds(LIST_ITEM);
    }

    @JDIAction("Get '{name}' column items")
    public List<String> getColumnItems(int colNum) {
        List<String> columnItemList = new LinkedList<>();
        if (!columnIsExpanded(colNum) && expander(colNum).isExist()) {
            expander(colNum).click();
        }
        dataIteratorElements().get(colNum).finds(LIST_ITEM).values().forEach(item -> {
            String finalItem = item.replaceAll("[\\t\\n\\r]+", " ");
            columnItemList.add(finalItem);
        });
        return columnItemList;
    }

    @JDIAction("Get '{name}' column title")
    public String getColumnTitle(int colNum) {
        return dataIteratorElements().get(colNum).find(TITLE).getText();
    }

    @JDIAction("Is '{name}' column empty")
    public boolean columnIsEmpty(int colNum) {
        return getColumn(colNum).isEmpty();
    }

    @JDIAction("Get '{name}' iterator")
    public UIElement table() {
        return find(TABLE);
    }

    @JDIAction("Get '{name}' header")
    public UIElement tableHeader() {
        return find(".v-toolbar__title");
    }

    @JDIAction("Get '{name}' header")
    public String getTableHeader() {
        return tableHeader().getText();
    }

    @JDIAction("Get '{name}' footer")
    public UIElement tableFooter() {
        return find(".v-toolbar__title.subheading");
    }


    @JDIAction("Get '{name}' footer")
    public String getTableFooter() {
        return tableFooter().getText();
    }

    @JDIAction("Get '{name}' header theme")
    public String headerTheme() {
        return tableHeader().find("//ancestor::header[contains(@class, v-toolbar)]").classLike("theme--");
    }

    @JDIAction("Get '{name}' footer theme")
    public String footerTheme() {
        return tableFooter().find("//ancestor::header[contains(@class, v-toolbar)]").classLike("theme--");
    }

    @Override
    @JDIAction("Get '{name}' theme")
    public String theme() {
        return table().classLike("theme--");
    }

    @Override
    public DataIteratorAssert is() {
        DataIteratorAssert dataIteratorAssert = new DataIteratorAssert();
        dataIteratorAssert.set(this);
        return dataIteratorAssert;
    }

    @Override
    public DataIteratorAssert assertThat() {
        return is();
    }

    @Override
    public DataIteratorAssert has() {
        return is();
    }
}

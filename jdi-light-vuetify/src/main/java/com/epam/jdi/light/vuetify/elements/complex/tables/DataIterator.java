package com.epam.jdi.light.vuetify.elements.complex.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

import static com.epam.jdi.light.elements.init.UIFactory.$$;

import com.epam.jdi.light.vuetify.asserts.tables.DataIteratorAssert;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * To see an example of Data Iterator web element please visit https://vuetifyjs.com/en/components/data-iterators/
 */

public class DataIterator extends DataTable {
    private static final String TITLE_PATH = "[class*='title']";
    private static final String LIST_ITEM_PATH = "[role = 'listitem']";

    private WebList dataIteratorElements() {
        return finds("[class^='col']");
    }

    private WebList options() {
        return $$("div.v-list-item__content > div.v-list-item__title");
    }

    private WebList itemsPerPage() {
        return $$("div[role=menuitem]");
    }

    private void expandOptionList() {
        find("div[aria-haspopup='listbox']").click();
    }

    private UIElement expander(int colNum) {
        return dataIteratorElements().get(colNum).find("[class*='selection']");
    }

    public Integer getColumnsValue() {
        return dataIteratorElements().size();
    }

    @JDIAction("Expand {name}")
    public void expandColumn(int colNum) {
        if (!columnIsExpanded(colNum) && expander(colNum).isExist()) {
            expander(colNum).click();
        }
    }

    @JDIAction("Close {name}")
    public void collapseCollumn(int colNum) {
        if (columnIsExpanded(colNum) && expander(colNum).isExist()) {
            expander(colNum).click();
        }
    }

    @JDIAction("Is {name} expanded")
    public boolean columnIsExpanded(int colNum) {
        if (expander(colNum).isExist()) {
            return dataIteratorElements().get(colNum).find("input[role=switch]")
                    .attr("aria-checked").equalsIgnoreCase("true");
        } else {
            return false;
        }
    }

    @JDIAction("Get single {name} column")
    public Map<String, WebList> getSingleColumn(int colNum) {
        Map<String, WebList> singleColumn = new HashMap<>();
        UIElement singleElement = dataIteratorElements().get(colNum);
        expandColumn(colNum);
        String columnTitle = singleElement.find(TITLE_PATH).getText();
        singleColumn.put(columnTitle, singleElement.finds(LIST_ITEM_PATH));
        return singleColumn;
    }

    @JDIAction("Get {name} column")
    public WebList getColumn(int colNum) {
        return dataIteratorElements().get(colNum).finds(LIST_ITEM_PATH);
    }

    @JDIAction("Get {name} column items")
    public List<String> getColumnItems(int colNum) {
        List<String> columnItemList = new LinkedList<>();
        expandColumn(colNum);
        dataIteratorElements().get(colNum).finds(LIST_ITEM_PATH).values().forEach(item -> {
            String finalItem = item.replaceAll("[\\t\\n\\r]+", " ");
            columnItemList.add(finalItem);
        });
        return columnItemList;
    }

    @JDIAction("Get {name} column title")
    public String getColumnTitle(int colNum) {
        return dataIteratorElements().get(colNum).find(TITLE_PATH).getText();
    }

    @JDIAction("Sorting {name} columns by option index by ascend")
    public void sortAscend(int optNum) {
        expandOptionList();
        options().select(optNum);
        find(".mdi-arrow-up").click();
    }

    @JDIAction("Sorting {name} columns by option name by ascend")
    public void sortAscend(String optName) {
        expandOptionList();
        options().select(optName);
        find(".mdi-arrow-up").click();
    }

    @JDIAction("Sorting {name} columns by option index by descend")
    public void sortDescend(int optNum) {
        expandOptionList();
        options().select(optNum);
        find(".mdi-arrow-down").click();
    }

    @JDIAction("Sorting {name} columns by option name by descend")
    public void sortDescend(String optName) {
        expandOptionList();
        options().select(optName);
        find(".mdi-arrow-down").click();
    }

    @JDIAction("Select {name} columns quantity on page")
    public void numberColumnsOnPage(int index) {
        find(".mdi-chevron-down").click();
        itemsPerPage().select(index);
    }

    @JDIAction("Select {name} columns quantity on page")
    public void numberColumnsOnPage(String value) {
        find(".mdi-chevron-down").click();
        itemsPerPage().select(value);
    }

    @JDIAction("Is {name} column empty")
    public boolean columnIsEmpty(int colNum) {
        return getColumn(colNum).isEmpty();
    }

    @JDIAction("Get {name} header")
    public String getTableHeader() {
        return find(".v-toolbar__title").getText();
    }

    @JDIAction("Get {name} footer")
    public String getTableFooter() {
        return this.find(".v-toolbar__title.subheading").getText();
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

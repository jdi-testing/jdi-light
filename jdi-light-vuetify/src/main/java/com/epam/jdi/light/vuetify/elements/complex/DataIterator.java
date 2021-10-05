package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import com.epam.jdi.light.vuetify.asserts.DataIteratorAssert;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * To see an example of Data Iterator web element please visit https://vuetifyjs.com/en/components/data-iterators/
 */

public class DataIterator extends UIBaseElement<DataIteratorAssert> {
    private final String title_path = "div[class*='title']";
    private final String input_path = "div[class*='selection']";
    private final String list_item_path = "div[role = 'listitem']";

    private WebList dataIteratorElements() {
        return this.finds("div[class^='col']");
    }

    private WebList options() {
        return $$("div[role=option]");
    }

    private WebList itemsPerPage() {
        return $$("div[role=menuitem]");
    }

    private WebList pageButtons() {
        return finds("button[type=button]");
    }

    private void expandOptionList() {
        this.find("div[aria-haspopup='listbox']").click();
    }

    private UIElement expander(int colNum) {
        return dataIteratorElements().get(colNum).find(input_path);
    }

    private UIElement clearingButton() {
        return this.find("button[aria-label='clear icon']");
    }

    @JDIAction("Expand {name}")
    public void expandColumn(int colNum) {
        if (!columnIsExpanded(colNum) && expander(colNum).isExist()) {
            expander(colNum).click();
        }
    }

    @JDIAction("Close {name}")
    public void closeColumn(int colNum) {
        if (columnIsExpanded(colNum) && expander(colNum).isExist()) {
            expander(colNum).click();
        }
    }

    @JDIAction("Is {name} expanded")
    public boolean columnIsExpanded(int colNum) {
        if (expander(colNum).isExist()) {
            return dataIteratorElements().get(colNum).find("input[role=switch]")
                    .attr("aria-checked").equalsIgnoreCase("true");
        } else return false;
    }

    @JDIAction("Get all {name} columns")
    public Map<String, WebList> getAllColumns() {
        Map<String, WebList> maps = new HashMap<>();
        dataIteratorElements().forEach(el -> {
            String name = el.find(title_path).getText();
            if (el.find(input_path).isExist()) {
                el.find(input_path).click();
            }
            WebList elems = el.finds(list_item_path);
            maps.put(name, elems);
        });
        return maps;
    }

    @JDIAction("Get single {name} column")
    public Map<String, WebList> getSingleColumn(int colNum) {
        Map<String, WebList> singleColumn = new HashMap<>();
        UIElement singleElement = dataIteratorElements().get(colNum);
        expandColumn(colNum);
        String columnTitle = singleElement.find(title_path).getText();
        singleColumn.put(columnTitle, singleElement.finds(list_item_path));
        return singleColumn;
    }

    @JDIAction("Get {name} column")
    public WebList getColumn(int colNum) {
        return dataIteratorElements().get(colNum).finds(list_item_path);
    }

    @JDIAction("Get {name} column items")
    public List<String> getColumnItems(int colNum) {
        List<String> columnItemList = new LinkedList<>();
        expandColumn(colNum);
        dataIteratorElements().get(colNum).finds(list_item_path).values().forEach(item -> {
            String finalItem = item.replaceAll("[\\t\\n\\r]+", " ");
            columnItemList.add(finalItem);
        });
        return columnItemList;
    }

    @JDIAction("Get {name} column title")
    public String getColumnTitle(int colNum) {
        return dataIteratorElements().get(colNum).find(title_path).getText();
    }

    @JDIAction("Search {name} element")
    public void search(String colName) {
        if (clearingButton().isExist()) {
            clear();
        }
        this.find("input[type=text]").sendKeys(colName);
    }

    @JDIAction("Clear {name} searching element")
    public void clear() {
        clearingButton().click();
    }

    @JDIAction("Sorting {name} columns by option index by ascend")
    public void sortAscend(int optNum) {
        expandOptionList();
        options().select(optNum);
        pageButtons().select(1);
    }

    @JDIAction("Sorting {name} columns by option name by ascend")
    public void sortAscend(String optName) {
        expandOptionList();
        options().select(optName);
        pageButtons().select(1);
    }

    @JDIAction("Sorting {name} columns by option index by descend")
    public void sortDescend(int optNum) {
        expandOptionList();
        options().select(optNum);
        pageButtons().select(2);
    }

    @JDIAction("Sorting {name} columns by option name by descend")
    public void sortDescend(String optName) {
        expandOptionList();
        options().select(optName);
        pageButtons().select(2);
    }

    @JDIAction("Select {name} columns quantity on page")
    public void quantityColumnsOnPage(int index) {
        pageButtons().select(3);
        itemsPerPage().select(index);
    }

    @JDIAction("Select {name} columns quantity on page")
    public void quantityColumnsOnPage(String value) {
        pageButtons().select(3);
        itemsPerPage().select(value);
    }

    @JDIAction("Switch {name} page forward")
    public void nextPage() {
        pageButtons().select(5);
    }

    @JDIAction("Switch {name} page backward")
    public void previousPage() {
        pageButtons().select(4);
    }

    @JDIAction("Is {name} column empty")
    public boolean columnIsEmpty(int colNum) {
        return getColumn(colNum).isEmpty();
    }

    @JDIAction("Get {name} header")
    public String getHeader() {
        return this.find(".v-toolbar__title").getText();
    }

    @JDIAction("Get {name} footer")
    public String getFooter() {
        return this.find(".v-toolbar__title.subheading").getText();
    }

    @Override
    public DataIteratorAssert is() {
        return new DataIteratorAssert().set(this);
    }
}

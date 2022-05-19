package com.epam.jdi.light.vuetify.elements.complex.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.tables.DataTableAssert;
import com.jdiai.tools.Timer;
import org.openqa.selenium.Keys;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Data Table web element please visit https://vuetifyjs.com/en/components/data-tables/
 **/

public class DataTable extends SimpleTable {
    public static final String TABLE_INPUT_PATH = ".menuable__content__active input[type='text']";

    protected WebList menuContent() {
        return $$("[class*='active'] [role='listbox'] [role='option']");
    }

    protected WebList newItemCard() {
        return $$("//div[@role='document']//div[@class='row']/child::div");
    }

    public WebList groups() {
        return finds(".v-row-group__header");
    }

    public void expand() {
        find(".mdi-menu-down").click();
    }

    protected UIElement input() {
        return find("[type='text']");
    }

    protected UIElement singleSelect() {
        return find(".v-input--selection-controls__input");
    }

    private void sort(String value, String order) {
        headerUI().stream().filter(element -> element.text().contains(value)).forEach(element -> {
            while (!element.attr("aria-sort").equalsIgnoreCase(order)) {
                element.click();
            }
        });
    }

    @JDIAction("Get {name} first column required element")
    public String firstColumnElement(String data) {
        return this.getColumn(1).get(data).text();
    }

    @JDIAction("Get {name} second column required element")
    public String secondColumnElement(String data) {
        return this.getColumn(2).get(data).text();
    }

    @JDIAction("Get required element from required {name} column")
    public String columnElement(int colNum, int elNum) {
        return getColumn(colNum).get(elNum).text();
    }

    @JDIAction("Search required element in {name}")
    public void search(String tableTestData) {
        clear();
        input().sendKeys(tableTestData.toUpperCase());
    }

    @JDIAction("Clear {name} input field")
    public void clear() {
        UIElement clearingButton = find("[aria-label='clear icon']");
        if (clearingButton.isExist()) {
            clearingButton.click();
        } else {
            do {
                input().sendKeys(Keys.BACK_SPACE);
            } while (!input().isEmpty());
        }
    }

    @JDIAction("Show required rows value in {name}")
    public void rowsPerPage(String value) {
        Map<String, Integer> pairs = new HashMap<>();
        pairs.put("5", 1);
        pairs.put("10", 2);
        pairs.put("15", 3);
        pairs.put("All", 4);
        Timer.waitCondition(() -> find(".mdi-menu-down").isVisible());
        find(".mdi-menu-down").click();
        Timer.waitCondition(() -> find(".menuable__content__active ").isVisible());
        menuContent().select(pairs.get(value));
        Timer.waitCondition(() -> value.equals(find(".v-select__selections").getText()));
    }

    @JDIAction("Show required items value in {name}")
    public void itemsPerPage(String value) {
        UIElement input = find("input");
        while (input.isNotEmpty()) {
            input.sendKeys(Keys.BACK_SPACE);
        }
        input.sendKeys(value);
    }

    @JDIAction("Get {name} column size")
    public Integer elementsInColumn(int colNum) {
        return getColumn(colNum).size();
    }

    @JDIAction("Switch {name} to the previous page")
    public void previousPage() {
        UIElement prevButton = find(".mdi-chevron-left");
        if (!prevButton.isDisabled()) {
            prevButton.click();
        }
    }

    @JDIAction("Switch {name} to the first page")
    public void firstPage() {
        find("button[aria-label='Goto Page 1']").click();
    }

    @JDIAction("Switch {name} to the second page")
    public void secondPage() {
        find("button[aria-label='Goto Page 2']").click();
    }

    @JDIAction("Switch {name} to the next page")
    public void nextPage() {
        UIElement nextButton = find(".mdi-chevron-right");
        if (!nextButton.isDisabled()) {
            nextButton.click();
        }
    }

    @JDIAction("Sort {name} by value in ascending order")
    public void sortAscBy(String value) {
        sort(value, "ascending");
    }

    @JDIAction("Sort {name} by value in descending order")
    public void sortDescBy(String value) {
        sort(value, "descending");
    }

    @JDIAction("Turn off {name} sort")
    public void sortOff(String value) {
        sort(value, "none");
    }

    @JDIAction("Check that {name} sorted by value")
    public boolean isSortedBy(String value) {
        for (UIElement element : headerUI()) {
            if (element.text().contains(value)) {
                if (element.attr("aria-sort").equalsIgnoreCase("descending") ||
                        element.attr("aria-sort").equalsIgnoreCase("ascending")) {
                    return true;
                }
            }
        }
        return false;
    }


    @JDIAction("Collapse required {name} group ")
    public void collapseGroup(String category) {
        WebList buttons = groups().get(category).finds("button[type='button']");
        boolean collapsed = buttons.get(1).find("i").attr("class").contains("plus");
        if (!collapsed) {
            buttons.select(1);
        }
    }

    @JDIAction("Expand required {name} group")
    public void expandGroup(String category) {
        WebList buttons = groups().get(category).finds("button[type='button']");
        boolean collapsed = buttons.get(1).find("i").attr("class").contains("plus");
        if (collapsed) {
            buttons.select(1);
        }
    }

    @JDIAction("Sort {name} by group")
    public void sortGroup(String type) {
        switch (type.toLowerCase()) {
            case ("diary"):
                while (!headerUI().get(2).attr("aria-label").contains("Dairy")) {
                    find("//span[contains(text(), 'group')]").click();
                }
                break;
            case ("category"):
                while (!headerUI().get(2).attr("aria-label").contains("Category")) {
                    find("//span[contains(text(), 'group')]").click();
                }
                break;
            default:
                System.out.println("Required category not found or not exist");
                break;
        }
    }

    @JDIAction("Remove {name} groups")
    public void removeGroups() {
        WebList buttons = groups().get(1).finds("button[type='button']");
        buttons.select(2);
    }

    @JDIAction("Group {name}")
    public void group() {
        UIElement group = find("//span[contains(text(), 'group')]");
        group.click();
    }

    @JDIAction("Show that {name} has required group")
    public boolean hasGroup(String groupName) {
        return groups().get(groupName).isExist();
    }

    @JDIAction("Check that {name} is loading")
    public boolean isLoading() {
        return find("div[role='progressbar']").isExist();
    }

    @JDIAction("Check that required element in required {name} column is selected")
    public boolean isSelected(int colNum, int elNum) {
        if (getColumn(colNum).get(elNum).find("i").isExist()) {
            return getColumn(colNum).get(elNum).find("i").attr("class").contains("-marked");
        } else {
            return false;
        }
    }

    @JDIAction("Turn on {name} single select")
    public void singleSelectOn() {
        if (singleSelect().find("input").attr("aria-checked").equalsIgnoreCase("false")) {
            singleSelect().select();
        }
    }

    @JDIAction("Turn off {name} single select")
    public void singleSelectOff() {
        if (singleSelect().find("input").attr("aria-checked").equalsIgnoreCase("true")) {
            singleSelect().click();
        }
    }

    @Override
    @JDIAction("Get list of {name} headers")
    public List<String> header() {
        WebList header = finds("//thead/tr");
        List<String> headerName = new LinkedList<>();
        header.forEach(element -> headerName.add(element.text()));
        return headerName;
    }

    @JDIAction("Check that required element in required {name} column is green")
    public boolean elIsGreen(int colNum, int elNum) {
        if (getColumn(colNum).get(elNum).find(".v-chip").isExist()) {
            return getColumn(colNum).get(elNum).find(".v-chip").attr("class").contains("green");
        } else {
            return false;
        }
    }

    @JDIAction("Check that required element in required {name} column is orange")
    public boolean elIsOrange(int colNum, int elNum) {
        if (getColumn(colNum).get(elNum).find(".v-chip").isExist()) {
            return getColumn(colNum).get(elNum).find(".v-chip").attr("class").contains("orange");
        } else {
            return false;
        }
    }

    @JDIAction("Check that required element in required {name} column is red")
    public boolean elIsRed(int colNum, int elNum) {
        if (getColumn(colNum).get(elNum).find(".v-chip").isExist()) {
            return getColumn(colNum).get(elNum).find(".v-chip").attr("class").contains("red");
        } else {
            return false;
        }
    }

    private void create(String name, String cal, String fat, String carbs, String prot) {
        newItemCard().get(1).find("input").sendKeys(Keys.BACK_SPACE);
        newItemCard().get(1).find("input").sendKeys(name);
        newItemCard().get(2).find("input").sendKeys(Keys.BACK_SPACE);
        newItemCard().get(2).find("input").sendKeys(cal);
        newItemCard().get(3).find("input").sendKeys(Keys.BACK_SPACE);
        newItemCard().get(3).find("input").sendKeys(fat);
        newItemCard().get(4).find("input").sendKeys(Keys.BACK_SPACE);
        newItemCard().get(4).find("input").sendKeys(carbs);
        newItemCard().get(5).find("input").sendKeys(Keys.BACK_SPACE);
        newItemCard().get(5).find("input").sendKeys(prot);
    }

    @JDIAction("Create new {name} element and save it")
    public void createWithSave(String name, String cal, String fat, String carbs, String prot) {
        UIElement newItem = find("//span[contains(text(), 'New Item')]");
        UIElement save = $("//div[@role='document']//span[contains(text(), 'Save')]");
        newItem.click();
        create(name, cal, fat, carbs, prot);
        save.click();
    }

    @JDIAction("Create new {name} element, but cancel it")
    public void createWithoutSave(String name, String cal, String fat, String carbs, String prot) {
        UIElement newItem = find("//span[contains(text(), 'New Item')]");
        UIElement cancel = $("//div[@role='document']//span[contains(text(), 'Cancel')]");
        newItem.click();
        create(name, cal, fat, carbs, prot);
        cancel.click();
    }

    @JDIAction("Change required {name} element name")
    public void editElement(int elNum, String newEl) {
        UIElement input = $(TABLE_INPUT_PATH);
        getColumn(1).select(elNum);
        while (input.isNotEmpty()) {
            input.sendKeys(Keys.BACK_SPACE);
        }
        input.sendKeys(newEl);
    }

    @JDIAction("Confirm changes in {name}")
    public void confirm() {
        UIElement input = $(TABLE_INPUT_PATH);
        input.sendKeys(Keys.ENTER);
    }

    @JDIAction("Cancel changes in {name}")
    public void cancel() {
        UIElement input = $(TABLE_INPUT_PATH);
        input.sendKeys(Keys.ESCAPE);
    }

    @JDIAction("Expand required {name} element")
    public void expand(int numEl) {
        if (!isExpanded(numEl)) {
            getColumn(7).get(numEl).find("button").click();
        }
    }

    @JDIAction("Check that required {name} element is expanded")
    public boolean isExpanded(int numEl) {
        return getColumn(7).get(numEl).find("button").attr("class").contains("active");
    }

    @JDIAction("Sort {name}  with button by value in ascending order")
    public void sortWithButtonAsc(int elNum) {
        headerUI().select(elNum);
        while (headerUI().get(elNum).attr("aria-sort").equalsIgnoreCase("ascending")) {
            find("//span[contains(text(), 'Toggle sort order')]").click();
        }
    }

    @JDIAction("Sort {name}  with button by value in descending order")
    public void sortWithButtonDesc(int elNum) {
        headerUI().select(elNum);
        while (headerUI().get(elNum).attr("aria-sort").equalsIgnoreCase("descending")) {
            find("//span[contains(text(), 'Toggle sort order')]").click();
        }
    }

    @JDIAction("Sort next {name} column")
    public void sortNextColumn() {
        find("//span[contains(text(), 'Sort next column')]").click();
    }

    @JDIAction("Select required {name} option")
    public void selectOption(int numOpt) {
        WebList menu = $$("//div[@role='listbox']/child::div[@role='option']");
        menu.get(numOpt).click();
    }

    @Override
    public DataTableAssert is() {
        DataTableAssert dataTableAssert = new DataTableAssert();
        dataTableAssert.set(this);
        return dataTableAssert;
    }

    @Override
    public DataTableAssert has() {
        return is();
    }

    @Override
    public DataTableAssert assertThat() {
        return is();
    }
}

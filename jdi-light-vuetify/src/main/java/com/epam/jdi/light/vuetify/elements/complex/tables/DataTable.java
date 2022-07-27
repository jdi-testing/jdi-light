package com.epam.jdi.light.vuetify.elements.complex.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.tables.DataTableAssert;
import org.openqa.selenium.Keys;

import java.util.LinkedList;
import java.util.List;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.jdiai.tools.Timer.waitCondition;

/**
 * To see an example of Data Table web element please visit https://vuetifyjs.com/en/components/data-tables/
 **/
public class DataTable extends SimpleTable {

    protected WebList menuContent() {
        return $$("[class*='active'] [role='listbox'] [role='option']");
    }

    public WebList groups() {
        return finds(".v-row-group__header");
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

    @JDIAction("Show required rows value in {name}")
    public void rowsPerPage(String value) {
        if (!menuContent().isDisplayed()) {
            find(".v-input__icon").click();
        }
        waitCondition(() -> !menuContent().isDisplayed());
        menuContent().select(value);
    }

    @JDIAction("Get {name} column size")
    public Integer elementsInColumn(int colNum) {
        return getColumn(colNum).size();
    }

    @JDIAction("Switch {name} to the previous page")
    public void previousPage() {
        UIElement prevButton = find(".v-data-footer__icons-before");
        if (!prevButton.isDisabled()) {
            prevButton.click();
        }
    }

    @JDIAction("Switch {name} to the next page")
    public void nextPage() {
        UIElement nextButton = find(".v-data-footer__icons-after");
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

    @Override
    @JDIAction("Get list of {name} headers")
    public List<String> header() {
        WebList header = finds("//thead/tr");
        List<String> headerName = new LinkedList<>();
        header.forEach(element -> headerName.add(element.text()));
        return headerName;
    }

    @JDIAction("Change required {name} element name")
    public void editElement(int elNum, String newEl) {
        UIElement input = $(".menuable__content__active input[type='text']");
        getColumn(1).select(elNum);
        while (input.isNotEmpty()) {
            input.sendKeys(Keys.BACK_SPACE);
        }
        input.sendKeys(newEl);
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

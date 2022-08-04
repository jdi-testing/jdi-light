package com.epam.jdi.light.vuetify.elements.complex.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.tables.DataTableAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

import static com.epam.jdi.light.settings.WebSettings.logger;
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
    public void collapseGroup(String groupName) {
        UIElement button = groups().get(groupName).find("button");
        if (groupIsExpanded(groupName)) {
            button.click();
        }
    }

    public boolean groupIsExpanded(String groupName) {
        // if next row is group header then group is not expanded
        List<WebElement> list = finds("tr").webElements();
        if (list.stream().filter(element -> element.getText().contains(groupName)).count() != 1) {
            logger.error("Non or more than one group with that groupName");
            throw new IllegalStateException("Non or more than one group with that groupName");
        }
        int index = 0;
        for (; index < list.size(); index++){
            if (list.get(index).getText().contains(groupName)) {break;}
        }
        return !list.get(index + 1).getAttribute("class").contains("v-row-group__header");
    }

    @JDIAction("Expand required {name} group")
    public void expandGroup(String groupName) {
        UIElement button = groups().get(groupName).find("button");
        if (!groupIsExpanded(groupName)) {
            button.click();
        }
    }

    @JDIAction("Group {name} by column {0}")
    public void group(String colName) {

        String type = colName.toLowerCase();
        if (groups().size() == 0) {
            WebElement groupHeader;
            for (WebElement headerElement : headerUI()) {
                if ((groupHeader = headerElement).findElement(By.cssSelector("span:first-child")).getText().toLowerCase().equals(type)) {
                    groupHeader.findElement(By.cssSelector("span:last-child")).click();
                    return;
                }
            }
            logger.error("Required category not found or not exist");
        } else {
            UIElement groupName = groups().get(1);
            UIElement groupBtn = headerUI().get(headerUI().size()).find("span:last-child");
            String initialSorting = groupName.getText().toLowerCase();

            while (!groupName.getText().split(":")[0].toLowerCase().equals(type)) {
                groupBtn.click();
                if (groupName.getText().toLowerCase().equals(initialSorting)) {
                    logger.error("Required sorting category not found or not exist");
                    break;
                }
            }
        }
    }

    @JDIAction("Remove {name} groups")
    public void removeGroups() {
        groups().finds("button[type='button']").select(2);
    }

    @JDIAction("Show that {name} has required group {0}")
    public boolean hasGroup(String groupName) {
        return (groups().webElements().stream().anyMatch(element -> element.getText().toLowerCase().contains(
                groupName.toLowerCase())));
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
    public void expandRow(int numEl) {
        if (!rowIsExpanded(numEl)) {
            getExpandButton(numEl).click();
        }
    }

    @JDIAction("Check that required {name} element is expanded")
    public boolean rowIsExpanded(int numEl) {
        return getExpandButton(numEl).attr("class").contains("active");
    }

    protected UIElement getExpandButton(int numEl) {
        return finds(".v-data-table__expand-icon").get(numEl);
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

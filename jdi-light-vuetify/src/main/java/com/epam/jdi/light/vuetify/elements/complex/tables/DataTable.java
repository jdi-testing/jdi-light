package com.epam.jdi.light.vuetify.elements.complex.tables;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.vuetify.elements.complex.tables.DataTable.SortOrder.ASCENDING;
import static com.epam.jdi.light.vuetify.elements.complex.tables.DataTable.SortOrder.DESCENDING;
import static com.epam.jdi.light.vuetify.elements.complex.tables.DataTable.SortOrder.NONE;
import static com.jdiai.tools.Timer.waitCondition;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.tables.DataTableAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * To see an example of Data Table web element please visit https://vuetifyjs.com/en/components/data-tables/
 **/
public class DataTable
    extends SimpleTable<DataTable, DataTableAssert>
    implements HasTheme {

    private static final String TABLE_ROOT_LOCATOR = "./div[contains(@class, 'v-data-table')]";
    private static final String GROUP_HEADER_LOCATOR = ".v-row-group__header";
    private static final String MENU_LOCATOR = "[class*='active'] [role='listbox'] [role='option']";

    private static final String FOOTER_LOCATOR = "//div[contains(@class, 'v-data-footer')]";
    private static final String FOOTER_FIRST_PAGE_LOCATOR = "// button[contains(@aria-label, 'First page')]";
    private static final String FOOTER_PREVIOUS_PAGE_LOCATOR = "// button[contains(@aria-label, 'Previous page')]";
    private static final String FOOTER_NEXT_PAGE_LOCATOR = "// button[contains(@aria-label, 'Next page')]";
    private static final String FOOTER_LAST_PAGE_LOCATOR = "// button[contains(@aria-label, 'Last page')]";

    private static final String EXPAND_BUTTON_LOCATOR = ".v-data-table__expand-icon";
    private static final String PROGRESS_BAR_LOCATOR = "div[role='progressbar']";
    private static final String SELECT_ROWS_PER_PAGE_LOCATOR = ".v-input__icon i ";
    private static final String NUMBER_OF_ROWS_PER_PAGE_DROP_DOWN_LOCATOR = "// div[contains(@class, 'menuable__content__active')]";
    private static final String NUMBER_OF_ROWS_BUTTON_LOCATOR_TEMPLATE = "// div[contains(@class, 'v-list-item__title') and contains(text(), '%s')]";
    private static final String GROUP_BUTTON_SELECTOR = "button[type='button']";
    private static final String HEADERS_LOCATOR = "//thead / tr";

    protected WebList menuContent() {
        return $$(MENU_LOCATOR);
    }

    public WebList groups() {
        return finds(GROUP_HEADER_LOCATOR);
    }

    private void sort(String value, String order) {
        headerUI().stream()
                  .filter(element -> element.text().contains(value))
                  .findFirst()
                  .ifPresent(
                      element -> {
                          while (!element.attr("aria-sort").equalsIgnoreCase(order)) {
                              element.click();
                          }
                      }
                  );
    }

    private void clickIfEnabled(String locator) {
        UIElement button = find(locator);
        if (!button.isDisabled()) {
            button.click();
        }
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
            find(SELECT_ROWS_PER_PAGE_LOCATOR).click();
        }
        waitCondition(() -> !menuContent().isDisplayed());
        menuContent().select(value);
    }

    @JDIAction("Switch {name} to the previous page")
    public void previousPage() {
        clickIfEnabled(FOOTER_PREVIOUS_PAGE_LOCATOR);
    }

    @JDIAction("Switch {name} to the next page")
    public void nextPage() {
        clickIfEnabled(FOOTER_NEXT_PAGE_LOCATOR);
    }

    @JDIAction("Switch {name} to the first page")
    public void firstPage() {
        clickIfEnabled(FOOTER_FIRST_PAGE_LOCATOR);
    }

    @JDIAction("Switch {name} to the last page")
    public void lastPage() {
        clickIfEnabled(FOOTER_LAST_PAGE_LOCATOR);
    }

    @JDIAction("Get {name} to the last page")
    public int currentPage() {
        return Integer.parseInt(find(FOOTER_LOCATOR).find("./span").text());
    }

    @JDIAction("Sort {name} by value in ascending order")
    public void sortAscBy(String value) {
        sort(value, ASCENDING.order);
    }

    @JDIAction("Sort {name} by value in descending order")
    public void sortDescBy(String value) {
        sort(value, DESCENDING.order);
    }

    @JDIAction("Turn off {name} sort")
    public void sortOff(String value) {
        sort(value, NONE.order);
    }

    @JDIAction("Check that {name} sorted by value")
    public boolean isSortedBy(String value) {
        return headerUI().stream()
                         .filter(e -> e.text().contains(value))
                         .map(e -> e.attr("aria-sort"))
                         .anyMatch(order -> StringUtils.equalsAnyIgnoreCase(order, ASCENDING.order, DESCENDING.order));
    }


    @JDIAction("Collapse required {name} group ")
    public void collapseGroup(String groupName) {
        UIElement button = groups().get(groupName).find("button");
        if (groupIsExpanded(groupName)) {
            button.click();
        }
    }

    /**
     * Check if the next row is group header then the group is not expanded
     * @param groupName
     */
    public boolean groupIsExpanded(String groupName) {
        List<WebElement> list = finds("tr").webElements();
        if (list.stream().filter(element -> element.getText().contains(groupName)).count() != 1) {
            logger.error("Non or more than one group with that groupName");
            throw new IllegalStateException("Non or more than one group with that groupName");
        }
        int index = 0;
        for (; index < list.size(); index++) {
            if (list.get(index).getText().contains(groupName)) {
                break;
            }
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
        WebList groups = groups();
        WebList headerUI = headerUI();
        if (groups.size() == 0) {
            for (UIElement headerElement : headerUI) {
                if (headerElement.find("span:first-child").getText().equalsIgnoreCase(colName)) {
                    headerElement.find("span:last-child").click();
                    return;
                }
            }
            logger.error("Required category not found or not exist");
        } else {
            UIElement groupName = groups.get(1);
            UIElement groupBtn = headerUI.get(headerUI.size()).find("span:last-child");
            String initialSorting = groupName.getText();

            while (!groupName.getText().split(":")[0].equalsIgnoreCase(colName)) {
                groupBtn.click();
                if (groupName.getText().equalsIgnoreCase(initialSorting)) {
                    logger.error("Required sorting category not found or not exist");
                    break;
                }
            }
        }
    }

    @JDIAction("Remove {name} groups")
    public void removeGroups() {
        groups().finds(GROUP_BUTTON_SELECTOR).select(2);
    }

    @JDIAction("Show that {name} has required group {0}")
    public boolean hasGroup(String groupName) {
        return groups().webElements()
                       .stream()
                       .map(WebElement::getText)
                       .anyMatch(text -> StringUtils.containsIgnoreCase(text, groupName));
    }

    @JDIAction("Check that {name} is loading")
    public boolean isLoading() {
        return find(PROGRESS_BAR_LOCATOR).isExist();
    }

    @JDIAction("Check that required element in required {name} column is selected")
    public boolean isSelected(int colNum, int elNum) {
        UIElement element = getColumn(colNum).get(elNum).find("i");
        if (element.isExist()) {
            return element.attr("class").contains("-marked");
        } else {
            return false;
        }
    }

    @Override
    @JDIAction("Get list of {name} headers")
    public List<String> header() {
        return finds(HEADERS_LOCATOR).stream()
                                  .map(UIElement::getText)
                                  .collect(Collectors.toList());
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

    @JDIAction("Collapse {name} element")
    public void collapseRow(int rowNumber) {
        if (rowIsExpanded(rowNumber)) {
            getExpandButton(rowNumber).click();
        }
    }

    @JDIAction("Select {name} number of tows per page")
    public void selectNumberOfRowsPerPage(String value) {
        getNumberOfRowsPerPageInput().click();
        $(NUMBER_OF_ROWS_PER_PAGE_DROP_DOWN_LOCATOR)
            .find(String.format(NUMBER_OF_ROWS_BUTTON_LOCATOR_TEMPLATE, value))
            .click();
    }

    protected UIElement getExpandButton(int numEl) {
        return finds(EXPAND_BUTTON_LOCATOR).get(numEl);
    }

    public UIElement footer() {
        return find(FOOTER_LOCATOR);
    }

    public UIElement getFirstPageButton() {
        return find(FOOTER_FIRST_PAGE_LOCATOR);
    }

    public UIElement getPreviousPageButton() {
        return find(FOOTER_PREVIOUS_PAGE_LOCATOR);
    }

    public UIElement getNextPageButton() {
        return find(FOOTER_NEXT_PAGE_LOCATOR);
    }

    public UIElement getLastPageButton() {
        return find(FOOTER_LAST_PAGE_LOCATOR);
    }

    public UIElement getNumberOfRowsPerPageInput() {
        return find(SELECT_ROWS_PER_PAGE_LOCATOR);
    }

    public List<String> getRowValues(int rowNumber) {
        return getRow(rowNumber).values();
    }

    @Override
    public String theme() {
        return find(TABLE_ROOT_LOCATOR).classLike("theme--");
    }

    @Override
    public DataTableAssert is() {
        return new DataTableAssert().set(this);
    }

    @Override
    public DataTableAssert has() {
        return is();
    }

    @Override
    public DataTableAssert assertThat() {
        return is();
    }

    public enum SortOrder {

        ASCENDING("ascending"),
        DESCENDING("descending"),
        NONE("none");

        private final String order;

        SortOrder(String order) {
            this.order = order;
        }

    }
}

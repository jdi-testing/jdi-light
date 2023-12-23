package com.epam.jdi.light.vuetify.elements.complex.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.tables.DataTableAssert;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.enums.SortOrder;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.vuetify.enums.SortOrder.ASCENDING;
import static com.epam.jdi.light.vuetify.enums.SortOrder.DESCENDING;
import static com.epam.jdi.light.vuetify.enums.SortOrder.NONE;

/**
 * To see an example of Data Table web element please visit https://vuetifyjs.com/en/components/data-tables/
 **/
public class DataTable
    extends SimpleTable<DataTable, DataTableAssert>
    implements HasTheme, IsLoading, HasMeasurement {

    private static final String FOOTER_LOCATOR = ".//div[contains(@class, 'v-data-footer')]";
    private static final String FOOTER_FIRST_PAGE_LOCATOR = ".//button[@aria-label='First page']";
    private static final String FOOTER_PREVIOUS_PAGE_LOCATOR = ".//button[@aria-label='Previous page']";
    private static final String FOOTER_NEXT_PAGE_LOCATOR = ".//button[@aria-label='Next page']";
    private static final String FOOTER_LAST_PAGE_LOCATOR = ".//button[@aria-label='Last page']";

    private static final String EXPAND_BUTTON_LOCATOR = ".v-data-table__expand-icon";

    private static final String PROGRESS_BAR_LOCATOR = "div[role='progressbar']";

    private static final String SELECT_ROWS_PER_PAGE_LOCATOR = ".v-input__icon i ";
    private static final String NUMBER_OF_ROWS_PER_PAGE_DROP_DOWN_LOCATOR = ".//div[contains(@class, 'menuable__content__active')]";
    private static final String NUMBER_OF_ROWS_BUTTON_LOCATOR_TEMPLATE = ".//div[contains(@class, 'v-list-item__title') and contains(text(), '%s')]";

    private static final String ROW_GROUPING_LOCATOR = ".v-row-group__header";
    private static final String GROUP_EXPAND_BUTTON_SELECTOR = "i.mdi-minus";
    private static final String GROUP_COLLAPSE_BUTTON_SELECTOR = "i.mdi-plus";
    private static final String GROUP_CLOSE_BUTTON_SELECTOR = "i.mdi-close";
    private static final String SEARCH_LOCATOR = "./div[contains(@class, 'v-text-field--is-booted')]";

    private String sortAttribute = "aria-sort";

    public WebList groups() {
        return core().finds(ROW_GROUPING_LOCATOR);
    }

    @Override
    public void setup(Field field) {
        this.headerLocator = By.xpath(".//thead//th");
        super.setup(field);
    }

    @JDIAction("Get {name} groups list with the list of content of the first column")
    public Map<String, List<String>> groupedData() {
        Map<String, List<String>> groups = new HashMap<>();
        String currentGroup = null;

        for (WebElement element : core().finds("tr").webElements()) {
            if (element.getAttribute("class").contains("v-row-group__header")) {
                currentGroup = element.getText();
            } else {
                groups.computeIfAbsent(currentGroup, key -> new ArrayList<>()).add(element.getText());
            }
        }

        return groups;
    }

    private Optional<UIElement> getSortButton(String value) {
        return headerUI().stream()
                         .filter(element -> element.find("./span").text().equalsIgnoreCase(value))
                         .findFirst();
    }

    private void sort(String value, SortOrder order) {
        Optional<UIElement> sortButton = getSortButton(value);
        if (sortButton.isPresent()) {
            UIElement element = sortButton.get();
            if (element.hasAttribute(sortAttribute)) {
                while (!element.attr(sortAttribute).equalsIgnoreCase(order.name())) {
                    element.click();
                }
            } else {
                throw new IllegalStateException(String.format("Sorting by %s is disabled", value));
            }
        } else {
            throw new IllegalStateException(String.format("Cannot sort by %s", value));
        }
    }

    private void clickIfEnabled(String locator) {
        UIElement button = core().find(locator);
        if (button.isEnabled()) {
            button.click();
        }
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

    @JDIAction("Get {name} page number")
    public int currentPage() {
        return Integer.parseInt(core().find(FOOTER_LOCATOR).find("./span").text());
    }

    @JDIAction("Sort {name} by value in ascending order")
    public void sortAscBy(String value) {
        sort(value, ASCENDING);
    }

    @JDIAction("Sort {name} by value in descending order")
    public void sortDescBy(String value) {
        sort(value, DESCENDING);
    }

    @JDIAction("Turn off {name} sort")
    public void removeSort(String value) {
        sort(value, NONE);
    }

    @JDIAction("Get if {name} sorted by value")
    public boolean isSortedBy(String value) {
        return headerUI().stream()
                         .filter(e -> e.text().contains(value))
                         .map(e -> e.attr(sortAttribute))
                         .anyMatch(order -> StringUtils.equalsAnyIgnoreCase(order, ASCENDING.name(), DESCENDING.name()));
    }


    @JDIAction("Collapse {name} group ")
    public void collapseGroup(String groupName) {
        if (isGroupExpanded(groupName)) {
            groups().get(groupName).find(GROUP_EXPAND_BUTTON_SELECTOR).click();
        }
    }

    /**
     * Check if the next row is group header then the group is not expanded
     *
     * @param groupName Group title
     *
     * @return true if expanded, false if not. Exception if there is no such group
     */
    @JDIAction("Get if group {0} is expanded in {name}")
    public boolean isGroupExpanded(String groupName) {
        UIElement groupElement = groups().get(groupName);
        if (groupElement == null || groupElement.isNotDisplayed()) {
            throw new IllegalStateException(String.format("There is no group with name '%s'", groupName));
        }

        return groupElement.find(GROUP_COLLAPSE_BUTTON_SELECTOR).isDisplayed();
    }

    @JDIAction("Expand {name} group")
    public void expandGroup(String groupName) {
        if (!isGroupExpanded(groupName)) {
            UIElement button = groups().get(groupName).find(GROUP_EXPAND_BUTTON_SELECTOR);
            button.click();
        }
    }

    @JDIAction("Group {name} by column {0}")
    public void groupBy(String colName) {
        WebList groups = groups();
        WebList headerUI = headerUI();

        for (UIElement headerElement : headerUI) {
            if (headerElement.find(String.format("./span[text()='%s']", colName)).isExist()) {
                headerElement.find("./span[text()='group']").click();
                return;
            }
        }

        //check if it is already grouped by
        if (groups.isEmpty()) {
            throw runtimeException(String.format("Grouping by column '%s' is not available", colName));
        }
        UIElement groupName = groups.get(1);
        if (!groupName.text().startsWith(colName + ": ")) {
            throw runtimeException(String.format("Grouping by column '%s' is not available", colName));
        }
    }

    @JDIAction("Remove {name} grouping")
    public void removeGroups() {
        core().find(GROUP_CLOSE_BUTTON_SELECTOR).click();
    }

    @JDIAction("Show that {name} has group {0}")
    public boolean hasGroup(String groupName) {
        return groups().get(groupName).isDisplayed();
    }

    @JDIAction("Get if {name} is loading")
    public boolean isLoading() {
        return core().find(PROGRESS_BAR_LOCATOR).isVisible();
    }

    @JDIAction("Get if required element in required {name} column is selected")
    public boolean isSelected(int colNum, int elNum) {
        UIElement element = getColumn(colNum).get(elNum).find("i");
        if (element.isExist()) {
            return element.attr("class").contains("-marked");
        } else {
            return false;
        }
    }

    @JDIAction("Expand row {name} element")
    public void expandRow(int numEl) {
        if (!isRowExpanded(numEl)) {
            expandButton(numEl).click();
        }
    }

    @JDIAction("Get if required {name} element is expanded")
    public boolean isRowExpanded(int numEl) {
        return expandButton(numEl).attr("class").contains("active");
    }

    @JDIAction("Collapse {name} element")
    public void collapseRow(int rowNumber) {
        if (isRowExpanded(rowNumber)) {
            expandButton(rowNumber).click();
        }
    }

    @JDIAction("Select {name} number of rows per page")
    public void selectNumberOfRowsPerPage(String value) {
        getNumberOfRowsPerPageInput().click();
        $(NUMBER_OF_ROWS_PER_PAGE_DROP_DOWN_LOCATOR)
            .find(String.format(NUMBER_OF_ROWS_BUTTON_LOCATOR_TEMPLATE, value))
            .click();
    }

    protected UIElement expandButton(int numEl) {
        return core().finds(EXPAND_BUTTON_LOCATOR).get(numEl);
    }

    public UIElement footer() {
        return core().find(FOOTER_LOCATOR);
    }

    public UIElement firstPageButton() {
        return core().find(FOOTER_FIRST_PAGE_LOCATOR);
    }

    public UIElement previousPageButton() {
        return core().find(FOOTER_PREVIOUS_PAGE_LOCATOR);
    }

    public UIElement nextPageButton() {
        return core().find(FOOTER_NEXT_PAGE_LOCATOR);
    }

    public UIElement lastPageButton() {
        return core().find(FOOTER_LAST_PAGE_LOCATOR);
    }

    public UIElement getNumberOfRowsPerPageInput() {
        return core().find(SELECT_ROWS_PER_PAGE_LOCATOR);
    }

    public List<String> getRowValues(int rowNumber) {
        return getRow(rowNumber).values();
    }

    public Input searchInput() {
        return new Input().setCore(Input.class, core().find(SEARCH_LOCATOR));
    }

    public boolean isSortEnabled(String column) {
        return getSortButton(column)
            .filter(uiElement -> uiElement.hasAttribute(sortAttribute))
            .isPresent();
    }

    public boolean isSortRequired() {
        return headerUI()
                .stream()
                .anyMatch(uiElement -> !uiElement.attr(sortAttribute).equalsIgnoreCase(NONE.name()));
    }

    @Override
    public String theme() {
        return core().classLike("theme--");
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

    public boolean isFixedHeader() {
        return core().hasClass("v-data-table--fixed-header");
    }
}

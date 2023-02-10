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
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.vuetify.enums.SortOrder.ASCENDING;
import static com.epam.jdi.light.vuetify.enums.SortOrder.DESCENDING;
import static com.epam.jdi.light.vuetify.enums.SortOrder.NONE;
import static com.jdiai.tools.Timer.waitCondition;

/**
 * To see an example of Data Table web element please visit https://vuetifyjs.com/en/components/data-tables/
 **/
public class DataTable
    extends SimpleTable<DataTable, DataTableAssert>
    implements HasTheme, IsLoading, HasMeasurement {
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
    private static final String HEADERS_LOCATOR = "//thead/tr";
    private static final String SEARCH_LOCATOR = "./div[contains(@class, 'v-text-field--is-booted')]";

    private String sortAttribute = "aria-sort";


    protected WebList menuContent() {
        return $$(MENU_LOCATOR);
    }

    public WebList groups() {
        return finds(GROUP_HEADER_LOCATOR);
    }

    public Map<String, List<String>> groupElements() {
        Map<String, List<String>> groups = new HashMap<>();
        String currentGroup = null;

        for (WebElement element : finds("tr").webElements()) {
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
                         .filter(element -> element.text().contains(value))
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
        UIElement button = find(locator);
        if (!button.isDisabled()) {
            button.click();
        }
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

    @JDIAction("Get {name} page number")
    public int currentPage() {
        return Integer.parseInt(find(FOOTER_LOCATOR).find("./span").text());
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
        UIElement button = groups().get(groupName).find("button");
        if (isGroupExpanded(groupName)) {
            button.click();
        }
    }

    /**
     * Check if the next row is group header then the group is not expanded
     */
    @JDIAction("Get if group {0} is expanded in {name}")
    public boolean isGroupExpanded(String groupName) {
        List<WebElement> list = finds("tr").webElements();
        if (list.stream().filter(element -> element.getText().contains(groupName)).count() != 1) {
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

    @JDIAction("Expand {name} group")
    public void expandGroup(String groupName) {
        if (!isGroupExpanded(groupName)) {
            UIElement button = groups().get(groupName).find("button");
            button.click();
        }
    }

    @JDIAction("Group {name} by column {0}")
    public void groupBy(String colName) {
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

    @JDIAction("Remove {name} grouping")
    public void removeGroups() {
        groups().finds(GROUP_BUTTON_SELECTOR).select(2);
    }

    @JDIAction("Show that {name} has group {0}")
    public boolean hasGroup(String groupName) {
        return groups().webElements()
                       .stream()
                       .map(WebElement::getText)
                       .anyMatch(text -> StringUtils.containsIgnoreCase(text, groupName));
    }

    @JDIAction("Get if {name} is loading")
    public boolean isLoading() {
        return find(PROGRESS_BAR_LOCATOR).isVisible();
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

    @Override
    @JDIAction("Get list of {name} headers")
    public List<String> header() {
        return finds(HEADERS_LOCATOR).stream()
                                  .map(UIElement::getText)
                                  .collect(Collectors.toList());
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
        return finds(EXPAND_BUTTON_LOCATOR).get(numEl);
    }

    public UIElement footer() {
        return find(FOOTER_LOCATOR);
    }

    public UIElement firstPageButton() {
        return find(FOOTER_FIRST_PAGE_LOCATOR);
    }

    public UIElement previousPageButton() {
        return find(FOOTER_PREVIOUS_PAGE_LOCATOR);
    }

    public UIElement nextPageButton() {
        return find(FOOTER_NEXT_PAGE_LOCATOR);
    }

    public UIElement lastPageButton() {
        return find(FOOTER_LAST_PAGE_LOCATOR);
    }

    public UIElement getNumberOfRowsPerPageInput() {
        return find(SELECT_ROWS_PER_PAGE_LOCATOR);
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
        return hasClass("v-data-table--fixed-header");
    }
}

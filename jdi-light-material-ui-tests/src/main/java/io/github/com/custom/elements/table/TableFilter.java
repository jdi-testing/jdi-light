package io.github.com.custom.elements.table;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class TableFilter {
    /**
     * 'Column filter' field in filter configuration window.
     */
    @UI("#columns-filter-select")
    public UIElement columnFilter;

    /**
     * 'Operator filter' field in filter configuration window.
     */
    @UI("#columns-operators-select")
    public UIElement operatorFilter;

    /**
     * 'Value filter' field in filter configuration window.
     */
    @UI("//ancestor::body//input[@placeholder='Filter value']")
    public UIElement valueFilter;
}

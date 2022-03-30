package io.github.com.custom.elements.table;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.jdiai.tools.map.MapArray;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Table with inner tables in expanding rows
 */
public class CollapsingTable extends Table {

    /**
     * Row expansion buttons
     */
    @UI("button")
    private List<Button> buttons;

    /**
     * Multiplayer for getting every expanding row index
     * or getting row with inner table
     */
    private final int tableRowMultiplier = 2;

    /**
     * Rows initialization
     */
    protected MuiCacheAll<MapArray<String, WebList>> rows
            = new MuiCacheAll<>(MapArray::new);

    /**
     * Array of inner tables. Initialized in expandRow() method
     * @see CollapsingTable#expandRow(int) 
     */
    private InnerTable[] innerTables;

    @Override
    @JDIAction("Get '{name}' rows as array")
    protected MapArray<String, WebList> getRows() {
        if (rows.isGotAll()) {
            return rows.get();
        }
        MapArray<String, WebList> result = new MapArray<>();
        int count = count() + getStartIndex();
        for (int i = getStartIndex(); i < count; i += tableRowMultiplier) {
            result.add(i + "", webRow(i));
        }
        rows.gotAll();
        return rows.set(result);
    }

    /**
     * Get inner table in expanded row using index
     *
     * @param rowNum Number of expanded row with inner table
     * @return table in expanded row {@link InnerTable} instance from inner tables array
     * @throws RuntimeException if any row was not expanded or rowNum is incorrect
     */
    @JDIAction("Get inner table from '{name}' row '{0}'")
    public InnerTable innerTable(int rowNum) {
        return innerTables[rowNum - 1] == null ? null : innerTables[rowNum - 1];
    }

    /**
     * Expand row and fills innerTables array with created Inner Table
     *
     * @param rowNum Number of row for expand
     * @throws RuntimeException if element not found
     */
    @JDIAction("Expand '{name}' row '{0}'")
    public void expandRow(int rowNum) {
        if (innerTables == null) {
            innerTables = new InnerTable[rows().size()];
        }

        buttons.get(rowNum).click();
        By tableLocator = By.xpath(String.format("//tbody/tr[%d]//table", rowNum * tableRowMultiplier));
        InnerTable innerTable = new InnerTable().setCore(InnerTable.class, find(tableLocator));
        innerTables[rowNum - 1] = innerTable;
    }

    /**
     * Collapse row
     *
     * @param rowNum Number of row for collapse
     * @throws RuntimeException if element not found
     */
    @JDIAction("Collapse '{name}' row '{0}'")
    public void collapseRow(int rowNum) {
        buttons.get(rowNum).click();
    }
}

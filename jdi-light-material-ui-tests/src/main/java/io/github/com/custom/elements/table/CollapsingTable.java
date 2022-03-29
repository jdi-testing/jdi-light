package io.github.com.custom.elements.table;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.jdiai.tools.map.MapArray;
import org.openqa.selenium.By;

import java.util.List;

public class CollapsingTable extends Table {

    @UI("button")
    private List<Button> buttons;

    private final int tableRowMultiplayer = 2;

    protected MuiCacheAll<MapArray<String, WebList>> rows
            = new MuiCacheAll<>(MapArray::new);

    private InnerTable[] innerTables;

    @Override
    @JDIAction("Get '{name}' rows as array")
    protected MapArray<String, WebList> getRows() {
        if (rows.isGotAll()) {
            return rows.get();
        }
        MapArray<String, WebList> result = new MapArray<>();
        int count = count() + getStartIndex();
        for (int i = getStartIndex(); i < count; i += tableRowMultiplayer) {
            result.add(i + "", webRow(i));
        }
        rows.gotAll();
        return rows.set(result);
    }

    @JDIAction("Get inner table from '{name}' row '{0}'")
    public InnerTable innerTable(int rowNum) {
        return innerTables[rowNum - 1] == null ? null : innerTables[rowNum - 1];
    }

    @JDIAction("Expand '{name}' row '{0}'")
    public void expandRow(int rowNum) {
        if (innerTables == null) {
            innerTables = new InnerTable[rows().size()];
        }

        buttons.get(rowNum).click();
        By tableLocator = By.xpath(String.format("//tbody/tr[%d]//table", rowNum * tableRowMultiplayer));
        InnerTable innerTable = new InnerTable().setCore(InnerTable.class, find(tableLocator));
        innerTables[rowNum - 1] = innerTable;
    }

    @JDIAction("Collapse '{name}' row '{0}'")
    public void collapseRow(int rowNum) {
        buttons.get(rowNum).click();
    }
}

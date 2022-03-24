package io.github.com.custom.elements.complex.table;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.jdiai.tools.map.MapArray;
import org.openqa.selenium.By;

public class CollapsingTable extends Table {

    protected MuiCacheAll<MapArray<String, WebList>> rows
            = new MuiCacheAll<>(MapArray::new);

    private InnerTable[] innerTables;

    protected MapArray<String, WebList> getRows() {
        if (rows.isGotAll()) return rows.get();
        MapArray<String, WebList> result = new MapArray<>();
        int count = count() + getStartIndex();
        for (int i = getStartIndex(); i < count; i += 2)
            result.add(i + "", webRow(i));
        rows.gotAll();
        return rows.set(result);
    }

    @JDIAction("Get inner table from row '{0}'")
    public InnerTable innerTable(int rowNum) {
        return innerTables[rowNum - 1] == null ? null : innerTables[rowNum - 1];
    }

    @JDIAction("Expand row at index '{0}'")
    public void expandRow(int rowNum) {
        if (innerTables == null) {
            innerTables = new InnerTable[rows().size()];
        }

        core().finds(By.cssSelector("button")).get(rowNum).click();
        By tableLocator = By.xpath(String.format("//tbody/tr[%d]//table", rowNum * 2));
        InnerTable innerTable = new InnerTable().setCore(InnerTable.class, find(tableLocator));
        innerTables[rowNum - 1] = innerTable;
    }
}

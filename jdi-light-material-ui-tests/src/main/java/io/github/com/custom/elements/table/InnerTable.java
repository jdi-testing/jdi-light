package io.github.com.custom.elements.table;

import com.epam.jdi.light.elements.complex.table.Table;
import org.openqa.selenium.By;

/**
 * Inner table in {@link CollapsingTable} row.
 */
public class InnerTable extends Table {

    /**
     * Creates new {@link InnerTable} instance.
     */
    public InnerTable() {
        rowLocator = By.xpath("//tbody/tr[%s]/*");
        cellLocator = By.xpath("//tbody/tr[{1}]/*[{0}]");
        headerLocator = By.xpath("//thead//th");
    }
}

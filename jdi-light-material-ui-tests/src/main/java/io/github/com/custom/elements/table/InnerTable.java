package io.github.com.custom.elements.table;

import com.epam.jdi.light.asserts.generic.table.TableAssert;
import com.epam.jdi.light.elements.complex.table.BaseTable;
import com.epam.jdi.light.elements.complex.table.Table;
import org.openqa.selenium.By;

public class InnerTable extends BaseTable<Table, TableAssert> {

    public InnerTable() {
       rowLocator = By.xpath("//tbody/tr[%s]/*");
       cellLocator = By.xpath("//tbody/tr[{1}]/*[{0}]");
       headerLocator = By.xpath("//thead//th");
    }
}

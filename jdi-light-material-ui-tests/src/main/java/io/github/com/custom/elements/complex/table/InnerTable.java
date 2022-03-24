package io.github.com.custom.elements.complex.table;

import com.epam.jdi.light.elements.complex.table.BaseTable;
import io.github.com.custom.asserts.TableAssert;
import org.openqa.selenium.By;

public class InnerTable extends BaseTable<Table, TableAssert> {
    public InnerTable() {
       rowLocator = By.xpath("//tbody/tr[%s]/*");
       cellLocator = By.xpath("//tbody/tr[{1}]/*[{0}]");
       headerLocator = By.xpath("//thead//th");
    }
}

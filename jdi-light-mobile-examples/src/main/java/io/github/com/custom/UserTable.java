package io.github.com.custom;

import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.composite.Section;
import org.openqa.selenium.By;

public class UserTable<L extends Section, D> extends DataTable<L, D> {
    public UserTable() {
        super();
        rowLocator = By.xpath("//tr[%s]/td");
        columnLocator = By.xpath("//tr/td[%s]");
        cellLocator = By.xpath("//tr[{1}]/td[{0}]");
        allCellsLocator = By.cssSelector("td");
    }

}

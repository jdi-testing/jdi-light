package com.epam.jdi.light.elements.complex.table;

import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.fillByTemplate;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

public class Grid extends Table {
    public Grid() {
        firstColumnIndex = 1;
        firstRowIndex = 1;
    }
    @Override
    protected int getCount() {
        if (columns.get().any())
            return columns.get().get(0).value.size();
        List<WebElement> row = $$(fillByTemplate(columnLocator, getRowIndex()), this).getListFast();
        return row.size();
    }
    @Override
    protected int getColumnIndex(int index) {
        if (columnsMapping.length > 0)
            return columnsMapping[index-1];
        return index;
    }
    @Override
    protected int getRowIndex(int rowNum) {
        return rowNum;
    }
}

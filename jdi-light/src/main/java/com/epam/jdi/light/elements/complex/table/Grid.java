package com.epam.jdi.light.elements.complex.table;

import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.fillByTemplate;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

public class Grid extends Table {
    public Grid() {
        shiftColumnIndex = 1;
        shiftRowIndex = 1;
    }
    @Override
    protected int getCount() {
        if (columns.get().any())
            return columns.get().get(0).value.size();
        List<WebElement> row = $$(fillByTemplate(columnLocator, getRowHeaderIndex() + getShiftRowIndex()), this).getListFast();
        return row.size();
    }
    @Override
    protected int getColumnIndex(int index) {
        return columnsMapping.length > 0 ? columnsMapping[index-getStartIndex()] : index;
    }
    @Override
    protected int getRowIndex(int rowNum) {
        return rowNum;
    }
}

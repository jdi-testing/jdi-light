package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDITable;
import com.epam.jdi.light.material.elements.displaydata.Table;
import com.epam.jdi.light.material.elements.inputs.Button;

public class TableFrame extends Section {
    @JDITable
    public Table table;

    @UI(".MuiIconButton-label[2]")
    public Button next;

    @UI(".MuiSelect-root")
    public Button pages;

    @UI("//li[@data-value='10']")
    public Button page10;

    @UI(".MuiSvgIcon-root[2]")
    public Button column2Sorting;
}

package io.github.com.sections.tables;

import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;

public class PersonTable extends Section {
    @JTable(
            root = ".MuiDataGrid-main",
            cell = ".MuiDataGrid-main div[role='row'] div[tabindex]",
            headers = ".MuiDataGrid-colCellWrapper [tabindex='-1']",
            row = ".MuiDataGrid-main div[role='row']")
    public static Table table;
}

package io.github.com.pages.sections;

import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.NoCache;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;

public class TableSection extends Section {
    @UI("//a[contains(text(),'  Table')]")
    public static Link sectionStart;

    @UI("//table")
    public static Table basicTable;

    @JTable(
            root = "//mat-table",
            headers = "//mat-header-row/mat-header-cell",
            column = "//mat-row/mat-cell[%s]",
            row = "//mat-row[%s]/mat-cell",
            cell = "//mat-row[{1}]/mat-cell[{0}]",
            allCells = "//mat-cell",
            size=4)
    public static Table basicMatTable;

    @UI("//a[contains(text(), 'Table with selection')]")
    public static Link tableWithSelectionLink;

    @NoCache
    @UI("//table-selection-example//table")
    public static Table tableWithSelection;
}

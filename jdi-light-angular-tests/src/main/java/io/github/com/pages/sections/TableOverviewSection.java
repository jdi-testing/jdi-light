package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.Paginator;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class TableOverviewSection {
    @UI("#mat-input-85")
    public static TextField overviewFilter;

    @JTable(root = "table-overview-example>div>table")
    public static Table overviewTable;

    @UI("//table-overview-example/div/mat-paginator")
    public static Paginator overviewPaginator;
}

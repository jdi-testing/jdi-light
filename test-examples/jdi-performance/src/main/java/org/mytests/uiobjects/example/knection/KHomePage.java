package org.mytests.uiobjects.example.knection;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class KHomePage extends WebPage {
    @UI("[aria-label='Knection']")
    public static Label knectionHome;
    @UI("[ng-table=projectsTableParams] [ui-id=Name]")
    public static TextField searchByName;
    @JTable(root = "table[ng-table=projectsTableParams]",
            header = {"Name", "Project Code", "Api Id", "Metrics", "Last Updated", "Actions"})
    public static DataTable<ProjectRow, Workspace> projects;
}

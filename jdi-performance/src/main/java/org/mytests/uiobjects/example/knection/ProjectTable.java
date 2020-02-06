package org.mytests.uiobjects.example.knection;

import com.epam.jdi.mobile.elements.complex.table.DataTable;

import static java.util.Arrays.asList;

public class ProjectTable extends DataTable<ProjectRow, Workspace> {
    public ProjectTable() {
        header.set(asList("Name", "Project Code", "Api Id", "Metrics", "Last Updated", "Actions"));
    }
}

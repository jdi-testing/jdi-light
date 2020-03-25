package org.mytests.uiobjects.example.knection;

import com.epam.jdi.light.elements.complex.table.DataTable;

import static java.util.Arrays.*;

public class ProjectTable extends DataTable<ProjectRow, Workspace> {
    public ProjectTable() {
        header.set(asList("Name", "Project Code", "Api Id", "Metrics", "Last Updated", "Actions"));
    }
}

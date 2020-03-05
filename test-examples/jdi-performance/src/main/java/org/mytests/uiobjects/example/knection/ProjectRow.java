package org.mytests.uiobjects.example.knection;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ProjectRow extends Section {
    @Title
    public Link name;
    public Text projectCode, apiId, lastUpdated;
    public Link actions;
}

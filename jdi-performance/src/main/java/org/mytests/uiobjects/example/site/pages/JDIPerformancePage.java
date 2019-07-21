package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.complex.DropdownSelect;

@Url("/performance.html")
public class JDIPerformancePage extends WebPage {
    // @Css("#users-table")
    public static Table usersTable;

    // @Css("#user-names")
    public static DropdownSelect userNames;

    //@Css("#textarea-performance")
    public static TextArea textareaPerformance;
}

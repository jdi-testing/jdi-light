package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.complex.table.FastTable;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.common.TextArea;
import com.epam.jdi.light.ui.html.complex.Dropdown;

@Url("/performance.html")
public class JDIPerformancePage extends WebPage {
    // @Css("#users-table")
    public static FastTable usersTable;

    // @Css("#user-names")
    public static Dropdown userNames;

    //@Css("#textarea-performance")
    public static TextArea textareaPerformance;
}

package io.github.epam.html.tests.issue.issue70.po;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;


@JSite("https://epam.github.io/JDI/table-with-href/")
public class JDISite {

    @Url("table-with-href.html")
    public static IndexPageJdi indexPageJdi;

    public static DocumentActions documentActions;

    public static DashboardPage documentList;

    public static DashboardItem dashboardItem;
}
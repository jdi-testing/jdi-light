package io.github.epam.html.tests.issues.issue70.test;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.PageFactory;
import io.github.epam.html.tests.issues.issue70.po.DashboardPage;
import org.testng.annotations.Test;

@JSite("https://jdi-testing.github.io/jdi-light/table-with-href/")
public class TestJDIList {
    @Url("table-with-href.html")
    public static DashboardPage dashboardPage;

    @Test(enabled = false)
    public void issue70() {
        PageFactory.initElements(TestJDIList.class);
        dashboardPage.open();
        dashboardPage.documents.get("foo").is().displayed();
        dashboardPage.documents.get("bar").is().displayed();
        dashboardPage.documents.get("bar").menu.select("foo");
    }
}

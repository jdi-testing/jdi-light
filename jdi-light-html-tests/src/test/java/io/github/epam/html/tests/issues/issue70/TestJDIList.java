package io.github.epam.html.tests.issues.issue70;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import io.github.epam.html.tests.issues.issue70.po.DashboardPage;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.PageFactory.*;

@JSite("https://jdi-testing.github.io/jdi-light/table-with-href/")
public class TestJDIList {
    @Url("table-with-href.html")
    public static DashboardPage dashboardPage;

    @Test
    public void issue70() {
        initSite(TestJDIList.class);
        dashboardPage.open();
        dashboardPage.documents.get("foo").is().displayed();
        dashboardPage.documents.get("bar").is().displayed();
        dashboardPage.documents.get("bar").menu.select("foo");
    }
}

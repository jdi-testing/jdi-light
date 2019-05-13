package io.github.epam.html.tests.issues.issue70.test;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import io.github.epam.html.tests.issues.issue70.po.DashboardPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.logger.LogLevels.INFO;

@JSite("https://epam.github.io/JDI/table-with-href/")
public class TestJDIList {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initElements(TestJDIList.class);
    }

    @Url("table-with-href.html")
    public static DashboardPage dashboardPage;

    @Test
    public void issue70() {
        dashboardPage.open();
        dashboardPage.documents.get("foo").is().displayed();
        dashboardPage.documents.get("bar").is().displayed();
        dashboardPage.documents.get("bar").menu.select("foo");
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}

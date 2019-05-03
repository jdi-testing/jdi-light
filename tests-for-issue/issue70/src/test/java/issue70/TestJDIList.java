package issue70;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import issue70.po.DashboardPage;
import issue70.po.JDISite;

import static com.epam.jdi.light.logger.LogLevels.INFO;

public class TestJDIList {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        WebSettings.logger.setLogLevel(INFO);
        PageFactory.initElements(JDISite.class);
    }

    @Test
    public void TestJdi() {
        JDISite.indexPageJdi.open();
        DashboardPage.documents.get("foo").is().displayed();
        DashboardPage.documents.get("bar").is().displayed();
        DashboardPage.documents.get("bar").menu.select("foo");
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}
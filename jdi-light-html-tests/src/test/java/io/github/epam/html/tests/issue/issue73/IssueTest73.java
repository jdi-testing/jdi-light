package io.github.epam.html.tests.issue.issue73;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.epam.html.tests.issue.issue73.JDISite73.issuePage73;

public class IssueTest73 {

    @BeforeMethod
    public void beforeSuite() {
        PageFactory.initElements(JDISite73.class);
    }

    @Test(enabled = false)
    //look locator io.github.epam.html.tests.issue.issue73 line10
    public void issueTest73(){
        issuePage73.open();
        issuePage73.stageItems.get(0).AddBefore();
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverFactory.close();
    }
}

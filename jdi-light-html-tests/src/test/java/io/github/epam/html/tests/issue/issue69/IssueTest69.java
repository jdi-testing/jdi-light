package io.github.epam.html.tests.issue.issue69;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.epam.html.tests.issue.issue69.JDISite69.issuePage69;

public class IssueTest69 {
    @BeforeMethod
    public void beforeSuite() {
        PageFactory.initElements(JDISite69.class);
    }

    @Test(enabled = false)
    public void issueTest69() {
        issuePage69.open();
        issuePage69.paragraphs.get(0);
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverFactory.close();
    }
}

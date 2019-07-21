package io.github.epam.html.tests.issues.issue73;

import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static io.github.epam.html.tests.issues.issue73.JDISite73.issuePage73;

public class IssueTest73 {
    @Test(enabled = false)
    //look locator io.github.epam.html.tests.issue.issue73; class StageItem; line10
    public void issueTest73(){
        initSite(JDISite73.class);
        issuePage73.open();
        issuePage73.stageItems.get(0).AddBefore();
    }
}

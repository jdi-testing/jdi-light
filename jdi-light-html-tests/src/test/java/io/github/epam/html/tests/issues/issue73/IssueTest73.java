package io.github.epam.html.tests.issues.issue73;

import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.Test;

import static io.github.epam.html.tests.issues.issue73.JDISite73.issuePage73;

public class IssueTest73 {
    @Test(enabled = false)
    //look locator io.github.epam.html.tests.issue.issue73 line10
    public void issueTest73(){
        PageFactory.initElements(JDISite73.class);
        issuePage73.open();
        issuePage73.stageItems.get(0).AddBefore();
    }
}

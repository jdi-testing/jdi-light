package io.github.epam.html.tests.issues.issue69;

import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.Test;

import static io.github.epam.html.tests.issues.issue69.JDISite69.issuePage69;

public class IssueTest69 {
    @Test(enabled = false)
    public void issueTest69() {
        PageFactory.initElements(JDISite69.class);
        issuePage69.open();
        issuePage69.paragraphs.get(0);
    }
}

package org.mytests.tests.example;

import com.epam.jdi.light.elements.composite.WebPage;
import org.mytests.uiobjects.example.knection.KnectionSite;
import org.mytests.uiobjects.example.knection.Workspace;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static org.mytests.uiobjects.example.knection.KHomePage.*;

public class KNeticTest {
    @Test(invocationCount = 10)
    public void smoke() {
        initSite(KnectionSite.class);
        WebPage.openUrl("http://ecsc00a0154c.epam.com:82/?ssoUserId=Administrator");
        knectionHome.click();
        searchByName.sendKeys("project");
        projects.waitFor().all()
            .rows(w -> w.name.toLowerCase().contains("project"));
        Workspace project = projects.dataRow(1);
    }
}

package io.github.epam.html.tests.site;

import com.epam.jdi.light.elements.common.WindowsManager;
import com.epam.jdi.light.elements.composite.WebPage;
import io.github.com.GoogleDuckSite;
import io.github.com.StaticSite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static io.github.com.pages.Header.userIcon;

public class MultiSiteExample {

    @Test(enabled = false)
    public void loginTest() {
        initSite(GoogleDuckSite.class);
        openSite(StaticSite.class);
        WindowsManager.setWindowName("StaticSite");
        WindowsManager.openNewTab();
        WindowsManager.switchToNewWindow();
        WindowsManager.setWindowName("GoogleDuckSite");
        WebPage.openUrl("https://duckduckgo.com/");
        GoogleDuckSite.searchInput.input("Something");
        WindowsManager.switchToWindow("StaticSite");
        userIcon.click();
    }
}

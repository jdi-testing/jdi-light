package io.github.epam.html.tests.site;

import com.epam.jdi.light.elements.common.WindowsManager;
import com.epam.jdi.light.elements.composite.WebPage;
import io.github.com.GoogleDuckSite;
import io.github.com.StaticSite;
import io.github.com.pages.Header;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.Conditions.displayed;
import static com.epam.jdi.light.elements.base.Conditions.hidden;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static io.github.com.pages.Header.userIcon;

public class MultiSiteExample {
    @Test(enabled = false)
    public void loginTest() {
        initSite(GoogleDuckSite.class);
        openSite(StaticSite.class);
        WindowsManager.setWindowName("StaticSite");
        WindowsManager.openNewTab("GoogleDuckSite");
        WebPage.openUrl("https://duckduckgo.com/");
        GoogleDuckSite.searchInput.input("Something");
        WindowsManager.switchToWindow("StaticSite");
        userIcon.click();
    }

    @Test(enabled = false)
    public void multiTabsSites() {
        openSite(StaticSite.class);
        openSite(GoogleDuckSite.class);
        GoogleDuckSite.searchInput.input("Something");
        Header.userIcon.click();
        Header.loginForm.shouldBe(displayed);
        GoogleDuckSite.results.shouldBe(hidden);
        GoogleDuckSite.searchButton.input("Something");
        GoogleDuckSite.results.shouldBe(displayed);
    }

}

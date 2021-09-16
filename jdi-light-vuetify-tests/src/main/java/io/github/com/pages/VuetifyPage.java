package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.tools.CacheValue;

import static com.epam.jdi.light.actions.ActionProcessor.isTop;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.settings.WebSettings.init;

public abstract class VuetifyPage extends WebPage {
    @Override
    public void open(Object... params) {
        WebPage mainPage = new WebPage();
        mainPage.setName("Main page");
        mainPage.open();
        clickOnTheSidebar(this.url);
        initializePage(this);
    }

    private void clickOnTheSidebar(String fullUrl) {
        String pageLink = fullUrl.split(".io")[1];
        new UIElement().find(String.format("//nav//a[contains(@href, '%s')]", pageLink)).click();
    }

    private void initializePage(WebPage webPage) {
        init();
        CacheValue.reset();
        getWindows();
        isTop.set(true);
        setCurrentPage(webPage);
    }
}

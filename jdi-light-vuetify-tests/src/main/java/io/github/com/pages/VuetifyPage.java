package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.tools.CacheValue;
import org.openqa.selenium.JavascriptExecutor;

import static com.epam.jdi.light.actions.ActionProcessor.isTop;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.settings.WebSettings.init;

public abstract class VuetifyPage extends WebPage {
    @Override
    public void open(Object... params) {
        WebPage mainPage = new WebPage();
        mainPage.setName("Main page");
        mainPage.open();
        goToTargetPage(this.url);
        initializePage(this);
    }

    private void goToTargetPage(String fullUrl) {
        ((JavascriptExecutor) this.driver()).executeScript("$nuxt.$options.router.push({'path': arguments[0]})",
                fullUrl.split("vuetify")[1]);
    }

    private void initializePage(WebPage webPage) {
        init();
        CacheValue.reset();
        getWindows();
        isTop.set(true);
        setCurrentPage(webPage);
    }
}
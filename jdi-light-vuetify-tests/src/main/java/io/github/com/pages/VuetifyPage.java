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
        navigate();
        initializePage();
    }

    private void navigate() {
        String pageLink = this.url.split("vuetify")[1];
        ((JavascriptExecutor) this.driver()).executeScript("$nuxt.$router.push({'path': arguments[0]})", pageLink);
    }

    private void initializePage() {
        init();
        CacheValue.reset();
        getWindows();
        isTop.set(true);
        setCurrentPage(this);
    }
}
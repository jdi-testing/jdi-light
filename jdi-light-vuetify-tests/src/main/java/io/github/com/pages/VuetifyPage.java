package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitAfterAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.tools.CacheValue;

import static com.epam.jdi.light.actions.ActionProcessor.isTop;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.settings.WebSettings.init;

public class VuetifyPage extends WebPage {
    @UI("//div[text()='Form input & controls']")
    public static UIElement formInputAndControls;

    @WaitAfterAction(3)
    @UI("//div[text()='Checkboxes']")
    public static UIElement checkboxes;

    @Override
    public void open(Object... params) {
        WebPage mainPage = new WebPage();
        mainPage.setName("Main page");
        mainPage.open();
        clickOnTheSidebar(this.url);
        initializePage(this);
    }

    public void expandFormInputAndControls() {
        formInputAndControls.click();
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
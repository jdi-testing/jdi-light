package io.github.com.actions;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.tools.CacheValue;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import static com.epam.jdi.light.actions.ActionProcessor.isTop;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.composite.WebPage.setCurrentPage;
import static com.epam.jdi.light.settings.WebSettings.init;

@SuppressWarnings("unused")
@Aspect
public class VuetifyPageOpener {
    @Around("within(io.github.epam.vuetify.tests..*) " +
            "&& call(* io.github.com.pages.*.open(..))")
    public void openPage(ProceedingJoinPoint joinPoint) {
        new WebPage().open();
        WebPage webPage = (WebPage) joinPoint.getTarget();
        clickOnTheSidebar(webPage.url);
        initializePage(webPage);
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

package com.epam.jdi.light.settings;

import com.epam.jdi.light.common.PageChecks;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.tools.func.JAction1;

import static com.epam.jdi.light.common.VisualCheckPage.CHECK_NEW_PAGE;
import static com.epam.jdi.light.settings.JDISettings.PAGE;
import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static com.epam.jdi.light.settings.WebSettings.VISUAL_PAGE_STRATEGY;

public class PageSettings {
    public PageChecks checkPageOpen = PageChecks.NONE;
    public JAction1<WebPage> beforeNewPage = PageSettings::beforeNewPage;
    public JAction1<WebPage> beforeEachStep = PageSettings::beforeThisPage;

    public static void beforeNewPage(WebPage page) {
        if (VISUAL_PAGE_STRATEGY == CHECK_NEW_PAGE)
            WebPage.visualWindowCheck();
        WebSettings.logger.toLog("Page '" + page.getName() + "' opened");
        TIMEOUTS.element.set(TIMEOUTS.page.get());
    }

    public static void beforeThisPage(WebPage page) {
        if (PAGE.checkPageOpen != PageChecks.NONE)
            page.checkOpened();
    }
}

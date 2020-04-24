package com.epam.jdi.light.settings;

import com.epam.jdi.light.common.PageChecks;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.tools.func.JAction1;

public class PageSettings {
    public PageChecks checkPageOpen = PageChecks.NONE;
    public JAction1<WebPage> beforeNewPage = WebPage::beforeNewPage;
    public JAction1<WebPage> beforeEachStep = WebPage::beforeThisPage;
}

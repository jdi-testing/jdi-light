package io.github.epam.html.tests.issues.issue70.po;

import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;

public class DashboardPage extends WebPage {
    @XPath("//*[contains(@href, '%s')]")
    public DataList<DashboardItem, ?> documents;
}

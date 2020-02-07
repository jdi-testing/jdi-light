package io.github.epam.html.tests.issues.issue70.po;

import com.epam.jdi.mobile.elements.complex.DataList;
import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.XPath;

public class DashboardPage extends WebPage {
    @XPath("//*[contains(@href, '%s')]")
    public DataList<DashboardItem, ?> documents;
}

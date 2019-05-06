package io.github.epam.html.tests.issue.issue70.po;

import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;

public class DashboardPage {
    @XPath("//*[contains(@href, '%s')]")
    public static UIList<DashboardItem, ?> documents;
}

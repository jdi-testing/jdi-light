package io.github.epam.html.tests.issue.issue73;

import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

public class IssuePage73 extends WebPage {
    @Css("[id='stage-list-item-wrapper']")
    public DataList<StageItem, ?> stageItems;
}

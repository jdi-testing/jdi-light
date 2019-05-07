package io.github.epam.html.tests.issue.issue73;

import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;

class IssuePage73 extends WebPage {
    @Css("[id='stage-list-item-wrapper']")
    UIList<StageItem, ?> stageItems;
}

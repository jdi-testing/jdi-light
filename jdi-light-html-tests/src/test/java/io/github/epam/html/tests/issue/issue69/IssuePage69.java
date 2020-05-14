package io.github.epam.html.tests.issue.issue69;

import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

class IssuePage69 extends WebPage {
    @UI("list")
    DataList<Paragraph, ?> paragraphs;
}

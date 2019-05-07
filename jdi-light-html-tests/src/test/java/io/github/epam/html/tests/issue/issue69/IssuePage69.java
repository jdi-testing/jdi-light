package io.github.epam.html.tests.issue.issue69;

import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;

class IssuePage69 extends WebPage {
    @UI("list")
    UIList<Paragraph, ?> paragraphs;
}

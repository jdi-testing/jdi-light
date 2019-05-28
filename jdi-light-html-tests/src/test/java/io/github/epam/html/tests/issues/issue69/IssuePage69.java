package io.github.epam.html.tests.issues.issue69;

import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;

import java.util.List;

class IssuePage69 extends WebPage {
    @UI("[qa-item=template] [value=element_%s]")
    UIList<Paragraph, ?> template;
    @UI("[qa-item=paragraph]>div")
    UIList<Paragraph, ?> paragraphs;


    @UI("[qa-item=template] [value=element_%s]")
    List<Paragraph> templateList;
    @UI("[qa-item=paragraph]>div")
    List<Paragraph> paragraphsList;

    @UI("[qa-item=template] [value=element_%s]")
    UIList<Paragraph, ParagraphData> templateData;
    @UI("[qa-item=paragraph]>div")
    UIList<Paragraph, ParagraphData> paragraphsData;
}

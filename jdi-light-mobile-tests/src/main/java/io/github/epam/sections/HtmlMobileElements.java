package io.github.epam.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class HtmlMobileElements extends Section {

    @FindBy(css = "#mCSB_1_container > ul > li:nth-child(5) > ul > li:nth-child(1)")
    public static UIElement htmlMobileElements;

}

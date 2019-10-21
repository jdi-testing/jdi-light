package io.github.com.sections.navbar;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.ListGroup;

public class ScrollSpyNav extends Section {
    @UI(".//h4 | .//h5") public ListGroup header;//@FindBy(xpath = ".//h4 | .//h5")
    @UI("p") public ListGroup mainText;          // @FindBy(css = "p")

    @JDIAction("Scroll {0} to '{index}' check '{className}' class exists")
    public void scrollParagraph(ListGroup listGroup, int index, String className){
        mainText.get(index).show();

        if (!listGroup.get(index).core().hasClass(className) &&
                index < header.size()) {
            header.get(index + 1).show();
        }
    }
}

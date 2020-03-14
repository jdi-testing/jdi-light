package io.github.com.sections;

import com.epam.jdi.light.asserts.generic.*;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

import static java.lang.String.*;

public class Slide extends Section implements IsText, HasAssert<TextAssert> {
    @UI("h5") public Label title;
    @UI("//div[img]") public Text image;
    @UI("p") public Text text;
    @Override
    public String getText() {
        return format("%s[%s:%s]", title.text(), image.text(), text.text());
    }
    @Override
    public TextAssert is() { return new TextAssert().set(this); }
}

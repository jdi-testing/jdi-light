package applitools.hackathon.custom;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

import static java.lang.String.format;

public class CategoryCell extends Section implements HasValue {
    @UI("a") public Text name;
    public String getValue() {
        return format("badge=%s;value=%s", name.classes().get(1), name.getText());
    }
}

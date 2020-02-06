package applitools.hackathon.custom;

import com.epam.jdi.mobile.elements.composite.Section;
import com.epam.jdi.mobile.elements.interfaces.base.HasValue;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

import static java.lang.String.format;

public class CategoryCell extends Section implements HasValue {
    @UI("a") public Text name;
    public String getValue() {
        return format("badge=%s;value=%s", name.classes().get(1), name.getText());
    }
}

package applitools.hackathon.custom;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;

import static java.lang.String.format;

public class StatusCell extends Section implements HasValue {
    @UI(".status-pill") Icon statusPill;
    @UI("//span[2]") Text value;
    public String getValue() {
        return format("color=%s;status=%s",
            statusPill.classes().get(2), value.getText());
    }
}

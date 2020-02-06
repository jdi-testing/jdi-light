package applitools.hackathon.custom;

import com.epam.jdi.mobile.elements.composite.Section;
import com.epam.jdi.mobile.elements.interfaces.base.HasValue;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

import static java.lang.Float.parseFloat;
import static java.lang.String.format;

public class AmountCell extends Section implements HasValue {
    @UI("span") public Text value;
    public float value() {
        String[] split = value.getText().split(" ");
        float value = parseFloat(split[1].replace(",", ""));
        if (split[0].equals("-"))
            value = value * -1;
        return value;
    }
    public String getValue() {
        return format("type=%s;value=%s", value.classes().get(0), value.getText());
    }
}

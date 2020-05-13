package jdisite.custom;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;

public class Avatar extends Section implements HasValue {
    @UI("img") public Image image;
    @UI(".user-descr>span")public Text description;
    @UI("input[type=checkbox]")public Checkbox vip;

    @Override
    public String getValue() {
        return description.getText() + ":" +
            (vip.isSelected() ? "VIP" : "Dude");
    }
}

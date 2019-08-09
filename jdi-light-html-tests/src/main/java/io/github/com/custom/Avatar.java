package io.github.com.custom;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Image;
import com.epam.jdi.light.ui.html.elements.common.Text;

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

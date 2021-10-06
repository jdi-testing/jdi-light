package io.github.com.custom.windows;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public abstract class AccountWindow extends Section {

    @UI(".text-caption")
    private Text caption;

    public Text caption() {
        return caption;
    }

}

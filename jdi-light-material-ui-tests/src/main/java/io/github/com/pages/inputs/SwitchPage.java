package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class SwitchPage extends WebPage {

    @UI("//span[contains(@class,'MuiSwitch-switchBase')]")
    public static List<Checkbox> switches;

    @UI("//p[contains(@class,'MuiFormHelperText-root')]")
    public static Text formGroupTextForm;
}

package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class SwitchPage extends WebPage {

    @UI("//h2[text()='Basic switches']/following-sibling::span[@class='MuiSwitch-root']")
    public static List<Switch> basicSwitches;

    @UI("//fieldset//span[@class='MuiSwitch-root']")
    public static List<Switch> formGroupSwitches;

    @UI("//p[contains(@class,'MuiFormHelperText-root')]")
    public static Text formGroupTextForm;

}

package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.*;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;

import java.util.List;

public class ButtonPage extends WebPage {

    @UI("//h2[text()='Contained buttons']/parent::div/div[1]/*")
    public static List<Button> containedButtons;

    @UI("//h2[text()='Text buttons']/parent::div/div[2]/*")
    public static List<Button> textButtons;

    @UI("//h2[text()='Buttons with icons and label']/parent::div/div[3]/*")
    public static List<Button> iconLabelButtons;

    @UI("//span[contains(@class,'MuiButton-icon')]")
    public static List<Icon> iconLabelIcons;

    @UI("//h2[text()='Icon buttons']/parent::div/div[4]/*")
    public static List<Button> iconButtons;

    @UI("//span[@class='MuiIconButton-label']")
    public static List<Icon> iconButtonIcons;

    @UI("//h2[text()='Customized buttons']/parent::div/div[5]/*")
    public static List<Button> customizedButtons;

    @UI("//h2[text()='Complex buttons']/parent::div/div[6]/*")
    public static List<Button> complexButtons;
}

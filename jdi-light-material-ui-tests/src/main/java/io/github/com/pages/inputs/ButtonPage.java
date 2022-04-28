package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.ComplexMUIButton;
import com.epam.jdi.light.material.elements.inputs.MUIButton;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class ButtonPage extends WebPage {

    @UI("//h2[text()='Contained buttons']/following-sibling::div[1]/*[contains(@class, 'MuiButton-root')]")
    public static List<MUIButton> containedButtons;


    @UI("//h2[text()='Text buttons']/following-sibling::div[1]/*[contains(@class, 'MuiButton-root')]")
    public static List<MUIButton> textButtons;


    @UI("//h2[text()='Buttons with icons and label']/following-sibling::div[1]/button")
    public static List<MUIButton> iconLabelButtons;


    @UI("//h2[text()='Icon buttons']/following-sibling::div[1]/button")
    public static List<MUIButton> iconButtons;


    @UI("//h2[text()='Customized buttons']/following-sibling::div[1]/button")
    public static List<MUIButton> customizedButtons;


    @UI("//h2[text()='Complex buttons']/following-sibling::div[1]/button")
    public static List<ComplexMUIButton> complexButtons;

}

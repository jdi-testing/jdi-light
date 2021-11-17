package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.RadioGroup;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class RadioPage extends WebPage {

    @UI("#simpleRadio .MuiRadio-root")
    public static List<RadioGroup> simpleRadioButtons;

    @UI("#lastClickContent")
    public static Text lastRadioText;

    @UI("h2['Label placement']  //h2[text()='Label placement']/following::label")
    public static List<Button> labelPlacementButtons;

    @UI("//h2[text()='Label placement']/following::span[@id='MuiButtonBase-root']")
    public static List<Button> labelPlacementButtonsClass;

    @UI("//h2[text()='Show error']/following::label")
    public static List<Button> showErrorButtons;

    @UI("//h2[text()='Show error']/following::p")
    public static Text errorText;

    @UI("//h2[text()='Show error']/following::button")
    public static Button checkAnswer;
}

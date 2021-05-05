package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class RadioButtonPage extends WebPage {

    @UI("//fieldset[@id='simpleRadio']//label")
    public static List<Button> simpleRadioButtons;

    @UI("//fieldset[@id='simpleRadio']//span[@id='MuiButtonBase-root']")
    public static List<Button> simpleRadioButtonsClass;

    @UI("//p[@id='lastClickContent']")
    public static Text lastRadioText;

    @UI("//h2[text()='Label placement']/following-sibling::fieldset[1]/div/label")
    public static List<Button> labelPlacementButtons;

    @UI("//h2[text()='Label placement']/following-sibling::fieldset[1]/div/label/span[1]")
    public static List<Button> labelPlacementButtonsClass;

    @UI("//h2[text()='Show error']/following-sibling::form/fieldset/div/label")
    public static List<Button> showErrorButtons;

    @UI("//h2[text()='Show error']/following-sibling::form/fieldset/p")
    public static Text errorText;

    @UI("//h2[text()='Show error']/following::button")
    public static Button checkAnswer;
}

package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class RadioButtonPage extends WebPage {
    @UI("//h2[text()='Simple radio']/following-sibling::fieldset[1]/div/label")
    public static List<UIElement> simpleRadioButtons;

    @UI("//h2[text()='Simple radio']/following-sibling::fieldset[1]/div/label/span[1]")
    public static List<UIElement> simpleRadioButtonsClass;

    @UI("//h2[text()='Simple radio']/following-sibling::fieldset[1]/p")
    public static Text lastRadioText;

    @UI("//h2[text()='Label placement']/following-sibling::fieldset[1]/div/label")
    public static List<UIElement> labelPlacementButtons;

    @UI("//h2[text()='Label placement']/following-sibling::fieldset[1]/div/label/span[1]")
    public static List<UIElement> labelPlacementButtonsClass;

    @UI("//h2[text()='Show error']/following-sibling::form/fieldset/div/label")
    public static List<UIElement> showErrorButtons;

    @UI("//h2[text()='Show error']/following-sibling::form/fieldset/p")
    public static Text errorText;

    @UI("//h2[text()='Show error']/following-sibling::form/fieldset/button")
    public static Button checkAnswer;
}

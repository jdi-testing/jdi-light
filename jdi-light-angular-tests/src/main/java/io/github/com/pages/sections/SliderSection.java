package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.angular.elements.common.Slider;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;


public class SliderSection extends Section {
    public Slider matSliderConfigurable;
    public Slider matSliderBasic;
    public Slider matSliderFormatting;
    public TextField sliderConfigurableValue;
    public TextField sliderConfigurableMin;
    public TextField sliderConfigurableMax;
    public TextField sliderConfigurableStep;
    public Checkbox sliderConfigurableThumbLabel;
    public Checkbox sliderConfigurableVertical;
    public Checkbox sliderConfigurableInvert;
    public Checkbox sliderConfigurableDisabled;
}

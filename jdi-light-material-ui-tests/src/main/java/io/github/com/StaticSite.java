package io.github.com;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.tools.DataClass;
import io.github.com.pages.inputs.SelectFrame;
import io.github.com.pages.inputs.SliderFrame;
import io.github.com.pages.inputs.SwitchFrame;
import io.github.com.pages.inputs.TextFieldFrame;
import io.github.com.pages.surfaces.AccordionFrame;
import io.github.com.pages.surfaces.PaperFrame;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class StaticSite {

    // inputs
    // switch
    @Frame("storybook-preview-iframe")
    public static SwitchFrame switchFrame;

    @Frame("storybook-preview-iframe")
    public static SelectFrame selectFrame;

    @Url("/material-ui-switch--default")
    public static WebPage inputSwitchDefaultPage;

    @Url("/material-ui-switch--disabled")
    public static WebPage inputSwitchDisabledPage;

    @Url("/material-ui-switch--disabled-and-checked")
    public static WebPage inputSwitchDisabledAndCheckedPage;

    @Url("/material-ui-inputs-select--disabled-select-view")
    public static WebPage inputSelectDisabledPage;

    @Url("/material-ui-inputs-select--multiple-select-view")
    public static WebPage inputSelectMultiplePage;

    @Url("/material-ui-inputs-select--simple-select-view")
    public static WebPage inputSelectSimplePage;

    //slider
    @Frame("storybook-preview-iframe")
    public static SliderFrame sliderFrame;

    @Url("/material-ui-sliders--default-and-disabled-sliders")
    public static WebPage inputSliderDefaultAnfDisabledPage;

    @Url("/material-ui-sliders--range-slider")
    public static WebPage inputSliderRangePage;

    @Url("/material-ui-sliders--vertical-slider")
    public static WebPage inputSliderVerticalPage;

    // text field
    @Frame("storybook-preview-iframe")
    public static TextFieldFrame textFieldFrame;

    @Url("/material-ui-inputs-text-field--standard")
    public static WebPage inputTextFieldStandardPage;

    @Url("/material-ui-inputs-text-field--field-with-default")
    public static WebPage inputTextFieldFilledWithDefaultPage;

    @Url("/material-ui-inputs-text-field--filled")
    public static WebPage inputTextFieldFilledPage;

    @Url("/material-ui-inputs-text-field--disabled")
    public static WebPage inputTextFieldDisabledPage;

    @Url("/material-ui-inputs-text-field--time")
    public static WebPage inputTextFieldTimePage;

    // surfaces
    // accordion
    @Frame("storybook-preview-iframe")
    public static AccordionFrame accordionFrame;

    @Url("/material-ui-surfaces-accordion--default")
    public static WebPage surfaceAccordionPage;

    @Url("/material-ui-surfaces-accordion--disabled")
    public static WebPage surfaceAccordionDisabledPage;

    // paper
    @Frame("storybook-preview-iframe")
    public static PaperFrame paperFrame;

    @Url("/material-ui-surfaces-paper--default")
    public static WebPage surfacePaperDefaultPage;

    @UI("#login-form")
    public static Form<User> loginForm;

    @Css(".logout")
    public static Button logout;
    public static Button userIcon;
    public static Text userName;

    public static class User extends DataClass<User> {
        public String name = "Roman";
        public String password = "Jdi1234";
    }
}

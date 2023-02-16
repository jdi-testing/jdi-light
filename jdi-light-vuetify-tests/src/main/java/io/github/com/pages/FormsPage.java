package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.forms.RulesVuetifyForm;
import io.github.com.custom.forms.SingleTextFieldVuetifyForm;
import io.github.com.custom.forms.ValidationWithSubmitClearVuetifyForm;
import io.github.com.custom.forms.VeeValidateVuetifyForm;
import io.github.com.custom.forms.VuelidateVuetifyForm;

public class FormsPage extends VuetifyPage {

    @UI("#RulesForm")
    public static RulesVuetifyForm rulesForm;

    @UI("#ValidationWithSubmitClearForm")
    public static ValidationWithSubmitClearVuetifyForm validationWithSubmitClearForm;

    @UI("#VeeValidateForm")
    public static VeeValidateVuetifyForm veeValidateForm;

    @UI("#VuelidateForm")
    public static VuelidateVuetifyForm vuelidateForm;

    @UI("#DisabledForm form")
    public static SingleTextFieldVuetifyForm disabledForm;

    @UI("#ReadonlyForm form")
    public static SingleTextFieldVuetifyForm readonlyForm;
}

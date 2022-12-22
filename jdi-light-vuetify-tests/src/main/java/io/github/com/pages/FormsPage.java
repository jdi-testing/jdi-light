package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.forms.RulesForm;
import io.github.com.custom.forms.SingleTextFieldForm;
import io.github.com.custom.forms.ValidationWithSubmitClearForm;
import io.github.com.custom.forms.VeeValidateForm;
import io.github.com.custom.forms.VuelidateForm;

public class FormsPage extends VuetifyPage {

    @UI("#RulesForm")
    public static RulesForm rulesForm;

    @UI("#ValidationWithSubmitClearForm")
    public static ValidationWithSubmitClearForm validationWithSubmitClearForm;

    @UI("#VeeValidateForm")
    public static VeeValidateForm veeValidateForm;

    @UI("#VuelidateForm")
    public static VuelidateForm vuelidateForm;

    @UI("#DisabledForm form")
    public static SingleTextFieldForm disabledForm;

    @UI("#ReadonlyForm form")
    public static SingleTextFieldForm readonlyForm;
}

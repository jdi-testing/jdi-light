package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.forms.RuleForm;
import io.github.com.custom.forms.VeeValidateForm;
import io.github.com.custom.forms.ValidationWithSubmitClearForm;
import io.github.com.custom.forms.VuelidateForm;

public class FormsPage extends VuetifyPage {

    @UI("#RulesForm")
    public static RuleForm ruleForm;

    @UI("#ValidationWithSubmitClearForm")
    public static ValidationWithSubmitClearForm validationWithSubmitClearForm;

    @UI("#VeeValidateForm")
    public static VeeValidateForm veeValidateForm;

    @UI("#VuelidateForm")
    public static VuelidateForm vuelidateForm;

}

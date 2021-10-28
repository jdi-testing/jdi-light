package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.forms.CustomRuleForm;
import io.github.com.custom.forms.ValidationWithSubmitClearForm;

public class FormsPage extends VuetifyPage {

    @UI("#RulesForm")
    public static CustomRuleForm customRuleForm;

    @UI("#ValidationWithSubmitClearForm")
    public static ValidationWithSubmitClearForm validationWithSubmitClearForm;

}

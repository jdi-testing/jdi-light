package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

/**
 * Created by Roman Bordiugov on 18.10.2019
 * Email: Roman_Bordiugov@epam.com; Skype: rome_hk
 */

public class FormHorizontalLabelSizing extends Form {

    @UI("#colFormLabelSm")
    public TextField smallText;

    @UI("#colFormLabel")
    public TextField commonText;

    @UI("#colFormLabelLg")
    public TextField largeText;

}

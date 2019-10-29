package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

/**
 * Created by Roman Bordiugov on 21.10.2019
 * Email: Roman_Bordiugov@epam.com; Skype: rome_hk
 */

public class FormColumnSizing extends Form {

    @UI("#form-column-size-city")
    public TextField cityName;

    @UI("#form-column-size-state")
    public TextField stateName;

    @UI("#form-column-size-zip")
    public TextField zipCode;
}

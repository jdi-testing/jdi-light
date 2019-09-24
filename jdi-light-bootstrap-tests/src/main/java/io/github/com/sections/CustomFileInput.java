package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

/**
 * Created by Olga Ivanova on 19.09.2019
 * Email: olga_ivanova@epam.com
 */

public class CustomFileInput extends Section {

    @UI(".input-group-prepend") public Label uploadTextBefore;
    @UI(".input-group-append") public Label uploadTextAfter;

    @UI(".custom-file input") public UIElement inputFiled;
    @UI(".custom-file label") public Label labelText;
}

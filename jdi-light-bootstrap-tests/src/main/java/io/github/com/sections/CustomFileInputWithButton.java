package io.github.com.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

/**
 * Created by Olga Ivanova on 19.09.2019
 * Email: olga_ivanova@epam.com
 */

public class CustomFileInputWithButton extends Section {

    @UI(".input-group-prepend") public Text uploadTextBefore;
    @UI(".input-group-append") public Text uploadTextAfter;

    @UI(".custom-file-input") public UIElement inputFiled;
    @UI(".custom-file-label") public UIElement labelText;
}

package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class CardExample extends Section {
    @Css("#bs-card-example-title") public static Text cardExampleTitle;
    @Css("#bs-card-example-text") public static Text cardExampleMainText;
    @Css("#bs-card-example-button") public static Button cardExampleButton;
    @Css("#bs-card-example-image") public static Image cardExampleImage;
}

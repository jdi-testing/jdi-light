package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.common.IsJumbotron;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class Jumbotron extends Section implements IsJumbotron {
    @Css(".display-4") public Text title;
    @Css(".lead") public Text description;
    @Css(".btn") public Button learnMoreBtn;
}
package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.ui.bootstrap.interfaces.IsJumbotron;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

// Implements Jumbotron
// https://getbootstrap.com/docs/4.0/components/jumbotron/
public class Jumbotron extends Section implements IsJumbotron {
    @Css(".display-4") public Text title;
    @Css(".lead") public Text description;
    @Css(".btn") public Button learnMoreBtn;
}
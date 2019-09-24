package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class CardTextAlignment extends Section {

    @Title
    @UI("h5")
    public Text cardTitle;

    @UI(".card-text")
    public Text cardDescription;

    @UI("button")
    public Button cardButton;

}

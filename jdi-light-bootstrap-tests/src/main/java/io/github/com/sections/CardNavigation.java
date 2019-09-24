package io.github.com.sections;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class CardNavigation extends Section {

    @UI(".nav")
    public Menu menu;

    @Title
    @UI("h5")
    public Text title;

    @UI(".card-text")
    public Text text;

    @UI("button")
    public Button button;

}

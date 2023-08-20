package io.github.com.custom;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ShadowElement extends UIElement {
    @UI("#shadowTitle")
    public Label title;

    @UI("#shadowBtn")
    public Button shadowBtn;

    @UI("#shadowTxt")
    public Text shadowText;
}

package io.github.com.custom;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.composite.Parallax;

public class ContentParallax extends Parallax {

    @UI("h1")
    private Text header;

    @UI("h4")
    private Text subheader;

    public Text getHeader() { return header; }

    public Text getSubheader() { return subheader; }
}

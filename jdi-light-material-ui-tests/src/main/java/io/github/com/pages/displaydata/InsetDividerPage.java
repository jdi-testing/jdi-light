package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Divider;

public class InsetDividerPage extends WebPage {
    @UI("(//li[contains(@class, 'MuiDivider-root')])[2]")
    public Divider divider;
}

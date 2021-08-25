package io.github.com;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;

@JSite("https://duckduckgo.com/")
public class GoogleDuckSite {
    @UI("#search_form_input_homepage")
    public static TextField searchInput;
    @UI("#search_button_homepage")
    public static TextField searchButton;
    @UI(".results")
    public static UIElement results;

}

package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.entities.SuperHero;
import io.github.com.entities.SupportMessage;

public class BootstrapFormsPage extends WebPage {
    @UI("#support-form")
    public static Form<SupportMessage> supportMessageForm;

    @UI("#new-superhero-form")
    public static Form<SuperHero> superheroForm;
}

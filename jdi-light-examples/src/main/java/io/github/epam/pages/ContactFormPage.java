package io.github.epam.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import io.github.epam.sections.LogSidebar;
import io.github.epam.sections.Main;

public class ContactFormPage extends WebPage {
	@Css(".uui-side-bar[name='log-sidebar']") public LogSidebar logSidebar;
	@Css(".main-form") public Main main;

}
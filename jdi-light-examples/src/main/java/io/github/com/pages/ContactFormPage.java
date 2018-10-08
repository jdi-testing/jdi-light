package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;

public class ContactFormPage extends WebPage {
	@Css(".uui-side-bar[name='log-sidebar']") public static LogSidebar logSidebar;
	@Css(".main-form") public static Main main;

}
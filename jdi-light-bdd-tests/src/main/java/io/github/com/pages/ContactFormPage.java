package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class ContactFormPage extends WebPage {
	@UI(".uui-side-bar[name='log-sidebar']") public static LogSidebar logSidebar;
	@UI(".main-form") public static Main main;

}
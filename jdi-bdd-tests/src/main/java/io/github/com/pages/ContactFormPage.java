package io.github.com.pages;

import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;

public class ContactFormPage extends WebPage {
	@UI(".uui-side-bar[name='log-sidebar']") public static LogSidebar logSidebar;
	@UI(".main-form") public static Main main;

}
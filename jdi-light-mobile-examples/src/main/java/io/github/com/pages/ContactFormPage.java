package io.github.com.pages;

import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.Css;

public class ContactFormPage extends WebPage {
	@Css(".uui-side-bar[name='log-sidebar']") public static LogSidebar logSidebar;
	@Css(".main-form") public static Main main;

}
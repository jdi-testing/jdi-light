package io.github.epam.pages;

import com.epam.jdi.mobile.elements.complex.table.Table;
import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.Css;

public class PerformancePage extends WebPage {
	@Css("#users-table") public Table users;
	@Css("#users-table") public Table usersFast;

}
package io.github.epam.pages;

import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;

public class PerformancePage extends WebPage {
	@Css("#users-table") public Table users;
	@Css("#users-table") public Table usersFast;

}
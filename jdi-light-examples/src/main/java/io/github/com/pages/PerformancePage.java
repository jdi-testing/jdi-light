package io.github.com.pages;

import com.epam.jdi.light.elements.complex.table.FastTable;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;

public class PerformancePage extends WebPage {
	@Css("#users-table") public static Table users;
	@Css("#users-table") public static FastTable usersFast;

}
package io.github.com.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.entities.Furniture;

public class SimpleTablePage extends WebPage {
	public static Table usersTable;
	public static DataTable<?, Furniture> products;
	public static DataTable<?, Furniture> furniture;
	@UI("//*[@id='furniture']//tr[3]/td")public static WebList flist;

}
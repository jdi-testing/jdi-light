package io.github.com.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.NoCache;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.UserRow;
import io.github.com.custom.UserTable;
import io.github.com.entities.UserInfo;

public class PerformancePage extends WebPage {
	@UI("#users-table tr>td:first-child") public static WebList firstRow;
	@UI("//*[@id='users-table']//tr/td[1][text()='%s']") public static WebList firstTemplate;
	@UI("//*[@id='users-table']//tr/td[1]") public static WebList firstXpath;

	public static Table usersTable;
	@UI("#users-table") public static Table usersTableUI;

	@JTable(
		root = "#users-table", row = "//tr[%s]/td", column = "//tr/td[%s]",
		cell = "//tr[{1}]/td[{0}]", allCells = "td", headers = "th",
		header = {"Name", "Phone", "Email", "City"},
		rowHeader = "Name", size = 4
	) public static Table usersTableSetup;

	@UI("#users-table") @NoCache
	public static DataTable<UserRow, UserInfo> usersDataTable;

	@JTable(
		root = "#users-table", row = "//tr[%s]/td", column = "//tr/td[%s]",
		cell = "//tr[{1}]/td[{0}]", allCells = "td", headers = "th",
		header = {"Name", "Phone", "Email", "City"},
		rowHeader = "Name", size = 4
	) public static DataTable<UserRow, UserInfo> usersDataTableSetup;

	@UI("#users-table")
	public static UserTable<UserRow, UserInfo> customUsersDataTable;

}
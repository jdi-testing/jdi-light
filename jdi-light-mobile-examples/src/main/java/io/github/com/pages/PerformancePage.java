package io.github.com.pages;

import com.epam.jdi.mobile.elements.complex.table.DataTable;
import com.epam.jdi.mobile.elements.complex.table.Table;
import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.NoCache;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.UserTable;
import io.github.epam.custom.UserRow;
import io.github.epam.entities.UserInfo;

public class PerformancePage extends WebPage {
	@UI("#users-table") public static Table users;
	@JTable(
		root = "#users-table",
		row = "//tr[%s]/td",
		column = "//tr/td[%s]",
		cell = "//tr[{1}]/td[{0}]",
		allCells = "td",
		headers = "th",
		header = {"Name", "Phone", "Email", "City"},
	 	rowHeader = "Name",
		size = 4
	) public static Table usersSetup;

	@UI("#users-table") @NoCache
	public static DataTable<UserRow, UserInfo> usersData;
	@JTable( root = "#users-table",
		row = "//tr[%s]/td", column = "//tr/td[%s]",
		cell = "//tr[{1}]/td[{0}]", allCells = "td",
		headers = "th", header = {"Name", "Phone", "Email", "City"},
		rowHeader = "Name", size = 4
	)
	public static DataTable<UserRow, UserInfo> usersDataSetup;
	@UI("#users-table")
	public static UserTable<UserRow, UserInfo> customUsersDataSetup;

}
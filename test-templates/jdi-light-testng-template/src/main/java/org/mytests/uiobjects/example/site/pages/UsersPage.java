package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.mytests.uiobjects.example.custom.MarvelUser;
import org.mytests.uiobjects.example.entities.MarvelUserInfo;

@Url("/user-table.html") @Title("User Table")
public class UsersPage extends WebPage {
	@UI("#user-table") public static Table usersTable;
	@UI("#user-table") @WaitTimeout(2)
	public static DataTable<MarvelUser, MarvelUserInfo> users;
	@UI("#user-table") public static DataTable<MarvelUser, ?> usersRow;
	@JTable(root = "#user-table", rowHeader = "User")
	public static DataTable<MarvelUser, MarvelUserInfo> usersSetup;

}
package io.github.com.pages;

import com.epam.jdi.light.elements.complex.table.*;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitTimeout;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import io.github.com.custom.MarvelUser;
import io.github.com.entities.*;

public class UsersPage extends WebPage {
	@UI("#user-table")
	public static Table usersTable;
	@UI("#user-table") @WaitTimeout(2)
	public static DataTable<MarvelUser, MarvelUserInfo> users;
	@UI("#user-table")
	public static DataTable<MarvelUser, ?> usersRow;
	@UI("#user-table")
	public static DataTable<?, MarvelUserSimple> usersData;
	@JTable(root = "#user-table", rowHeader = "User")
	public static DataTable<MarvelUser, MarvelUserInfo> usersSetup;

}
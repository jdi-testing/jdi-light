package io.github.com.pages;

import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import io.github.com.custom.MarvelUser;
import io.github.com.entities.MarvelUserInfo;

public class UsersPage extends WebPage {
	@UI("#user-table") public static DataTable<MarvelUser, MarvelUserInfo> users;
	@JTable(root = "#user-table", rowHeader = "User") public static
	DataTable<MarvelUser, MarvelUserInfo> usersSetup;

}
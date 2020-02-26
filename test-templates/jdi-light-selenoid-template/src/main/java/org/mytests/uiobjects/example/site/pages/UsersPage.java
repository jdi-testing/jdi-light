package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import org.mytests.uiobjects.example.entities.MarvelUserInfo;
import org.mytests.uiobjects.example.site.custom.MarvelUser;

@Url("/user-table.html") @Title("User Table")
public class UsersPage extends WebPage {
	@UI("#user-table") public static DataTable<MarvelUser, MarvelUserInfo> users;
	@JTable(root = "#user-table", rowHeader = "User")
	public static DataTable<MarvelUser, MarvelUserInfo> usersSetup;

}
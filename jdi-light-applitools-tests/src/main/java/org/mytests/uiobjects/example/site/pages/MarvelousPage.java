package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.mytests.uiobjects.example.custom.MarvelUser;
import org.mytests.uiobjects.example.entities.MarvelUserInfo;

public class MarvelousPage extends WebPage {
    @UI("#user-table")
    public static DataTable<?, MarvelUserInfo> usersData;
    public static DataTable<MarvelUser, MarvelUserInfo> userTable;
}

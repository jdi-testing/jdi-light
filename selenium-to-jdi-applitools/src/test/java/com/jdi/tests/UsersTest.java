package com.jdi.tests;

import com.jdi.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdi.states.State.loggedIn;
import static jdisite.enums.MenuOptions.Service;
import static jdisite.enums.MenuOptions.UserTable;
import static jdisite.pages.JDISite.marvelousPage;
import static jdisite.pages.JDISite.selectInMenu;

public class UsersTest extends TestsInit {
    @BeforeMethod
    public void before() {
        loggedIn();
        selectInMenu(Service);
        selectInMenu(UserTable);
    }
    @Test
    public void verifyUsersTest() {
        marvelousPage.userTable.isDisplayed();
        marvelousPage.userRow2.isDisplayed();
        marvelousPage.descriptionOfUser2.isDisplayed();
        marvelousPage.imageOfUser2.isDisplayed();
    }
}

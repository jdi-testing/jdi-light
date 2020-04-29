package com.jdi.tests;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.jdi.TestsInit;
import org.testng.annotations.*;

import static com.epam.jdi.light.elements.complex.table.Row.inRow;
import static com.jdi.states.State.loggedIn;
import static jdisite.entities.DefaultData.SPIDER_MAN;
import static jdisite.enums.MenuOptions.*;
import static jdisite.pages.JDISite.leftMenu;
import static jdisite.pages.MarvelousPage.userTable;
import static org.hamcrest.Matchers.containsString;

public class Users2Test extends TestsInit {
    @BeforeMethod
    public void before() {
        loggedIn();
        leftMenu.select(Service, UserTable);
    }
    @Test
    public void verifyUsersTest() {
        userTable.is().displayed();
        userTable.has().value(SPIDER_MAN, inRow(2));
        userTable.line(2).description.is().displayed();
        userTable.line(2).description.image
            .has().src(containsString("spider-man"));
    }
}

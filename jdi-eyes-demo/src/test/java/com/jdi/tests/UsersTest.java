package com.jdi.tests;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.jdi.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.complex.table.Row.*;
import static com.jdi.states.State.*;
import static jdisite.entities.DefaultData.*;
import static jdisite.enums.MenuOptions.*;
import static jdisite.pages.JDISite.*;
import static jdisite.pages.MarvelousPage.*;
import static org.hamcrest.Matchers.*;

public class UsersTest extends TestsInit {
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

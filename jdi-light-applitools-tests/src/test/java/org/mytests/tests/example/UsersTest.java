package org.mytests.tests.example;

import org.mytests.tests.TestsInit;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.complex.table.Row.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.hamcrest.Matchers.*;
import static org.mytests.uiobjects.example.entities.Defaults.*;
import static org.mytests.uiobjects.example.site.SiteJdi.*;
import static org.mytests.uiobjects.example.site.pages.MarvelousPage.*;

public class UsersTest extends TestsInit {
    @Test
    public void verifyUsersTest() {
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        marvelousPage.open();
        userTable.has().value(SPIDER_MAN, inRow(2));
        userTable.assertThat()
            .all().rows(d -> d.user.length() > 4)
            .no().rows(d -> isBlank(d.user))
            .atLeast(3).rows(d -> d.type.contains("User"))
            .exact(1).rows(SPIDER_MAN);
        userTable.line(2).description.image.is()
            .src(containsString("spider-man"));
        userTable.line(3).description.is().displayed();
    }
}

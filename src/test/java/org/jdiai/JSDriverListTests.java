package org.jdiai;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JSDriverListTests extends TestInit {

    @BeforeMethod
    public void logout() {
        if (DRIVER.manage().getCookieNamed("authUser") == null) {
            js("#user-name").getOne("click()");
            js("#name").getOne("value='Roman'");
            js("#password").getOne("value='Jdi1234'");
            js("#login-button").getOne("click()");
        }
        if (!DRIVER.getCurrentUrl().equals(USERS_PAGE)) {
            DRIVER.get(USERS_PAGE);
        }
    }

    @Test
    public void oneTest() {
        assertEquals(js("//*[@id='user-table']//td[3]").getList("innerText").toString(),
        "[Roman, Sergey Ivan, Vladzimir, Helen Bennett, Yoshi Tannamuri, Giovanni Rovelli]");
    }
    @Test
    public void chainTest() {
        js("#user-table tr", "//*[*[span[contains(.,'er')]]]", "[checked]").getListChain("id");
    }
}

package org.jdiai.tests;

import org.jdiai.JSDriver;
import org.jdiai.TestInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JSDriverListTests extends TestInit {

    @BeforeMethod
    public void logout() {
        if (driver().manage().getCookieNamed("authUser") == null) {
            js("#user-name").invoke("click()");
            js("#name").invoke("value='Roman'");
            js("#password").invoke("value='Jdi1234'");
            js("#login-button").invoke("click()");
        }
        if (!driver().getCurrentUrl().equals(USERS_PAGE)) {
            driver().get(USERS_PAGE);
        }
    }

    @Test
    public void list1Test() {
        assertEquals(js("//*[@id='user-table']//td[3]").attribute("innerText").getList().asString().toString(),
        "[Roman, Sergey Ivan, Vladzimir, Helen Bennett, Yoshi Tannamuri, Giovanni Rovelli]");
    }
    @Test
    public void chain3Test() {
        assertEquals(js("#user-table", ".//tr//*[*[span[contains(.,'er')]]]", "[checked]").attribute("id").getListChain().asString().toString(),
                "[roman]");
    }
    @Test
    public void list3Test() {
        assertEquals(js("#user-table", ".//tr//*[*[span[contains(.,'er')]]]", "[checked]").attribute("id").getList().asString().toString(),
                "[roman]");
    }
    @Test
    public void multi3Test() {
        assertEquals(js("#user-table tr", ".//*[*[span[contains(.,'er')]]]", "[checked]").attribute("id").getListMultiSearch().asString().toString(),
                "[roman, vlad]");
    }
    @Test
    public void multiListTest() {
        JSDriver js = js("#user-table tr", ".//*[*[span[contains(.,'er')]]]", "[checked]")
            .multiSearch();
        assertEquals(js.attribute("id").getList().asString().toString(), "[roman, vlad]");
    }
    @Test
    public void getOneMultiTest() {
        JSDriver js = js("#user-table tr", ".//*[*[span[contains(.,'er')]]]", "[checked]")
            .multiSearch();
        assertEquals(js.attribute("id").getOne().asString(), "roman");
    }

    @Test
    public void getOneChainTest() {
        JSDriver js = js("#user-table tr", ".//*[*[span[contains(.,'er')]]]", "[checked]");
        try {
            js.attribute("id").getOne().asString();
            Assert.fail("Chain search should fail");
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("javascript error: Cannot read property 'querySelector' of null"));
        }
    }
}

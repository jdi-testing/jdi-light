package org.jdiai.tests;

import org.jdiai.JSInterface;
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
            js("#user-name").getOne("click()");
            js("#name").getOne("value='Roman'");
            js("#password").getOne("value='Jdi1234'");
            js("#login-button").getOne("click()");
        }
        if (!driver().getCurrentUrl().equals(USERS_PAGE)) {
            driver().get(USERS_PAGE);
        }
    }

    @Test
    public void list1Test() {
        assertEquals(js("//*[@id='user-table']//td[3]").getList("innerText").toString(),
        "[Roman, Sergey Ivan, Vladzimir, Helen Bennett, Yoshi Tannamuri, Giovanni Rovelli]");
    }
    @Test
    public void chain3Test() {
        assertEquals(js("#user-table", ".//tr//*[*[span[contains(.,'er')]]]", "[checked]").getListChain("id").toString(),
                "[roman]");
    }
    @Test
    public void list3Test() {
        assertEquals(js("#user-table", ".//tr//*[*[span[contains(.,'er')]]]", "[checked]").getList("id").toString(),
                "[roman]");
    }
    @Test
    public void multi3Test() {
        assertEquals(js("#user-table tr", ".//*[*[span[contains(.,'er')]]]", "[checked]").getListMultiSearch("id").toString(),
                "[roman, vlad]");
    }
    @Test
    public void multiListTest() {
        JSInterface js = js("#user-table tr", ".//*[*[span[contains(.,'er')]]]", "[checked]")
            .multiSearch();
        assertEquals(js.getList("id").toString(), "[roman, vlad]");
    }
    @Test
    public void getOneMultiTest() {
        JSInterface js = js("#user-table tr", ".//*[*[span[contains(.,'er')]]]", "[checked]")
            .multiSearch();
        assertEquals(js.getOne("id"), "roman");
    }

    @Test
    public void getOneChainTest() {
        JSInterface js = js("#user-table tr", ".//*[*[span[contains(.,'er')]]]", "[checked]");
        try {
            js.getOne("id");
            Assert.fail("Chain search should fail");
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("javascript error: Cannot read property 'querySelector' of null"));
        }
    }
}

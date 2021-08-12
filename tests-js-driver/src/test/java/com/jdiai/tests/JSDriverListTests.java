package com.jdiai.tests;

import com.jdiai.TestInit;
import com.jdiai.jsdriver.JSDriver;
import com.jdiai.testng.TestNGListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jdiai.Pages.USERS_PAGE;
import static com.jdiai.states.States.loggedInAt;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(TestNGListener.class)
public class JSDriverListTests implements TestInit {

    @BeforeMethod
    public void before() {
        loggedInAt(USERS_PAGE);
    }

    @Test
    public void list1Test() {
        assertEquals(js("//*[@id='user-table']//td[3]").getList("element.innerText").asString().toString(),
        "[Roman, Sergey Ivan, Vladzimir, Helen Bennett, Yoshi Tannamuri, Giovanni Rovelli]");
    }
    @Test
    public void chain3Test() {
        assertEquals(js("#user-table", ".//tr//*[*[span[contains(.,'er')]]]", "[checked]")
            .getListChain("element.id").asString().toString(),"[roman]");
    }
    @Test
    public void list3Test() {
        assertEquals(js("#user-table", ".//tr//*[*[span[contains(.,'er')]]]", "[checked]")
            .getList("element.id").asString().toString(),"[roman]");
    }
    @Test
    public void multi3Test() {
        assertEquals(js("#user-table tr", ".//*[*[span[contains(.,'er')]]]", "[checked]")
            .getListMultiSearch("element.id").asString().toString(),"[roman, vlad]");
    }
    @Test
    public void multiListTest() {
        JSDriver js = js("#user-table tr", ".//*[*[span[contains(.,'er')]]]", "[checked]")
            .multiSearch();
        assertEquals(js.getList("element.id").asString().toString(), "[roman, vlad]");
    }
    @Test

    public void getOneMultiTest() {
        JSDriver js = js("#user-table tr", ".//*[*[span[contains(.,'er')]]]", "[checked]")
            .multiSearch();
        assertEquals(js.getOne("element.id").asString(), "roman");
    }

    @Test
    public void getOneChainTest() {
        JSDriver js = js("#user-table tr", ".//*[*[span[contains(.,'er')]]]", "[checked]");
        try {
            js.getOne("element.id").asString();
            Assert.fail("Chain search should fail");
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("Cannot read property 'querySelector' of null"));
        }
    }
}

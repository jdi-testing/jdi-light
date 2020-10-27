package org.jdiai.tests;

import org.jdiai.TestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.jdiai.jselement.JSTalk.$;
import static org.testng.Assert.assertEquals;

public class JSElementTest extends TestInit {

    @BeforeMethod
    public void before() {
        atHomePage();
    }

    @Test
    public void oneTest() {
        assertEquals($("#user-icon").getAttribute("tagName"), "IMG");
        assertEquals($("#user-name").getAttribute("innerText"), "Roman Iovlev");
        assertEquals($("#user-name").getAttribute("textContent"), "Roman Iovlev");
        assertEquals($("#user-name").getAttribute("innerHTML"), "Roman Iovlev");
        assertEquals($("#user-name").getStyle("visibility"), "hidden");

        $("#user-name").doAction("click()");
        $("#name").doAction("value='Roman'");
        $("#password").doAction("value='Jdi1234'");
        $("#login-button").doAction("click()");

        assertEquals($("#user-name").getStyle("visibility"), "visible");
    }
    @Test
    public void oneFewLocatorsTest() {
        assertEquals($(withParent("#user-icon")).getAttribute("tagName"), "IMG");
        assertEquals($(withParent("#user-name")).getAttribute("innerText"), "Roman Iovlev");
        assertEquals($(withParent("#user-name")).getAttribute("textContent"), "Roman Iovlev");
        assertEquals($(withParent("#user-name")).getAttribute("innerHTML"), "Roman Iovlev");
        assertEquals($("#user-name").getStyle("visibility"), "hidden");

        $(withParent("#user-name")).doAction("click()");
        $(inForm("#name")).doAction("value='Roman'");
        $(inForm("#password")).doAction("value='Jdi1234'");
        $(inForm("#login-button")).doAction("click()");

        assertEquals($(withParent("#user-name")).getStyle("visibility"), "visible");
    }
    @Test
    public void styleTest() {
        assertEquals($("#user-name").getStyle("visibility"), "hidden");

        $(withParent("#user-name")).doAction("click()");
        $(inForm("#name")).doAction("value='Roman'");
        $(inForm("#password")).doAction("value='Jdi1234'");
        $(inForm("#login-button")).doAction("click()");

        assertEquals($("#user-name").getStyle("visibility"), "visible");
    }
    @Test
    public void styleMultiTest() {
        assertEquals($(withParent("#user-name")).getStyle("visibility"), "hidden");

        $(withParent("#user-name")).doAction("click()");
        $(inForm("#name")).doAction("value='Roman'");
        $(inForm("#password")).doAction("value='Jdi1234'");
        $(inForm("#login-button")).doAction("click()");

        assertEquals($(withParent("#user-name")).getStyle("visibility"), "visible");
    }
}

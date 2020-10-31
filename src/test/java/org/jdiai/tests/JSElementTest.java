package org.jdiai.tests;

import org.jdiai.TestInit;
import org.jdiai.jselement.JSTalk;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.jdiai.jselement.JSTalk.element;
import static org.testng.Assert.assertEquals;

public class JSElementTest extends TestInit {

    @BeforeMethod
    public void before() {
        atHomePage();
    }

    @Test
    public void oneTest() {
        assertEquals(JSTalk.element("#user-icon").getAttribute("tagName"), "IMG");
        assertEquals(JSTalk.element("#user-name").getAttribute("innerText"), "Roman Iovlev");
        assertEquals(JSTalk.element("#user-name").getAttribute("textContent"), "Roman Iovlev");
        assertEquals(JSTalk.element("#user-name").getAttribute("innerHTML"), "Roman Iovlev");
        assertEquals(JSTalk.element("#user-name").getStyle("visibility"), "hidden");

        JSTalk.element("#user-name").doAction("click()");
        JSTalk.element("#name").doAction("value='Roman'");
        JSTalk.element("#password").doAction("value='Jdi1234'");
        JSTalk.element("#login-button").doAction("click()");

        assertEquals(JSTalk.element("#user-name").getStyle("visibility"), "visible");
    }
    @Test
    public void oneFewLocatorsTest() {
        assertEquals(element(withParent("#user-icon")).getAttribute("tagName"), "IMG");
        assertEquals(element(withParent("#user-name")).getAttribute("innerText"), "Roman Iovlev");
        assertEquals(element(withParent("#user-name")).getAttribute("textContent"), "Roman Iovlev");
        assertEquals(element(withParent("#user-name")).getAttribute("innerHTML"), "Roman Iovlev");
        assertEquals(JSTalk.element("#user-name").getStyle("visibility"), "hidden");

        element(withParent("#user-name")).doAction("click()");
        element(inForm("#name")).doAction("value='Roman'");
        element(inForm("#password")).doAction("value='Jdi1234'");
        element(inForm("#login-button")).doAction("click()");

        assertEquals(element(withParent("#user-name")).getStyle("visibility"), "visible");
    }
    @Test
    public void styleTest() {
        assertEquals(JSTalk.element("#user-name").getStyle("visibility"), "hidden");

        element(withParent("#user-name")).doAction("click()");
        element(inForm("#name")).doAction("value='Roman'");
        element(inForm("#password")).doAction("value='Jdi1234'");
        element(inForm("#login-button")).doAction("click()");

        assertEquals(JSTalk.element("#user-name").getStyle("visibility"), "visible");
    }
    @Test
    public void styleMultiTest() {
        assertEquals(element(withParent("#user-name")).getStyle("visibility"), "hidden");

        element(withParent("#user-name")).doAction("click()");
        element(inForm("#name")).doAction("value='Roman'");
        element(inForm("#password")).doAction("value='Jdi1234'");
        element(inForm("#login-button")).doAction("click()");

        assertEquals(element(withParent("#user-name")).getStyle("visibility"), "visible");
    }
}

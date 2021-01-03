package org.jdiai.tests.basics;

import org.jdiai.TestInit;
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
        assertEquals(element("#user-icon").getAttribute("tagName"), "IMG");
        assertEquals(element("#user-name").getAttribute("innerText"), "Roman Iovlev");
        assertEquals(element("#user-name").getAttribute("textContent"), "Roman Iovlev");
        assertEquals(element("#user-name").getAttribute("innerHTML"), "Roman Iovlev");
        assertEquals(element("#user-name").getStyle("visibility"), "hidden");

        element("#user-name").doAction("click()");
        element("#name").doAction("value='Roman'");
        element("#password").doAction("value='Jdi1234'");
        element("#login-button").doAction("click()");

        assertEquals(element("#user-name").getStyle("visibility"), "visible");
    }
    @Test
    public void oneFewLocatorsTest() {
        assertEquals(element(withParent("#user-icon")).getAttribute("tagName"), "IMG");
        assertEquals(element(withParent("#user-name")).getAttribute("innerText"), "Roman Iovlev");
        assertEquals(element(withParent("#user-name")).getAttribute("textContent"), "Roman Iovlev");
        assertEquals(element(withParent("#user-name")).getAttribute("innerHTML"), "Roman Iovlev");
        assertEquals(element("#user-name").getStyle("visibility"), "hidden");

        element(withParent("#user-name")).doAction("click()");
        element(inForm("#name")).doAction("value='Roman'");
        element(inForm("#password")).doAction("value='Jdi1234'");
        element(inForm("#login-button")).doAction("click()");

        assertEquals(element(withParent("#user-name")).getStyle("visibility"), "visible");
    }
    @Test
    public void styleTest() {
        assertEquals(element("#user-name").getStyle("visibility"), "hidden");

        element(withParent("#user-name")).doAction("click()");
        element(inForm("#name")).doAction("value='Roman'");
        element(inForm("#password")).doAction("value='Jdi1234'");
        element(inForm("#login-button")).doAction("click()");

        assertEquals(element("#user-name").getStyle("visibility"), "visible");
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

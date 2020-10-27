package org.jdiai.tests;

import org.jdiai.TestInit;
import org.jdiai.entity.TextHtml;
import org.jdiai.entity.TextInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.jdiai.jselement.JSTalk.entity;
import static org.testng.Assert.assertEquals;

public class JSObjectTest extends TestInit {
    @BeforeMethod
    public void before() {
        atHomePage();
    }

    @Test
    public void oneTest() {
        TextInfo jsObject = entity(TextInfo.class, "#user-icon").getObject(
            " { \"tag\": element.tagName, \"iText\": element.innerText, " +
            "\"text\": element.textContent, \"iHtml\": element.innerHTML }");
        assertEquals(jsObject.tag, "Roman Iovlev");
        assertEquals(jsObject.iText, "Roman Iovlev");
        assertEquals(jsObject.text, "Roman Iovlev");
        assertEquals(jsObject.iHtml, "Roman Iovlev");
    }
    @Test
    public void oneAttributeTest() {
        TextHtml jsObject = entity(TextHtml.class, "#user-icon")
            .getObject("tagName", "innerText", "textContent", "innerHTML");
        assertEquals(jsObject.tagName, "Roman Iovlev");
        assertEquals(jsObject.innerText, "Roman Iovlev");
        assertEquals(jsObject.textContent, "Roman Iovlev");
        assertEquals(jsObject.innerHTML, "Roman Iovlev");
    }
    @Test
    public void oneFewLocatorsTest() {
        TextInfo jsObject = entity(TextInfo.class, withParent("#user-icon")).getObject(
            " { \"tag\": element.tagName, \"iText\": element.innerText, " +
            "\"text\": element.textContent, \"iHtml\": element.innerHTML }");
        assertEquals(jsObject.tag, "Roman Iovlev");
        assertEquals(jsObject.iText, "Roman Iovlev");
        assertEquals(jsObject.text, "Roman Iovlev");
        assertEquals(jsObject.iHtml, "Roman Iovlev");
    }
    @Test
    public void oneFewLocatorsAttributesTest() {
        TextInfo jsObject = entity(TextInfo.class, "#user-icon")
            .getObject("tagName", "innerText", "textContent", "innerHTML");
        assertEquals(jsObject.tag, "Roman Iovlev");
        assertEquals(jsObject.iText, "Roman Iovlev");
        assertEquals(jsObject.text, "Roman Iovlev");
        assertEquals(jsObject.iHtml, "Roman Iovlev");
    }

    @Test
    public void styleTest() {
        assertEquals(entity("#user-name").getStyle("visibility"), "hidden");

        entity(withParent("#user-name")).doAction("click()");
        entity(inForm("#name")).doAction("value='Roman'");
        entity(inForm("#password")).doAction("value='Jdi1234'");
        entity(inForm("#login-button")).doAction("click()");

        assertEquals(entity("#user-name").getStyle("visibility"), "visible");
    }
    @Test
    public void styleMultiTest() {
        assertEquals(entity(withParent("#user-name")).getStyle("visibility"), "hidden");

        entity(withParent("#user-name")).doAction("click()");
        entity(inForm("#name")).doAction("value='Roman'");
        entity(inForm("#password")).doAction("value='Jdi1234'");
        entity(inForm("#login-button")).doAction("click()");

        assertEquals(entity(withParent("#user-name")).getStyle("visibility"), "visible");
    }
}

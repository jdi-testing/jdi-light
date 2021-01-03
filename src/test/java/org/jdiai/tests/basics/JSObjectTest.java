package org.jdiai.tests.basics;

import org.jdiai.TestInit;
import org.jdiai.entity.TextHtml;
import org.jdiai.entity.TextInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.util.Arrays.asList;
import static org.jdiai.jselement.JSTalk.element;
import static org.testng.Assert.assertEquals;

public class JSObjectTest extends TestInit {
    @BeforeMethod
    public void before() {
        atHomePage();
    }

    @Test
    public void oneTest() {
        TextInfo jsObject = element(TextInfo.class, "#user-name").getEntity(
            "{ 'tag': element.tagName, 'iText': element.innerText, " +
            "'text': element.textContent, 'iHtml': element.innerHTML }");

        assertEquals(jsObject.tag, "SPAN");
        assertEquals(jsObject.iText, "Roman Iovlev");
        assertEquals(jsObject.text, "Roman Iovlev");
        assertEquals(jsObject.iHtml, "Roman Iovlev");
    }
    @Test
    public void oneAttributeTest() {
        TextHtml jsObject = element(TextHtml.class, "#user-name")
            .getEntity("tagName", "innerText", "textContent", "innerHTML");

        assertEquals(jsObject.tagName, "SPAN");
        assertEquals(jsObject.innerText, "Roman Iovlev");
        assertEquals(jsObject.textContent, "Roman Iovlev");
        assertEquals(jsObject.innerHTML, "Roman Iovlev");
    }
    @Test
    public void oneAttributeListTest() {
        TextHtml jsObject = element(TextHtml.class, "#user-name")
                .getEntity(asList("tagName", "innerText", "textContent", "innerHTML"));

        assertEquals(jsObject.tagName, "SPAN");
        assertEquals(jsObject.innerText, "Roman Iovlev");
        assertEquals(jsObject.textContent, "Roman Iovlev");
        assertEquals(jsObject.innerHTML, "Roman Iovlev");
    }
    @Test
    public void oneFewLocatorsTest() {
        TextInfo jsObject = element(TextInfo.class, withParent("#user-name")).getEntity(
            " { 'tag': element.tagName, 'iText': element.innerText, " +
            "'text': element.textContent, 'iHtml': element.innerHTML }");

        assertEquals(jsObject.tag, "SPAN");
        assertEquals(jsObject.iText, "Roman Iovlev");
        assertEquals(jsObject.text, "Roman Iovlev");
        assertEquals(jsObject.iHtml, "Roman Iovlev");
    }
    @Test
    public void oneFewLocatorsAttributesTest() {
        TextHtml jsObject = element(TextHtml.class, "#user-name")
            .getEntity("tagName", "innerText", "textContent", "innerHTML");

        assertEquals(jsObject.tagName, "SPAN");
        assertEquals(jsObject.innerText, "Roman Iovlev");
        assertEquals(jsObject.textContent, "Roman Iovlev");
        assertEquals(jsObject.innerHTML, "Roman Iovlev");
    }
    @Test
    public void oneFewLocatorsAttributesListTest() {
        TextHtml jsObject = element(TextHtml.class, "#user-name")
                .getEntity(asList("tagName", "innerText", "textContent", "innerHTML"));

        assertEquals(jsObject.tagName, "SPAN");
        assertEquals(jsObject.innerText, "Roman Iovlev");
        assertEquals(jsObject.textContent, "Roman Iovlev");
        assertEquals(jsObject.innerHTML, "Roman Iovlev");
    }

    @Test
    public void styleTest() {
        assertEquals(element(TextHtml.class, "#user-name").getStyle("visibility"), "hidden");

        element(TextHtml.class, withParent("#user-name")).doAction("click()");
        element(TextHtml.class, inForm("#name")).doAction("value='Roman'");
        element(TextHtml.class, inForm("#password")).doAction("value='Jdi1234'");
        element(TextHtml.class, inForm("#login-button")).doAction("click()");

        assertEquals(element(TextHtml.class, "#user-name").getStyle("visibility"), "visible");
    }
    @Test
    public void styleMultiTest() {
        assertEquals(element(TextHtml.class, withParent("#user-name")).getStyle("visibility"), "hidden");

        element(TextHtml.class, withParent("#user-name")).doAction("click()");
        element(TextHtml.class, inForm("#name")).doAction("value='Roman'");
        element(TextHtml.class, inForm("#password")).doAction("value='Jdi1234'");
        element(TextHtml.class, inForm("#login-button")).doAction("click()");

        assertEquals(element(TextHtml.class, withParent("#user-name")).getStyle("visibility"), "visible");
    }
}

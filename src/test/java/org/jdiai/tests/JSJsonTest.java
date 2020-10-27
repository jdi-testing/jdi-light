package org.jdiai.tests;

import com.google.gson.JsonObject;
import org.jdiai.TestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.jdiai.jselement.JSTalk.json;
import static org.testng.Assert.assertEquals;

public class JSJsonTest extends TestInit {
    
    @BeforeMethod
    public void before() {
        atHomePage();
    }

    @Test
    public void oneTest() {
        JsonObject jsObject = json("#user-name").getJson(
            " { \"tag\": element.tagName, \"iText\": element.innerText, \"text\": element.textContent, \"iHtml\": element.innerHTML }");

        assertEquals(jsObject.get("tag").getAsString(), "SPAN");
        assertEquals(jsObject.get("iText").getAsString(), "Roman Iovlev");
        assertEquals(jsObject.get("text").getAsString(), "Roman Iovlev");
        assertEquals(jsObject.get("iHtml").getAsString(), "Roman Iovlev");
    }
    @Test
    public void oneFewLocatorsTest() {
        JsonObject jsObject = json(withParent("#user-name")).getJson(
            " { \"tag\": element.tagName, \"iText\": element.innerText, " +
            "\"text\": element.textContent, \"iHtml\": element.innerHTML }");

        assertEquals(jsObject.get("tag").getAsString(), "SPAN");
        assertEquals(jsObject.get("iText").getAsString(), "Roman Iovlev");
        assertEquals(jsObject.get("text").getAsString(), "Roman Iovlev");
        assertEquals(jsObject.get("iHtml").getAsString(), "Roman Iovlev");
    }

    @Test
    public void styleTest() {
        assertEquals(json("#user-name").getStyle("visibility"), "hidden");

        json(withParent("#user-name")).doAction("click()");
        json(inForm("#name")).doAction("value='Roman'");
        json(inForm("#password")).doAction("value='Jdi1234'");
        json(inForm("#login-button")).doAction("click()");

        assertEquals(json("#user-name").getStyle("visibility"), "visible");
    }
    @Test
    public void styleMultiTest() {
        assertEquals(json(withParent("#user-name")).getStyle("visibility"), "hidden");

        json(withParent("#user-name")).doAction("click()");
        json(inForm("#name")).doAction("value='Roman'");
        json(inForm("#password")).doAction("value='Jdi1234'");
        json(inForm("#login-button")).doAction("click()");

        assertEquals(json(withParent("#user-name")).getStyle("visibility"), "visible");
    }
}

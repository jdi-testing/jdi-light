package org.jdiai.tests;

import com.google.gson.JsonObject;
import org.jdiai.TestInit;
import org.jdiai.entities.Header;
import org.jdiai.entities.HeaderRaw;
import org.jdiai.entities.TextHtml;
import org.jdiai.entities.TextInfo;
import org.jdiai.jsproducer.Json;
import org.jdiai.jswraper.JSElement;
import org.jdiai.jswraper.JSSmart;
import org.jdiai.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jdiai.Pages.DOMAIN;
import static org.jdiai.Pages.SIMPLE_PAGE;
import static org.jdiai.jswraper.JSWrapper.$;
import static org.jdiai.states.States.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(TestNGListener.class)
public class JSSmartTests implements TestInit {
    @BeforeMethod
    public void before() {
        logout();
        atHomePage();
    }

    @Test
    public void entityFromJsonTest() {
        TextInfo jsObject = $(TextInfo.class, "#user-name").getEntity(
        "{ 'tag': element.tagName, 'iText': element.innerText, " +
            "'text': element.textContent, 'iHtml': element.innerHTML }");

        assertEquals(jsObject.tag, "SPAN");
        assertEquals(jsObject.iText, "Roman Iovlev");
        assertEquals(jsObject.text, "Roman Iovlev");
        assertEquals(jsObject.iHtml, "Roman Iovlev");
    }
    @Test
    public void entityFromJsonLocatorListTest() {
        TextInfo jsObject = $(TextInfo.class, withParent("#user-name")).getEntity(
        "{ 'tag': element.tagName, 'iText': element.innerText, " +
            "'text': element.textContent, 'iHtml': element.innerHTML }");

        assertEquals(jsObject.tag, "SPAN");
        assertEquals(jsObject.iText, "Roman Iovlev");
        assertEquals(jsObject.text, "Roman Iovlev");
        assertEquals(jsObject.iHtml, "Roman Iovlev");
    }
    @Test
    public void entityFromAttributesTest() {
        TextHtml jsObject = $(TextHtml.class, "#user-name")
            .getEntity(asList("tagName", "innerText", "textContent", "innerHTML"));

        assertEquals(jsObject.tagName, "SPAN");
        assertEquals(jsObject.innerText, "Roman Iovlev");
        assertEquals(jsObject.textContent, "Roman Iovlev");
        assertEquals(jsObject.innerHTML, "Roman Iovlev");
    }
    @Test
    public void entityFromAttributesLocatorListTest() {
        TextHtml jsObject = $(TextHtml.class, withParent("#user-name"))
            .getEntity(asList("tagName", "innerText", "textContent", "innerHTML"));

        assertEquals(jsObject.tagName, "SPAN");
        assertEquals(jsObject.innerText, "Roman Iovlev");
        assertEquals(jsObject.textContent, "Roman Iovlev");
        assertEquals(jsObject.innerHTML, "Roman Iovlev");
    }
    private Header expectedHeader() {
        return new Header().set(h-> { h.text = "Name"; h.visibility = ""; h.tag = "TH"; });
    }
    private HeaderRaw expectedHeaderRaw() {
        return new HeaderRaw().set(h-> { h.innerText = "Name"; h.className = ""; h.tagName = "TH"; });
    }

    @Test
    public void multiEntitiesTest() {
        loggedInAt(SIMPLE_PAGE);
        List<Header> headers = $(Header.class, "#furniture-double-hidden th")
            .getEntityList("{ 'text': element.innerText, 'visibility': element.className, 'tag': element.tagName }");
        assertEquals(headers.size(), 4);
        assertEquals(headers.get(0), expectedHeader());
    }
    @Test
    public void multiEntitiesLocatorListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<Header> headers = $(Header.class, "#furniture-double-hidden", "th")
            .getEntityList("{ 'text': element.innerText, 'visibility': element.className, 'tag': element.tagName }");
        assertEquals(headers.size(), 4);
        assertEquals(headers.get(0), expectedHeader());
    }
    @Test
    public void multiEntitiesByAttrTest() {
        loggedInAt(SIMPLE_PAGE);
        List<HeaderRaw> headers = $(HeaderRaw.class, "#furniture-double-hidden th")
            .getEntityList(asList("innerText", "className", "tagName"));
        assertEquals(headers.size(), 4);
        assertEquals(headers.get(0), expectedHeaderRaw());
    }
    @Test
    public void multiEntitiesByAttrLocatorListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<HeaderRaw> headers = $(HeaderRaw.class, "#furniture-double-hidden", "th")
            .getEntityList(asList("innerText", "className", "tagName"));
        assertEquals(headers.size(), 4);

        assertEquals(headers.get(0), expectedHeaderRaw());
    }


    @Test
    public void jsonTest() {
        JsonObject json = $("#user-icon")
            .getJson("{ 'id': element.id, 'source': element.src, 'tag': element.tagName }");
        assertEquals(json.get("id").getAsString(), "user-icon");
        assertEquals(json.get("source").getAsString(), DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(json.get("tag").getAsString(), "IMG");
    }
    @Test
    public void jsonLocatorListTest() {
        JsonObject json = $(withParent("#user-icon"))
            .getJson("{ 'id': element.id, 'source': element.src, 'tag': element.tagName }");
        assertEquals(json.get("id").getAsString(), "user-icon");
        assertEquals(json.get("source").getAsString(), DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(json.get("tag").getAsString(), "IMG");
    }
    @Test
    public void jsonMultiTest() {
        loggedInAt(SIMPLE_PAGE);
        List<JsonObject> headers = $("#furniture-double-hidden th")
            .getJsonList("{ 'text': element.innerText, 'class': element.className, 'tag': element.tagName }");
        assertEquals(headers.size(), 4);

        assertEquals(headers.get(0).get("text").getAsString(), "Name");
        assertEquals(headers.get(0).get("class").getAsString(), "");
        assertEquals(headers.get(0).get("tag").getAsString(), "TH");
    }
    @Test
    public void jsonMultiLocatorListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<JsonObject> headers = $("#furniture-double-hidden", "th")
            .getJsonList("{ 'text': element.innerText, 'class': element.className, 'tag': element.tagName }");
        assertEquals(headers.size(), 4);

        assertEquals(headers.get(0).get("text").getAsString(), "Name");
        assertEquals(headers.get(0).get("class").getAsString(), "");
        assertEquals(headers.get(0).get("tag").getAsString(), "TH");
    }
    private JSSmart userName() {
        JSSmart userName = $("#user-name");
        userName.setEntity(TextHtml.class);
        return userName;
    }
    private JSSmart userNameInfo() {
        JSSmart userName = $("#user-name");
        userName.setEntity(TextInfo.class);
        return userName;
    }
    @Test
    public void smartFromJsonTest() {;
        TextInfo jsObject = userNameInfo().getEntity(
    "{ 'tag': element.tagName, 'iText': element.innerText, " +
            "'text': element.textContent, 'iHtml': element.innerHTML }");

        assertEquals(jsObject.tag, "SPAN");
        assertEquals(jsObject.iText, "Roman Iovlev");
        assertEquals(jsObject.text, "Roman Iovlev");
        assertEquals(jsObject.iHtml, "Roman Iovlev");
    }
    @Test
    public void smartFromAttributesTest() {
        TextHtml jsObject = userName().getEntity(asList("tagName", "innerText", "textContent", "innerHTML"));

        assertEquals(jsObject.tagName, "SPAN");
        assertEquals(jsObject.innerText, "Roman Iovlev");
        assertEquals(jsObject.textContent, "Roman Iovlev");
        assertEquals(jsObject.innerHTML, "Roman Iovlev");
    }
    private JSSmart header() {
        JSSmart userName = $("#furniture-double-hidden th");
        userName.setEntity(Header.class);
        return userName;
    }
    private JSSmart headerRaw() {
        JSSmart userName = $("#furniture-double-hidden th");
        userName.setEntity(HeaderRaw.class);
        return userName;
    }
    @Test
    public void smartMultiEntitiesTest() {
        loggedInAt(SIMPLE_PAGE);
        List<Header> headers = header().getEntityList("{ 'text': element.innerText, 'visibility': element.className, 'tag': element.tagName }");
        assertEquals(headers.size(), 4);
        assertEquals(headers.get(0), expectedHeader());
    }
    @Test
    public void smartMultiEntitiesByAttrTest() {
        loggedInAt(SIMPLE_PAGE);
        List<HeaderRaw> headers = headerRaw().getEntityList(asList("innerText", "className", "tagName"));
        assertEquals(headers.size(), 4);
        assertEquals(headers.get(0), expectedHeaderRaw());
    }

    @Test
    public void doActionTest() {
        $(TextInfo.class, "#user-name").doAction("click()");
        $(TextInfo.class, "#name").doAction("value='Roman'");
        $(TextInfo.class, "#password").doAction("value='Jdi1234'");
        $(TextInfo.class, "#login-button").doAction("click()");
    }
    @Test
    public void doActionLocatorListTest() {
        $(TextInfo.class, withParent("#user-name")).doAction("click()");
        $(TextInfo.class, inForm("#name")).doAction("value='Roman'");
        $(TextInfo.class, inForm("#password")).doAction("value='Jdi1234'");
        $(TextInfo.class, inForm("#login-button")).doAction("click()");
    }
    @Test
    public void attributeTest() {
        assertEquals($(TextInfo.class, "#user-icon").getAttribute("tagName"), "IMG");

        JSElement userName = $(TextInfo.class, "#user-name");
        assertEquals(userName.getAttribute("innerText"), "Roman Iovlev");
        assertEquals(userName.getAttribute("textContent"), "Roman Iovlev");
        assertEquals(userName.getAttribute("innerHTML"), "Roman Iovlev");
    }
    @Test
    public void attributeLocatorListTest() {
        assertEquals($(TextInfo.class, withParent("#user-icon")).getAttribute("tagName"), "IMG");

        JSElement userName = $(TextInfo.class, withParent("#user-name"));
        assertEquals(userName.getAttribute("innerText"), "Roman Iovlev");
        assertEquals(userName.getAttribute("textContent"), "Roman Iovlev");
        assertEquals(userName.getAttribute("innerHTML"), "Roman Iovlev");
    }
    @Test
    public void valueTest() {
        boolean isVisible = $(TextInfo.class, "#user-icon").getValue(
            "element !== null && styles.visibility === 'visible' && styles.display !== 'none'")
            .equalsIgnoreCase("true");
        assertTrue(isVisible);
    }
    @Test
    public void valueLocatorListTest() {
        boolean isVisible = $(TextInfo.class, withParent("#user-icon")).getValue(
            "element !== null && styles.visibility === 'visible' && styles.display !== 'none'")
            .equalsIgnoreCase("true");
        assertTrue(isVisible);
    }
    @Test
    public void attributeListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<String> headers = $(TextInfo.class, "#products th").getAttributeList("innerText");
        assertEquals(headers.size(), 4);
        assertEquals(headers.toString(), "[Name, Type, Cost, Weight]");
    }
    @Test
    public void attributesListLocatorListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<String> headers = $(TextInfo.class, "#products", "th").getAttributeList("innerText");
        assertEquals(headers.size(), 4);
        assertEquals(headers.toString(), "[Name, Type, Cost, Weight]");
    }
    @Test
    public void attributesTest() {
        Json attributes = $(TextInfo.class, "#user-icon").getAttributes("id", "src", "tagName");
        assertEquals(attributes.get("id"), "user-icon");
        assertEquals(attributes.get("src"), DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(attributes.get("tagName"), "IMG");
    }
    @Test
    public void attributesLocatorListTest() {
        Json attributes = $(TextInfo.class, withParent("#user-icon")).getAttributes("id", "src", "tagName");
        assertEquals(attributes.get("id"), "user-icon");
        assertEquals(attributes.get("src"), DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(attributes.get("tagName"), "IMG");
    }
    @Test
    public void multiAttributesTest() {
        loggedInAt(SIMPLE_PAGE);
        List<Json> headers = $(TextInfo.class, "#furniture-double-hidden th").getMultiAttributes("innerText", "className ", "tagName");
        assertEquals(headers.size(), 4);

        assertEquals(headers.get(0).get("innerText"), "Name");
        assertEquals(headers.get(0).get("className "), "");
        assertEquals(headers.get(0).get("tagName"), "TH");
    }
    @Test
    public void multiAttributesLocatorListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<Json> headers = $(TextInfo.class, "#furniture-double-hidden", "th").getMultiAttributes("innerText", "className", "tagName");
        assertEquals(headers.size(), 4);

        assertEquals(headers.get(0).get("innerText"), "Name");
        assertEquals(headers.get(0).get("className"), "");
        assertEquals(headers.get(0).get("tagName"), "TH");
    }

    @Test
    public void styleTest() {
        String visibility = $(TextInfo.class, "#user-name").getStyle("visibility");
        assertEquals(visibility, "hidden");

        login();
        visibility = $(TextInfo.class, "#user-name").getStyle("visibility");
        assertEquals(visibility, "visible");
    }
    @Test
    public void allStylesTest() {
        Json styles = $(TextInfo.class, "#user-name").getAllStyles();
        assertTrue(styles.size() > 10);
        String visibility = styles.get("visibility");
        assertEquals(visibility, "hidden");
    }
    @Test
    public void styleLocatorListTest() {
        String visibility = $(TextInfo.class, withParent("#user-name")).getStyle("visibility");
        assertEquals(visibility, "hidden");

        login();
        visibility = $(TextInfo.class, withParent("#user-name")).getStyle("visibility");
        assertEquals(visibility, "visible");
    }
    @Test
    public void stylesTest() {
        Json styles = $(TextInfo.class, "#user-icon").getStyles("color", "display", "fontSize");
        assertEquals(styles.get("color"), "rgb(204, 204, 204)");
        assertEquals(styles.get("display"), "block");
        assertEquals(styles.get("fontSize"), "15px");
    }
    @Test
    public void stylesLocatorListTest() {
        Json styles = $(TextInfo.class, withParent("#user-icon")).getStyles("color", "display", "fontSize");
        assertEquals(styles.get("color"), "rgb(204, 204, 204)");
        assertEquals(styles.get("display"), "block");
        assertEquals(styles.get("fontSize"), "15px");
    }
    @Test
    public void stylesListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<String> visibility = $(TextInfo.class, "#furniture-double-hidden th").getStylesList("visibility");
        assertEquals(visibility.size(), 4);
        assertEquals(visibility.get(0), "visible");
    }
    @Test
    public void stylesListLocatorListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<String> visibility = $(TextInfo.class, "#furniture-double-hidden", "th").getStylesList("visibility");
        assertEquals(visibility.size(), 4);
        assertEquals(visibility.get(0), "visible");
    }
    @Test
    public void multiStylesTest() {
        loggedInAt(SIMPLE_PAGE);
        List<Json> visibility = $(TextInfo.class, "#furniture-double-hidden th").getMultiStyles("visibility", "display");
        assertEquals(visibility.size(), 4);

        assertEquals(visibility.get(0).get("visibility"), "visible");
        assertEquals(visibility.get(0).get("display"), "table-cell");
    }
    @Test
    public void multiStylesLocatorListTest() {
        loggedInAt(SIMPLE_PAGE);
        List<Json> visibility = $(TextInfo.class, "#furniture-double-hidden", "th").getMultiStyles("visibility", "display");
        assertEquals(visibility.size(), 4);

        assertEquals(visibility.get(0).get("visibility"), "visible");
        assertEquals(visibility.get(0).get("display"), "table-cell");
    }
}

package com.jdiai.tests;

import com.google.gson.JsonObject;
import com.jdiai.TestInit;
import com.jdiai.entities.Link;
import com.jdiai.jsdriver.JSDriver;
import com.jdiai.testng.TestNGListener;
import com.jdiai.tools.map.MapArray;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.jdiai.Pages.DOMAIN;
import static com.jdiai.states.States.atHomePage;
import static com.jdiai.states.States.logout;
import static com.jdiai.tools.LinqUtils.map;
import static com.jdiai.tools.PrintUtils.print;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

@Listeners(TestNGListener.class)
public class JSDriverTests implements TestInit {

    @BeforeMethod
    public void before() {
        logout();
        atHomePage();
    }

    @Test
    public void oneTest() {
        assertEquals(js("#user-icon").getOne("element.tagName").asString(), "IMG");
        assertEquals(js("#user-name").getOne("element.innerText").asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getOne("element.textContent").asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getOne("element.innerHTML").asString(), "Roman Iovlev");
        assertEquals(getStyle(js("#user-name"), "visibility"), "hidden");

        js("#user-name").getOne("element.click()");
        js("#name").getOne("element.value='Roman'");
        js("#password").getOne("element.value='Jdi1234'");
        js("#login-button").getOne("element.click()");

        assertEquals(getStyle(js("#user-name"), "visibility"), "visible");
    }
    
    @Test
    public void chainTest() {
        assertEquals(js("#user-icon").getOne("element.tagName").asString(), "IMG");
        assertEquals(js("#user-name").getOne("element.innerText").asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getOne("element.textContent").asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getOne("element.innerHTML").asString(), "Roman Iovlev");
        assertEquals(getStyle(js("#user-name"), "visibility"), "hidden");


        js("#user-name").getOne("element.click()");
        js("#name").getOne("element.value='Roman'");
        js("#password").getOne("element.value='Jdi1234'");
        js("#login-button").getOne("element.click()");

        assertEquals(getStyle(js("#user-name"), "visibility"), "visible");
    }
    @Test
    public void multiTest() {
        assertEquals(jsMulti("#user-icon").getOne("element.tagName").asString(), "IMG");
        assertEquals(jsMulti("#user-name").getOne("element.innerText").asString(), "Roman Iovlev");
        assertEquals(jsMulti("#user-name").getOne("element.textContent").asString(), "Roman Iovlev");
        assertEquals(jsMulti("#user-name").getOne("element.innerHTML").asString(), "Roman Iovlev");
        assertEquals(getStyle(js("#user-name"), "visibility"), "hidden");


        jsMulti("#user-name").getOne("element.click()");
        jsMulti("#name").getOne("element.value='Roman'");
        jsMulti("#password").getOne("element.value='Jdi1234'");
        jsMulti("#login-button").getOne("element.click()");

        assertEquals(getStyle(js("#user-name"), "visibility"), "visible");
    }
    @Test
    public void oneFewLocatorsTest() {
        assertEquals(js(withParent("#user-icon")).getOne("element.tagName").asString(), "IMG");
        assertEquals(js(withParent("#user-name")).getOne("element.innerText").asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOne("element.textContent").asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOne("element.innerHTML").asString(), "Roman Iovlev");
        assertEquals(getStyle(js("#user-name"), "visibility"), "hidden");

        js(withParent("#user-name")).getOne("element.click()");
        js(inForm("#name")).getOne("element.value='Roman'");
        js(inForm("#password")).getOne("element.value='Jdi1234'");
        js(inForm("#login-button")).getOne("element.click()");

        assertEquals(getStyle(js(withParent("#user-name")), "visibility"), "visible");
    }
    @Test
    public void chainFewLocatorsTest() {
        assertEquals(js(withParent("#user-icon")).getOne("element.tagName").asString(), "IMG");
        assertEquals(js(withParent("#user-name")).getOne("element.innerText").asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOne("element.textContent").asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOne("element.innerHTML").asString(), "Roman Iovlev");
        assertEquals(getStyle(js("#user-name"), "visibility"), "hidden");

        js(withParent("#user-name")).getOne("element.click()");
        js(inForm("#name")).getOne("element.value='Roman'");
        js(inForm("#password")).getOne("element.value='Jdi1234'");
        js(inForm("#login-button")).getOne("element.click()");

        assertEquals(getStyle(js(withParent("#user-name")), "visibility"), "visible");
    }
    @Test
    public void multiFewLocatorsTest() {
        assertEquals(jsMulti(withParent("#user-icon")).getOne("element.tagName").asString(), "IMG");
        assertEquals(jsMulti(withParent("#user-name")).getOne("element.innerText").asString(), "Roman Iovlev");
        assertEquals(jsMulti(withParent("#user-name")).getOne("element.textContent").asString(), "Roman Iovlev");
        assertEquals(jsMulti(withParent("#user-name")).getOne("element.innerHTML").asString(), "Roman Iovlev");
        assertEquals(getStyle(js("#user-name"), "visibility"), "hidden");

        jsMulti(withParent("#user-name")).getOne("element.click()");
        jsMulti(inForm("#name")).getOne("element.value='Roman'");
        jsMulti(inForm("#password")).getOne("element.value='Jdi1234'");
        jsMulti(inForm("#login-button")).getOne("element.click()");

        assertEquals(getStyle(js(withParent("#user-name")), "visibility"), "visible");
    }
    @Test
    public void toObjectTests() {
        JsonObject json = js("#user-icon").getOne("{ 'tag': element.tagName, 'ref': element.src }").asJson();
        Link link = js("#user-icon").getOne("{ 'tag': element.tagName, 'ref': element.src }").asObject(Link.class);
        assertEquals(link.tag, "IMG");
        assertEquals(link.ref, DOMAIN + "/images/icons/user-icon.jpg");
        assertEquals(json.get("ref").getAsString(), link.ref);
    }
    @Test
    public void getStylesTests() {
        MapArray<String, String> styles = getStyles(js("#user-icon"), "color", "display", "fontSize");
        assertEquals(styles.get("color"), "rgb(204, 204, 204)");
        assertEquals(styles.get("display"), "block");
        assertEquals(styles.get("fontSize"), "15px");
    }

    private String getStyle(JSDriver driver, String style) {
        return driver.getOne("{ 'style': getComputedStyle(element)." + style + " }").asJson().get("style").getAsString();
    }
    private MapArray<String, String> getStyles(JSDriver driver, List<String> styles) {
        String jsonObject = "{ " + print(map(styles, el -> "'" + el + "': getComputedStyle(element)." + el), ", ") + " }";
        JsonObject json = driver.getOne(jsonObject).asJson();
        return new MapArray<>(styles, s -> s, s -> json.get(s).getAsString());
    }
    private MapArray<String, String> getStyles(JSDriver driver, String... styles) {
        return getStyles(driver, asList(styles));
    }
}
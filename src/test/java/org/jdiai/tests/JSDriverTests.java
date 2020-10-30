package org.jdiai.tests;

import com.epam.jdi.tools.map.MapArray;
import com.google.gson.JsonObject;
import org.jdiai.TestInit;
import org.jdiai.entity.Link;
import org.jdiai.jsdriver.JSDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

public class JSDriverTests extends TestInit {

    @BeforeMethod
    public void before() {
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
        assertEquals(js("#user-icon").getOneChain("element.tagName").asString(), "IMG");
        assertEquals(js("#user-name").getOneChain("element.innerText").asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getOneChain("element.textContent").asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getOneChain("element.innerHTML").asString(), "Roman Iovlev");
        assertEquals(getStyle(js("#user-name"), "visibility"), "hidden");


        js("#user-name").getOneChain("element.click()");
        js("#name").getOneChain("element.value='Roman'");
        js("#password").getOneChain("element.value='Jdi1234'");
        js("#login-button").getOneChain("element.click()");

        assertEquals(getStyle(js("#user-name"), "visibility"), "visible");
    }
    @Test
    public void multiTest() {        
        assertEquals(js("#user-icon").getOneMultiSearch("element.tagName").asString(), "IMG");
        assertEquals(js("#user-name").getOneMultiSearch("element.innerText").asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getOneMultiSearch("element.textContent").asString(), "Roman Iovlev");
        assertEquals(js("#user-name").getOneMultiSearch("element.innerHTML").asString(), "Roman Iovlev");
        assertEquals(getStyle(js("#user-name"), "visibility"), "hidden");


        js("#user-name").getOneMultiSearch("element.click()");
        js("#name").getOneMultiSearch("element.value='Roman'");
        js("#password").getOneMultiSearch("element.value='Jdi1234'");
        js("#login-button").getOneMultiSearch("element.click()");

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
        assertEquals(js(withParent("#user-icon")).getOneChain("element.tagName").asString(), "IMG");
        assertEquals(js(withParent("#user-name")).getOneChain("element.innerText").asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOneChain("element.textContent").asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOneChain("element.innerHTML").asString(), "Roman Iovlev");
        assertEquals(getStyle(js("#user-name"), "visibility"), "hidden");

        js(withParent("#user-name")).getOneChain("element.click()");
        js(inForm("#name")).getOneChain("element.value='Roman'");
        js(inForm("#password")).getOneChain("element.value='Jdi1234'");
        js(inForm("#login-button")).getOneChain("element.click()");

        assertEquals(getStyle(js(withParent("#user-name")), "visibility"), "visible");
    }
    @Test
    public void multiFewLocatorsTest() {
        assertEquals(js(withParent("#user-icon")).getOneMultiSearch("element.tagName").asString(), "IMG");
        assertEquals(js(withParent("#user-name")).getOneMultiSearch("element.innerText").asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOneMultiSearch("element.textContent").asString(), "Roman Iovlev");
        assertEquals(js(withParent("#user-name")).getOneMultiSearch("element.innerHTML").asString(), "Roman Iovlev");
        assertEquals(getStyle(js("#user-name"), "visibility"), "hidden");

        js(withParent("#user-name")).getOneMultiSearch("element.click()");
        js(inForm("#name")).getOneMultiSearch("element.value='Roman'");
        js(inForm("#password")).getOneMultiSearch("element.value='Jdi1234'");
        js(inForm("#login-button")).getOneMultiSearch("element.click()");

        assertEquals(getStyle(js(withParent("#user-name")), "visibility"), "visible");
    }
    @Test
    public void toObjectTests() {
        JsonObject json = js("#user-icon").getOne("{ \"tag\": element.tagName, \"ref\": element.src }").asJson();
        Link link = js("#user-icon").getOne("{ \"tag\": element.tagName, \"ref\": element.src }").asObject(Link.class);
        assertEquals(link.tag, "IMG");
        assertEquals(link.ref, "https://jdi-testing.github.io/jdi-light/images/icons/user-icon.jpg");
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
        return driver.getOne("{ \"style\": getComputedStyle(element)." + style + " }").asJson().get("style").getAsString();
    }
    private MapArray<String, String> getStyles(JSDriver driver, List<String> styles) {
        String jsonObject = "{ " + print(map(styles, el -> "\"" + el + "\": getComputedStyle(element)." + el), ", ") + " }";
        JsonObject json = driver.getOne(jsonObject).asJson();
        return new MapArray<>(styles, s -> s, s -> json.get(s).getAsString());
    }
    private MapArray<String, String> getStyles(JSDriver driver, String... styles) {
        return getStyles(driver, asList(styles));
    }
}

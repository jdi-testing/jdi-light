package org.jdiai.tests.jsdriver.driver;

import org.jdiai.jsdriver.JSDriver;
import org.jdiai.jsdriver.jsbuilder.JSBuilder;
import org.jdiai.jsdriver.jsbuilder.SmartBuilderActions;
import org.jdiai.tests.jsdriver.TestInit;
import org.jdiai.tools.locators.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.util.Arrays.asList;
import static org.jdiai.tests.jsdriver.states.States.atHomePage;
import static org.jdiai.tests.jsdriver.states.States.logout;
import static org.jdiai.tools.JSTalk.driver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JSDriverFrameTests extends TestInit {

    @BeforeMethod
    public void before() {
        logout();
        atHomePage();
    }

    @Test
    public void frameTest() {
        JSDriver frameImage = js("frame:#first_frame", "img").setBuilder(new JSBuilder(driver(), new SmartBuilderActions()));
        assertEquals(frameImage.getOne("element.tagName").asString(), "IMG");
        assertTrue(frameImage.getOne("element.src").asString().contains("wolverin.jpg"));
    }
    @Test
    public void frameInFrameTest() {
        JSDriver frameImage = js("frame:#jdi-frame-site", "frame:#first_frame", "img").setBuilder(new JSBuilder(driver(), new SmartBuilderActions()));
        assertEquals(frameImage.getOne("element.tagName").asString(), "IMG");
        assertTrue(frameImage.getOne("element.src").asString().contains("wolverin.jpg"));
    }
    @Test
    public void byFrameTest() {
        JSDriver frameImage = new JSDriver(driver(), asList(By.frame("first_frame"), By.tag("img")), new SmartBuilderActions());
        assertEquals(frameImage.getOne("element.tagName").asString(), "IMG");
        assertTrue(frameImage.getOne("element.src").asString().contains("wolverin.jpg"));
    }
}
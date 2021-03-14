package org.jdiai.tests;

import org.jdiai.TestInit;
import org.jdiai.jsbuilder.JSBuilder;
import org.jdiai.jsbuilder.SmartBuilderActions;
import org.jdiai.jsdriver.JSDriver;
import org.jdiai.locators.By;
import org.jdiai.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static java.util.Arrays.asList;
import static org.jdiai.DriverManager.driver;
import static org.jdiai.states.States.atHomePage;
import static org.jdiai.states.States.logout;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(TestNGListener.class)
public class JSDriverFrameTests implements TestInit {

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
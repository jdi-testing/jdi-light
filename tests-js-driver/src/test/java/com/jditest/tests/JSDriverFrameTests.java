package com.jditest.tests;

import com.jditest.TestInit;
import com.jditest.jsbuilder.SmartBuilderActions;
import com.jditest.jsdriver.JSDriver;
import com.jditest.locators.By;
import com.jditest.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static java.util.Arrays.asList;
import static com.jditest.DriverManager.driver;
import static com.jditest.states.States.atHomePage;
import static com.jditest.states.States.logout;
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
        JSDriver frameImage = js("frame:#first_frame", "img").updateBuilderActions(new SmartBuilderActions());
        assertEquals(frameImage.getOne("element.tagName").asString(), "IMG");
        assertTrue(frameImage.getOne("element.src").asString().contains("wolverin.jpg"));
    }
    @Test
    public void frameInFrameTest() {
        JSDriver frameImage = js("frame:#jdi-frame-site", "frame:#first_frame", "img").updateBuilderActions(new SmartBuilderActions());
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
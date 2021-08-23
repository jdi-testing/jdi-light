package com.jdiai.tests;

import com.jdiai.TestInit;
import com.jdiai.jsdriver.JSDriver;
import com.jdiai.locators.By;
import com.jdiai.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jdiai.DriverManager.driver;
import static com.jdiai.states.States.atHomePage;
import static com.jdiai.states.States.logout;
import static java.util.Arrays.asList;
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
        JSDriver frameImage = js("frame:#first_frame", "img");
        assertEquals(frameImage.getOne("element.tagName").asString(), "IMG");
        assertTrue(frameImage.getOne("element.src").asString().contains("wolverin.jpg"));
    }
    @Test
    public void frameInFrameTest() {
        JSDriver frameImage = js("frame:#jdi-frame-site", "frame:#first_frame", "img");
        assertEquals(frameImage.getOne("element.tagName").asString(), "IMG");
        assertTrue(frameImage.getOne("element.src").asString().contains("wolverin.jpg"));
    }
    @Test
    public void byFrameTest() {
        JSDriver frameImage = new JSDriver(driver(), asList(By.frame("first_frame"), By.tag("img")));
        assertEquals(frameImage.getOne("element.tagName").asString(), "IMG");
        assertTrue(frameImage.getOne("element.src").asString().contains("wolverin.jpg"));
    }
}
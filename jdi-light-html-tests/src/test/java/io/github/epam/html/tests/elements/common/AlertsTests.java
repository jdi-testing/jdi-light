//package io.github.epam.html.tests.elements.common;
//
//import io.github.epam.TestsInit;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import static com.epam.jdi.light.elements.common.Alerts.*;
//import static io.github.com.StaticSite.html5Page;
//import static io.github.com.pages.HtmlElementsPage.*;
//import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
//import static org.hamcrest.Matchers.*;
//import static org.testng.Assert.assertEquals;
//
///**
// * Created by Roman Iovlev on 19.08.2019
// * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
// */
//
//public class AlertsTests implements TestsInit {
//
//    @BeforeMethod
//    public void before() {
//        shouldBeLoggedIn();
//        html5Page.open();
//
//    }
//
//    @Test
//    public void acceptAlertTest() {
//        redButton.click();
//        acceptAlert();
//        blueButton.click();
//        acceptAlert();
//        refresh();
//        ghostButton.click();
//        acceptAlert();
//    }
//    @Test
//    public void dismissAlertTest() {
//        redButton.click();
//        dismissAlert();
//        blueButton.click();
//        dismissAlert();
//        refresh();
//        ghostButton.click();
//        dismissAlert();
//    }
//    @Test
//    public void getAlertTextTest() {
//        redButton.click();
//        String text = getAlertText();
//        assertEquals(text, "Red button");
//        acceptAlert();
//        blueButton.click();
//        text = getAlertText();
//        assertEquals(text, "Blue button");
//        acceptAlert();
//        refresh();
//        ghostButton.click();
//        text = getAlertText();
//        assertEquals(text, "Ghost button");
//        acceptAlert();
//    }
//
//    @Test
//    public void inputAndAcceptAlertTest() {
//        refresh();
//        ghostButton.click();
//        inputAndAcceptAlert("Some text");
//    }
//
//    @Test
//    public void validateAlertTest() {
//        redButton.click();
//        validateAlert(is("Red button"));
//        redButton.click();
//        validateAlert(equalToIgnoringCase("red button"));
//        redButton.click();
//        validateAlert(containsString("Red"));
//    }
//}

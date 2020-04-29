package com.jdi.tests;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.jdi.TestsInit;
import org.testng.annotations.*;

import static com.epam.jdi.light.elements.common.Alerts.*;
import static com.jdi.states.State.loggedIn;
import static jdisite.enums.MenuOptions.*;
import static jdisite.pages.Html5Page.suspendButton;
import static jdisite.pages.JDISite.*;
import static org.hamcrest.Matchers.is;

public class WaitButtonTests extends TestsInit {
    @BeforeMethod
    public void before() {
        loggedIn();
        leftMenu.select(ElementsPacks, HTML5);
    }
    @Test
    public void waitButtonTest() {
        htmlPage.checkOpened();
        suspendButton.click();
        validateAlert(is("Suspend button"));
    }
}

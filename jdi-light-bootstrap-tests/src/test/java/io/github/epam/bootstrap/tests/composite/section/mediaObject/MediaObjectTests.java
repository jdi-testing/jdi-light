package io.github.epam.bootstrap.tests.composite.section.mediaObject;


import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.switchToWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.windowsCount;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class MediaObjectTests extends TestsInit {

    private static String bodyTextOfMediaObjectSample = "WOLVERINE\nWolverine is a fictional character appearing in American comic books published by Marvel Comics, mostly in association with the X-Men. He is a mutant who possesses animal-keen senses, enhanced physical capabilities, powerful regenerative ability known as a healing factor, and three retractable claws in each hand.";
    private static String bodyTextOfMediaObjectNesting = "IRON MAN\nDonec sed odio dui. Nullam quis risus eget urna mollis ornare vel eu leo.";
    private static String expectedUrl ="https://jdi-testing.github.io/jdi-light/index.html";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(mediaObjectSample);
        baseValidation(mediaObjectNesting);
    }

    @Test
    public void isValidationTestSample() {
        mediaObjectSample.is().displayed();
        mediaObjectSample.is().enabled();
        mediaObjectSample.bodyOfMediaObject.is().text(is(bodyTextOfMediaObjectSample));
        mediaObjectSample.bodyOfMediaObject.is().text(containsString("American comic books"));
        assertThat(mediaObjectSample.mediaHeading.core().css("font-size"), is("20px"));
        assertThat(mediaObjectSample.bodyOfMediaObject.core().css("font-size"), is("14px"));
        mediaObjectSample.bodyOfMediaObject.assertThat().displayed()
                .and().text(is(bodyTextOfMediaObjectSample))
                .core()
                .css("font-size", is("14px"))
                .cssClass("media-body")
        ;

    }

    @Test
    public void isValidationTestNesting() {
        mediaObjectNesting.is().displayed();
        mediaObjectNesting.is().enabled();
        mediaObjectNesting.listOfMediaObjectNesting.get(0).bodyOfMediaObject.is().text(is(bodyTextOfMediaObjectNesting));
        mediaObjectNesting.listOfMediaObjectNesting.get(0).bodyOfMediaObject.is().text(containsString("vel eu leo"));
        assertThat(mediaObjectNesting.listOfMediaObjectNesting.get(0).mediaHeading.core().css("font-size"), is("20px"));
        assertThat(mediaObjectNesting.listOfMediaObjectNesting.get(0).bodyOfMediaObject.core().css("font-size"), is("14px"));
        mediaObjectNesting.listOfMediaObjectNesting.get(0).bodyOfMediaObject.assertThat().displayed()
                .and().text(is(bodyTextOfMediaObjectNesting))
                .core()
                .css("font-size", is("14px"))
                .cssClass("media-body")
        ;

    }

    @Test
    public void clickTest() {
        mediaObjectNesting.listOfMediaObjectNesting.get(0).image.click();
        assertThat(2, is(windowsCount()));
        switchToWindow(2);
        assertThat(getUrl(), is(expectedUrl));
    }



}

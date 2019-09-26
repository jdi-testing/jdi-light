package io.github.epam.bootstrap.tests.composite.section.mediaObject;


import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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
    private static List<String> listOfHeading = Arrays.asList("WOLVERINE FIRST", "IRON MAN SECOND", "SPIDER MAN THIRD");

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationSampleTest() {
        baseValidation(mediaObjectSample);
    }

    @Test
    public void baseValidationNestingTest() {
        baseValidation(mediaObjectNesting);
    }

    @Test
    public void isValidationTestSample() {
        mediaObjectSample.is().displayed();
        mediaObjectSample.is().enabled();
        mediaObjectSample.bodyOfMediaObject.is().text(is(bodyTextOfMediaObjectSample));
        mediaObjectSample.bodyOfMediaObject.is().text(containsString("American comic books"));
        assertThat(mediaObjectSample.headingOfMediaObject.core().css("font-size"), is("20px"));
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
        mediaObjectNesting.nestingMediaObject.bodyOfMediaObject.is().text(is(bodyTextOfMediaObjectNesting));
        mediaObjectNesting.nestingMediaObject.bodyOfMediaObject.is().text(containsString("vel eu leo"));
        assertThat(mediaObjectNesting.nestingMediaObject.headingOfMediaObject.core().css("font-size"), is("20px"));
        assertThat(mediaObjectNesting.nestingMediaObject.bodyOfMediaObject.core().css("font-size"), is("14px"));
        mediaObjectNesting.nestingMediaObject.bodyOfMediaObject.assertThat().displayed()
                .and().text(is(bodyTextOfMediaObjectNesting))
                .core()
                .css("font-size", is("14px"))
                .cssClass("media-body")
        ;

    }

    @Test
    public void isValidationTestListMediaObject() {
        mediaObjectList.is().displayed();
        mediaObjectList.is().enabled();
        mediaObjectList.get(2).headingOfMediaObject.is().text(is(listOfHeading.get(1)));
        mediaObjectList.get(2).bodyOfMediaObject.is().text(containsString("Stark requires"));
        assertThat(mediaObjectList.get(3).headingOfMediaObject.core().css("font-size"), is("20px"));
        assertThat(mediaObjectList.get(2).bodyOfMediaObject.core().css("font-size"), is("14px"));
        mediaObjectList.assertThat().displayed()
                .core()
                .css("font-size", is("14px"))
        ;

    }

    @Test
    public void clickTest() {
        mediaObjectNesting.nestingMediaObject.imageOfMediaObject.click();
        assertThat(2, is(windowsCount()));
        switchToWindow(2);
        assertThat(getUrl(), is(expectedUrl));
    }
}

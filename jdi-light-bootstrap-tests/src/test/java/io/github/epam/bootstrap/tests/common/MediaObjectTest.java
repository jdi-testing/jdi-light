package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.mediaObjectSample;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class MediaObjectTest extends TestsInit {

    private static String  bodyTextOfMediaObjectSample = "Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void isValidationTest() {
        mediaObjectSample.is().displayed();
        mediaObjectSample.is().enabled();
        mediaObjectSample.bodyOfMediaObject.is().text(is(bodyTextOfMediaObjectSample));
        mediaObjectSample.bodyOfMediaObject.is().text(containsString("sit amet nibh libero,"));
        assertThat(mediaObjectSample.mediaHeading.core().css("font-size"), is("20px"));
        assertThat(mediaObjectSample.bodyOfMediaObject.core().css("font-size"), is("14px"));
        mediaObjectSample.bodyOfMediaObject.assertThat().displayed()
                .and().text(is(bodyTextOfMediaObjectSample))
                .core()
                //.css("font-size", is("16px"))
               // .cssClass("media-body")
              //  .attr("type", "button")
             //   .tag(is("button"))
        ;

    }

}
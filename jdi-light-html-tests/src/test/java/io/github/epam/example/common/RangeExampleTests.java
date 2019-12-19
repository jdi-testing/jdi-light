package io.github.epam.example.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledRange;
import static io.github.com.pages.HtmlElementsPage.volume;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class RangeExampleTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        volume.setVolume(90);
    }

    @Test
    public void checkRangeTest() {
        volume
                .assertThat()
                .enabled()
                .displayed();
        disabledRange
                .assertThat()
                .disabled()
                .displayed();
    }

    @Test
    public void checkRangeVolumeTest() {
        disabledRange.assertThat().volume(50);
        volume.assertThat().volume(90);
        volume.is().volume(greaterThanOrEqualTo(10));
        volume.is().volume(lessThanOrEqualTo(100));
    }

    @Test
    public void checkMinTest() {
        volume.assertThat().minVolume(10);
        volume.assertThat().minVolume(is(10));
    }

    @Test
    public void checkMaxTest() {
        volume.assertThat().maxVolume(100);
        volume.assertThat().maxVolume(is(100));
    }

    @Test
    public void checkStepTest() {
        volume.assertThat().step(5);
        volume.assertThat().step(is(5));
    }

    @Test
    public void setVolumeTest() {
        volume.setVolume(10);
        volume.assertThat().volume(10);
    }

    @Test
    public void labelTest() {
        volume.label().is().text("Volume");
        volume.label().is().text(containsString("lume"));
        volume.label().assertThat().text(equalToIgnoringCase("volume"));
    }
}

package io.github.epam.vuetify.tests.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.parallaxPage;
import static io.github.com.pages.ParallaxPage.contentParallax;
import static io.github.com.pages.ParallaxPage.customHeightParallax;


public class ParallaxTests extends TestsInit {

    @BeforeClass
    public void before() {
        parallaxPage.open();
        parallaxPage.checkOpened();
    }

    @Test
    public void contentParallaxTests() {
        contentParallax.has().content();
        String expectedHeader = "Vuetify";
        String expectedSubheader = "Build your application today!";

        contentParallax.getHeader().is().text(expectedHeader);
        contentParallax.getSubheader().is().text(expectedSubheader);
    }

    @Test
    public void customHeightParallaxTests() {
        customHeightParallax.has().noContent();

        int expectedHeight = 300;
        customHeightParallax.has().height(expectedHeight);
    }
}

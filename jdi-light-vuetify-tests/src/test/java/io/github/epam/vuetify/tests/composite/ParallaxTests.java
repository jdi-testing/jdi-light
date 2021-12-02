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
//        contentParallax.has().noContent();
        contentParallax.has().content();
    }

    @Test
    public void customHeightParallaxTests() {
        customHeightParallax.has().noContent();
//        customHeightParallax.has().content();

        int expectedHeight = 300;
        customHeightParallax.has().height(expectedHeight);
    }
}

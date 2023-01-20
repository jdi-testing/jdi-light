package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.aspectRatiosPage;
import static io.github.com.pages.AspectRatiosPage.aspectRatiosContainer;

public class AspectRatiosTests extends TestsInit {

    @BeforeClass
    public void before() {
        aspectRatiosPage.open();
        waitCondition(() -> aspectRatiosPage.isOpened());
        aspectRatiosPage.checkOpened();
    }

    @Test
    public void aspectRatioImageTests() {
        aspectRatiosContainer.has().ratio(16, 9);
    }

}

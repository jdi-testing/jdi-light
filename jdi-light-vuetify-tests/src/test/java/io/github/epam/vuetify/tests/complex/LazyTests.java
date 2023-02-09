package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.lazyPage;
import static io.github.com.pages.LazyPage.lazyContent;
import static io.github.com.pages.LazyPage.lazyCard;
import static org.hamcrest.Matchers.containsString;

public class LazyTests extends TestsInit {

    @BeforeClass
    public void before() {
        lazyPage.open();
        waitCondition(() -> lazyPage.isOpened());
        lazyPage.checkOpened();
    }

    @Test(description = "Test checks that card will not render its contents until it has been intersected")
    public void itemIsLoadedTest() {
        lazyCard.is().notVisible();
        lazyContent.show();
        lazyCard.is().displayed();
        lazyCard.title().is().text("Card title");
        lazyCard.content().has().text(containsString("Aliquam lobortis"));
    }
}

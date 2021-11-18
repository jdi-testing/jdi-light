package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.lazyPage;
import static io.github.com.pages.LazyPage.*;

public class LazyTests extends TestsInit {

    @BeforeClass
    public void before() {
        lazyPage.open();
    }

    @Test
    public void itemIsHiddenTest() {
        lazy.is().hidden();
    }

    @Test
    public void itemIsLoadedTest() {
        lazy.scrollIntoView();
        lazy.is().displayed();
        lazy.hiddenItem().is().displayed();
        lazy.core().find(ITEM_TITLE).has().text("Card title");
        lazy.core().find(ITEM_TEXT).is().displayed();
        lazy.core().find(ITEM_TEXT).has().text(Matchers.containsString("Aliquam lobortis"));

    }
}

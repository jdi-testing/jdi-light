package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.lazyPage;
import static io.github.com.pages.LazyPage.ITEM_TEXT;
import static io.github.com.pages.LazyPage.ITEM_TITLE;
import static io.github.com.pages.LazyPage.lazy;


public class LazyTests extends TestsInit {

    @BeforeClass
    public void before() {
        lazyPage.open();
        waitCondition(() -> lazyPage.isOpened());
        lazyPage.checkOpened();
    }

    @Test
    public void itemIsHiddenTest() {
        waitCondition(() -> lazy.isExist());
        lazy.is().notVisible();
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

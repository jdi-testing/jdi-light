package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.lazyPage;
import static io.github.com.pages.LazyPage.lazyCard;
import static io.github.com.pages.LazyPage.scrollDownText;
import static org.hamcrest.Matchers.containsString;


public class LazyTests extends TestsInit {

    @BeforeClass
    public void before() {
        lazyPage.open();
        waitCondition(() -> lazyPage.isOpened());
        lazyPage.checkOpened();
    }

    @Test
    public void itemIsHiddenTest() {
        lazyCard.has().notExistContent();
    }

    @Test
    public void itemIsLoadedTest() {
        String title = "Card title";
        String partOfTextContent = "Aliquam lobortis";
        lazyCard.scrollIntoView();
        lazyCard.is().existContent();
        lazyCard.title().is().text(title);
        lazyCard.contentText().is().text(containsString(partOfTextContent));
        scrollDownText.scrollIntoView();
        lazyCard.is().existContent();
        lazyCard.title().is().text(title);
        lazyCard.contentText().is().text(containsString(partOfTextContent));
    }
}

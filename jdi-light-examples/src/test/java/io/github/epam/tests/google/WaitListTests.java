package io.github.epam.tests.google;

import com.epam.jdi.tools.func.JAction;
import io.github.epam.GoogleInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.GoogleSite.homePage;
import static io.github.com.pages.SearchPage.searchS;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class WaitListTests extends GoogleInit {
    @BeforeMethod
    public void before() {
        homePage.shouldBeOpened();
        homePage.search("jdi");
    }

    private void waitList(JAction action) {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception ignore) {}
            action.execute();
        }).start();
    }

    @Test
    public void notEmptyTest() {
        searchS.is().notEmpty();
    }
    @Test
    public void notEmpty2Test() {
        searchS.assertThat(not(empty()));
    }
    @Test
    public void emptyTest() {
        try {
            searchS.is().empty();
            Assert.fail("List should not be empty");
        } catch (Throwable ex) { }
    }
    @Test
    public void sizeTest() {
        assertEquals(searchS.size(), 6);
        searchS.is().size(equalTo(8));
    }
    @Test
    public void sizeNotEmptyTest() {
        searchS.is().size(greaterThan(7));
    }

}

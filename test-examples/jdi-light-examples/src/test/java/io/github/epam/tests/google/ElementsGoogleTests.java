package io.github.epam.tests.google;

import com.epam.jdi.light.elements.complex.DataList;
import io.github.com.custom.*;
import io.github.epam.StaticTestsInit;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.Header.*;
import static io.github.epam.test.data.ListData.*;
import static io.github.epam.tests.recommended.steps.Preconditions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class ElementsGoogleTests extends StaticTestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        epamLogo.click();
        search("jdi");
    }
    @Test
    public void validateEntitiesTests() {
        DataList<SearchResult, Result> jobs = searchPage.search;

        jobs.assertThat(not(empty()))
            .and(hasSize(greaterThan(2)))
            .and(hasItem(CORRECT))
            .and(hasItems(CORRECT, CORRECT_2, CORRECT_3))
            .and(not(hasItem(CORRUPTED)))
            .and(not(hasItems(CORRUPTED, CORRUPTED_2)));
    }
    @Test
    public void validateEntities2Tests() {
        DataList<SearchResult, ?> jobs = searchPage.search2;

        assertEquals(jobs.get(1).name.getText(),"JDI SKYPE");
        assertEquals(jobs.get(2).name.getText(),"JDI OWNER CONTACT");
        try {
            jobs.is().empty();
            Assert.fail("List should not be empty");
        } catch (Throwable ex) {
            assertThat(ex.getMessage(), containsString("but: was \"list is not empty\""));
        }
        jobs.is().notEmpty();
        jobs.assertThat().size(equalTo(8));
    }

    @Test
    public void validateFilterTests() {
        DataList<SearchResult, Result> jobs = searchPage.search;

        jobs.assertThat().value(containsString(
            "name:JDI FACEBOOK GROUP; description:English Community Facebook group"))
            .any(e -> e.description.toLowerCase().contains("jdi"))
            .each(e -> e.name.toLowerCase().contains("jdi"))
            .onlyOne(e -> e.name.contains("OWNER"))
            .noOne(e -> e.name.equalsIgnoreCase("Selenide"));
    }

}

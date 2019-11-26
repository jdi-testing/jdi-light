package io.github.epam.tests.google;

import com.epam.jdi.light.elements.complex.DataList;
import io.github.com.custom.Result;
import io.github.com.custom.SearchResult;
import io.github.epam.StaticTestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.searchPage;
import static io.github.com.pages.Header.epamLogo;
import static io.github.com.pages.Header.search;
import static io.github.epam.test.data.ListDataUtils.CORRECT;
import static io.github.epam.test.data.ListDataUtils.CORRECT_2;
import static io.github.epam.test.data.ListDataUtils.CORRECT_3;
import static io.github.epam.test.data.ListDataUtils.CORRUPTED;
import static io.github.epam.test.data.ListDataUtils.CORRUPTED_2;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.testng.Assert.assertEquals;

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
        assertEquals(jobs.get(0).name.getText(),"JDI SKYPE");
        assertEquals(jobs.get(1).name.getText(),"JDI OWNER CONTACT");
        try {
            jobs.is().empty();
            Assert.fail("List should not be empty");
        } catch (Throwable ex) { }
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

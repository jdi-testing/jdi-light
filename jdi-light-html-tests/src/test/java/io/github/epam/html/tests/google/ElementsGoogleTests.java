package io.github.epam.html.tests.google;

import com.epam.jdi.light.elements.complex.UIList;
import com.google.custom.Result;
import com.google.custom.SearchResult;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.GoogleSite.homePage;
import static com.google.GoogleSite.searchPage;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class ElementsGoogleTests extends GoogleInit {
    @BeforeMethod
    public void before() {
        homePage.shouldBeOpened();
        homePage.search("jdi");
    }

    @Test
    public void printResultListTest() {
        for (SearchResult job : searchPage.jobsE) {
            System.out.println(job.print());
        }
    }

    @Test
    public void validateEntitiesTests() {
        UIList<SearchResult, Result> jobs = searchPage.jobsE;
    /*
        jobs.assertThat(not(empty()));
        jobs.assertThat(hasSize(greaterThan(2)));
        jobs.assertThat(hasItem(expectedResult()));
        jobs.assertThat(hasItems(expectedResultsList()));
        jobs.assertThat(not(hasItem(corruptedResult())));
        jobs.assertThat(not(hasItems(corruptedResultsList())));
        */
    }
    @Test
    public void validateEntities2Tests() {
        UIList<SearchResult, ?> jobs = searchPage.jobs2;

        int size = searchPage.jobs2.size();

        try {
            jobs.is().empty();
            Assert.fail("List should not be empty");
        } catch (Throwable ex) {}
        jobs.is().notEmpty();
        jobs.assertThat().size(equalTo(size));

    }
    @Test
    public void validateFilterTests() {
        UIList<SearchResult, Result> jobs = searchPage.jobsE;

        /*
        String expetedValue = searchPage.jobsE.getValue();
        jobs.assertThat().value(expetedValue);
        jobs.assertThat().any(e -> e.name.toLowerCase().contains("jdi"));
        jobs.assertThat().each(e -> e.name.toLowerCase().contains("jdi")
            || e.name.contains("株式会")
            || e.name.contains("Japan"));
        jobs.assertThat().onlyOne(e -> e.name.contains("株式会"));
        jobs.assertThat().noOne(e -> e.name.contains("SELENIDE"));
        */
    }

    private static List<Result> jobs() {
        return searchPage.jobsE.asData();
    }

    private static Result expectedResult() {
        return jobs().get(1);
    }
    private static Result corruptedResult() {
        Result r = jobs().get(1);
        r.name = "changed";
        return r;
    }
    private static Result[] expectedResultsList() {
        return new Result[] {jobs().get(1), jobs().get(3)};
    }

    private static Result[] corruptedResultsList() {
        Result r = jobs().get(1);
        r.name = "changed";
        Result r2 = jobs().get(3);
        r2.description = "changed";
        return new Result[] {r, r2};
    }
}

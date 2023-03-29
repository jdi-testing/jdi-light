package io.github.epam.html.tests.elements.complex.list;

import com.epam.jdi.light.elements.complex.DataList;
import io.github.com.custom.Result;
import io.github.com.custom.SearchResult;
import io.github.epam.TestsInit;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.jdiai.tools.PrintUtils.print;
import static io.github.com.StaticSite.searchPage;
import static io.github.com.pages.Header.epamLogo;
import static io.github.com.pages.Header.search;
import static io.github.com.pages.SearchPage.search3;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static io.github.epam.test.data.ListData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class ElementsGoogleTests implements TestsInit {

    static final String searchResultPrint =
        "SearchResult{NAME=JDI SKYPE; DESCRIPTION=JDI Skype group with active JDI users; LINK=https://join.skype.com/u2Cel0MWHkAO}," +
        "SearchResult{NAME=JDI OWNER CONTACT; DESCRIPTION=Write an email directly to Framework owner and main architect Iovlev Roman; LINK=mailto:roman.iovlev.jdi@gmail.com}," +
        "SearchResult{NAME=JDI TEST SITE; DESCRIPTION=JDI Site for testing; LINK=https://jdi-testing.github.io/jdi-light/}," +
        "SearchResult{NAME=JDI YOUTUBE CHANNEL; DESCRIPTION=JDI Tutorial Official Youtube; LINK=https://www.youtube.com/channel/UCck0VgwbPVgXht5h6PGCdgg/videos?view_as=subscriber}," +
        "SearchResult{NAME=JDI DOCUMENTATION; DESCRIPTION=JDI Documentation; LINK=https://jdi-docs.github.io/jdi-light}";
    static final String searchResult =
        "JDI SKYPE\nJDI Skype group with active JDI users\nJoin Skype group," +
        "JDI OWNER CONTACT\nWrite an email directly to Framework owner and main architect Iovlev Roman\nWrite email," +
        "JDI TEST SITE\nJDI Site for testing\nVisit Site," +
        "JDI YOUTUBE CHANNEL\nJDI Tutorial Official Youtube\nVisit Channel,JDI DOCUMENTATION\n" +
        "JDI Documentation\nSee more";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        epamLogo.click();
        search("jdi");
    }
    @Step
    public void iterationStep(DataList<SearchResult, Result> data) {
        List<String> searchValues = new ArrayList<>();
        for (SearchResult result : data) {
            searchValues.add(result.getText());
        }
        assertThat(print(searchValues), containsString(searchResult));
    }
    @Step
    public void iterationStep2(List<SearchResult> data) {
        List<String> searchValues = new ArrayList<>();
        for (SearchResult result : data) {
            searchValues.add(result.print());
        }
        assertThat(print(searchValues), containsString(searchResultPrint));
    }
    @Test
    public void iterationWithStepTest() {
        iterationStep(searchPage.search);
    }
    @Test
    public void iterationWithStepTest2() {
        iterationStep2(searchPage.search);
    }
    @Test
    public void iterationWithStepTest3() {
        iterationStep2(search3);
    }
    @Test
    public void iterationTest() {
        List<String> searchValues = new ArrayList<>();
        for (SearchResult result : searchPage.search) {
            searchValues.add(result.print());
        }
        assertThat(print(searchValues), containsString(searchResultPrint));
    }
    @Test
    public void iterationTest1() {
        List<String> searchValues = new ArrayList<>();
        for (SearchResult result : searchPage.search2) {
            searchValues.add(result.getText());
        }
        assertThat(print(searchValues), containsString(searchResult));
    }
    @Test
    public void iterationTest2() {
        List<String> searchValues = new ArrayList<>();
        for (SearchResult result : search3) {
            searchValues.add(result.getText());
        }
        assertThat(print(searchValues), containsString(searchResult));
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

        assertEquals(jobs.get(ELEMENT.startIndex).name.getText(),"JDI SKYPE");
        assertEquals(jobs.get(ELEMENT.startIndex + 1).name.getText(),"JDI OWNER CONTACT");
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

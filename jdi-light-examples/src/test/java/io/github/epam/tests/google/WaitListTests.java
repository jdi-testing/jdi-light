package io.github.epam.tests.google;

import com.epam.jdi.tools.func.JAction;
import io.github.epam.GoogleInit;
import org.testng.annotations.BeforeMethod;

import static com.google.GoogleSite.homePage;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class WaitListTests extends GoogleInit {
    @BeforeMethod
    public void before() {
        homePage.shouldBeOpened();
        homePage.search("");
    }

    private void waitList(JAction action) {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception ignore) {}
            action.execute();
        }).start();
    }
    /*
    //@TestSkipp
    public void notEmptyTest() {
        homePage.search("sgrgergsergsfdgdfgergsergserg");
        waitList(() -> homePage.search("jdi"));
        searchS.is().notEmpty();
    }
    //@TestSkipp
    public void notEmpty2Test() {
        homePage.search("sgrgergsergsfdgdfgergsergserg");
        waitList(() -> homePage.search("jdi"));
        searchS.assertThat(not(empty()));
    }
    //@TestSkipp
    public void emptyTest() {
        homePage.search("jdi");
        waitList(() -> homePage.search("sgrgergsergsfdgdfgergsergserg"));
        searchS.is().empty();
    }
    //@TestSkipp
    public void sizeTest() {
        homePage.search("jdi");
        waitList(() -> homePage.search("sgrgergsergsfdgdfgergsergserg"));
        searchS.is().size(equalTo(0));
    }
    //@TestSkipp
    public void sizeNotEmptyTest() {
        homePage.search("sgrgergsergsfdgdfgergsergserg");
        waitList(() -> homePage.search("jdi"));
        searchS.is().size(greaterThan(2));
    }
    */
        /*jobs.assertThat(not(empty()));
        jobs.assertThat(hasSize(greaterThan(2)));
        jobs.assertThat(hasItem(expectedResult()));
        jobs.assertThat(hasItems(expectedResultsList()));
        jobs.assertThat(not(hasItem(corruptedResult())));
        jobs.assertThat(not(hasItems(corruptedResultsList())));
        */
/*


    //@Test
    public void validateFilterTests() {
        UIList<SearchResult, Result> jobs = searchPage.search;


        String expetedValue = searchPage.search.getValue();
        jobs.assertThat().value(expetedValue);
        jobs.assertThat().any(e -> e.name.toLowerCase().contains("jdi"));
        jobs.assertThat().each(e -> e.name.toLowerCase().contains("jdi")
            || e.name.contains("株式会")
            || e.name.contains("Japan"));
        jobs.assertThat().onlyOne(e -> e.name.contains("株式会"));
        jobs.assertThat().noOne(e -> e.name.contains("SELENIDE"));

    }*/
}

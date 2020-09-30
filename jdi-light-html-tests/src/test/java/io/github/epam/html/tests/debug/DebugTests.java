package io.github.epam.html.tests.debug;

import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.tools.LinqUtils;
import io.github.com.custom.Result;
import io.github.com.custom.SearchResult;
import io.github.epam.TestsInit;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.github.com.StaticSite.searchPage;
import static io.github.com.pages.Header.epamLogo;
import static io.github.com.pages.Header.search;
import static io.github.com.pages.SearchPage.search3;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class DebugTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        epamLogo.click();
        search("jdi");
    }
    @Step
    public void iterationStep(DataList<SearchResult, Result> data) {
        List<String> searchValues = new ArrayList<>();
        for(SearchResult result : data) {
            searchValues.add(result.getText());
        }
        System.out.println("Values: " + searchValues);
    }
    @Step
    public void iterationStep2(List<SearchResult> data) {
        List<String> searchValues = new ArrayList<>();
        for(SearchResult result : data) {
            searchValues.add(result.getText());
        }
        System.out.println("Values: " + searchValues);
    }
    @Test
    public void iterationWithStepTest() {
        List<String> l = LinqUtils.select(search3, el -> el.name.getText());
        iterationStep(searchPage.search);
        iterationStep2(searchPage.search);
        iterationStep2(search3);
    }

}

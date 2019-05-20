package io.github.epam.html.tests.elements.composite.webpage;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import pseudo.site.dataproviders.WebPage.WebPageDataProvider;


public class ActionsWebPageTests extends TestsInit {

    @Test(dataProvider = "actionsWebPageDataProvider", dataProviderClass = WebPageDataProvider.class)
    public void actionsWebPageTest() {

    }
}
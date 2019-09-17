package io.github.epam.bootstrap.tests.common;


import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.breadcrumb;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BreadcrumbTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }
    private static final String HOME = "Home";
    private static final String HTML5 = "HTML 5";
    private static final String BOOTSTRAP = "Bootstrap";

    private static final List<String> ANCESTOR_VALUES = Arrays.asList(HOME, HTML5);

    @Test
    public void getTextTest() {
        List<String> ancestorValues = breadcrumb.ancestorList.stream().map(UIElement::getText).collect(Collectors.toList());

        assertThat(breadcrumb.currentItem.getText(), is(BOOTSTRAP));
        assertThat(ancestorValues, is(ANCESTOR_VALUES));
    }

    @Test
    public void getValueTest() {
        List<String> ancestorValues = breadcrumb.ancestorList.stream().map(UIElement::getValue).collect(Collectors.toList());

        assertThat(breadcrumb.currentItem.getValue(), is(BOOTSTRAP));
        assertThat(ancestorValues, is(ANCESTOR_VALUES));
    }

/*        String bsPageT = bsPage.getTitle();

        homePage.shouldBeOpened();
        String homePageT = homePage.getTitle();

        html5Page.shouldBeOpened();
        String html5PageT = html5Page.getTitle();*/
}
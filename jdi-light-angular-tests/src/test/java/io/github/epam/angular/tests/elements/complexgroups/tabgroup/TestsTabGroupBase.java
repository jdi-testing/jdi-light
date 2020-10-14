package io.github.epam.angular.tests.elements.complexgroups.tabgroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class TestsTabGroupBase extends TestsInit {

    public static final String CLASS_ATTR = "class";
    public static final String ACCENT = "accent";
    public static final String PRIMARY = "primary";
    public static final String DYNAMIC_CONTENT = "Content %s";
    public static final String TAB_GROUP_DEFAULT_CLASS = "mat-tab-group mat-primary";
    public static final List<String> TITLES_DEFAULT_LIST = Arrays.asList("First", "Second", "Third");

    @BeforeTest(alwaysRun = true)
    public static void beforeStartTest() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }
}

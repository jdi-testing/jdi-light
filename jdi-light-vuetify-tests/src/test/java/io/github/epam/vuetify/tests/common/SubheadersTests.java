package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.SubheaderTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.subheadersPage;
import static io.github.com.pages.SubheadersPage.gridSubheader;
import static io.github.com.pages.SubheadersPage.insetSubheader;
import static io.github.com.pages.SubheadersPage.menuSubheader;
import static io.github.com.pages.SubheadersPage.socialMediaSubheader;

public class SubheadersTests extends TestsInit {

    @BeforeClass
    public void before() {
        subheadersPage.open();
        waitCondition(() -> subheadersPage.isOpened());
        subheadersPage.checkOpened();
    }

    @Test
    public void insetTest() {
        insetSubheader.is().displayed();
        insetSubheader.is().lightTheme();
        insetSubheader.is().inset();
        insetSubheader.is().text("Subheader");
    }

    @Test(dataProvider = "gridTestData", dataProviderClass = SubheaderTestsDataProvider.class)
    public void gridTest(int index, String text) {
        gridSubheader.get(index).is().displayed();
        gridSubheader.get(index).is().lightTheme();
        gridSubheader.get(index).is().text(text);
    }

    @Test
    public void menuTest() {
        menuSubheader.is().displayed();
        menuSubheader.is().lightTheme();
        menuSubheader.is().text("Labels");
    }

    @Test(dataProvider = "socialMediaTestData", dataProviderClass = SubheaderTestsDataProvider.class)
    public void socialMediaTest(int index, String text) {
        socialMediaSubheader.get(index).is().displayed();
        socialMediaSubheader.get(index).is().lightTheme();
        socialMediaSubheader.get(index).is().text(text);
    }

}
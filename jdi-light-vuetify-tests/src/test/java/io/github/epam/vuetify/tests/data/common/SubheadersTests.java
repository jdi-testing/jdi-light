package io.github.epam.vuetify.tests.data.common;

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

    @Test(description = "Test checks inset Subheader features: 'theme' and 'text'")
    public void insetSubheaderTest() {
        insetSubheader.is().displayed();
        insetSubheader.is().lightTheme();
        insetSubheader.is().inset();
        insetSubheader.is().text("Subheader");
    }

    @Test(description = "Test checks grid Subheader features: 'theme' and 'text'",
            dataProvider = "gridTestData", dataProviderClass = SubheaderTestsDataProvider.class)
    public void gridSubheaderTest(int index, String text) {
        gridSubheader.get(index).is().displayed();
        gridSubheader.get(index).is().lightTheme();
        gridSubheader.get(index).is().text(text);
    }

    @Test(description = "Test checks menu Subheader features: 'theme' and 'text'")
    public void menuSubheaderTest() {
        menuSubheader.is().displayed();
        menuSubheader.is().lightTheme();
        menuSubheader.is().text("Labels");
    }

    @Test(description = "Test checks social media Subheader features: 'theme' and 'text'",
            dataProvider = "socialMediaTestData", dataProviderClass = SubheaderTestsDataProvider.class)
    public void socialMediaSubheaderTest(int index, String text) {
        socialMediaSubheader.get(index).is().displayed();
        socialMediaSubheader.get(index).is().lightTheme();
        socialMediaSubheader.get(index).is().text(text);
    }

}

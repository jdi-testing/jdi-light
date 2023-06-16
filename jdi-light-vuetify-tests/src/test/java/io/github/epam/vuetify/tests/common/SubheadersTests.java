package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.subheadersPage;
import static io.github.com.pages.SubheadersPage.insetSubheader;

public class SubheadersTests extends TestsInit {

    @BeforeClass
    public void before() {
        subheadersPage.open();
        waitCondition(() -> subheadersPage.isOpened());
        subheadersPage.checkOpened();
    }

    @Test(description = "Test checks inset Subheader features: 'theme' and 'text'")
    public void insetSubheaderTest() {
        insetSubheader.is().displayed()
                .and().lightTheme()
                .and().inset()
                .and().text("Subheader");
    }
}

package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Subheader;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.subheadersPage;
import static io.github.com.pages.SubheadersPage.gridSubheader;
import static io.github.com.pages.SubheadersPage.insetSubheader;
import static io.github.com.pages.SubheadersPage.menuSubheader;
import static io.github.com.pages.SubheadersPage.socialMediaSubheader;

public class SubheaderTests extends TestsInit {

    @BeforeClass
    public void before() {
        subheadersPage.open();
    }

    @Test
    public void insetTest() {
        insetSubheader.is().displayed();
        insetSubheader.is().lightTheme();
        insetSubheader.is().inset();
        insetSubheader.is().text("Subheader");
    }

    @Test
    public void gridTest() {
        gridSubheader.stream().map(Subheader::is).forEach(subheader -> {
            subheader.is().displayed();
            subheader.is().lightTheme();
        });
        gridSubheader.get(1).is().text("May");
        gridSubheader.get(2).is().text("June");
    }

    @Test
    public void menuTest() {
        menuSubheader.is().displayed();
        menuSubheader.is().lightTheme();
        menuSubheader.is().text("Labels");
    }

    @Test
    public void socialMediaTest() {
        socialMediaSubheader.stream().map(Subheader::is).forEach(subheader -> {
            subheader.is().displayed();
            subheader.is().lightTheme();
        });
        socialMediaSubheader.get(1).is().text("Places to Be");
        socialMediaSubheader.get(2).is().text("Places to See");
    }
}

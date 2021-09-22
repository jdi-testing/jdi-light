package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Subheader;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.subheaderPage;
import static io.github.com.pages.SubheaderPage.gridSubheader;
import static io.github.com.pages.SubheaderPage.insetSubheader;
import static io.github.com.pages.SubheaderPage.menuSubheader;
import static io.github.com.pages.SubheaderPage.socialMediaSubheader;

public class SubheaderTests extends TestsInit {

    @BeforeClass
    public void before() {
        subheaderPage.open();
    }

    @Test
    public void insetTest() {
        insetSubheader.is()
                .displayed()
                .text("Subheader")
                .inset()
                .lightTheme();
    }

    @Test
    public void gridTest() {
        gridSubheader.stream().map(Subheader::is).forEach(subheader -> subheader.is()
                .displayed()
                .lightTheme());
        gridSubheader.get(1).is().text("May");
        gridSubheader.get(2).is().text("June");
    }

    @Test
    public void menuTest() {
        menuSubheader.is()
                .displayed()
                .text("Labels")
                .lightTheme();
    }

    @Test
    public void socialMediaTest() {
        socialMediaSubheader.stream().map(Subheader::is).forEach(subheader -> subheader.is()
                .displayed()
                .lightTheme());
        socialMediaSubheader.get(1).is().text("Places to Be");
        socialMediaSubheader.get(2).is().text("Places to See");
    }
}

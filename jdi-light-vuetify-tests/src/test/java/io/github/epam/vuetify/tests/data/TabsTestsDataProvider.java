package io.github.epam.vuetify.tests.data;

import static io.github.com.enums.MdiIcons.ACCOUNT_BOX;
import static io.github.com.enums.MdiIcons.HEART;
import static io.github.com.enums.MdiIcons.PHONE;

import org.testng.annotations.DataProvider;

public class TabsTestsDataProvider {

    @DataProvider(name = "alignWithTitleTabsTestsData")
    public static Object[][] alignWithTitleTabsTestsData() {
        return new Object[][]{
                {1, "WEB"}, {2, "SHOPPING"}, {3, "VIDEOS"},
                {4, "IMAGES"}, {5, "NEWS"}
        };
    }

    @DataProvider(name = "iconsTextTabsTestsData")
    public static Object[][] iconsTextTabsTestsData() {
        return new Object[][]{
            {1, "RECENTS", PHONE.mdi()}, {2, "FAVORITES", HEART.mdi()}, {3, "NEARBY", ACCOUNT_BOX.mdi()}
        };
    }
}

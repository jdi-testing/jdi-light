package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class AvatarDataProvider {

    @DataProvider
    public Object[][] avatarsWithBadge() {
        return new Object[][]{
                {1, ""},
                {2, "R"}
        };
    }
}

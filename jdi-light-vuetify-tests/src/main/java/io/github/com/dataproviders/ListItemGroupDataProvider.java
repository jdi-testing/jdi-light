package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

public class ListItemGroupDataProvider {

    @DataProvider
    public static Object[][] listItemGroupsDataProvider() {
        List<String> expectedTitles = Arrays.asList("Wifi", "Bluetooth", "Data Usage");
        return new Object[][]{
                {expectedTitles}
        };
    }
}

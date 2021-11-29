package io.github.com.dataproviders;

import java.util.Arrays;
import java.util.List;
import org.testng.annotations.DataProvider;

public class ChipGroupsDataProviders {
    @DataProvider
    public static Object[][] columnChipGroupDataProvider() {
        List<String> chipsLabels = Arrays.asList("Work", "Home Improvement", "Vacation", "Food", "Drawers",
                "Shopping", "Art", "Tech", "Creative Writing");
        return new Object[][]{
                {chipsLabels}
        };
    }

    @DataProvider
    public static Object[][] chooseAmenitiesAndNeighborhoodsDataProvider() {
        List<String> chooseAmenitiesAndNeighborhoods = Arrays.asList("Elevator", "Washer / Dryer", "Fireplace",
                "Wheelchair access", "Dogs ok", "Cats ok", "Snowy Rock Place", "Honeylane Circle",
                "Donna Drive", "Elaine Street", "Court Street", "Kennedy Park");
        return new Object[][]{
                {chooseAmenitiesAndNeighborhoods}
        };
    }

    @DataProvider
    public static Object[][] selectSizeShirtBlouseDataProvider() {
        List<String> sizes = Arrays.asList("04", "06", "08", "10", "12", "14");
        return new Object[][]{
                {sizes}
        };
    }

    @DataProvider
    public static Object[][] selectTypeToothbrushDataProvider() {
        List<String> types = Arrays.asList("Extra Soft", "Soft", "Medium", "Hard");
        return new Object[][]{
                {types}
        };
    }

}

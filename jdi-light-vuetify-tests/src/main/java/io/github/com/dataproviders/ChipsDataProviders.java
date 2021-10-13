package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

public class ChipsDataProviders {
    @DataProvider
    public static Object[][] closableChipsDataProvider() {
        List<String> chipsLabels = Arrays.asList("Closable", "Remove", "Success", "Complete");
        return new Object[][]{
                {chipsLabels}
        };
    }

    @DataProvider
    public static Object[][] coloredChipsDataProvider() {
        List<String> chipsLabels = Arrays.asList("Default", "Primary", "Secondary", "Red Chip", "Green Chip");
        List<String> chipsBackgroundColors = Arrays.asList("rgba(224, 224, 224, 1)", "rgba(25, 118, 210, 1)",
                "rgba(66, 66, 66, 1)", "rgba(244, 67, 54, 1)", "rgba(76, 175, 80, 1)");
        return new Object[][]{
                {chipsLabels, chipsBackgroundColors}
        };
    }

    @DataProvider
    public static Object[][] outlinedChipsDataProvider() {
        List<String> borderColors = Arrays.asList("rgb(76, 175, 80)", "rgb(25, 118, 210)",
                "rgb(98, 0, 234)", "rgb(40, 53, 147)");
        List<String> fontColors = Arrays.asList("rgba(76, 175, 80, 1)", "rgba(25, 118, 210, 1)",
                "rgba(98, 0, 234, 1)", "rgba(40, 53, 147, 1)");
        return new Object[][]{
                {borderColors, fontColors}
        };
    }

    @DataProvider
    public static Object[][] sizesChipsDataProvider() {
        List<Integer> fontSizes = Arrays.asList(10, 12, 14, 16, 18);
        List<Integer> heights = Arrays.asList(16, 24, 32, 54, 66);
        return new Object[][]{
                {fontSizes, heights}
        };
    }

    @DataProvider
    public static Object[][] actionChipsDataProvider() {
        List<String> alertMessages = Arrays.asList("Toggling lights...", "Turning on alarm...", "Toggling Blinds...");
        return new Object[][]{
                {alertMessages}
        };
    }

    @DataProvider
    public static Object[][] customListChipsDataProvider() {
        return new Object[][]{
                {"Nature"}
        };
    }

    @DataProvider
    public static Object[][] expandableChipDataProvider() {
        List<String> emails = Arrays.asList("john@vuetifyjs.com", "john@gmail.com");
        return new Object[][]{
                {emails}
        };
    }

    @DataProvider
    public static Object[][] inSelectChipsDataProvider() {
        List<String> fullLabel = Arrays.asList("Programming (interest)", "Playing video games (interest)",
                "Watching movies (interest)", "Sleeping (interest)");
        List<String> boldText = Arrays.asList("Programming", "Playing video games",
                "Watching movies", "Sleeping");
        String regularText = "(interest)";
        return new Object[][]{
                {fullLabel, boldText, regularText}
        };
    }
}

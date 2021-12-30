package io.github.com.dataproviders;

import io.github.com.enums.Colors;
import org.testng.annotations.DataProvider;

public class ButtonsDataProvider {

    @DataProvider
    private Object[][] depressedButtons() {
        return new Object[][]{
                {1, true, Colors.GREY_LIGHTEN_4.toString(), "Normal"},
                {2, true, Colors.BLUE_DARKEN_2.toString(), "Primary"},
                {3, true, Colors.RED_ACCENT_2.toString(), "Error"},
                {4, false, "rgba(0, 0, 0, 0.12)", "Error"}
        };
    }

    @DataProvider
    private Object[][] iconButtons() {
        return new Object[][]{
                {1, true, "mdi-heart", Colors.PINK.toString(), "heart"},
                {2, true, "mdi-star", Colors.INDIGO.toString(), "star"},
                {3, true, "mdi-cached", Colors.GREEN.toString(), "cached"},
                {4, true, "mdi-thumb-up", Colors.DEEP_ORANGE.toString(), "thumb up"},
                {5, false, "mdi-heart", "rgba(0, 0, 0, 0.26)", "thumb up"},
                {6, false, "mdi-star", "rgba(0, 0, 0, 0.26)", "thumb up"},
                {7, false, "mdi-cached", "rgba(0, 0, 0, 0.26)", "thumb up"},
                {8, false, "mdi-thumb-up", "rgba(0, 0, 0, 0.26)", "thumb up"}
        };
    }

    @DataProvider
    private Object[][] loadingButtons() {
        return new Object[][]{
                {1, "ACCEPT TERMS", "", ""},
                {2, "UPLOAD", "", ""},
                {3, "CUSTOM LOADER", "text", "Loading..."},
                {4, "ICON LOADER", "icon", "mdi-cached"},
                {5, "", "", ""}
        };
    }

    @DataProvider
    private Object[][] textButtons() {
        return new Object[][]{
                {1, true, "rgba(0, 0, 0, 0.87)", "NORMAL", "Normal"},
                {2, true, Colors.BLUE_DARKEN_2.toString(), "PRIMARY", "Primary"},
                {3, true, Colors.RED_ACCENT_2.toString(), "ERROR", "Error"},
                {4, false, "rgba(0, 0, 0, 0.26)", "DISABLED", "Error"}
        };
    }

    @DataProvider
    private Object[][] plainButtons() {
        return new Object[][]{
                {1, "cancel"},
                {2, "delete"}
        };
    }
}

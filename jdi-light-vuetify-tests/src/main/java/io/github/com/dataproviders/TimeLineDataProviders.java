package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import static io.github.com.enums.Colors.AMBER;
import static io.github.com.enums.Colors.AMBER_LIGHTEN_1;
import static io.github.com.enums.Colors.CYAN;
import static io.github.com.enums.Colors.CYAN_LIGHTEN_1;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.GREEN_LIGHTEN_1;
import static io.github.com.enums.Colors.INDIGO;
import static io.github.com.enums.Colors.ORANGE;
import static io.github.com.enums.Colors.PINK;
import static io.github.com.enums.Colors.PURPLE_DARKEN_1;
import static io.github.com.enums.Colors.PURPLE_LIGHTEN_2;
import static io.github.com.enums.Colors.RED_LIGHTEN_1;
import static io.github.com.enums.Colors.RED_LIGHTEN_2;
import static io.github.com.enums.Colors.TEAL_LIGHTEN_3;
import static io.github.com.enums.Colors.WHITE;

public class TimeLineDataProviders {

    public static final String LOREM_IPSUM_TEXT = "Lorem ipsum dolor sit amet, no " +
            "nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire " +
            "principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, " +
            "vix an salutandi sententiae.";

    public static final String LOREM_IPSUM_TITLE = "Lorem ipsum";

    @DataProvider
    public static Object[][] colorTimeLineData() {
        return new Object[][]{
                {1, "5pm", "New Icon", "Mobile App", PINK},
                {2, "3-4pm", "Design Stand Up", "Hangouts", TEAL_LIGHTEN_3},
                {3, "12pm", "Lunch break", null, PINK},
                {4, "9-11am", "Finish Home Screen", "Web App", TEAL_LIGHTEN_3}
        };
    }

    @DataProvider
    public static Object[][] iconDotsTimeLineData() {
        return new Object[][]{
                {1, "mdi-star", "Lorem Ipsum Dolor", LOREM_IPSUM_TEXT, RED_LIGHTEN_2, WHITE},
                {2, "mdi-book-variant", "Lorem Ipsum Dolor", LOREM_IPSUM_TEXT, PURPLE_DARKEN_1, WHITE},
                {3, "mdi-airballoon", "Lorem Ipsum Dolor", LOREM_IPSUM_TEXT, GREEN_LIGHTEN_1, WHITE},
                {4, "mdi-buffer", "Lorem Ipsum Dolor", LOREM_IPSUM_TEXT, INDIGO, WHITE}
        };
    }

    @DataProvider
    public static Object[][] smallTimeLineData() {
        return new Object[][]{
                {1, "Title 1", "mdi-magnify", PURPLE_LIGHTEN_2, false},
                {2, "Title 2", "mdi-home-outline", AMBER_LIGHTEN_1, true},
                {3, "Title 3", "mdi-email-outline", CYAN_LIGHTEN_1, false},
                {4, "Title 4", "mdi-account-multiple-outline", RED_LIGHTEN_1, true},
                {5, "Title 5", "mdi-phone-in-talk", GREEN_LIGHTEN_1, false}
        };
    }

    @DataProvider
    public static Object[][] oppositeTimeLineData() {
        return new Object[][]{
                {1, "1960", CYAN},
                {2, "1970", GREEN},
                {3, "1980", PINK},
                {4, "1990", AMBER},
                {5, "2000", ORANGE}
        };
    }
}

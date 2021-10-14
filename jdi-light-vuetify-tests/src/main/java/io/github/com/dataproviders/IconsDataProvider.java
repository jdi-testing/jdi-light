package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_GREY_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_LIGHTEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.GREEN_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.ORANGE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PURPLE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED_LIGHTEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.TEAL_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.WHITE;

public class IconsDataProvider {

    @DataProvider(name = "colorIconsTestsDataProvider")
    public static Object[][] colorIconsTestsData() {
        return new Object[][] {
                {1, "mdi-domain", GREEN_DARKEN_2.value(), "36px", "36px" },
                {2, "mdi-message-text", BLUE_DARKEN_2.value(), "36px", "36px" },
                {3, "mdi-dialpad", PURPLE_DARKEN_2.value(), "36px", "36px" },
                {4, "mdi-email", TEAL_DARKEN_2.value(), "36px", "36px" },
                {5, "mdi-call-split", BLUE_GREY_DARKEN_2.value(), "36px", "36px" },
                {6, "mdi-arrow-up-bold-box-outline", ORANGE_DARKEN_2.value(), "36px", "36px" }
        };
    }

    @DataProvider(name = "buttonsIconsTestsDataProvider")
    public static Object[][] buttonsIconsTestsData() {
        return new Object[][] {
                {1, "mdi-checkbox-marked-circle", WHITE.value(), "18px", "18px"},
                {2, "mdi-cancel", WHITE.value(), "18px", "18px"},
                {3, "mdi-minus-circle", WHITE.value(), "18px", "18px"},
                {4, "mdi-arrow-left", WHITE.value(), "18px", "18px"},
                {5, "mdi-wrench", WHITE.value(), "24px", "24px"},
                {6, "mdi-cloud-upload", WHITE.value(), "24px", "24px"},
                {7, "mdi-thumb-up", BLUE_LIGHTEN_2.value(), "24px", "24px"},
                {8, "mdi-thumb-down", RED_LIGHTEN_2.value(), "24px", "24px"}
        };
    }

    @DataProvider(name = "fontAwesomeIconsTestsDataProvider")
    public static Object[][] fontAwesomeIconsTestsData() {
        return new Object[][] {
                {1, "fa-lock", "24px", "21px"},
                {2, "fa-search", "24px", "24px"},
                {3, "fa-list",  "24px", "24px"},
                {4, "fa-edit", "24px", "27px"},
                {5, "fa-tachometer-alt", "24px", "27px"},
                {6, "fa-circle-notchfa-spin","24px", "24px"}
        };
    }

    @DataProvider(name = "materialDesignIconsTestsDataProvider")
    public static Object[][] materialDesignIconsTestsData() {
        return new Object[][] {
                {1, "home", "16px", "16px"},
                {2, "event", "16px", "16px"},
                {3, "info",  "16px", "16px"},
                {4, "folder_open", "16px", "16px"},
                {5, "widgets", "16px", "16px"},
                {6, "gavel","16px", "16px"},
                {7, "home", "24px", "24px"},
                {8, "event", "24px", "24px"},
                {9, "info",  "24px", "24px"},
                {10, "folder_open", "24px", "24px"},
                {11, "widgets", "24px", "24px"},
                {12, "gavel","24px", "24px"},
                {13, "home", "36px", "36px"},
                {14, "event", "36px", "36px"},
                {15, "info",  "36px", "36px"},
                {16, "folder_open", "36px", "36px"},
                {17, "widgets", "36px", "36px"},
                {18, "gavel","36px", "36px"},
                {19, "home", "40px", "40px"},
                {20, "event", "40px", "40px"},
                {21, "info",  "40px", "40px"},
                {22, "folder_open", "40px", "40px"},
                {23, "widgets", "40px", "40px"},
                {24, "gavel","40px", "40px"},
        };
    }

    @DataProvider(name = "mdiSvgIconsTestsDataProvider")
    public static Object[][] mdiSvgIconsTestsData() {
        return new Object[][] {
                {1, "24px", "24px"},
                {2, "24px", "24px"},
                {3, "24px", "24px"},
                {4, "18px", "18px"}
        };
    }
}

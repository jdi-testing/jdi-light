package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.BLUE_GREY_DARKEN_2;
import static io.github.com.enums.Colors.BLUE_LIGHTEN_2;
import static io.github.com.enums.Colors.GREEN_DARKEN_2;
import static io.github.com.enums.Colors.ORANGE_DARKEN_2;
import static io.github.com.enums.Colors.PURPLE_DARKEN_2;
import static io.github.com.enums.Colors.RED_LIGHTEN_2;
import static io.github.com.enums.Colors.TEAL_DARKEN_2;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.enums.MdiIcons.ACCOUNT;
import static io.github.com.enums.MdiIcons.ARROW_LEFT;
import static io.github.com.enums.MdiIcons.ARROW_UP_BOLD_BOX_OUTLINE;
import static io.github.com.enums.MdiIcons.CALL_SPLIT;
import static io.github.com.enums.MdiIcons.CANCEL;
import static io.github.com.enums.MdiIcons.CHECKBOX_MARKED_CIRCLE;
import static io.github.com.enums.MdiIcons.CHEVRON_RIGHT;
import static io.github.com.enums.MdiIcons.CLOUD_UPLOAD;
import static io.github.com.enums.MdiIcons.DELETE;
import static io.github.com.enums.MdiIcons.DIALPAD;
import static io.github.com.enums.MdiIcons.DOMAIN;
import static io.github.com.enums.MdiIcons.EMAIL;
import static io.github.com.enums.MdiIcons.FOLDER_OPEN;
import static io.github.com.enums.MdiIcons.GAVEL;
import static io.github.com.enums.MdiIcons.HOME;
import static io.github.com.enums.MdiIcons.MESSAGE_TEXT;
import static io.github.com.enums.MdiIcons.MINUS_CIRCLE;
import static io.github.com.enums.MdiIcons.PENCIL;
import static io.github.com.enums.MdiIcons.SHARE_VARIANT;
import static io.github.com.enums.MdiIcons.THUMB_DOWN;
import static io.github.com.enums.MdiIcons.THUMB_UP;
import static io.github.com.enums.MdiIcons.WIDGETS;
import static io.github.com.enums.MdiIcons.WRENCH;

public class IconsDataProvider {

    @DataProvider(name = "colorIconsTestsDataProvider")
    public static Object[][] colorIconsTestsData() {
        return new Object[][]{
                {1, "mdi-domain", DOMAIN.value(), GREEN_DARKEN_2.value(), 36, 36},
                {2, "mdi-message-text", MESSAGE_TEXT.value(), BLUE_DARKEN_2.value(), 36, 36},
                {3, "mdi-dialpad", DIALPAD.value(), PURPLE_DARKEN_2.value(), 36, 36},
                {4, "mdi-email", EMAIL.value(), TEAL_DARKEN_2.value(), 36, 36},
                {5, "mdi-call-split", CALL_SPLIT.value(), BLUE_GREY_DARKEN_2.value(), 36, 36},
                {6, "mdi-arrow-up-bold-box-outline", ARROW_UP_BOLD_BOX_OUTLINE.value(), ORANGE_DARKEN_2.value(), 36, 36}
        };
    }

    @DataProvider(name = "buttonsIconsTestsDataProvider")
    public static Object[][] buttonsIconsTestsData() {
        return new Object[][]{
                {1, "mdi-checkbox-marked-circle", CHECKBOX_MARKED_CIRCLE.value(), WHITE.value(), 18, 18},
                {2, "mdi-cancel", CANCEL.value(), WHITE.value(), 18, 18},
                {3, "mdi-minus-circle", MINUS_CIRCLE.value(), WHITE.value(), 18, 18},
                {4, "mdi-arrow-left", ARROW_LEFT.value(), WHITE.value(), 18, 18},
                {5, "mdi-wrench", WRENCH.value(), WHITE.value(), 24, 24},
                {6, "mdi-cloud-upload", CLOUD_UPLOAD.value(), WHITE.value(), 24, 24},
                {7, "mdi-thumb-up", THUMB_UP.value(), BLUE_LIGHTEN_2.value(), 24, 24},
                {8, "mdi-thumb-down", THUMB_DOWN.value(), RED_LIGHTEN_2.value(), 24, 24}
        };
    }

    @DataProvider(name = "fontAwesomeIconsTestsDataProvider")
    public static Object[][] fontAwesomeIconsTestsData() {
        return new Object[][]{
                {1, "fa-lock", 24, 21},
                {2, "fa-search", 24, 24},
                {3, "fa-list", 24, 24},
                {4, "fa-edit", 24, 27},
                {5, "fa-tachometer-alt", 24, 27},
                {6, "fa-circle-notchfa-spin", 24, 24}
        };
    }

    @DataProvider(name = "materialDesignIconsTestsDataProvider")
    public static Object[][] materialDesignIconsTestsData() {
        return new Object[][]{
                {0, "home", 16, 16},
                {1, "event", 16, 16},
                {2, "info", 16, 16},
                {3, "folder_open", 16, 16},
                {4, "widgets", 16, 16},
                {5, "gavel", 16, 16},
                {6, "home", 24, 24},
                {7, "event", 24, 24},
                {8, "info", 24, 24},
                {9, "folder_open", 24, 24},
                {10, "widgets", 24, 24},
                {11, "gavel", 24, 24},
                {12, "home", 36, 36},
                {13, "event", 36, 36},
                {14, "info", 36, 36},
                {15, "folder_open", 36, 36},
                {16, "widgets", 36, 36},
                {17, "gavel", 36, 36},
                {18, "home", 40, 40},
                {19, "event", 40, 40},
                {20, "info", 40, 40},
                {21, "folder_open", 40, 40},
                {22, "widgets", 40, 40},
                {23, "gavel", 40, 40},
        };
    }

    @DataProvider(name = "mdiSvgIconsTestsDataProvider")
    public static Object[][] mdiSvgIconsTestsData() {
        return new Object[][]{
                {0, ACCOUNT.value(), 24, 24},
                {1, PENCIL.value(), 24, 24},
                {2, SHARE_VARIANT.value(), 24, 24},
                {3, DELETE.value(), 18, 18}
        };
    }

    @DataProvider(name = "findMdiIconTestDataProvider")
    public static Object[] findMdiIconTestsData() {
        return new Object[]{
                DOMAIN,
                MESSAGE_TEXT,
                DIALPAD,
                EMAIL,
                CALL_SPLIT,
                ARROW_UP_BOLD_BOX_OUTLINE,
                CHEVRON_RIGHT,
                CHECKBOX_MARKED_CIRCLE,
                CANCEL,
                MINUS_CIRCLE,
                ARROW_LEFT,
                WRENCH,
                CLOUD_UPLOAD,
                THUMB_UP,
                THUMB_DOWN,
                HOME,
                FOLDER_OPEN,
                WIDGETS,
                GAVEL,
                ACCOUNT,
                PENCIL,
                SHARE_VARIANT,
                DELETE
        };
    }
}

//package io.github.com.enums;
//
//import com.epam.jdi.light.elements.base.UIBaseElement;
//import com.epam.jdi.light.vuetify.elements.common.Icon;
//import com.google.common.base.CaseFormat;
//import com.opencsv.CSVReader;
//
//import java.io.FileReader;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public enum MdiIcons {
//    ACCESS_POINT,
//    ACCOUNT,
//    ACCOUNT_BOX,
//    ACCOUNT_CIRCLE,
//    ACCOUNT_CIRCLE_OUTLINE,
//    ACCOUNT_GROUP_OUTLINE,
//    ACCOUNT_MULTIPLE,
//    ACCOUNT_MULTIPLE_OUTLINE,
//    ACCOUNT_OUTLINE,
//    ACCOUNT_SUPERVISOR_CIRCLE,
//    AIRBALLOON,
//    ALARM,
//    ALARM_CHECK,
//    ALERT,
//    ALERT_CIRCLE,
//    ALERT_OCTAGON,
//    ALERT_OCTAGON_OUTLINE,
//    ALERT_OUTLINE,
//    ANDROID,
//    APPS,
//    ARROW_COLLAPSE_LEFT,
//    ARROW_COLLAPSE_RIGHT,
//    ARROW_DOWN,
//    ARROW_LEFT,
//    ARROW_LEFT_BOLD_BOX_OUTLINE,
//    ARROW_RIGHT_BOLD_BOX_OUTLINE,
//    ARROW_RIGHT_THICK,
//    ARROW_UP,
//    ARROW_UP_BOLD_BOX_OUTLINE,
//    BATTERY,
//    BIKE,
//    BLINDS,
//    BLUETOOTH,
//    BOOK,
//    BOOKMARK,
//    BOOKMARK_OUTLINE,
//    BOOK_VARIANT,
//    BOTTLE_TONIC_PLUS,
//    BRIEFCASE,
//    BRIGHTNESS_5,
//    CACHED,
//    CAKE_VARIANT,
//    CALENDAR,
//    CALENDAR_BLANK,
//    CALENDAR_RANGE,
//    CALENDAR_TEXT,
//    CALL_SPLIT,
//    CAMERA,
//    CANCEL,
//    CART,
//    CELLPHONE,
//    CHART_DONUT,
//    CHECK,
//    CHECKBOX_BLANK_OUTLINE,
//    CHECKBOX_MARKED,
//    CHECKBOX_MARKED_CIRCLE,
//    CHECK_BOLD,
//    CHECK_CIRCLE,
//    CHEVRON_DOWN,
//    CHEVRON_LEFT,
//    CHEVRON_RIGHT,
//    CIRCLE,
//    CIRCLE_EDIT_OUTLINE,
//    CITY,
//    CLIPBOARD_TEXT,
//    CLOCK,
//    CLOCK_FAST,
//    CLOCK_START,
//    CLOCK_TIME_FOUR_OUTLINE,
//    CLOSE,
//    CLOSE_CIRCLE,
//    CLOSE_CIRCLE_OUTLINE,
//    CLOUD,
//    CLOUD_ALERT,
//    CLOUD_DOWNLOAD,
//    CLOUD_UPLOAD,
//    CODEPEN,
//    CODE_JSON,
//    CODE_TAGS,
//    COG_OUTLINE,
//    COMMENT,
//    CONTENT_COPY,
//    CONTENT_CUT,
//    CONTENT_SAVE,
//    CONTENT_SAVE_COG_OUTLINE,
//    CROSSHAIRS_GPS,
//    DATABASE_SEARCH,
//    DELETE,
//    DIALPAD,
//    DOMAIN,
//    DOTS_VERTICAL,
//    EMAIL,
//    EMAIL_OPEN,
//    EMAIL_OUTLINE,
//    EMOTICON,
//    EXCLAMATION,
//    EXPORT,
//    EYE,
//    EYE_OFF,
//    FACEBOOK,
//    FAST_FORWARD,
//    FILE_DOCUMENT_OUTLINE,
//    FILE_FIND,
//    FILE_IMAGE,
//    FILTER,
//    FILTER_VARIANT,
//    FIRE,
//    FIREWORK,
//    FLAG,
//    FOLDER,
//    FOLDER_NETWORK,
//    FOLDER_OPEN,
//    FORMAT_ALIGN_CENTER,
//    FORMAT_ALIGN_JUSTIFY,
//    FORMAT_ALIGN_LEFT,
//    FORMAT_ALIGN_RIGHT,
//    FORMAT_BOLD,
//    FORMAT_COLOR_FILL,
//    FORMAT_COLOR_TEXT,
//    FORMAT_ITALIC,
//    FORMAT_LIST_BULLETED_SQUARE,
//    FORMAT_UNDERLINE,
//    FORUM,
//    FORWARD,
//    GAVEL,
//    GESTURE_TAP_BUTTON,
//    GITHUB,
//    GLASS_WINE,
//    GMAIL,
//    HEART,
//    HEART_OUTLINE,
//    HEART_PULSE,
//    HELP_BOX,
//    HELP_CIRCLE_OUTLINE,
//    HISTORY,
//    HOME,
//    HOME_CITY,
//    HOME_OUTLINE,
//    HOME_VARIANT,
//    HUMAN_MALE_FEMALE_CHILD,
//    IMAGE,
//    IMAGE_EDIT_OUTLINE,
//    INBOX,
//    INBOX_ARROW_DOWN,
//    INFORMATION,
//    INFORMATION_OUTLINE,
//    INSTAGRAM,
//    INVERT_COLORS,
//    LABEL,
//    LANGUAGE_HTML5,
//    LANGUAGE_MARKDOWN,
//    LAPTOP,
//    LEAF,
//    LINKEDIN,
//    LOCK,
//    MAGNIFY,
//    MAGNIFY_MINUS_OUTLINE,
//    MAGNIFY_PLUS_OUTLINE,
//    MAP,
//    MAP_MARKER,
//    MATERIAL_DESIGN,
//    MENU,
//    MENU_DOWN,
//    MENU_LEFT,
//    MENU_RIGHT,
//    MESSAGE,
//    MESSAGE_OUTLINE,
//    MESSAGE_TEXT,
//    MICROPHONE,
//    MINUS,
//    MINUS_BOX,
//    MINUS_CIRCLE,
//    MONITOR,
//    MUSIC_NOTE_EIGHTH,
//    NATURE,
//    NODEJS,
//    NUMERIC_0_BOX,
//    NUMERIC_1_BOX,
//    NUMERIC_2_BOX,
//    NUMERIC_3_BOX,
//    NUMERIC_4_BOX,
//    NUMERIC_5_BOX,
//    NUMERIC_6_BOX,
//    NUMERIC_7_BOX,
//    NUMERIC_8_BOX,
//    NUMERIC_9_BOX,
//    OPEN_IN_NEW,
//    PAGE_NEXT,
//    PALETTE_OUTLINE,
//    PAPERCLIP,
//    PENCIL,
//    PHONE,
//    PHONE_IN_TALK,
//    PLAY,
//    PLUS,
//    RADIOBOX_BLANK,
//    RADIOBOX_MARKED,
//    RECORD,
//    REPLY,
//    REWIND,
//    RUN,
//    SCHOOL,
//    SEND,
//    SERVER_NETWORK,
//    SERVER_PLUS,
//    SHARE_VARIANT,
//    SHIELD_LOCK_OUTLINE,
//    SIGNAL_CELLULAR_OUTLINE,
//    SILVERWARE,
//    SILVERWARE_FORK_KNIFE,
//    SKIP_NEXT,
//    SKIP_PREVIOUS,
//    SNOWFLAKE,
//    SPEEDOMETER,
//    SQUARE,
//    STAR,
//    STAR_CIRCLE,
//    STAR_CIRCLE_OUTLINE,
//    STAR_HALF_FULL,
//    STAR_OUTLINE,
//    TABLET,
//    TAG,
//    TELEVISION,
//    TELEVISION_PLAY,
//    THUMB_DOWN,
//    THUMB_UP,
//    TICKET,
//    TRIANGLE,
//    TWITTER,
//    UNFOLD_MORE_HORIZONTAL,
//    UPDATE,
//    UPLOAD,
//    VIEW_DASHBOARD,
//    VIEW_DASHBOARD_OUTLINE,
//    VIEW_MODULE,
//    VOLUME_HIGH,
//    VUETIFY,
//    WHITE_BALANCE_SUNNY,
//    WIDGETS,
//    WIFI,
//    WIFI_STRENGTH_4,
//    WIFI_STRENGTH_ALERT_OUTLINE,
//    WINDOW_MAXIMIZE,
//    WINDOW_MINIMIZE,
//    WRENCH;
//
//    static Map<String, String> nonStandardIcons;
//
//    public static List<Icon> finds(UIBaseElement<?> root, MdiIcons iconName) {
//        if (getNonStandard().containsKey(iconName.value())) {
//            return root.finds(getNonStandard().get(iconName.value())).stream().map(Icon::toIcon).collect(Collectors.toList());
//        } else { return Icon.finds(root, iconName.value());}
//    }
//
//    public static Icon find(UIBaseElement<?> root, MdiIcons iconName) {
//        return finds(root, iconName).get(0);
//    }
//
//    public static Map<String, String> getNonStandard() {
//        if (nonStandardIcons == null) {
//            nonStandardIcons = new HashMap<>();
//            try {
//                CSVReader reader = new CSVReader(new FileReader("src/test/resources/nonStandardIcons.csv"));
//                String[] line;
//                while ((line = reader.readNext()) != null) {
//                    nonStandardIcons.put(line[1], line[0]);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return nonStandardIcons;
//    }
//
//    public String mdi() {
//        return "mdi-" + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, value());
//    }
//
//    public String text() {
//        return value().toLowerCase(Locale.ROOT).replace("_", " ");
//    }
//
//    public String svg() {
//        String nonStandard = getNonStandard().get(value());
//        if (nonStandard != null && nonStandard.charAt(0) == 'M' && nonStandard.charAt(nonStandard.length() - 1) == 'Z') {
//            return nonStandard;
//        } else {
//            return Icon.getMdiMap().get(value());
//        }
//    }
//
//    public String value() {
//        return this.toString();
//    }
//}
//

package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.datePickersMonthPage;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.GREEN_LIGHTEN_1;
import static io.github.com.pages.DatePickersMonthPage.allowedMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.buttonCancelMenu;
import static io.github.com.pages.DatePickersMonthPage.buttonOkDialog;
import static io.github.com.pages.DatePickersMonthPage.buttonOkMenu;
import static io.github.com.pages.DatePickersMonthPage.firstColorMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.firstWidthMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.iconsMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.multipleMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.orientationMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.orientationSwitcher;
import static io.github.com.pages.DatePickersMonthPage.pickerInDialogMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.pickerInMenuMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.readonlyMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.swedishMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.thaiMonthPicker;
import static org.hamcrest.Matchers.is;

public class DatePickersMonthTests extends TestsInit {
    private final LocalDate date = LocalDate.now();
    private final DateTimeFormatter formatterYearHyphenMonth =
            DateTimeFormatter.ofPattern("YYYY-MM");

    private static final String NEXT_YEAR_ICON_CLASS = "mdi-skip-next";
    private static final String PREVIOUS_YEAR_ICON_CLASS = "mdi-skip-previous";
    private static final String ADDITIONAL_YEAR_ICON_CLASS = "mdi-calendar-blank";
    private static final int CHOSEN_DAY = 15;
    private static final String EMPTY_MONTH_FIELD = "-";
    private static final String SELECTION_TEXT = " selected";
    private static final int WIDTH_OF_PREDEFINED_WIDTH_DP = 290;
    private static final int HEIGHT = 378;
    private static final List<String> CHECKED_MULTIPLE_MONTHS =
            Arrays.asList("Jan", "Apr", "Aug", "Oct", "Dec");
    private static final List<String> THAI_SHORT_MONTHS =
            Arrays.asList("ม.ค.", "ก.พ.", "มี.ค.", "เม.ย.",
            "พ.ค.", "มิ.ย.", "ก.ค.", "ส.ค.", "ก.ย.", "ต.ค.", "พ.ย.", "ธ.ค.");
    private static final List<String> THAI_FULL_MONTHS =
            Arrays.asList("มกราคม", "กุมภาพันธ์", "มีนาคม",
            "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม");
    private static final List<String> SWEDISH_SHORT_MONTHS =
            Arrays.asList("Jan.", "Feb.", "Mars", "Apr.",
            "Maj", "Juni", "Juli", "Aug.", "Sep.", "Okt.", "Nov.", "Dec.");
    private static final List<String> SWEDISH_FULL_MONTHS =
            Arrays.asList("januari", "februari", "mars",
            "april", "maj", "juni", "juli", "augusti", "september", "oktober", "november", "december");

    private final int currentYear = Year.now().getValue();

    private final String currentMonthFull = date.getMonth().toString().charAt(0)
            + date.getMonth().toString().substring(1).toLowerCase();
    private final String chosenMonthFull = date.minusMonths(1).getMonth().toString().charAt(0)
            + date.minusMonths(1).getMonth().toString().substring(1).toLowerCase();
    private final String chosenMonthTwoFull = date.plusMonths(1).getMonth().toString().charAt(0)
            + date.plusMonths(1).getMonth().toString().substring(1).toLowerCase();
    private final String chosenMonth = chosenMonthFull.substring(0, 3);
    private final String chosenMonthTwo = chosenMonthTwoFull.substring(0, 3);

    @BeforeClass
    public void beforeTest() {
        datePickersMonthPage.open();
        waitCondition(() -> datePickersMonthPage.isOpened());
        datePickersMonthPage.checkOpened();
    }

    @Test(description = "Test checks that enabled months are clickable and disabled months are not clickable")
    public void allowedMonthPickerTest() {
        allowedMonthPicker.show();
        allowedMonthPicker.has().enabledMonthsNonEmptyList();
        allowedMonthPicker.has().disabledMonthsNonEmptyList();
        allowedMonthPicker.has().clickableEnabledMonths();
        allowedMonthPicker.has().nonClickableDisabledMonths();
    }

    @Test
    public void colorsMonthPickerTest() {
        firstColorMonthPicker.show();
        firstColorMonthPicker.has().backgroundColor(GREEN_LIGHTEN_1.value());
        firstColorMonthPicker.has().color(BLACK_TRANSPARENT_087.value());
    }

    @Test(description = "Change date month picker test")
    public void changeDateMonthPickerTest() {
        firstColorMonthPicker.show();
        firstColorMonthPicker.selectMonth(chosenMonth);
        firstColorMonthPicker.has().month(chosenMonthFull);
        firstColorMonthPicker.selectMonth(chosenMonthTwo);
        firstColorMonthPicker.has().month(chosenMonthTwoFull)
                .and().year(currentYear);
        firstColorMonthPicker.nextYear();
        firstColorMonthPicker.has().year(currentYear + 1);
        firstColorMonthPicker.selectMonth(chosenMonth);
        firstColorMonthPicker.changeYear();
        firstColorMonthPicker.selectYear(currentYear + 99);
        firstColorMonthPicker.has().year(currentYear + 99);
        firstColorMonthPicker.changeYearCornerButton();
        firstColorMonthPicker.selectYear(currentYear);
        firstColorMonthPicker.has().year(currentYear);
    }

    @Test(description = "Test checks that month picker has proper icons")
    public void iconsMonthPickerTest() {
        iconsMonthPicker.show();
        iconsMonthPicker.has().nextYearIconClass(NEXT_YEAR_ICON_CLASS)
                .and().previousYearIconClass(PREVIOUS_YEAR_ICON_CLASS)
                .and().additionalYearIcon()
                .and().additionalYearIconClass(ADDITIONAL_YEAR_ICON_CLASS);
    }

    @Test(description = "Test checks that month picker is multiple")
    public void multipleMonthPickerTest() {
        multipleMonthPicker.show();
        List<String> firstlyActiveMonths = multipleMonthPicker.getAllActiveMonths();
        CHECKED_MULTIPLE_MONTHS.stream().forEach(elem -> {
            if (!firstlyActiveMonths.contains(elem)) {
                multipleMonthPicker.selectMonth(elem);
            }
        });
        firstlyActiveMonths.addAll(CHECKED_MULTIPLE_MONTHS);
        Set<String> allExpectedChosenMonths = new HashSet<>(firstlyActiveMonths);
        multipleMonthPicker.has().properSetOfActiveMonths(allExpectedChosenMonths)
                .and().month(allExpectedChosenMonths.size() + SELECTION_TEXT);
        allExpectedChosenMonths.stream().forEach(elem -> multipleMonthPicker.selectMonth(elem));
        multipleMonthPicker.has().month(EMPTY_MONTH_FIELD);
        multipleMonthPicker.selectMonth(chosenMonth);
        multipleMonthPicker.has().month(chosenMonthFull);
    }

    @Test(description = "Test checks that month picker is readonly")
    public void readOnlyMonthPickerTest() {
        readonlyMonthPicker.show();
        readonlyMonthPicker.selectMonth(chosenMonth);
        readonlyMonthPicker.has().month(currentMonthFull);
        readonlyMonthPicker.selectMonth(chosenMonthTwo);
        readonlyMonthPicker.has().month(currentMonthFull);
    }

    @Test(description = "Test checks month picker measurements")
    public void measurementMonthPickerTest() {
        firstWidthMonthPicker.show();
        firstWidthMonthPicker.has().width(WIDTH_OF_PREDEFINED_WIDTH_DP)
                .and().height(HEIGHT);
    }

    @Test(description = "Test shows how to work with expandable month pickers")
    public void dialogAndMenuMonthPickerTest() {
        pickerInMenuMonthPicker.show();
        pickerInMenuMonthPicker.expand();
        pickerInMenuMonthPicker.has().resultDate(date.format(formatterYearHyphenMonth));
        pickerInMenuMonthPicker.selectMonth(chosenMonth);
        pickerInMenuMonthPicker.has().resultDate(LocalDate.of(currentYear, Month.valueOf(chosenMonthFull.
                toUpperCase(Locale.ROOT)), CHOSEN_DAY).format(formatterYearHyphenMonth));
        pickerInMenuMonthPicker.selectMonth(chosenMonthTwo);
        pickerInMenuMonthPicker.has().resultDate(LocalDate.of(currentYear, Month.valueOf(chosenMonthTwoFull.
                toUpperCase(Locale.ROOT)), CHOSEN_DAY).format(formatterYearHyphenMonth));
        buttonOkMenu.click();
        pickerInMenuMonthPicker.expand();
        pickerInMenuMonthPicker.has().notMonthField();
        buttonCancelMenu.click();
        pickerInDialogMonthPicker.expand();
        pickerInDialogMonthPicker.has().monthField();
        buttonOkDialog.click();
    }

    @Test(description = "Test shows how to work with internationalized month picker")
    public void internationalizationMonthPickerTest() {
        waitCondition(() -> thaiMonthPicker.isVisible());
        jdiAssert(swedishMonthPicker.getAllMonths(), is(SWEDISH_SHORT_MONTHS));
        List<String> shownSwedishMonths = new ArrayList<>();
        SWEDISH_SHORT_MONTHS.stream().forEach(elem -> {
            swedishMonthPicker.selectMonth(elem.toLowerCase());
            swedishMonthPicker.hoverMonth(elem.toLowerCase());
            shownSwedishMonths.add(swedishMonthPicker.getMonth());
        });
        jdiAssert(shownSwedishMonths, is(SWEDISH_FULL_MONTHS));

        jdiAssert(thaiMonthPicker.getAllMonths(), is(THAI_SHORT_MONTHS));
        List<String> shownThaiMonths = new ArrayList<>();
        THAI_SHORT_MONTHS.stream().forEach(elem -> {
            thaiMonthPicker.selectMonth(elem);
            thaiMonthPicker.hoverMonth(elem);
            shownThaiMonths.add(thaiMonthPicker.getMonth());
        });
        jdiAssert(shownThaiMonths, is(THAI_FULL_MONTHS));
    }

    @Test(description = "Test checks orientation of month picker")
    public void orientationMonthPickerTest() {
        orientationMonthPicker.show();
        orientationMonthPicker.has().portraitOrientation();
        orientationSwitcher.check();
        orientationMonthPicker.has().landscapeOrientation();
    }

    @Test(description = "Test checks month picker's theme")
    public void testThemeMonthPicker() {
        orientationMonthPicker.show();
        orientationMonthPicker.has().darkTheme();
        thaiMonthPicker.show();
        thaiMonthPicker.has().lightTheme();
    }

    @Test(description = "Test checks month picker's elevation")
    public void testMonthPicker() {
        orientationMonthPicker.show();
        orientationMonthPicker.is().elevated()
                .and().has().elevation(10);
    }
}

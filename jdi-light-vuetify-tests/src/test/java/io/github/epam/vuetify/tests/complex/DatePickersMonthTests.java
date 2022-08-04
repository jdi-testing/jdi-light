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
import static io.github.com.pages.DatePickersMonthPage.allowedMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.firstColorMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.firstShowCurrentMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.firstWidthMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.iconsMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.mainWindow;
import static io.github.com.pages.DatePickersMonthPage.multipleMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.orientationMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.pickerInDialogMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.pickerInMenuMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.readonlyMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.secondColorMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.secondShowCurrentMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.secondWidthMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.swedishMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.thaiMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.buttonOkDialog;
import static io.github.com.pages.DatePickersMonthPage.buttonOkMenu;
import static io.github.com.pages.DatePickersMonthPage.buttonCancelMenu;
import static org.hamcrest.Matchers.is;

public class DatePickersMonthTests extends TestsInit {
    private LocalDate date = LocalDate.now();
    private DateTimeFormatter formatterYearHyphenMonth = DateTimeFormatter.ofPattern("YYYY-MM");

    private static final String NEXT_YEAR_ICON_CLASS = "mdi-skip-next";
    private static final String PREVIOUS_YEAR_ICON_CLASS = "mdi-skip-previous";
    private static final String GREEN_COLOR_HEX = "#66bb6a";
    private static final String BLUE_COLOR_HEX = "#1976d2";
    private static final int CHOSEN_DAY = 15;
    private static final String EMPTY_MONTH_FIELD = "-";
    private static final String SELECTION_TEXT = " selected";
    private static final String MONTH_BORDER = "1px";
    private static final int WIDTH_OF_PREDEFINED_WIDTH_DP = 290;

    private static final List<String> CHECKED_MULTIPLE_MONTHS = Arrays.asList("Jan", "Apr", "Aug", "Oct", "Dec");
    private static final List<String> THAI_SHORT_MONTHS = Arrays.asList("ม.ค.", "ก.พ.", "มี.ค.", "เม.ย.",
            "พ.ค.", "มิ.ย.", "ก.ค.", "ส.ค.", "ก.ย.", "ต.ค.", "พ.ย.", "ธ.ค.");
    private static final List<String> THAI_FULL_MONTHS = Arrays.asList("มกราคม", "กุมภาพันธ์", "มีนาคม",
            "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม");
    private static final List<String> SWEDISH_SHORT_MONTHS = Arrays.asList("Jan.", "Feb.", "Mars", "Apr.",
            "Maj", "Juni", "Juli", "Aug.", "Sep.", "Okt.", "Nov.", "Dec.");
    private static final List<String> SWEDISH_FULL_MONTHS = Arrays.asList("januari", "februari", "mars",
            "april", "maj", "juni", "juli", "augusti", "september", "oktober", "november", "december");

    private int currentYear = Year.now().getValue();

    private String currentMonthFull = date.getMonth().toString().substring(0, 1)
            + date.getMonth().toString().substring(1).toLowerCase();
    private String chosenMonthFull = date.minusMonths(1).getMonth().toString().substring(0, 1)
            + date.minusMonths(1).getMonth().toString().substring(1).toLowerCase();
    private String chosenMonthTwoFull = date.plusMonths(1).getMonth().toString().substring(0, 1)
            + date.plusMonths(1).getMonth().toString().substring(1).toLowerCase();
    private String chosenMonth = chosenMonthFull.substring(0, 3);
    private String chosenMonthTwo = chosenMonthTwoFull.substring(0, 3);

    @BeforeClass
    public void beforeTest() {
        datePickersMonthPage.open();
        waitCondition(() -> datePickersMonthPage.isOpened());
        datePickersMonthPage.checkOpened();
    }

    @Test
    public void testAllowedMonthPicker() {
        waitCondition(() -> allowedMonthPicker.isVisible());
        allowedMonthPicker.has().disabledMonthsNonEmptyList();
        allowedMonthPicker.getEnabledMonths();
        allowedMonthPicker.has().clickableEnabledMonths();
        allowedMonthPicker.has().nonClickableDisabledMonths();
    }

    @Test
    public void testColorsMonthPicker() {
        waitCondition(() -> firstColorMonthPicker.isVisible());
        firstColorMonthPicker.has().color(GREEN_COLOR_HEX);
        secondColorMonthPicker.has().color(BLUE_COLOR_HEX);
        firstColorMonthPicker.selectMonth(chosenMonth);
        firstColorMonthPicker.has().month(chosenMonthFull);
        firstColorMonthPicker.selectMonth(chosenMonthTwo);
        firstColorMonthPicker.has().month(chosenMonthTwoFull);
        firstColorMonthPicker.has().year(currentYear);
        firstColorMonthPicker.nextYear();
        firstColorMonthPicker.has().year(currentYear + 1);
        firstColorMonthPicker.previousYear();
        firstColorMonthPicker.previousYear();
        firstColorMonthPicker.has().year(currentYear - 1);
        firstColorMonthPicker.selectMonth(chosenMonth);
        firstColorMonthPicker.changeYear();
        firstColorMonthPicker.selectYear(currentYear + 99);
        firstColorMonthPicker.has().year(currentYear + 99);
        firstColorMonthPicker.changeYear();
        firstColorMonthPicker.selectYear(currentYear);
        firstColorMonthPicker.changeYear();
        firstColorMonthPicker.selectYear(currentYear - 100);
        firstColorMonthPicker.has().year(currentYear - 100);
        firstColorMonthPicker.changeYearCornerButton();
        firstColorMonthPicker.selectYear(currentYear);
        firstColorMonthPicker.has().year(currentYear);
    }

    @Test
    public void testIconsMonthPicker() {
        waitCondition(() -> iconsMonthPicker.isVisible());
        iconsMonthPicker.has().nextYearIconClass(NEXT_YEAR_ICON_CLASS);
        iconsMonthPicker.has().previousYearIconClass(PREVIOUS_YEAR_ICON_CLASS);
        iconsMonthPicker.has().additionalYearIcon();
    }

    @Test
    public void testMultipleMonthPicker() {
        waitCondition(() -> multipleMonthPicker.isVisible());
        List<String> firstlyActiveMonths = multipleMonthPicker.getAllActiveMonths();
        CHECKED_MULTIPLE_MONTHS.stream().forEach(elem -> {
            if (!firstlyActiveMonths.contains(elem)) {
                multipleMonthPicker.selectMonth(elem);
            }
        });
        firstlyActiveMonths.addAll(CHECKED_MULTIPLE_MONTHS);
        Set<String> allExpectedChosenMonths = new HashSet<>(firstlyActiveMonths);
        multipleMonthPicker.has().properSetOfActiveMonths(allExpectedChosenMonths);
        multipleMonthPicker.has().month(allExpectedChosenMonths.size() + SELECTION_TEXT);
        allExpectedChosenMonths.stream().forEach(elem -> multipleMonthPicker.selectMonth(elem));
        multipleMonthPicker.has().month(EMPTY_MONTH_FIELD);
        multipleMonthPicker.selectMonth(chosenMonth);
        multipleMonthPicker.has().month(chosenMonthFull);
    }

    @Test
    public void testReadOnlyMonthPicker() {
        waitCondition(() -> readonlyMonthPicker.isVisible());
        readonlyMonthPicker.selectMonth(chosenMonth);
        readonlyMonthPicker.has().month(currentMonthFull);
        readonlyMonthPicker.selectMonth(chosenMonthTwo);
        readonlyMonthPicker.has().month(currentMonthFull);
    }

    @Test
    public void testShowCurrentMonthPicker() {
        waitCondition(() -> firstShowCurrentMonthPicker.isVisible());
        firstShowCurrentMonthPicker.has().month(currentMonthFull);
        secondShowCurrentMonthPicker.has().properOutlinedMonthBorder(MONTH_BORDER);
    }

    @Test
    public void testWidthMonthPicker() {
        waitCondition(() -> firstWidthMonthPicker.isVisible());
        firstWidthMonthPicker.has().pickerWidth(WIDTH_OF_PREDEFINED_WIDTH_DP);
        secondWidthMonthPicker.has().pickerWidth(mainWindow.getSize().getWidth());
    }

    @Test
    public void testDialogAndMenuMonthPicker() {
        waitCondition(() -> pickerInMenuMonthPicker.isVisible());
        pickerInMenuMonthPicker.expand();
        pickerInMenuMonthPicker.has().resultDate(date.format(formatterYearHyphenMonth));
        pickerInMenuMonthPicker.selectMonth(chosenMonth);
        pickerInMenuMonthPicker.has().resultDate(LocalDate.of(currentYear, Month.valueOf(chosenMonthFull.
                toUpperCase(Locale.ROOT)), CHOSEN_DAY).format(formatterYearHyphenMonth));
        pickerInMenuMonthPicker.selectMonth(chosenMonthTwo);
        pickerInMenuMonthPicker.has().resultDate(LocalDate.of(currentYear, Month.valueOf(chosenMonthTwoFull.
                toUpperCase(Locale.ROOT)), CHOSEN_DAY).format(formatterYearHyphenMonth));
        pickerInMenuMonthPicker.nextYear();
        pickerInMenuMonthPicker.has().year(currentYear + 1);
        pickerInMenuMonthPicker.previousYear();
        pickerInMenuMonthPicker.previousYear();
        pickerInMenuMonthPicker.has().year(currentYear - 1);
        pickerInMenuMonthPicker.changeYear();
        pickerInMenuMonthPicker.selectYear(currentYear + 99);
        pickerInMenuMonthPicker.has().year(currentYear + 99);
        pickerInMenuMonthPicker.changeYear();
        pickerInMenuMonthPicker.selectYear(currentYear);
        pickerInMenuMonthPicker.changeYear();
        pickerInMenuMonthPicker.selectYear(currentYear - 100);
        pickerInMenuMonthPicker.has().year(currentYear - 100);
        buttonOkMenu.clickOk();
        pickerInMenuMonthPicker.expand();
        pickerInMenuMonthPicker.has().monthFieldIsNotExist();
        buttonCancelMenu.clickCancel();
        pickerInDialogMonthPicker.expand();
        pickerInDialogMonthPicker.has().monthField();
        buttonOkDialog.clickOk();
    }

    @Test
    public void testInternationalizationMonthPicker() {
        waitCondition(() -> thaiMonthPicker.isVisible());
        jdiAssert(swedishMonthPicker.getAllMonths(), is(SWEDISH_SHORT_MONTHS),
                "For Swedish picker: shown and expected short month names are not the same");
        List<String> shownSwedishMonths = new ArrayList<>();
        SWEDISH_SHORT_MONTHS.stream().forEach(elem -> {
            swedishMonthPicker.selectMonth(elem.toLowerCase());
            swedishMonthPicker.hoverMonth(elem.toLowerCase());
            shownSwedishMonths.add(swedishMonthPicker.getMonth());
        });
        jdiAssert(shownSwedishMonths, is(SWEDISH_FULL_MONTHS),
                "For Swedish picker: shown and expected full month names are not the same");

        jdiAssert(thaiMonthPicker.getAllMonths(), is(THAI_SHORT_MONTHS),
                "For Thai picker: shown and expected short month names are not the same");
        List<String> shownThaiMonths = new ArrayList<>();
        THAI_SHORT_MONTHS.stream().forEach(elem -> {
            thaiMonthPicker.selectMonth(elem);
            thaiMonthPicker.hoverMonth(elem);
            shownThaiMonths.add(thaiMonthPicker.getMonth());
        });
        jdiAssert(shownThaiMonths, is(THAI_FULL_MONTHS),
                "For Thai picker: shown and expected full month names are not the same");
    }

    @Test
    public void testOrientationMonthPicker() {
        waitCondition(() -> orientationMonthPicker.isVisible());
        orientationMonthPicker.has().portraitOrientation();
        orientationMonthPicker.switchOrientation();
        orientationMonthPicker.has().landscapeOrientation();
    }
}

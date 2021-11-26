package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.tools.Timer;
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
import static io.github.com.StaticSite.datePickersMonthPage;
import static io.github.com.pages.DatePickersMonthPage.allowedMP;
import static io.github.com.pages.DatePickersMonthPage.firstColorMP;
import static io.github.com.pages.DatePickersMonthPage.firstShowCurrentMP;
import static io.github.com.pages.DatePickersMonthPage.firstWidthMP;
import static io.github.com.pages.DatePickersMonthPage.iconsMP;
import static io.github.com.pages.DatePickersMonthPage.mainWindow;
import static io.github.com.pages.DatePickersMonthPage.multipleMP;
import static io.github.com.pages.DatePickersMonthPage.orientationMP;
import static io.github.com.pages.DatePickersMonthPage.pickerInDialogMP;
import static io.github.com.pages.DatePickersMonthPage.pickerInMenuMP;
import static io.github.com.pages.DatePickersMonthPage.readonlyMP;
import static io.github.com.pages.DatePickersMonthPage.secondColorMP;
import static io.github.com.pages.DatePickersMonthPage.secondShowCurrentMP;
import static io.github.com.pages.DatePickersMonthPage.secondWidthMP;
import static io.github.com.pages.DatePickersMonthPage.swedishMP;
import static io.github.com.pages.DatePickersMonthPage.thaiMP;
import static org.hamcrest.Matchers.is;

public class DatePickersMonthTests extends TestsInit {
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatterYearHyphenMonth = DateTimeFormatter.ofPattern("YYYY-MM");

    public static final String NEXT_YEAR_ICON_CLASS = "mdi-skip-next";
    public static final String PREVIOUS_YEAR_ICON_CLASS = "mdi-skip-previous";
    public static final String GREEN_COLOR_HEX = "#66bb6a";
    public static final String BLUE_COLOR_HEX = "#1976d2";
    public static final String CHOSEN_DAY = "15";
    public static final String EMPTY_MONTH_FIELD = "-";
    public static final String SELECTION_TEXT = " selected";
    public static final String MONTH_BORDER = "1px";
    public static final int WIDTH_OF_PREDEFINED_WIDTH_DP = 290;

    public static final List<String> CHECKED_MULTIPLE_MONTHS = Arrays.asList("Jan", "Apr", "Aug", "Oct", "Dec");
    public static final List<String> THAI_SHORT_MONTHS = Arrays.asList("ม.ค.", "ก.พ.", "มี.ค.", "เม.ย.",
            "พ.ค.", "มิ.ย.", "ก.ค.", "ส.ค.", "ก.ย.", "ต.ค.", "พ.ย.", "ธ.ค.");
    public static final List<String> THAI_FULL_MONTHS = Arrays.asList("มกราคม", "กุมภาพันธ์", "มีนาคม",
            "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม");
    public static final List<String> SWEDISH_SHORT_MONTHS = Arrays.asList("Jan.", "Feb.", "Mars", "Apr.",
            "Maj", "Juni", "Juli", "Aug.", "Sep.", "Okt.", "Nov.", "Dec.");
    public static final List<String> SWEDISH_FULL_MONTHS = Arrays.asList("januari", "februari", "mars",
            "april", "maj", "juni", "juli", "augusti", "september", "oktober", "november", "december");

    int currentYear = Year.now().getValue();

    String currentMonthFull = date.getMonth().toString().substring(0, 1)
            + date.getMonth().toString().substring(1).toLowerCase();
    String chosenMonthFull = date.minusMonths(1).getMonth().toString().substring(0, 1)
            + date.minusMonths(1).getMonth().toString().substring(1).toLowerCase();
    String chosenMonthTwoFull = date.plusMonths(1).getMonth().toString().substring(0, 1)
            + date.plusMonths(1).getMonth().toString().substring(1).toLowerCase();
    String chosenMonth = chosenMonthFull.substring(0, 3);
    String chosenMonthTwo = chosenMonthTwoFull.substring(0, 3);

    @BeforeClass
    public void beforeTest() {
        datePickersMonthPage.open();
    }

    @Test
    public void testAllowedMonthPicker() {
        Timer.waitCondition(() -> allowedMP.isVisible());
        allowedMP.has().disabledMonthsNonEmptyList();
        allowedMP.getEnabledMonths();
        allowedMP.has().clickableEnabledMonths();
        allowedMP.has().nonClickableDisabledMonths();
    }

    @Test
    public void testColorsMonthPicker() {
        Timer.waitCondition(() -> firstColorMP.isVisible());
        firstColorMP.has().color(GREEN_COLOR_HEX);
        secondColorMP.has().color(BLUE_COLOR_HEX);
        firstColorMP.selectMonth(chosenMonth);
        firstColorMP.has().month(chosenMonthFull);
        firstColorMP.selectMonth(chosenMonthTwo);
        firstColorMP.has().month(chosenMonthTwoFull);
        firstColorMP.has().year(Integer.toString(currentYear));
        firstColorMP.nextYear();
        firstColorMP.has().year(Integer.toString(currentYear + 1));
        firstColorMP.previousYear();
        firstColorMP.previousYear();
        firstColorMP.has().year(Integer.toString(currentYear - 1));
        firstColorMP.selectMonth(chosenMonth);
        firstColorMP.changeYear();
        firstColorMP.selectYear(Integer.toString(currentYear + 99));
        firstColorMP.has().year(Integer.toString(currentYear + 99));
        firstColorMP.changeYear();
        firstColorMP.selectYear(Integer.toString(currentYear));
        firstColorMP.changeYear();
        firstColorMP.selectYear(Integer.toString(currentYear - 100));
        firstColorMP.has().year(Integer.toString(currentYear - 100));
        firstColorMP.changeYearCornerButton();
        firstColorMP.selectYear(Integer.toString(currentYear));
        firstColorMP.has().year(Integer.toString(currentYear));
    }

    @Test
    public void testIconsMonthPicker() {
        Timer.waitCondition(() -> iconsMP.isVisible());
        iconsMP.has().nextYearIconClass(NEXT_YEAR_ICON_CLASS);
        iconsMP.has().previousYearIconClass(PREVIOUS_YEAR_ICON_CLASS);
        iconsMP.has().additionalYearIcon();
    }

    @Test
    public void testMultipleMonthPicker() {
        Timer.waitCondition(() -> multipleMP.isVisible());
        List<String> firstlyActiveMonths = multipleMP.getAllActiveMonths();
        CHECKED_MULTIPLE_MONTHS.stream().forEach(elem -> {
            if (!firstlyActiveMonths.contains(elem)) {
                multipleMP.selectMonth(elem);
            }
        });
        firstlyActiveMonths.addAll(CHECKED_MULTIPLE_MONTHS);
        Set<String> allExpectedChosenMonths = new HashSet<>(firstlyActiveMonths);
        multipleMP.has().properSetOfActiveMonths(allExpectedChosenMonths);
        multipleMP.has().month(allExpectedChosenMonths.size() + SELECTION_TEXT);
        allExpectedChosenMonths.stream().forEach(elem -> multipleMP.selectMonth(elem));
        multipleMP.has().month(EMPTY_MONTH_FIELD);
        multipleMP.selectMonth(chosenMonth);
        multipleMP.has().month(chosenMonthFull);
    }

    @Test
    public void testReadOnlyMonthPicker() {
        Timer.waitCondition(() -> readonlyMP.isVisible());
        readonlyMP.selectMonth(chosenMonth);
        readonlyMP.has().month(currentMonthFull);
        readonlyMP.selectMonth(chosenMonthTwo);
        readonlyMP.has().month(currentMonthFull);
    }

    @Test
    public void testShowCurrentMonthPicker() {
        Timer.waitCondition(() -> firstShowCurrentMP.isVisible());
        firstShowCurrentMP.has().month(currentMonthFull);
        secondShowCurrentMP.has().properOutlinedMonthBorder(MONTH_BORDER);
    }

    @Test
    public void testWidthMonthPicker() {
        Timer.waitCondition(() -> firstWidthMP.isVisible());
        firstWidthMP.has().pickerWidth(WIDTH_OF_PREDEFINED_WIDTH_DP);
        secondWidthMP.has().pickerWidth(mainWindow.getSize().getWidth());
    }

    @Test
    public void testDialogAndMenuMonthPicker() {
        Timer.waitCondition(() -> pickerInMenuMP.isVisible());
        pickerInMenuMP.expand();
        pickerInMenuMP.has().resultDate(date.format(formatterYearHyphenMonth));
        pickerInMenuMP.selectMonth(chosenMonth);
        pickerInMenuMP.has().resultDate(LocalDate.of(currentYear, Month.valueOf(chosenMonthFull.
                toUpperCase(Locale.ROOT)), Integer.parseInt(CHOSEN_DAY)).format(formatterYearHyphenMonth));
        pickerInMenuMP.selectMonth(chosenMonthTwo);
        pickerInMenuMP.has().resultDate(LocalDate.of(currentYear, Month.valueOf(chosenMonthTwoFull.
                toUpperCase(Locale.ROOT)), Integer.parseInt(CHOSEN_DAY)).format(formatterYearHyphenMonth));
        pickerInMenuMP.nextYear();
        pickerInMenuMP.has().year(Integer.toString(currentYear + 1));
        pickerInMenuMP.previousYear();
        pickerInMenuMP.previousYear();
        pickerInMenuMP.has().year(Integer.toString(currentYear - 1));
        pickerInMenuMP.changeYear();
        pickerInMenuMP.selectYear(Integer.toString(currentYear + 99));
        pickerInMenuMP.has().year(Integer.toString(currentYear + 99));
        pickerInMenuMP.changeYear();
        pickerInMenuMP.selectYear(Integer.toString(currentYear));
        pickerInMenuMP.changeYear();
        pickerInMenuMP.selectYear(Integer.toString(currentYear - 100));
        pickerInMenuMP.has().year(Integer.toString(currentYear - 100));
        pickerInMenuMP.clickOk();
        pickerInMenuMP.expand();
        pickerInMenuMP.has().monthFieldIsNotExist();
        pickerInMenuMP.clickCancel();
        pickerInDialogMP.expand();
        pickerInDialogMP.has().monthField();
        pickerInDialogMP.clickOk();
    }

    @Test
    public void testInternationalizationMonthPicker() {
        Timer.waitCondition(() -> thaiMP.isVisible());
        jdiAssert(swedishMP.getAllMonths(), is(SWEDISH_SHORT_MONTHS),
                "For Swedish picker: shown and expected short month names are not the same");
        List<String> shownSwedishMonths = new ArrayList<>();
        SWEDISH_SHORT_MONTHS.stream().forEach(elem -> {
            swedishMP.selectMonth(elem.toLowerCase());
            swedishMP.hoverMonth(elem.toLowerCase());
            shownSwedishMonths.add(swedishMP.getMonth());
        });
        jdiAssert(shownSwedishMonths, is(SWEDISH_FULL_MONTHS),
                "For Swedish picker: shown and expected full month names are not the same");

        jdiAssert(thaiMP.getAllMonths(), is(THAI_SHORT_MONTHS),
                "For Thai picker: shown and expected short month names are not the same");
        List<String> shownThaiMonths = new ArrayList<>();
        THAI_SHORT_MONTHS.stream().forEach(elem -> {
            thaiMP.selectMonth(elem);
            thaiMP.hoverMonth(elem);
            shownThaiMonths.add(thaiMP.getMonth());
        });
        jdiAssert(shownThaiMonths, is(THAI_FULL_MONTHS),
                "For Thai picker: shown and expected full month names are not the same");
    }

    @Test
    public void testOrientationMonthPicker() {
        Timer.waitCondition(() -> orientationMP.isVisible());
        orientationMP.has().portraitOrientation();
        orientationMP.switchOrientation();
        orientationMP.has().landscapeOrientation();
    }
}

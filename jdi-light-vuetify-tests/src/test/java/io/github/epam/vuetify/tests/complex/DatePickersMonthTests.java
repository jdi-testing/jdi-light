package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.datePickersMonthPage;
import static io.github.com.pages.DatePickersMonthPage.activeMonthButtonFirstShowCurrentPicker;
import static io.github.com.pages.DatePickersMonthPage.activeMonthButtonReadonlyPicker;
import static io.github.com.pages.DatePickersMonthPage.activeMonthButtonsAllowedMP;
import static io.github.com.pages.DatePickersMonthPage.activeMonthButtonsMultipleDP;
import static io.github.com.pages.DatePickersMonthPage.additionalYearIconIconsDP;
import static io.github.com.pages.DatePickersMonthPage.allowedMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.colorsMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.disabledMonths;
import static io.github.com.pages.DatePickersMonthPage.firstSectionWidthMP;
import static io.github.com.pages.DatePickersMonthPage.landscapeOrientedMonthSection;
import static io.github.com.pages.DatePickersMonthPage.leftArrowIconsDP;
import static io.github.com.pages.DatePickersMonthPage.mainWindowMonthPickers;
import static io.github.com.pages.DatePickersMonthPage.monthPickerInDialog;
import static io.github.com.pages.DatePickersMonthPage.monthPickerInMenu;
import static io.github.com.pages.DatePickersMonthPage.multipleMonthButtons;
import static io.github.com.pages.DatePickersMonthPage.orientationSwitcher;
import static io.github.com.pages.DatePickersMonthPage.outlinedButtonShowCurrentPicker;
import static io.github.com.pages.DatePickersMonthPage.pickerInDialogMonthField;
import static io.github.com.pages.DatePickersMonthPage.pickerInDialogMonthOkButton;
import static io.github.com.pages.DatePickersMonthPage.portraitOrientedMonthSection;
import static io.github.com.pages.DatePickersMonthPage.readonlyMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.rightArrowIconsDP;
import static io.github.com.pages.DatePickersMonthPage.secondSectionWidthMP;
import static io.github.com.pages.DatePickersMonthPage.secondShowCurrentMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.swedishMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.thaiMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.yearColorMPDropdown;
import static io.github.com.pages.DatePickersMonthPage.yearSmallButton;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class DatePickersMonthTests extends TestsInit {
    //LocalDate date = LocalDate.now();

    DateTimeFormatter formatterYearHyphenMonth = DateTimeFormatter.ofPattern("YYYY-MM");

    public static final int WIDTH_OF_PREDEFINED_WIDTH_DP = 290;

    public static final String CHOSEN_MONTH = "may";
    public static final String CHOSEN_MONTH_TWO = "oct";
    public static final String CHOSEN_MONTH_TWO_FULL = "October";
    public static final String CHOSEN_MONTH_THREE = "nov";
    public static final String CHOSEN_MONTH_FOUR = "dec";

    public static final List<String> CHECKED_MONTHS = Arrays.asList("jan", "feb", "mar", "apr",
            "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec");

//    public static final List<String> CHECKED_THAI_MONTHS = Arrays.asList("ม.ค.", "ก.พ.", "มี.ค.", "เม.ย.",
//            "พ.ค.", "มิ.ย.", "ก.ค.", "ส.ค.", "ก.ย.", "ต.ค.", "พ.ย.", "ธ.ค.");

    public static final List<String> CHECKED_THAI_FULL_MONTHS = Arrays.asList("มกราคม", "กุมภาพันธ์", "มีนาคม",
            "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม");

    public static final List<String> CHECKED_SWEDISH_MONTHS = Arrays.asList("jan.", "feb.", "mars", "apr.",
            "maj", "juni", "juli", "aug.", "sep.", "okt.", "nov.", "dec.");

//    public static final List<String> CHECKED_SWEDISH_FULL_MONTHS = Arrays.asList("januari", "februari", "mars",
//            "april", "maj", "juni", "juli", "augusti", "september", "oktober", "november", "december");

    int currentYear = Year.now().getValue();
    int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    Timer timer;

    @BeforeClass
    public void beforeTest() {
        datePickersMonthPage.open();
    }

    @Test
    public void testAllowedMonthPicker() {
        timer = new Timer(5000L);
        timer.wait(() -> allowedMonthPicker.isVisible());
        List<String> allDisabledMonths = disabledMonths.stream().map(elem
                -> elem.getText().toLowerCase()).collect(Collectors.toList());
        jdiAssert(allDisabledMonths.toArray(), not(emptyArray()),
                "There are no non-allowed elements");
        CHECKED_MONTHS.stream().forEach(elem -> {
            if (!allDisabledMonths.contains(elem)) {
                allowedMonthPicker.select(elem);
                jdiAssert(activeMonthButtonsAllowedMP.getText().toLowerCase(), is(elem),
                        "Allowed elements are not active after selection");
            }
        });
    }

    @Test
    public void testColorsMonthPicker() throws InterruptedException {
        // ADD GLOBAL TEST....................................................

        //colorsMonthPicker.expand();
        colorsMonthPicker.select(CHOSEN_MONTH);
        colorsMonthPicker.hover();

        //System.out.println("Month: " + colorsMonthPicker.getText());

        yearColorMPDropdown.expand();
        yearColorMPDropdown.select("2121");
        jdiAssert(yearColorMPDropdown.getText(), is("2121"),
                "After changing of year to latest accessible: shown year is wrong");


//        yearColorDPDropdown.expand();
//        yearColorDPDropdown.select(Integer.toString(currentYear));
//        yearColorDPDropdown.expand();
//        yearColorDPDropdown.select(Integer.toString(currentYear - 100));


        yearSmallButton.click();
        yearColorMPDropdown.select("2121");

        // TEST arrows as well


        Thread.sleep(3000);
    }

    @Test
    public void testIconsMonthPicker(){
        jdiAssert(leftArrowIconsDP.attr("class"), containsString("mdi-skip-previous"),
                "Left arrow in Icons date picker does not have required attributes");
        jdiAssert(rightArrowIconsDP.attr("class"), containsString("mdi-skip-next"),
                "Right arrow in Icons date picker does not have required attributes");
        jdiAssert(additionalYearIconIconsDP.isEnabled(), is(true),
                "There is no required additional picture for year area of Icons date picker");
    }

    @Test
    public void testMultipleMonthPicker() {
        List<String> allFirstlyActiveMonths = activeMonthButtonsMultipleDP.stream().map(elem
                -> elem.getText().toLowerCase()).collect(Collectors.toList());
        CHECKED_MONTHS.stream().forEach(elem -> {
            if (!allFirstlyActiveMonths.contains(elem)) {
                multipleMonthButtons.select(elem);
            }
        });
        allFirstlyActiveMonths.addAll(CHECKED_MONTHS);
        Set<String> allExpectedChosenMonths = new HashSet<>(allFirstlyActiveMonths);
        List<String> allSecondlyChosenMonths = activeMonthButtonsMultipleDP.stream().map(elem
                -> elem.getText().toLowerCase()).collect(Collectors.toList());
        jdiAssert(allSecondlyChosenMonths, containsInAnyOrder(allExpectedChosenMonths.toArray()),
                "Not all of chosen months became active");
        jdiAssert(multipleMonthButtons.getText(),
                is(allSecondlyChosenMonths.size() + " selected"),
                "Number of active months and number of months in the main field are different");
        allSecondlyChosenMonths.stream().forEach(elem -> multipleMonthButtons.select(elem));
        multipleMonthButtons.hover();
        jdiAssert(multipleMonthButtons.getText(),
                is("-"),
                "After deselection of all months: notification in the main field is incorrect");
        multipleMonthButtons.select(CHOSEN_MONTH_TWO);
        multipleMonthButtons.hover();
        jdiAssert(multipleMonthButtons.getText(),
                is(CHOSEN_MONTH_TWO_FULL),
                "After only one month has been selected: notification in the main field is incorrect");
    }

    @Test
    public void testReadOnlyMonthPicker() {
        String currentlyActiveMonth = activeMonthButtonReadonlyPicker.getText();
        CHECKED_MONTHS.stream().forEach(elem -> {
            if (!currentlyActiveMonth.equals(elem)) {
                readonlyMonthPicker.select(elem);
                jdiAssert(activeMonthButtonReadonlyPicker.getText(), is(currentlyActiveMonth),
                        "Other months but current month have been selected although they " +
                                "have to be read only");
            }
        });
    }

    @Test
    public void testShowCurrentMonthPicker() {
        String currentMonth = LocalDate.now().getMonth().
                getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();
        String outlinedMonth = outlinedButtonShowCurrentPicker.getText();
        jdiAssert(activeMonthButtonFirstShowCurrentPicker.getText(), is(currentMonth),
                "Current month and active month in first 'Show current' are not the same");
        jdiAssert(outlinedButtonShowCurrentPicker.css("border"), containsString("1px solid"),
                "Outlined date in Show current date picker does not have the border of 1 px");
        CHECKED_MONTHS.stream().forEach(elem -> {
            if (!outlinedMonth.toLowerCase().equals(elem)) {
                secondShowCurrentMonthPicker.select(elem);
                jdiAssert(outlinedButtonShowCurrentPicker.getText(), is(outlinedMonth),
                        "After changing of active month: outlined month is wrongly changed as well");
            }
        });
    }

    @Test
    public void testWidthMonthPicker() {
        jdiAssert(firstSectionWidthMP.getSize().getWidth(), is(WIDTH_OF_PREDEFINED_WIDTH_DP),
                "Width of first Width month picker is not equal to predefined value");
        jdiAssert(secondSectionWidthMP.getSize().getWidth(), is(mainWindowMonthPickers.getSize().getWidth()),
                "Width of full width month picker is not equal to width of main window");
    }

    @Test
    public void testDialogAndMenuMonthPicker() {
        monthPickerInMenu.expand();
        CHECKED_MONTHS.stream().forEach(elem -> {
            monthPickerInMenu.select(elem);
            Date date = null;
            try {
                date = new SimpleDateFormat("MMM").parse(elem);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            LocalDate chosenDateFormat = LocalDate.of(currentYear, (calendar.get(Calendar.MONTH) + 1), currentDay);
            String chosenDate = chosenDateFormat.format(formatterYearHyphenMonth);
            jdiAssert(monthPickerInMenu.getText(), is(chosenDate),
                    "After clicking the month in Picker in menu: shown date in the field is wrong");
        });
        monthPickerInDialog.expand();
        CHECKED_MONTHS.stream().forEach(elem -> {
            monthPickerInDialog.select(elem);
            Date date = null;
            try {
                date = new SimpleDateFormat("MMM").parse(elem);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            LocalDate chosenDateFormat = LocalDate.of(currentYear, (calendar.get(Calendar.MONTH) + 1), currentDay);
            String chosenDate = chosenDateFormat.format(formatterYearHyphenMonth);
            String chosenMonthFormatted = chosenDateFormat.getMonth().toString().substring(0, 1)
                    + chosenDateFormat.getMonth().toString().substring(1).toLowerCase();
            jdiAssert(monthPickerInDialog.getText(), is(chosenDate),
                    "After clicking the month in Picker in dialog: shown date in the field is wrong");
            jdiAssert(pickerInDialogMonthField.getText(), is(chosenMonthFormatted),
                    "After clicking the month in Picker in dialog: shown month in month field is wrong");
        });
        pickerInDialogMonthOkButton.click();
    }

    @Test
    public void testInternationalizationMonthPicker() {
        for (int i = 0; i < CHECKED_THAI_FULL_MONTHS.size(); i++) {
            thaiMonthPicker.select(i + 1);
            thaiMonthPicker.hover();
            jdiAssert(thaiMonthPicker.getText(), is(CHECKED_THAI_FULL_MONTHS.get(i)),
                    "After clicking the month in thai month picker: shown month in the field is wrong");
        }
        CHECKED_SWEDISH_MONTHS.stream().forEach(elem -> {
                    swedishMonthPicker.select(elem);
                    Date date = null;
                    try {
                        date = new SimpleDateFormat("MMM", new Locale("sv", "SE")).parse(elem);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    LocalDate chosenDateFormat = LocalDate.of(currentYear, (calendar.get(Calendar.MONTH) + 1),
                            currentDay);
                    String chosenMonthFormatted = chosenDateFormat.getMonth().
                            getDisplayName(TextStyle.FULL, new Locale("sv", "SE"));
                    swedishMonthPicker.hover();
                    jdiAssert(swedishMonthPicker.getText(), is(chosenMonthFormatted),
                            "After clicking the month in swedish month picker: " +
                                    "shown month in the field is wrong");
                }
        );
    }

    @Test
    public void testOrientationMonthPicker(){
        int landscapeOrientedTitleWidth = landscapeOrientedMonthSection.getSize().getWidth();
        int landscapeOrientedTitleHeight = landscapeOrientedMonthSection.getSize().getHeight();
        orientationSwitcher.check();
        int portraitOrientedTitleHeight = portraitOrientedMonthSection.getSize().getHeight();
        jdiAssert(landscapeOrientedTitleWidth, is(portraitOrientedTitleHeight),
                "Width of landscape oriented title section is not equal to height " +
                        "of portrait oriented section");
        jdiAssert(landscapeOrientedTitleHeight, lessThan(portraitOrientedTitleHeight),
                "Height of landscape oriented title section is more than height " +
                        "of portrait oriented section");
    }
}

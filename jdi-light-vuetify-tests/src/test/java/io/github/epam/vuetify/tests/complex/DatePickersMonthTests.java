package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.datePickersMonthPage;
import static io.github.com.pages.DatePickersMonthPage.activeMonthButtonReadonlyPicker;
import static io.github.com.pages.DatePickersMonthPage.activeMonthButtonsMultipleDP;
import static io.github.com.pages.DatePickersMonthPage.additionalYearIconIconsDP;
import static io.github.com.pages.DatePickersMonthPage.colorsMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.leftArrowIconsDP;
import static io.github.com.pages.DatePickersMonthPage.multipleMonthButtons;
import static io.github.com.pages.DatePickersMonthPage.readonlyMonthPicker;
import static io.github.com.pages.DatePickersMonthPage.rightArrowIconsDP;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class DatePickersMonthTests extends TestsInit {

    public static final String CHOSEN_MONTH = "may";
    public static final String CHOSEN_MONTH_TWO = "oct";
    public static final String CHOSEN_MONTH_TWO_FULL = "October";
    public static final String CHOSEN_MONTH_THREE = "nov";


//    Timer timer;
//    WebDriverWait wait;

    @BeforeClass
    public void beforeTest() {
        datePickersMonthPage.open();
    }

//    @Test
//    public void testAllowedMonthPicker() throws InterruptedException {
//
//
//        Thread.sleep(3000);
//    }

//    @Test
//    public void testColorsMonthPicker() throws InterruptedException {
//        //colorsMonthPicker.expand();
//        colorsMonthPicker.select(CHOSEN_MONTH);
//        colorsMonthPicker.hover();
//
//        System.out.println("Month: " + colorsMonthPicker.getText());
//
//        Thread.sleep(3000);
//    }

//    @Test
//    public void testIconsMonthPicker() throws InterruptedException {
//        jdiAssert(leftArrowIconsDP.attr("class"), containsString("mdi-skip-previous"),
//                "Left arrow in Icons date picker does not have required attributes");
//        jdiAssert(rightArrowIconsDP.attr("class"), containsString("mdi-skip-next"),
//                "Right arrow in Icons date picker does not have required attributes");
//        jdiAssert(additionalYearIconIconsDP.isEnabled(), is(true),
//                "There is no required additional picture for year area of Icons date picker");
//        Thread.sleep(3000);
//    }

//    @Test
//    public void testMultipleMonthPicker(){
//        List<String> allFirstlyActiveMonths = activeMonthButtonsMultipleDP.stream().map(elem
//                -> elem.getText().toLowerCase()).collect(Collectors.toList());
//        List<String> checkedMonths = Arrays.asList(CHOSEN_MONTH, CHOSEN_MONTH_TWO, CHOSEN_MONTH_THREE);
//        checkedMonths.stream().forEach(elem -> {
//            if(!allFirstlyActiveMonths.contains(elem)){
//                multipleMonthButtons.select(elem);
//            }
//        });
//        allFirstlyActiveMonths.addAll(checkedMonths);
//        Set<String> allExpectedChosenMonths = new HashSet<>(allFirstlyActiveMonths);
//        List<String> allSecondlyChosenMonths = activeMonthButtonsMultipleDP.stream().map(elem
//                -> elem.getText().toLowerCase()).collect(Collectors.toList());
//        jdiAssert(allSecondlyChosenMonths, containsInAnyOrder(allExpectedChosenMonths.toArray()),
//                "Not all of chosen months became active");
//        jdiAssert(multipleMonthButtons.getText(),
//                is(allSecondlyChosenMonths.size() + " selected"),
//                "Number of active months and number of months in the main field are different");
//        allSecondlyChosenMonths.stream().forEach(elem -> multipleMonthButtons.select(elem));
//        multipleMonthButtons.hover();
//        jdiAssert(multipleMonthButtons.getText(),
//                is("-"),
//                "After deselection of all months: notification in the main field is incorrect");
//        multipleMonthButtons.select(CHOSEN_MONTH_TWO);
//        multipleMonthButtons.hover();
//        System.out.println("Multiple info: " + multipleMonthButtons.getText());
//        jdiAssert(multipleMonthButtons.getText(),
//                is(CHOSEN_MONTH_TWO_FULL),
//                "After only one month has been selected: notification in the main field is incorrect");
//        //System.out.println("Multiple info: " + multipleMonthButtons.getText());
//    }

//    @Test
//    public void testReadOnlyMonthPicker(){
//        String currentlyActiveMonth = activeMonthButtonReadonlyPicker.getText();
//        List<String> checkedMonths = Arrays.asList(CHOSEN_MONTH, CHOSEN_MONTH_TWO, CHOSEN_MONTH_THREE);
//        checkedMonths.stream().forEach(elem -> {
//            if (!currentlyActiveMonth.equals(elem)) {
//                readonlyMonthPicker.select(elem);
//            }
//        });
//        jdiAssert(activeMonthButtonReadonlyPicker.getText(), is(currentlyActiveMonth),
//                "Other months but current month have been selected although they have to be read only");
//    }
//
//    @Test
//    public void testShowCurrentMonthPicker() throws InterruptedException {
//
//
//        Thread.sleep(3000);
//    }
//
//    @Test
//    public void testWidthMonthPicker() throws InterruptedException {
//
//
//        Thread.sleep(3000);
//    }
//
//    @Test
//    public void testDialogAndMenuMonthPicker() throws InterruptedException {
//
//
//        Thread.sleep(3000);
//    }
//
//    @Test
//    public void testInternationalizationMonthPicker() throws InterruptedException {
//
//
//        Thread.sleep(3000);
//    }
//
//    @Test
//    public void testOrientationMonthPicker() throws InterruptedException {
//
//
//        Thread.sleep(3000);
//    }

}

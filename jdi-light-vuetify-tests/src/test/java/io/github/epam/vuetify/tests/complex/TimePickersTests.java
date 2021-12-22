package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.timePickersPage;
import static io.github.com.pages.DatePickersPage.allowedDatePicker;
import static io.github.com.pages.TimePickersPage.allowedTimesTimePicker;
//import static io.github.com.pages.TimePickersPage.but10;
import static io.github.com.pages.TimePickersPage.amPmInTitleTimePicker;
import static io.github.com.pages.TimePickersPage.disabledTimePicker;
import static io.github.com.pages.TimePickersPage.firstColorTimePicker;
import static io.github.com.pages.TimePickersPage.readOnlyTimePicker;

public class TimePickersTests extends TestsInit {

    @BeforeClass
    public static void before() {
        timePickersPage.open();
    }

    @Test
    public static void colorTimePickerTest() throws InterruptedException{
        Timer.waitCondition(() -> firstColorTimePicker.isVisible());
//        System.out.println("Hours: " + firstColorTimePicker.getHours());
//        System.out.println("Hours: " + firstColorTimePicker.getMinutes());
        firstColorTimePicker.selectHoursOrMinutes("10");
        firstColorTimePicker.selectHoursOrMinutes("20");
        System.out.println("Hours: " + firstColorTimePicker.getHours());
        System.out.println("Minutes: " + firstColorTimePicker.getMinutes());
        System.out.println("Time: " + firstColorTimePicker.getTime());
        System.out.println("AM/PM status before switch: " + firstColorTimePicker.getAmPm());
        firstColorTimePicker.switchToPM();
        System.out.println("AM/PM status after switch: " + firstColorTimePicker.getAmPm());
        firstColorTimePicker.switchToAM();
        System.out.println("AM/PM status after switch: " + firstColorTimePicker.getAmPm());
        System.out.println("AM/PM status after switch: " + firstColorTimePicker.getColor());





        Thread.sleep(3000);
    }


    @Test
    public static void amPmInTitleTimePickerTest() throws InterruptedException{
        Timer.waitCondition(() -> amPmInTitleTimePicker.isVisible());

        amPmInTitleTimePicker.switchToTitlePM();
        amPmInTitleTimePicker.switchToTitleAM();
        // Create method - active AM/PM in title
        //System.out.println("AM/PM status after switch: " + amPmInTitleTimePicker.getAmPm());

//        firstColorTimePicker.selectHoursOrMinutes("10");
//        firstColorTimePicker.selectHoursOrMinutes("20");
//        System.out.println("Hours: " + firstColorTimePicker.getHours());
//        System.out.println("Minutes: " + firstColorTimePicker.getMinutes());
//        System.out.println("Time: " + firstColorTimePicker.getTime());
//        System.out.println("AM/PM status before switch: " + firstColorTimePicker.getAmPm());
//        firstColorTimePicker.switchToPM();
//        System.out.println("AM/PM status after switch: " + firstColorTimePicker.getAmPm());
//        firstColorTimePicker.switchToAM();
//        System.out.println("AM/PM status after switch: " + firstColorTimePicker.getAmPm());
//        System.out.println("AM/PM status after switch: " + firstColorTimePicker.getColor());





        Thread.sleep(3000);
    }





    @Test
    public static void allowedTimesTimePickerTest() throws InterruptedException {
        Timer.waitCondition(() -> allowedTimesTimePicker.isVisible());
        System.out.println("Hours: " + allowedTimesTimePicker.getHours());
        System.out.println("Hours: " + allowedTimesTimePicker.getMinutes());
        //allowedTimesTimePicker.selectHoursOrMinutes("10");
        Thread.sleep(3000);
//        Timer.waitCondition(() -> allowedTimesTimePicker.isVisible());
//        allowedTimesTimePicker.is().enabled();
//        allowedTimesTimePicker.has().size(24);
//        allowedTimesTimePicker.select("9");
//        allowedTimesTimePicker.select("30");
//        allowedTimesTimePicker.is().selected("30");
//        allowedTimesTimePicker.has().values("00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55");
//        allowedTimesTimePicker.is().displayed();
//        allowedTimesTimePicker.has().elementDisabled("55");
    }

    @Test
    public static void disabledTimePickerTest() {
//        disabledTimePicker.is().disabled();
//        disabledTimePicker.has().size(12);
//        disabledTimePicker.is().selected("12");
    }

    @Test
    public static void readOnlyTimePickerTest() {
//        readOnlyTimePicker.select(3);
//        readOnlyTimePicker.has().selected("12");
//        readOnlyTimePicker.has().size(12);
    }
}

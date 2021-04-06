package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.inputs.DateTimePickersFrame.timeTen;
import static io.github.com.pages.inputs.DateTimePickersFrame.dateTimePopUpOkButton;
import static io.github.com.pages.inputs.DateTimePickersFrame.dateTimePopUpCancelButton;
import static io.github.com.pages.inputs.DateTimePickersFrame.dateTenBtn;
import static io.github.com.pages.inputs.DateTimePickersFrame.pickers;
import static org.hamcrest.Matchers.*;

public class DateTimePickersTests extends TestsInit {

    @Test
    public void datePickerInline() {
        openSection("Date / Time");

        pickers.getPickerLabel(1).has().text("Date picker inline");
        pickers.getPickerBtn(1).click();
        dateTenBtn.is().visible();
        dateTenBtn.toggle();
        pickers.is().containigText(1, containsString("/10/"));

        pickers.getPickerField(1).setText("10/10/2021");
        pickers.is().containigText(1, hasToString("10/10/2021"));
    }

    @Test
    public void datePickerDialog() {
        openSection("Date / Time");

        pickers.getPickerLabel(2).has().text("Date picker dialog");
        String currentDate = pickers.getPickerField(2).getValue();
        pickers.getPickerBtn(2).click();
        dateTimePopUpCancelButton.toggle();
        pickers.is().containigText(2, hasToString(currentDate));

        pickers.getPickerBtn(2).is().visible();
        pickers.getPickerBtn(2).click();
        dateTenBtn.is().visible();
        dateTenBtn.toggle();
        dateTimePopUpOkButton.toggle();
        pickers.is().containigText(2, containsString("/10/"));

        pickers.getPickerField(2).setText("10/10/2021");
        pickers.is().containigText(2, equalTo("10/10/2021"));

    }

    @Test
    public void timePicker() {
        openSection("Date / Time");

        pickers.getPickerLabel(3).has().text("Time picker");
        String currentTime = pickers.getPickerField(3).getText();
        pickers.getPickerBtn(3).click();
        dateTimePopUpCancelButton.toggle();
        pickers.is().containigText(3, equalTo(currentTime));

        pickers.getPickerBtn(3).is().visible();
        pickers.getPickerBtn(3).click();
        timeTen.is().visible();
        timeTen.toogleXY();
        dateTimePopUpOkButton.toggle();
        pickers.is().containigText(3, containsString("10:"));
        pickers.getPickerField(3).setText("10:10");
        pickers.is().containigText(3, equalTo("10:10"));
    }

    @Test
    public void datePickerBirthday() {
        openSection("Date / Time");

        pickers.getPickerLabel(4).has().text("Birthday");
        pickers.is().containigText(4, equalTo("2017-05-24"));
        pickers.getPickerField(4).setValue("04/05/2021");
        pickers.is().containigText(4, equalTo("2021-04-05"));
    }

    @Test
    public void datePickerNextAppointment() {
        openSection("Date / Time");

        pickers.getPickerLabel(5).has().text("Next appointment");
        pickers.is().containigText(5, equalTo("2017-05-24T10:30"));
        pickers.getPickerField(5).setText("2020-11-11T11:11");
        pickers.is().containigText(5, equalTo("2020-11-11T11:11"));
    }

    @Test
    public void datePickerAlarmClock() {
        openSection("Date / Time");

        pickers.getPickerLabel(6).has().text("Alarm clock");
        pickers.is().containigText(6, equalTo("07:30"));
        pickers.getPickerField(6).setText("08:00");
        pickers.is().containigText(6, equalTo("08:00"));
    }

}

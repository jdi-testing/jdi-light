package io.github.epam.material.tests.inputs;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;

public class DateTimePickersTests extends TestsInit {

    @Test
    public void datePickerInline() {
        datePickerInlinePage.open();

        dateTimePickersFrame.dateTimePickersIcon.toggle();
        dateTimePickersFrame.dateTen.is().visible();
        dateTimePickersFrame.dateTen.toggle();
        dateTimePickersFrame.dateTimePickersInput.is().valueContains("/10/");

        dateTimePickersFrame.dateTimePickersInput.setValue("10/10/2021");
        dateTimePickersFrame.dateTimePickersInput.is().valueContains("10/10/2021");
    }

    @Test
    public void datePickerDialog() {
        datePickerDialogPage.open();

        String currentDate = dateTimePickersFrame.dateTimePickersInput.getValue();
        dateTimePickersFrame.dateTimePickersIcon.toggle();
        dateTimePickersFrame.dateTimePickersCancelButton.toggle();
        dateTimePickersFrame.dateTimePickersInput.is().valueContains(currentDate);

        dateTimePickersFrame.dateTimePickersIcon.is().visible();
        dateTimePickersFrame.dateTimePickersIcon.toggle();
        dateTimePickersFrame.dateTen.is().visible();
        dateTimePickersFrame.dateTen.toggle();
        dateTimePickersFrame.dateTimePickersOkButton.toggle();
        dateTimePickersFrame.dateTimePickersInput.is().valueContains("/10/");

        dateTimePickersFrame.dateTimePickersInput.setValue("10/10/2021");
        dateTimePickersFrame.dateTimePickersInput.is().valueContains("10/10/2021");
    }

    @Test
    public void timePicker(){
        timePickerPage.open();

        String currentTime = dateTimePickersFrame.dateTimePickersInput.getValue();
        dateTimePickersFrame.dateTimePickersIcon.toggle();
        dateTimePickersFrame.dateTimePickersCancelButton.toggle();
        dateTimePickersFrame.dateTimePickersInput.is().valueContains(currentTime);

        dateTimePickersFrame.dateTimePickersIcon.is().visible();
        dateTimePickersFrame.dateTimePickersIcon.toggle();
        dateTimePickersFrame.timeTen.is().visible();
        dateTimePickersFrame.timeTen.toogleXY();
        dateTimePickersFrame.dateTimePickersOkButton.toggle();
        dateTimePickersFrame.dateTimePickersInput.is().valueContains("10:");

        dateTimePickersFrame.dateTimePickersInput.setValue("10:10");
        dateTimePickersFrame.dateTimePickersInput.is().valueContains("10:10");
    }

}

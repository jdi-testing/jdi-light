package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.android.Picker;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class DatePickerPage {

    @MobileFindBy(id = "android:id/month_view")
    public static Picker datePicker;

    @MobileFindBy(id = "android:id/prev")
    public static Button previousMonth;

    @MobileFindBy(id = "android:id/next")
    public static Button nextMonth;

    @MobileFindBy(id = "android:id/date_picker_header_date")
    public static Button datePickerHeader;

    @MobileFindBy(id = "android:id/date_picker_header_year")
    public static Button yearPickerHeader;

    @MobileFindBy(id = "android:id/date_picker_year_picker")
    public static Picker yearPicker;

}

package nativeapp.android.apidemosespresso.app;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class EspressoAppPage {
    

    @MobileFindBy(androidDataMatcher = "{\n" +
            "    \"name\": \"hasEntry\",\n" +
            "    \"args\": [\"title\", \"Alarm\"]\n" +
            "  }")
    public static Button alarmPage;

}

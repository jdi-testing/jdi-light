package nativeapp.android.apidemosespresso;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class EspressoIndexPage {


    @MobileFindBy(androidDataMatcher = "{\n" +
            "    \"name\": \"hasEntry\",\n" +
            "    \"args\": [\"title\", \"App\"]\n" +
            "  }")
    public static Button appPage;

    @MobileFindBy(androidDataMatcher = "{\n" +
            "    \"name\": \"hasEntry\",\n" +
            "    \"args\": [\"title\", \"Content\"]\n" +
            "  }")
    public static Button contentPage;
}

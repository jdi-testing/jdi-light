package nativeapp.android.apiDemos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBys;

import java.util.List;

public class ViewsPage {
    @MobileFindBy(accessibilityId = "Buttons")
    public static Button buttonsPage;

    @MobileFindBy(accessibilityId = "Rating Bar")
    public static Button ratingBarPage;

    @MobileFindBys(@MobileFindBy(id = "android:id/list"))
    public static List<Button> buttons;
}

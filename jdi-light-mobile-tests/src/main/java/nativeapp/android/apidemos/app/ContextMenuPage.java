package nativeapp.android.apidemos.app;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ContextMenuPage {

    @MobileFindBy(accessibilityId = "Long press me")
    public static Button longPressButton;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView")
    public static Button menuView;

}

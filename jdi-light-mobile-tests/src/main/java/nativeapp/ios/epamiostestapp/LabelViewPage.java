package nativeapp.ios.epamiostestapp;

import com.epam.jdi.light.mobile.elements.common.app.ios.Label;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class LabelViewPage {

    @MobileFindBy(accessibilityId = "Label1")
    public static Label label1;

    @MobileFindBy(accessibilityId = "Label2")
    public static Label label2;

    @MobileFindBy(accessibilityId = "Text1 under Label1")
    public static Label text_under_label1;

    @MobileFindBy(accessibilityId = "Text2 under Label2")
    public static Label text_under_label2;

}

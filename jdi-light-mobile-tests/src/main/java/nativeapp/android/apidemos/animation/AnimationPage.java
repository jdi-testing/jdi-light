package nativeapp.android.apidemos.animation;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class AnimationPage {

    @MobileFindBy(xpath = "//android.widget.TextView[@content-desc=\"Layout Animations\"]")
    public static Button layoutAnimationsButton;

}

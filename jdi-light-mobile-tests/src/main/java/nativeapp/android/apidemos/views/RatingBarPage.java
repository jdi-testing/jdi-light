package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.mobile.elements.common.app.android.RatingBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class RatingBarPage {

    @MobileFindBy(id = "io.appium.android.apis:id/ratingbar1")
    public static RatingBar ratingBar1;

    @MobileFindBy(id = "io.appium.android.apis:id/ratingbar2")
    public static RatingBar ratingBar2;

    @MobileFindBy(id = "io.appium.android.apis:id/small_ratingbar")
    public static RatingBar smallRatingBar;

    @MobileFindBy(id = "io.appium.android.apis:id/indicator_ratingbar")
    public static RatingBar indicatorRatingBar;

    @MobileFindBy(id = "io.appium.android.apis:id/rating")
    public static Text rating;

}

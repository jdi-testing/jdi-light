package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.views.RatingBarPage;
import nativeapp.android.apidemos.views.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RatingBarTests extends ApiDemosTestInit {

    @DataProvider
    public Object[][] threeStarsData(){
        return new Object[][]{
                {1.0}, {3.0}, {6.0}
        };
    }
    @DataProvider
    public Object[][] fiveStarsData(){
        return new Object[][]{
                {1.0}, {6.0}, {10.0}
        };
    }

    @DataProvider
    public Object[][] incorrectData(){
        return new Object[][]{
                {-1.0}, {7.0}
        };
    }

    @BeforeMethod(alwaysRun = true)
    public void init(){
        IndexPage.viewsPage.click();
        MobileScreen.scrollToElementInList(IndexPage.goToRatingBar);
        ViewsPage.ratingBarPage.click();
    }

    @Test
    public void checkInitialCondition(){
        RatingBarPage.ratingBar1.is().value(5.0);
        RatingBarPage.ratingBar2.is().value(5.0);
        RatingBarPage.indicatorRatingBar.is().value(0.0);
        RatingBarPage.smallRatingBar.is().value(0.0);
    }

    @Test(dataProvider = "threeStarsData")
    public void checkThreeStarsByClick(double data){
        RatingBarPage.ratingBar1.setRatingByClick(data, 6.0);
        RatingBarPage.ratingBar1.is().value(data);
        RatingBarPage.indicatorRatingBar.is().value(data);
        RatingBarPage.smallRatingBar.is().value(data);
        RatingBarPage.rating.is().text("Rating: " + data / 2 + "/3");
    }

    @Test(dataProvider = "threeStarsData")
    public void checkThreeStars(double data){
        RatingBarPage.ratingBar1.setRating(data);
        RatingBarPage.ratingBar1.is().value(data);
    }

    @Test(dataProvider = "fiveStarsData")
    public void checkFiveStarsByClick(double data){
        RatingBarPage.ratingBar2.setRatingByClick(data, 10.0);
        RatingBarPage.ratingBar2.is().value(data);
        RatingBarPage.indicatorRatingBar.is().value(data);
        RatingBarPage.smallRatingBar.is().value(data);
        RatingBarPage.rating.is().text("Rating: " + data / 2 + "/5");
    }

    @Test(dataProvider = "fiveStarsData")
    public void checkFiveStars(double data){
        RatingBarPage.ratingBar2.setRating(data);
        RatingBarPage.ratingBar2.is().value(data);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "incorrectData")
    public void checkIncorrectValue(double value){
        RatingBarPage.ratingBar1.setRatingByClick(value, 6.0);
    }

}

package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.ProgressBarPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressBarTests extends ApiDemosTestInit {

    @BeforeMethod
    public void init() {
        MobileScreen.scrollToElementInList(IndexPage.goToViewPage);
        IndexPage.viewsPage.click();
        MobileScreen.scrollToElementInList(IndexPage.goToProgressBarPageStageThree);
        IndexPage.goToProgressBarPageStageOne.click();
        IndexPage.goToProgressBarPageStageTwo.click();
    }

    @Test
    public void isProgressBarHidden() {
        ProgressBarPage.progressBarLine.is().hidden();
    }

    @Test
    public void decreaseStandardProgressBar() {
        ProgressBarPage.decreaseStandardButton.is().enabled(); //todo: mb check it before click?
        ProgressBarPage.decreaseStandardButton.click();
        ProgressBarPage.progressBarLine.isExist();
    }

    @Test
    public void increaseStandardProgressBar() {
        ProgressBarPage.increaseStandardButton.is().enabled();
        ProgressBarPage.increaseStandardButton.click();
        ProgressBarPage.progressBarLine.isExist();
    }

    @Test
    public void decreaseSecondaryProgressBar() {
        ProgressBarPage.decreaseSecondaryButton.is().enabled();
        ProgressBarPage.decreaseSecondaryButton.click();
        ProgressBarPage.progressBarLine.isExist();
    }

    @Test
    public void increaseSecondaryProgressBar() {
        ProgressBarPage.increaseSecondaryButton.is().enabled();
        ProgressBarPage.increaseSecondaryButton.click();
        ProgressBarPage.progressBarLine.isExist();
    }
}

package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.ProgressBarPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressBarTests extends ApiDemosTestInit {

    private static final String DECREASED_STANDARD_BAR = "49.0";
    private static final String INCREASED_STANDARD_BAR = "50.0";
    private static final String DECREASED_SECONDARY_BAR = "74.0";
    private static final String INCREASED_SECONDARY_BAR = "75.0";

    @BeforeMethod
    public void init() {
        MobileScreen.scrollToElementInList(IndexPage.goToViewPage);
        IndexPage.viewsPage.click();
        MobileScreen.scrollToElementInList(IndexPage.goToProgressBarPageStageThree);
        IndexPage.goToProgressBarPageStageOne.click();
        IndexPage.goToProgressBarPageStageTwo.click();
    }

    @Test
    public void decreaseStandardProgressBar() {
        ProgressBarPage.decreaseStandardButton.is().enabled();
        ProgressBarPage.decreaseStandardButton.click();
        ProgressBarPage.progressBarLine.getProgressValue().equals(DECREASED_STANDARD_BAR);
    }

    @Test
    public void increaseStandardProgressBar() {
        ProgressBarPage.increaseStandardButton.is().enabled();
        ProgressBarPage.increaseStandardButton.click();
        ProgressBarPage.progressBarLine.getProgressValue().equals(INCREASED_STANDARD_BAR);
    }

    @Test
    public void decreaseSecondaryProgressBar() {
        ProgressBarPage.decreaseSecondaryButton.is().enabled();
        ProgressBarPage.decreaseSecondaryButton.click();
        ProgressBarPage.progressBarLine.getProgressValue().equals(DECREASED_SECONDARY_BAR);
    }

    @Test
    public void increaseSecondaryProgressBar() {
        ProgressBarPage.increaseSecondaryButton.is().enabled();
        ProgressBarPage.increaseSecondaryButton.click();
        ProgressBarPage.progressBarLine.getProgressValue().equals(INCREASED_SECONDARY_BAR);
    }
}

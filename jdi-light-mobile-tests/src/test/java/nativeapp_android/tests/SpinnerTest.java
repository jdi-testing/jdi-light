package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp.android.apidemos.IndexPage;
import nativeapp.android.apidemos.SpinnerPage;
import nativeapp.android.apidemos.views.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.IndexPage.viewsPage;

public class SpinnerTest extends ApiDemosTestInit {

    private final String[] COLOR_ITEMS = {"red", "orange", "yellow", "green", "blue", "violet"};
    private final String[] PLANET_ITEMS = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};

    @BeforeMethod
    public void init(){
        MobileScreen.scrollToElementInList(IndexPage.goToViewPage);
        viewsPage.click();
        MobileScreen.scrollToElementInList(ViewsPage.spinnerPage);
        ViewsPage.spinnerPage.click();
    }

    @Test
    public void chooseColorSpinnersTest() {
        SpinnerPage.colorSpinner.shouldBe().displayed();
        SpinnerPage.colorSpinner.tap();
        SpinnerPage.colorSpinner.hasItems(COLOR_ITEMS);
        SpinnerPage.colorSpinner.select("red");
        SpinnerPage.colorSpinner.has().text("red");

        SpinnerPage.colorSpinner.tap();
        SpinnerPage.colorSpinner.select("yellow");
        SpinnerPage.colorSpinner.has().text("yellow");

        SpinnerPage.colorSpinner.tap();
        SpinnerPage.colorSpinner.select("violet");
        SpinnerPage.colorSpinner.has().text("violet");
    }

    @Test
    public void choosePlanetSpinnersTest() {
        SpinnerPage.planetSpinner.shouldBe().displayed();
        SpinnerPage.planetSpinner.tap();
        SpinnerPage.planetSpinner.hasItems(PLANET_ITEMS);
        SpinnerPage.planetSpinner.select("Mercury");
        SpinnerPage.planetSpinner.has().text("Mercury");

        SpinnerPage.planetSpinner.tap();
        SpinnerPage.planetSpinner.select("Earth");
        SpinnerPage.planetSpinner.has().text("Earth");

        SpinnerPage.planetSpinner.tap();
        SpinnerPage.planetSpinner.select("Jupiter");
        SpinnerPage.planetSpinner.has().text("Jupiter");
    }
}
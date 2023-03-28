package nativeapp_android.tests;

import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.ExpandableListPage.*;
import static nativeapp.android.apidemos.views.ViewsPage.expandableList;

public class ExpandableListTests extends ApiDemosTestInit {

    @BeforeMethod
    public void init() {
        viewsPage.tap();
        expandableList.tap();
    }

    @Test
    public void customAdapterTest() {
        customAdapter.tap();
        peopleNames.tap();
        dogNames.tap();
        catNames.tap();
        fishNames.tap();

        arnoldName.is().enabled();
        arnoldName.is().displayed();
        arnoldName.is().text("Arnold");

        bubblesName.is().enabled();
        bubblesName.is().displayed();
        bubblesName.is().text("Bubbles");
    }

    @Test
    public void simpleAdapterTest(){
        simpleAdapter.tap();
        group0.tap();
        child1.is().enabled();
        child1.is().displayed();
        child1.is().text("Child 1");
        group0.tap();
    }
}

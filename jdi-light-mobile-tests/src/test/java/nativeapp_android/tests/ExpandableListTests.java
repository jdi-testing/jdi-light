package nativeapp_android.tests;

import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.ExpandableListPage.arnoldName;
import static nativeapp.android.apidemos.views.ExpandableListPage.catNames;
import static nativeapp.android.apidemos.views.ExpandableListPage.child1;
import static nativeapp.android.apidemos.views.ExpandableListPage.child1odd;
import static nativeapp.android.apidemos.views.ExpandableListPage.customAdapter;
import static nativeapp.android.apidemos.views.ExpandableListPage.dogNames;
import static nativeapp.android.apidemos.views.ExpandableListPage.fishNames;
import static nativeapp.android.apidemos.views.ExpandableListPage.bubblesName;
import static nativeapp.android.apidemos.views.ExpandableListPage.group0;
import static nativeapp.android.apidemos.views.ExpandableListPage.peopleNames;
import static nativeapp.android.apidemos.views.ExpandableListPage.simpleAdapter;
import static nativeapp.android.apidemos.views.ViewsPage.expandableList;

public class ExpandableListTests extends ApiDemosTestInit {

    @BeforeMethod
    public void initSteps() {
        viewsPage.click();
        expandableList.click();
    }

    @Test
    public void customAdapterTest() {
        customAdapter.click();
        peopleNames.click();
        dogNames.click();
        catNames.click();
        fishNames.click();

        arnoldName.is().enabled();
        arnoldName.is().displayed();
        arnoldName.is().text("Arnold");

        bubblesName.is().enabled();
        bubblesName.is().displayed();
        bubblesName.is().text("Bubbles");
    }

    @Test
    public void simpleAdapterTest(){
        simpleAdapter.click();
        group0.click();
        child1.is().enabled();
        child1.is().displayed();
        child1.is().text("Child 1");
        group0.click();
    }
}

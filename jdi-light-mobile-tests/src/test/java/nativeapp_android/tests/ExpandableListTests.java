package nativeapp_android.tests;

import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.ExpandableListPage.arnoldName;
import static nativeapp.android.apidemos.views.ExpandableListPage.customAdapter;
import static nativeapp.android.apidemos.views.ExpandableListPage.peopleNames;
import static nativeapp.android.apidemos.views.ViewsPage.expandableList;

public class ExpandableListTests extends ApiDemosTestInit {

    @BeforeMethod
    public void initSteps() {
        viewsPage.click();
        expandableList.click();
    }

    @Test
    public void openNotificationTest() {
        customAdapter.click();
        peopleNames.click();
        arnoldName.is().enabled();
        arnoldName.is().displayed();
        arnoldName.is().text("Arnold");
        System.out.println("TEST" );
        System.out.println("getName   "  +    arnoldName.getName());
        System.out.println("getText   "  +    arnoldName.getText());
        System.out.println("getValue  "  +    arnoldName.getValue());
        System.out.println("TEST 2");
        System.out.println("getAllAttributes"  +  arnoldName.core().getAllAttributes());
        System.out.println("CORE() "  +    arnoldName.core().getName());
        System.out.println("CORE() "  +    arnoldName.core().getText());
        System.out.println("CORE() "  +    arnoldName.core().getValue());
    }
}

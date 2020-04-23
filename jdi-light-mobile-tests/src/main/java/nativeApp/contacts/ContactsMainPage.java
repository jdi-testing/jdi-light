package nativeApp.contacts;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.mobile.elements.common.Text;

public class ContactsMainPage {

    private static final String LOCATOR_PATH = "com.google.android.contacts:id/";

    @FindBy(id = LOCATOR_PATH + "floating_action_button")
    public static Button addNewContactBtn;

    @FindBy(id = "android:id/text1")
    public static Text noContactsInThisAccountText;

    public void createNewContact(){
        addNewContactBtn.click();
    }
}

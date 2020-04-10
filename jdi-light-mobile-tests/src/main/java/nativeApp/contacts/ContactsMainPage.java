package nativeapp.contacts;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.mobile.elements.common.Button;
import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class ContactsMainPage {

    private static final String LOCATOR_PATH = "com.google.android.contacts:id/";

    @FindBy(id = "com.google.android.contacts:id/floating_action_button")
    public static Button addNewContactBtn;

    @FindBy(id = LOCATOR_PATH + "og_apd_internal_image_view")
    public static Button contactsSourceBtn;

    @FindBy(id = LOCATOR_PATH + "open_search_bar_text_view")
    public static TextField findContactTextField;

    @FindBy(id = "android:id/text1")
    public static Text noContactsInThisAccountText;

    public void createNewContact(){
        addNewContactBtn.click();
    }
}

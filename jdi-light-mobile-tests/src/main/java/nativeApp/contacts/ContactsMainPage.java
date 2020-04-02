package nativeApp.contacts;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

//import com.epam.jdi.light.mobile.elements.common.Button;

public class ContactsMainPage {

    private final String LOCATOR_PATH = "com.google.android.contacts:id/";

    @FindBy(id = "com.google.android.contacts:id/floating_action_button")
    Button addNewContactBtn;

    @FindBy(id = LOCATOR_PATH + "og_apd_internal_image_view")
    Button contactsSourceBtn;

    @FindBy(id = LOCATOR_PATH + "open_search_bar_text_view")
    TextField findContactTextField;

//    public ContactsMainPage(){
//        PageFactory.initElements(this);
//    }

    public void createNewContact(){
        addNewContactBtn.click();
        //return new CreateNewContact();
    }
}

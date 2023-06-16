package nativeapp.contacts;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.mobile.elements.common.app.ios.TextField;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;

public class CreateNewContact {

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[1]")
    private TextField name;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[2]")
    private TextField lastName;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Spinner")
    private DataListOptions phoneType;

    public void fillInNewContactInformation(String contactName, String contactLastName, int phoneTypeIdx) {
        fillName(contactName);
        fillLastName(contactLastName);
        choosePhoneType(phoneTypeIdx);
    }

    private void choosePhoneType(int typeIdx) {
        phoneType.select(typeIdx);
    }

    private void fillName(String contactName) {
        name.sendKeys(contactName);
    }

    private void fillLastName(String contactLastName) {
        lastName.sendKeys(contactLastName);
    }

}

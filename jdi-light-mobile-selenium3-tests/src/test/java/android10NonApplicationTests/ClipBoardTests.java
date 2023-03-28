package android10NonApplicationTests;

import com.epam.jdi.light.mobile.elements.common.MobileDevice;
import nativeapp_android.SettingsAppTestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;


public class ClipBoardTests extends SettingsAppTestsInit {

    private String text = "Modem mode";

    @Test
    public void clipBoardTest() {
        MobileDevice.setClipBoardText(text);
        String getText = MobileDevice.getClipBoardText();
        jdiAssert(getText.contains(text), Matchers.is(true));
    }
}

package nativeapp.android.keyboard;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventMetaModifier;
import io.appium.java_client.android.nativekey.PressesKey;

import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class AndroidKeyStore {

    AndroidKey code;
    boolean isShifted;

    public AndroidKeyStore(AndroidKey keyCode, boolean shift){
        code = keyCode;
        isShifted = shift;
    }

    public void type() {
        KeyEvent keyEvent = new KeyEvent(code);
        if (isShifted) {
            keyEvent.withMetaModifier(KeyEventMetaModifier.SHIFT_MASK);
        }
        executeDriverMethod(PressesKey.class,
                (PressesKey driver) -> driver.pressKey(keyEvent));
    }
}

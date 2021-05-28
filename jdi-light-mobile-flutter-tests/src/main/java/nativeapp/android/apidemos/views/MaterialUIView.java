package nativeapp.android.apidemos.views;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

//public class MaterialUIView extends Button {
public class MaterialUIView {

    final static String xpath = "//android.widget.Button[contains(@content-desc, '%s')]";

    @MobileFindBy(xpath = "//android.view.View[contains(@content-desc, 'App bar')]")
    public static Button appBar;
    @MobileFindBy(xpath = "//android.view.View[contains(@content-desc, 'Text fields')]")
    public static Button textFields;
    @MobileFindBy(xpath = "//android.view.View[contains(@content-desc, 'Dismiss')]")
    public static UIElement appearView;

    public static void pressButton(Button toView) {
        MobileScreen.scrollToBottom();
        toView.waitFor().is().displayed();
        toView.click();
//        contentView = appearView.find(By.xpath(xpath.format(xpath,"Text fields")));
//        contentView.waitFor().is().displayed();
        appearView.waitFor().is().displayed();
    }

    public static void open(String nameView) {
        switch(nameView) {
            case "Text fields": pressButton(textFields);
            break;
        }
    }
}

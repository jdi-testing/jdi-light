import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angPage;
import static io.github.com.pages.AngularPage.firstBasicRadioButton;

public class BasicRadiosTests {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angPage.shouldBeOpened();
    }

    @Test
    public void checkBasicRadios() {
        firstBasicRadioButton.is().disabled();
    }

}

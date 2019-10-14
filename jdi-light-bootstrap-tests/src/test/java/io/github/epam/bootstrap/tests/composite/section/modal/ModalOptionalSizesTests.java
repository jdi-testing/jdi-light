package io.github.epam.bootstrap.tests.composite.section.modal;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalOptionalSizes;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ModalOptionalSizesTests extends TestsInit {

//    @DataProvider
//    public Object[][] modalDismissData() {
//        return new Object[][]{
//                {}
//        };
//    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void modalSizeTest() {
        modalOptionalSizes.xlButton.click();
//        $(By.xpath("//*[@id='model-optional-sizes']//*[@class='modal-dialog modal-xl']")).waitFor().displayed();
//        modalOptionalSizes.xlModal.is().displayed();
    }

}

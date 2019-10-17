package io.github.epam.bootstrap.tests.composite.section.modal;

import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Modal;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalOptionalSizes;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ModalOptionalSizesTests extends TestsInit {

    @DataProvider
    public Object[][] modalBasicData() {
        return new Object[][]{
                {modalOptionalSizes.xlButton, modalOptionalSizes.xlModal},
                {modalOptionalSizes.lgButton, modalOptionalSizes.lgModal},
                {modalOptionalSizes.smButton, modalOptionalSizes.smModal},
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "modalBasicData")
    public void modalBasicFunctionalityTest(Button button, Modal modal) {
        button.highlight();
        button.click();

        modal.is().displayed();

        modal.close();

        modal.is().hidden();

        button.unhighlight();
    }



}

package io.github.epam.bootstrap.tests.composite.section.modal;

import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Modal;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.modalOptionalSizes;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ModalOptionalSizesTests extends TestsInit {

    @DataProvider
    public Object[][] modalBasicData() {
        return new Object[][]{
                {bsPage.xlButton, modalOptionalSizes.xlModal},
                {bsPage.lgButton, modalOptionalSizes.lgModal},
                {bsPage.smButton, modalOptionalSizes.smModal},
        };
    }

    @DataProvider
    public Object[][] modalCssData() {
        return new Object[][]{
                {bsPage.xlButton, modalOptionalSizes.xlModal, "modal-xl"},
                {bsPage.lgButton, modalOptionalSizes.lgModal, "modal-lg"},
                {bsPage.smButton, modalOptionalSizes.smModal, "modal-sm"},
        };
    }

    @DataProvider
    public Object[][] modalSizeData() {
        return new Object[][]{
                {bsPage.xlButton, modalOptionalSizes.xlModal, 1140},
                {bsPage.lgButton, modalOptionalSizes.lgModal, 800},
                {bsPage.smButton, modalOptionalSizes.smModal, 300},
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "modalBasicData")
    public void modalBasicFunctionalityTest(Button button, Modal modal) {
        button.show();
        button.click();

        modal.is().displayed();

        modal.close();

        modal.is().hidden();
    }

    @Test(dataProvider = "modalCssData")
    public void modalCssTest(Button button, Modal modal, String modalCss) {
        button.show();
        button.click();

        modal.is().displayed();

        modal.childs().get(1).core().is().hasClass(modalCss);

        modal.close();
    }

    @Test(dataProvider = "modalSizeData")
    public void modalSizeTest(Button button,
                              Modal modal,
                              int modalWidth) {
        button.show();
        button.click();

        modal.is().displayed();

        assertThat(modal.childs().get(2).core().getRect().width, equalTo(modalWidth));

        modal.close();
    }

}

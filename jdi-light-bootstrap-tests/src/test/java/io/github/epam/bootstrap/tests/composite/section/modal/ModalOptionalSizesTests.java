package io.github.epam.bootstrap.tests.composite.section.modal;

import com.epam.jdi.light.driver.WebDriverFactory;
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
                {modalOptionalSizes.xlButton, modalOptionalSizes.xlModal},
                {modalOptionalSizes.lgButton, modalOptionalSizes.lgModal},
                {modalOptionalSizes.smButton, modalOptionalSizes.smModal},
        };
    }

    @DataProvider
    public Object[][] modalCssData() {
        return new Object[][]{
                {modalOptionalSizes.xlButton, modalOptionalSizes.xlModal, "modal-xl"},
                {modalOptionalSizes.lgButton, modalOptionalSizes.lgModal, "modal-lg"},
                {modalOptionalSizes.smButton, modalOptionalSizes.smModal, "modal-sm"},
        };
    }

    @DataProvider
    public Object[][] modalSizeData() {
        return new Object[][]{
                {modalOptionalSizes.xlButton, modalOptionalSizes.xlModal, "bd-example-modal-xl", 1140},
                {modalOptionalSizes.lgButton, modalOptionalSizes.lgModal, "bd-example-modal-lg", 800},
                {modalOptionalSizes.smButton, modalOptionalSizes.smModal, "bd-example-modal-sm", 300},
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

    @Test(dataProvider = "modalCssData")
    public void modalCssTest(Button button, Modal modal, String modalCss) {
        button.highlight();
        button.click();

        modal.is().displayed();

        modal.childs().get(1).core().is().hasClass(modalCss);

        modal.close();

        button.unhighlight();
    }

    @Test(dataProvider = "modalSizeData")
    public void modalSizeTest(Button button,
                              Modal modal,
                              String modalClassName,
                              long modalSize) {
        button.highlight();
        button.click();

        modal.is().displayed();

        long modalWidth = WebDriverFactory.jsExecute(
                "var modal = document.getElementsByClassName('" + modalClassName + "')[0];" +
                        "return modal.children[0].offsetWidth;"
        );

        assertThat(modalWidth, equalTo(modalSize));

        modal.close();

        button.unhighlight();
    }

}

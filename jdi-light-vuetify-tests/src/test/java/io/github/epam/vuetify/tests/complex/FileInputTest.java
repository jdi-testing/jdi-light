package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.com.pages.FileInputsPage;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.JDISettings.COMMON;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.StaticSite.fileInputsPage;
import static io.github.com.pages.FileInputsPage.acceptFileInput;

public class FileInputTest extends TestsInit {

    String path1 = "C:\\Users\\Robert_Andreev\\Desktop\\Instruction.png";
    String path2 = "C:\\Users\\Robert_Andreev\\Desktop\\Instruction.pdf";

    @BeforeClass
    public void before() {
        fileInputsPage.open();
        fileInputsPage.checkOpened();
    }

    @Test
    public void acceptFileInput() {
        acceptFileInput.uploadFile(path1);
        acceptFileInput.has().text("Instruction.png");
    }

    @Test
    public void baseFileTe2st() {
//        fileInput.highlight();
//        UIElement element = fileInput.core().find("input");
//        element.getWebElement().sendKeys(path1);
//        element.getWebElement().sendKeys(path2);
////        element.sendKeys(path);
//        Thread.sleep(5000);
    }

}

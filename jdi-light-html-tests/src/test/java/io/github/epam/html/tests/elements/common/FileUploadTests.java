package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.elements.composite.WebPage2;
import org.testng.annotations.Test;

import java.util.function.Consumer;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class FileUploadTests {
    Consumer<Integer> a = WebPage2::staticMethod;

    FileUploadTests() {
    }

    @Test
    public void baseValidationTest() {
    }
}

package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.StaticSite.chipFrame;
import static org.hamcrest.Matchers.hasToString;

public class DateAndTimePickersTest extends TestsInit {

    @Test
    public void defaultDateAndTimeTest(){
        openSection("Date / Time");


    }

    public void basicCheck(){
        chipFrame.chips.is().displayed(1);
    }


}

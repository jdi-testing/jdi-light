package io.github.epam.properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Properties;

import static com.epam.jdi.light.common.PropertyValidator.validateProperties;
import static com.epam.jdi.light.settings.PropertyNames.TIMEOUT_WAIT_ELEMENT;

public class TimeoutWaitElementTest {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"-1", "1000", "01", "", "1.1", "10,11", "ten"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"0", "1", "998", "999"};
    }

    @Test(expectedExceptions = {RuntimeException.class}, dataProvider = "negativeData",
            expectedExceptionsMessageRegExp = ".*Value of parameter '" + TIMEOUT_WAIT_ELEMENT + "' is not valid." +
                    " See example: https://jdi-docs.github.io/jdi-light/#driver-settings.*")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(TIMEOUT_WAIT_ELEMENT, value);
        validateProperties(properties);
        Assert.fail("Value " + value + " should not be valid for this test.");
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(TIMEOUT_WAIT_ELEMENT, value);
        validateProperties(properties);
    }

}

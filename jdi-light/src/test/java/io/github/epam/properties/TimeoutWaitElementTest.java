package io.github.epam.properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Properties;

import static com.epam.jdi.light.common.PropertyName.TIMEOUT_WAIT_ELEMENT;
import static com.epam.jdi.light.common.PropertyValidator.validateProperties;

public class TimeoutWaitElementTest {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"a", "*", "", "%"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"0", "1", "120"};
    }

    @Test(expectedExceptions = {RuntimeException.class}, dataProvider = "negativeData",
            expectedExceptionsMessageRegExp = ".*Value of parameter '" + TIMEOUT_WAIT_ELEMENT + "' is not valid..*")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(TIMEOUT_WAIT_ELEMENT, value);
        validateProperties(properties);
        Assert.fail("Value " + value + " should not be valid");
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(TIMEOUT_WAIT_ELEMENT, value);
        validateProperties(properties);
    }

}

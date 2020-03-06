package io.github.epam.properties;

    import java.security.InvalidParameterException;
    import java.util.Properties;

    import org.testng.annotations.DataProvider;
    import org.testng.annotations.Test;

    import static com.epam.jdi.light.common.Property.ALLURE_STEPS_PROPERTY;
    import static com.epam.jdi.light.common.PropertyValidationUtils.LINK_TO_EXAMPLES;
    import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
    import static org.testng.Assert.assertEquals;
    import static org.testng.Assert.fail;

public class AllureStepsTests {

    @DataProvider
    public static Object[] negativeData() {
        return new Object[]{"flase", "", "0"};
    }

    @DataProvider
    public static Object[] positiveData() {
        return new Object[]{"true", "false"};
    }

    @Test(dataProvider = "negativeData")
    public void negativeTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(ALLURE_STEPS_PROPERTY.getName(), value);
        try {
            validateProperties(properties);
            fail("Value '" + value + "' should not be valid for this test.");
        } catch (InvalidParameterException exp) {
            String expMessage = exp.getMessage();
            assertEquals(expMessage, ALLURE_STEPS_PROPERTY.getExMsg() + LINK_TO_EXAMPLES);
        }
    }

    @Test(dataProvider = "positiveData")
    public void positiveTest(String value) {
        Properties properties = new Properties();
        properties.setProperty(ALLURE_STEPS_PROPERTY.getName(), value);
        validateProperties(properties);
    }
}

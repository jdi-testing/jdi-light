package com.epam.jdi.light.mobile;

import com.epam.jdi.light.mobile.driver.MobileDriverData;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.ClassLoader.getSystemResource;

public class AllurePropertiesGenerator {

    private static final String ENVIRONMENT_PROPERTIES_FILENAME = "environment.properties";
    private static final String ALLURE_RESULTS_DIR = "allure-results";
    private static final String PROPERTIES_FORMAT = "%s=%s";
    public static final String DRIVER = "driver";
    public static final String DEVICE_NAME_PROPERTY = "deviceName";
    public static final String PLATFORM_NAME_PROPERTY = "platformName";
    public static final String APPIUM_URL_PROPERTY = "driver.remote.url";
    boolean initiated = false;

    public void createAllureProperties() {
        if (initiated) {
            return;
        }

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String propsPath = rootPath + "test.properties";
        Properties appProps = new Properties();
        try (FileInputStream propStream = new FileInputStream(propsPath)) {
            appProps.load(propStream);
        } catch (IOException e) {
            logger.error("Error during read test.properties file from %s. %s", propsPath, e);
        }

        List<String> properties = Arrays.asList(
                formatProperties(DRIVER, "Chrome", appProps),
                formatProperties(DEVICE_NAME_PROPERTY, "unset in test.properties", appProps),
                formatProperties(PLATFORM_NAME_PROPERTY, "Chrome", appProps),
                formatProperties(APPIUM_URL_PROPERTY, "-", appProps)
        );

        try {
            Path allureResults = Paths.get(getSystemResource("").toURI()).getParent();
            allureResults = Paths.get(allureResults.toAbsolutePath().toString(),
                    ALLURE_RESULTS_DIR, ENVIRONMENT_PROPERTIES_FILENAME);
            if (!Files.exists(allureResults.getParent())) {
                Files.createDirectories(allureResults.getParent());
            }
            logger.info(String.format("allure prop file path: %s", allureResults.toAbsolutePath()));
            Files.write(allureResults, properties, StandardCharsets.UTF_8);
        } catch (Exception e) {
            logger.error("Can not create property file for allure results.", e);
            logger.toLog(e.toString());
        }
        initiated = true;

    }

    private String formatProperties(String propertyName, String defValue, Properties appProps) {
        String propertyValue = appProps.getProperty(propertyName);
        if (propertyValue == null) {
            if ("android".equalsIgnoreCase(appProps.getProperty(DRIVER))) {
                propertyValue = MobileDriverData.CAPABILITIES_FOR_ANDROID.get(propertyName);
            } else {
                propertyValue = MobileDriverData.CAPABILITIES_FOR_IOS.get(propertyName);
            }
        }
        return String.format(PROPERTIES_FORMAT, propertyName, Objects.isNull(propertyValue) ? defValue : propertyValue);
    }

}
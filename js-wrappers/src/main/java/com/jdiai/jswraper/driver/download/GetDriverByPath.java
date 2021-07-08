package com.jdiai.jswraper.driver.download;

import com.jdiai.jsdriver.JDINovaException;
import com.jdiai.jswraper.driver.DriverTypes;

import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.jdiai.jswraper.driver.GetDriverUtilities.getOs;
import static com.jdiai.jswraper.driver.OsTypes.WIN;

public class GetDriverByPath {
    private final String driverPath;

    public GetDriverByPath(String driverPath) {
        this.driverPath = driverPath;
    }

    private String chromeDriverPath() {
        return mergePath(driverPath, getOs() == WIN ? "chromedriver.exe" : "chromedriver");
    }
    private String ieDriverPath() {
        return mergePath(driverPath,"IEDriverServer.exe");
    }
    private String edgeDriverPath() {
        return mergePath(driverPath,"MicrosoftWebDriver.exe");
    }
    private String operaDriverPath() {
        return driverPath("operadriver");
    }
    private String safariDriverPath() {
        return driverPath("safaridriver");
    }
    private String firefoxDriverPath() {
        return driverPath("geckodriver");
    }
    private String driverPath(String name) {
        return mergePath(driverPath, getOs() == WIN ? name + ".exe" : name);
    }

    public void setSystemProperty(DriverTypes browser) {
        try {
            switch (browser) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", firefoxDriverPath());
                    break;
                case IE:
                    System.setProperty("webdriver.ie.driver", ieDriverPath());
                    break;
                case IE_EDGE:
                    System.setProperty("webdriver.edge.driver", edgeDriverPath());
                    break;
                case SAFARI:
                    System.setProperty("webdriver.safari.driver", safariDriverPath());
                    break;
                case OPERA:
                    System.setProperty("webdriver.opera.driver", operaDriverPath());
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath());
            }
        } catch (Exception ex) {
            throw new JDINovaException(ex, "Failed to run local driver '%s'", browser);
        }
    }

}

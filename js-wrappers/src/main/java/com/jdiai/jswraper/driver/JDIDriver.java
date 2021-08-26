package com.jdiai.jswraper.driver;

import com.jdiai.tools.map.MapArray;
import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;

import static com.jdiai.jswraper.driver.DriverTypes.*;
import static com.jdiai.jswraper.driver.RunModes.LOCAL_DOWNLOAD;
import static com.jdiai.tools.pairs.Pair.$;

public class JDIDriver {
    public static RunModes RUN_MODE = LOCAL_DOWNLOAD;

    public static Consumer<WebDriver> DRIVER_SETUP = driver -> driver.manage().window().maximize();

    public static DriverOptions DRIVER_OPTIONS = new DriverOptions();

    public static MapArray<DriverTypes, String> REMOTE_DRIVER_VERSIONS = new MapArray<>(
            $(CHROME, "latest"),
            $(FIREFOX, "latest"),
            $(IE, "latest"),
            $(IE_EDGE, "latest"),
            $(SAFARI, "latest"),
            $(OPERA, "latest")
    );
}

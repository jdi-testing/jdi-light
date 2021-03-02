package io.github.epam;

// import com.epam.jdi.light.mobile.settings.MobileSettings;
// import io.github.com.StaticSite;
// import io.github.epam.testng.TestNGListener;
// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.BeforeSuite;
// import org.testng.annotations.Listeners;
// 
// import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
// import static com.epam.jdi.light.elements.composite.WebPage.openSite;
// import static com.epam.jdi.light.settings.WebSettings.logger;
// 
// @Listeners(TestNGListener.class)
// public interface TestsInit {
//     @BeforeSuite(alwaysRun = true)
//     default void setUp() {
//         MobileSettings.init();
//         openSite(StaticSite.class);
//         logger.toLog("Run Tests Bootstrap mobile");
//     }
// 
//     @AfterSuite(alwaysRun = true)
//     default void tearDown() {
//         killAllSeleniumDrivers();
//     }
// }
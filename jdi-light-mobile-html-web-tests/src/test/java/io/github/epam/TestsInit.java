package io.github.epam;

// import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
// import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
// import io.github.com.StaticSite;
// import io.github.epam.testng.TestNGListener;
// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.BeforeSuite;
// import org.testng.annotations.Listeners;
// import pseudo.site.PseudoSite;
//
// import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
// import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;
// import static com.epam.jdi.light.mobile.elements.init.PageFactory.initMobile;
// import static com.epam.jdi.light.settings.WebSettings.logger;
// import static io.github.com.StaticSite.homePage;
//
// @Listeners(TestNGListener.class)
// public interface TestsInit {
//     @BeforeSuite(alwaysRun = true)
//     default void setUp() {
//         INTERFACES.update(IsCombobox.class, DataListOptions.class);
//         killAllSeleniumDrivers();
//         initMobile(StaticSite.class);
//         initMobile(PseudoSite.class);
//         homePage.open();
//         logger.toLog("Run Tests");
//     }
//
//     @AfterSuite(alwaysRun = true)
//     default void tearDown() {
//          killAllSeleniumDrivers();
//     }
//}

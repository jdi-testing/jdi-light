package cucmberTests;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.base.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.epam.jdi.light.elements.init.PageFactory.PRE_INIT;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;
import static io.github.com.pages.HtmlElementsPage.blueButton;
import static io.github.com.pages.HtmlElementsPage.ghostButton;
import static io.github.com.pages.HtmlElementsPage.redButton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.HtmlSettings;

public class Dev {

	public static void main(String[] args) {
		Class<?>[] pages = getClassesWithPages("src/main/java/io/github/com");
		PRE_INIT = HtmlSettings::init;
        initElements(pages);
        WebPage.openUrl("https://jdi-testing.github.io/jdi-light/index.html");
		userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        WebPage.openUrl("https://jdi-testing.github.io/jdi-light/html5.html");
        redButton.click();
        acceptAlert();
        blueButton.click();
        acceptAlert();
        refresh();
        ghostButton.click();
        acceptAlert();
        killAllSeleniumDrivers();
	}
	
	public static Class<?>[] getClassesWithPages(String pathToPages) {
		List<Path> pathsList = new ArrayList<Path>();
		try (Stream<Path> paths = Files.walk(Paths.get("src/main/java/io/github/com"))) {
			pathsList = paths.filter(Files::isRegularFile).filter(p -> {
				long entryCount = 0;
				try {
					entryCount = Files.lines(p)
							.filter(line -> line.contains("extends WebPage") || line.contains("extends Section"))
							.count();
				} catch (IOException e) {
					throw exception("Can't read from file!");
				}
				return entryCount > 0;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw exception("Can't read from file!");
		}
		Class<?>[] pages = new Class<?>[pathsList.size()];
		for (int i = 0; i < pathsList.size(); ++i) {
			String className = pathsList.get(i).toString().substring(14).replace("\\", ".").replace(".java", "");
			try {
				Class<?> page = Class.forName(className);
				pages[i] = page;
			} catch (ClassNotFoundException e) {
				throw exception("Can't find class with name %s", className);
			}
		}
		return pages;
	}
}

package io.github.epam.bootstrap.tests.complex;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.carouselWithCaptions;
import static io.github.com.pages.BootstrapPage.carouselWithControls;
import static io.github.com.pages.BootstrapPage.carouselWithCustomInterval;
import static io.github.com.pages.BootstrapPage.carouselWithFadeTransition;
import static io.github.com.pages.BootstrapPage.carouselWithIndicators;
import static io.github.com.pages.BootstrapPage.carouselWithSlidesOnly;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.durationMoreThan;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class CarouselTests extends TestsInit {

	private String nextText = "Next";
	private String prevText = "Previous";
	private String firstSlideText = "First slide";
	private String secondSlideText = "Second slide";
	private String thirdSlideText = "Third slide";
	private String firstSlideFullText = firstSlideText + "\n" + prevText + "\n" + nextText;
	private String secondSlideFullText = secondSlideText + "\n" + prevText + "\n" + nextText;
	private String thirdSlideFullText = thirdSlideText + "\n" + prevText + "\n" + nextText;

	private String firstSlideWithLabelText = firstSlideText + "\n" + "FIRST SLIDE LABEL\n"
			+ "Nulla vitae elit libero, a pharetra augue mollis interdum.\n" + prevText + "\n" + nextText;
	private String secondSlideWithLabelText = secondSlideText + "\n" + "SECOND SLIDE LABEL\n"
			+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" + prevText + "\n" + nextText;
	private String thirdSlideWithLabelText = thirdSlideText + "\n" + "THIRD SLIDE LABEL\n"
			+ "Praesent commodo cursus magna, vel scelerisque nisl consectetur.\n" + prevText + "\n" + nextText;
	
	private int interval = 5;

	@BeforeMethod
	public void before() {
		shouldBeLoggedIn();
		bsPage.shouldBeOpened();
		refresh();
	}

	// Carousel slides only tests
	@Test
	public void getSlidesTextTest() {
		carouselWithSlidesOnly.is().text(firstSlideText);
		carouselWithSlidesOnly.is().text(secondSlideText);
	}

	// Carousel with controls tests
	@Test
	public void prevTest() {
		carouselWithControls.prev();
		carouselWithControls.is().text(secondSlideFullText);

		carouselWithControls.prev();
		carouselWithControls.is().text(firstSlideFullText);

		carouselWithControls.prevControl().is().text(prevText);
	}

	@Test
	public void nextTest() {
		carouselWithControls.next();
		carouselWithControls.is().text(firstSlideFullText);

		carouselWithControls.next();
		carouselWithControls.is().text(secondSlideFullText);

		carouselWithControls.nextControl().is().text(nextText);
	}

	// Carousel with indicators tests
	@Test
	public void selectTest() {
		carouselWithIndicators.select(1);
		carouselWithIndicators.is().text(firstSlideFullText);
		carouselWithIndicators.get(1).is().selected();
		carouselWithIndicators.get(2).is().deselected();

		carouselWithIndicators.select(3);
		carouselWithIndicators.is().text(thirdSlideFullText);
		carouselWithIndicators.get(3).is().selected();
		carouselWithIndicators.get(1).is().deselected();

		carouselWithIndicators.select(2);
		carouselWithIndicators.is().text(secondSlideFullText);
		carouselWithIndicators.get(2).is().selected();
		carouselWithIndicators.get(3).is().deselected();
	}

	// Carousel with captions tests
	@Test
	public void captionTest() {
		carouselWithCaptions.select(1);
		carouselWithCaptions.is().text(firstSlideWithLabelText);

		carouselWithCaptions.select(2);
		carouselWithCaptions.is().text(secondSlideWithLabelText);

		carouselWithCaptions.select(3);
		carouselWithCaptions.is().text(thirdSlideWithLabelText);
	}

	// Carousel fade tests
	@Test
	public void fadePrevTest() {
		carouselWithFadeTransition.prev();
		carouselWithFadeTransition.is().text(thirdSlideFullText);

		carouselWithFadeTransition.prev();
		carouselWithFadeTransition.is().text(secondSlideFullText);

		carouselWithFadeTransition.prevControl().is().text(prevText);
	}

	@Test
	public void fadeNextTest() {
		carouselWithFadeTransition.next();
		carouselWithFadeTransition.is().text(secondSlideFullText);

		carouselWithFadeTransition.next();
		carouselWithFadeTransition.is().text(thirdSlideFullText);

		carouselWithFadeTransition.nextControl().is().text(nextText);
	}

	// Carousel with interval tests
	@Test
	public void intervalTest() {
		int customInterval = 1;
		WebPage.reload();
		durationMoreThan(interval, () -> carouselWithCustomInterval.is().text(secondSlideFullText));
		customInterval = carouselWithCustomInterval.interval() / 1000;
		durationMoreThan(customInterval, () -> carouselWithCustomInterval.is().text(thirdSlideFullText));
		customInterval = carouselWithCustomInterval.interval() / 1000;
		durationMoreThan(customInterval, () -> carouselWithCustomInterval.is().text(firstSlideFullText));
		customInterval = carouselWithCustomInterval.interval() / 1000;
		durationMoreThan(customInterval, () -> carouselWithCustomInterval.is().text(secondSlideFullText));
	}
}

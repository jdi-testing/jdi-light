package io.github.epam.bootstrap.tests.complex;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.com.entities.SlideInfo;
import io.github.com.sections.Slide;
import io.github.epam.TestsInit;
import org.testng.annotations.*;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.*;
import static io.github.epam.states.States.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class CarouselTests implements TestsInit {
	final SlideInfo firstSlide = new SlideInfo().set(s -> {
		s.title = "First slide";
		s.image = "Wolverin";
		s.text = "Nulla vitae elit libero, a pharetra augue mollis interdum.";
		s.src = "wolverin.jpg";
	});
	final SlideInfo secondSlide = new SlideInfo().set(s -> {
		s.title = "Second slide";
		s.image = "Cyclope";
		s.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
		s.src = "cyclope.jpg";
	});
	final SlideInfo thirdSlide = new SlideInfo().set(s -> {
		s.title = "Third slide";
		s.image = "Punisher";
		s.text = "Praesent commodo cursus magna, vel scelerisque nisl consectetur.";
		s.src = "punisher.jpg";
	});

	@BeforeMethod
	public void before() {
		shouldBeLoggedIn();
		bsPage.shouldBeOpened();
		WebPage.reload();
		carousel.show();
		carousel.slides.refresh();
	}

	@Test
	public void getSlideTest() {
		Slide slide = carousel.activeSlide();
		slide.has().text(firstSlide.visibleText());
	}

	@Test
	public void nextSlideTest() {
		carousel.next();
		Slide slide = carousel.activeSlide();
		slide.has().text(secondSlide.visibleText());
	}

	@Test
	public void prevSlideTest() {
		carousel.previous();
		Slide slide = carousel.activeSlide();
		slide.has().text(thirdSlide.visibleText());
	}

	@Test
	public void selectSlideTest() {
		carousel.openSlide(3);
		Slide slide = carousel.activeSlide();
		slide.has().text(thirdSlide.visibleText());
		slide.image.find("img").has().attr("src", containsString(thirdSlide.src));
	}

	@Test
	public void selectSlideByNameTest() {
		carousel.openSlide(secondSlide.title);
		Slide slide = carousel.activeSlide();
		slide.has().text(secondSlide.visibleText());
		slide.image.find("img").has().attr("src", containsString(secondSlide.src));
	}
	@Test
	public void getSlideDataTest() {
		SlideInfo info = carousel.activeSlideData();
		assertEquals(info.toString(), firstSlide.visibleText());
	}

	@Test
	public void getSlideDataByIndexTest() {
		SlideInfo info = carousel.slides.getData(2);
		assertEquals(info.toString(), secondSlide.toString());
	}
	@Test
	public void getSlideDataByTextTest() {
		SlideInfo info = carousel.slides.getData(thirdSlide.title);
		assertEquals(info.toString(), thirdSlide.toString());
	}
	@Test
	public void getSlideByIndexTest() {
		Slide info = carousel.slides.get(2);
		info.image.find("img").has().attr("src", containsString(secondSlide.src));
	}
	@Test
	public void getSlideByTextTest() {
		Slide info = carousel.slides.get(thirdSlide.title);
		info.image.find("img").has().attr("src", containsString(thirdSlide.src));
	}

	@Test
	public void isValidationTest() {
		carousel.is().displayed().enabled();
		carousel.has().text(firstSlide.visibleText());
	}
	@Test
	public void baseValidationTest() {
		baseValidation(carousel);
	}
}

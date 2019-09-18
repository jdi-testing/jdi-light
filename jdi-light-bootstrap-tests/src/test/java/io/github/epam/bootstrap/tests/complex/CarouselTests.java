package io.github.epam.bootstrap.tests.complex;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.com.pages.BootstrapPage.carouselWithSlidesOnly;
import static io.github.epam.states.States.shouldBeLoggedIn;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import io.github.epam.TestsInit;

public class CarouselTests extends TestsInit {
	
	@BeforeMethod
	public void before() {
		shouldBeLoggedIn();
		bsPage.shouldBeOpened();
		refresh();
	}
	
	private String nextText = "Next";
	private String prevText = "Previous";
	private String firstSlideText = "First slide";
	private String secondSlideText = "Second slide";
	private String thirdSlideText = "Third slide";
	private String firstSlideFullText = firstSlideText + "\n" + prevText + "\n" + nextText;
	private String secondSlideFullText = secondSlideText + "\n" + prevText + "\n" + nextText;
	private String thirdSlideFullText = thirdSlideText + "\n" + prevText + "\n" + nextText;
	
	private String firstSlideWithLabelText = firstSlideText + "\n" +
	                                 "FIRST SLIDE LABEL\n" +
			                         "Nulla vitae elit libero, a pharetra augue mollis interdum.\n" + 
	                                 prevText + "\n" + nextText;
	private String secondSlideWithLabelText = secondSlideText + "\n" + 
			                          "SECOND SLIDE LABEL\n" + 
			                          "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" + 
			                          prevText + "\n" + nextText;
	private String thirdSlideWithLabelText = thirdSlideText + "\n" + 
			                          "THIRD SLIDE LABEL\n" + 
			                          "Praesent commodo cursus magna, vel scelerisque nisl consectetur.\n" + 
			                          prevText + "\n" + nextText;

	//Carousel slides only tests
	@Test
	public void getSlidesTextTest() {
		assertEquals(carouselWithSlidesOnly.getText(), firstSlideText);
		
		//carouselSlidesOnly.base().waitSec(10);
		delay(10000);
		assertEquals(carouselWithSlidesOnly.getText(), secondSlideText);
	}
	
	//Carousel with controls tests
	@Test
	public void prevTest() {
		carouselWithControls.prev();	
		//carouselControls.base().waitSec(1);
		delay(1000);
		carouselWithControls.is().text(secondSlideFullText);
		assertEquals(carouselWithControls.getText(), secondSlideFullText);
		
		carouselWithControls.prev();	
		//carouselControls.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithControls.getText(), firstSlideFullText);
		
		assertEquals(carouselWithControls.prevControl().getText(), prevText);
	}
	
	@Test
	public void nextTest() {
		carouselWithControls.next();	
		//carouselControls.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithControls.getText(), firstSlideFullText);
		
		carouselWithControls.next();	
		//carouselControls.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithControls.getText(), secondSlideFullText);
		
		assertEquals(carouselWithControls.nextControl().getText(), nextText);
	}
	
	//Carousel with indicators tests
	@Test
	public void selectTest() {
		carouselWithIndicators.select(1);	
		//carouselIndicators.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithIndicators.getText(), firstSlideFullText);
		assertTrue(carouselWithIndicators.list().get(0).isSelected());
		assertFalse(carouselWithIndicators.list().get(1).isSelected());
		
		carouselWithIndicators.select(3);	
		//carouselIndicators.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithIndicators.getText(), thirdSlideFullText);
		assertTrue(carouselWithIndicators.list().get(2).isSelected());
		assertFalse(carouselWithIndicators.list().get(0).isSelected());
		
		carouselWithIndicators.select(2);	
		//carouselIndicators.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithIndicators.getText(), secondSlideFullText);
		assertTrue(carouselWithIndicators.list().get(1).isSelected());
		assertFalse(carouselWithIndicators.list().get(2).isSelected());
    }
	
	//Carousel with captions tests
	@Test
	public void captionTest() {
		carouselWithCaptions.select(1);
		//carouselCaptions.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithCaptions.getText(), firstSlideWithLabelText);
		
		carouselWithCaptions.select(2);
		//carouselCaptions.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithCaptions.getText(), secondSlideWithLabelText);

		carouselWithCaptions.select(3);
		//carouselCaptions.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithCaptions.getText(), thirdSlideWithLabelText);

	}
	
	// Carousel fade tests
	@Test
	public void fadePrevTest() {
		carouselWithFadeTransition.prev();	
		//carouselFade.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithFadeTransition.getText(), thirdSlideFullText);
		
		carouselWithFadeTransition.prev();	
		//carouselFade.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithFadeTransition.getText(), secondSlideFullText);
		
		assertEquals(carouselWithFadeTransition.prevControl().getText(), prevText);
	}
	
	@Test
	public void fadeNextTest() {
		carouselWithFadeTransition.next();	
		//carouselFade.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithFadeTransition.getText(), secondSlideFullText);
		
		carouselWithFadeTransition.next();	
		//carouselFade.base().waitSec(1);
		delay(1000);
		assertEquals(carouselWithFadeTransition.getText(), thirdSlideFullText);
		
		assertEquals(carouselWithFadeTransition.nextControl().getText(), nextText);
	}
	
	
	// Carousel with interval tests
	@Test
	public void intervalTest() {
		//carouselInterval.base().waitSec(1);
		delay(carouselWithCustomInterval.interval());
		assertEquals(carouselWithCustomInterval.getText(), firstSlideFullText);
		
		//carouselInterval.base().waitSec(1);
		delay(carouselWithCustomInterval.interval());
		assertEquals(carouselWithCustomInterval.getText(), secondSlideFullText);
		
		//carouselInterval.base().waitSec(1);
		delay(carouselWithCustomInterval.interval());
		assertEquals(carouselWithCustomInterval.getText(), thirdSlideFullText);
	}

	public void delay(long ms) {
		try {
			System.out.println("DELAY: " + ms);
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

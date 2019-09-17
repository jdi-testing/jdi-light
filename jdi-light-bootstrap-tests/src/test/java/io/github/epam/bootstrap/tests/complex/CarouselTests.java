package io.github.epam.bootstrap.tests.complex;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.com.pages.BootstrapPage.carouselSlidesOnly;
import static io.github.epam.states.States.shouldBeLoggedIn;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.epam.TestsInit;

public class CarouselTests extends TestsInit {
	
	@BeforeMethod
	public void before() {
		shouldBeLoggedIn();
		bsPage.shouldBeOpened();
	}

	String text = "First slide";
	String text2 = "Second slide";
	String text3 = "Third slide";

	@Test
	public void getTextTest() {
//		System.out.println(carouselControls.list().get(0).isDeselected());
//		System.out.println(carouselControls.list().get(1).isDeselected());
		System.out.println(carouselControls.list().size());
	
	}
	
	@Test
	public void getTextTest2() {
		
		carouselIndicators.select(3);	
		carouselIndicators.base().waitSec(2);
		System.out.println("SIZE: " + carouselIndicators.list().size());
		System.out.println("GET 1 " + carouselIndicators.list().get(1).isSelected());
		System.out.println("GET 2 " + carouselIndicators.list().get(2).isSelected());
		System.out.println(carouselIndicators.getText());
		System.out.println("SELECTED VALUE: " + carouselIndicators.selected());
		
		carouselIndicators.select(1);
		carouselIndicators.base().waitSec(2);
		System.out.println(carouselIndicators.getText());
		carouselIndicators.select(2);
		carouselIndicators.base().waitSec(2);
		System.out.println(carouselIndicators.getText());
		
	}
	
	@Test
	public void getTextTest3() {
		
		System.out.println("INTERVAL: " + carouselInterval.getInterval());
		
	}
}

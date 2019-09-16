package io.github.epam.bootstrap.tests.complex;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.carouselControls;
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
		System.out.println(carouselControls.list().get(0).getText());
		System.out.println(carouselControls.list().get(1).getText());
		System.out.println(carouselControls.list().get(2).getText());
		//System.out.println(carouselControls.list().size());
	//	System.out.println(carouselControls.list().size());
	//	System.out.println(carouselControls.list());
//		carouselControls.nextControl().click();
//		System.out.println(carouselControls.getText());
//		carouselControls.base().waitSec(1);
//		carouselControls.nextControl().click();
//		System.out.println(carouselControls.getText());
//		carouselControls.base().waitSec(1);
//		carouselControls.nextControl().click();
//		System.out.println(carouselControls.getText());
	}
	
	@Test
	public void getTextTest2() {
	}
}

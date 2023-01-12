package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.INDIGO;
import static io.github.com.enums.Colors.ORANGE;
import static io.github.com.enums.Colors.PINK;
import static io.github.com.enums.Colors.PURPLE;
import static io.github.com.enums.Colors.RED;
import static io.github.com.pages.RatingsPage.colorRatingGreen;
import static io.github.com.pages.RatingsPage.colorRatingIndigo;
import static io.github.com.pages.RatingsPage.colorRatingOrange;
import static io.github.com.pages.RatingsPage.colorRatingPink;
import static io.github.com.pages.RatingsPage.colorRatingPurple;
import static io.github.com.pages.RatingsPage.colorRatingRed;
import static io.github.com.pages.RatingsPage.sizeRatingGreen;
import static io.github.com.pages.RatingsPage.sizeRatingIndigo;
import static io.github.com.pages.RatingsPage.sizeRatingPink;
import static io.github.com.pages.RatingsPage.sizeRatingPurple;
import static io.github.com.pages.RatingsPage.sizeRatingRed;

public class RatingDataProvider {
	@DataProvider(name = "colorRatingTestData")
	public Object[][] colorRatingTestData() {
		return new Object[][] {
				{PURPLE.value(), colorRatingPurple},
				{PINK.value(), colorRatingPink},
				{ORANGE.value(), colorRatingOrange},
				{GREEN.value(), colorRatingGreen},
				{RED.value(), colorRatingRed},
				{INDIGO.value(), colorRatingIndigo},
		};
	}

	@DataProvider(name = "sizeRatingTestData")
	public Object[][] sizeRatingTestTestData() {
		return new Object[][] {
				{16, sizeRatingPurple},
				{24, sizeRatingPink},
				{36, sizeRatingGreen},
				{40, sizeRatingRed},
				{64, sizeRatingIndigo},
		};
	}

	@DataProvider(name = "itemSlotRatingTestData")
	public Object[][] itemSlotRatingTestData() {
		return new Object[][] {
				{1, GREEN.value()},
				{2, PURPLE.value()},
				{3, ORANGE.value()},
				{4, INDIGO.value()},
				{5, RED.value()},
		};
	}
}

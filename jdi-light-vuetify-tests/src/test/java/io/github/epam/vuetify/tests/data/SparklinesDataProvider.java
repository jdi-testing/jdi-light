package io.github.epam.vuetify.tests.data;

import org.testng.annotations.DataProvider;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SparklinesDataProvider {
	@DataProvider(name = "fillSparklineLinearGradientTestsData")
	public Object[][] fillSparklineLinearGradientTestsData() {
		return new Object[][]{
				{Collections.singletonMap("0", "#222"), 1},
				{Collections.singletonMap("0", "#42b3f4"), 2},
				{Stream.of(new String[][]{
						{"0", "yellow"},
						{"0.5", "orange"},
						{"1", "red"},
				}).collect(Collectors.toMap(data -> data[0], data -> data[1])), 3},
				{Stream.of(new String[][]{
						{"0", "violet"},
						{"1", "purple"},
				}).collect(Collectors.toMap(data -> data[0], data -> data[1])), 4},
				{Stream.of(new String[][]{
						{"0", "#FF0"},
						{"0.5", "#F0F"},
						{"1", "#00c6ff"},
				}).collect(Collectors.toMap(data -> data[0], data -> data[1])), 5},
				{Stream.of(new String[][]{
						{"0", "#1feaea"},
						{"0.5", "#ffd200"},
						{"1", "#f72047"},
				}).collect(Collectors.toMap(data -> data[0], data -> data[1])), 6},
		};
	}
}

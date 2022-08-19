package io.github.epam.vuetify.tests.data;

import java.util.Arrays;
import java.util.List;

public class ImagesTestsData {


    public List<AspectRatioImageTestDataObject> aspectRatioImageTestData() {
        return Arrays.asList(
                new AspectRatioImageTestDataObject(300, 300.0, 168.75),
                new AspectRatioImageTestDataObject(200, 200.0, 112.5),
                new AspectRatioImageTestDataObject(248, 248.0, 139.5),
                new AspectRatioImageTestDataObject(400, 400.0, 225),
                new AspectRatioImageTestDataObject(500, 500.0, 281.25)
        );
    }

    public List<String> gridImagesLazySrcTestData() {
        return  Arrays.asList(
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/1_small.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/2_small.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/3_small.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/4_small.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/5_small.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/6_small.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/7_small.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/8_small.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/9_small.jpeg");
    }

    public List<String> gridImagesSrcTestData() {
        return  Arrays.asList(
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/1_large.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/2_large.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/3_large.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/4_large.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/5_large.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/6_large.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/7_large.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/8_large.jpeg",
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/grid_image/9_large.jpeg");
    }

    public static class AspectRatioImageTestDataObject {

        private final int sliderPosition;
        private final double width;
        private final double height;

        public AspectRatioImageTestDataObject(int sliderPosition, double width, double height) {
            this.sliderPosition = sliderPosition;
            this.width = width;
            this.height = height;
        }


        public int getSliderPosition() {
            return sliderPosition;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }
    }

}

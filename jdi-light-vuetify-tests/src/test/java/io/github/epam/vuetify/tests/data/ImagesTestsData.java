package io.github.epam.vuetify.tests.data;

import java.util.Arrays;
import java.util.List;

public class ImagesTestsData {

    public int defaultBrowserWindowWidth() {
        return 1920;
    }

    public int defaultBrowserWindowHeight() {
        return 1080;
    }

    public List<AspectRatioImageTestDataObject> aspectRatioImageTestData() {
        return Arrays.asList(
                new AspectRatioImageTestDataObject(300, 300.0, 168.75),
                new AspectRatioImageTestDataObject(200, 200.0, 112.5),
                new AspectRatioImageTestDataObject(248, 248.0, 139.5),
                new AspectRatioImageTestDataObject(400, 400.0, 225),
                new AspectRatioImageTestDataObject(500, 500.0, 281.25)
        );
    }

    public Double containImagesWidth() {
        return 643.078;
    }

    public List<Double> containImagesHeights() {
        return Arrays.asList(378.281, 321.531, 459.328, 378.281, 321.531, 459.328);
    }

    public Double heightImagesWidth() {
        return 776.5;
    }

    public Double heightImagesHeight() {
        return 125.0;
    }

    public List<String> gridImagesLazySrcTestData() {
        return  Arrays.asList(
                "https://picsum.photos/10/6?image=15", "https://picsum.photos/10/6?image=20",
                "https://picsum.photos/10/6?image=25", "https://picsum.photos/10/6?image=30",
                "https://picsum.photos/10/6?image=35", "https://picsum.photos/10/6?image=40",
                "https://picsum.photos/10/6?image=45", "https://picsum.photos/10/6?image=50",
                "https://picsum.photos/10/6?image=55");
    }

    public List<String> gridImagesSrcTestData() {
        return  Arrays.asList(
                "https://picsum.photos/500/300?image=15", "https://picsum.photos/500/300?image=20",
                "https://picsum.photos/500/300?image=25", "https://picsum.photos/500/300?image=30",
                "https://picsum.photos/500/300?image=35", "https://picsum.photos/500/300?image=40",
                "https://picsum.photos/500/300?image=45", "https://picsum.photos/500/300?image=50",
                "https://picsum.photos/500/300?image=55");
    }

    public Double gridImagesWidth() {
        return 517.656;
    }

    public Double gridImagesHeight() {
        return 517.656;
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

package io.github.epam.vuetify.tests.data;

import java.util.Arrays;
import java.util.List;

public class AspectRatiosTestsData {
    public List<AspectRatiosTestDataObject> aspectRatiosTestData() {
        return Arrays.asList(
                new AspectRatiosTestDataObject(2000, 1000),
                new AspectRatiosTestDataObject(1920, 1080),
                new AspectRatiosTestDataObject(800, 600),
                new AspectRatiosTestDataObject(400, 400),
                new AspectRatiosTestDataObject(100, 2000)
        );
    }

    public static class AspectRatiosTestDataObject {
        private final int width;
        private final int height;

        public AspectRatiosTestDataObject(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

}

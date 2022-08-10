package io.github.epam.vuetify.tests.data;

import java.util.Arrays;
import java.util.List;

public class AspectRatiosTestsData {
    /**
     * Test data with some popular resolutions of Desktop, Tablet and Mobile
     */
    public List<AspectRatiosTestDataObject> aspectRatiosTestData() {
        return Arrays.asList(
                new AspectRatiosTestDataObject(1920, 1080),
                new AspectRatiosTestDataObject(768, 1024),
                new AspectRatiosTestDataObject(601, 962)
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

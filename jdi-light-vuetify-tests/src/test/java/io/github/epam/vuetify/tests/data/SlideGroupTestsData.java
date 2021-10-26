package io.github.epam.vuetify.tests.data;

import java.util.Arrays;
import java.util.List;

public class SlideGroupTestsData {

    public List<SlideGroupTestDataObject> commonSlideGroupTestData() {
        return Arrays.asList(
                new SlideGroupTestDataObject("direct", 0, 1, 5),
                new SlideGroupTestDataObject("direct", -664, 1, 5),
                new SlideGroupTestDataObject("direct", -1316, 2, 6),
                new SlideGroupTestDataObject("reverse", -1316, 6, 2),
                new SlideGroupTestDataObject("reverse", -652, 6, 2),
                new SlideGroupTestDataObject("reverse", 0, 5, 1));
    }

    public List<Integer> centerActiveSlideGroupTestData() {
        return Arrays.asList(-130, -262, -394, -526, -658, -790, -922, -1054, -1186);
    }

    public List<SlideGroupTestDataObject> multipleSlideGroupTestData() {
        return Arrays.asList(
                new SlideGroupTestDataObject("direct", 0, 1, 5),
                new SlideGroupTestDataObject("direct", -664, 1, 5),
                new SlideGroupTestDataObject("direct", -1316, 2, 6),
                new SlideGroupTestDataObject("reverse", -1316, 6, 2));
    }


    public static class SlideGroupTestDataObject {

        private final String order;
        private final int slidesPosition;
        private final int startIndex;
        private final int endIndex;

        SlideGroupTestDataObject(String order, int slidesPosition, int startIndex, int endIndex) {
            this.order = order;
            this.slidesPosition = slidesPosition;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }


        public String getOrder() {
            return order;
        }

        public int getSlidesPosition() {
            return slidesPosition;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }
    }
}

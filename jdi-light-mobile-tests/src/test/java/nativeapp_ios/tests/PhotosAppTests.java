package nativeapp_ios.tests;

import nativeapp.ios.photos.PhotosPage;
import nativeapp_ios.PhotosAppTestInit;
import org.testng.annotations.Test;

import java.util.Arrays;

public class PhotosAppTests extends PhotosAppTestInit {

    @Test
    public void tabBarTest() {
        PhotosPage.photosTabBar.has().values(Arrays.asList("All Photos", "For You", "Albums", "Search"));

        PhotosPage.photosTabBar.tapBarButton("Search");
        PhotosPage.photosTabBar.is().selected("Search");

        PhotosPage.photosTabBar.tapBarButton("For You");
        PhotosPage.noContentText.is().displayed();
    }
}

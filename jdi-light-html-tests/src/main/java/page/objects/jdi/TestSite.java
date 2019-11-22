package page.objects.jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@SuppressWarnings("PMD.ClassNamingConventions")
public class TestSite {
    @Url("/index.html") @Title("Home Page Static")
    public static HomePageWeb homePageWeb;
    @Url("/index.html") @Title("Home Page Static Ex")
    public static HomePageWebEx homePageWebEx;
}

package nativeapp.android.apidemos.views;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;


public class ExpandableListPage {

    @MobileFindBy(accessibilityId = "1. Custom Adapter")
    public static Button customAdapter;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]" +
            "/android.widget.ExpandableListView/android.widget.TextView[1]")
    public static Button peopleNames;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]" +
            "/android.widget.ExpandableListView/android.widget.TextView[6]")
    public static Button dogNames;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]" +
            "/android.widget.ExpandableListView/android.widget.TextView[11]")
    public static Button catNames;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]" +
            "/android.widget.ExpandableListView/android.widget.TextView[14]")
    public static Button fishNames;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]" +
            "/android.widget.ExpandableListView/android.widget.TextView[16]")
    public static Button bubblesName;

    @MobileFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]" +
            "/android.widget.ExpandableListView/android.widget.TextView[2]")
    public static Button arnoldName;

    @MobileFindBy(accessibilityId = "3. Simple Adapter")
    public static Button simpleAdapter;

    @MobileFindBy(xpath = "//android.widget.TextView[@text='Group 0']")
    public static Button group0;

    @MobileFindBy(xpath = "//android.widget.TextView[@text='Child 1']")
    public static Button child1;

}

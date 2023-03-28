package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import nativeapp.ios.epamiostestapp.LabelViewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.MainPage.menuLabelView;

public class LabelsTest extends IosApplicationInit {
    @Test
    public void iosLabelsTest() {
        menuLabelView.tap();

        Assert.assertEquals(LabelViewPage.label1.getValue(), "Label1");
        Assert.assertEquals(LabelViewPage.label2.getValue(), "Label2");

    }

    @Test
    public void iosTextUnderTheLabelsTest() {
        menuLabelView.tap();
        Assert.assertEquals(LabelViewPage.text_under_label1.getValue(),
                "Text1 under the label");
        Assert.assertEquals(LabelViewPage.text_under_label2.getValue(),
                "Text2 under the label");

    }
}

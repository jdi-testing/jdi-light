package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import nativeapp.ios.epamiostestapp.LabelViewPage;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.MainPage.menuLabelView;

public class LabelsTest extends IosApplicationInit {
    @Test
    public void iosLabelsTest() {
        menuLabelView.tap();
        String labelAssert = LabelViewPage.label1.getValue();
        LabelViewPage.label1.is().text(labelAssert);

        LabelViewPage.label2.is().text("Label2");

    }

    @Test
    public void iosTextUnderTheLabelsTest() {
        menuLabelView.tap();
        String labelAssert = LabelViewPage.text_under_label1.getValue();
        LabelViewPage.text_under_label1.is().text(labelAssert);

        LabelViewPage.text_under_label2.is().text("Text2 under the label");

    }
}

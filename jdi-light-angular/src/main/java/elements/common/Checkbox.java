package elements.common;

public class Checkbox extends com.epam.jdi.light.ui.html.elements.common.Checkbox {

    @Override
    public boolean isSelected() {
        return super.isSelected() || hasClass("mat-checkbox-checked");
    }

    @Override
    public boolean isEnabled() {
        if (hasClass("mat-checkbox-disabled")) {
            return false;
        }
        return super.isEnabled();
    }

    @Override
    public boolean isDisabled() {
        return !isEnabled();
    }
}

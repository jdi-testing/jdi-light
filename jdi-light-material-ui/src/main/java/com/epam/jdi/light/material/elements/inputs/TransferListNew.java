package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.TransferListNewAssert;


public class TransferListNew extends UIBaseElement<TransferListNewAssert>  {

    @Override
    public TransferListNewAssert is() {
        return new TransferListNewAssert().set(this);
    }
}

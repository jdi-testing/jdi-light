package com.epam.jdi.light.material.elements.inputs.TransferList;

public class SimpleTransferList extends TransferList {

    public void moveAllItemsLeft(){
        this.find(moveAllLeftButton).click();
    }

    public void moveAllItemsRight(){
        this.find(moveAllRightButton).click();
    }
}

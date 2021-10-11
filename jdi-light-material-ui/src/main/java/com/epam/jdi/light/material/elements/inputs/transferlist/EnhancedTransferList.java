package com.epam.jdi.light.material.elements.inputs.transferlist;

public class EnhancedTransferList extends TransferList {

  @Override
  public void moveAllElementsLeft() {
    //TODO replace to checkbox
    this.find(allItemsRightCheckbox).click();
    this.find(moveLeftButton).click();
  }


  @Override
  public void moveAllElementsRight() {
    this.find(allItemsLeftCheckbox).click();
    this.find(moveRightButton).click();
  }

}

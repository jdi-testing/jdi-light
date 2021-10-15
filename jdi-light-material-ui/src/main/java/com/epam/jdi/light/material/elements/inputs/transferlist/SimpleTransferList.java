package com.epam.jdi.light.material.elements.inputs.transferlist;

public class SimpleTransferList extends TransferList {

  @Override
  public void moveAllElementsLeft() {
    this.find(moveAllLeftButton).click();
  }

  @Override
  public void moveAllElementsRight() {
    this.find(moveAllRightButton).click();
  }
}

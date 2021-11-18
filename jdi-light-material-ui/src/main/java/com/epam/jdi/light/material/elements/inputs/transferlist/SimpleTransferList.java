package com.epam.jdi.light.material.elements.inputs.transferlist;

/**
 * To see an example of Simple Transfer List web element please visit
 * https://mui.com/components/transfer-list/#basic-transfer-list
 */

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

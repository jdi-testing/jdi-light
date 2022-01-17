package com.epam.jdi.light.material.elements.inputs.transferlist;

import com.epam.jdi.light.common.JDIAction;

/**
 * To see an example of Simple Transfer List web element please visit
 * https://mui.com/components/transfer-list/#basic-transfer-list
 */

public class SimpleTransferList extends TransferList {

  @JDIAction("Moves all {name}'s elements left")
  @Override
  public void moveAllElementsLeft() {
    this.find(moveAllLeftButton).click();
  }

  @JDIAction("Moves all {name}'s elements right")
  @Override
  public void moveAllElementsRight() {
    this.find(moveAllRightButton).click();
  }
}

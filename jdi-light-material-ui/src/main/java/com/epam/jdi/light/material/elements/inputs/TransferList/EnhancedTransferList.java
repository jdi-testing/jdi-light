package com.epam.jdi.light.material.elements.inputs.TransferList;

public class EnhancedTransferList extends TransferList {

  public boolean isSubhesdersCorrect(String leftHeader, String rightHeader){
    return leftHeader.equals(this.finds(subHeadersText).get(0)) &&
        rightHeader.equals(this.finds(subHeadersText).get(1));
  }

}

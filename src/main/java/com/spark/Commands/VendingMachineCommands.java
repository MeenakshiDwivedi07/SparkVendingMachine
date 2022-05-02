package com.spark.Commands;

public class VendingMachineCommands {
    private String displayMessage;

    public VendingMachineCommands() {
    }
    public String display() {
        return displayMessage;
    }

    public void startVendingMachine(String productList) {
        displayMessage = "Please choose products"+":"+productList;
    }
    public void itemDispensed(String productName) {
        displayMessage = "Please collect :" +productName;
    }

    public void itemNotPresent() throws Exception {
        displayMessage = "Item is not available.";
        throw new Exception(displayMessage);

    }
}

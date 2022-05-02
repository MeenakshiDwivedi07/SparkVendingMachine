package com.spark;

import Controller.VendingMachineController;

import java.util.Scanner;


/**
 * vending machine application
 *takes input from the list of three items
 * update inventory
 */


public class VendingMachineApplication {

    public static void main(String[] args) {
        VendingMachineApplication app = new VendingMachineApplication();
        try {
            app.run();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void run() throws Exception {
        VendingMachineController vendingMachineController = new VendingMachineController();
        vendingMachineController.loadVendingMachine("SparklingWater",2,
                "SparkPasta", 3,
                "SparkSoda",5
        );

        Scanner in=new Scanner(System.in);
        System. out. println("Please enter your EmployeeId");
        String employeeId=in.nextLine();
        vendingMachineController.employeeStartProcess(employeeId);
        vendingMachineController.startVendingMachine();
        System.out.println(vendingMachineController.display());
        String selected = in.nextLine();
        if(selected.equalsIgnoreCase("1"))  selected = "sparklingwater";
        else if(selected.equalsIgnoreCase("2")) selected = "sparkpasta";
        else if(selected.equalsIgnoreCase("3")) selected = "sparksoda";
        else selected = selected.toLowerCase();
        vendingMachineController.selectProduct(selected);
        System.out.println(vendingMachineController.display());

    }

}

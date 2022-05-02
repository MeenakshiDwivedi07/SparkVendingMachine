package Controller;

import com.spark.Commands.VendingMachineCommands;
import com.spark.Person.Employee;
import com.spark.Products.Products;
import com.spark.Products.SparkPasta;
import com.spark.Products.SparklingWater;
import com.spark.Products.Sparksoda;
import com.spark.inventory.Inventory;

import java.util.ArrayList;
import java.util.Optional;

public class VendingMachineController {
    private Inventory productInventory;
    private Products dispensedItem = null;

    private Employee procurer = null;
    private VendingMachineCommands vendingMachineCommands;
    private boolean itemDispensed;

    public VendingMachineController() {
        vendingMachineCommands = new VendingMachineCommands();

    }

    public void loadVendingMachine(String SparklingWater, Integer QuantityWater,
                            String SparkPasta,Integer QuantityPasta,
                            String SparkSoda,Integer QuantitySoda) {
        Inventory inventory = new Inventory();

        ArrayList<Products> sparklingWater = new ArrayList<>(1);
        for(int i=0; i<QuantityWater;i++) {
            sparklingWater.add(new SparklingWater(SparklingWater));
        }

        ArrayList<Products> sparkPasta = new ArrayList<>(1);
        for(int i=0; i<QuantityPasta;i++) {
            sparkPasta.add(new SparkPasta(SparkPasta));
        }

        ArrayList<Products> sparkSoda = new ArrayList<>(1);
        for(int i=0; i<QuantitySoda;i++) {
            sparkSoda.add(new Sparksoda(SparkSoda));
        }

        inventory.addProduct("sparklingwater", sparklingWater);
        inventory.addProduct("sparkpasta", sparkPasta);
        inventory.addProduct("sparksoda", sparkSoda);
        addProductInventory(inventory);
        startVendingMachine();

    }

    public String display() {
        String messageToDisplay = vendingMachineCommands.display();
        return messageToDisplay;
    }
    public Employee employeeStartProcess(String EmployeeId) {
        procurer = new Employee(EmployeeId);
        return procurer;
    }


    public void selectProduct(String selection) throws Exception {
        Optional<Products> optionalProduct = productInventory.getProduct(selection);

        if (optionalProduct.isPresent()) {

            if (!(procurer.getEmployeeId() == null)) {
                dispenseItems(selection, optionalProduct);
            }
        } else {
            vendingMachineCommands.itemNotPresent();
        }

        if (itemDispensed) {
            vendingMachineCommands.itemDispensed(dispensedItem.getProductName());
        }
    }

    private void dispenseItems(String selection, Optional<Products> optionalProduct) {

        itemDispensed = true;
        dispensedItem = optionalProduct.get();
    }

    public void addProductInventory(Inventory inventory) {
        this.productInventory = inventory;
    }

    public Inventory getProductInventory() {
        return this.productInventory;
    }

    public void startVendingMachine() {
        String productList = "";
        int i =1;

        for (String name : productInventory.getProducts().keySet()) {
            name = i++ + ". " +name;
            productList = productList+name+"\n";
        }

        vendingMachineCommands.startVendingMachine(productList);
        vendingMachineCommands.display();
    }
}

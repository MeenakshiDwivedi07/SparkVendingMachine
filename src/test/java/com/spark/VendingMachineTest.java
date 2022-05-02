package com.spark;


import Controller.VendingMachineController;
import com.spark.Person.Employee;
import com.spark.inventory.Inventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class VendingMachineTest {
    private VendingMachineController vendingMachine;
    private Employee employee;

    private Inventory inventory;


    @Before
    public void setUp() {
        vendingMachine = new VendingMachineController();
        vendingMachine.loadVendingMachine("SparklingWater",2,
                "SparkPasta", 3,
                "SparkSoda",5
        );
        employee = vendingMachine.employeeStartProcess("EMP001");
        inventory = vendingMachine.getProductInventory();
        vendingMachine.startVendingMachine();

    }

    @Test
    public void test_vending_machine_checks_employee() {
        Assert.assertEquals(employee.getEmployeeId(), "EMP001");
    }

    @Test
    public void test_vending_machine_gets_valid_inventory_products() {
      vendingMachine.startVendingMachine();
      Assert.assertTrue(vendingMachine.display().toLowerCase().contains("spark"));
    }

    @Test
    public void test_vending_machine_displays_sparkwater_when_item_is_selected_reduce_quantity() throws Exception {
        vendingMachine.selectProduct("sparklingwater");
        Assert.assertEquals("please collect :sparklingwater", vendingMachine.display().toLowerCase());
        Assert.assertEquals(1,inventory.getProducts().get("sparklingwater").size());


    }

    @Test
    public void test_vending_machine_displays_sparksoda_when_item_is_selected_reduce_quantity() throws Exception {
        vendingMachine.selectProduct("sparksoda");
        Assert.assertEquals("please collect :sparksoda", vendingMachine.display().toLowerCase());
        Assert.assertEquals(4,inventory.getProducts().get("sparksoda").size());
    }



    @Test
    public void test_vending_machine_displays_sparkpasta_when_item_is_selected_reduce_quantity() throws Exception {
        vendingMachine.selectProduct("sparkpasta");
        Assert.assertEquals("please collect :sparkpasta", vendingMachine.display().toLowerCase());
        Assert.assertEquals(2,inventory.getProducts().get("sparkpasta").size());

    }


    @Test
    public void test_vending_machine_zero_quantity_of_sparklingsoda_displays_no() {
        Assert.assertEquals(5,inventory.getProducts().get("sparksoda").size());
        try {
            vendingMachine.selectProduct("sparksoda");
            vendingMachine.selectProduct("sparksoda");
            vendingMachine.selectProduct("sparksoda");
            vendingMachine.selectProduct("sparksoda");
            vendingMachine.selectProduct("sparksoda");
            vendingMachine.selectProduct("sparksoda");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertEquals("Item is not available.", e.getMessage());
        }
    }

}

package com.spark.inventory;

import com.spark.Products.Products;

import java.util.*;

public class Inventory {

    private Map<String, ArrayList<Products>> products;

    public Inventory() {
        products = new HashMap<>(9);
    }

    public Map<String, ArrayList<Products>> getProducts() {
        return products;
    }

    /**
     * Grab the product based on the selection. For a vending machine inventory system, the inventory
     * doesn't have an exact idea of what product is in it. Just a letter/number system that corresponds to
     * what it holds.
     *
     * @param selection
     * @return Optional VMProduct. The item may or may not be in the inventory
     */
    public Optional<Products> getProduct(String selection) {
        ArrayList<Products> productSelection = products.get(selection);
        Optional<Products> productToReturn = Optional.empty();

        //Grabbing, returning, removing the first product (if found) in the list, it's the first one seen
        if (productSelection != null && productSelection.size() > 0) {
            productToReturn = Optional.of(productSelection.get(0));
            productSelection.remove(0);
        }

        return productToReturn;
    }

    public void addProduct(String selectionNumber, ArrayList<Products> product) {
        products.put(selectionNumber, product);
    }
}

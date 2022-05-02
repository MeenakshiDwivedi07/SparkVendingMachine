package com.spark.Products;


public class Sparksoda implements Products {
    final String productName;
    public Sparksoda(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }
}

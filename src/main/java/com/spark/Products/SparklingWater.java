package com.spark.Products;


public class SparklingWater implements Products {
    final String productName;
    public SparklingWater(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }
}

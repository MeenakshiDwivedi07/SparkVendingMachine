package com.spark.Products;


public class SparkPasta implements Products {
    final String productName;
    public SparkPasta(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }
}

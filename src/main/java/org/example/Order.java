package org.example;

import org.example.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Order<Product>{
    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public String getProduct(int index) {
        return productList.get(index).toString();
    }

    public Order(List<Product> productList) {
        this.productList = productList;
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("-".repeat(15))
              .append(" Order ")
              .append("-".repeat(15))
              .append("\n");
        for (Product product:productList) {
            result.append(product)
                  .append("\n");
        }
        result.append("-".repeat(37));
        return result.toString();
    }



    public void addProduct(Product product) {
        productList.add(product);
    }
}

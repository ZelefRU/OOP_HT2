package org.example.People;

import org.example.Order;
import org.example.Products.Product;

import java.util.List;

public class Client extends Order<Product> {
    private String name;

    public Client(String name, List<Product> products) {
        super(products);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Name: " + name + "\nOrder: ");

        for (Product product : getProductList()) {
            result.append(product.getName())
                    .append(", ");
        }
        result = new StringBuilder(result.substring(0, result.length() - 2));
        return result.toString();
    }
}

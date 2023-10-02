package org.example.Products;

public class Product {
    protected String name;
    protected int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public Product(Product product) {
        this.name = product.name;
        this.price = product.price;
    }


    @Override
    public String toString() {
        return String.format("Product %s, price %s", name, price);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

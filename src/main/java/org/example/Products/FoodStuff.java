package org.example.Products;

public class FoodStuff extends Product{
    protected float weight;

    public FoodStuff(String name, int price, float weight) {
        super(name, price);
        this.weight = weight;
    }

    public FoodStuff(FoodStuff foodStuff) {
        this.name = foodStuff.name;
        this.price = foodStuff.price;
        this.weight = foodStuff.weight;
    }

    @Override
    public String toString() {
        return String.format("Foodstuff %s, price %s, weight %s", name, price, weight);
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}

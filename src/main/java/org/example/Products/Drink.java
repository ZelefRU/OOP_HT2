package org.example.Products;

public class Drink extends Product{
    protected float volume;

    public Drink(String name, int price, float volume) {
        super(name, price);
        this.volume = volume;
    }

    public Drink(Drink drink){
        this.name = drink.name;
        this.price = drink.price;
        this.volume = drink.volume;
    }

    public Drink() {
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("Drink %s, price %s, volume %sl",name,price,volume);
    }
}

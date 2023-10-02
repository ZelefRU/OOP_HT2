package org.example.Products;

public class DrinkWithTemp extends Drink{
    private int temp;

    public DrinkWithTemp(String name, int price, float volume, int temp) {
        super(name, price, volume);
        this.temp = temp;
    }

    public DrinkWithTemp(DrinkWithTemp drinkWithTemp){
        this.name = drinkWithTemp.name;
        this.price = drinkWithTemp.price;
        this.volume = drinkWithTemp.volume;
        this.temp = drinkWithTemp.temp;
    }

    @Override
    public String toString() {
        String tempWord = (temp < 10) ? "Cold" : (temp > 70) ? "Hot" : "Warm";
        return String.format("%s drink %s, price %s, volume %s, temp %sC*",tempWord,name,price,volume,temp);
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}

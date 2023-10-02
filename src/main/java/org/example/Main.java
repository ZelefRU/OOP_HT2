package org.example;

import org.example.Enums.EDrink;
import org.example.Enums.EDrinkWithTemp;
import org.example.Enums.EFoodStuff;
import org.example.Enums.Names;
import org.example.People.Client;
import org.example.Products.Drink;
import org.example.Products.DrinkWithTemp;
import org.example.Products.FoodStuff;
import org.example.Products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Client> clientList = new ArrayList<>(getRandomClinetList(7,2,6));
        Market magnum = new Market("Magnum", clientList);

        System.out.println(magnum.getClientList());
        magnum.removeFirstInQueue();
        System.out.println(magnum.getClientList());
        magnum.addInQueue(getRandomClient(5));
        System.out.println(magnum.getClientList());
        magnum.updateQueue();


    }

    /***
     * Возвращает набором случайных продуктов.
     * @param count Количество в списке
     * @return {@link List}<{@link Product}>
     */
    public static List<Product> getRandomOrder(int count) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            productList.add(getRandomProduct());
        }
        return productList;
    }

    /**
     * Возвращает случайный продукт.
     * @return {@link Product}
     */
    public static Product getRandomProduct() {
        int random = new Random().nextInt(1,4);
        switch (random) {
            case 1 -> {return getRandomDrink();}
            case 2 -> {return getRandomDrinkWithTemp();}
            case 3 -> {return getRandomFoodStuff();}
        }
        return new Product("empty", 0);
    }

    /**
     * Возвращает случайный Напиток
     * @return {@link Drink}
     */
    public static Drink getRandomDrink() {
        List<String> drinks = new ArrayList<>();
        for (EDrink eDrink : EDrink.values()) drinks.add(eDrink.name());
        String name = drinks.get(new Random().nextInt(drinks.size()));
        int price = new Random().nextInt(15,55) * 10;
        float volume = ((new Random().nextInt(1, 8)) * 0.25f / 10f);
        return new Drink(name, price, volume);
    }

    /**
     * Возвращает случайный напиток с Температурой
     * @return {@link DrinkWithTemp}
     */
    public static DrinkWithTemp getRandomDrinkWithTemp() {
        List<String> drinks = new ArrayList<>();
        for (EDrinkWithTemp eDrinkWithTemp : EDrinkWithTemp.values()) drinks.add(eDrinkWithTemp.name());
        String name = drinks.get(new Random().nextInt(drinks.size()));
        int price = new Random().nextInt(15,55) * 10;
        float volume = ((new Random().nextInt(1, 8)) * 0.25f / 10f);
        int temp = new Random().nextInt(-5,9) * 10;
        return new DrinkWithTemp(name, price, volume, temp);
    }

    /**
     * Возвращает случайный съедобный продукт
     * @return {@link FoodStuff}
     */
    public static FoodStuff getRandomFoodStuff() {
        List<String> food = new ArrayList<>();
        for (EFoodStuff eFoodStuff : EFoodStuff.values()) food.add(eFoodStuff.name());
        String name = food.get(new Random().nextInt(food.size()));
        int price = new Random().nextInt(15,55) * 10;
        float weight = ((new Random().nextInt(10, 150)) * 10f);
        return new FoodStuff(name, price, weight);
    }

    /**
     * Возвращает случайное имя из {@link Names}
     * @return {@link String}
     */
    public static String getRandomName() {
        List<String> names = new ArrayList<>();
        for(Names name: Names.values()) names.add(name.name());
        return names.get(new Random().nextInt(names.size()));
    }

    /**
     * Возвращает случайного Клиента
     * @param orderItemCount Количество заказов
     * @return {@link Client}
     */
    public static Client getRandomClient(int orderItemCount) {
        return new Client(getRandomName(),getRandomOrder(orderItemCount));
    }

    /**
     * Возвращает заполненный список со случайными клиентами и заказами.
     * @param count Количество клиентов в списке
     * @param orderItemCountMin Минимальное количество заказов
     * @param orderItemCountMax Максимальное количество заказов
     * @return {@link List}<{@link Client}>
     */
    public static List<Client> getRandomClinetList(int count, int orderItemCountMin, int orderItemCountMax) {
        List<Client> clientList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            clientList.add(new Client(getRandomName(), getRandomOrder(new Random()
                    .nextInt(orderItemCountMin,orderItemCountMax))));
        }
        return clientList;
    }
}
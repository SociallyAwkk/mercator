package com.goldpiecessoftware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Checkout {

    private final Map<String, Fruit> items = Map.of(
            "Apple", new Fruit("Apple", 2, 60),
            "Orange", new Fruit("Orange", 3, 25),
            "Banana", new Fruit("Banana", 2, 20)
    );

    public int getPricePence(String item){
        Fruit fruit =  items.get(item);
        return fruit.getPriceInPence();
    }

    public Fruit getFruit(String item){
        return items.get(item);
    }

    public int getTotalPricePence(List<String> itemList){
        int total = 0;

        int appleCount = FruitCount(itemList, "Apple");
        int orangeCount = FruitCount(itemList, "Orange");
        int bananaCount = FruitCount(itemList, "Banana");

        int appleCountWithDiscount = FruitPostDiscount(itemList, "Apple");
        int orangeCountWithDiscount = FruitPostDiscount(itemList, "Orange");
        int bananaCountWithDiscount = FruitPostDiscount(itemList, "Banana");

        int applesThatWerentImpactedByDiscount = appleCount % getFruit("Apple").getOfferFactor();
        int bananasThatWerentImpactedByDiscount = bananaCount % getFruit("Banana").getOfferFactor();


        List<Integer> leftovers = new ArrayList<>();
        for (int i = 0; i < applesThatWerentImpactedByDiscount; i++) leftovers.add(getPricePence("Apple"));
        for (int i = 0; i < bananasThatWerentImpactedByDiscount; i++) leftovers.add(getPricePence("Banana"));

        leftovers.sort(Collections.reverseOrder());

        int freeTotal = 0;
        for (int i = 1; i < leftovers.size(); i += 2) {
            freeTotal += leftovers.get(i);
        }


        total += appleCountWithDiscount * getPricePence("Apple");
        total += orangeCountWithDiscount * getPricePence("Orange");
        total += bananaCountWithDiscount * getPricePence("Banana");


        return total - freeTotal;
    }



    public double convertPenceToPounds(int pence){
        return pence / 100.0;
    }

    public String convertPenceToPoundsString(int pence){
        return String.format("£%.2f", convertPenceToPounds(pence));
    }

    public String priceFullBasket(List<String> itemList){
        return convertPenceToPoundsString(getTotalPricePence(itemList));
    }

    public int FruitCount(List<String> itemList, String fruit){
        return Math.toIntExact(itemList.stream().filter(item ->
                item.equals(fruit)).count());
    }

    public int FruitPostDiscount(List<String> itemList, String fruit){
        Fruit fruitType = items.get(fruit);
        int fruitCount = FruitCount(itemList, fruit);
        int discountedFruit = fruitCount / fruitType.getOfferFactor();
        return fruitCount - discountedFruit;
    }


}

package com.goldpiecessoftware;

import java.util.List;
import java.util.Map;

public class Checkout {

    private final Map<String, Integer> items = Map.of(
            "Apple", 60,
            "Orange", 25
    );

    public int getPricePence(String item){
        return items.get(item);
    }

    public int getTotalPricePence(List<String> itemList){
        int total = 0;
        int appleCountWithDiscount = ApplesPostDiscount(itemList);
        int orangeCountWithDiscount = OrangesPostDiscount(itemList);
        total += appleCountWithDiscount * getPricePence("Apple");
        total += orangeCountWithDiscount * getPricePence("Orange");
        return total;
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

    public int ApplesPostDiscount(List<String> itemList){
        int appleCount = Math.toIntExact(itemList.stream().filter(item -> item.equals("Apple")).count());
        int discountedApples = appleCount / 2;
        return appleCount - discountedApples;
    }

    public int OrangesPostDiscount(List<String> itemList){
        int orangeCount = Math.toIntExact(itemList.stream().filter(item -> item.equals("Orange")).count());
        int discountedOranges = orangeCount / 3;
        return orangeCount - discountedOranges;
    }


}

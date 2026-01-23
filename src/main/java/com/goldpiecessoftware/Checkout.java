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
        for(String item : itemList){
            total += getPricePence(item);
        }
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
}

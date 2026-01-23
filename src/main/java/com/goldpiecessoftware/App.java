package com.goldpiecessoftware;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      Checkout checkout = new Checkout();
        List<String> basket = List.of("Apple", "Orange", "Apple", "Orange", "Apple");
      System.out.println(checkout.priceFullBasket(basket));
    }
}

package com.goldpiecessoftware;

import junit.framework.TestCase;

import java.util.List;

public class CheckoutTest extends TestCase {

    public void testCheckout() {
        assertTrue(true);
    }

    public void testApplePricing(){
        Checkout checkout = new Checkout();
        assertEquals(60, checkout.getPricePence("Apple"));
    }

    public void testOrangePricing(){
        Checkout checkout = new Checkout();
        assertEquals(25, checkout.getPricePence("Orange"));
    }

    public void testBananaPricing(){
        Checkout checkout = new Checkout();
        assertEquals(20, checkout.getPricePence("Banana"));
    }

    public void testTotalPricing(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Apple", "Orange");
        assertEquals(85, checkout.getTotalPricePence(items));
    }

    public void testPenceToPoundsConversion(){
        Checkout checkout = new Checkout();
        assertEquals(1.00, checkout.convertPenceToPounds(100));
    }

    public void testPenceToPoundsConversionBelowOnePound(){
        Checkout checkout = new Checkout();
        assertEquals(0.85, checkout.convertPenceToPounds(85));
    }

    public void testPenceToPoundsStringConversion(){
        Checkout checkout = new Checkout();
        assertEquals("£1.00", checkout.convertPenceToPoundsString(100));
    }

    public void testPenceToPoundsStringConversionBelowOnePound(){
        Checkout checkout = new Checkout();
        assertEquals("£0.85", checkout.convertPenceToPoundsString(85));
    }

    public void testPriceBasedOnItemList(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Apple", "Orange");
        assertEquals("£0.85", checkout.priceFullBasket(items));
    }

    public void testBOGOFAppleDiscountViable(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Apple", "Apple", "Apple", "Orange");
        assertEquals(2, checkout.FruitPostDiscount(items, "Apple"));
    }

    public void testBOGOFAppleDiscountUnViable(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Apple", "Orange");
        assertEquals(1, checkout.FruitPostDiscount(items, "Apple"));
    }

    public void testBOGOFBananaDiscountViable(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Banana", "Banana");
        assertEquals(1, checkout.FruitPostDiscount(items, "Banana"));
    }

    public void testThreeForTwoOrangeDiscountViable(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Orange", "Orange", "Orange", "Orange", "Apple");
        assertEquals(3, checkout.FruitPostDiscount(items, "Orange"));
    }

    public void testThreeForTwoOrangeDiscountUnViable(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Orange", "Orange", "Apple");
        assertEquals(2, checkout.FruitPostDiscount(items, "Orange"));
    }

    public void testPriceBasedOnItemListWithDiscount(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Apple", "Apple", "Orange", "Orange", "Orange", "Banana");
        assertEquals("£1.30", checkout.priceFullBasket(items));
    }

    public void testAppleBananDiscount(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Apple", "Banana");
        assertEquals(60, checkout.getTotalPricePence(items));
    }

    public void testAppleBananDiscountContinued(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Apple", "Banana", "Banana", "Banana");
        assertEquals(80, checkout.getTotalPricePence(items));
    }

}
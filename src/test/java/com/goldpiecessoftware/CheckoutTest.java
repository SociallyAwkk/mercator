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
        assertEquals(2, checkout.ApplesPostDiscount(items));
    }

    public void testBOGOFAppleDiscountUnViable(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Apple", "Orange");
        assertEquals(1, checkout.ApplesPostDiscount(items));
    }

    public void testThreeForTwoOrangeDiscountViable(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Orange", "Orange", "Orange", "Orange", "Apple");
        assertEquals(3, checkout.OrangesPostDiscount(items));
    }

    public void testThreeForTwoOrangeDiscountUnViable(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Orange", "Orange", "Apple");
        assertEquals(2, checkout.OrangesPostDiscount(items));
    }

    public void testPriceBasedOnItemListWithDiscount(){
        Checkout checkout = new Checkout();
        List<String> items = List.of("Apple", "Apple", "Orange", "Orange", "Orange");
        assertEquals("£1.10", checkout.priceFullBasket(items));
    }



}
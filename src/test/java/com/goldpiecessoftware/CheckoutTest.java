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


}
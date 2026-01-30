package com.goldpiecessoftware;



public class Fruit {
    private String name;
    private int priceInPence;
    private int offerFactor;

    public Fruit(String name, int offerFactor, int priceInPence) {
        this.name = name;
        this.offerFactor = offerFactor;
        this.priceInPence = priceInPence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOfferFactor() {
        return offerFactor;
    }

    public void setOfferFactor(int offerFactor) {
        this.offerFactor = offerFactor;
    }

    public int getPriceInPence() {
        return priceInPence;
    }

    public void setPriceInPence(int priceInPence) {
        this.priceInPence = priceInPence;
    }
}

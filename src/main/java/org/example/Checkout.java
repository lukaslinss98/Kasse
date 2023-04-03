package org.example;

import java.util.*;

public class Checkout {

    private int checkoutSum = 0;
    //private List<String> products = new ArrayList<>();
    private Map<String, Integer> prod = new HashMap<>();
    public Checkout(){
    }

    /**
     Adds a product to the list of scanned products and updates the checkout sum based on the product.
     @param product the product to be scanned, must be a single character string representing a valid product
     @throws IllegalArgumentException if the input string is longer than 1 character or if the product is unknown
     */
    public void scan(String product) throws IllegalArgumentException {

        if(product.length() != 1)
            throw new IllegalArgumentException("The input String is too long");

        product = product.toUpperCase();

        switch (product){
            case "A" -> {
                this.addToCheckout("A");
                this.checkoutSum += this.prod.get("A") % 3 == 0 ? 35: 50;
            }

            case "B" -> {
                this.addToCheckout("B");
                this.checkoutSum += this.prod.get("B") % 2 == 0 ? 15 : 30;  //Collections.frequency(products, "B") % 2 == 0 ? 15: 30;
            }

            case "C" -> {
                this.addToCheckout("C");
                this.checkoutSum += 15;
            }

            case "D" -> {
                this.addToCheckout("D");
                this.checkoutSum += 20;
            }

            case "E" -> {
                this.addToCheckout("E");
                this.checkoutSum += this.prod.get("E") % 4 == 0 ? 5 : 25;
            }

            default ->  throw new IllegalArgumentException("Unknown Product");

        }
    }

    public int getTotal(){
        System.out.print("Checkout Products: ");
        System.out.println(prod.toString());
        return this.checkoutSum;
    }

    private void addToCheckout(String product){
        if(this.prod.containsKey(product))
            prod.put(product, prod.get(product) + 1);
        else
            prod.put(product, 1);
    }
}


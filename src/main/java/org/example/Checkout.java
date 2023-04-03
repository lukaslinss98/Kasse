package org.example;

import java.util.*;

public class Checkout {

    private static int id = 0;
    private int checkoutSum = 0;
    //private List<String> products = new ArrayList<>();
    private Map<Product, Integer> prod = new HashMap<>();
    public Checkout(){
        id++;
    }

    /**
     Adds a product to the list of scanned products and updates the checkout sum based on the product.
     @param product the product to be scanned, must be a single character string representing a valid product
     @throws IllegalArgumentException if the input string is longer than 1 character or if the product is unknown
     */
    public void scan(Product product) throws IllegalArgumentException {
        this.addToCheckout(product);
        checkoutSum += this.addProductPrice(product);
    }

    public int getTotal(){
        System.out.print("Checkout Products: ");
        System.out.println(prod.toString());
        return this.checkoutSum;
    }

    private void addToCheckout(Product product){
        if(this.prod.containsKey(product))
            prod.put(product, prod.get(product) + 1);
        else
            prod.put(product, 1);
    }

    private int addProductPrice(Product product) {
        int productPrice;
        if(Objects.isNull(product.getDiscount()))
            return product.getPrice();


        int discountPrice = product.getDiscount().getDiscountPrice();
        int price = discountPrice - (product.getDiscount().getQuantity() - 1) * product.getPrice();


        return prod.get(product) % product.getDiscount().getQuantity() == 0 ? price : product.getPrice();
    }
}


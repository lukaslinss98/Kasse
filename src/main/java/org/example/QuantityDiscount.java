package org.example;

public class QuantityDiscount {
    private int quantity;
    private int discountPrice;

    public QuantityDiscount(int quantity, int discountPrice) {
        this.quantity = quantity;
        this.discountPrice = discountPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}

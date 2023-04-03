package org.example;

public class Product {
    private String name;
    private int price;
    private QuantityDiscount discount;


    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public Product(String name, int price, QuantityDiscount discount ){
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public QuantityDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(QuantityDiscount discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

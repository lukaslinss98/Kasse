package org.example;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest {
    @Test
    void scanProductA(){
        Checkout co = new Checkout();
        try {
            co.scan("A");
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(50, co.getTotal());
    }
    @Test
    void scanProductB(){
        Checkout co = new Checkout();
        try {
            co.scan("B");
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(30, co.getTotal());
    }
    @Test
    void scanProductC(){
        Checkout co = new Checkout();
        try {
            co.scan("C");
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(15, co.getTotal());
    }
    @Test
    void scanProductD(){
        Checkout co = new Checkout();
        try {
            co.scan("D");
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(20, co.getTotal());
    }
    @Test
    void scanProductE(){
        Checkout co = new Checkout();
        try {
            co.scan("E");
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(25, co.getTotal());
    }
    @Test
    void scanAllProductsOnce(){
        Checkout co = new Checkout();
        try {
            co.scan("A");
            co.scan("B");
            co.scan("C");
            co.scan("D");
            co.scan("E");
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(140, co.getTotal());
    }
    @Test
    void scanProductASingleDiscount(){
        Checkout co = new Checkout();
        try{
            IntStream.rangeClosed(1, 3).forEach(
                    i -> co.scan("A")
            );
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(135, co.getTotal());
    }
    @Test
    void scanProductADoubleDiscount(){
        Checkout co = new Checkout();
        try{
            IntStream.rangeClosed(1, 6).forEach(
                    i -> co.scan("A")
            );
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(270, co.getTotal());
    }
    /*
    * Three products with discount + one regular priced product
    */
    @Test
    void scanProductAMixedDiscount(){
        Checkout co = new Checkout();
        try{
            IntStream.rangeClosed(1, 4).forEach(
                    i -> co.scan("A")
            );
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(185, co.getTotal());
    }
    @Test
    void scanProductBSingleDiscount(){
        Checkout co = new Checkout();
        try{
            IntStream.rangeClosed(1, 2).forEach(
                    i -> co.scan("B")
            );
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(co.getTotal());
        assertEquals(45, co.getTotal());
    }
    @Test
    void scanProductBDoubleDiscount(){
        Checkout co = new Checkout();
        try{
            IntStream.rangeClosed(1, 4).forEach(
                    i -> co.scan("B")
            );
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(co.getTotal());
        assertEquals(90, co.getTotal());
    }
    @Test
    void scanProductBMixedDiscount(){
        Checkout co = new Checkout();
        try{
            IntStream.rangeClosed(1,3).forEach(
                    i -> co.scan("B")
            );
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(75, co.getTotal());
    }
    @Test
    void scanProductESingleDiscount(){
        Checkout co = new Checkout();
        try{
            IntStream.rangeClosed(1,4).forEach(
                    i -> co.scan("E")
            );
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(80, co.getTotal());
    }
    @Test
    void scanProductEDoubleDiscount(){
        Checkout co = new Checkout();
        try{
            IntStream.rangeClosed(1,8).forEach(
                    i -> co.scan("E")
            );

        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(160, co.getTotal());
    }
    @Test
    void scanProductEMixedDiscount(){
        Checkout co = new Checkout();
        try{
            IntStream.rangeClosed(1,5).forEach(
                    i -> co.scan("E")
            );

        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(105, co.getTotal());
    }

    @Test
    void scanLowerCaseProducts(){
        Checkout co = new Checkout();
        try {
            co.scan("a");
            co.scan("b");
            co.scan("c");
            co.scan("d");
            co.scan("e");
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        assertEquals(140, co.getTotal());
    }

    @Test
    void unknownProductException(){
        Checkout co = new Checkout();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> co.scan("F"));
        assertEquals("Unknown Product", exception.getMessage());
    }
}
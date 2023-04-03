package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        makePayment();
    }

    public static void makePayment(Checkout... co){
        Checkout checkout = co.length == 0 ? new Checkout(): co[0];
        Scanner s = new Scanner(System.in);
        boolean inProgress = true;

        try{
            while(inProgress) {
                System.out.println("Choose from product to checkout");
                System.out.println("-------------------------------");
                System.out.println("A - Product A");
                System.out.println("B - Product B");
                System.out.println("C - Product C");
                System.out.println("D - Product D");
                System.out.println("E - Product E");
                System.out.println("Press ENTER to complete the checkout");

                String product = s.nextLine();
                if (product.equals("")) {
                    inProgress = false;
                    continue;
                }
                checkout.scan(product);
            }
            s.close();
            System.out.println("TOTAL Checkout amount: " + checkout.getTotal());
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            makePayment(checkout);
        }
    }
}
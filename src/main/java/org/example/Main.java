package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product a = new Product("a", 50);
        Product b = new Product("b", 20);

        a.setDiscount(new QuantityDiscount(3, 135));
        b.setDiscount(new QuantityDiscount(2, 35));

        Checkout co = new Checkout();
        //co.scan(a);
        //co.scan(a);
        //co.scan(a);
        co.scan(b);
        co.scan(b);



        System.out.println(co.getTotal());

    }

    public static void makePayment(Checkout... co){
     /*
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

      */
    }
}
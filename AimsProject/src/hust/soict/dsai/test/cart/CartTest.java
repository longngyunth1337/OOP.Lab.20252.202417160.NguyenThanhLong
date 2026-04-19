package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

       
        DigitalVideoDisc standard = new DigitalVideoDisc("Pragmata: Standard Edition", "Action-Adventure", "Capcom", 120, 59.99f);
        DigitalVideoDisc deluxe = new DigitalVideoDisc("Pragmata: System Auditor Deluxe", "Sci-Fi", "Capcom", 150, 85.50f);
        DigitalVideoDisc collectors = new DigitalVideoDisc("Pragmata: Lunar Collector's Box", "Survival", "Capcom", 200, 149.99f);

      
        cart.addDigitalVideoDisc(standard);

     
        cart.addDigitalVideoDisc(deluxe, collectors);
        DigitalVideoDisc[] lunarBundle = {
            new DigitalVideoDisc("Pragmata: Diana's Origin OST", "Music", 19.99f),
            new DigitalVideoDisc("Pragmata: Art of the Moon", "Digital Artbook", 25.00f)
        };
        cart.addDigitalVideoDisc(lunarBundle);

        System.out.println("--- Test Cart Summary ---");
        System.out.println("Total Cost for Pragmata Collection: " + cart.totalCost() + " $");
    }
}
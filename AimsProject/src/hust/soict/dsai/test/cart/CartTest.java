package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc hugh = new DigitalVideoDisc("Pragmata: Hugh Williams Edition", "Action", "Capcom", 120, 59.99f);
        DigitalVideoDisc diana = new DigitalVideoDisc("Pragmata: Diana Prototype", "Sci-Fi", "Capcom", 150, 65.50f);
        DigitalVideoDisc lunar = new DigitalVideoDisc("Pragmata: Lunar Crisis", "Survival", "Capcom", 180, 89.90f);

        cart.addDigitalVideoDisc(hugh);
        cart.addDigitalVideoDisc(diana, lunar);

        DigitalVideoDisc[] extraItems = {
            new DigitalVideoDisc("Pragmata OST", "Music", 19.99f),
            new DigitalVideoDisc("Pragmata Artbook", "Digital", 25.00f)
        };
        cart.addDigitalVideoDisc(extraItems);

        cart.print();

        cart.searchByTitle("Diana");
        cart.searchByTitle("Cyberpunk");
    }
}
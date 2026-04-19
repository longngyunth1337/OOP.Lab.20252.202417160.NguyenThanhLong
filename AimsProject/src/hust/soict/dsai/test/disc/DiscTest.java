package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class DigitalVideoDiscTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Pragmata: Hugh's Mission", "Action", "Capcom", 120, 59.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Pragmata: Diana's Awakening", "Sci-Fi", "Capcom", 145, 65.00f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Pragmata: Lunar Crisis", "Survival", "Capcom", 180, 89.90f);

        System.out.println("--- Testing Pragmata DVD Data ---");
        System.out.println("Item 1: " + dvd1.getTitle() + " | Category: " + dvd1.getCategory() + " | Cost: " + dvd1.getCost());
        System.out.println("Item 2: " + dvd2.getTitle() + " | Director: " + dvd2.getDirector() + " | Length: " + dvd2.getLength());
        System.out.println("Item 3: " + dvd3.getTitle() + " | Cost: " + dvd3.getCost());


        if (dvd1.getTitle().equals("Pragmata: Hugh's Mission")) {
            System.out.println("\nVerification Success: DVD 1 matches Hugh's Auditor profile.");
        }
    }
}
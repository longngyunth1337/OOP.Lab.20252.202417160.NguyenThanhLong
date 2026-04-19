package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;


    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }


    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                addDigitalVideoDisc(disc);
            } else {
                System.out.println("The cart is almost full. Stop adding.");
                break;
            }
        }
    }


    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        } else {
            System.out.println("The cart is full, cannot add both discs.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("The disc was not found.");
            return;
        }

        for (int i = index; i < qtyOrdered - 1; i++) {
            itemsOrdered[i] = itemsOrdered[i + 1];
        }
        itemsOrdered[qtyOrdered - 1] = null;
        qtyOrdered--;
        System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
    }

    public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
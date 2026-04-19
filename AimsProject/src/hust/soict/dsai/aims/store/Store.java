package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int CAPACITY = 100;
    private DigitalVideoDisc[] dvdStock = new DigitalVideoDisc[CAPACITY];
    private int currentQty = 0;

    public void addDVD(DigitalVideoDisc disc) {
        if (currentQty >= CAPACITY) {
            System.out.println("[Store] Warehouse is full. Cannot add: " + disc.getTitle());
            return;
        }
        
        dvdStock[currentQty] = disc;
        currentQty++;
        System.out.println("[Store] Succesfully added: " + disc.getTitle());
    }

    public void removeDVD(DigitalVideoDisc disc) {
        int index = findDVDIndex(disc);
        
        if (index == -1) {
            System.out.println("[Store] Error: Disc '" + disc.getTitle() + "' not found.");
            return;
        }

        for (int i = index; i < currentQty - 1; i++) {
            dvdStock[i] = dvdStock[i + 1];
        }
        
        dvdStock[currentQty - 1] = null;
        currentQty--;
        System.out.println("[Store] Succesfully removed: " + disc.getTitle());
    }

   
    private int findDVDIndex(DigitalVideoDisc disc) {
        for (int i = 0; i < currentQty; i++) {
            if (dvdStock[i] != null && dvdStock[i].equals(disc)) {
                return i;
            }
        }
        return -1;
    }

    public void showInventory() {
        System.out.println("--- Current Store Inventory ---");
        for (int i = 0; i < currentQty; i++) {
            System.out.println((i + 1) + ". " + dvdStock[i].getTitle());
        }
        System.out.println("-------------------------------");
    }
}
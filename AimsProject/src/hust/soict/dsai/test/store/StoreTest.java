package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store moonBaseStore = new Store();

      
        DigitalVideoDisc item1 = new DigitalVideoDisc("Hugh Williams: The Auditor", "Character Bio", "Capcom", 45, 0.0f);
        DigitalVideoDisc item2 = new DigitalVideoDisc("Diana: Android Prototype", "Secret File", "Capcom", 60, 0.0f);
        DigitalVideoDisc item3 = new DigitalVideoDisc("Dead Filament Analysis", "Research", "Neil Higgins", 30, 15.0f);

     
        moonBaseStore.addDVD(item1);
        moonBaseStore.addDVD(item2);
        moonBaseStore.addDVD(item3); 
        moonBaseStore.showInventory();
        moonBaseStore.removeDVD(item2);
        System.out.println("After Diana's file was hacked (removed):");
        moonBaseStore.showInventory();
    }
}
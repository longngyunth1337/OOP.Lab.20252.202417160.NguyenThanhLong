package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("[Store] Media already exists: " + media.getTitle());
            return;
        }

        itemsInStore.add(media);
        System.out.println("[Store] Successfully added: " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            System.out.println("[Store] Media not found: " + media.getTitle());
            return;
        }

        itemsInStore.remove(media);
        System.out.println("[Store] Successfully removed: " + media.getTitle());
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)
                    || media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return media;
            }
        }

        return null;
    }

    public void showInventory() {
        System.out.println("***********************STORE***********************");

        if (itemsInStore.isEmpty()) {
            System.out.println("Store is empty.");
        }

        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i));
        }

        System.out.println("***************************************************");
    }

    public void addDVD(DigitalVideoDisc disc) {
        addMedia(disc);
    }

    public void removeDVD(DigitalVideoDisc disc) {
        removeMedia(disc);
    }
}
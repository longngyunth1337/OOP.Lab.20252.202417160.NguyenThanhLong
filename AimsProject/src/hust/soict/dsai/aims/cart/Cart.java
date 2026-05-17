package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public int getNumberOfItems() {
        return itemsOrdered.size();
    }

    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("The media already exists in cart: " + media.getTitle());
            return;
        }

        itemsOrdered.add(media);
        System.out.println("The media \"" + media.getTitle() + "\" has been added.");
    }

    public void removeMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            System.out.println("The media was not found.");
            return;
        }

        itemsOrdered.remove(media);
        System.out.println("The media \"" + media.getTitle() + "\" has been removed.");
    }

    public float totalCost() {
        float total = 0.0f;

        for (Media media : itemsOrdered) {
            total += media.getCost();
        }

        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        if (itemsOrdered.isEmpty()) {
            System.out.println("Cart is empty.");
        }

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i));
        }

        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media);
                return media;
            }
        }

        System.out.println("No match found for id: " + id);
        return null;
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)
                    || media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found: " + media);
                return media;
            }
        }

        System.out.println("No match found for title: " + title);
        return null;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title then cost.");
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost then title.");
    }

    public void clear() {
        itemsOrdered.clear();
    }

    public void playMedia(String title) {
        Media media = searchByTitle(title);

        if (media == null) {
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        addMedia(disc);
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            addMedia(disc);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addMedia(dvd1);
        addMedia(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        removeMedia(disc);
    }
}
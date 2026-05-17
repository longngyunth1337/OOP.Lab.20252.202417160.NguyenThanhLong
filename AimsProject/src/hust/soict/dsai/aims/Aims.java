package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class Aims {
    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        initSampleStore();

        int choice;

        do {
            showMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    System.out.println("Update store will be implemented next.");
                    break;
                case 3:
                    cart.print();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void initSampleStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                1,
                "Sekiro: Shadows Die Twice - Immortal Severance",
                "Game Cinematic",
                19.95f,
                87,
                "FromSoftware"
        );

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                2,
                "Elden Ring: The Shattering",
                "Game Cinematic",
                24.95f,
                120,
                "FromSoftware"
        );

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                3,
                "Black Myth: Wukong - Journey Begins",
                "Game Cinematic",
                22.95f,
                100,
                "Game Science"
        );

        Book book1 = new Book(
                4,
                "Sekiro: Shadows Die Twice - Official Artworks",
                "Game Artbook",
                30.0f
        );
        book1.addAuthor("FromSoftware");
        book1.setContent("Sekiro Shadows Die Twice official artworks character design environment design combat concept art");

        Book book2 = new Book(
                5,
                "Elden Ring: Official Art Book",
                "Game Artbook",
                45.0f
        );
        book2.addAuthor("FromSoftware");
        book2.setContent("Elden Ring official art book lands between demigods weapons armor enemies bosses concept art");

        Book book3 = new Book(
                6,
                "Black Myth: Wukong - Journey to the West Art Collection",
                "Game Artbook",
                40.0f
        );
        book3.addAuthor("Game Science");
        book3.setContent("Black Myth Wukong journey to the west mythology character design boss design environment art");

        Book book4 = new Book(
                7,
                "Pragmata: Science Fiction World Guide",
                "Game Guide",
                35.0f
        );
        book4.addAuthor("Capcom");
        book4.setContent("Pragmata science fiction world guide lunar setting characters technology story concept");

        CompactDisc cd1 = new CompactDisc(
                8,
                "Elden Ring Original Soundtrack",
                "Game Music",
                15.5f,
                "FromSoftware",
                "Yuka Kitamura"
        );
        cd1.addTrack(new Track("The Final Battle", 354));
        cd1.addTrack(new Track("Limgrave", 210));
        cd1.addTrack(new Track("Godskin Apostles", 245));

        CompactDisc cd2 = new CompactDisc(
                9,
                "Black Myth: Wukong Original Soundtrack",
                "Game Music",
                16.5f,
                "Game Science",
                "Game Science Audio Team"
        );
        cd2.addTrack(new Track("Destined One", 230));
        cd2.addTrack(new Track("Journey to the West", 260));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);
        store.addMedia(cd1);
        store.addMedia(cd2);
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    private static void viewStore() {
        int choice;

        do {
            store.showInventory();
            storeMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaFromStoreToCart();
                    break;
                case 3:
                    playMediaFromStore();
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        System.out.println(media);

        int choice;

        do {
            mediaDetailsMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Current cart size: " + cart.getNumberOfItems());
                    break;
                case 2:
                    playMedia(media);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void addMediaFromStoreToCart() {
        System.out.print("Enter media title to add to cart: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        cart.addMedia(media);
        System.out.println("Current cart size: " + cart.getNumberOfItems());
    }

    private static void playMediaFromStore() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        playMedia(media);
    }

    private static void playMedia(Media media) {
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter an integer: ");
            }
        }
    }
}
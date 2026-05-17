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
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
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
                    seeCurrentCart();
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
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void seeCurrentCart() {
        int choice;

        do {
            cart.print();
            cartMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    filterMediaInCart();
                    break;
                case 2:
                    sortMediaInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void filterMediaInCart() {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");

        int choice = readInt();

        if (choice == 1) {
            System.out.print("Enter id: ");
            int id = readInt();
            cart.searchById(id);
        } else if (choice == 2) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void sortMediaInCart() {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");

        int choice = readInt();

        if (choice == 1) {
            cart.sortByTitleCost();
            cart.print();
        } else if (choice == 2) {
            cart.sortByCostTitle();
            cart.print();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void removeMediaFromCart() {
        System.out.print("Enter title to remove: ");
        String title = scanner.nextLine();

        Media media = cart.searchByTitle(title);

        if (media == null) {
            return;
        }

        cart.removeMedia(media);
    }

    private static void playMediaFromCart() {
        System.out.print("Enter title to play: ");
        String title = scanner.nextLine();

        Media media = cart.searchByTitle(title);

        if (media == null) {
            return;
        }

        playMedia(media);
    }

    private static void placeOrder() {
        System.out.println("An order has been created.");
        cart.clear();
    }
    private static void addDVDToStore() {
        System.out.print("ID: ");
        int id = readInt();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Director: ");
        String director = scanner.nextLine();

        System.out.print("Length: ");
        int length = readInt();

        System.out.print("Cost: ");
        float cost = readFloat();

        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, length, director);
        store.addMedia(dvd);
    }
    private static void addBookToStore() {
        System.out.print("ID: ");
        int id = readInt();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Cost: ");
        float cost = readFloat();

        Book book = new Book(id, title, category, cost);

        System.out.print("Authors, separated by comma: ");
        String authorsInput = scanner.nextLine();

        String[] authors = authorsInput.split(",");
        for (String author : authors) {
            String trimmed = author.trim();
            if (!trimmed.isEmpty()) {
                book.addAuthor(trimmed);
            }
        }

        System.out.print("Content: ");
        String content = scanner.nextLine();
        book.setContent(content);

        store.addMedia(book);
    }
    private static void addCDToStore() {
        System.out.print("ID: ");
        int id = readInt();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Director: ");
        String director = scanner.nextLine();

        System.out.print("Artist: ");
        String artist = scanner.nextLine();

        System.out.print("Cost: ");
        float cost = readFloat();

        CompactDisc cd = new CompactDisc(id, title, category, cost, director, artist);

        System.out.print("Number of tracks: ");
        int numberOfTracks = readInt();

        for (int i = 0; i < numberOfTracks; i++) {
            System.out.print("Track title: ");
            String trackTitle = scanner.nextLine();

            System.out.print("Track length: ");
            int trackLength = readInt();

            cd.addTrack(new Track(trackTitle, trackLength));
        }

        store.addMedia(cd);
    }
    private static void removeMediaFromStore() {
        System.out.print("Enter title to remove: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        store.removeMedia(media);
    }
    private static void updateStore() {
        System.out.println("Update store:");
        System.out.println("--------------------------------");
        System.out.println("1. Add DVD");
        System.out.println("2. Add Book");
        System.out.println("3. Add CD");
        System.out.println("4. Remove media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int choice = readInt();

        switch (choice) {
            case 1:
                addDVDToStore();
                break;
            case 2:
                addBookToStore();
                break;
            case 3:
                addCDToStore();
                break;
            case 4:
                removeMediaFromStore();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice.");
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
    private static float readFloat() {
        while (true) {
            try {
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
    }
}
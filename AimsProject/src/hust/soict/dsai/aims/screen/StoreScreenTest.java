package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class StoreScreenTest {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

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

        Book book2 = new Book(
                5,
                "Elden Ring: Official Art Book",
                "Game Artbook",
                45.0f
        );

        Book book3 = new Book(
                6,
                "Black Myth: Wukong - Journey to the West Art Collection",
                "Game Artbook",
                40.0f
        );

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
        store.addMedia(cd1);
        store.addMedia(cd2);

        new StoreScreen(store, cart);
    }
}
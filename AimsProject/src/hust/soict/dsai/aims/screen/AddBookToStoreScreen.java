package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book To Store");
    }

    @Override
    protected void addMoreFields(JPanel center) {
        // Book only needs id, title, category and cost in this simple screen.
    }

    @Override
    protected void addItemToStore() {
        try {
            Book book = new Book(
                    readId(),
                    readTitle(),
                    readCategory(),
                    readCost()
            );

            store.addMedia(book);
            showSuccessMessage("Book", book.getTitle());

            dispose();
            new StoreScreen(store, cart);
        } catch (Exception exception) {
            showErrorMessage(exception);
        }
    }
}
package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD To Store");
    }

    @Override
    protected void addMoreFields(JPanel center) {
        tfDirector = new JTextField();
        tfLength = new JTextField();

        center.add(new JLabel("Director:"));
        center.add(tfDirector);

        center.add(new JLabel("Length:"));
        center.add(tfLength);
    }

    @Override
    protected void addItemToStore() {
        try {
            DigitalVideoDisc dvd = new DigitalVideoDisc(
                    readId(),
                    readTitle(),
                    readCategory(),
                    readCost(),
                    Integer.parseInt(tfLength.getText()),
                    tfDirector.getText()
            );

            store.addMedia(dvd);
            showSuccessMessage("DVD", dvd.getTitle());

            dispose();
            new StoreScreen(store, cart);
        } catch (Exception exception) {
            showErrorMessage(exception);
        }
    }
}
package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfArtist;
    private JTextField tfTrackTitle;
    private JTextField tfTrackLength;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD To Store");
    }

    @Override
    protected void addMoreFields(JPanel center) {
        tfDirector = new JTextField();
        tfArtist = new JTextField();
        tfTrackTitle = new JTextField();
        tfTrackLength = new JTextField();

        center.add(new JLabel("Director:"));
        center.add(tfDirector);

        center.add(new JLabel("Artist:"));
        center.add(tfArtist);

        center.add(new JLabel("Track title:"));
        center.add(tfTrackTitle);

        center.add(new JLabel("Track length:"));
        center.add(tfTrackLength);
    }

    @Override
    protected void addItemToStore() {
        try {
            CompactDisc cd = new CompactDisc(
                    readId(),
                    readTitle(),
                    readCategory(),
                    readCost(),
                    tfDirector.getText(),
                    tfArtist.getText()
            );

            if (!tfTrackTitle.getText().isBlank() && !tfTrackLength.getText().isBlank()) {
                Track track = new Track(
                        tfTrackTitle.getText(),
                        Integer.parseInt(tfTrackLength.getText())
                );
                cd.addTrack(track);
            }

            store.addMedia(cd);
            showSuccessMessage("CD", cd.getTitle());

            dispose();
            new StoreScreen(store, cart);
        } catch (Exception exception) {
            showErrorMessage(exception);
        }
    }
}
package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;
    private ObservableList<Media> mediaItems;
    private FilteredList<Media> filteredItems;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Label lblTotal;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        mediaItems = cart.getItemsOrdered();
        filteredItems = new FilteredList<>(mediaItems, media -> true);
        tblMedia.setItems(filteredItems);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        ToggleGroup filterGroup = new ToggleGroup();
        radioBtnFilterId.setToggleGroup(filterGroup);
        radioBtnFilterTitle.setToggleGroup(filterGroup);
        radioBtnFilterId.setSelected(true);

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia());
        radioBtnFilterId.selectedProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia());
        radioBtnFilterTitle.selectedProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia());

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    } else {
                        btnPlay.setVisible(false);
                        btnRemove.setVisible(false);
                    }
                }
        );

        mediaItems.addListener((ListChangeListener<Media>) change -> updateTotal());

        updateTotal();
    }

    private void showFilteredMedia() {
        String filterText = tfFilter.getText();

        if (filterText == null || filterText.isBlank()) {
            filteredItems.setPredicate(media -> true);
            return;
        }

        String lowerCaseFilter = filterText.toLowerCase();

        filteredItems.setPredicate(media -> {
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            }

            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle() != null
                        && media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }

            return true;
        });
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        if (media != null) {
            cart.removeMedia(media);
            updateTotal();

            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        if (media instanceof Playable) {
            try {
                ((Playable) media).play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Play media");
                alert.setHeaderText(null);
                alert.setContentText("Playing: " + media.getTitle());
                alert.showAndWait();
            } catch (PlayerException exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Player Exception");
                alert.setHeaderText("Cannot play this media");
                alert.setContentText(exception.getMessage());
                alert.showAndWait();

                exception.printStackTrace();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Place order");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();

        cart.clear();
        updateTotal();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
    }

    private void updateTotal() {
        lblTotal.setText(String.format("%.2f $", cart.totalCost()));
    }
}
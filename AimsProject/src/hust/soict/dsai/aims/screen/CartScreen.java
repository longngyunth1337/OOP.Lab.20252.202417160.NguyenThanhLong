package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();

        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();

        // Quan trọng: tránh JavaFX runtime bị tắt sau khi đóng cửa sổ Cart.
        Platform.setImplicitExit(false);

        this.setLayout(new BorderLayout());
        this.add(fxPanel, BorderLayout.CENTER);

        this.setTitle("Cart");
        this.setSize(new Dimension(1024, 768));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                        Objects.requireNonNull(getClass().getResource("cart.fxml"))
                );

                CartScreenController controller = new CartScreenController(this.cart);
                loader.setController(controller);

                Parent root = loader.load();
                Scene scene = new Scene(root);

                fxPanel.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();

                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(
                        this,
                        "Cannot load cart.fxml: " + e.getMessage(),
                        "Cart Screen Error",
                        JOptionPane.ERROR_MESSAGE
                ));
            }
        });
    }
}
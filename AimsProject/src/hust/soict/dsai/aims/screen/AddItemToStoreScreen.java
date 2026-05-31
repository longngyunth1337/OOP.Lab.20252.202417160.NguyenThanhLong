package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;

    protected JTextField tfId;
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store, Cart cart, String title) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(title), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.add(createSouth(), BorderLayout.SOUTH);

        setTitle(title);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createNorth(String screenTitle) {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        north.add(createMenuBarPanel());

        JLabel title = new JLabel(screenTitle);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 36));
        title.setForeground(Color.CYAN);
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        north.add(title);

        return north;
    }

    private JMenuBar createMenuBarPanel() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            dispose();
            new AddBookToStoreScreen(store, cart);
        });

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            dispose();
            new AddCompactDiscToStoreScreen(store, cart);
        });

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store, cart);
        });

        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);

        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(e -> {
            dispose();
            new StoreScreen(store, cart);
        });

        JMenuItem viewCartItem = new JMenuItem("View cart");
        viewCartItem.addActionListener(e -> new CartScreen(cart));

        menu.add(smUpdateStore);
        menu.add(viewStoreItem);
        menu.add(viewCartItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        tfId = new JTextField();
        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();

        center.add(new JLabel("ID:"));
        center.add(tfId);

        center.add(new JLabel("Title:"));
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        center.add(tfCategory);

        center.add(new JLabel("Cost:"));
        center.add(tfCost);

        addMoreFields(center);

        return center;
    }

    private JPanel createSouth() {
        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btnAdd = new JButton("Add to store");
        btnAdd.addActionListener(e -> addItemToStore());

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> dispose());

        south.add(btnAdd);
        south.add(btnCancel);

        return south;
    }

    protected abstract void addMoreFields(JPanel center);

    protected abstract void addItemToStore();

    protected int readId() {
        return Integer.parseInt(tfId.getText());
    }

    protected String readTitle() {
        return tfTitle.getText();
    }

    protected String readCategory() {
        return tfCategory.getText();
    }

    protected float readCost() {
        return Float.parseFloat(tfCost.getText());
    }

    protected void showSuccessMessage(String mediaType, String title) {
        JOptionPane.showMessageDialog(
                this,
                mediaType + " \"" + title + "\" has been added to store.",
                "Add item",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    protected void showErrorMessage(Exception exception) {
        JOptionPane.showMessageDialog(
                this,
                "Invalid input: " + exception.getMessage(),
                "Input error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
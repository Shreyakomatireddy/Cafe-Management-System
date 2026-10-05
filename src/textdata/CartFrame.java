package textdata;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CartFrame {

    JFrame frame = new JFrame();

    Color pinkBackground = new Color(255, 245, 248);
    Color pink = new Color(245, 160, 175);
    Color darkBrown = new Color(80, 55, 55);
    Color cardBackground = new Color(255, 240, 244);
    Color borderPink = new Color(235, 190, 200);

    ArrayList<String> cartItems;

    String customerName;
    String tableNumber;
    String mobileNumber;

    // ================= CONSTRUCTOR =================

    public CartFrame(
            ArrayList<String> cartItems,
            String customerName,
            String tableNumber,
            String mobileNumber) {

        this.cartItems = cartItems;
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.mobileNumber = mobileNumber;

        frame.setTitle("Brew & Bliss - Your Cart");

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(
                pinkBackground
        );

        // ================= HEADER =================

        JPanel headingPanel = new JPanel();

        headingPanel.setLayout(
                new BoxLayout(
                        headingPanel,
                        BoxLayout.Y_AXIS
                )
        );

        headingPanel.setBackground(
                pinkBackground
        );

        JLabel title =
                new JLabel("Brew & Bliss");

        title.setFont(
                new Font(
                        "Segoe Script",
                        Font.PLAIN,
                        34
                )
        );

        title.setForeground(pink);

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel coffeeHouse =
                new JLabel("COFFEE HOUSE");

        coffeeHouse.setFont(
                new Font(
                        "Maiandra GD",
                        Font.PLAIN,
                        15
                )
        );

        coffeeHouse.setForeground(
                darkBrown
        );

        coffeeHouse.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel cartTitle =
                new JLabel("Your Cart");

        cartTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        cartTitle.setForeground(
                darkBrown
        );

        cartTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        headingPanel.add(
                Box.createVerticalStrut(25)
        );

        headingPanel.add(title);

        headingPanel.add(
                Box.createVerticalStrut(3)
        );

        headingPanel.add(coffeeHouse);

        headingPanel.add(
                Box.createVerticalStrut(20)
        );

        headingPanel.add(cartTitle);

        headingPanel.add(
                Box.createVerticalStrut(15)
        );

        mainPanel.add(
                headingPanel,
                BorderLayout.NORTH
        );

        // ================= CART PANEL =================

        JPanel cartPanel =
                new JPanel();

        cartPanel.setLayout(
                new BoxLayout(
                        cartPanel,
                        BoxLayout.Y_AXIS
                )
        );

        cartPanel.setBackground(
                pinkBackground
        );

        cartPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        250,
                        10,
                        250
                )
        );

        double total = 0;

        for (String item : cartItems) {

            double price =
                    getItemPrice(item);

            total = total + price;

            JPanel itemPanel =
                    new JPanel(
                            new BorderLayout()
                    );

            itemPanel.setBackground(
                    cardBackground
            );

            itemPanel.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(
                                    borderPink
                            ),
                            BorderFactory.createEmptyBorder(
                                    12,
                                    20,
                                    12,
                                    20
                            )
                    )
            );

            itemPanel.setMaximumSize(
                    new Dimension(
                            Integer.MAX_VALUE,
                            55
                    )
            );

            JLabel itemLabel =
                    new JLabel(item);

            itemLabel.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            15
                    )
            );

            itemLabel.setForeground(
                    darkBrown
            );

            JLabel priceLabel =
                    new JLabel(
                            "₹" + price
                    );

            priceLabel.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            15
                    )
            );

            priceLabel.setForeground(
                    darkBrown
            );

            itemPanel.add(
                    itemLabel,
                    BorderLayout.WEST
            );

            itemPanel.add(
                    priceLabel,
                    BorderLayout.EAST
            );

            cartPanel.add(itemPanel);

            cartPanel.add(
                    Box.createVerticalStrut(8)
            );
        }

        // ================= FINAL TOTAL =================

        final double orderTotal = total;

        // ================= EMPTY CART =================

        if (cartItems.isEmpty()) {

            JLabel emptyLabel =
                    new JLabel(
                            "Your cart is empty."
                    );

            emptyLabel.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            18
                    )
            );

            emptyLabel.setForeground(
                    darkBrown
            );

            emptyLabel.setAlignmentX(
                    Component.CENTER_ALIGNMENT
            );

            cartPanel.add(
                    Box.createVerticalStrut(50)
            );

            cartPanel.add(emptyLabel);
        }

        JScrollPane scrollPane =
                new JScrollPane(cartPanel);

        scrollPane.setBorder(null);

        scrollPane.getViewport()
                .setBackground(
                        pinkBackground
                );

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // ================= BOTTOM =================

        JPanel bottomPanel =
                new JPanel();

        bottomPanel.setLayout(
                new BoxLayout(
                        bottomPanel,
                        BoxLayout.Y_AXIS
                )
        );

        bottomPanel.setBackground(
                pinkBackground
        );

        JLabel totalLabel =
                new JLabel(
                        "Total: ₹" + orderTotal
                );

        totalLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        totalLabel.setForeground(
                darkBrown
        );

        totalLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        bottomPanel.add(
                totalLabel
        );

        bottomPanel.add(
                Box.createVerticalStrut(15)
        );

        // ================= BUTTON PANEL =================

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                15,
                                10
                        )
                );

        buttonPanel.setBackground(
                pinkBackground
        );

        JButton placeOrderButton =
                new JButton("Place Order");

        JButton clearButton =
                new JButton("Clear Cart");

        JButton backButton =
                new JButton("Back to Menu");

        JButton homeButton =
                new JButton("Back to Home");

        styleButton(placeOrderButton);
        styleButton(clearButton);
        styleButton(backButton);
        styleButton(homeButton);

        buttonPanel.add(
                placeOrderButton
        );

        buttonPanel.add(
                clearButton
        );

        buttonPanel.add(
                backButton
        );

        buttonPanel.add(
                homeButton
        );

        bottomPanel.add(
                buttonPanel
        );

        bottomPanel.add(
                Box.createVerticalStrut(15)
        );

        mainPanel.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        // ================= PLACE ORDER =================

        placeOrderButton.addActionListener(e -> {

            if (cartItems.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Your cart is empty."
                );

                return;
            }

            // Create item list as one String

            StringBuilder items =
                    new StringBuilder();

            for (String item : cartItems) {

                if (items.length() > 0) {
                    items.append(", ");
                }

                items.append(item);
            }

            // ================= SAVE ORDER =================

            OrderData.addOrder(
                    customerName,
                    tableNumber,
                    mobileNumber,
                    items.toString(),
                    orderTotal
            );

            JOptionPane.showMessageDialog(
                    frame,
                    "Order placed successfully!"
            );

            // Clear cart after placing order

            cartItems.clear();

            // Keep Cart page open
            // Customer can click Back to Home

            placeOrderButton.setEnabled(false);
            clearButton.setEnabled(false);
        });

        // ================= CLEAR CART =================

        clearButton.addActionListener(e -> {

            if (cartItems.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Your cart is already empty."
                );

                return;
            }

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to clear the cart?",
                            "Clear Cart",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice ==
                    JOptionPane.YES_OPTION) {

                cartItems.clear();

                JOptionPane.showMessageDialog(
                        frame,
                        "Cart cleared."
                );

                frame.dispose();
            }
        });

        // ================= BACK TO MENU =================

        backButton.addActionListener(e -> {

            new Frame(
                    customerName,
                    tableNumber,
                    mobileNumber
            );

            frame.dispose();
        });

        // ================= BACK TO HOME =================

        homeButton.addActionListener(e -> {

            new RoleSelectionFrame();

            frame.dispose();
        });

        // ================= SHOW FRAME =================

        frame.add(mainPanel);

        frame.setVisible(true);
    }

    // ================= ITEM PRICE =================

    private double getItemPrice(String item) {

        for (MenuData.MenuItem menuItem :
                MenuData.items) {

            if (menuItem.name.equals(item)) {

                return menuItem.price;
            }
        }

        return 0;
    }

    // ================= BUTTON STYLE =================

    private void styleButton(JButton button) {

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        button.setForeground(
                darkBrown
        );

        button.setBackground(
                cardBackground
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createLineBorder(
                        borderPink
                )
        );

        button.setPreferredSize(
                new Dimension(
                        140,
                        38
                )
        );
    }
}
package textdata;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

public class Frame {

    JFrame frame = new JFrame();

    JLabel cafeName = new JLabel("Brew & Bliss");

    JLabel coffeeHouse = new JLabel("COFFEE HOUSE");

    JLabel tagline = new JLabel(
            "We love making coffee for a city that loves to drink it."
    );

    JLabel menuTitle = new JLabel("MENU");

    JLabel menuMessage = new JLabel(
            "Choose your favorites and add them to your cart."
    );

    JPanel headingPanel = new JPanel();

    JPanel menuPanel = new JPanel();

    JPanel cartButtonPanel = new JPanel();

    JButton cartButton = new JButton("Go to Cart");

    ArrayList<String> cart = new ArrayList<>();

    // Customer details

    String customerName;

    String tableNumber;

    String mobileNumber;

    // =================================================
    // COLORS
    // =================================================

    Color pinkBackground = new Color(255, 245, 248);

    Color softPink = new Color(245, 160, 175);

    Color lightText = new Color(190, 170, 175);

    Color darkText = new Color(90, 70, 70);

    // =================================================
    // CONSTRUCTOR
    // =================================================

    public Frame(
            String customerName,
            String tableNumber,
            String mobileNumber) {

        this.customerName = customerName;

        this.tableNumber = tableNumber;

        this.mobileNumber = mobileNumber;

        // =================================================
        // LOAD MENU FROM DATABASE
        // =================================================

        MenuData.loadItems();

        // =================================================
        // BACKGROUND PANEL
        // =================================================

        BackgroundPanel backgroundPanel =
                new BackgroundPanel();

        backgroundPanel.setLayout(
                new BorderLayout()
        );

        // =================================================
        // HEADING
        // =================================================

        headingPanel.setLayout(
                new BoxLayout(
                        headingPanel,
                        BoxLayout.Y_AXIS
                )
        );

        // IMPORTANT:
        // Transparent so background image is visible

        headingPanel.setOpaque(false);

        // =================================================
        // CAFE NAME
        // =================================================

        cafeName.setFont(
                new Font(
                        "Segoe Script",
                        Font.PLAIN,
                        30
                )
        );

        cafeName.setForeground(
                softPink
        );

        cafeName.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // =================================================
        // COFFEE HOUSE
        // =================================================

        coffeeHouse.setFont(
                new Font(
                        "Maiandra GD",
                        Font.PLAIN,
                        15
                )
        );

        coffeeHouse.setForeground(
                new Color(80, 55, 55)
        );

        coffeeHouse.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // =================================================
        // TAGLINE
        // =================================================

        tagline.setFont(
                new Font(
                        "Georgia",
                        Font.ITALIC,
                        12
                )
        );

        tagline.setForeground(
                lightText
        );

        tagline.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // =================================================
        // MENU TITLE
        // =================================================

        menuTitle.setFont(
                new Font(
                        "Georgia",
                        Font.BOLD,
                        27
                )
        );

        menuTitle.setForeground(
                darkText
        );

        menuTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // =================================================
        // MENU MESSAGE
        // =================================================

        menuMessage.setFont(
                new Font(
                        "Georgia",
                        Font.PLAIN,
                        12
                )
        );

        menuMessage.setForeground(
                lightText
        );

        menuMessage.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // =================================================
        // ADD HEADING
        // =================================================

        headingPanel.add(
                Box.createVerticalStrut(12)
        );

        headingPanel.add(cafeName);

        headingPanel.add(
                Box.createVerticalStrut(2)
        );

        headingPanel.add(coffeeHouse);

        headingPanel.add(
                Box.createVerticalStrut(3)
        );

        headingPanel.add(tagline);

        headingPanel.add(
                Box.createVerticalStrut(8)
        );

        headingPanel.add(menuTitle);

        headingPanel.add(
                Box.createVerticalStrut(2)
        );

        headingPanel.add(menuMessage);

        // =================================================
        // MENU PANEL
        // =================================================

        menuPanel.setLayout(
                new BoxLayout(
                        menuPanel,
                        BoxLayout.Y_AXIS
                )
        );

        // Transparent

        menuPanel.setOpaque(false);

        menuPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        5,
                        60,
                        5,
                        60
                )
        );

        // =================================================
        // CREATE CATEGORY PANELS
        // =================================================

        JPanel coffeePanel =
                createCategory("Coffee");

        JPanel dessertPanel =
                createCategory("Desserts");

        JPanel snackPanel =
                createCategory("Snacks");

        // =================================================
        // LOAD ITEMS FROM MYSQL
        // =================================================

        for (MenuData.MenuItem item : MenuData.items) {

            String price =
                    "₹" + item.price;

            if (item.category.equalsIgnoreCase("Coffee")) {

                addMenuItem(
                        coffeePanel,
                        item.name,
                        price
                );

            } else if (item.category.equalsIgnoreCase("Desserts")) {

                addMenuItem(
                        dessertPanel,
                        item.name,
                        price
                );

            } else if (item.category.equalsIgnoreCase("Snacks")) {

                addMenuItem(
                        snackPanel,
                        item.name,
                        price
                );
            }
        }

        // =================================================
        // ADD CATEGORIES
        // =================================================

        if (coffeePanel.getComponentCount() > 0) {

            menuPanel.add(coffeePanel);

            menuPanel.add(
                    Box.createVerticalStrut(8)
            );
        }

        if (dessertPanel.getComponentCount() > 0) {

            menuPanel.add(dessertPanel);

            menuPanel.add(
                    Box.createVerticalStrut(8)
            );
        }

        if (snackPanel.getComponentCount() > 0) {

            menuPanel.add(snackPanel);
        }

        // =================================================
        // IF NO MENU ITEMS FOUND
        // =================================================

        if (MenuData.items.isEmpty()) {

            JLabel noItems =
                    new JLabel(
                            "No menu items available."
                    );

            noItems.setFont(
                    new Font(
                            "Georgia",
                            Font.PLAIN,
                            15
                    )
            );

            noItems.setForeground(
                    darkText
            );

            noItems.setAlignmentX(
                    Component.CENTER_ALIGNMENT
            );

            menuPanel.add(noItems);
        }

        // =================================================
        // SCROLL PANE
        // =================================================

        JScrollPane scrollPane =
                new JScrollPane(menuPanel);

        // Make background visible

        scrollPane.setOpaque(false);

        scrollPane.getViewport().setOpaque(false);

        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar().setOpaque(false);

        // =================================================
        // CART BUTTON
        // =================================================

        cartButton.setFont(
                new Font(
                        "Georgia",
                        Font.PLAIN,
                        14
                )
        );

        cartButton.setFocusPainted(false);

        cartButton.setBackground(
                new Color(255, 225, 233)
        );

        cartButton.setForeground(
                darkText
        );

        cartButton.setBorder(
                BorderFactory.createLineBorder(
                        new Color(235, 190, 200),
                        1
                )
        );

        cartButton.setPreferredSize(
                new Dimension(
                        130,
                        35
                )
        );

        // Transparent

        cartButtonPanel.setOpaque(false);

        cartButtonPanel.add(cartButton);

        // =================================================
        // CART ACTION
        // =================================================

        cartButton.addActionListener(e -> {

            new CartFrame(
                    cart,
                    customerName,
                    tableNumber,
                    mobileNumber
            );

            frame.dispose();
        });

        // =================================================
        // ADD EVERYTHING TO BACKGROUND
        // =================================================

        backgroundPanel.add(
                headingPanel,
                BorderLayout.NORTH
        );

        backgroundPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        backgroundPanel.add(
                cartButtonPanel,
                BorderLayout.SOUTH
        );

        // =================================================
        // FRAME
        // =================================================

        frame.setContentPane(
                backgroundPanel
        );

        frame.setTitle(
                "Brew & Bliss"
        );

        frame.setExtendedState(
                JFrame.MAXIMIZED_BOTH
        );

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    // =================================================
    // ADD MENU ITEM
    // =================================================

    void addMenuItem(
            JPanel categoryPanel,
            String name,
            String price) {

        JLabel itemName =
                new JLabel(name);

        JLabel itemPrice =
                new JLabel(price);

        JButton addButton =
                new JButton("Add to Cart");

        JPanel itemPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                15,
                                6
                        )
                );

        // =================================================
        // ITEM NAME
        // =================================================

        itemName.setFont(
                new Font(
                        "Georgia",
                        Font.PLAIN,
                        15
                )
        );

        itemName.setForeground(
                darkText
        );

        // =================================================
        // ITEM PRICE
        // =================================================

        itemPrice.setFont(
                new Font(
                        "Georgia",
                        Font.PLAIN,
                        15
                )
        );

        itemPrice.setForeground(
                new Color(160, 130, 135)
        );

        // =================================================
        // ADD BUTTON
        // =================================================

        addButton.setFont(
                new Font(
                        "Georgia",
                        Font.PLAIN,
                        12
                )
        );

        addButton.setFocusPainted(false);

        addButton.setBackground(
                new Color(255, 225, 233)
        );

        addButton.setForeground(
                darkText
        );

        addButton.setBorder(
                BorderFactory.createLineBorder(
                        new Color(235, 190, 200),
                        1
                )
        );

        addButton.setPreferredSize(
                new Dimension(
                        105,
                        28
                )
        );

        // =================================================
        // ADD COMPONENTS
        // =================================================

        itemPanel.add(itemName);

        itemPanel.add(itemPrice);

        itemPanel.add(addButton);

        // Slightly transparent item background

        itemPanel.setOpaque(true);

        itemPanel.setBackground(
                new Color(
                        255,
                        245,
                        248,
                        220
                )
        );

        // =================================================
        // ADD TO CART
        // =================================================

        addButton.addActionListener(e -> {

            cart.add(name);

            JOptionPane.showMessageDialog(
                    frame,
                    name + " added to cart!"
            );
        });

        categoryPanel.add(itemPanel);
    }

    // =================================================
    // CREATE CATEGORY
    // =================================================

    JPanel createCategory(String title) {

        JPanel categoryPanel =
                new JPanel();

        categoryPanel.setLayout(
                new BoxLayout(
                        categoryPanel,
                        BoxLayout.Y_AXIS
                )
        );

        categoryPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        235,
                                        190,
                                        200
                                ),
                                1
                        ),
                        title.toUpperCase(),
                        0,
                        0,
                        new Font(
                                "Maiandra GD",
                                Font.PLAIN,
                                20
                        ),
                        new Color(
                                85,
                                60,
                                55
                        )
                )
        );

        // Slightly transparent

        categoryPanel.setOpaque(true);

        categoryPanel.setBackground(
                new Color(
                        255,
                        245,
                        248,
                        205
                )
        );

        categoryPanel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        return categoryPanel;
    }

    // =================================================
    // BACKGROUND IMAGE PANEL
    // =================================================

    class BackgroundPanel extends JPanel {

        private Image backgroundImage;

        public BackgroundPanel() {

            URL imageURL =
                    getClass().getResource(
                            "/cafe_background.png"
                    );

            if (imageURL != null) {

                backgroundImage =
                        new ImageIcon(
                                imageURL
                        ).getImage();

                System.out.println(
                        "Background image loaded successfully!"
                );

            } else {

                System.out.println(
                        "Background image NOT FOUND!"
                );
            }
        }

        @Override
        protected void paintComponent(
                Graphics g) {

            super.paintComponent(g);

            if (backgroundImage != null) {

                Graphics2D g2 =
                        (Graphics2D) g.create();

                g2.setRenderingHint(
                        RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR
                );

                g2.drawImage(
                        backgroundImage,
                        0,
                        0,
                        getWidth(),
                        getHeight(),
                        this
                );

                g2.dispose();

            } else {

                g.setColor(
                        pinkBackground
                );

                g.fillRect(
                        0,
                        0,
                        getWidth(),
                        getHeight()
                );
            }
        }
    }
}
package textdata;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.net.URL;

public class RoleSelectionFrame {

    JFrame frame = new JFrame();

    JLabel cafeName = new JLabel("Brew & Bliss");
    JLabel coffeeHouse = new JLabel("COFFEE HOUSE");
    JLabel welcomeLabel = new JLabel("Welcome to Brew & Bliss!");
    JLabel tagline = new JLabel("Your perfect coffee moment starts here.");
    JLabel chooseLabel = new JLabel("How would you like to continue?");
    JLabel footer = new JLabel("Coffee • Desserts • Good Moments");

    JButton customerButton = new JButton("Enter as Customer");
    JButton staffButton = new JButton("Staff Login");

    JPanel headingPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel cardsPanel = new JPanel();


    // ==========================================
    // CONSTRUCTOR
    // ==========================================

    RoleSelectionFrame() {

        // ==========================================
        // COLORS
        // ==========================================

        Color darkBrown =
                new Color(80, 55, 55);

        Color softBrown =
                new Color(175, 145, 150);

        Color pink =
                new Color(245, 160, 175);

        Color cardBackground =
                new Color(255, 240, 244);

        Color borderPink =
                new Color(235, 190, 200);


        // ==========================================
        // HEADING PANEL
        // ==========================================

        headingPanel.setLayout(
                new BoxLayout(
                        headingPanel,
                        BoxLayout.Y_AXIS
                )
        );

        headingPanel.setOpaque(false);


        // ==========================================
        // CAFE NAME
        // ==========================================

        cafeName.setFont(
                new Font(
                        "Segoe Script",
                        Font.PLAIN,
                        42
                )
        );

        cafeName.setForeground(pink);

        cafeName.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // ==========================================
        // COFFEE HOUSE
        // ==========================================

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


        // ==========================================
        // WELCOME
        // ==========================================

        welcomeLabel.setFont(
                new Font(
                        "Georgia",
                        Font.PLAIN,
                        22
                )
        );

        welcomeLabel.setForeground(
                darkBrown
        );

        welcomeLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // ==========================================
        // TAGLINE
        // ==========================================

        tagline.setFont(
                new Font(
                        "Georgia",
                        Font.ITALIC,
                        15
                )
        );

        tagline.setForeground(
                softBrown
        );

        tagline.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // ==========================================
        // ADD HEADING COMPONENTS
        // ==========================================

        headingPanel.add(
                Box.createVerticalStrut(35)
        );

        headingPanel.add(cafeName);

        headingPanel.add(
                Box.createVerticalStrut(2)
        );

        headingPanel.add(coffeeHouse);

        headingPanel.add(
                Box.createVerticalStrut(22)
        );

        headingPanel.add(welcomeLabel);

        headingPanel.add(
                Box.createVerticalStrut(7)
        );

        headingPanel.add(tagline);


        // ==========================================
        // CENTER PANEL
        // ==========================================

        centerPanel.setLayout(
                new BoxLayout(
                        centerPanel,
                        BoxLayout.Y_AXIS
                )
        );

        centerPanel.setOpaque(false);


        // ==========================================
        // CHOOSE LABEL
        // ==========================================

        chooseLabel.setFont(
                new Font(
                        "Georgia",
                        Font.PLAIN,
                        16
                )
        );

        chooseLabel.setForeground(
                darkBrown
        );

        chooseLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        centerPanel.add(
                Box.createVerticalStrut(30)
        );

        centerPanel.add(
                chooseLabel
        );

        centerPanel.add(
                Box.createVerticalStrut(18)
        );


        // ==========================================
        // CARDS PANEL
        // ==========================================

        cardsPanel.setLayout(
                new GridLayout(
                        1,
                        2,
                        30,
                        0
                )
        );

        cardsPanel.setOpaque(false);

        cardsPanel.setBorder(
                new EmptyBorder(
                        5,
                        80,
                        5,
                        80
                )
        );


        // ==========================================
        // CUSTOMER CARD
        // ==========================================

        JPanel customerCard =
                createCard(
                        "CUSTOMER",
                        "Browse our menu",
                        "Place your order",
                        customerButton,
                        cardBackground,
                        borderPink,
                        darkBrown
                );


        // ==========================================
        // STAFF CARD
        // ==========================================

        JPanel staffCard =
                createCard(
                        "STAFF",
                        "Manage the menu",
                        "Manage items",
                        staffButton,
                        cardBackground,
                        borderPink,
                        darkBrown
                );


        cardsPanel.add(customerCard);
        cardsPanel.add(staffCard);

        centerPanel.add(
                cardsPanel
        );


        // ==========================================
        // FOOTER
        // ==========================================

        footer.setFont(
                new Font(
                        "Maiandra GD",
                        Font.PLAIN,
                        13
                )
        );

        footer.setForeground(
                softBrown
        );

        footer.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(
                Box.createVerticalStrut(22)
        );

        centerPanel.add(
                footer
        );


        // ==========================================
        // CUSTOMER ACTION
        // ==========================================

        customerButton.addActionListener(e -> {

            new LoginFrame();

            frame.dispose();
        });


        // ==========================================
        // STAFF ACTION
        // ==========================================

        staffButton.addActionListener(e -> {

            new StaffLoginFrame();

            frame.dispose();
        });


        // ==========================================
        // BACKGROUND PANEL
        // ==========================================

        BackgroundPanel backgroundPanel =
                new BackgroundPanel();

        backgroundPanel.setLayout(
                new BorderLayout()
        );


        // ==========================================
        // ADD PANELS
        // ==========================================

        backgroundPanel.add(
                headingPanel,
                BorderLayout.NORTH
        );

        backgroundPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );


        // ==========================================
        // SET CONTENT PANE
        // ==========================================

        frame.setContentPane(
                backgroundPanel
        );


        // ==========================================
        // FRAME SETTINGS
        // ==========================================

        frame.setTitle(
                "Brew & Bliss"
        );

        frame.setExtendedState(
                JFrame.MAXIMIZED_BOTH
        );

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setVisible(
                true
        );
    }


    // ==========================================
    // CREATE ROLE CARD
    // ==========================================

    JPanel createCard(
            String title,
            String line1,
            String line2,
            JButton button,
            Color background,
            Color borderColor,
            Color darkBrown
    ) {

        JPanel card = new JPanel();

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setBackground(
                background
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(
                                borderColor,
                                1
                        ),
                        new EmptyBorder(
                                25,
                                30,
                                25,
                                30
                        )
                )
        );


        // ==========================================
        // CARD TITLE
        // ==========================================

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Maiandra GD",
                        Font.PLAIN,
                        18
                )
        );

        titleLabel.setForeground(
                darkBrown
        );

        titleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // ==========================================
        // FIRST DESCRIPTION
        // ==========================================

        JLabel firstLine =
                new JLabel(line1);

        firstLine.setFont(
                new Font(
                        "Georgia",
                        Font.PLAIN,
                        14
                )
        );

        firstLine.setForeground(
                darkBrown
        );

        firstLine.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // ==========================================
        // SECOND DESCRIPTION
        // ==========================================

        JLabel secondLine =
                new JLabel(line2);

        secondLine.setFont(
                new Font(
                        "Georgia",
                        Font.PLAIN,
                        14
                )
        );

        secondLine.setForeground(
                darkBrown
        );

        secondLine.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // ==========================================
        // BUTTON
        // ==========================================

        button.setFont(
                new Font(
                        "Maiandra GD",
                        Font.PLAIN,
                        14
                )
        );

        button.setForeground(
                darkBrown
        );

        button.setBackground(
                new Color(
                        255,
                        220,
                        230
                )
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(
                                new Color(
                                        235,
                                        180,
                                        195
                                ),
                                1
                        ),
                        new EmptyBorder(
                                8,
                                20,
                                8,
                                20
                        )
                )
        );

        button.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // ==========================================
        // ADD COMPONENTS
        // ==========================================

        card.add(titleLabel);

        card.add(
                Box.createVerticalStrut(18)
        );

        card.add(firstLine);

        card.add(
                Box.createVerticalStrut(7)
        );

        card.add(secondLine);

        card.add(
                Box.createVerticalStrut(22)
        );

        card.add(button);


        return card;
    }


    // ==========================================
    // BACKGROUND PANEL
    // ==========================================

    class BackgroundPanel extends JPanel {

        Image backgroundImage;


        // ==========================================
        // LOAD IMAGE
        // ==========================================

        BackgroundPanel() {

            /*
             * Image is directly inside src
             *
             * src
             *  ├── cafe_background.png
             *  └── textdata
             */

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


        // ==========================================
        // PAINT BACKGROUND
        // ==========================================

        @Override
        protected void paintComponent(
                Graphics g) {

            super.paintComponent(g);

            if (backgroundImage != null) {

                Graphics2D g2 =
                        (Graphics2D) g.create();

                int width =
                        getWidth();

                int height =
                        getHeight();

                g2.drawImage(
                        backgroundImage,
                        0,
                        0,
                        width,
                        height,
                        this
                );

                g2.dispose();

            } else {

                // Backup pink background

                g.setColor(
                        new Color(
                                255,
                                245,
                                248
                        )
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
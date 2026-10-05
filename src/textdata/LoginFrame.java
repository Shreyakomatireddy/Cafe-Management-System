package textdata;

import javax.swing.*;
import java.awt.*;

public class LoginFrame {

    JFrame frame = new JFrame();

    JLabel title =
            new JLabel("Brew & Bliss");

    JLabel coffeeHouse =
            new JLabel("COFFEE HOUSE");

    JLabel welcomeLabel =
            new JLabel("Welcome to Brew & Bliss!");

    JLabel tagline =
            new JLabel(
                    "We love making coffee for a city that loves to drink it."
            );

    JLabel instructionLabel =
            new JLabel(
                    "Please enter your details to explore our menu."
            );

    JLabel nameLabel =
            new JLabel("Customer Name");

    JLabel tableLabel =
            new JLabel("Table Number");

    JLabel mobileLabel =
            new JLabel("Mobile Number");

    JTextField nameField =
            new JTextField();

    JTextField tableField =
            new JTextField();

    JTextField mobileField =
            new JTextField();

    JButton loginButton =
            new JButton("Enter Menu");


    // =================================================
    // CONSTRUCTOR
    // =================================================

    public LoginFrame() {

        // =================================================
        // COLORS
        // =================================================

        Color pinkBackground =
                new Color(255, 245, 248);

        Color darkBrown =
                new Color(80, 55, 55);

        Color softPink =
                new Color(245, 160, 175);


        // =================================================
        // TITLE
        // =================================================

        title.setFont(
                new Font(
                        "Segoe Script",
                        Font.PLAIN,
                        34
                )
        );

        title.setForeground(
                softPink
        );

        title.setAlignmentX(
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
                darkBrown
        );

        coffeeHouse.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // =================================================
        // WELCOME
        // =================================================

        welcomeLabel.setFont(
                new Font(
                        "Georgia",
                        Font.PLAIN,
                        17
                )
        );

        welcomeLabel.setForeground(
                new Color(170, 140, 145)
        );

        welcomeLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // =================================================
        // TAGLINE
        // =================================================

        tagline.setFont(
                new Font(
                        "Century Gothic",
                        Font.ITALIC,
                        13
                )
        );

        tagline.setForeground(
                new Color(195, 175, 180)
        );

        tagline.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // =================================================
        // INSTRUCTION
        // =================================================

        instructionLabel.setFont(
                new Font(
                        "Georgia",
                        Font.PLAIN,
                        13
                )
        );

        instructionLabel.setForeground(
                new Color(175, 155, 160)
        );

        instructionLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // =================================================
        // HEADING PANEL
        // =================================================

        JPanel headingPanel =
                new JPanel();

        headingPanel.setLayout(
                new BoxLayout(
                        headingPanel,
                        BoxLayout.Y_AXIS
                )
        );

        headingPanel.setBackground(
                pinkBackground
        );


        headingPanel.add(
                Box.createVerticalStrut(18)
        );

        headingPanel.add(title);

        headingPanel.add(
                Box.createVerticalStrut(2)
        );

        headingPanel.add(coffeeHouse);

        headingPanel.add(
                Box.createVerticalStrut(15)
        );

        headingPanel.add(welcomeLabel);

        headingPanel.add(
                Box.createVerticalStrut(5)
        );

        headingPanel.add(tagline);

        headingPanel.add(
                Box.createVerticalStrut(5)
        );

        headingPanel.add(instructionLabel);


        // =================================================
        // FEATURE PANEL
        // =================================================

        JPanel featurePanel =
                new JPanel(
                        new GridLayout(
                                1,
                                3,
                                20,
                                0
                        )
                );

        featurePanel.setBackground(
                pinkBackground
        );

        featurePanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        250,
                        10,
                        250
                )
        );


        // =================================================
        // FEATURE CARDS
        // =================================================

        JPanel coffeeCard =
                createCard(
                        "FRESH COFFEE",
                        "Carefully brewed coffee"
                );

        JPanel dessertCard =
                createCard(
                        "SWEET TREATS",
                        "Delicious desserts and snacks"
                );

        JPanel momentCard =
                createCard(
                        "COZY MOMENTS",
                        "Good food, good mood"
                );


        featurePanel.add(
                coffeeCard
        );

        featurePanel.add(
                dessertCard
        );

        featurePanel.add(
                momentCard
        );


        // =================================================
        // QUOTE
        // =================================================

        JLabel quoteLabel =
                new JLabel(
                        "\"A little coffee, a little sweetness, and a lot of bliss.\""
                );

        quoteLabel.setFont(
                new Font(
                        "Georgia",
                        Font.ITALIC,
                        14
                )
        );

        quoteLabel.setForeground(
                new Color(150, 125, 125)
        );

        quoteLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // =================================================
        // CUSTOMER LOGIN TITLE
        // =================================================

        JLabel customerTitle =
                new JLabel("Customer Login");

        customerTitle.setFont(
                new Font(
                        "Georgia",
                        Font.BOLD,
                        22
                )
        );

        customerTitle.setForeground(
                darkBrown
        );

        customerTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // =================================================
        // LABEL FONTS
        // =================================================

        nameLabel.setFont(
                new Font(
                        "Lucida Handwriting",
                        Font.PLAIN,
                        13
                )
        );

        tableLabel.setFont(
                new Font(
                        "Lucida Handwriting",
                        Font.PLAIN,
                        13
                )
        );

        mobileLabel.setFont(
                new Font(
                        "Lucida Handwriting",
                        Font.PLAIN,
                        13
                )
        );


        // =================================================
        // TEXT FIELDS
        // =================================================

        nameField.setPreferredSize(
                new Dimension(
                        220,
                        30
                )
        );

        tableField.setPreferredSize(
                new Dimension(
                        220,
                        30
                )
        );

        mobileField.setPreferredSize(
                new Dimension(
                        220,
                        30
                )
        );

        nameField.setBackground(
                pinkBackground
        );

        tableField.setBackground(
                pinkBackground
        );

        mobileField.setBackground(
                pinkBackground
        );


        // =================================================
        // LOGIN BOX
        // =================================================

        JPanel loginBox =
                new JPanel();

        loginBox.setLayout(
                new BoxLayout(
                        loginBox,
                        BoxLayout.Y_AXIS
                )
        );

        loginBox.setBackground(
                pinkBackground
        );


        loginBox.add(
                customerTitle
        );

        loginBox.add(
                Box.createVerticalStrut(15)
        );


        // =================================================
        // NAME
        // =================================================

        JPanel namePanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                8,
                                0
                        )
                );

        namePanel.setBackground(
                pinkBackground
        );

        namePanel.add(
                nameLabel
        );

        namePanel.add(
                nameField
        );

        loginBox.add(
                namePanel
        );

        loginBox.add(
                Box.createVerticalStrut(7)
        );


        // =================================================
        // TABLE
        // =================================================

        JPanel tablePanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                8,
                                0
                        )
                );

        tablePanel.setBackground(
                pinkBackground
        );

        tablePanel.add(
                tableLabel
        );

        tablePanel.add(
                tableField
        );

        loginBox.add(
                tablePanel
        );

        loginBox.add(
                Box.createVerticalStrut(7)
        );


        // =================================================
        // MOBILE
        // =================================================

        JPanel mobilePanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                8,
                                0
                        )
                );

        mobilePanel.setBackground(
                pinkBackground
        );

        mobilePanel.add(
                mobileLabel
        );

        mobilePanel.add(
                mobileField
        );

        loginBox.add(
                mobilePanel
        );


        // =================================================
        // ENTER MENU BUTTON
        // =================================================

        loginButton.setFont(
                new Font(
                        "Georgia",
                        Font.PLAIN,
                        14
                )
        );

        loginButton.setForeground(
                darkBrown
        );

        loginButton.setBackground(
                new Color(255, 225, 233)
        );

        loginButton.setFocusPainted(
                false
        );

        loginButton.setBorder(
                BorderFactory.createLineBorder(
                        new Color(235, 190, 200),
                        1
                )
        );

        loginButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        loginBox.add(
                Box.createVerticalStrut(12)
        );

        loginBox.add(
                loginButton
        );


        // =================================================
        // CENTER PANEL
        // =================================================

        JPanel centerPanel =
                new JPanel();

        centerPanel.setLayout(
                new BoxLayout(
                        centerPanel,
                        BoxLayout.Y_AXIS
                )
        );

        centerPanel.setBackground(
                pinkBackground
        );


        centerPanel.add(
                featurePanel
        );

        centerPanel.add(
                Box.createVerticalStrut(5)
        );

        centerPanel.add(
                quoteLabel
        );

        centerPanel.add(
                Box.createVerticalStrut(20)
        );

        centerPanel.add(
                loginBox
        );


        // =================================================
        // FOOTER
        // =================================================

        JLabel footer =
                new JLabel(
                        "Brew & Bliss  •  Coffee  •  Desserts  •  Good Moments"
                );

        footer.setFont(
                new Font(
                        "Georgia",
                        Font.ITALIC,
                        12
                )
        );

        footer.setForeground(
                new Color(190, 170, 175)
        );

        footer.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        // =================================================
        // BUTTON ACTION
        // =================================================

        loginButton.addActionListener(e -> {

            String customerName =
                    nameField.getText().trim();

            String tableNumber =
                    tableField.getText().trim();

            String mobileNumber =
                    mobileField.getText().trim();


            // Check empty fields

            if (
                    customerName.isEmpty()
                    ||
                    tableNumber.isEmpty()
                    ||
                    mobileNumber.isEmpty()
            ) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter your name, table number and mobile number."
                );

                return;
            }


            // =================================================
            // OPEN MENU WITH CUSTOMER DETAILS
            // =================================================

            new Frame(
                    customerName,
                    tableNumber,
                    mobileNumber
            );


            // Close Login

            frame.dispose();
        });


        // =================================================
        // FRAME
        // =================================================

        frame.setLayout(
                new BorderLayout()
        );

        frame.getContentPane().setBackground(
                pinkBackground
        );

        frame.add(
                headingPanel,
                BorderLayout.NORTH
        );

        frame.add(
                centerPanel,
                BorderLayout.CENTER
        );

        frame.add(
                footer,
                BorderLayout.SOUTH
        );


        frame.setTitle(
                "Brew & Bliss - Customer Login"
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


    // =================================================
    // CREATE FEATURE CARD
    // =================================================

    JPanel createCard(
            String heading,
            String description
    ) {

        JPanel card =
                new JPanel();

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setBackground(
                new Color(255, 240, 244)
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(240, 205, 215),
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                12,
                                15,
                                12,
                                15
                        )
                )
        );


        JLabel headingLabel =
                new JLabel(
                        heading
                );

        headingLabel.setFont(
                new Font(
                        "Maiandra GD",
                        Font.PLAIN,
                        15
                )
        );

        headingLabel.setForeground(
                new Color(100, 70, 70)
        );

        headingLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel descriptionLabel =
                new JLabel(
                        description
                );

        descriptionLabel.setFont(
                new Font(
                        "Georgia",
                        Font.ITALIC,
                        11
                )
        );

        descriptionLabel.setForeground(
                new Color(170, 145, 150)
        );

        descriptionLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        card.add(
                headingLabel
        );

        card.add(
                Box.createVerticalStrut(5)
        );

        card.add(
                descriptionLabel
        );


        return card;
    }


    // =================================================
    // MAIN
    // =================================================

    public static void main(String[] args) {

        new LoginFrame();

    }
}
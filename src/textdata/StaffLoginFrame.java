package textdata;

import javax.swing.*;
import java.awt.*;

public class StaffLoginFrame {

    JFrame frame = new JFrame();

    JLabel title = new JLabel("Brew & Bliss");
    JLabel coffeeHouse = new JLabel("COFFEE HOUSE");

    JLabel welcomeLabel =
            new JLabel("Welcome back to Brew & Bliss!");

    JLabel tagline =
            new JLabel(
                    "We love making coffee for a city that loves to drink it."
            );

    JLabel instructionLabel =
            new JLabel(
                    "Manage your café with ease and keep the bliss brewing."
            );

    JLabel quoteLabel =
            new JLabel(
                    "\"A little coffee, a little sweetness, and a lot of bliss.\""
            );

    JLabel staffTitle =
            new JLabel("Staff Login");

    JLabel usernameLabel =
            new JLabel("Username");

    JLabel passwordLabel =
            new JLabel("Password");

    JTextField usernameField =
            new JTextField();

    JPasswordField passwordField =
            new JPasswordField();

    JButton loginButton =
            new JButton("Login");


    public StaffLoginFrame() {

        Color pinkBackground =
                new Color(255, 245, 248);

        Color darkBrown =
                new Color(80, 55, 55);

        Color softBrown =
                new Color(150, 125, 125);

        Color softPink =
                new Color(245, 160, 175);


        // =================================================
        // TOP HEADING
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


        // ---------------- BREW & BLISS ----------------

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


        // ---------------- COFFEE HOUSE ----------------

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


        // ---------------- WELCOME ----------------

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


        // ---------------- TAGLINE ----------------

        tagline.setFont(
                new Font(
                        "Georgia",
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


        // ---------------- INSTRUCTION ----------------

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


        headingPanel.add(
                Box.createVerticalStrut(18)
        );

        headingPanel.add(title);

        headingPanel.add(
                Box.createVerticalStrut(3)
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
        // CAFÉ FEATURE CARDS
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


        // ---------------- CARD 1 ----------------

        JPanel coffeeCard =
                createCard(
                        "FRESH COFFEE",
                        "Carefully brewed coffee"
                );


        // ---------------- CARD 2 ----------------

        JPanel dessertCard =
                createCard(
                        "SWEET TREATS",
                        "Delicious desserts & snacks"
                );


        // ---------------- CARD 3 ----------------

        JPanel momentCard =
                createCard(
                        "COZY MOMENTS",
                        "Good food, good mood"
                );


        featurePanel.add(coffeeCard);
        featurePanel.add(dessertCard);
        featurePanel.add(momentCard);


        // =================================================
        // QUOTE
        // =================================================

        quoteLabel.setFont(
                new Font(
                        "Georgia",
                        Font.ITALIC,
                        14
                )
        );

        quoteLabel.setForeground(
                softBrown
        );

        quoteLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // =================================================
        // LOGIN SECTION
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


        // ---------------- STAFF LOGIN ----------------

        staffTitle.setFont(
                new Font(
                        "Georgia",
                        Font.BOLD,
                        22
                )
        );

        staffTitle.setForeground(
                darkBrown
        );

        staffTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        loginBox.add(staffTitle);

        loginBox.add(
                Box.createVerticalStrut(15)
        );


        // ---------------- USERNAME ----------------

        JPanel usernamePanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                8,
                                0
                        )
                );

        usernamePanel.setBackground(
                pinkBackground
        );


        usernameLabel.setFont(
                new Font(
                        "Lucida Handwriting",
                        Font.PLAIN,
                        13
                )
        );


        usernameField.setPreferredSize(
                new Dimension(220, 30)
        );

        usernameField.setBackground(
                pinkBackground
        );


        usernamePanel.add(
                usernameLabel
        );

        usernamePanel.add(
                usernameField
        );


        loginBox.add(
                usernamePanel
        );


        // ---------------- SMALL GAP ----------------

        loginBox.add(
                Box.createVerticalStrut(8)
        );


        // ---------------- PASSWORD ----------------

        JPanel passwordPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                8,
                                0
                        )
                );

        passwordPanel.setBackground(
                pinkBackground
        );


        passwordLabel.setFont(
                new Font(
                        "Lucida Handwriting",
                        Font.PLAIN,
                        13
                )
        );


        passwordField.setPreferredSize(
                new Dimension(220, 30)
        );

        passwordField.setBackground(
                pinkBackground
        );


        passwordPanel.add(
                passwordLabel
        );

        passwordPanel.add(
                passwordField
        );


        loginBox.add(
                passwordPanel
        );


        // =================================================
        // LOGIN BUTTON
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
        // CENTER CONTENT
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
                Box.createVerticalStrut(8)
        );

        centerPanel.add(
                quoteLabel
        );

        centerPanel.add(
                Box.createVerticalStrut(25)
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
        // LOGIN ACTION
        // =================================================

        loginButton.addActionListener(e -> {

            String username =
                    usernameField.getText();

            String password =
                    new String(
                            passwordField.getPassword()
                    );


            if (
                    username.isEmpty()
                    ||
                    password.isEmpty()
            ) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter username and password."
                );

            }

            else if (
                    username.equals("staff")
                    &&
                    password.equals("1234")
            ) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Staff login successful!"
                );

                // Open Staff Dashboard
                new StaffDashboardFrame();

                // Close Staff Login
                frame.dispose();

            }

            else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid username or password."
                );
            }

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
                "Brew & Bliss - Staff Login"
        );

        frame.setExtendedState(
                JFrame.MAXIMIZED_BOTH
        );

        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        frame.setVisible(
                true
        );
    }


    // =================================================
    // METHOD TO CREATE FEATURE CARD
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
}
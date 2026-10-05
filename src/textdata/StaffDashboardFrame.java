package textdata;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StaffDashboardFrame {

    JFrame frame = new JFrame();

    Color pinkBackground = new Color(255, 245, 248);
    Color pink = new Color(245, 160, 175);
    Color darkBrown = new Color(80, 55, 55);
    Color cardBackground = new Color(255, 240, 244);
    Color borderPink = new Color(235, 190, 200);

    JPanel contentPanel;

    CardLayout cardLayout;

    JTextField itemNameField;

    JTextField priceField;

    JComboBox<String> categoryBox;

    DefaultTableModel menuModel;

    JTable menuTable;

    // ================= ORDER TABLE =================

    DefaultTableModel orderModel;

    JTable orderTable;

    public StaffDashboardFrame() {

        frame.setTitle("Brew & Bliss - Staff Panel");

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.setBackground(pinkBackground);

        // ================= HEADER =================

        JPanel headerPanel = new JPanel();

        headerPanel.setLayout(
                new BoxLayout(headerPanel, BoxLayout.Y_AXIS)
        );

        headerPanel.setBackground(pinkBackground);

        JLabel title = new JLabel("Brew & Bliss");

        title.setFont(
                new Font("Segoe Script", Font.PLAIN, 42)
        );

        title.setForeground(pink);

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel coffeeHouse = new JLabel("COFFEE HOUSE");

        coffeeHouse.setFont(
                new Font("Maiandra GD", Font.PLAIN, 15)
        );

        coffeeHouse.setForeground(darkBrown);

        coffeeHouse.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel heading = new JLabel("STAFF PANEL");

        heading.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        heading.setForeground(darkBrown);

        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcome = new JLabel("Welcome, Staff!");

        welcome.setFont(
                new Font("Arial", Font.PLAIN, 18)
        );

        welcome.setForeground(darkBrown);

        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(Box.createVerticalStrut(25));

        headerPanel.add(title);

        headerPanel.add(Box.createVerticalStrut(3));

        headerPanel.add(coffeeHouse);

        headerPanel.add(Box.createVerticalStrut(20));

        headerPanel.add(heading);

        headerPanel.add(Box.createVerticalStrut(8));

        headerPanel.add(welcome);

        headerPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        // ================= NAVIGATION =================

        JPanel navigationPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        20,
                        10
                )
        );

        navigationPanel.setBackground(pinkBackground);

        JButton dashboardButton =
                new JButton("Dashboard");

        JButton manageMenuButton =
                new JButton("Manage Menu");

        JButton viewOrdersButton =
                new JButton("View Orders");

        styleNavigationButton(dashboardButton);

        styleNavigationButton(manageMenuButton);

        styleNavigationButton(viewOrdersButton);

        navigationPanel.add(dashboardButton);

        navigationPanel.add(manageMenuButton);

        navigationPanel.add(viewOrdersButton);

        // ================= CONTENT =================

        cardLayout = new CardLayout();

        contentPanel = new JPanel(cardLayout);

        contentPanel.setBackground(pinkBackground);

        contentPanel.add(
                createDashboardPanel(),
                "DASHBOARD"
        );

        contentPanel.add(
                createMenuPanel(),
                "MENU"
        );

        contentPanel.add(
                createOrdersPanel(),
                "ORDERS"
        );

        // ================= CENTER WRAPPER =================

        JPanel centerWrapper =
                new JPanel(new BorderLayout());

        centerWrapper.setBackground(pinkBackground);

        centerWrapper.add(
                navigationPanel,
                BorderLayout.NORTH
        );

        centerWrapper.add(
                contentPanel,
                BorderLayout.CENTER
        );

        mainPanel.add(
                centerWrapper,
                BorderLayout.CENTER
        );

        // ================= BUTTON ACTIONS =================

        dashboardButton.addActionListener(e -> {

            cardLayout.show(
                    contentPanel,
                    "DASHBOARD"
            );
        });

        manageMenuButton.addActionListener(e -> {

            MenuData.loadItems();

            loadMenuTable();

            cardLayout.show(
                    contentPanel,
                    "MENU"
            );
        });

        // ================= VIEW ORDERS =================

        viewOrdersButton.addActionListener(e -> {

            OrderData.loadOrders();

            loadOrderTable();

            cardLayout.show(
                    contentPanel,
                    "ORDERS"
            );
        });

        // ================= FOOTER =================

        JPanel footerPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER
                        )
                );

        footerPanel.setBackground(
                pinkBackground
        );

        JButton logoutButton =
                new JButton("Logout");

        logoutButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        logoutButton.setForeground(
                darkBrown
        );

        logoutButton.setBackground(
                cardBackground
        );

        logoutButton.setFocusPainted(false);

        logoutButton.setBorder(
                BorderFactory.createLineBorder(
                        borderPink
                )
        );

        logoutButton.setPreferredSize(
                new Dimension(120, 38)
        );

        footerPanel.add(logoutButton);

        logoutButton.addActionListener(e -> {

            new RoleSelectionFrame();

            frame.dispose();
        });

        mainPanel.add(
                footerPanel,
                BorderLayout.SOUTH
        );

        frame.add(mainPanel);

        frame.setVisible(true);
    }

    // =====================================================
    // DASHBOARD PANEL
    // =====================================================

    private JPanel createDashboardPanel() {

        JPanel panel = new JPanel(
                new GridLayout(1, 2, 30, 0)
        );

        panel.setBackground(pinkBackground);

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        180,
                        30,
                        180
                )
        );

        JPanel menuCard = createSimpleCard(
                "MANAGE MENU",
                "Add, delete and view menu items"
        );

        JPanel orderCard = createSimpleCard(
                "VIEW ORDERS",
                "View customer orders and order details"
        );

        panel.add(menuCard);

        panel.add(orderCard);

        return panel;
    }

    // =====================================================
    // MENU PANEL
    // =====================================================

    private JPanel createMenuPanel() {

        JPanel panel = new JPanel(
                new BorderLayout()
        );

        panel.setBackground(pinkBackground);

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        100,
                        20,
                        100
                )
        );

        JLabel menuTitle =
                new JLabel("Manage Menu");

        menuTitle.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        menuTitle.setForeground(
                darkBrown
        );

        menuTitle.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        panel.add(
                menuTitle,
                BorderLayout.NORTH
        );

        // ================= FORM =================

        JPanel formPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        10,
                        15
                )
        );

        formPanel.setBackground(
                pinkBackground
        );

        JLabel nameLabel =
                new JLabel("Item Name:");

        itemNameField =
                new JTextField(12);

        JLabel categoryLabel =
                new JLabel("Category:");

        categoryBox =
                new JComboBox<>(
                        new String[]{
                                "Coffee",
                                "Snacks",
                                "Desserts"
                        }
                );

        JLabel priceLabel =
                new JLabel("Price:");

        priceField =
                new JTextField(8);

        JButton addButton =
                new JButton("Add Item");

        JButton deleteButton =
                new JButton("Delete Item");

        styleButton(addButton);

        styleButton(deleteButton);

        formPanel.add(nameLabel);

        formPanel.add(itemNameField);

        formPanel.add(categoryLabel);

        formPanel.add(categoryBox);

        formPanel.add(priceLabel);

        formPanel.add(priceField);

        formPanel.add(addButton);

        formPanel.add(deleteButton);

        // ================= TABLE =================

        menuModel =
                new DefaultTableModel(
                        new String[]{
                                "Item Name",
                                "Category",
                                "Price"
                        },
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {

                        return false;
                    }
                };

        menuTable =
                new JTable(menuModel);

        menuTable.setRowHeight(28);

        menuTable.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        menuTable.getTableHeader().setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        JScrollPane scrollPane =
                new JScrollPane(menuTable);

        // Load menu from MySQL

        MenuData.loadItems();

        loadMenuTable();

        // ================= ADD ITEM =================

        addButton.addActionListener(e -> {

            String itemName =
                    itemNameField
                            .getText()
                            .trim();

            String category =
                    categoryBox
                            .getSelectedItem()
                            .toString();

            String price =
                    priceField
                            .getText()
                            .trim();

            if (itemName.isEmpty()
                    || price.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter item name and price."
                );

                return;
            }

            try {

                double priceValue =
                        Double.parseDouble(price);

                if (priceValue <= 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Price must be greater than 0."
                    );

                    return;
                }

                // Save item to MySQL

                MenuData.addItem(
                        itemName,
                        category,
                        priceValue
                );

                // Reload table from MySQL

                loadMenuTable();

                itemNameField.setText("");

                priceField.setText("");

                JOptionPane.showMessageDialog(
                        frame,
                        "Item added successfully!"
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a valid price."
                );
            }
        });

        // ================= DELETE ITEM =================

        deleteButton.addActionListener(e -> {

            int selectedRow =
                    menuTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select an item to delete."
                );

                return;
            }

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to delete this item?",
                            "Delete Item",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice ==
                    JOptionPane.YES_OPTION) {

                String itemName =
                        menuModel
                                .getValueAt(
                                        selectedRow,
                                        0
                                )
                                .toString();

                // Delete item from MySQL

                MenuData.deleteItem(
                        itemName
                );

                // Reload table from MySQL

                loadMenuTable();

                JOptionPane.showMessageDialog(
                        frame,
                        "Item deleted successfully!"
                );
            }
        });

        JPanel centerPanel =
                new JPanel(
                        new BorderLayout()
                );

        centerPanel.setBackground(
                pinkBackground
        );

        centerPanel.add(
                formPanel,
                BorderLayout.NORTH
        );

        centerPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        panel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        return panel;
    }

    // =====================================================
    // LOAD MENU TABLE FROM MYSQL
    // =====================================================

    private void loadMenuTable() {

        if (menuModel == null) {

            return;
        }

        // Get latest data from MySQL

        MenuData.loadItems();

        menuModel.setRowCount(0);

        for (MenuData.MenuItem item :
                MenuData.items) {

            menuModel.addRow(
                    new Object[]{
                            item.name,
                            item.category,
                            item.price
                    }
            );
        }
    }

    // =====================================================
    // ORDERS PANEL
    // =====================================================

    private JPanel createOrdersPanel() {

        JPanel panel = new JPanel(
                new BorderLayout()
        );

        panel.setBackground(pinkBackground);

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        100,
                        20,
                        100
                )
        );

        JLabel ordersTitle =
                new JLabel("Customer Orders");

        ordersTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        ordersTitle.setForeground(
                darkBrown
        );

        ordersTitle.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        panel.add(
                ordersTitle,
                BorderLayout.NORTH
        );

        // ================= ORDER TABLE =================

        String[] columns = {

                "Order ID",

                "Customer",

                "Mobile",

                "Table",

                "Items",

                "Total",

                "Status"
        };

        orderModel =
                new DefaultTableModel(
                        columns,
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {

                        return false;
                    }
                };

        orderTable =
                new JTable(orderModel);

        orderTable.setRowHeight(30);

        orderTable.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        orderTable.getTableHeader().setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        JScrollPane scrollPane =
                new JScrollPane(orderTable);

        panel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        JLabel message =
                new JLabel(
                        "Customer orders will appear here.",
                        SwingConstants.CENTER
                );

        message.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        message.setForeground(
                darkBrown
        );

        panel.add(
                message,
                BorderLayout.SOUTH
        );

        return panel;
    }

    // =====================================================
    // LOAD ORDERS FROM MYSQL
    // =====================================================

    private void loadOrderTable() {

        if (orderModel == null) {

            return;
        }

        // Load latest orders from MySQL

        OrderData.loadOrders();

        orderModel.setRowCount(0);

        for (OrderData.Order order :
                OrderData.orders) {

            orderModel.addRow(
                    new Object[]{

                            order.orderId,

                            order.customerName,

                            order.mobileNumber,

                            order.tableNumber,

                            order.items,

                            "₹" + order.total,

                            order.status
                    }
            );
        }
    }

    // =====================================================
    // SIMPLE CARD
    // =====================================================

    private JPanel createSimpleCard(
            String titleText,
            String description) {

        JPanel card = new JPanel();

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setBackground(
                cardBackground
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                borderPink,
                                1
                        ),

                        BorderFactory.createEmptyBorder(
                                25,
                                20,
                                25,
                                20
                        )
                )
        );

        JLabel title =
                new JLabel(titleText);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        title.setForeground(
                darkBrown
        );

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel descriptionLabel =
                new JLabel(description);

        descriptionLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        descriptionLabel.setForeground(
                darkBrown
        );

        descriptionLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        card.add(
                Box.createVerticalGlue()
        );

        card.add(title);

        card.add(
                Box.createVerticalStrut(10)
        );

        card.add(descriptionLabel);

        card.add(
                Box.createVerticalGlue()
        );

        return card;
    }

    // =====================================================
    // NAVIGATION BUTTON STYLE
    // =====================================================

    private void styleNavigationButton(
            JButton button) {

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
                        borderPink,
                        1
                )
        );

        button.setPreferredSize(
                new Dimension(
                        150,
                        38
                )
        );
    }

    // =====================================================
    // NORMAL BUTTON STYLE
    // =====================================================

    private void styleButton(
            JButton button) {

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        button.setForeground(
                darkBrown
        );

        button.setBackground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createLineBorder(
                        borderPink,
                        1
                )
        );
    }
}
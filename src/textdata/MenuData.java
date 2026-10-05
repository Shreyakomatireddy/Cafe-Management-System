package textdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MenuData {

    public static ArrayList<MenuItem> items =
            new ArrayList<>();

    // Load menu items from MySQL
    public static void loadItems() {

        items.clear();

        String query =
                "SELECT item_name, category, price FROM menu";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                String name =
                        rs.getString("item_name");

                String category =
                        rs.getString("category");

                double price =
                        rs.getDouble("price");

                items.add(
                        new MenuItem(
                                name,
                                category,
                                price
                        )
                );
            }

            System.out.println(
                    "Menu loaded successfully!"
            );

        } catch (Exception e) {

            System.out.println(
                    "Failed to load menu!"
            );

            e.printStackTrace();
        }
    }

    // Add new menu item to MySQL
    public static void addItem(
            String name,
            String category,
            double price) {

        String query =
                "INSERT INTO menu (item_name, category, price) VALUES (?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps =
                        con.prepareStatement(query)
        ) {

            ps.setString(1, name);
            ps.setString(2, category);
            ps.setDouble(3, price);

            ps.executeUpdate();

            System.out.println(
                    "Menu item added successfully!"
            );

            // Reload menu after adding
            loadItems();

        } catch (Exception e) {

            System.out.println(
                    "Failed to add menu item!"
            );

            e.printStackTrace();
        }
    }

    // Delete menu item from MySQL
    public static void deleteItem(String name) {

        String query =
                "DELETE FROM menu WHERE item_name = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps =
                        con.prepareStatement(query)
        ) {

            ps.setString(1, name);

            ps.executeUpdate();

            System.out.println(
                    "Menu item deleted successfully!"
            );

            // Reload menu after deleting
            loadItems();

        } catch (Exception e) {

            System.out.println(
                    "Failed to delete menu item!"
            );

            e.printStackTrace();
        }
    }

    public static class MenuItem {

        public String name;
        public String category;
        public double price;

        public MenuItem(
                String name,
                String category,
                double price) {

            this.name = name;
            this.category = category;
            this.price = price;
        }
    }
}
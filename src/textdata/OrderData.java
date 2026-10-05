package textdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderData {

    public static ArrayList<Order> orders =
            new ArrayList<>();

    // =================================================
    // ADD ORDER TO DATABASE
    // =================================================

    public static void addOrder(
            String customerName,
            String tableNumber,
            String mobileNumber,
            String items,
            double total) {

        String query =
                "INSERT INTO orders " +
                "(customer_name, table_number, mobile_number, items, total, status) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps =
                        con.prepareStatement(query)
        ) {

            ps.setString(1, customerName);
            ps.setString(2, tableNumber);
            ps.setString(3, mobileNumber);
            ps.setString(4, items);
            ps.setDouble(5, total);
            ps.setString(6, "Pending");

            ps.executeUpdate();

            System.out.println(
                    "Order saved successfully!"
            );

        } catch (Exception e) {

            System.out.println(
                    "Failed to save order!"
            );

            e.printStackTrace();
        }
    }

    // =================================================
    // LOAD ORDERS FROM DATABASE
    // =================================================

    public static void loadOrders() {

        orders.clear();

        String query =
                "SELECT order_id, customer_name, table_number, " +
                "mobile_number, items, total, status " +
                "FROM orders";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps =
                        con.prepareStatement(query);
                ResultSet rs =
                        ps.executeQuery()
        ) {

            while (rs.next()) {

                int orderId =
                        rs.getInt("order_id");

                String customerName =
                        rs.getString("customer_name");

                String tableNumber =
                        rs.getString("table_number");

                String mobileNumber =
                        rs.getString("mobile_number");

                String items =
                        rs.getString("items");

                double total =
                        rs.getDouble("total");

                String status =
                        rs.getString("status");

                Order order =
                        new Order(
                                orderId,
                                customerName,
                                tableNumber,
                                mobileNumber,
                                items,
                                total,
                                status
                        );

                orders.add(order);
            }

            System.out.println(
                    "Orders loaded successfully!"
            );

        } catch (Exception e) {

            System.out.println(
                    "Failed to load orders!"
            );

            e.printStackTrace();
        }
    }

    // =================================================
    // ORDER CLASS
    // =================================================

    public static class Order {

        public int orderId;
        public String customerName;
        public String tableNumber;
        public String mobileNumber;
        public String items;
        public double total;
        public String status;

        public Order(
                int orderId,
                String customerName,
                String tableNumber,
                String mobileNumber,
                String items,
                double total,
                String status) {

            this.orderId = orderId;
            this.customerName = customerName;
            this.tableNumber = tableNumber;
            this.mobileNumber = mobileNumber;
            this.items = items;
            this.total = total;
            this.status = status;
        }
    }
}
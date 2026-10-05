# Brew & Bliss - Cafe Management System

Brew & Bliss is a Java Swing based Cafe Management System developed using Java.

The application allows customers to browse the cafe menu, add items to their cart, and place orders. Staff can log in to manage menu items and view customer orders.

## How to Run

1. Download or clone this repository.
2. Open **Eclipse IDE**.
3. Go to **File → Import → Existing Projects into Workspace**.
4. Select the downloaded project folder.
5. Open the `textdata` package.
6. Open `Main.java`.
7. Right-click on `Main.java`.
8. Select **Run As → Java Application**.
## Features

### Customer
- Customer login
- Enter customer name, table number and mobile number
- Browse coffee, snacks and desserts
- Add items to cart
- View total bill
- Place orders
- Clear cart
- Return to menu or home

### Staff
- Staff login
- Staff dashboard
- Add menu items
- Delete menu items
- View available menu items
- View customer orders
- Check order details and order status

## Technologies Used

- Java
- Java Swing
- AWT
- ArrayList
- Eclipse IDE

## Project Structure

```text
textdata
├── Main.java
├── RoleSelectionFrame.java
├── LoginFrame.java
├── StaffLoginFrame.java
├── StaffDashboardFrame.java
├── Frame.java
├── CartFrame.java
├── MenuData.java
└── OrderData.java

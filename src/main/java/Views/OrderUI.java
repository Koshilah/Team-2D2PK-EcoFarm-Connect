package Views;

import Models.OrderDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class OrderUI extends JFrame {
    private JTextField orderIdField, customerIdField, produceIdField, quantityField, deliveryDateField, statusField;
    private JButton placeOrderButton, viewOrdersButton, updateStatusButton;
    private JTable table;
    private DefaultTableModel model;

    public OrderUI() {
        setTitle("Order Management");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table
        model = new DefaultTableModel(new String[]{"Order ID", "Produce ID", "Quantity", "Delivery Date", "Status"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(7, 2));
        orderIdField = new JTextField();
        customerIdField = new JTextField();
        produceIdField = new JTextField();
        quantityField = new JTextField();
        deliveryDateField = new JTextField("2025-11-15"); // yyyy-MM-dd
        statusField = new JTextField();

        formPanel.add(new JLabel("Order ID:"));
        formPanel.add(orderIdField);
        formPanel.add(new JLabel("Customer ID:"));
        formPanel.add(customerIdField);
        formPanel.add(new JLabel("Produce ID:"));
        formPanel.add(produceIdField);
        formPanel.add(new JLabel("Quantity:"));
        formPanel.add(quantityField);
        formPanel.add(new JLabel("Delivery Date (yyyy-MM-dd):"));
        formPanel.add(deliveryDateField);
        formPanel.add(new JLabel("Status (for update):"));
        formPanel.add(statusField);

        placeOrderButton = new JButton("Place Order");
        viewOrdersButton = new JButton("View Orders");
        updateStatusButton = new JButton("Update Status");

        formPanel.add(placeOrderButton);
        formPanel.add(viewOrdersButton);
        formPanel.add(updateStatusButton);

        add(formPanel, BorderLayout.SOUTH);

        OrderDAO dao = new OrderDAO();

        // Place Order
        placeOrderButton.addActionListener(e -> {
            boolean success = dao.placePreOrder(
                    orderIdField.getText(),
                    customerIdField.getText(),
                    produceIdField.getText(),
                    Integer.parseInt(quantityField.getText()),
                    LocalDate.parse(deliveryDateField.getText())
            );
            JOptionPane.showMessageDialog(this, success ? "Order placed!" : "Failed to place order.");
        });

        // View Orders
        viewOrdersButton.addActionListener(e -> {
            model.setRowCount(0);
            List<String[]> orders = dao.getCustomerOrders(customerIdField.getText());
            for (String[] row : orders) model.addRow(row);
        });

        // Update Status
        updateStatusButton.addActionListener(e -> {
            boolean success = dao.updateDeliveryStatus(orderIdField.getText(), statusField.getText());
            JOptionPane.showMessageDialog(this, success ? "Status updated!" : "Failed to update status.");
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new OrderUI();
    }
}


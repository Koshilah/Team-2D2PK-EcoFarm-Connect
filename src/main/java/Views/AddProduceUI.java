package Views;

import Models.Produce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProduceUI extends JFrame{
    private JTextField txtProduceId, txtName, txtCategory, txtQuantity, txtHarvestDate, txtPrice;
    private JButton btnRegister;

    public AddProduceUI() {
        setTitle("Register Produce");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel setup
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));

        // Labels and text fields
        panel.add(new JLabel("Produce ID:"));
        txtProduceId = new JTextField();
        panel.add(txtProduceId);

        panel.add(new JLabel("Name:"));
        txtName = new JTextField();
        panel.add(txtName);

        panel.add(new JLabel("Category:"));
        txtCategory = new JTextField();
        panel.add(txtCategory);

        panel.add(new JLabel("Available Quantity:"));
        txtQuantity = new JTextField();
        panel.add(txtQuantity);

        panel.add(new JLabel("Harvest Date (YYYY-MM-DD):"));
        txtHarvestDate = new JTextField();
        panel.add(txtHarvestDate);

        panel.add(new JLabel("Price per Unit:"));
        txtPrice = new JTextField();
        panel.add(txtPrice);

        // Button
        btnRegister = new JButton("Register Produce");
        panel.add(btnRegister);

        // Empty cell for alignment
        panel.add(new JLabel(""));

        add(panel);

        // Button action
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerProduce();
            }
        });
    }

    private void registerProduce() {
        try {
            String produceId = txtProduceId.getText();
            String name = txtName.getText();
            String category = txtCategory.getText();
            int quantity = Integer.parseInt(txtQuantity.getText());
            String harvestDate = txtHarvestDate.getText();
            double price = Double.parseDouble(txtPrice.getText());

            Produce produce = new Produce(produceId, name, category, quantity, harvestDate, price);
            produce.registerProduce();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number format: " + ex.getMessage(),
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AddProduceUI().setVisible(true);
        });
    }
}

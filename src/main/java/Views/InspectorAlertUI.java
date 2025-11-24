package Views;

import javax.swing.*;
import java.awt.*;
import Models.InspectorAlert;

public class InspectorAlertUI extends JFrame {
    private JTextField produceIDField;
    private JTextField inspectorIDField;
    private JTextArea messageArea;
    private JButton sendButton;

    public InspectorAlertUI() {
        setTitle("Send Inspector Alert");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel produceIDLabel = new JLabel("Produce ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(produceIDLabel, gbc);

        produceIDField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(produceIDField, gbc);

        JLabel inspectorIDLabel = new JLabel("Inspector ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(inspectorIDLabel, gbc);

        inspectorIDField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(inspectorIDField, gbc);

        JLabel messageLabel = new JLabel("Message:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(messageLabel, gbc);

        messageArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(scrollPane, gbc);

        sendButton = new JButton("Send Alert");
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(sendButton, gbc);

        sendButton.addActionListener(e -> sendAlert());

        add(panel);
    }

    private void sendAlert() {
        try {
            String produceID = produceIDField.getText();
            String inspectorID = inspectorIDField.getText();
            String message = messageArea.getText();

            InspectorAlert alert = new InspectorAlert(produceID, inspectorID, message);
            alert.sendAlert();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Produce ID must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InspectorAlertUI().setVisible(true));
    }
}

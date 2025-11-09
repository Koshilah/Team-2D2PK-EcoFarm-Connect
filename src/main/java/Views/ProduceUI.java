package Views;

import Models.ProduceDAO;
//4
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ProduceUI extends JFrame {
    private JTable table;
    private JButton loadAvailableButton, searchPreferenceButton;
    private JTextField preferenceField;
    private DefaultTableModel model;

    public ProduceUI() {
        setTitle("Direct-to-Consumer Produce Viewer");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{
                "ID", "Name", "Category", "Quantity", "Harvest Date", "Price"
        }, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        loadAvailableButton = new JButton("Load Available Produce");
        searchPreferenceButton = new JButton("Search by Preference");
        preferenceField = new JTextField(20);
        controlPanel.add(loadAvailableButton);
        controlPanel.add(new JLabel("Preferences (comma):"));
        controlPanel.add(preferenceField);
        controlPanel.add(searchPreferenceButton);
        add(controlPanel, BorderLayout.SOUTH);

        ProduceDAO dao = new ProduceDAO();

        loadAvailableButton.addActionListener(e -> {
            model.setRowCount(0);
            List<String[]> data = dao.getAvailableProduce(LocalDate.now());
            for (String[] row : data) model.addRow(row);
        });

        searchPreferenceButton.addActionListener(e -> {
            model.setRowCount(0);
            List<String> prefs = Arrays.asList(preferenceField.getText().split(","));
            List<String[]> data = dao.searchProduceByPreference(prefs);
            for (String[] row : data) model.addRow(row);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ProduceUI();
    }
}


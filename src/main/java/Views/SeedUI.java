package Views;

import Models.InventoryItems;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeedUI extends JFrame{
    private  JTextPane textPane1;
    public JPanel backPanel;

    public static void main(String[] args) throws SQLException {
        SeedUI ui = new SeedUI();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Inventory Management");
        ui.setSize(600, 600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);

        InventoryItems in = new InventoryItems();
        ResultSet sq = in.viewSeeds();

        StringBuilder builder = new StringBuilder();
        while (sq.next()) {
            builder.append(sq.getString("name")).append(" - ")
                    .append(sq.getString("category")).append("\n");
        }
        ui.textPane1.setText(builder.toString());
    }

}

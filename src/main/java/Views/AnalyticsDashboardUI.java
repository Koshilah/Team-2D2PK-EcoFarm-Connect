package Views;

import Models.AnalyticsDashboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnalyticsDashboardUI extends JFrame {
    private JLabel lblfarmers;
    private JLabel lblcrops;
    private JLabel lblharvestcrops;
    private JLabel lblrevenue;
    private JButton advancedDashboardButton;
    public JPanel backPanel;
    private JLabel pending;
    private JLabel shipped;
    private JLabel delivered;

    public AnalyticsDashboardUI() {
        advancedDashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard ui=new Dashboard();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Register Farmer");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });

        lblfarmers.setText(Integer.toString(AnalyticsDashboard.getFarmerCount()));
        lblcrops.setText(Integer.toString(AnalyticsDashboard.getCropCount()));
        lblharvestcrops.setText(Integer.toString(AnalyticsDashboard.getCropsToHarvestThisMonth()));
        lblrevenue.setText(Double.toString(AnalyticsDashboard.getTotalRevenueThisMonth()));
        pending.setText(Integer.toString(AnalyticsDashboard.getPendingOrders()));
        shipped.setText(Integer.toString(AnalyticsDashboard.getShippedOrders()));
        delivered.setText(Integer.toString(AnalyticsDashboard.getDeliveredOrders()));
    }

    public static void main(String[] args) {
        AnalyticsDashboardUI ui=new AnalyticsDashboardUI();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);

    }
}

package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageProduceANDQuality extends JFrame {
    private JButton alertAnInspectorButton;
    private JButton addProduceButton;
    private JButton qualityReportButton;
    private JButton backToDashboardButton;
    public JPanel backPanel;
    private JButton viewProducesButton;

    public ManageProduceANDQuality() {
        alertAnInspectorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> new InspectorAlertUI().setVisible(true));
            }
        });
        qualityReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QualityCheckpointForm ui=new QualityCheckpointForm();
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Quality Check");
                ui.setSize(600,600);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
        backToDashboardButton.addActionListener(new ActionListener() {
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
        addProduceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    new AddProduceUI().setVisible(true);
                });
            }
        });
        viewProducesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProduceUI();
            }
        });
    }

    public static void main(String[] args) {
        ManageProduceANDQuality ui=new ManageProduceANDQuality();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(600,300);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}

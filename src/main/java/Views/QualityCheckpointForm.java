package Views;

import Models.QualityCheckpoint;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QualityCheckpointForm extends JFrame{

    private JTextField textproduceid;
    private JTextField textckpointname;
    private JComboBox statusbox;
    private JTextField textdate;
    private JButton logQualityCheckInformationButton;
    public JPanel backPanel;

    public QualityCheckpointForm() {
        logQualityCheckInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QualityCheckpoint qCheck =new QualityCheckpoint(textproduceid.getText(),textckpointname.getText(),(String) statusbox.getSelectedItem(),textdate.getText());
                qCheck.logCheckpoint();
            }
        });
    }

    public static void main(String[] args) {
        QualityCheckpointForm ui=new QualityCheckpointForm();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Quality Check");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}

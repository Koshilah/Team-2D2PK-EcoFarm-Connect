package Views;

import Models.Crop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CropForm extends JFrame{
    private JTextField textCrop;
    private JTextField textVeraity;
    private JTextField textPlantingdate;
    private JTextField textHarvestingdate;
    private JButton ADDButton;
    public JPanel backPanel;

    public CropForm() {
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cropName=textCrop.getText();
                String veraity=textVeraity.getText();
                String planingDate=textPlantingdate.getText();
                String harvestingDate=textHarvestingdate.getText();

                Crop crop=new Crop(cropName,veraity,planingDate,harvestingDate);
                crop.insertNewCrop();

            }
        });
    }

    public static void main(String[] args) {
        CropForm ui =new CropForm();
        ui.setContentPane(ui.backPanel);
        ui.setTitle("Register Farmer");
        ui.setSize(600,600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}

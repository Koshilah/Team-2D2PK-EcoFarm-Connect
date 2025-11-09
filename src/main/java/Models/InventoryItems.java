package Models;

import DatabaseLayer.DBConfig;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryItems {
    private String itemId;
    private String name;
    private String category; // e.g., "Seed", "Fertilizer", "Tool", "Equipment"
    private String quantity;
    private String unit; // e.g., "kg", "liters", "units"
    private String farmId;
    private boolean isOrganic;
    private String certification;

    public InventoryItems(String itemId, String name, String category, String quantity, String unit, String farmId, boolean isOrganic, String certification) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
        this.farmId = farmId;
        this.isOrganic = isOrganic;
        this.certification = certification;
    }

    //seeds
    public InventoryItems( String name, String category, String quantity, String unit,String farmId) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
        this.farmId = farmId;
    }

    //fertilizer
    public InventoryItems(String itemId, String name, String category, String quantity, String unit, boolean isOrganic, String farmId) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
        this.isOrganic = isOrganic;
        this.farmId = farmId;
    }

    //tools and equipments
    public InventoryItems(String itemId, String name, String category, String quantity, String unit, String farmId, String certification) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
        this.farmId = farmId;
        this.certification = certification;
    }

    public InventoryItems() {
    }

    public void AddNewSeedInventory(){
        DBConfig db = new DBConfig();
        Connection conn=null;
        String sql="Insert into inventory (name,category,quantity,unit,farm_id) values (?,?,?,?,?)";

        try {
            conn=db.DBConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, category);
            pstmt.setString(3, quantity);
            pstmt.setString(4, unit);
            pstmt.setString(5, farmId);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "New Seed Added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet viewSeeds(){
        DBConfig db=new DBConfig();
        Connection conn=null;
        String sql="SELECT * FROM inventory WHERE category='seeds'";
        ResultSet resultSet=null;

        try{
            conn= db.DBConnection();
            PreparedStatement ptsm= conn.prepareStatement(sql);
            resultSet= ptsm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    public static void main(String[] args) throws SQLException {
        InventoryItems in= new InventoryItems();
        ResultSet sq= in.viewSeeds();

        while (sq.next()){
            System.out.print(sq.getString("name"));
            System.out.println(" "+sq.getString("category"));
        }
    }
}

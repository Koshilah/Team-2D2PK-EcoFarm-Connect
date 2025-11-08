package Models;

import DatabaseLayer.DBConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryItems {
    private String itemId;
    private String name;
    private String category; // e.g., "Seed", "Fertilizer", "Tool", "Equipment"
    private int quantity;
    private String unit; // e.g., "kg", "liters", "units"
    private String farmId;
    private boolean isOrganic;
    private String certification;

    public InventoryItems(String itemId, String name, String category, int quantity, String unit, String farmId, boolean isOrganic, String certification) {
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
    public InventoryItems(String itemId, String name, String category, int quantity, String unit) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
    }

    //fertilizer
    public InventoryItems(String itemId, String name, String category, int quantity, String unit, boolean isOrganic, String farmId) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
        this.isOrganic = isOrganic;
        this.farmId = farmId;
    }

    //tools and equipments
    public InventoryItems(String itemId, String name, String category, int quantity, String unit, String farmId, String certification) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
        this.farmId = farmId;
        this.certification = certification;
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
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    public static void main(String[] args) {

    }
}

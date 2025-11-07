package Models;

import DatabaseLayer.DBConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterFarmer {
    private String farmerFirstName;
    private String farmerLastName;
    private String farmerEmail;
    private String farmerPhone;
    private String farmerAddress;
    private String farmerCity;
    private String specialization;
    private String certificates;

    public RegisterFarmer(String farmerFirstName, String farmerLastName, String farmerEmail, String farmerPhone, String farmerAddress, String farmerCity, String specialization, String certificates) {
        this.farmerFirstName = farmerFirstName;
        this.farmerLastName = farmerLastName;
        this.farmerEmail = farmerEmail;
        this.farmerPhone = farmerPhone;
        this.farmerAddress = farmerAddress;
        this.farmerCity = farmerCity;
        this.specialization = specialization;
        this.certificates = certificates;
    }

    public String getFarmerFirstName() {
        return farmerFirstName;
    }

    public void setFarmerFirstName(String farmerFirstName) {
        this.farmerFirstName = farmerFirstName;
    }

    public String getFarmerLastName() {
        return farmerLastName;
    }

    public void setFarmerLastName(String farmerLastName) {
        this.farmerLastName = farmerLastName;
    }

    public String getFarmerEmail() {
        return farmerEmail;
    }

    public void setFarmerEmail(String farmerEmail) {
        this.farmerEmail = farmerEmail;
    }

    public String getFarmerPhone() {
        return farmerPhone;
    }

    public void setFarmerPhone(String farmerPhone) {
        this.farmerPhone = farmerPhone;
    }

    public String getFarmerAddress() {
        return farmerAddress;
    }

    public void setFarmerAddress(String farmerAddress) {
        this.farmerAddress = farmerAddress;
    }

    public String getFarmerCity() {
        return farmerCity;
    }

    public void setFarmerCity(String farmerCity) {
        this.farmerCity = farmerCity;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }

    public void insertNewFarmer(){
        DBConfig db =new DBConfig();
        String sql = "INSERT INTO farmer (farmerFirstName, farmerLastName, farmerEmail,farmerPhone,farmerAddress,farmerCity,specialization,certificates) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection connection=null;
            connection=db.DBConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, farmerFirstName);
            pstmt.setString(2, farmerLastName);
            pstmt.setString(3, farmerEmail);
            pstmt.setString(4, farmerPhone);
            pstmt.setString(5, farmerAddress);
            pstmt.setString(6, farmerCity);
            pstmt.setString(7, specialization);
            pstmt.setString(8, certificates);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Farmer inserted successfully!");
            }
        }
        catch(SQLException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        RegisterFarmer r1=new RegisterFarmer("Koshila","Himala","test@gmail.com","0715487963","No.123,Galle Rd","Colombo 03","Senior","Degree");
        r1.insertNewFarmer();
    }
}

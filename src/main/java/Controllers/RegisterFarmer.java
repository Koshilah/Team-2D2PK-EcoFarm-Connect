package Controllers;

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
}

package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
    private String houseNo;
    private String street;
    private String area;
    private String landmark;
    private String city;
    private String district;
    private String state;
    private String country;
    private int pinCode;

    // Default Constructor
    public Address() {
    }

    // Parameterized Constructor
    public Address(String houseNo, String street, String area, String landmark,
                   String city, String district, String state,
                   String country, int pinCode) {
        this.houseNo = houseNo;
        this.street = street;
        this.area = area;
        this.landmark = landmark;
        this.city = city;
        this.district = district;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

    // Getters and Setters

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo='" + houseNo + '\'' +
                ", street='" + street + '\'' +
                ", area='" + area + '\'' +
                ", landmark='" + landmark + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}